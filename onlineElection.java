// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Solution: We use 2 maps, 1) to store people and their votes 2) to store who is the leader at that perticular time
class TopVotedCandidate {
    int[] times;
    Map<Integer, Integer> votes = new HashMap<>();
    Map<Integer, Integer> leaders = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        if (persons == null || persons.length == 0 || times == null || times.length == 0) return;

        this.times = times;
        int leader = persons[0];
        for (int i=0; i<persons.length; i++) {
            votes.put(persons[i], votes.getOrDefault(persons[i], 0) + 1);

            if (votes.get(persons[i]) >= votes.get(leader)) {
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
    }

    public int q(int t) {
        if (leaders.containsKey(t)) return leaders.get(t);

        int low = 0, high = times.length-1;
        // binary search to find the time less than t which is in the map
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (times[mid] < t) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return leaders.get(times[high]);
    }
}