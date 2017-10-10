package leetcode;

import java.util.*;

/**
 * Created by Hua on 11/30/2016.


 design parking lot, assume there are 3 types of car and spaces.(regular, compact, handicap)

 */
public class summary_OODesign {
    enum CarType{regular, compact, handicap}

    public class Car{
        int license;
        CarType type;
    }

    public class ParkingSpace{
        int number;
        boolean isEmpty;
        Car car;
        CarType type;

        // constructor
        ParkingSpace(int num, CarType type){
            this.number = num;
            this.type = type;
            this.isEmpty = true;
            this.car = null;
        }
    }


    public class ParkingLot{
        // variables
        int numTotalParkingSpaces;
        int numParkedSpaces;
        List<ParkingSpace> spaces;

        // constructor
        ParkingLot(){
            this.numTotalParkingSpaces = 50;
            this.numParkedSpaces = 0;
            int handicapSpace = 5, compact=15, regular = 30;
            this.spaces = new ArrayList();
            int seq = 1;
            for(int i=0;i<handicapSpace;i++) this.spaces.add(new ParkingSpace(seq++, CarType.handicap));
            for(int i=0;i<compact;i++) this.spaces.add(new ParkingSpace(seq++, CarType.compact));
            for(int i=0;i<regular;i++) this.spaces.add(new ParkingSpace(seq++, CarType.regular));
        }


        // method
        // assume the type must match to park
        public boolean parkCar(Car car){
            if(this.isFull()) return false; // cant' park because it's full

            for(ParkingSpace e : spaces){
                if(e.isEmpty && e.type == car.type){
                    e.isEmpty = false;
                    e.car = car;
                    numParkedSpaces++;
                    return true;
                }
            }
            return false; // can't park because no type match
        }

        // o(n) time, can be o(1) with extra space with hashmap.
        public boolean exitCar(Car car){
            for(ParkingSpace e : spaces){
                if(!e.isEmpty && e.car.equals(car)){
                    numParkedSpaces--;
                    e.isEmpty = true;
                    e.car = null;
                    return true;
                }
            }
            return false; //no such car
        }

        public boolean isFull(){
            return numParkedSpaces == numTotalParkingSpaces;
        }

    }

    // the operation of exitCar can be improved by using hashmap
    // the operation of parkCar can be improved by separate counting of each type of car.








    // ************************************************************************************* //
    // Design Elevator, assume only one elevator.
    public enum Status {up, down, standby, maintainance}

    public class Elevator{
        Status status;
        int capacity;
        int currentCapacity;
        int currentFloor;

        // method
        void openDoor(){}
        void closeDoor(){}
        void moveUp(){}
        void moveDown(){}



    }






}



/*









eBay
题：
1. 统计01数组中0和1的数量
2. merge two sorted lists
3. find if a tree is balanced or not
4. evaluate an expression. e.g. a+b*(c-e/f) (注意不是 leetcode上那道，我同学写的答案是用两个stack分别存数字和操作符，保持栈顶元素优先级最大。写了小100行代码吧……电面20分钟让我做这个我没刷过水平不济自认倒霉_(:з」∠)_）
5. pow(a,b)，要求logn
6. anagrams， Find if given string is composed of the same charecters in second string。.

eBay是组与组之间独立面试的，一个跪了还可以申别的，一般情况下没有 onsite，电面过后 Skpye 过了就给 offer了。.
我对eBay整个面试体验非常不好。
首先面试官全是老印，电面我实在听不清他们讲的题啊……第一组还让我把代码念给她听，问题非常 aggressive。其次有的 HR 非常 lame……比如我第一个组虽然我知道我面的不好，你也不用过一两个月才给我拒信吧，谁理你- -第二个面试官也感觉很二逼……我当时面完第二天就飞去西雅图面 Amazon了，下飞机发现一个语音留言是昨天的面试官发现打不通说待会儿再打。然后我就回邮件问怎么了，结果他说我打错了我是在找其他的 candidate……你在逗我？？？然后前两天 HR 给我发信说某一个组要找我 skype 面，但我明确记得我被那个组拒了，而且当时已经拿了 Amazon 了就没理。然后系统又给我发了遍拒信！然后 HR 又跟我 follow up 说你怎么没回信呀我们想面你。我一看 HR这么好就跟他说不去了，他也很有礼貌的回信 wish me best luck。对 eBay 的唯一好印象只有这个 HR 了……
总之整体感觉就是管理混乱……





Houzz
题：
1. two sum, 电面用 hashset，onstie 又考了一遍用两种方法做.
2. 分解质因数
3. shift array (shifts an array by N number of steps. E.g. [0,1,2,3,4] shiftArray(arr, 3) -> [2,3,4,0,1])
4. search in rotated array
5. valid BST. 我刚说完思路面试官就说我知道是对的你不用写代码了⊙▽⊙
6. database design + SQL
7. fib, 非要让我不用 temp 和不能多用两个数……
8. edit distance，本来想背dp答案的，结果没等我开口给我简化了并让我用 recursion 写
9. 前端基础
我之前不知道这公司是同学给我发家具链接我顺便去投的，去了后发现公司文化神马的貌似相当不错啊，地点在 stanford 旁边，办公室清新，员工除了刁难我（其实是我太次）的中国猥琐男之外也都很 neat 很 smart 很 friendly 的感觉。HR 是 MIT CS 毕业的各种FLGT都去腻了然后跑来转 HR 了……员工各种 Stanford 各种 FLG……中午吃饭给某个员工庆祝生日还分了点蛋糕吃，中午吃饭跟人聊天感觉也都很不错。HR 还带我看了他们被 forbes 评为 N 大 hot start-up 跟 dropbox CEO 合影之类的封面。.

后来我跟 HR 说我面的好烂之后 HR 告诉我其实他们也不怎么招 new grad，是今年突然想要招所以试试的，只要很厉害的人……除了安慰我之外其实也是实情，他家从电面到 onsite 算是我面过最难的了。没写在例题之外其实还问了挺多不那么基础的基础知识的，我都答成狗了……
总之能去的话是很不错的公司，各位巨巨可以试试……



Evernote
题：.
1. coding challenge. 统计字符串中 word frequency 并排序，要求 O（n）.HR 给发的，要点是注释要写好。
2. 各种数据结构知识(array, linkedlist, map, set, tree），从电面到 onstie 问了 N 遍，想去的话请认真温习。
3. isPalindrome （iterative 和 recursion，rec 是写完前者之后面试官追加的）
4. 给定一个array，返回一个array，每个元素是input里除了对应元素之外别的所有的乘积。
5. 用户吐槽服务变慢，如何解决.
6. 大文件 sort (external merge sort）不用写，讲思路
7. latest common ansestor，单向，给root和targets
8. implement set
9. design card game 这题我根本没听懂，面完就被赶出去了
coding challenge + 两轮 Skype + onstie。
总体面试感受非常好，清爽明快，没有奇怪的题，问的也挺全面。办公室小清新。面试流程非常快，HR 说你想快我们可以2周搞定所有流程。



Yelp
题：
1. generate random graph (int nEdges, int nNodes)，返回形式随意
2. 给你个 list 每条（用户，url），求top 10 url。
3. 给个矩阵，求任意给定子矩阵所有元素和。面试官 CMU 小哥，我说了 naive 写法，小哥直接提示说我要用很多次，你写 DP吧。
4. conway game 的一部分，给了矩阵和一些规则，求每应用一次规则矩阵上元素的死活。manager 问的，写的比较抽象就行了。
5. 给一个文档集合 String[][] file，设计index(),search()，前者可以很慢的初始化，后者尽量快的返回所有文档中除了 target 之外的其他元素。比如 String[][]file = {{“a”, “b”, “c”}, {“g”,”r”,”c”}, {“p”,”q”}}， search(c) = {{“a”,”b”},{“g”,”r”}}.
他家投了半天没反应，但有反应之后就非常快。办公室有点破，但人都挺酷的，我还跟面试官聊了聊刺客信条……他家也不会面到一半赶人，其实是我面过所有算法 onsite 里唯一一个题全答出来的了_(:з」∠)_虽然是在弃疗之后才去的_(:з」∠)_感觉题都比较合理。












OO设计问题是电面或者onsite中常考的问题，尤其对以Java为主要开发语言的公司（比如Amazon），OO设计问题可以算必考。OO设计题目的特点是题目非常开放，比如用OO的思想设计一个停车场，或者电梯等，没有固定的答案和套路。对于面试者，尤其是编程经验有限的毕业生，如何回答好这类问题确实是非常大的挑战。那么本篇就以设计电梯为例讲解一下回答这类问题的思路、以及需要注意的细节。


面试官：（经过若干客套）能否用设计关于一个电梯的class，合理的设计其方法和内部成员？


准确理解面试问题是成功面试的第一步，对于OO设计问题更是如此。由于题目的需求相对模糊，面试者需要通过不断的沟通和交流来确定题目中可能被遗漏的细节，从而明确需要实现的步骤和细节。


『设计电梯类』，每个人对于电梯都有一个具体的认知，但面试者自己的理解是否就和面试官一致呢？避免想当然的去假设，多问问题，明确细节，比如：


    电梯的容量（载重，载入数）是否考虑？
    电梯的运行范围是几层到几层？
    是一部电梯还是多个电梯？



当我们相对了解题目的具体需求之后，设计电梯类时要从OO设计基本原则入手，比如封装性，本质上就是讲class内部的状态封装在内，对外提供合理的方法接口。


从方法的角度思考相对直观：根据题目的需求，一个基本的电梯类应该提供什么样的方法呢？


    开门、关门
    移动到下一目标楼层
    接受去目标楼层的请求



以上都是最直观、最基本的方法，相对应的就是电梯内部的基本状态：


    电梯门的开关状态 （开关门会影响该状态）

    运行方向（移动会影响该状态，该状态也影响下一步行动）；
    当前楼层 （移动会影响该状态，该状态也影响下一步行动）
    需要停的楼层集合（接受去某楼层的请求会影响该状态，该状态影响下一步行动）；



如果在细一点，还可以加入『当前载重』，『当前载人数』等，可以使内部的实现更加合理。如果面试官设计的基本方法和内部状态设计没有异议，面试者一般还需要简单的实现一两个重要的方法，在本题中『移动到下一目标楼层』方法，目的在于看面试者是否有能力将接口和内部对象状态封装好。


包子Tips: 面试中很多同学喜欢临时添加变量，比如一开始没有考虑到电梯门的状态，结果到了需要实现开门、关门的方法的时候只能临时补。这样一来容易出错，二来会给面试官留下不好的印象。我们建议同学们在答题之前，最好花一点时间，把需要设计的方法、用到的内部状态想清楚，然后再深入做题，尽量做到思路清晰、连贯。


面向对象的另两个重要特性是继承和多态。设计电梯这个题目可能并不是特别适合考察这两方面，但是OO设计的思路是大概相似的：分析每一个类的外部方法和内部状态是什么，什么样的方法可以抽象成通用的接口，什么样的类之间存在继承关系等。作为一个思考的问题，大家不妨动手做一做『如何设计停车场』这个题目，欢迎留言讨论。






First there is an elevator class. It has a direction (up, down, stand, maintenance), a current floor and a list of floor requests sorted in the direction. It receives request from this elevator.

Then there is a bank. It contains the elevators and receives the requests from the floors. These are scheduled to all active elevators (not in maintenance).

The scheduling will be like:

    if available pick a standing elevator for this floor.
    else pick an elevator moving to this floor.
    else pick a standing elevator on an other floor.
    else pick the elevator with the lowest load.

Each elevator has a set of states.

    Maintenance: the elevator does not react to external signals (only to its own signals).
    Stand: the elevator is fixed on a floor. If it receives a call. And the elevator is on that floor, the doors open. If it is on another floor, it moves in that direction.
    Up: the elevator moves up. Each time it reaches a floor, it checks if it needs to stop. If so it stops and opens the doors. It waits for a certain amount of time and closes the door (unless someting is moving through them. Then it removes the floor from the request list and checks if there is another request. If so the elevator starts moving again. If not it enters the state stand.
    Down: like up but in reverse direction.

There are additional signals:

    alarm. The elevator stops. And if it is on a floor, the doors open, the request list is cleared, the requests moved back to the bank.
    door open. Opens the doors if an elevator is on a floor and not moving.
    door closes. Closed the door if they are open.

EDIT: Some elevators don't start at bottom/first_floor esp. in case of skyscrapers.

min_floor & max_floor are two additional attributes for Elevator.






elevator:
First ask the interviewer what kind of elevator?  there is only one elevator serving that building or multiple elevators serving the building simultaneously?
this situation is that: there is one elevator serving the building.  there are many floors in the buliding. Maybe there are some users in different floor pressing the button simultaneously. This results in some requests to RequestProcessCenter for processing. The  RequestProcessCenter figure out the first request that need to be processed in such an algorithm that the distance between target floor and current floor is shortest.

First describe the whole situation. and check it with your interviewer;
Second sketch out the main classes and methods on the whiteboard;
So we need the following classes:


public class User {
    private name;
    public pressButton(int toFloor) {
        Request req = new Request(toFloor);
        RequestProcessCenter  center = RequestProcessCenter.getInstance();
        center.addRequest(req);
    }
}

public class Request {
    private int toFloor;
    public Request(int _toFloor) {
        toFloor = _toFloor;
    }
    public getToFloor() {
        return toFloor;
    }
}

public class Elevator {
    public static Elevator instance = null;
    private int currentFloor;
    public static Elevator( ) {
        if (instance == null) {  // late loading and eager loading
            // connection pool
            synchronized (Elevator.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }

    public getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }
    public getCurrentFloor() {
        return currentFloor;
    }
    public moveToTargetFloor(int toFloor) {
        currentFloor = toFloor;
    }
    public void moveUp();
    public void moveDown();
}

public RequestProcessCenter implements runnable {
    public LinkedList<Request> queue;
    public RequestProcessCenter( ) {
        queue = new LinkedList<Request>( );
    }
    public void run() {
        while ( true ) {
            processRequest( )
        }
    }

    public void addRequest(Request request) {
        queue.add(request);
    }
    public void removeRequest(Request request) {
        queue.remove(request);
    }
    public Request getNextRequest( ) {
        Request shortestReq = null;
        int shortest = Integer.MAX_VALUE;
        int curFloor = Elevator.getInstance( ).getCurrentFloor( );
        for (Request item : queue) {
            int distance = Math.abs(curFloor - item.getToFloor( ) );
            if (distance < shortest) {
                shortest = distance;
                shortestReq = item;
            }
        }
        return shortestReq;
    }
    public void processRequest( ) {
        Request req = getNextRequest( );
        if (req != null) {
                int toFloor = req.getToFloor( );
                Elevator.getInstance.moveToTargetFloor( toFloor);
                queue.remove(req);
        }

    }
}















public class Elevator {
	private float location = 0;
	private Direction direction = Direction.UP;
	private State state = State.STOPPED;
	private Door door = Door.CLOSED;
	private Thread processingThread;
	private Thread listeningThread;

	public class Request {
		public long time;
		public Integer floor;
		public Direction direction;

		public Request(long time, Integer floor, Direction direction) {
			this.time = time;
			this.floor = floor;
			this.direction = direction;
		}
	}

	public enum Direction {
		UP, DOWN
	}

	public enum State {
		MOVING, STOPPED
	}

	public enum Door {
		OPEN, CLOSED
	}

	public Comparator<Request> upComparator = new Comparator<Request>() {
		public int compare(Request u1, Request u2) {
			return u1.floor.compareTo(u2.floor);
		}
	};

	public Comparator<Request> downComparator = upComparator.reversed();

	private Queue<Request> upQueue = new PriorityQueue<>(upComparator);
	private Queue<Request> currentQueue = upQueue;
	private Queue<Request> downQueue = new PriorityQueue<>(downComparator);

	public void call(int floor, Direction direction) {
		if (direction == Direction.UP) {
			if (floor >= location) {
				currentQueue.add(new Request(System.currentTimeMillis(), floor,
						direction));
			} else {
				upQueue.add(new Request(System.currentTimeMillis(), floor,
						direction));
			}
		} else {
			if (floor <= location) {
				currentQueue.add(new Request(System.currentTimeMillis(), floor,
						direction));
			} else {
				downQueue.add(new Request(System.currentTimeMillis(), floor,
						direction));
			}
		}
	}

	public void go(int floor) {
		call(floor, direction);
	}

	public void process() {
		while (true) {
			if (!upQueue.isEmpty() && !downQueue.isEmpty()) {
				Request r = currentQueue.poll();
				if (r != null) {
					goToFloor(r.floor);
				} else {
					preProcessNextQueue();
				}
			}
		}
	}

	public void goToFloor(int floor) {
		state = State.MOVING;
		for (float i = location; i <= floor; i = (float) (i + 0.1)) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		location = floor;
		door = Door.OPEN;
		state = State.STOPPED;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		door = Door.CLOSED;
	}

	private void preProcessNextQueue() {
		if (getLowestTimeUpQueue() > getLowestTimeDownQueue()) {
			this.direction = Direction.UP;
			currentQueue = upQueue;
			upQueue = new PriorityQueue<>(upComparator);
		} else {
			this.direction = Direction.DOWN;
			currentQueue = downQueue;
			downQueue = new PriorityQueue<>(downComparator);
		}
	}

	private long getLowestTimeUpQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : upQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}

	private long getLowestTimeDownQueue() {
		long lowest = Long.MAX_VALUE;
		for (Request r : downQueue) {
			if (r.time < lowest)
				lowest = r.time;
		}
		return lowest;
	}

	public class Process implements Runnable {
		@Override
		public void run() {
			process();
		}
	}

	public class Listen implements Runnable {
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(90000);
				while (true) {
					Socket socket = serverSocket.accept();
					Thread thread = new Thread(new Worker(socket));
					thread.start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public class Worker implements Runnable {
		private Socket s;

		public Worker(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				String line;
				while (true) {
					if ((line = reader.readLine()) != null) {
						String[] tokens = line.split(" ");
						if(tokens.length == 3 && tokens[0].equals("call")){
							call(Integer.parseInt(tokens[1]), tokens[2].equals("up")?Direction.UP:Direction.DOWN);
						}else if(tokens.length == 2 && tokens[0].equals("go")){
							go(Integer.parseInt(tokens[1]));
						}else{
							s.getOutputStream().write("Wrong input".getBytes());
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		elevator.listeningThread = new Thread(elevator.new Listen());
		elevator.listeningThread.start();
		elevator.processingThread = new Thread(elevator.new Process());
		elevator.processingThread.start();
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


 */