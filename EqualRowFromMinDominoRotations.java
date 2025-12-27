// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : The intuition is, the target can be either tops[0] or bottoms[0] because it should appear in all positions in either tops or
// bottoms. We check if target is not present in both arrays at same index we return. If it's present in either of two arrays, we increase
// the count accordingly and return the minimum of it.

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int res = helper(tops, bottoms, tops[0]);//check if target is tops[0]
        if(res != -1){
            return res;
        }
        return helper(tops, bottoms, bottoms[0]); //target will be bottoms[0]

    }

    private int helper(int[] tops, int[] bottoms, int target) {
        int i = 0;
        int topCount = 0;
        int botCount = 0;
        while (i < tops.length) {
            if(tops[i] != target && bottoms[i] != target){ //target is not in both arrays
                return -1;
            }
            else if (tops[i] != target) { //swap to tops is possible
                topCount++;
            } else if (bottoms[i] != target) { //swap to bottoms is possible
                botCount++;
            }
            i++;
        }
        return Math.min(topCount, botCount); //return the min
    }
}