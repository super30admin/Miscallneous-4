//time complexity: O(logn)
//space complexity: O(1)
class TopVotedCandidate {
    HashMap<Integer,Integer> time;
    HashMap<Integer,Integer> count;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        time=new HashMap<>();
        count=new HashMap<>();
        this.times=times;
        int leader=-1;
        int max=0;
        for(int i=0;i<persons.length;i++)
        {
            if(count.get(persons[i])==null)
                count.put(persons[i],0);
            count.put(persons[i],count.get(persons[i])+1);
            if(count.get(persons[i])>=max)
            {
                leader=persons[i];
                max=count.get(persons[i]);
            }
            time.put(times[i],leader);
        }
    }
    
    public int q(int t) {
        if(time.get(t)!=null)
            return time.get(t);
        int low=0;
        int high=times.length-1;
        while(low<=high)
        {
            int mid= low + (high-low)/2;
            if(times[mid]>t)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
         return time.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */