/* Time Complexity : O(log n) 
 *   n - length of persons/times array */
/* Space Complexity : O(n) 
 *   n - size of leaders map */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class TopVotedCandidate {
    int[] time;
    HashMap<Integer, Integer> leadersMap;
    public TopVotedCandidate(int[] persons, int[] times) {
		//Maintain two maps of frequency (countMap) and time to leader (leadersMap)
        int n = persons.length;
        this.time = times;
        this.leadersMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int leader = 0;
        for(int i = 0; i < n; i ++){
            int t = times[i];
            int p = persons[i];
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
            if(countMap.get(p) >= countMap.get(leader)){
                leader = p;
            }
            leadersMap.put(t, leader);
        }
    }
    
    public int q(int t) {
		//if t is present in the map return the leader else perform binary search on the times array
        if(leadersMap.containsKey(t)){
            return leadersMap.get(t);
        }
        int low = 0; int high = time.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(time[mid] > t){
                high = mid - 1;
            } else {
                low = mid + 1;
            }            
        }
        return leadersMap.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */