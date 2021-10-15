class TopVotedCandidate(object):
    def __init__(self, persons, times):
        self.leaders = {}
        self.time = times
        count = {}
        leader = 0
        count[0] = 0 
        for i in range(len(times)):
            if persons[i] not in count.keys():
                count[persons[i]] = 0
            count[persons[i]] += 1
            if count[persons[i]] >= count[leader]:
                leader = persons[i]
            self.leaders[times[i]] = leader
                   

    def q(self, t):
        if t in self.leaders.keys():
            return self.leaders[t]
        else:
            low = 0
            high = len(self.time) - 1
            while low <= high:
                mid = low + (high-low)//2
                if self.time[mid] > t:
                    high = mid - 1
                else:
                    low = mid + 1
            return self.leaders[self.time[high]]

# Time Complexity: Q * log(n)
# Space Complexity: O(n)