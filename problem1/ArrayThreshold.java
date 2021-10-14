// Time Complexity : O(nlog(n)), n -> Number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.Arrays;

public class ArrayThreshold {
	public float findThreshold(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);
		int n = nums.length;

		float threshold = target / n;

		for (int i = 0; i < n; i++) {
			if (nums[i] < threshold) {
				float diff = threshold - nums[i];
				threshold += (diff / (n - i - 1));
			}
		}

		return threshold;
	}

	public static void main(String[] args) {
		ArrayThreshold obj = new ArrayThreshold();

		int[] nums = { 6, 5, 1, 8, 7, 4, 3, 2 };
		int target = 24;

		System.out.println("Threshold value = " + obj.findThreshold(nums, target));
	}

}
