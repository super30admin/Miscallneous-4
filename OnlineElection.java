package misc4;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
	//Time Complexity : O(log n), where n is length of times array
	//Space Complexity : O(n), for HashMao
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Map<Integer, Integer> votes;
    Map<Integer, Integer> leader;
    int[] times;
    public OnlineElection(int[] persons, int[] times) {
        votes = new HashMap<>();
        leader = new HashMap<>();
        this.times = times;
        int leadPerson = 0;
        
        for(int i=0; i<persons.length; i++) {
            int currPerson = persons[i];
            int currTime = times[i];
            
            votes.put(currPerson, votes.getOrDefault(currPerson, 0) + 1);
            if(currPerson != leadPerson) {
                if(votes.get(currPerson) >= votes.get(leadPerson))
                    leadPerson = currPerson;
            }
            
            leader.put(currTime, leadPerson);
        }
    }
    
    public int q(int t) {
        if(leader.containsKey(t))
            return leader.get(t);
        
        int low = 0;
        int high = times.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(times[mid] > t)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return leader.get(times[high]);
    }
}
