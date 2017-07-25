package leetcode;

/**
 * Created by Hua on 7/25/2017.

 LeetCode wants to give one of its best employees the option to travel among N cities to collect algorithm problems.
 But all work and no play makes Jack a dull boy, you could take vacations in some particular cities and weeks.
 Your job is to schedule the traveling to maximize the number of vacation days you could take,
 but there are certain rules and restrictions you need to follow.

 Rules and restrictions:

 You can only travel among N cities, represented by indexes from 0 to N-1.
 Initially, you are in the city indexed 0 on Monday.
 The cities are connected by flights. The flights are represented as a N*N matrix (not necessary symmetrical),
 called flights representing the airline status from the city i to the city j.
 If there is no flight from the city i to the city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1.
 Also, flights[i][i] = 0 for all i.

 You totally have K weeks (each week has 7 days) to travel.
 You can only take flights at most once per day and can only take flights on each week's Monday morning.
 Since flight time is so short, we don't consider the impact of flight time.

 For each city, you can only have restricted vacation days in different weeks,
 given an N*K matrix called days representing this relationship. For the value of days[i][j],
 it represents the maximum days you could take vacation in the city i in the week j.


 You're given the flights matrix and days matrix,
 and you need to output the maximum vacation days you could take during K weeks.

 Example 1:

 Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
 Output: 12
 Explanation:
 Ans = 6 + 3 + 3 = 12.

 One of the best strategies is:
 1st week : fly from city 0 to city 1 on Monday, and play 6 days and work 1 day.
 (Although you start at city 0, we could also fly to and start at other cities since it is Monday.)
 2nd week : fly from city 1 to city 2 on Monday, and play 3 days and work 4 days.
 3rd week : stay at city 2, and play 3 days and work 4 days.

 Example 2:

 Input:flights = [[0,0,0],[0,0,0],[0,0,0]], days = [[1,1,1],[7,7,7],[7,7,7]]
 Output: 3
 Explanation:
 Ans = 1 + 1 + 1 = 3.

 Since there is no flights enable you to move to another city, you have to stay at city 0 for the whole 3 weeks.
 For each week, you only have one day to play and six days to work.
 So the maximum number of vacation days is 3.

 Example 3:

 Input:flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[7,0,0],[0,7,0],[0,0,7]]
 Output: 21
 Explanation:
 Ans = 7 + 7 + 7 = 21

 One of the best strategies is:
 1st week : stay at city 0, and play 7 days.
 2nd week : fly from city 0 to city 1 on Monday, and play 7 days.
 3rd week : fly from city 1 to city 2 on Monday, and play 7 days.

 Note:

 N and K are positive integers, which are in the range of [1, 100].
 In the matrix flights, all the values are integers in the range of [0, 1].
 In the matrix days, all the values are integers in the range [0, 7].
 You could stay at a city beyond the number of vacation days, but you should work on the extra days,
 which won't be counted as vacation days.
 If you fly from the city A to the city B and take the vacation on that day,
 the deduction towards vacation days will count towards the vacation days of city B in that week.
 We don't consider the impact of flight hours towards the calculation of vacation days.


 Test cases:
 Input:
 [[0,1,0],[0,0,0],[0,0,0]]
 [[0,0,7],[2,0,0],[7,7,7]]
 Expected:7


 Input:
 [[0,0,0,0,0],[0,0,0,0,0],[1,1,0,1,0],[1,0,0,0,0],[1,1,1,1,0]]
 [[0,1,1,0,0],[1,2,2,1,2],[2,0,0,2,1],[0,2,1,2,2],[0,1,1,1,0]]
 Expected:2


 */
public class N568_MaximumVacationDays {
    // typical dp, o(col * row^2)
    // 57 / 57 test cases passed.
    // 116 ms
    public class Solution {
        public int maxVacationDays(int[][] flights, int[][] days) {
            int row = days.length, col = (row == 0)? 0 : days[0].length;
            if(col == 0) return 0;
            int[][] dp = new int[row][col];

            //init, week 0
            dp[0][0] = days[0][0];
            int ret = dp[0][0];
            for(int city=1; city<row; city++) {
                if(flights[0][city] == 1) dp[city][0] = days[city][0];
                ret = Math.max(ret, dp[city][0]);
            }

            // from week 1 to week n
            for(int week=1 ;week<col; week++){
                for(int curCity=0; curCity<row; curCity++){
                    for(int preCity = 0 ; preCity < row; preCity++){
                        if((flights[preCity][curCity] == 1 && dp[preCity][week-1] != 0)      // fly to other cities
                                || (preCity == curCity && curCity == 0)                      // stay in first city
                                || (preCity == curCity && dp[preCity][week-1] != 0)){        // stay in other cities
                            dp[curCity][week] = Math.max(dp[curCity][week], dp[preCity][week-1] + days[curCity][week]);
                        }
                    }
                    ret = Math.max(ret, dp[curCity][week]);
                }
            }
            return ret;
        }
    }


    // another bottom up solution, it's great to take a further look.
    // 57 / 57 test cases passed.
    // 69 ms
    public class Solution2 {
        public int maxVacationDays(int[][] flights, int[][] days) {
            int n = flights.length, k = days[0].length;
            int[][] dp = new int[k + 1][n];
            for (int i = k - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    int max = dp[i + 1][j] + days[j][i];
                    for (int c = 0; c < n; c++) {
                        if (flights[j][c] > 0) {
                            max = Math.max(max, dp[i + 1][c] + days[c][i]);
                        }
                    }
                    dp[i][j] = max;
                }
            }
            return dp[0][0];
        }
    }

}
