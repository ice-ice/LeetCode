public class Solution {
    public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int lenA = a.length(), lenB = b.length();
        int len = 1 + Math.max(lenA, lenB);
        
        char[] result = new char[len];
        
        int indexA = lenA - 1, indexB = lenB - 1, index = len - 1;
        int sum = 0, carry = 0;
        
        while (indexA >= 0 && indexB >= 0) {
            sum = carry + (int)(a.charAt(indexA) - '0') + (int)(b.charAt(indexB) - '0');
            carry = sum / 2;
            sum = sum % 2;
            result[index] = (char)(sum + '0');
            --index;
            --indexA;
            --indexB;
        }
        
        if (indexA < 0) {
            while (indexB >= 0) {
                sum = carry + (int)(b.charAt(indexB) - '0');
                carry = sum / 2;
                sum = sum % 2;
                result[index] = (char)(sum + '0');
                --index;
                --indexB;
            }
        } else {
            while (indexA >= 0) {
                sum = carry + (int)(a.charAt(indexA) - '0');
                carry = sum / 2;
                sum = sum % 2;
                result[index] = (char)(sum + '0');
                --index;
                --indexA;
            }
        }
        
        result[0] = (char)(carry + '0');
        
        String ret = new String(result);
        
        return carry == 0 ? ret.substring(1) : ret;
    }
}
