package leetcode;

/**
 * Created by Hua on 7/25/2017.

 Given an array of n distinct non-empty strings, you need to generate minimal
 possible abbreviations for every word following rules below.

 Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used
 instead of only the first character until making the map from word to abbreviation become unique.
 In other words, a final abbreviation cannot map to more than one original words.
 If the abbreviation doesn't make the word shorter, then keep it as original.

 Example:

 Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]

 Note:

 Both n and the length of each word will not exceed 400.
 The length of each word is greater than 1.
 The words consist of lowercase English letters only.
 The return answers should be in the same order as the original array.


 */

import java.util.*;
public class N527_WordAbbreviation {
    // Google, Snapchat (Premium)
    // hashtable, string, fair complex code.
    // 78 / 78 test cases passed.
    // 64 ms
    public class Solution {
        public List<String> wordsAbbreviation(List<String> dict) {
            int n = dict.size();
            int[] prefix = new int[n];
            Arrays.fill(prefix, 1);
            String[] ret = new String[n];
            for(int i=0; i<n; i++){
                ret[i] = makeAbbr(dict.get(i), 1);  // init prefix is 1 char
            }

            // for each string try to find a unique by increase prefix one by one
            for(int i =0 ;i<n ;i++){
                while(true){
                    HashSet<Integer> set = new HashSet(); // store index of duplicate prefix
                    for(int j= i+1; j<n ;j++){
                        if(ret[i].equals(ret[j])) set.add(j);
                    }
                    if(set.isEmpty()) break; // ret[i] is unique
                    set.add(i);              // find some duplicate of ret[i], add ret[i] as well to increase prefix
                    for(int k : set){
                        ret[k] = makeAbbr(dict.get(k), ++prefix[k]);
                    }
                }
            }
            return Arrays.asList(ret);
        }

        // smart function
        public String makeAbbr(String s, int k){
            int n = s.length();
            if(k >= n - 2) return s;
            StringBuilder sb = new StringBuilder();
            return sb.append(s.substring(0, k)).append(n - k - 1).append(s.charAt(n-1)).toString();
        }
    }


    // wrong answer for below data
    // ["bbadabadccdabdadccdd","aacbbbacccacaadabcdc","ccdcccdcbccadadbdcdd","abdbcaacbaacabccadaa","cbaaabddbbddcbbcbddb","addaadcdaabcccbddada","aaaabcbbcadabdaccdda","dbcabacdacdaaccdccdc","acdabbcdcabaaccdbbac","abbadcabdabcadcdccbc","ddbddbadacacacbcbaaa","dabaaababccaddbaacad","dbbdbcdcabbaacdccbdc","dcdcbbcccadbacdaddad","dacdbcdbaddabbbabbac","bdddacdcabbcccdbcdaa","abaababcccadabadbcdd","bbbccdbadcbaacadcacb","abddadccaaccccaacccd","dbbababacaacdbdbcdcb","cdadccadbdaaacbabbbc","adaaabbcabddadcacabb","bdbbbaadaddbbbddbabd","ddaccbdccadcaccabcbd","dbdacbbbacdbbddddbbd","bbaaadcccdbacdccdddd","cbdbbcddaacabcabbabd","bbacccdbdbddbabbbaba","cacabbaaaaaaabadbddc","daddaaccbadcacaadabc","adcdbddadabbdabcabdb","aabdacbdbacdddcbbbdc","bbcdbdbdcbacbccbbdaa","daadacbcbcbcddcdcbcc","daccabbdbddcddacbdcb","cbccacacabbcdbbcabac","bbdbcbbdbacabddbcbcb","acbbbcdbbdcddbccbbba","cbdabcdaccdbcddbbbcb","dabdbbcdcccdbdacbcca","cdccbdddbbdcadbcbcbd","cacccbccdcacdcbddcbd","bbcddabcdbcadcbcdaac","adddbcbdaacbabcddbcc","ccbbbbcaabccadbcdacd","cbbbbdaadaccdadccbad","caabaddbbacccaddcdcd","bbbcdbcddadabddcccbd","ccdadbcacdadbdbbacdb","cbcaddcadadcbcdabbdc","dcadcdbaabcacdddaaba","ccaadddcabdcbbdacdad","dacdadcbbbdddaabacaa","addbaddaabbddacbdbaa","adcabccccbaccdccadaa","cbaabdabdddcaaaabdac","dbcababcaaddbdacbdcc","bdaaaadcdbcacccccdac","baccadcdaabcbcdbabba","badccccddaabacdbcdac","dabcabbdadcdcadbcddb","abcdcbbaccdddadcaaba","aaaccabacbdbcadbabcb","ddbccbbbaccdabaacacb","bdacababadbadadbccbc","aacacadccabbcadbabac","bcbcddadaddbdbddddad","bcabddacadbaadcaddaa","ccdcbdcadacddaaacbab","ddcbdbabaddcacdadcaa","bcabddcdbbdabdbccbac","cbddcbccbcadacdaccbb","ddbcaddcdabccbbdcccd","cbadbbcacdccdddabadd","cdcbdcbddddcbccbadad","dcdacdbaacddbaaccaba","cccbddbbaddbcababcdb","dcbdbaddaabcdadcaaad","ddccbadacbdbcbccadcd","dcaccbddaccdabccbccb","bdcbddcbddcbbbbdabca","dcbddbbbacaacdacdbbc","abdbabbddbdacccbdbdd","cbaddbabdcbbbaadcdbb","dbacdbdcdcacaccbbabb","acdaccdababbbcdddbbd","badcccdabacadbdaabad","cdabbadbaccbadcbaacd","bdcaddbdccdcadaaabba","bccaaddbaabcbcacdcab","abaabacbcdcdbcadaacb","abbccddcbadaaaaadcdd","badbccdddbbbdcbdbddd","bcdbddcdcccbaabccbbd","bacabcdbcbabacdddddc","cbaabcbacdbcbdabcacb","ddbdadacadcaccbdbcdd","ccabbbbbdbcacbaacbbc","bccabcacdccccbdabcad","babbadcaddadabdbdcbc","ddcaacdcccbdbdadcaac","aacccddcbaddbacbaccc","adabadbcbdbcdaacbbdd","bbacaddcbaccbcbadcdb","badddadbddbbdbcaacda","aaccddddbddddaacbcaa","aabbcbdadcdcabcccadc","dacbdaabdccccbdddacd","dccbdddccdaacadbaabc","abacddbabdacacadbadc","abcbbddddbbdccacbabb","aacaacdaadcadaaccbcc","addbacdbcdabcadccdac","cbababbdccdbdbdacadb","babdbcbacdbadbadccaa","aaabcddbcdbacbdaabbd","dabcadaaabdbcaaacbbb","dcdcdacbcccbcabccdca","abbddccccdaaaabaccad","bcabbdacbcaaccdddddd","dacddcabcaddacbbbcaa","aabcbbbddabdbaabddbc","abcbdddbccbaaaaadcdb","cbabbdacdadaddbccaca","bcddbbdcdddbadbdbabc","bbdbdadbbbaccbadbdda","cccbbdbcadbbdccbdaaa","bbcbababbcdbadbaacda","adcdcddbcccbbbaaacdc","bbbdccdccdcdaacbdacb","bcbbacbccdadabddaada","dadadadaacaaccccbdac","abbbcddaaadbbcbcbdcd","dababccbbdadbadcaaad","bbcdccbdbdbbddcbacba","ccdaaababbbbdcaaabda","daaadaabaacaabdabbbd","abbbbbbcdbcddbacddcb","adddbdbbcbdbbcdaccca","ccbddabbdcdcaabbbdbb","dcddabddbaacbbbcbaca","bccaccadcabbaabaadaa","baadcbdcabcbbbcddccd","cbddcdcbddbccbaacabc","ddacabdbacbbabccadbd","daaddcadaccdbbdcdccd","abdaabcdbabbdbbcdcba","ccdbbcaabbdadbbdccdb","cadcddbbccadcdbdabcb","dcdcddbaabbddcbdaddb","cbcdbadcdcdaddcbcddd","ddadaadcbddadbbadccd","acdacaadcddbadbcdbdd","bbaadccddabcdadddbbb","caabadcbcdacdcbacbbd","badcbddccbdcdccbbbcd","aabcbddbdbcbacdaaada","abccdcbbacbbbacddcbd","cccbbbdabcbadcabaaab","acccbcbcbbbbaaddaccb","abdddbdaadcbcdcbbccc","abcdadacdcabdacddbdd","cdddcadadbddbcbbcdba","abdbadcacbcdaaabbacd","ccdaddabbacbbbcccaba","dddaacbddcbbbddacdbc","ddbbbdcdbddaaabcdaab","dbdabddacaadccaabbac","badddacadbdbacbddbcb","cdadcddaaacdaaaabdab","bccbadaccdbbdabddbab","ddaadabbddacacbdbcdb","addcbdbdbddbdaadcdaa","bbcabccadcdcbcdadcdd","bbaccccdbdacbcddacac","dbbaadabacabbbdcaddb","bcdbbaacbccaacdbaaaa","aaabcdadbaacbabdacbc","dbccbdacdbcbacdadaba","bdadcdcdbbcdcabdbbcc","cdbbbdaabddbccabdaac","baacabdccdcdccbcbdcc","bcbbbaaaddabdcddddcd","dcddacdddacccddacbdb","dcacdcbddccbbcaacbda","cbadbbbacabcddddcacc","dabbbdddbcddbccbabda","bbcacaaddbbabddbbdaa","cbaddabdabbcddadbaab","bbadcbbdbabddbabbcca","adbdcdddbabdaacdacab","bdaccaaddbaddbaabdcc","cbdcbacacdbbcbbccbbd","cdcabcccddbbcddccbdc","bddddcabbaabcbdbbabd","cdbcbabacacbcbcdbcbc","aadbacacbaadbbbcbdba","caadbbaddcddccbbabdb","aacbddbbbadddacdbdaa","bcadabdaadcacbcccbaa"]
    public class Solution2 {
        public List<String> wordsAbbreviation(List<String> dict) {
            HashMap<String, HashSet<String>> abbrMap = new HashMap();  // abbr -> words
            HashMap<String, String> wordMap = new HashMap();        // word -> abbr

            for(String s : dict){
                String abbr = (s.length() <= 3 ? s : s.charAt(0) + "" + (s.length()-2) + s.charAt(s.length()-1));
                if(!abbrMap.containsKey(abbr)) abbrMap.put(abbr, new HashSet());
                abbrMap.get(abbr).add(s);
            }

            for(String abbr : abbrMap.keySet()){
                HashSet<String> list = abbrMap.get(abbr);

                if(list.size() == 1) wordMap.put(list.iterator().next(), abbr);
                else{
                    // find uncommon prefix and try to abbr if singled out
                    int n = list.iterator().next().length(), i=0 ;
                    while(i < n){
                        HashMap<Character, List<String>> map = new HashMap();
                        for(String s: list) {
                            char c = s.charAt(i);
                            if(!map.containsKey(c)) map.put(c, new ArrayList());
                            map.get(c).add(s);
                        }

                        if(map.size() == list.size())break;

                        for(char c : map.keySet()){
                            if(map.get(c).size() == 1){
                                addWordToMap(wordMap, map.get(c).get(0), i, n);
                                list.remove(map.get(c).get(0));
                            }
                        }
                        i++;
                    }

                    // contruct new abbr
                    for(String s : list){
                        addWordToMap(wordMap, s, i, n);
                    }
                }
            }

            List<String> ret = new ArrayList();
            for(String s : dict) ret.add(wordMap.get(s));

            return ret;
        }

        public void addWordToMap(HashMap<String, String> wordMap, String s, int i, int n){
            if(n - i <= 3) wordMap.put(s, s);
            else wordMap.put(s, s.substring(0, i+1) + "" + (n - i - 2) + s.charAt(n-1));
        }
    }
}
