class TopVotedCandidate {
    HashMap<Integer, Integer> leaders;
    int [] time;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        leaders = new HashMap<>();
        time = times;
        
        HashMap<Integer, Integer> count = new HashMap<>();
        
        int leader = persons[0];
        
        for(int i = 0; i < times.length; i++){
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if(count.get(persons[i]) >= count.get(leader)){
                leader = persons[i];
            }
            leaders.put(times[i], leader);
        }
        
    }
    
    public int q(int t) {
        if(leaders.containsKey(t)) return leaders.get(t);
        
        int low = 0; int high = time.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(time[mid] < t){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return leaders.get(time[high]);
    }
}


//TC: O(N)
//SC: O(N)
