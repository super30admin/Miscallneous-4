class TopVotedCandidate:
    #Approach: HashMap, BinarySearch
    #Time Complexity: O(n) for the constructor; O(log n) for a query
    #Space Complexity: O(n)
    #where n is the number of votes

    def __init__(self, persons: List[int], times: List[int]):
        
        self.times = times
        self.leaderMap = {}
        if not persons:
            return self.leaderMap
        
        voteMap, currLeader = {}, persons[0]
        for i in range(len(persons)):
            voteMap[persons[i]] = voteMap.get(persons[i], 0) + 1
            
            if voteMap[persons[i]] >= voteMap[currLeader]:
                currLeader = persons[i]
                
            self.leaderMap[times[i]] = currLeader

    def q(self, t: int) -> int:
        if t in self.times:
            return self.leaderMap[t]
        
        low = 0
        high = len(self.times) - 1
        while low <= high:
            mid = low + (high - low) // 2
            
            if self.times[mid] < t:
                low = mid + 1
            else:
                high = mid - 1
        
        return self.leaderMap[self.times[high]]

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)