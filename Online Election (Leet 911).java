/*
Time: One time O(n), for query O(log n)
Space: One time O(n), for query O(n)
Executed Successfully: Yes
*/

class TopVotedCandidate {
    HashMap <Integer, Integer> countmap;
    HashMap <Integer, Integer> leadermap;
    int leader;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.countmap = new HashMap<>();
        this.leadermap = new HashMap<>();
        this.leader = persons[0];
        this.leadermap.put(times[0], persons[0]);
        this.countmap.put(persons[0], 1);
        this.times = times;
        
        for(int i = 1; i < persons.length; i++){
            if(!countmap.containsKey(persons[i])){
                countmap.put(persons[i],1);
            }else{
                countmap.put(persons[i],countmap.get(persons[i])+1);
            }
            if (countmap.get(persons[i]) >= countmap.get(leader)){
                leader = persons[i];
            }
            leadermap.put(times[i], leader);
        }
        
    }
    
    public int q(int t) {
        if (leadermap.containsKey(t)){
            return leadermap.get(t);
        }
        
        // binary search
        int l = 0, r = times.length-1;
        while (l <= r){
            int mid = l+(r-l)/2;
            if(times[mid] > t){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return leadermap.get(times[r]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
