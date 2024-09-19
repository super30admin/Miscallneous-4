import java.util.HashMap;
import java.util.Map;

/**
 * Try with example
 * <p>
 * persons = {0, 1, 1, 0, 0, 1, 0}
 * times = {0, 5, 10, 15, 20, 25, 30}
 * <p>
 * Now, we have to find leader at a particular time.
 * <p>
 * time : leader
 * 0 : 0
 * 5 : 1
 * 10 : 1
 * 15 : 0
 * 20 : 0
 * 25 : 1
 * 30 : 0
 * <p>
 * Now, when we are queried for the given times:
 * [3],[12],[25],[15],[24],[8]
 * <p>
 * we can check the map and get the exact hit -> TC O(1)
 * OR
 * we can find the lower bound -> apply binary search as times is sorted -> TC O(log n)
 * <p>
 * But the question is how to find the leader:
 * Brute: for each incoming vote, scan for vote counts from beginning and find the leader -> O(n^2)
 * <p>
 * Optimal: the leader gets affected by the incoming vote, so just compare the incoming vote with the leader's vote and update the leader accordingly -> Tc O(n)
 */
public class OnlineElection {

    private final int[] times;
    private final Map<Integer, Integer> timeLeaderMap;

    public OnlineElection(int[] persons, int[] times) {
        this.times = times;
        this.timeLeaderMap = new HashMap<>();
        buildLeaderMap(persons);
    }

    /**
     * Build the time-leader map
     *
     * @param persons
     */
    private void buildLeaderMap(int[] persons) {
        Map<Integer, Integer> personVotesMap = new HashMap<>();
        int leader = persons[0];
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];
            int votes = personVotesMap.getOrDefault(person, 0);
            personVotesMap.put(person, ++votes);
            int leaderVotes = personVotesMap.get(leader);
            if (leaderVotes <= votes) {
                leader = person;
            }
            timeLeaderMap.put(time, leader);
        }
        System.out.println(timeLeaderMap);
    }

    /**
     * TC: O(log n)
     *
     * @param t
     * @return
     */
    public int query(int t) {
        int time = -1;
        if (timeLeaderMap.containsKey(t)) {
            time = t;
        } else {
            time = binarySearch(t);
        }
        System.out.println(t + " = " + time);
        return timeLeaderMap.get(time);
    }

    // find lower bound
    private int binarySearch(int t) {
        int lo = 0;
        int hi = times.length - 1;
        int mid, time = -1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (times[mid] <= t) {
                time = times[mid];
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        OnlineElection onlineElection = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(onlineElection.query(3));
        System.out.println(onlineElection.query(12));
        System.out.println(onlineElection.query(25));
        System.out.println(onlineElection.query(15));
        System.out.println(onlineElection.query(24));
        System.out.println(onlineElection.query(8));
    }
}
