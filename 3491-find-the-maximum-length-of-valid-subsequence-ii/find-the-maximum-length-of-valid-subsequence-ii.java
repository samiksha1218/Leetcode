class Solution {
    public int maximumLength(int[] nums, int k) {
        // Initialize a 2D array to keep track of subarray lengths with modulo value
        int[][] subarrayLengths = new int[k][k];  
        int maxLength = 0;  // Variable to store the maximum length found

        // Iterate over each element in nums
        for (int num : nums) {
            int modValue = num % k;  // Compute the current number's modulo with k
          
            // Iterate over all possible modulo values from 0 to k-1
            for (int j = 0; j < k; ++j) {
                int requiredMod = (j - modValue + k) % k;  // Compute the required complement modulo

                // Update the subarray length by 1 for the current modulo configuration
                subarrayLengths[modValue][requiredMod] = subarrayLengths[requiredMod][modValue] + 1;

                // Update the maximum length found so far
                maxLength = Math.max(maxLength, subarrayLengths[modValue][requiredMod]);
            }
        }
        return maxLength;  // Return the maximum subarray length satisfying the condition
    }
}
