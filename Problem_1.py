"""
Time Complexity : O(n +qlog n) for doing computation inside the constructor and then quering
Space Complexity : O(n)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

here, we maintain 2 maps, one for keeping vote count for each candidate and the other for keeping a track of who is leading
at a particular time stamp. All this would be done inside the constructor. When a query is called, we check if that time 
stamp exists inside our hashmap. If yes, we check and return the leader. If not, we perform binary searchon the time array
and give the nearing left time.
"""

from collections import defaultdict


class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.times = times
        self.leaderMap = defaultdict(int)
        countMap = defaultdict(int)
        lead = persons[0]
        l = len(persons)
        for i in range(l):
            countMap[persons[i]] += 1
            if countMap[lead] <= countMap[persons[i]]:
                lead = persons[i]
            self.leaderMap[times[i]] = lead

    def q(self, t: int) -> int:
        if t in self.leaderMap:
            return self.leaderMap[t]
        low = 0
        high = len(self.times)-1
        while low <= high:
            mid = low + (high - low)//2
            if self.times[mid] > t:
                high = mid-1
            else:
                low = mid+1
        return self.leaderMap[self.times[high]]


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
