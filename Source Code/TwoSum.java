public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] ret = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        HashMap<Integer, ArrayList<Integer>> maps = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i <= right; i++) {
            if (!maps.containsKey(numbers[i])) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i + 1);
                maps.put(numbers[i], list);
            } else {
                maps.get(numbers[i]).add(i + 1);
            }
        }
        
        Arrays.sort(numbers);
        
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ret[0] = maps.get(numbers[left]).get(0);
                
                if (numbers[left] == numbers[right]) {
                    ret[1] = maps.get(numbers[right]).get(1);
                } else {
                    ret[1] = maps.get(numbers[right]).get(0);
                }
                
                if (ret[0] > ret[1]) {
                    int tmp = ret[0];
                    ret[0] = ret[1];
                    ret[1] = tmp;
                }
                
                return ret;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }
}
