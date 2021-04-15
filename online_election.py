# Approach - In line
# Time  - O(1) if t exists else O(log N) for binary search to find t 
# Space - O(N)
# Constructor functions dont affect time calc

class TopVotedCandidate:
    def __init__(self, persons: List[int], times: List[int]):
        
        # initialize current leader as first one
        current_leader = persons[0]
        
        self.times = times
        self.persons = persons
        
        # map which stores frequencies of how many times this leader was voted for
        self.freq_map = {}
        # map which stores leader at any given time instant
        self.time_leader_map = {}
        
        for i in range(len(times)):
            # at each time we simultaneously iterate over persons and see who was voted at this time
            # but in time map we want to store the leader with leading votes and not current selection
            # first update count of incoming choice 
            
            self.freq_map[persons[i]] = self.freq_map.get(persons[i], 0) + 1
            
            # if incoming leader's count >= current leader, update current and in time map update with leader leading 
            if self.freq_map[persons[i]] >= self.freq_map[current_leader]:
                current_leader = persons[i]
            
            self.time_leader_map[times[i]] = current_leader
              
        

    def q(self, t: int) -> int:
        
        # if time exists in dictionary return it else perform binary search for closest interval like times not in range(6,7 mins etc)
    
        
        if t in self.time_leader_map:
            return self.time_leader_map[t]
        
        else:
            # perform modified binary search (closest value) to get time value closest to t
            # then with this t obtain the leader from time map
            
            low = 0
            high = len(self.times) - 1
            
            while low <= high:
                
                midd = low + (high - low) // 2
                
                if self.times[midd] < t:
                    low = midd + 1
                    
                elif self.times[midd] > t:
                    high = midd - 1
                    
            return self.time_leader_map[self.times[high]]
        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)