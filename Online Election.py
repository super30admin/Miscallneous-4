#time:O(logn)
#space: O(n)


class TopVotedCandidate:
    time=[]
    leader_at_time_t={}
    def __init__(self, persons: List[int], times: List[int]):
        self.time=times
        self.leader_at_time_t={}
        votecount={}
        currlead=persons[0]
        for i in range(len(persons)):
            if persons[i] not in votecount:
                votecount[persons[i]]=0
            votecount[persons[i]]+=1
            if(votecount[persons[i]]>=votecount[currlead]):
                currlead=persons[i]
                
            self.leader_at_time_t[times[i]]=currlead

    def q(self, t: int) -> int:
        if t in self.leader_at_time_t:
            return self.leader_at_time_t[t]
        l=0
        r=len(self.time)-1
        while(l<=r):
            mid=l+(r-l)//2
            if(self.time[mid]<t):
                l=mid+1
            else:
                r=mid-1
        return self.leader_at_time_t[self.time[r]]
            
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)