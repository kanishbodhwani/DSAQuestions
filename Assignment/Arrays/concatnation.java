class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] a=new int[2*nums.length];
        int i=0,j=0;
        while(j<a.length)
        {
            a[j++]=nums[i++];
            if(i==nums.length)
                i=0;
        }
        return a;  
    }
}