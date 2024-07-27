import java.util.*;

class TopVotedCandidate {

    int[] times;
    int[] ans;

    public TopVotedCandidate(int[] persons, int[] times) {
        // Tc: O(n) Sc: O(n)
        this.times = times;
        int n = persons.length;

        Map<Integer, Integer> map = new HashMap<>();
        ans = new int[n];

        int leader = -1;
        for (int i = 0; i < n; i++) {
            int person = persons[i];
            map.put(person, map.getOrDefault(person, 0) + 1);
            if (leader == -1 || map.get(person) >= map.get(leader)) {
                leader = person;
            }
            ans[i] = leader;
        }
    }

    public int q(int t) {
        // Tc: O(logn) Sc: O(1)
        int lo = 0, hi = times.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (times[mid] <= t) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return ans[lo];

    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */