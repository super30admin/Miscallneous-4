// Time Complexity : O(n) for topVotedCandidate function, O(logn) for q;
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class TopVotedCandidate {
public:
    vector<int>times;
    unordered_map<int,int>voteCount;
    unordered_map<int,int>leaders;
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        this->times = times;
        int n = persons.size();
        int leader = persons[0];
        
        for(int i = 0;i<n;i++)
        {
            voteCount[persons[i]]++;
            if(voteCount[persons[i]]>=voteCount[leader]){
                leader = persons[i];
            }
            leaders[times[i]] = leader;
        }
    }

    
    int q(int t) {
        if(leaders.find(t)!=leaders.end()){
            return leaders[t];
        }
        auto it = lower_bound(times.begin(),times.end(),t);
        it--;
        return leaders[*it];
    }
};

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */