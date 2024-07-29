//Time Complexity : log(n) - for binary search
//Space Complexity : O(n)
//Did this code run successfully on leetcode: Yes
//Any problem faced during coding this : No
class OnlineElection {
    int[] times;
    HashMap<Integer, Integer> leaderMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaderMap = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int leader = persons[0];

        for(int i = 0; i < times.length; i++) {
            int time = times[i];
            int person = persons[i];

            freqMap.put(person, freqMap.getOrDefault(person, 0)+1);
            if(freqMap.get(person) >= freqMap.get(leader)) {
                leader = person;
            }
            leaderMap.put(time, leader);
        }
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        int low = 0, high = times.length-1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(times[mid] > t) {
                high = mid -1;
            } else {
                low = mid+1;
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