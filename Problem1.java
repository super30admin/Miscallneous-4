/*

We are given a times array and a persons array, the time at index i represent the time the vote was casted and the person at the index i represent the person the vote 
was counted for. 
We will be given quries of times (which may or may not present in the times array), we need to tell which person was leading at that approximate or absolute time

Intuition:

Suppose the times array contains {10,20,30} mins, we can be given a query like 13 , which asks, which person was winning at 13. Obviosuy the 13 is not in the array
so we need to take the time which is just smallest (closet behind) that timestamp and return the leader.

We will start with the constructor, we will use a hashmap to maintain the person to vote count integer, we will keep maintaining a max, if any persons count becomes larger than the prev max, we will record the person as leader on the result array on the ith index, wich represents that till ith time , the person on result i is the leader.

Then when we are given the queru for time t, we will be finding the index of value <= to query , and then return the value of the index on the result array as our answer


Time : O (log(n))

Space: O(n)

*/
class TopVotedCandidate {

    int[] result;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        
        result = new int[persons.length];
        this.times =times;
        int leader =0; // we will take 0 as an initial leader
        int max =0;
        HashMap<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        // keep a max, as soon as the count of max changes , make that person the leader and change the max
        for(int i=0;i<persons.length;i++){
            if(!countMap.containsKey(persons[i])){
                countMap.put(persons[i],0);
            }
            int curCount = countMap.get(persons[i]);
            curCount++;
            countMap.put(persons[i], curCount);
            // If the count of this person is greater or equal to the prev max, make this person a leader
            if(curCount >= max){
                leader = persons[i];
                max = curCount; // change the max
            }
            result[i] = leader;
        }

        

    }
    
    public int q(int t) {

        int idx = getlowIdxBs(times, t);
        if(idx == result.length){
            return result[result.length-1];
        }
        return result[idx];
        
    }
    // on a given time, we need to find the time which is just smaller or equal to that in the times array
    private int getlowIdxBs(int[] arr, int val){
        int low =0, high = arr.length -1;

        while(low <= high){
            int mid = (high+low)/2;
             if(arr[mid] > val){
                 high = mid -1;
             }
             else{ 
                 low = mid +1;
             }

        }

        return high; // low would cross high, which means high would come to low position and low would come to high psoition
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */