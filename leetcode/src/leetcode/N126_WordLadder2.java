package leetcode;
import java.util.*;

/**
 * Created by Hua on 6/24/2016.

 Given two words (beginWord and endWord), and a dictionary's word list,
 find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Return

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]

 Note:

 All words have the same length.
 All words contain only lowercase alphabetic characters.


 Input:
 "red"
 "tax"
 ["ted","tex","red","tax","tad","den","rex","pee"]

 Output: [["red","ted","tad","tax"],["red","ted","tex","tax"]]

 Expected: [["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]



 */
public class N126_WordLadder2 {
    class Node{
        String word;
        Node pre;
        public Node(String val, Node pre){
            this.word = val;
            this.pre = pre;
        }
    }

    // BFS, store previous string as a node.
    // remove words from dictionary by level
    // 320 ms
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<List<String>> ret = new ArrayList<>();
        wordList.remove(beginWord);
        wordList.add(endWord);
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(beginWord,null));
        boolean isFound=false;
        while(!list.isEmpty()){
            int level_size = list.size();
            // for each level of BFS
            List<String> toBeRemoved = new ArrayList<>();
            while(level_size-- > 0) {
                Node node = list.remove(0);
                if (node.word.equals(endWord)) {
                    isFound = true;
                    ret.add(backTrackPath(node));
                }
                toBeRemoved.addAll(addNeighborsToList(node, list, wordList));
            }
            for(String s: toBeRemoved) wordList.remove(s); // without this will TLE
            if(isFound) break;
        }
        return ret;
    }

    public List<String> backTrackPath(Node node){
        LinkedList<String> path = new LinkedList<>();
        Node curNode = node;
        while(curNode != null){
            path.addFirst(curNode.word);
            curNode = curNode.pre;
        }
        return path;
    }

    // add neighbors of word to list
    // for each position of word replace with 'a' - 'z'
    public List<String> addNeighborsToList(Node node, LinkedList<Node> list, Set<String> wordList ){
        List<String> toBeRemoved = new ArrayList<>();
        char[] chars = node.word.toCharArray();
        for(int i=0;i<node.word.length();i++){
            for(int j=0;j<26;j++){
                if((char)('a'+j) == node.word.charAt(i)) continue;

                chars[i] = (char) ('a' + j) ;
                String newWord = new String(chars); //important, chars.toString won't work
                if(wordList.contains(newWord)){
                    toBeRemoved.add(newWord);
                    list.add(new Node(newWord, node));
                }
                chars[i] = node.word.charAt(i);
            }
        }
        return toBeRemoved;
    }


    public static void main(String[] args) {
        N126_WordLadder2 x = new N126_WordLadder2();
        //System.out.println(
        // x.findLadders("a", "c", new HashSet<>(Arrays.asList("a", "b", "c"))));

        //System.out.println(
        // x.findLadders("hot", "dog", new HashSet<>(Arrays.asList("hot", "dog"))));

        //System.out.println(x.findLadders("hit", "cog", new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"))));

        System.out.println(x.findLadders("red", "tax", new HashSet<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"))));

    }
}
