public class Solution {
    static HashMap<String, Integer> visited = new HashMap<String, Integer>();
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        visited.clear();
        visited.put(start, 1);
        
        dict.add(start);
        dict.add(end);
        
        return getMinNum(start, end, dict);
    }
    
    public int getMinNum(String start, String end, HashSet<String> dict) {
        ArrayList<String> queue = new ArrayList<String>();
        ArrayList<Integer> levels = new ArrayList<Integer>();
        queue.add(start);
        levels.add(1);
        
        while (!queue.isEmpty()) {
            String current = queue.remove(0);
            int level = levels.remove(0);
            if (current.equals(end)) {
                return level;
            }
            
            for (int i = 0; i < current.length(); i++) {
                ArrayList<String> lists = possibleStr(current, i, dict);
                for (String new_word : lists) {
                    if (!visited.containsKey(new_word)) {
                        queue.add(new_word);
                        levels.add(level + 1);
                        visited.put(new_word, level + 1);
                    }
                }
            }
        }
        
        return 0;
    }
    
    public ArrayList<String> possibleStr(String word, int index, HashSet<String> dict) {
        ArrayList<String> lists = new ArrayList<String>();
        
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (word.charAt(index) != c) {
                String new_word = makeStr(word, index, c);
                if (dict.contains(new_word)) {
                    lists.add(new_word);
                    dict.remove(new_word);
                }
            }
        }
        
        return lists;
    }
    
    public String makeStr(String word, int index, char c) {
        String left = word.substring(0, index);
        String right = index + 1 > word.length() - 1 ? "" : word.substring(index + 1);
        return left + c + right;
    }
}
