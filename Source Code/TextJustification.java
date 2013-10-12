public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<String> results = new ArrayList<String>();
        
        int i = 0;
        
        while ( i < words.length) {
            String current = "";
            int len = 0, count = 0;
            ArrayList<String> list = new ArrayList<String>();
            
            while (true) {
                if (i == words.length) {
                    String s = "";
                    for (String ss : list) {
                        s += " " + ss;
                    }
                    s = s.substring(1);
                    
                    for (int j = s.length(); j < L; j++) {
                        s += " ";
                    }
                    results.add(s);
                    break;
                }
                if (count > 0) len++;
                len = len + words[i].length();
                if (len > L) {
                    if (count == 1) {
                        String s = list.get(0);
                        for (int j = s.length(); j < L; j++) {
                            s = s + " ";
                        }
                        results.add(s);
                        break;
                    } else {
                        int spaces = L, remain = 0;
                        for (String s : list) {
                            spaces -= s.length();
                        }
                        remain = spaces % (count - 1);
                        spaces = spaces / (count - 1);
                        String new_s = list.get(0);
                        
                        String padString = "";
                        for (int j = 0; j < spaces; j++) {
                            padString += " ";
                        }
                        
                        for (int j = 0; j < remain; j++) {
                            new_s = new_s + " " + padString + list.get(j + 1);
                        }
                        
                        for (int j = remain; j < count - 1; j++) {
                            new_s = new_s + padString + list.get(j + 1);
                        }
                        
                        results.add(new_s);
                        break;
                    }
                } else {
                    list.add(words[i]);
                    count++;
                    i++;
                }
            }
        }
        
        return results;
    }
}
