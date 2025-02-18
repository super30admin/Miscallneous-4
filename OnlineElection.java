// Approach : 
// 1. Maintain a map to keep vote count of each candidate. This will help to determine who is the majority (leader)
// 2. Since they are asking leader at every time iterval , we need to create another map of time and the value is who the leader at that time.
// 3. Initially consider the leader as first person and at every stage of counting the votes check if the vote count of incoming 
// person is greater than already existing leader then make him the new leader and maintain the leader at that time in the leader map.
// 4. When query at certain time to find the leader , look up the leader map with the time given and return if you find it.
// If the query time is not present in the leaderMap then do a Binary search on the times array and determine the leader at that time. 

// Time : O(logn)
// Space : 
class TopVotedCandidate {

    int[] times;
    HashMap<Integer , Integer> countMap;
    HashMap<Integer,Integer> leaderMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.countMap = new HashMap<>();
        this.leaderMap = new HashMap<>();
        int leader= persons[0];
        this.times = times;
        for(int i=0;i<persons.length;i++){
            countMap.put(persons[i],countMap.getOrDefault(persons[i], 0)+1);
            if(countMap.get(persons[i]) >= countMap.get(leader)){
                leader = persons[i]; // new leader
            }
            leaderMap.put(times[i],leader);
        }  
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        // if you are quering for the leader in a time frame not in leader HashMap
        // we can perform binary search on times array and then look up the closest time in leader map and return the leader.
        int low =0;
        int high = times.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(times[mid] > t){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }

        // low and high crosses each other and then high will be on the lower side and low already passed high - Example : 12 (time)
        return leaderMap.get(times[high]);
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */