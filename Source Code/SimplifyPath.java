public class Solution {
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Stack<String> stack = new Stack<String>();
        
        int i = 0;
        while (i < path.length()) {
            char c = path.charAt(i);
            StringBuffer sb = new StringBuffer();
            if (c == '.') {
                if (i < path.length() - 1 && path.charAt(i + 1) == '.') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    i += 2;
                    continue;
                }
                if (i < path.length() - 1 && path.charAt(i + 1) == '/') {
                    i++;
                    continue;
                } else if (i == path.length() - 1) {
                    break;
                }
            }
            if (c != '/') {
                while (i < path.length() && path.charAt(i) != '/') {
                    sb.append(path.charAt(i++));
                }
                stack.push(sb.toString());
                continue;
            }
            i++;
        }
        
        String str = "";
        while (!stack.isEmpty()) {
            str = "/" + stack.pop() + str;
        }
        
        return str.equals("") ? "/" : str;
    }
}
