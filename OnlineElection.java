//Binary Search + HashMap
//TC:O(logN)
//SC:O(N)
//Did it run successfully on Leetcode?:Yes
class TopVotedCandidate {
    HashMap<Integer, Integer> leaderAtThisTime;
    int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        leaderAtThisTime = new HashMap();
        time = times;
        HashMap<Integer, Integer> voteCount = new HashMap();
        int leader = -1;
        for ( int i = 0; i < persons.length; i++){
            voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || voteCount.get(persons[i]) >= voteCount.get(leader)){
                leader = persons[i];     
            }     
            leaderAtThisTime.put(times[i], leader);
          }
    }
    
    public int q(int t) {
        if (leaderAtThisTime.containsKey(t)){
            return leaderAtThisTime.get(t);
        }
       //Binary Search on times array (as it is sorted)
        int low = 0;
        int high = time.length-1;
        while ( low <= high){
            int mid = low + (high-low)/2;
            // if (time[mid] == t)
            //     return leaderAtThisTime.get(t);
            if (time[mid] < t){
                low = mid + 1;
            } else{
                high = mid - 1;
            }  
        }
        return leaderAtThisTime.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
