// Time Complexity: O(logn)
// Space Complexity: O(M) where m is the length of times as worst case
class TopVotedCandidate {

    HashMap<Integer, Integer> countVotes;
    HashMap<Integer, Integer> leaders;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        int leader = persons[0];
        countVotes = new HashMap<>();
        leaders = new HashMap<>();
        this.times = times;

        for (int i=0;i<persons.length;i++) {
            countVotes.put(persons[i], countVotes.getOrDefault(persons[i], 0) + 1);

            if(countVotes.get(leader) <= countVotes.get(persons[i])) {
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }

    }

    public int q(int t) {
        if (leaders.containsKey(t)) {
            return leaders.get(t);
        }

        // Else perform binary search
        int low = 0;
        int high = times.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if(t>times[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
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