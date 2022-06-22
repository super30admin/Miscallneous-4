//Time Complexity O(P Log T)
//Space ComplexityO(P+T)
//LeetCode tested

import java.util.HashMap;

class TopVotedCandidate {
    HashMap <Integer, Integer> leaders = new HashMap<>();
    int [] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        time = times;
        HashMap <Integer, Integer> votesCount = new HashMap<>();
        int leader = -1;
        for(int i = 0; i < persons.length; i++){
            votesCount.put(persons[i], votesCount.getOrDefault(persons[i], 0) + 1);
            if(i == 0 || votesCount.get(leader) <= votesCount.get(persons[i])){
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
    }



    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);
        // Do a Binary Search on time array
        int low = 0;
        int high = time.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(time[mid] == t) return leaders.get(t);
            else if (time[mid] < t){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return leaders.get(time[high]);
    }
}
