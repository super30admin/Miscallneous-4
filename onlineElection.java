class TopVotedCandidate {
    HashMap<Integer, Integer> voteCountMap; // person : votes
    HashMap<Integer, Integer> timeLeadermap; // time : person
    int[] timesRecord;
    public TopVotedCandidate(int[] persons, int[] times) {
        voteCountMap = new HashMap<>();
        timeLeadermap = new HashMap<>();
        timesRecord = times;
        int leader = persons[0];  // initally set the leader to the first element
        
        for(int i=0; i<persons.length; i++){
            voteCountMap.put(persons[i], voteCountMap.getOrDefault(persons[i], 0)+1); // person : count+1
            
            // If person has more count, set the new leeder. If equal, set the recent leader
            if(voteCountMap.get(persons[i]) >= voteCountMap.get(leader)) 
                leader = persons[i];
            
            timeLeadermap.put(times[i], leader);  // time : leader till now
        }
    }
    
    public int q(int t) {
        // if exact time is asked, eg., 5, 10, 15 -> return from map
        if(timeLeadermap.containsKey(t)) return timeLeadermap.get(t); 
        
        // else do the binary search and see where time would have presented eg., t = 12
        int left = 0;
        int right = timesRecord.length-1;
        
        while(left <= right){
            int mid = left + (right-left) / 2;
            
            if(timesRecord[mid] > t)
                right = mid-1;
            else
                left = mid+1;
        }
        
        return timeLeadermap.get(timesRecord[right]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
