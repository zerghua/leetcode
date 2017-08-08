package leetcode;

/**
 * Created by Hua on 7/5/2017.



 You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the
 following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59.
 All domains are zero-padded decimal numbers.


 Design a log storage system to implement the following functions:

 void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.

 int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within
 the range from start to end. Start and end all have the same format as timestamp. However, granularity means
 the time level for consideration.

 For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day",
 it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.


 Example 1:

 put(1, "2017:01:01:23:59:59");
 put(2, "2017:01:01:22:59:59");
 put(3, "2016:01:01:00:00:00");
 retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
 retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.

 Note:

 There will be at most 300 operations of Put or Retrieve.
 Year ranges from [2000,2017]. Hour ranges from [00,23].
 Output for Retrieve has no order required.


 */

import java.util.*;
public class N635_DesignLogStorageSystem {
    // Snapchat
    // 63 / 63 test cases passed.
    // 208 ms
    public class LogSystem {
        TreeMap<Long, List<Integer>> map;

        public LogSystem() {
            map = new TreeMap();
        }

        public void put(int id, String timestamp) {
            // parse timestamp to long type
            Long time = Long.parseLong(removeDelimiter(timestamp));

            if(!map.containsKey(time)) map.put(time, new ArrayList());
            map.get(time).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            int index = 0;
            if(gra.equals("Year")) index = 4;
            else if(gra.equals("Month")) index = 6;
            else if(gra.equals("Day")) index = 8;
            else if(gra.equals("Hour")) index = 10;
            else if(gra.equals("Minute")) index = 12;
            else index = 14;

            // parse and handle granularity
            Long start = Long.parseLong(removeDelimiter(s).substring(0, index) + String.join("", Collections.nCopies(14-index,"0")));
            long end = Long.parseLong(removeDelimiter(e).substring(0, index) + String.join("", Collections.nCopies(14-index,"9")));

            // query tree map.
            List<Integer> ret = new ArrayList();
            Map<Long, List<Integer>> retMap = map.subMap(start, true, end, true);
            for(List<Integer> list: retMap.values()) ret.addAll(list);

            return ret;
        }

        private String removeDelimiter(String s){
            return String.join("", s.split(":"));
        }
    }


    // BF
    // 63 / 63 test cases passed.
    // 190 ms
    public class LogSystem2 {

        List<String[]> timestamps = new LinkedList<>();
        List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
        int[] indices = new int[]{4,7,10,13,16,19};

        public void put(int id, String timestamp) { timestamps.add(new String[]{Integer.toString(id), timestamp}); }

        public List<Integer> retrieve(String s, String e, String gra) {
            List<Integer> res = new LinkedList<>();
            int idx = indices[units.indexOf(gra)];
            for (String[] timestamp : timestamps) {
                if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
                        timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) res.add(Integer.parseInt(timestamp[0]));
            }
            return res;
        }
    }
}
