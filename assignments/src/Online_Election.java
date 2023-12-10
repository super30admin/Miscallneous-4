import java.util.*;

// Approach: Use HashMap and Binary search on a list of Votes (person, time)
// Time: O(n + qlogn) where n = no. of votes & q = no. of queries
// Space: O(n)

class Online_Election {

    Map<Integer, Integer> voteLeadMap;
    List<Vote> voteLeaderList;

    public Online_Election(int[] persons, int[] times) {
        voteLeaderList = new ArrayList();
        voteLeadMap = new HashMap();
        int leader = -1;
        int currLeaderVotes = 0;

        for (int i = 0; i<persons.length; ++i) {
            int p = persons[i], t = times[i];
            int count = voteLeadMap.getOrDefault(p, 0) + 1;
            voteLeadMap.put(p, count);

            if (count >= currLeaderVotes) {
                if (p != leader) {              // leader changes
                    leader = p;
                    voteLeaderList.add(new Vote(leader, t));
                }

                if (count > currLeaderVotes) {
                    currLeaderVotes = count;
                }
            }
        }
    }

    public int q(int t) {
        int low = 1, high = voteLeaderList.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (voteLeaderList.get(mid).time <= t)
                low = mid + 1;
            else
                high = mid;
        }

        return voteLeaderList.get(low - 1).person;
    }
}

class Vote {
    int person, time;
    Vote(int p, int t) {
        person = p;
        time = t;
    }
}