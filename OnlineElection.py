# Time Complexity : O(N) for init and O(logN) for query
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using 2 HashMaps one to store frequencies for each leader and other to store timestamps with leader at that timestamp
# For getting the leader for timestamps that are not given we will perform a nearest binary search and get the times[right] from HashMap


class TopVotedCandidate:
    def __init__(self, persons: List[int], times: List[int]):
        self.persons = persons
        self.times = times
        self.freqdict = {}
        self.leaddict = {}
        self.leader = self.persons[0]
        for i in range(len(self.times)):
            if self.persons[i] not in self.freqdict:
                self.freqdict[self.persons[i]] = 1
            else:
                self.freqdict[self.persons[i]] += 1
            if self.freqdict[self.leader] <= self.freqdict[self.persons[i]]:
                self.leader = self.persons[i]
            self.leaddict[self.times[i]] = self.leader

    def q(self, t: int) -> int:
        k = self.binarySearch(self.times, 0, len(self.times) - 1, t)
        return self.leaddict[self.times[k]]

    def binarySearch(self, arr, left, right, target):
        while left <= right:
            mid = left + (right - left) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return right


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)