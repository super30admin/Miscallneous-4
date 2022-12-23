class TopVotedCandidate {

    Map<Integer, Integer> leaders;
    Map<Integer, Integer> countMap;
    int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap<>();
        countMap = new HashMap<>();
        time = times;
        int leader = 0;
        for(int i=0;i<persons.length;i++){
            int p = persons[i];
            int t = times[i];
            countMap.put(p, countMap.getOrDefault(p,0)+1);
            if(countMap.get(p)>=countMap.get(leader)){
                leader = p;
            }
            leaders.put(t, leader);
        }
    }
    
    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);
        // binary search
        int l = 0, h = time.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(time[mid]>t){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return leaders.get(time[h]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

// Time Complexity - O(logn) or O(1)
// Space Complexity - O(n)
