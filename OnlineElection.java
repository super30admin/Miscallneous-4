// Time Complexity : Constructor O(n), q method O(log n) where n is the length of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create hashmap of votes, simultaneously update the winners array with value as the winner at that time
// Now we can use the computed winners array to find the closest time and get its corresponding winner
class TopVotedCandidate {
    int[] timeArr;
    int[] winners;
    public TopVotedCandidate(int[] persons, int[] times) {
        winners = new int[persons.length];
        timeArr = times;
        int winnerVotes = -1; 
        int winner = -1;
        int i = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int person: persons){
            int votes = hm.getOrDefault(person, 0);
            votes++;
            hm.put(person, votes);
            if(votes >= winnerVotes){
                winnerVotes = votes;
                winner = person;
            }
            winners[i] = winner;
            i++;
        }
    }
    public int q(int t) {
        int l = 0;
        int h = timeArr.length - 1;
        while(l <= h){ 
            int mid = l + (h - l)/2;
            if(timeArr[mid] == t){
                return winners[mid];
            }
            if(t > timeArr[mid]){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return winners[l-1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */