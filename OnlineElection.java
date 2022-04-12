// Time Complexity :  O(logn) if key is not present in map, if its there - O(1)
// Space Complexity : O(n) ; n - length of times array
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
    Map<Integer, Integer> countMap;
    Map<Integer, Integer> leaderMap;
    int[] time;

    public void TopVotedCandidate(int[] persons, int[] times) {
        countMap = new HashMap<>();
        leaderMap = new HashMap<>();
        time = times;
        int leader = persons[0];
        for(int i = 0 ; i < times.length ;i++){
            countMap.put(persons[i], countMap.getOrDefault(persons[i], 0) + 1);
            //compare no. of votes of curr person with existing leader
            //handles updating leader to most recently voted when votes are same
            if(countMap.get(persons[i]) >= countMap.get(leader)){
                leader = persons[i];
            }
            leaderMap.put(time[i], leader);
        }
    }

    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        //binary search to find closest time
        int low = 0, high = time.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(time[mid] > t){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return leaderMap.get(time[high]);
    }
}
