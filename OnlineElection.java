// Time Complexity : O(logn) where n = length of times array
// Space Complexity : O(n) where n = length of times array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//911. Online Election (Medium) - https://leetcode.com/problems/online-election/
// Time Complexity : O(logn) where n = length of times array
// Space Complexity : O(n) where n = length of times array
class TopVotedCandidate {

    HashMap<Integer, Integer> leadersMap; // Time to Leading Person
    HashMap<Integer, Integer> countMap; // Persons to number of votes
    int[] times;
    
    public TopVotedCandidate(int[] persons, int[] times) {
        this.leadersMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.times = times;
        int leader = -1;
        int max = 0;
        
        for (int i = 0; i < times.length; i++) { // O(n)
            int person = persons[i];
            int time = times[i];
            
            // increase vote count
            countMap.put(person, countMap.getOrDefault(person, 0) + 1);
            
            // compare max votes to current person votes to determine leader
            if (countMap.get(person) >= max) {
                max = countMap.get(person);
                leader = person;
            }
            
            // populate map with time and respective leader
            leadersMap.put(time, leader);
        }
    }
    
    public int q(int t) {
        if (leadersMap.containsKey(t)) return leadersMap.get(t);
        
        int low = 0, high = times.length - 1;
        
        while (low <= high) { // O(logn)
            int mid = low + (high-low)/2;
            
            if (times[mid] < t) low = mid + 1;
            else high = mid - 1;
        }
        
        return leadersMap.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */