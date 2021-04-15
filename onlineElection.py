# Time Complexity : O(LogN)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.leaders = {}
        self.time = times
        leader = persons[0]
        count = {}
        #build the two maps
        for i in range(len(times)):
            if persons[i] not in count:
                count[persons[i]] = 1
            count[persons[i]] += 1
            newCount = count[persons[i]]
            if count[leader] <= newCount:
                leader = persons[i]
                
            self.leaders[times[i]] = leader
    def q(self, t: int) -> int:
        if t in self.leaders:
            return self.leaders[t]
        
        #binary search when t is not part of times
        left = 0
        right = len(self.time)-1
        while left <= right:
            mid = left + (right-left)//2
            if self.time[mid] < t:
                left = mid+1
            else:
                right = mid - 1
        return self.leaders[self.time[right]]
            


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)