//Time - O(log(len(times)))
//Space - O(n)
class TopVotedCandidate {
public:
    unordered_map<int, int> leaders;
    vector<int> time;
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        time = times;
        int leader = persons[0];
        unordered_map<int, int> count;
        for(int i =0;i<persons.size();i++){
            count[persons[i]]++;
            if(count[persons[i]]>=count[leader]){
                leader = persons[i];
            }
            leaders[times[i]] = leader;
        }
    }
    
    int q(int t) {
        if(leaders.find(t)!=leaders.end()){
            return leaders[t];
        }
        
        int high = time.size()-1, low = 0;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(t>time[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
            
        }
        
        return leaders[time[high]];
        
    }
};