// Time Complexity : The time complexity is O(logn) where n is the length of the array
// Space Complexity : Te space complexity is O(n) where n is the length of the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class TopVotedCandidate {

    Map<Integer,Integer> leaders;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap<>();
        this.times = times;

        Map<Integer,Integer> freq = new HashMap<>();
        int leader = persons[0];

        // At every point of time, find the leader
        for(int i=0;i<persons.length;i++){
            freq.put(persons[i],freq.getOrDefault(persons[i],0)+1);
            if(freq.get(persons[i]) >= freq.get(leader)){
                leader = persons[i];
            }
            leaders.put(times[i],leader);
        }
    }

    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);

        int low = 0;
        int high = times.length-1;

        //get the closest time by doing binary search
        while(low <= high){
            int mid = (high-low)/2 + low;

            if(times[mid] < t){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return leaders.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */