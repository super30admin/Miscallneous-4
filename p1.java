// Time Complexity for q :O(log(n)) where n is the length of times
// Space Complexity for q: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class TopVotedCandidate {
    HashMap<Integer, Integer> map;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        map = new HashMap<>();
        int winner = -1;
        int max = -1;
        HashMap<Integer, Integer> fmap = new HashMap<>();
        //update frequency map and winner at given time
        for(int i=0; i<persons.length; i++){
            int person = persons[i];
            int time = times[i];
            fmap.put(person, fmap.getOrDefault(person, 0)+1);
            if(max <= fmap.get(person)){
                winner = person;
                max = fmap.get(person);
            }
            map.put(time, winner);
        }
    }
    
    public int q(int t) {
        //if time is there in hashmap, return tha
        if(map.containsKey(t)){
            return map.get(t);
        }
        //if time is not there in hashmap, get the floor value of the time
        //binary search
        int low = 0;
        int high = times.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(times[mid] > t){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return map.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */