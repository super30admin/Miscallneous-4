class TopVotedCandidate {
    int[] times;
    int[] leads;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        this.times = times;
        leads = new int[n];

        int[] votes = new int[n];
        int maxVotes = 0, leader = -1;

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            int t = times[i];

            votes[p]++;
            if (votes[p] >= maxVotes) {
                maxVotes = votes[p];
                leader = p;
            }

            leads[i] = leader;
        }
    }

    // TC: O(log n), where n is the number of times.
    // SC: O(n)
    public int q(int t) {
        int lo = 0, hi = times.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (times[mid] <= t) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return leads[lo];
    }
}
