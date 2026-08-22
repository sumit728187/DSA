import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                
                if (isPalindrome(left)) {
                    String rightReversed = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightReversed) && map.get(rightReversed) != i) {
                        result.add(Arrays.asList(map.get(rightReversed), i));
                    }
                }
                
                if (j != word.length() && isPalindrome(right)) {
                    String leftReversed = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftReversed) && map.get(leftReversed) != i) {
                        result.add(Arrays.asList(i, map.get(leftReversed)));
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}