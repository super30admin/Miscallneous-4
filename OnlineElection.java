class TopVotedCandidate {
    HashMap<Integer,Integer> leaderMap;
    HashMap<Integer, Integer> countMap;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.leaderMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.times= times;
        int leader= persons[0];
        for(int i=0;i<persons.length;i++){
            int person = persons[i];
            int time = times[i];
            countMap.put(person,countMap.getOrDefault(person, 0)+1);
            if(countMap.get(person)>= countMap.get(leader)){
                leader= person;
            }
            leaderMap.put(time,leader);
        }
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        int low=0, high= times.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(times[mid]>t){
                high= mid -1 ;

            }else{
                low=mid+1;
            }
        }


        return leaderMap.get(times[high]);
    }
}

