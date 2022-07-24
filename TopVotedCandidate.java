import java.util.HashMap;
import java.util.Map;

class TopVotedCandidate {

    Map<Integer, Integer> countVotes; // candidate to votes mapping
    Map<Integer, Integer> leaders;    // who is the leader at the given time
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        countVotes = new HashMap<>();
        leaders = new HashMap<>();
        this.times = times;
        int leader = persons[0];

        for(int i=0; i < times.length; i++) {
            countVotes.put(persons[i], countVotes.getOrDefault(persons[i],0) + 1);
            if(countVotes.get(persons[i]) >= countVotes.get(leader)){
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
    }

    // TC : For few keys, it will return in O(1). For a few it will take O(log n)
            // Asymptotically O(log n)
    // SC : O(n)
    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);

        int low = 0;
        int high = times.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(t > times[mid]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return leaders.get(times[high]);
    }
}


/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */