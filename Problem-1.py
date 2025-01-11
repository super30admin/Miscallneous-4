#Approach
# main in 2 hasmap for leader at current time and count map for untill count. Since the times are soterd we can binarysearch


#Complexities
#Time: O(n) +O(log(n)
#Sapce: O(n)


from typing import List


class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.persons = persons
        self.times = times
        self.hashMap = dict()
        self.countMap = dict()
        self.topVoteCandidate()
        print(self.hashMap)
        print(self.countMap)

    def topVoteCandidate(self):
        leader = self.persons[0]
        self.countMap[self.persons[0]] = 1
        self.hashMap[self.times[0]] = leader
        for i in range(1, len(self.times)):
            self.countMap[self.persons[i]] = self.countMap.get(self.persons[i], 0) + 1

            if self.countMap[self.persons[i]] >= self.countMap[leader]:
                leader = self.persons[i]

            self.hashMap[self.times[i]] = leader

    def binarySearch(self, t):
        low = 0
        high = len(self.times) - 1

        while low <= high:
            mid = (low + high) // 2

            print(mid)
            if self.times[mid] == t:
                return self.times[mid]
            elif self.times[mid] < t:
                low = mid + 1
            else:
                high = mid - 1
        return self.times[high]

    def q(self, t: int) -> int:

        print(self.hashMap)
        print(self.countMap)
        times = self.binarySearch(t)

        return self.hashMap[times]


s= TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30])
s.q(25)