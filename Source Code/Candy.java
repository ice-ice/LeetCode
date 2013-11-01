public class Solution {
    public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (ratings.length == 0) return 0;
        
        int total = 1, lastNotSatisfied = 0, last = ratings[0], current = 0, lastCandy = 1, currentCandy, lastLast = 1, lastSecond = 1;
        
        for (int i = 1; i < ratings.length; i++) {
            current = ratings[i];
            if (current < last) {
                if (lastCandy == 1) {
                    total += i - lastNotSatisfied + 1;
                    if (lastSecond < lastLast - 1) {
                        lastSecond++;
                        total--;
                    }
                } else {
                    lastLast = lastCandy;
                    lastSecond = 1;
                    total++;
                }
                currentCandy = 1;
            } else {
                lastNotSatisfied = i;
                if (current == last) {
                    currentCandy = 1;
                } else {
                    currentCandy = lastCandy + 1;
                }
                total += currentCandy;
                lastLast = currentCandy;
                lastSecond = lastLast - 1;
            }
            last = current;
            lastCandy = currentCandy;
        }
        
        return total;
    }
}
