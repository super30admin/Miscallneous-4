# Time Complexity: O(1)
# Space Complexity: O(n)

class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.hashmap = defaultdict(int)
        self.timesMap = defaultdict(int)
        self.persons = persons
        self.times = times
        leader = self.persons[0]
        for i in range(len(self.times)):
            self.hashmap[self.persons[i]] += 1
            if self.hashmap[leader] < self.hashmap[self.persons[i]] or self.hashmap[leader] == self.hashmap[self.persons[i]]:
                leader = self.persons[i]

            self.timesMap[self.times[i]] = leader

    def q(self, t: int) -> int:
        # print(self.timesMap)
        low = 0
        high = len(self.times) - 1
        while low <= high:
            mid = (low + high)//2
            if self.times[mid] == t:
                # print(t, '-----', self.timesMap[self.times[mid]])
                return self.timesMap[self.times[mid]]
            elif self.times[mid] > t:
                high = mid - 1
            else:
                low = mid + 1
        # print(t, '-----', self.timesMap[self.times[high]])
        return self.timesMap[self.times[high]]


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
