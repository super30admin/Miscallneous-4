/*
Will use 1 hashmap to save the vote counts and another to save who is 
the leader at particular time.
for quieries, we can first check if the query time is present in map.
if yes, return from map. Else since times are strcitly increasing we can do 
binary search to get the closest one

TC : O(1) in best case for query if the query time 't' is present. Else it is : log n , where n is times array length for binary search.

SC: O(n), for hashmaps 

*/
    
class TopVotedCandidate {
    HashMap<Integer, Integer> leaderMap;
    int currLeader;
    int[]times;
    HashMap<Integer,Integer> voteCount;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        //initialiaitons
        this.leaderMap = new HashMap<>();
        this.voteCount = new HashMap<>();
        this.times = times;
        this.currLeader = persons[0]; //initially lets assume the first person is leader
        
        //record the vote counts and also record leader
        for(int i = 0;i < persons.length;i++){
            if(!voteCount.containsKey(persons[i])){
                voteCount.put(persons[i], 0);
            }
                int newCount = voteCount.get(persons[i])+1;
                voteCount.put(persons[i],newCount);
                //updating the leader here if count >= leader
                if(newCount >= voteCount.get(currLeader)){
                    currLeader = persons[i];
                }
            
            //add to leaderMap the latest leader and time
            leaderMap.put(times[i] , currLeader);
        }
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t))return leaderMap.get(t);
        
        //else do binary search here
        int low = 0;
        int high = times.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(times[mid] < t){
                low = mid+1;
            }else{
                high = mid-1;
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