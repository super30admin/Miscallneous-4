# // Time Complexity :O(1)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        leader=0
        self.count={}
        self.leads={}
        self.time=times
        for i in range(len(persons)):
            if persons[i] not in self.count.keys():
                self.count[persons[i]]=0
            self.count[persons[i]]+=1
            if self.count[leader]<=self.count[persons[i]]:
                leader=persons[i]
            self.leads[times[i]]=leader
        

    def q(self, t: int) -> int:
        if t not in self.time:
            
            t=self.binarysearch(self.time,t)
        return self.leads[t]
    def binarysearch(self,li,t):
        low=0
        high=len(li)-1
        
        while low<=high:
            mid=(low+high)//2
            print(mid)
            if li[mid]>t:
                high=mid-1
            else:
                low=mid+1
        
        return li[high]
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)