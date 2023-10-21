#include<iostream>
#include<vector>

using namespace std;

class TopVotedCandidate {
public:
    vector<int> res{};
    int *p{NULL};
    int* p_l{NULL};
    int* p_h{NULL};

    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        // get the length of the input array
        size_t times_len = times.size();
        this->res.resize(times_len,0);
        this->p = &times.at(0);
        this->p_l = &times.at(0);
        this->p_h = &times.at(times_len-1);
        //find vote count
        unordered_map<int,int> vote_count{}; 
        vote_count[0] = 0;
        //iterate through time
        int curr_max{0};
        for(int i{};i<times_len;++i){
            int person = persons.at(i);
            if(vote_count.find(person) == vote_count.end()){
                vote_count[person] = 0;
            }
            ++vote_count[person];
            if(vote_count[person]>=vote_count[curr_max]){
                curr_max = person;
            }
            res.at(i) = curr_max;
        }
        // for(auto i:res){
        //     cout<<i<<" ";
        // }
        // cout<<endl;
    }

    
    int q(int t) {
        // here implement the binary search
        int* p_low = p_l;
        int* p_high = p_h;
        //check if time is greater than the last conducted vote.
        if(t >= *(p_high))
        return res.at(p_high-p);

        int res_int{};
        bool flag{false};
        int* mid = p_low + (p_high-p_low)/2;
        // cout<<"val t: "<<t<<endl;
        while(!flag && p_low<p_high){
            // cout<<"val_mid: "<<*mid<<" val_mid+1 "<<*(mid+1)<<endl;
            if(t>=*mid && t<*(mid+1)){
                flag = true;
                res_int = res.at(mid - this->p);
                // cout<<"val t: "<<t<<" "<<res_int<<endl;
            }
            else{
                if(*mid > t){
                    p_high = mid;
                }
                else{
                    p_low = mid+1;
                }
                mid = p_low + (p_high-p_low)/2;
            }
        }
        return res_int;
    }
};