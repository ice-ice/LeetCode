public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] ip = new int[s.length()];
        for (int i = 0; i < ip.length; i++) {
            ip[i] = (int)(s.charAt(i) - '0');
        }
        
        ArrayList<String> results = new ArrayList<String>();
        
        getAll(ip, 0, 0, "", results);
        
        return results;
    }
    
    public void getAll(int[] ip, int start, int dot, String s, ArrayList<String> results) {
        if (dot >= 3 || start >= ip.length) return;

        if (ip[start] == 0) {
            String new_s = s;
            if (s.length() == 0) {
                new_s = "0";
            } else {
                if (dot == 2) {
                    if (start != ip.length - 1) return;
                    results.add(s + ".0");
                    return;
                }
                new_s = s + ".0";
                dot++;
            }
            getAll(ip, start + 1, dot, new_s, results);
        } else {
            int sum = 0;
            if (dot == 2) {
                for (int i = start; i < ip.length; i++) {
                    sum = sum * 10 + ip[i];
                    if (sum > 255) return;
                }
                String new_s = s + "." + string_from_int(ip, start, ip.length - start);
                results.add(new_s);
                return;
            } else {
                for (int i = start; i < start + 3; i++) {
                    int new_dot = dot;
                    if (i >= ip.length) return;
                    sum = sum * 10 + ip[i];
                    if (sum > 255) return;
                    String new_s = s;
                    if (s.length() == 0) {
                        new_s = s;
                    } else {
                        new_s = s + ".";
                        new_dot++;
                    }
                    new_s = new_s + string_from_int(ip, start, i - start + 1);
                    getAll(ip, i + 1, new_dot, new_s, results);
                }
            }
        }
    }
    
    public String string_from_int(int[] ip, int start, int len) {
        char[] c = new char[len];
        for (int i = 0; i < len; i++) {
            c[i] = (char)(ip[i + start] + '0');
        }
        return new String(c);
    }
}
