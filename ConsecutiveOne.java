/*
sliding window technique.
TC : O(N), where N is the nums array length
SC :O(1)

we keep count of zero included in each window. 
Whenver the count goes below k, we record the window size since it the max number of zero we can swap

*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 0 || nums == null)return 0;
        
        int left = 0;
        
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0){
                k--;
            }
            if(k < 0){
                if(nums[left] == 0)k++;
                left++;
            }
        }
        
        return nums.length - left;
    }
}