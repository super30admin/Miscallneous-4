// Time Complexity: O(log n)
// Space Complexity: O(n)

class TopVotedCandidate {
    HashMap<Integer, Integer> leaderMap;
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.leaderMap = new HashMap<>();
        this.time = times;

        HashMap<Integer, Integer> count = new HashMap<>();
        int leader = persons[0];

        for (int i = 0; i < persons.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (count.get(persons[i]) >= count.get(leader))
                leader = persons[i];
            leaderMap.put(times[i], leader);
        }

    }

    public int q(int t) {
        if (leaderMap.containsKey(t))
            return leaderMap.get(t);
        int left = 0;
        int right = time.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (time[mid] > t)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return leaderMap.get(time[right]);

    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */