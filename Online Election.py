""""// Time Complexity : O(log(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.timeLeader = {}
        self.votes = {}
        self.time = times
        currLeader = -1
        for i in range(len(persons)):
            if persons[i] not in self.votes:
                self.votes[persons[i]] = 0
            self.votes[persons[i]] += 1

            if currLeader == -1:
                currLeader = persons[i]
            elif currLeader != -1:
                if self.votes[persons[i]] >= self.votes[currLeader]:
                    currLeader = persons[i]

            if times[i] not in self.timeLeader:
                self.timeLeader[times[i]] = currLeader

    def q(self, t: int) -> int:
        if t in self.timeLeader:
            return self.timeLeader[t]

        low = 0
        high = len(self.time) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if self.time[mid] < t:
                low = mid + 1
            else:
                high = mid - 1
        return self.timeLeader[self.time[high]]

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)