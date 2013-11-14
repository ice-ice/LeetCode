public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            
            int target = -num[i];
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                if (num[left] + num[right] == target) {
                    ArrayList<Integer> new_list = new ArrayList<Integer>();
                    new_list.add(num[i]);
                    new_list.add(num[left]);
                    new_list.add(num[right]);
                    results.add(new_list);
                    int l = num[left], r = num[right];
                    while (num[left] == l && left < right) {
                        left++;
                    }
                    while (num[right] == r && right > left) {
                        right--;
                    }
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return results;
    }
}
