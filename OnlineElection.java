// Time Complexity : TopVotedCandidate: O(n) q: O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class TopVotedCandidate {
    Map<Integer, Integer> leaders;
    int time[];

    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int leader = persons[0];
        time = times;
        for(int i=0; i<persons.length; i++){
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if(count.get(leader) <= count.get(persons[i])){
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if(leaders.containsKey(t))
            return leaders.get(t);
        
        //Binary Search
        int low=0;
        int hi = time.length-1;
        while(low<=hi){
            int mid = low + (hi - low)/2;
            if(time[mid] > t){
                hi = mid-1;
            }else{
                low = mid+1;
            }
        }
        return leaders.get(time[hi]);
    }
}

