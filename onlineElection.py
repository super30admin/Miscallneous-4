'''
time complexity: O(n)
space complexity:O(n)
'''
class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.countMap = {}
        self.leaderMap = {}
        leader = persons[0]
        for i in range(len(persons)):
            currPerson = persons[i]
            currTime = times[i]
            self.time = times
            if currPerson not in self.countMap:
                self.countMap[currPerson] = 0
            self.countMap[currPerson] +=1
            if (self.countMap[currPerson] >= self.countMap[leader]):
                leader = currPerson
            self.leaderMap[currTime] = leader
            
    def q(self, t: int) -> int:
        if t in self.leaderMap: return self.leaderMap[t]
        low = 0
        high = len(self.time)-1
        while(low<=high):
            mid = (low + high) //2
            if self.time[mid] > t:
                high = mid - 1
            else:
                low = mid + 1
        return self.leaderMap[self.time[high]]

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)