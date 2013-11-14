public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
            
                int remains = target - num[i] - num[j];
                int left = j + 1, right = num.length - 1;
                while (left < right) {
                    if (num[left] + num[right] == remains) {
                        ArrayList<Integer> new_list = new ArrayList<Integer>();
                        new_list.add(num[i]);
                        new_list.add(num[j]);
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
                    } else if (num[left] + num[right] < remains) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return results;
    }
}
