# Approach:
# - We preprocess the votes by maintaining a `leader_at_time` list, which stores the leading candidate at each timestamp.
# - A dictionary (`vote_count`) keeps track of the current vote counts for each candidate.
# - We iterate through `persons`, update vote counts, and determine the leader at each time.
# - For queries, we use binary search (`bisect_right`) to efficiently find the latest time `≤ t`, returning the leader at that time.

# Time Complexity:
# - __init__: O(N) where N is the number of votes (for preprocessing the leaders).
# - q: O(log N) per query using binary search.
# Space Complexity: O(N) (for storing leaders and times).

class TopVotedCandidate:
    def __init__(self, persons: List[int], times: List[int]):
        self.times = times  # Store voting times
        self.leaders = []  # Store leader at each time
        vote_count = {}  # Dictionary to track votes per candidate
        leader = -1  # Initialize leader
        
        for i, person in enumerate(persons):
            vote_count[person] = vote_count.get(person, 0) + 1  # Increment vote count
            
            # Update leader if necessary (tie goes to most recent vote)
            if leader == -1 or vote_count[person] >= vote_count[leader]:
                leader = person

            self.leaders.append(leader)  # Store the leader at this timestamp

    def q(self, t: int) -> int:
        # Use binary search to find the latest time ≤ t
        index = bisect.bisect_right(self.times, t) - 1
        return self.leaders[index]  # Return the leader at that time

# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
