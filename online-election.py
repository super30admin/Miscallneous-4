# TIME COMPLEXITY: O(N + Log N)
# SPACE COMPLEXITY: O(N)
class TopVotedCandidate(object):

    def __init__(self, persons, times):
        """
        :type persons: List[int]
        :type times: List[int]
        """
        self.times = times
        self.persons = persons
        # Map to keep track of the leader at any given point of time
        self.leader_map = collections.defaultdict(int)
        # Map to count votes for a candidate
        self.vote_count_map = collections.defaultdict(int)
        # Set leader to first person
        leader = persons[0]
        for i in range(len(persons)):
            self.vote_count_map[persons[i]] += 1
            # who is the leader at time i
            if self.vote_count_map[persons[i]] >= self.vote_count_map[leader]:
                leader = persons[i]
            self.leader_map[times[i]] = leader
    
    def q(self, t):
        """
        :type t: int
        :rtype: int
        """
        # Closest binary search to find time in the times array
        low = 0
        high = len(self.persons) - 1
        while low <= high:
            mid = (low + high) / 2
            if self.times[mid] > t:
                high = mid - 1
            else:
                low = mid + 1
        return self.leader_map[self.times[high]]


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)