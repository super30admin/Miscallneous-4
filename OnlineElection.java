import java.util.HashMap;

// TC - O(logn) for binary search if the time does not exist in the times array.
// If the time exists in the times array then it will be O(1) constant time.
// Here we are not considering the time taken to iterate over the times array as we are doing that in the constructor.
// SC : O(n) where n = length of times array
class TopVotedCandidate {
    HashMap<Integer,Integer> leaders;
    HashMap<Integer,Integer> countMap;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap<>();
        countMap = new HashMap<>();
        time = times;
        int leader = 0;

        for(int i=0; i<persons.length; i++){
            int p = persons[i];
            int t =  times[i];
            countMap.put(p, countMap.getOrDefault(p,0) +1);
            if(countMap.get(p) >= countMap.get(leader)){
                leader=p;
            }
            leaders.put(t,leader);
        }
    }

    public int q(int t) {
        if(leaders.containsKey(t))  return leaders.get(t);
        int low=0, high = time.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(time[mid]>t){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return leaders.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */