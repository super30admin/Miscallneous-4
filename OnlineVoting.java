class TopVotedCandidate {

    //Time Complexity: 0(logn) where n is the no of elements in times array. This is the worst case. But in average case I have 0(1). I will not consider addition in hashmap as it is called in constructor
    //Space Complexity : 0(n)

    HashMap<Integer, Integer> votes;    //this hashmap keeps a track of hwo many votes a candidate has received in total
    HashMap<Integer, Integer> leaders;  //this keeps a track of who is the leader at a give time from times array
    int [] times;   //this is given to me. I am making it global because I will require it

    public TopVotedCandidate(int[] persons, int[] times) {
        votes = new HashMap<>();
        leaders = new HashMap<>();
        int leader = persons[0];    //I will require a variable leader to compute who is the leader at a given time. Initially i set it to the 1st person
        this.times = times; //making local variable global

        for(int i = 0; i < persons.length; i++){
            votes.put(persons[i], votes.getOrDefault(persons[i], 0) + 1);   //adding the votes to the person as I traverse along the array
            if(votes.get(persons[i]) >= votes.get(leader)){ //checking if the vote of current person at this time instance is greater than the leader
                leader = persons[i];    //I will assign this person to be the leader.
            }
            leaders.put(times[i], leader);  //then put the current time along with the current leader in my hashmap
        }
    }

    public int q(int t) {
        if(leaders.containsKey(t)){ //If the time exists in my hashmap, then I can directly query my hashmap and return the leader at given time
            return leaders.get(t);
        }

        int low = 0;    //otherwise I do a binary search
        int high = times.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(t > times[mid]){ //if the given time is greater than the time in my times array
                low = mid + 1;  //I will need to look at the right side of the array
            }
            else{
                high = mid - 1; //otherwise I look at the left
            }
        }

        return leaders.get(times[high]);    //at the end, My high will contain the nearest time which inturn will contain the leader in my leader map which I return
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */