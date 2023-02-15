// Time complexity: O (log n) where n is size of the input vector
// Space complexity: O(n) - candidate hashmap and leader at time t hashmap

/*
Use hashmaps to store the votes for each candidate and the leader at each time t

Use binary search to get the closest smallest time and return the value of the leader at that time t
*/

class TopVotedCandidate {
public:
    unordered_map<int, int> leaderAtTime;
    unordered_map<int, int> votes;
    vector<int> times;
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        int leader = persons[0];
        this->times = times;
        for(int i = 0; i<persons.size(); i++) {
            votes[persons[i]]++;
            if(votes[persons[i]] >= votes[leader])
                leader = persons[i];
            leaderAtTime[times[i]] = leader;
        }
    }
    
    int q(int t) {
        if(leaderAtTime.find(t) != leaderAtTime.end())
            return leaderAtTime[t];
        // binary search to get the closest smaller t from hashmap 
        // the lowest closest number is found in high when the loop exits
        vector<int> inputTimes = times;
        int low = 0;
        int high = times.size()-1;
        while(low <= high) {
            int mid = (high - low)/2 + low;
            if(t > times[mid])
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return leaderAtTime[times[high]];
    }
};

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */