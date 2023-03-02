class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.persons = persons
        self.times = times
        self.count = dict()
        self.leaders = dict()

        leader = self.persons[0]

        for i, person in enumerate(self.persons):
            self.count[person] = self.count.get(person, 0) + 1
            if self.count[leader] <= self.count[person]:
                leader = person
            self.leaders[self.times[i]] = leader
            # print(leaders, count)

    def q(self, t: int) -> int:
        if t in self.leaders.keys():
            return self.leaders.get(t)

        # if the t in not present in the times
        # we return the nearest lower time as that will the latest time the person will be leading
        # eg: for 12 we return 10
        # we dot that with binary search and return self.times[high]. return high pointer

        low = 0
        high = len(self.times) - 1

        while low <= high:
            mid = low + (high - low) // 2

            # if self.times[mid] == t:
            #     return self.leaders[t]

            if self.times[mid] < t:
                low = mid + 1
            else:
                high = mid - 1

        return self.leaders.get(self.times[high])

# Design, Binary search
# Time Complexity: O(1)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
