// Problem 911. Online Election
// Time Complexity : Constructor - O(N) , Query - O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class TopVotedCandidate {
    private HashMap<Integer, Integer> leadersMap;
    private int[] times;
    private HashMap<Integer, Integer> countMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leadersMap = new HashMap<>();
        this.countMap = new HashMap<>();
        int leader = -1;
        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            int t = times[i];
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
            if (leader == -1 || countMap.get(p) >= countMap.get(leader)) {
                leader = p;
            }
            leadersMap.put(t, leader);
        }
    }
    
    public int q(int t) {
        int left = 0, right = times.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times[mid] > t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leadersMap.get(times[right]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */