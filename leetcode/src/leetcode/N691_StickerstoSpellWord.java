package leetcode;

import java.util.*;

/**
 * Created by HuaZ on 10/16/2017.

 We are given N different types of stickers. Each sticker has a lowercase English word on it.

 You would like to spell out the given target string by cutting individual letters from your
 collection of stickers and rearranging them.

 You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

 What is the minimum number of stickers that you need to spell out the target?
 If the task is impossible, return -1.

 Example 1:

 Input:

 ["with", "example", "science"], "thehat"

 Output:

 3

 Explanation:

 We can use 2 "with" stickers, and 1 "example" sticker.
 After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 Also, this is the minimum number of stickers necessary to form the target string.

 Example 2:

 Input:

 ["notice", "possible"], "basicbasic"

 Output:

 -1

 Explanation:

 We can't form the target "basicbasic" from cutting letters from the given stickers.

 Note:
 stickers has length in the range [1, 50].
 stickers consists of lowercase English words (without apostrophes).
 target has length in the range [1, 15], and consists of lowercase English letters.
 In all test cases, all words were chosen randomly from the 1000 most common US English words,
 and the target was chosen as a concatenation of two random words.
 The time limit may be more challenging than usual.
 It is expected that a 50 sticker test case can be solved within 35ms on average.

 */
public class N691_StickerstoSpellWord {
    // others dp solution
    // time 2^N * S(length of all words) * T(length of target)
    // 100 / 100 test cases passed.
    // 274 ms
    class Solution {
        public int minStickers(String[] stickers, String target) {
            int N = target.length();
            int[] dp = new int[1 << N];
            for (int i = 1; i < 1 << N; i++) dp[i] = -1;

            for (int state = 0; state < 1 << N; state++) {
                if (dp[state] == -1) continue;
                for (String sticker: stickers) {
                    int now = state;
                    for (char letter: sticker.toCharArray()) {
                        for (int i = 0; i < N; i++) {
                            if (((now >> i) & 1) == 1) continue;
                            if (target.charAt(i) == letter) {
                                now |= 1 << i;
                                break;
                            }
                        }
                    }
                    if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                        dp[now] = dp[state] + 1;
                    }
                }
            }
            return dp[(1 << N) - 1];
        }
    }


    // others BFS with set for memo solution
    // 100 / 100 test cases passed.
    // 388 ms
    class Solution2 {
        String toKey(int[] arr){
            StringBuilder sb=new StringBuilder();
            boolean allZ=true;
            for (int i=0;i<26;++i){
                int n=arr[i];
                sb.append(n).append(",");
                if (n>0)allZ=false;
            }
            if (allZ)return "";
            return sb.toString();
        }
        public int minStickers(String[] stickers, String target) {
            if (target.isEmpty())return 0;
            int ns=stickers.length;

            int[][] letters=new int[ns][26];
            for (int i=0;i<stickers.length;++i){
                String s=stickers[i];
                for (char c:s.toCharArray())++letters[i][c-'a'];
            }

            int[] targetLetters=new int[27];
            for (char c:target.toCharArray())++targetLetters[c-'a'];
            targetLetters[26]=0;
            String key=toKey(targetLetters);

            if (key.isEmpty())return 0;
            Queue<int[]> q=new LinkedList<>();
            Set<String> seenKey= new HashSet<>();
            seenKey.add(key);

            q.add(targetLetters);
            while (!q.isEmpty()){
                int[] cur=q.remove();
                for (int i=0;i<ns;++i){      // go through each stickers
                    int[] next=cur.clone();
                    int[] letter=letters[i];

                    for (int j=0;j<26;++j){
                        if (letter[j]>=0) next[j]=Math.max(next[j]-letter[j], 0);
                    }
                    ++next[26];
                    String nextKey=toKey(next);
                    if (nextKey.isEmpty())return next[26];

                    if (seenKey.add(nextKey)) q.add(next);  // add to set, if not in set, add to queue.
                }
            }
            return -1;
        }
    }


    // backtracking with pruning?
    // My contest solution, but TLE
    class Solution3 {
        int ret = Integer.MAX_VALUE;
        public int minStickers(String[] stickers, String target) {
            if(!hasAllChar(stickers, target)) return -1;  //pruning
            int[] t = new int[26];
            for(char c : target.toCharArray()) t[c - 'a']++;

            ArrayList<int[]> list = new ArrayList(); // shorter list candidate, pruning
            for(String s : stickers){
                for(char c : s.toCharArray()) {
                    if(t[c - 'a'] != 0){
                        int[] arr = new int[26];
                        for(char x : s.toCharArray()) arr[x - 'a']++;
                        list.add(arr);
                        break;
                    }
                }
            }

            dfs(list, t, 0, 0);
            return ret;
        }

        public void dfs(ArrayList<int[]> list, int[] t, int start, int count){
            boolean isOK = true;
            for(int x : t) {
                //System.out.println("x="+x);
                if(x > 0) {
                    isOK = false;
                    break;
                }
            }
            if(isOK) {  // means find all
                //System.out.println("count="+count + " start="+start);
                ret = Math.min(ret, count);
                return;
            }

            for(int i=start; i<list.size(); i++){
                int[] s = list.get(i);
                boolean[] isUsed = new boolean[26];
                boolean isAnyUsed = false;

                // set t
                for(int j=0; j<26;j++){
                    if(t[j] >0 && s[j] > 0){
                        t[j] -= s[j];
                        isUsed[j] = true;
                        isAnyUsed = true;
                    }
                }

                if(isAnyUsed) dfs(list, t, i, count+1);
                else dfs(list, t, i+1, count);

                // ret t
                if(!isAnyUsed) continue;
                for(int j=0; j<26;j++){
                    if(isUsed[j]) t[j] += s[j];
                }
            }
        }

        public boolean hasAllChar(String[] stickers, String target){
            boolean[] b = new boolean[26];
            for(char c : target.toCharArray()) b[c - 'a'] = true;
            for(String s : stickers){
                for(char c : s.toCharArray()) b[c - 'a'] = false;
            }
            for(boolean x : b) if(x) return false;
            return true;
        }
    }
}
