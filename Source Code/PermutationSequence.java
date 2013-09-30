public class Solution {
    static HashSet<Integer> used = new HashSet<Integer>();
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        used.clear();
        
        String s = new String();
        
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                s += (char)('0' + i);
            }
            return s;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int digit = (k - 1) / factorial(i) + 1;
            if (k > factorial(i)) {
                k = k % factorial(i);
                if (k == 0) k = factorial(i);
            }
            
            s += (char)(getDigit(digit) + '0');
            
            if (k == 1) {
                String rest = getRestInOrder(i);
                s += rest;
                return s;
            } else if (k == factorial(i)) {
                String rest = getRest(i, n);
                s += rest;
                return s;
            }
        }
        
        return s;
    }
    
    public String getRestInOrder(int d) {
        String s = new String();
        int num = 1;
        for (int i = 0; i < d; i++) {
            while (used.contains(num)) {num++;}
            used.add(num);
            s += (char)('0' + num);
        }
        return s;
    }
    
    public String getRest(int d, int n) {
        String s = new String();
        int num = n;
        for (int i = 0; i < d; i++) {
            while (used.contains(num)) {num--;}
            used.add(num);
            s += (char)('0' + num);
        }
        return s;
    }
    
    public int getDigit(int d) {
        int num = 0;
        
        for (int i = 0; i < d; i++) {
            num++;
            while (used.contains(num)) {num++;}
        }
        
        used.add(num);
        
        return num;
    }
    
    public int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }
}
