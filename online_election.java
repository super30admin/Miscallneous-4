// Time Complexity : O(logn) Binary search on answer (time)
// Space Complexity : O(n) - hashmap

class TopVotedCandidate {
    
    HashMap<Integer , Integer> timeToLeader;
    HashMap<Integer , Integer> candidateTomaxVotes;
    
    // times as global variable as we need to do binary search
    int[] time;
    
    public TopVotedCandidate(int[] persons, int[] times) {
    
        // This hashmap maps to the leader at that time
        timeToLeader = new HashMap<>();

        // canditate -> max votes
        candidateTomaxVotes = new HashMap<>();   
        
        time = times;

        int leader = persons[0];
        
        // Iterate through the person 
        for (int  i = 0; i < persons.length; i++){
            
            // if not found : add into the hashmap
            if (! candidateTomaxVotes.containsKey(persons[i])) {
                candidateTomaxVotes.put(persons[i] , 0);
            }
            
            // if already found the votes
            candidateTomaxVotes.put(persons[i] , candidateTomaxVotes.get(persons[i]) + 1 );
            
            // = also because we need the most recent vote
            if ( candidateTomaxVotes.get(persons[i]) >= candidateTomaxVotes.get(leader) ) {
                
                // make this as leader
                leader = persons[i];

            }

            // Add into the Hash map
            timeToLeader.put(times[i] , leader);
            
        }
        
        
    }
    
    public int q(int t) {
      
        if (timeToLeader.containsKey(t)){
            // most votes got by the candidate at the 't' time
            return timeToLeader.get(t);
        }
        
        int low = 0;
        int high = time.length - 1;
        
        while (low <= high){
            
            // calculate the mid
            int mid = low + (high - low)/2;
            
            if (time[mid] > t){
                // low region
                high = mid - 1;
            }
            else if (time[mid] <  t) {
                // high region
                low = mid + 1;
            } 
        }
        
        // most votes got by the candidate at the nearest 't' time
        return timeToLeader.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */