class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        
        self.time = {}
        self.time_array = times 
        count = {}
        leader = persons[0]
        
        for i in range(len(times)):
            if persons[i] not in count:
                count[persons[i]] = 0
            count[persons[i]] += 1
            
            if leader !=persons[i] and count[persons[i]] >= count[leader]:
                leader = persons[i]
            self.time[times[i]] = leader

    def q(self, t: int) -> int:
        
        if t in self.time:
            return self.time[t]
        
        low , high = 0, len(self.time)-1
        while low <= high :
            
            mid= low + (high - low ) //2
            if self.time_array[mid] > t:
                high = mid -1
            else:
                low = mid +1
        
        
        return self.time[self.time_array[high]]
                
            
            
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
