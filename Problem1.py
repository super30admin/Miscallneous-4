#Time Complexity: O(N + Q Log N) Q is queries, N is votes
#Space Complexity: O(N)
class TopVotedCandidate:
    time = []
    def __init__(self, persons: List[int], times: List[int]):
        self.leaders = {}
        self.countmap = {}
        temp = float('-inf')
        leader = 0
        self.time = times
        for i in range(len(persons)):
            if persons[i] not in self.countmap:
                self.countmap[persons[i]] = 1
            else:
                self.countmap[persons[i]] +=1
            
            if self.countmap[persons[i]] >= self.countmap[leader]:
                leader = persons[i]
            self.leaders[times[i]] = leader

    def q(self, t: int) -> int:
        li = []
        if t in self.leaders:
            return self.leaders[t]
        else:
            low = 0
            high = len(self.leaders) - 1
            while low <= high:
                mid = (low + high) // 2
                if self.time[mid] <= t:
                    low = mid + 1
                else:
                    high = mid - 1

            ele = self.time[high]
            return self.leaders[ele]
 

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)