// Time Complexity: O(N+QlogN), where N is the number of votes, and Q is the number of queries.
// Space Complexity: O(N)
import java.util.*;
class TopVotedCandidate {
    private HashMap<Integer, Integer> count;
    private HashMap<Integer, Integer> leaders;
    private int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        count = new HashMap<>();
        leaders = new HashMap<>();
        time = times;
        int leader = persons[0];
        for(int i = 0; i < persons.length; i++) {
            int curr = persons[i];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            if(count.get(leader) <= count.get(curr)) {
                leader = curr;
            }
            leaders.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);
        // binary search
        int low = 0;
        int high = time.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(time[mid] < t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return leaders.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */