//TC : O(1) or O(Log N) for query() and O(N) for initialization of maps // As we are using 2 maps and additional time array

class TopVotedCandidate {
    HashMap<Integer, Integer> timeToLeader; // To store at which time, which candidate is the leader
    HashMap<Integer, Integer> count; // Here we are storing the count of votes a candidate is having
    int[] time; 
    
    public TopVotedCandidate(int[] persons, int[] times) {
        time = times;
        timeToLeader = new HashMap<>();
        count = new HashMap<>();
        int leader = 0; //curr leader
        
        for(int i = 0; i< times.length; i++){
            int candidate = persons[i];
            int t = times[i];
            
            count.put(candidate, count.getOrDefault(candidate, 0) + 1); // UPDATING A Frequency of votes for a candidate
            
            int ct = count.get(candidate);
            if(ct >= count.get(leader)){
                leader = candidate;
            }
            
            timeToLeader.put(t, leader);// Cuurent leader at time t
        }
    }
    
    public int q(int t) { // If t in in map -- O(1) otherwise time will be O(Log N base 2)
        if(timeToLeader.containsKey(t)) return timeToLeader.get(t); 
        //If t is not in map, doing binary search of t in COUNT MAP
        int l = 0, h = time.length - 1;
        
        while(l <= h){
            int m = l + (h - l)/2;
            
            if(time[m] > t){
                h = m - 1;
            } else{
                l = m + 1;
            }
        }
        
        return timeToLeader.get(time[h]);
    }
}
