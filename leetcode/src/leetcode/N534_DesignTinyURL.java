package leetcode;

/**
 * Created by Hua on 8/11/2017.


 Note: For the coding companion problem, please see: Encode and Decode TinyURL.

 How would you design a URL shortening service that is similar to TinyURL?

 Background:
 TinyURL is a URL shortening service where you enter a URL such
 as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Requirements:

 For instance, "http://tinyurl.com/4e9iAk" is the tiny url for the page "https://leetcode.com/problems/design-tinyurl".
 The identifier (the highlighted part) can be any string with 6 alphanumeric characters containing 0-9, a-z, A-Z.
 Each shortened URL must be unique; that is, no two different URLs can be shortened to the same URL.

 Note about Questions:
 Below are just a small subset of questions to get you started.
 In real world, there could be many follow ups and questions possible
 and the discussion is open-ended (No one true or correct way to solve a problem).
 If you have more ideas or questions, please ask in Discuss and we may compile it here!

 Questions:

 How many unique identifiers possible? Will you run out of unique URLs?
 Should the identifier be increment or not? Which is easier to design? Pros and cons?
 Mapping an identifier to an URL and its reversal - Does this problem ring a bell to you?
 How do you store the URLs? Does a simple flat file database work?
 What is the bottleneck of the system? Is it read-heavy or write-heavy?
 Estimate the maximum number of URLs a single machine can store.
 Estimate the maximum number of queries per second (QPS) for decoding a shortened URL in a single machine.
 How would you scale the service? For example, a viral link which is shared in social media could result in a peak QPS at a moment's notice.
 How could you handle redundancy? i,e, if a server is down, how could you ensure the service is still operational?
 Keep URLs forever or prune, pros/cons? How we do pruning? (Contributed by @alex_svetkin)
 What API would you provide to a third-party developer? (Contributed by @alex_svetkin)
 If you can enable caching, what would you cache and what's the expiry time? (Contributed by @Humandroid)








 Note: The solution is translated from the Segmentfault post over here. Thanks for liuqi627.
 https://segmentfault.com/a/1190000006140476



 Design TinyURL 设计短网址系统

 九章系统设计 TinyURL笔记
 SN-提问:qps+容量
 AK-画图:流程，可行解
 E-优化:流量/存储

 S场景:

 长到短
 短到长
 N需求(不确定的话先往小里说):
 qps

 日活用户:100M
 每人每天使用：(写)长到短0.1，(读)短到长1
 日request:写10M，读100M
 qps：写100,读1K
 peak qps: 写200,读2K
 (千级别的qps可以单台SSD MySQL搞定)
 存储

 每天新产生10M个长链接<->短链接映射
 每个映射(长链接+短链接)平均大小100B
 每天1GB,1T的硬盘可以用3年
 存储对于这种系统不是问题，netflix这种才有存储上的问题

 通过SN的分析，可以知道要做多大体量的系统，可以感觉到这个系统不是很难，单台电脑配个ssd硬盘，用mysql就可以搞定
 下面开始AK细化流程，画图，给出可行解
 A服务与接口：

 就一个service，URLService.

 Core(Business Logic)层：
 类：URLService
 接口：

 URLService.encode(String long_url)

 URLService.decode(String short_url)

 Web层：
 REST API:

 GET: /{short_url}
 返回一个http redirect response(301)

 POST
 goo.gl做法： POST: https://goo.gl/api/shorten
 bit.ly做法： POST: https://bitly.com/data/shorten
 Request Body: {url=long_url}
 返回OK(200)，data里带着生成的short_url
 K数据存取

 第一步：select 选存储结构 -> 内存 or 文件系统 or 数据库 -> SQL or NoSQL?
 第二步：schema 细化数据表
 第一步：选存储结构

 SQL vs NoSQL?

 是否需要支持Transaction?
 NoSQL不支持Transaction.

 是否需要丰富的SQL Query?
 NoSQL的SQL Query丰富度不如SQL，不过目前差距正在缩小.

 是否追求效率(想偷懒)?
 大多数Web Framework与SQL数据库兼容得很好(自带ORM)，意味着可以少些很多代码.

 是否需要AUTO_INCREMENT ID?
 NoSQL做不到1,2,3,4,5...NoSQL只能做到一个全局unique的Object_id.

 对QPS要求高不高？
 NoSQL性能高，比如Memcached的qps可以到million级别，MondoDB可以到10k级别，MySQL只能在K这个级别.

 对Scalability的要求有多高？
 SQL需要程序员自己写代码来scale; NoSQL这些都是自带的(sharding,replica).

 Mark一下，写到这的时候，收到hr的邮件，由于uberChina和滴滴出行合并，面试推迟，系统设计的学习也要告一段落了，不多说。。

 综上：
 transaction? 不需要 -> nosql
 sql query? 不需要 -> nosql
 是否追求效率？ 本来也没多少代码 -> nosql
 对qps要求高？ 读2k，写200，真心不高 -> sql
 对scalability要求高？ 存储和QPS要求都不高，单机就可以了 -> sql
 要auto_increment_id? 我们的算法要！ -> sql

 ok，那么来聊一聊系统的算法是什么，有如下方案：
 1.hash function:
 把long_url用md5/sha1哈希
 md5把一个string转化成128位二进制数，一般用32位十六进制数(16byte)表示：
 http://site.douban.com/chuan -> c93a360dc7f3eb093ab6e304db516653
 sha1把一个string转化成160位二进制数，一般用40位十六进制数(20byte)表示：
 http://site.douban.com/chuan -> dff85871a72c73c3eae09e39ffe97aea63047094
 这两个算法可以保证哈希值分布很随机，但是冲突是不可避免的，任何一个哈希算法都不可避免有冲突。
 优点：简单，可以根据long_url直接生成；假设一个url中一个char占两个字节，平均长度为30的话，原url占大小60byte,hash之后要16byte。我们可以取md5的前6位,这样就更节省。
 缺点：难以保证哈希算法没有冲突
 解决冲突方案：1.拿(long_url + timestamp)来哈希；2.冲突的话，重试(timestamp会变，会生成新的hash)
 综上，流量不多时，可行；但是，当url超过了假设1 billion的时候，冲突会非常多，效率非常低。

 2.base62:
 将六位的short_url看做是一个62进制数(0-9,a-z,A-Z)，可以表示62^6=570亿个数。整个互联网的网页数在trillion级别，即一万亿这个级别。6位足够。
 每个short_url对应一个十进制整数，这个整数就可以是sql数据库中的自增id，即auto_increment_id。

 public class URLService {
 HashMap<String, Integer> ltos;
 HashMap<Integer, String> stol;
 static int COUNTER;
 String elements;
 URLService() {
 ltos = new HashMap<String, Integer>();
 stol = new HashMap<Integer, String>();
 COUNTER = 1;
 elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 }
 public String longToShort(String url) {
 String shorturl = base10ToBase62(COUNTER);
 ltos.put(url, COUNTER);
 stol.put(COUNTER, url);
 COUNTER++;
 return "http://tiny.url/" + shorturl;
 }
 public String shortToLong(String url) {
 url = url.substring("http://tiny.url/".length());
 int n = base62ToBase10(url);
 return stol.get(n);
 }

 public int base62ToBase10(String s) {
 int n = 0;
 for (int i = 0; i < s.length(); i++) {
 n = n * 62 + convert(s.charAt(i));
 }
 return n;

 }
 public int convert(char c) {
 if (c >= '0' && c <= '9')
 return c - '0';
 if (c >= 'a' && c <= 'z') {
 return c - 'a' + 10;
 }
 if (c >= 'A' && c <= 'Z') {
 return c - 'A' + 36;
 }
 return -1;
 }
 public String base10ToBase62(int n) {
 StringBuilder sb = new StringBuilder();
 while (n != 0) {
 sb.insert(0, elements.charAt(n % 62));
 n /= 62;
 }
 while (sb.length() != 6) {
 sb.insert(0, '0');
 }
 return sb.toString();
 }
 }

 第二步：schema 细化数据表

 一个表:两列(id,long_url),其中id为主键(自带index)，long_url将其index,这样一张表可以双向查！

 到现在有了work solution!可以达到weak hire。
 基本的系统架构是:
 浏览器 <-> Web <-> Core <-> DB
 E优化
 如何提高响应速度？
 提高web server和数据库之间的响应速度

 读:利用Memcached提高响应速度,get的时候先去cache找，没有就从数据库里找；可以把90%的读请求都引流到cache上
 提高web server和用户浏览器之间的响应速度（利用地理位置信息提速）

 不同地区，使用不同的Web服务器和缓存服务器，所有地区share一个db，用于缓存没hit的情况
 通过动态DNS解析可以把不同地区的用户match到最近的Web服务器
 假如一台MySQL 存不下/忙不过 了怎么办？

 面临问题：
 Cache资源不够
 写操作越来越多
 越来越多的cache miss率
 怎么做：
 拆数据库。
 拆数据库有两种，一种是把不同的表放到不同的机器(vertical sharding)，另一种是把数据散列到不同的机器(horizontal)。
 最好用的是horizontal sharding。
 当前的表结构是:(id, long_url)，既需要用id查long_url，也需要用long_url查id，如何分，把哪列作为sharding key呢？
 一个简单可行的办法是，按id取模sharding，因为读(短到长)的需求是主要的；写的时候就广播给所有机器，由于机器不会太多，也是可行的。
 此时一个新的问题来了，n台机器如何共享一个全局自增id?
 两个办法：开一台新的机器专门维护这个全局自增id，或者用zookeeper。都不好。
 所以我们不用全局自增id。
 业内的做法是，把sharding key作为第一位直接放到short_url里。这样就不需要全局自增id,每台机器自增就好了。
 用consistent hashing将环分为62份(这个无所谓，因为预估机器不会超过这个数目，也可以设成360或者别的数，每次新加一个机器可以把区间最大的分一半)每个机器在环上负责一段区间。
 具体做法：
 新来一个long_url -> hash(long_url)%62 -> 把long_url放到hash value对应的机器里 -> 在这台机器上生成short_url -> 返回short_url
 来一个short_url请求 -> 提取short_url的第一位得到sharding key -> 到sharding key对应的机器里找 -> 返回long_url
 新增一台机器 -> 找原来机器里负责range(0-61)最大的机器 -> 将其range减半 -> 把一半放到新增机器上
 继续优化？

 中国的db放到中国，美国的db放到美国。
 用地域信息作为sharding key，比如中国网站都放到0开头的，美国网站都放在1开头的。
 加一个新功能custom url怎么做？

 单独建一张表，存custom_url <--> long_url
 当查询时，先从custom表里查，再从url表里查。
 注意，千万不要在url表里插一列custom，这样这列大部分的值为空。



 Question Description

 Over here
 S: Scenario

 Long URL to short URL and reversed.
 N: Need (Assume the system is not massive if you are not sure)
 QPS (queries per second)

 Daily User: 100M
 Daily usage per person: (Write) long2short 0.1, (Read) short2long 1
 Daily request: Write 10M, Read 100M
 QPS: Since a day is 864000s approximately 100K.

 Write 100, Read 1K

 Peak QPS: Write 200, Read 2K

 (Thousand level can be handled by a single SSD MySQL Machine)
 Storage

 10M new mappings (long URL to short URL) per day
 assume each mapping takes 100B in average
 1GB every day. 1 TB hard drive could stand for 3 years.

 Storage is not the problem for this kind of system. Service like Netflix may have storage issues.

 Through SN analysis, we could have a big picture of the system. In general, this system is not hard and could be handled by a single SSD Machine.
 A: API

 Only one service: URLService

 Core (Business Logic) Layer:
 Class: URLService
 Interface:
 URLService.encode(String long_url)
 URLService.decode(String short_url)
 Web Layer:
 REST API:
 GET: /{short_url}, return a http redirect response(301)
 POST: goo.gl method - google shorten URL

 Request Body: {url=longUrl} e.g. {"longUrl": "http://www.google.com/"}
 Return OK(200), short_url is included in the data
 K: Data Access
 Step 1: Pick a storage structure
 SQL vs NoSQL?

 Does it need to support transactions? NoSQL does not support transaction.
 Do we need rich SQL query? NoSQL does not support as many queries as SQL.
 Pursue development efficiency? Most Web Framework supports SQL database very well (with ORM). It means fewer codes for the system.
 Do we need to use AUTO_INCREMENT ID? NoSQL couldn't do this. It only has a global unique Object_id.
 Does the system has a high requirement for QPS? NoSQL has high performance. For example, Memcached's QPS could reach million level, MondoDB does 10K level, MySQL only supports K level.
 How high is the system's scalability? SQL requires developers write their codes to scale, while NoSQL comes with them (sharding, replica).

 Answer:

 No -> NoSQL
 No -> NoSQL
 Doesn't matter because there are only a few codes. -> NoSQL
 Our algorithm needs AUTO_INCREMENT ID. -> SQL
 Write 200, Read 2K. Not high. -> SQL
 Not high. -> SQL

 System Algorithm

 OK, let's talk about the system algorithm. There are following solutions:

 Hash function:

 long_url -> md5/sha1
 md5 convert a string into 128 binary bits, generally represented as 16 bytes hex:

 http://site.douban.com/chuan -> c93a360dc7f3eb093ab6e304db516653
 sha1 convert a string into 160 binary bits, generally represented as 20 bytes hex:

 http://site.douban.com/chuan -> dff85871a72c73c3eae09e39ffe97aea63047094

 These two algorithms could make sure hash values are randomly distributed, but the conflicts are inevitable. Any hash algorithm could have inevitable conflicts.

 Pros: Simple. We could take the first 6 chars of the converted string.

 Cons: Conflicts.

 Solutions: 1. use (long_url + timestamp) as the hash function key. 2. When conflicts, regenerates the hash value(it's different because timestamp changes).

 Overall, when urls are over 1 billion, there would be a lot of conflicts and the efficiency could be very low.

 base62
 Take short_url as a 62 base notation. 6 bits could represent 62^6=57 billion.

 Each short_url represent a decimal digit. It could be the auto_increment_id in SQL database.

 public class URLService {
 HashMap<String, Integer> ltos;
 HashMap<Integer, String> stol;
 static int COUNTER;
 String elements;
 URLService() {
 ltos = new HashMap<String, Integer>();
 stol = new HashMap<Integer, String>();
 COUNTER = 1;
 elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
 }
 public String longToShort(String url) {
 String shorturl = base10ToBase62(COUNTER);
 ltos.put(url, COUNTER);
 stol.put(COUNTER, url);
 COUNTER++;
 return "http://tiny.url/" + shorturl;
 }
 public String shortToLong(String url) {
 url = url.substring("http://tiny.url/".length());
 int n = base62ToBase10(url);
 return stol.get(n);
 }

 public int base62ToBase10(String s) {
 int n = 0;
 for (int i = 0; i < s.length(); i++) {
 n = n * 62 + convert(s.charAt(i));
 }
 return n;

 }
 public int convert(char c) {
 if (c >= '0' && c <= '9')
 return c - '0';
 if (c >= 'a' && c <= 'z') {
 return c - 'a' + 10;
 }
 if (c >= 'A' && c <= 'Z') {
 return c - 'A' + 36;
 }
 return -1;
 }
 public String base10ToBase62(int n) {
 StringBuilder sb = new StringBuilder();
 while (n != 0) {
 sb.insert(0, elements.charAt(n % 62));
 n /= 62;
 }
 while (sb.length() != 6) {
 sb.insert(0, '0');
 }
 return sb.toString();
 }
 }

 Step 2: Database Schema

 One table (id, long_url). id is the primary key, ordered by long_url

 The basic system architecture:

 Browser <-> Web <-> Core <-> DB
 O: optimize
 How to improve the response speed?
 Improve the response speed between web server and database

 Use Memcached to improve response speed. When getting long_url, search in the cache first, then database. We could put 90% read request on the cache.
 Improve the response speed between web server and user's browser

 Different locations use different web server and cache server. All the areas share a DB used to match the users to the closest web server (through DNS) when they have a miss on the cache.
 What if we need one more MySQL machine?
 Issues:

 running out of cache
 More and more write requests
 More and more cache misses

 Solutions:

 Database Partitioning

 Vertical sharding 2. Horizontal sharding

 The best way is horizontal sharding.

 Currently table structure is (id, long_url). So, which column should be sharding key?

 An easy way is id modulo sharding.

 Here comes another question: How could multiple machines share a global auto_increment_id?

 Two ways: 1. use one more machine to maintain the id. 2. use zookeeper. Both suck.

 So, we do not use global auto_increment_id.

 The pro way is put the sharding key as the first byte of the short_url.

 Another way is to use consistent hashing to break the cycle into 62 pieces. It doesn't matter how many pieces because there probably would not be over 62 machines (it could be 360 or whatever). Each machine is responsible for the service in the part of the cycle.

 write long_url -> hash(long_url)%62 -> put long_url to the specific machine according to hash value -> generate short_url on this machine -> return short_url

 short_url request -> get the sharding key (first byte of the short_url) -> search in the corresponding machine based on sharding key -> return long_url

 Each time we add a new machine, put half of the range of the most used machine to the new machine.
 More Optimization

 Put Chinese DB in China, American DB in the United States. Use geographical information as the sharding key, e.g. 0 for Chinese websites, 1 for American websites.




 */
public class N534_DesignTinyURL {
}
