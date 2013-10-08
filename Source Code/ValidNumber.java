public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = s.length();
        int i = 0;
        boolean left = false, right = false, dot = false, ee = false;
        int count = 0;
        
        i = goToNextNotSpace(s, i);
        
        if (i == len) return false;
        
        int state = 0;
        
        while (i >= 0 && i < len) {
            switch (state) {
                case 0:
                    if (!left && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                        count++;
                    } else if (s.charAt(i) == '.') {
                        dot = true;
                        state = 1;
                    } else if (s.charAt(i) == 'e') {
                        if (i == len - 1) return false;
                        ee = true;
                        state = 4;
                        if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                            i++;
                            if (i == len - 1) return false;
                        }
                    } else if (s.charAt(i) == ' ') {
                        state = 3;
                    } else if (!isDigits(s, i)) {
                        return false;
                    } else {
                        left = true;
                    }
                    break;
                case 1:
                    if (!ee && s.charAt(i) == 'e') {
                        ee = true;
                        if (i == len - 1) return false;
                        if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                            i++;
                            if (i == len - 1) return false;
                        }
                    } else if (isDigits(s, i)) {
                        right = true;
                        state = 2;
                    } else if (s.charAt(i) == ' ') {
                        state = 3;
                    } else {
                        return false;
                    }
                    break;
                case 2:
                    if (!ee && s.charAt(i) == 'e') {
                        ee = true;
                        if (i == len - 1) return false;
                        left = true;
                        if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                            i++;
                            if (i == len - 1) return false;
                        }
                    } else if (s.charAt(i) == ' ') {
                        state = 3;
                    } else if (!isDigits(s, i)) {
                        return false;
                    }
                    break;
                case 3:
                    if (s.charAt(i) != ' ') {
                        return false;
                    }
                    break;
                case 4:
                    if (isDigits(s, i)) {
                        right = true;
                        state = 2;
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            i++;
        }
        
        if (i == len && count <= 1) {
            if (dot) {
                if (!(left || right)) {
                    return false;
                }
            }
            if (ee && !left) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
        
    public boolean isDigits(String s, int i) {
        if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            return true;
        } else {
            return false;
        }
    }
    
    public int goToNextNotSpace(String s, int i) {
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        return i;
    } 
}
