// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take two hashMap, one to get cnt of the votes, and one to get time to the lead vorter, take a variable lead which will have th lead haing max count, for the search, if the index present in time hashmap, them return else do the binary search on the time array, and get the high pointer's leading candidate
// Your code here along with comments explaining your approach
class TopVotedCandidate {
    int lead = 0;
    HashMap<Integer, Integer> count;
    HashMap<Integer, Integer> vote;
    int [] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        count = new HashMap<>();
        vote = new HashMap<>();
        lead = persons[0];
        this.times = times;
        for(int i = 0; i < times.length; i++){
            int time = times[i];
            int person = persons[i];
            count.put(person, count.getOrDefault(person, 0)+1);
            if(count.get(lead) <= count.get(person)){
                lead = person;
            }
            vote.put(time, lead);
        }
    }

    public int q(int t) {
        if(vote.containsKey(t)) return vote.get(t);
        int low = 0;
        int high = times.length -1 ;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(t > times[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return vote.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
