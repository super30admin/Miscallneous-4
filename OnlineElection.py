'''
TC: O(logn) - In constructor, the TC is O(n) for iterating through indexes of persons
            that would be O(n) but we can ignore that since it is a one timer.
            So, the O(logn) comes from the Binary Search implementation to find the 
            corresponding leader for a given time
SC: O(n) - since we are dealing with pointers and space required to store the constructor 
            map space.
'''
import collections
from typing import List

class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.times = times
        self.personToCount = collections.defaultdict(int)
        self.timeToLeader = {}
        leader = None
        for i in range(0,len(persons)):
            self.personToCount[persons[i]]+=1
            if leader is None:
                leader = persons[i]
            elif self.personToCount[leader] <= self.personToCount[persons[i]]:
                leader = persons[i]
            self.timeToLeader[times[i]] = leader

    def q(self, t: int) -> int:
        if t in self.timeToLeader:
            return self.timeToLeader[t]
        i,j = 0, len(self.times)-1
        while i<j:
            mid = (i+j)//2
            if self.times[mid]<t:
                i = mid+1
            else:
                j = mid-1
        return self.timeToLeader[self.times[i]] if self.times[i] < t else  self.timeToLeader[self.times[i-1]]


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)