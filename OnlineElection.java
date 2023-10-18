import java.util.HashMap;

// Time Complexity : O(n) for constructor and O(log n) for getting the leager
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class TopVotedCandidate {
    int[] times;
    HashMap<Integer, Integer> leaderMap;
    HashMap<Integer, Integer> countMap;
    int leader;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leaderMap = new HashMap<>();
        countMap = new HashMap<>();
        leader = persons[0];

        for(int i=0; i<persons.length; i++)   //O(n)
        {
            countMap.put(persons[i], countMap.getOrDefault(persons[i],0)+1);

            if(countMap.get(persons[i]) >= countMap.get(leader)){
                leader = persons[i];
            }

            leaderMap.put(times[i],leader);
        }
    }

    public int q(int t) {  // O(log n)
        if(leaderMap.containsKey(t)) return leaderMap.get(t);

        int low = 0; int high = times.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(times[mid] > t){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return leaderMap.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */