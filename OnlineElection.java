//TC : O(logn)
//SC : O(n)
class TopVotedCandidate {
    private HashMap<Integer, Integer> countMap = new HashMap<>();
    private HashMap<Integer, Integer> leaderMap = new HashMap<>();
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        int leader = 0;
        this.time = times;
        this.countMap = new HashMap<>();
        this.leaderMap = new HashMap<>();

        for(int i = 0;  i < times.length; i++){
            int time = times[i];
            int person = persons[i];
            countMap.put(person, countMap.getOrDefault(person, 0)+1);
            if(countMap.get(person) >= countMap.get(leader)){
                leader = person;
            }
            leaderMap.put(time, leader);
        }
    }

    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);

        // else bs on time array
        int low = 0;
        int high = time.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(time[mid] > t){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return leaderMap.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */