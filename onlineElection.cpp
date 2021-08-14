//Time: O(logn) in worst case for q function
//Space: O(n) for two hash maps

class TopVotedCandidate {
    unordered_map<int,int> leader; //Time : Winner
    vector<int> persons;
    vector<int> times; 
public:
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        unordered_map<int,int> count; // Person : Votes
        this->persons = persons;
        this->times = times;
        int currLeader = persons[0];
        for(int i = 0; i < persons.size();i++){
            count[persons[i]]++;
            if(count[persons[i]] >= count[currLeader]){
                currLeader = persons[i];
            }
            leader[times[i]] = currLeader;
        }
    }
    
    int q(int t) {
        if(leader.count(t)) return leader[t];
        //binary search to find the time before it 
        int size = times.size()-1;
        int low  = 0;
        int high = size;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(times[mid] > t) high = mid-1;
            else low = mid+1;
        }
        return leader[times[high]];
    }
};

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */