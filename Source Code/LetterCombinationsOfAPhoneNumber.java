public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> list = new ArrayList<String>();
        
        if (digits.length() == 0) {
            list.add("");
            return list;
        }
        
        list = getCharacters(digits.charAt(0));
        
        for (int i = 1; i < digits.length(); i++) {
            char c = digits.charAt(i);
            
            ArrayList<String> new_chars = getCharacters(c);
            
            int len = list.size();
            while (len > 0) {
                String s = list.remove(0);
                for (String new_c : new_chars) {
                    list.add(s + new_c);
                }
                len--;
            }
        }
        
        return list;
    }
    
    public ArrayList<String> getCharacters(char c) {
        ArrayList<String> list = new ArrayList<String>();
        
        switch (c) {
            case '2':
                list.add("a");
                list.add("b");
                list.add("c");
                break;
            case '3':
                list.add("d");
                list.add("e");
                list.add("f");
                break;
            case '4':
                list.add("g");
                list.add("h");
                list.add("i");
                break;
            case '5':
                list.add("j");
                list.add("k");
                list.add("l");
                break;
            case '6':
                list.add("m");
                list.add("n");
                list.add("o");
                break;
            case '7':
                list.add("p");
                list.add("q");
                list.add("r");
                list.add("s");
                break;
            case '8':
                list.add("t");
                list.add("u");
                list.add("v");
                break;
            case '9':
                list.add("w");
                list.add("x");
                list.add("y");
                list.add("z");
                break;
            default:
        }
        
        return list;
    }
}
