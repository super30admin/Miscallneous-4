// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class TopVotedCandidate {
    int[] time;
    HashMap<Integer,Integer> timeMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        this.timeMap = new HashMap<>();
        this.time = times;
        int leader = 0;
        for(int i = 0; i < persons.length; i++){
            int p = persons[i];
            int t = times[i];
            countMap.put(p,countMap.getOrDefault(p,0)+1);
            if(countMap.get(p) >= countMap.get(leader)){
                leader = p;
            }
            timeMap.put(t,leader);
        }
    }
    
    public int q(int t) {
        if(timeMap.containsKey(t))
            return timeMap.get(t);
        int lo = 0; int hi = time.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(time[mid] > t){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return timeMap.get(time[hi]);
    }
}