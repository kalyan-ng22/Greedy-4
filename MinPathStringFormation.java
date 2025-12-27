// Time Complexity : O(n log k) - k is the average occurrence of each character of source string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We store the occurences of each character of source in a HashMap. Then we start looping over the characters of target string
// and find the first index that is greater than currence pointer of source string. To achieve this, we perform binary search on the
// source string's character's occurences list. If the index is not found, it means we need to start over again and increment the subsequence
// count. If found, we increment the source and target strings pointers and continue the logic.

class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int tp = 0;
        int sp = 0;
        int n = target.length();
        int m = source.length();
        int res = 0;
        for(int i = 0;i<m;i++){ // add the occurences of each char of source to hashmap
            char ch = source.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        while(tp < n){
            List<Integer> indexes = map.get(target.charAt(tp)); //get the occurences of each target char in hashmap
            if(indexes == null){
                return -1;
            }
            int idx = binarySearch(indexes, sp); //find the first index ≥ sp
            if(idx == indexes.size()){ //end of list so increment subsequence count
                res++;
                sp = 0;
            } else{
                sp = indexes.get(idx) + 1; //increment sp
                tp++; //increment tp
            }
        }
        return res+1;
    }

    private int binarySearch(List<Integer> li, int target){
        int low = 0;
        int high = li.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if (li.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
