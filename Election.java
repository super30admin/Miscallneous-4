// Time Complexity : O(n)
// Space Complexity : O(nlogn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TopVotedCandidate {
    HashMap<Integer, Integer> votes = new HashMap<>();
    HashMap<Integer, Integer> leaders = new HashMap<>();  
    int times[];
    public TopVotedCandidate(int[] persons, int[] times) {
        if(persons == null || persons.length == 0){
            return;
        } 
        int leader = persons[0];
        this.times = times;

        for(int i =0; i< persons.length; i++){
            int person = persons[i];
            votes.put(person, votes.getOrDefault(person, 0)+1);
            if(votes.get(person) >= votes.get(leader)){
                leader = person;
            }
            leaders.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if(leaders.containsKey(t)){
            return leaders.get(t);
        }
        int low = 0;
        int high = times.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(times[mid] < t){
                low = mid + 1;
            }
            else{
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