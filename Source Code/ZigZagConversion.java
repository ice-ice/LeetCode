public class Solution {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (nRows <= 1) return s;
        
        StringBuffer[] sb = new StringBuffer[nRows];
        StringBuffer ret = new StringBuffer();
        
        for (int j = 0; j < nRows; j++) {
            sb[j] = new StringBuffer();
        }
        
        int direction = 1, cur = 0, i = 0;
        
        while (i < s.length()) {
            sb[cur].append(s.charAt(i++));
            switch (direction) {
                case 1:
                    if (cur == nRows - 1) {
                        cur--;
                        direction = 1 - direction;
                    } else {
                        cur++;
                    }
                    break;
                case 0:
                    if (cur == 0) {
                        cur++;
                        direction = 1 - direction;
                    } else {
                        cur--;
                    }
                    break; 
            }
        }
        
        for (int k = 0; k < nRows; k++) {
            ret.append(sb[k]);
        }
        
        return ret.toString();
    }
}
