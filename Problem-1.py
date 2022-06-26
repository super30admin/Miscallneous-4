class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.count_map=dict()
        self.leader_map=dict()
        leader=persons[0]
        self.time=times
        for i in range(len(persons)):
            curr=persons[i]
            self.count_map[curr]=self.count_map.get(curr,0)+1
            if self.count_map[curr]>=self.count_map[leader]:
                leader=curr
            self.leader_map[times[i]]=leader
            

    def q(self, t: int) -> int:
        if t in self.leader_map.keys():
            return self.leader_map[t]
        else:
            low,high=0,len(self.time)-1
            while low<=high:
                mid=low+(high-low)//2
                if self.time[mid]<t:
                    low=mid+1
                else:
                    high=mid-1
            return self.leader_map[self.time[high]]
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)