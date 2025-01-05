class TopVotedCandidate:

    ## T.C = O(logn)
    ## S.C = O(n)

    def __init__(self, persons: List[int], times: List[int]):
        self.persons = persons
        self.times = times
        self.hm_vote_counter = collections.defaultdict(int)
        self.hm_leader = collections.defaultdict(int)

        leader = self.persons[0]
        for i in range(len(self.times)):
            self.hm_vote_counter[self.persons[i]] += 1
            if self.hm_vote_counter[self.persons[i]] >= self.hm_vote_counter[leader]:
                leader = self.persons[i]

            self.hm_leader[times[i]] = leader

    def q(self, t: int) -> int:
        if t in self.hm_leader.keys():
            return self.hm_leader[t]

        low = 0
        high = len(self.times) - 1

        while low <= high:
            mid = (low + high) // 2

            if self.times[mid] < t:
                low = mid + 1
            else:
                high = mid - 1
        
        closest = self.times[high]
        return self.hm_leader[closest]

        


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)