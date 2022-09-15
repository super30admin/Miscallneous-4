class TopVotedCandidate {
    int maxVotes = 0;
    int maxPerson =-1;
    HashMap<Integer,Integer> peopleVotes;
    HashMap<Integer,Integer> timeVotes;
    int [] time;
    public TopVotedCandidate(int[] persons, int[] times) {
        peopleVotes = new HashMap<>();
        timeVotes =  new HashMap<>();
        time =times;
        for(int i =0;i<persons.length;i++)
        {
            int person = persons[i];
            int time = times[i];
            int val = peopleVotes.getOrDefault(person,0);
            val++;
            if(val>=maxVotes)
            {   maxPerson= person;
                maxVotes = val;
                timeVotes.put(time,person);
                peopleVotes.put(person,val);
            }
            else
            {  peopleVotes.put(person,val);
                timeVotes.put(time,maxPerson);
            }
        }

        
    }
    
    public int q(int t) {
        if(timeVotes.containsKey(t))
            return timeVotes.get(t);
        
       int low =0;
       int high = time.length-1;
       while(low<=high)
       {
            int mid = low + (high-low)/2;
           if(time[mid]>t)
               high = mid-1;
           if(time[mid]<t)
           {
               if(mid == time.length-1 || time[mid+1]>t)
                   return timeVotes.get(time[mid]);
               else
                   low = mid+1;
               
           }
           
           
       }
        return -1;
        
        
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */