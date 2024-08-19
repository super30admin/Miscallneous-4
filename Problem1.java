package Misc-4;
// TC: O(N*logN)
// SC: O(N)
public class Problem1 {
    Map<Integer, Integer> leaderMap;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.leaderMap = new HashMap<>();
        this.times = times;
        Map<Integer, Integer> countMap = new HashMap<>();
        int leader = persons[0];
        for(int i=0;i<persons.length;i++){
            int person = persons[i];
            int time = times[i];
            countMap.put(person, countMap.getOrDefault(person,0)+1);
            if(countMap.get(person) >= countMap.get(leader)){
                leader = person;
            }
            leaderMap.put(time, leader);
        }
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        int low = 0;
        int high = times.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(times[mid]>t){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return leaderMap.get(times[high]);
    }
}
