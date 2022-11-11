# Time Complexity : O(log n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class TopVotedCandidate:
    def __init__(self, persons: List[int], times: List[int]):
        # create a hashmap to store the times and the corresponding leader leading at that time
        self.leaders = {}
        
        # hashmap that can store the votes at that point
        self.votes = {0:0}
        
        # variable that stores the leader
        leader = 0
        self.times = times
        
        # traverse over the lenght of person or times
        for i in range(len(persons)):
            p = persons[i]
            t = times[i]
            
            # update the count or person in hashmap
            if p not in self.votes:
                self.votes[p] = 0
            self.votes[p] += 1
            
            # check if the current person has more or equal votes than the leader, if so then update the leader to the current person
            if self.votes[p] >= self.votes[leader]:
                leader = p
            self.leaders[t] = leader

    def q(self, t):
        # check if the time is present in hashmap then simply return the leading person
        if t in self.leaders:
            return self.leaders[t]
        else:
            # use binary search to return the person which would the lower timestamp present in the times list
            low = 0
            high = len(self.times) - 1
            
            while low <= high:
                # find the cehck
                mid = low + (high - low) // 2
                
                # compare the mid value of times to t and move low, high
                if self.times[mid] > t:
                    high = mid - 1
                else:
                    low = mid + 1
            
            # return the value from hashmap which points to the high pointer from times list
            return self.leaders[self.times[high]]
    
# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
