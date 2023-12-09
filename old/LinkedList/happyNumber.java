class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(fast != slow);
        
        if(slow == 1){
            return true;
        }
        return false;
    }
    
    private int findSqare(int number) {
        int ans = 0;
        while(number > 0) {
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    
}