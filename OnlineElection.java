// Time Complexity : O(log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TopVotedCandidate {
    int[] times;
    HashMap<Integer,Integer> leaderMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaderMap = new HashMap<>();

        HashMap<Integer,Integer> countMap = new HashMap<>();
        int leader = persons[0];

        for(int i=0;i< times.length;i++) {
            int person = persons[i];
            int time = times[i];
            countMap.put(person, countMap.getOrDefault(person,0)+1);

            if(countMap.get(person) >= countMap.get(leader)) {
                leader = person;
            }
            leaderMap.put(time, leader);
        }
    }

    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        int low =0;
        int high = times.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(times[mid] > t){
                high = mid-1;
            }else{
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