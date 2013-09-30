public int atoi(String str) {
    // Start typing your Java solution below
    // DO NOT write main() function
    
    String s = skipZeroes(str);
    
    int ret = 0, flag = 1, overflow = 0, posneg = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (posneg == 0 && s.charAt(i) == '-') {
            posneg = 1;
            flag = -1;
            continue;
        }
        
        if (posneg == 0 && s.charAt(i) == '+') {
            posneg = 1;
            flag = 1;
            continue;
        }
        
        if (s.charAt(i) > '9' || s.charAt(i) < '0') {
            break;
        }
        
        int maximum = Integer.MAX_VALUE;
        
        for (int k = 0; k < 10; k++) {
            maximum -= ret;
            if (maximum < 0) {
                overflow = 1;
                i = s.length() - 1;
                break;
            }
        }
        
        if (maximum < (int)(s.charAt(i) - '0')) {
            overflow = 1;
            i = s.length() - 1;
            break;
        }
        
        ret = ret * 10 + (int)(s.charAt(i) - '0');
    }
    
    if (overflow == 1) {
        return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }
    
    return flag == 1 ? ret : -ret;
}

public String skipZeroes(String str) {
    int i = 0;
    
    while (i < str.length() && str.charAt(i) == ' ') {
        i++;
    }
    
    return str.substring(i);
}
