package leetcode;

/**
 * Created by Hua on 8/14/16.

 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)

 search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true

 Note:
 You may assume that all words are consist of lowercase letters a-z.

 */
public class N211_AddandSearchWordDataStructureDesign {
    class TrieNode{
        boolean isLeaf;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    // 21ms
    public class WordDictionary {
        private TrieNode root = new TrieNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if(node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];  //important without else.
            }
            node.isLeaf = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return bfs(word, root, 0);
        }

        public boolean bfs(String word, TrieNode node, int start){
            if(node.isLeaf && start == word.length()) return true;
            if(start >= word.length()) return false;

            char c = word.charAt(start);
            if(c == '.'){
                boolean isMatched = false;
                for(int i=0;i<26;i++){
                    if(node.children[i] != null && bfs(word, node.children[i], start+1)) {
                        isMatched = true;
                        break;
                    }
                }
                if(isMatched) return true;
            }else{
                int index = c -'a';
                if(node.children[index] !=null) return bfs(word, node.children[index], start+1);
            }

            return false;
        }
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
