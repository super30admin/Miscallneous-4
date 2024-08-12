/*
Time: O(logN) per query
Space: O(n)

Using priority queue, maintain the top candidate at every timestamp in givevn times array (tie broken by most-recent first)

For a query, do binary search to find out the largest timestamp <= query time .. Return the top candidate of that timestamp
*/

class TopVotedCandidate {
public:
    vector<int> tops, times;

    TopVotedCandidate(vector<int>& p, vector<int>& t) {
        this->times = t;
        unordered_map<int,int> votes;

        //Using priority queue, maintain the top candidate at every timestamp in givevn times array (tie broken by most-recent first)
        auto cmp = [](vector<int> &a, vector<int> &b){
            if(a[2] == b[2])  return a[0] < b[0];
            return a[2] < b[2];
        };
        
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        for(int i=0;i<t.size();i++){
            votes[p[i]]++;
            pq.push({t[i], p[i], votes[p[i]]});

            int top = pq.top()[1];
            tops.push_back(top);
        }
    }
    
    int q(int t) {
        //Do binary search to find out the largest timestamp <= query time .. Return the top candidate of that timestamp
        int pos = upper_bound(times.begin(), times.end(), t) - times.begin() - 1;
        return tops[pos];
    }
};

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */
