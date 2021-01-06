class TopVotedCandidate {
public:
    unordered_map<int,int> votesCount, leaderMap;
    vector<int> time;
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        int leader=-1;
        time=times;
        for (int i=0;i<persons.size();i++) {
            votesCount[persons[i]]++;
            if (i==0 || votesCount[leader]<=votesCount[persons[i]]) {
                leader=persons[i];
            }
            leaderMap[times[i]]=leader;
        }
        
    }
    
    int q(int t) {
        if (leaderMap.find(t)!=leaderMap.end()) return leaderMap[t]; 
        int low=0;
        int high=time.size()-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (leaderMap.find(t)!=leaderMap.end()) return leaderMap[t]; 
            else if (time[mid]<t) {
               low=mid+1; 
            } else {
               high=mid-1;
            }
        }
        return leaderMap[time[high]];
    }
};

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */