import java.util.HashMap;

public class TopVotedCandidate {

    HashMap<Integer, Integer> countVotes;
    HashMap<Integer, Integer> leaders;
    int[] times;
    /***
     Iterate through persons.
     create hasmap for each person as key  and number of votes as values
     maintain leader variable andat every iteration if person votes is greater or equal(latest time stamp)
     than current leader, change the current person to leader.
     also maintain hashmap,
     times as key at every given time who is the leader as value.

     for query function,
     at any given time if leaders map  has that time, return the leader associated.
     if not perform binary search to find the valye just lover than the given value.
     That will be i the value high after high becomes lower than low.
     return the leader of that point.

     Time complexity 0(logn)
     space complexity o(n)


     */

    public TopVotedCandidate(int[] persons, int[] times) {
        if (persons == null || persons.length == 0) {
            return;
        }
        this.times = times;
        countVotes = new HashMap<>();
        leaders = new HashMap<>();
        int leader = persons[0];
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            countVotes.put(person, countVotes.getOrDefault(person, 0) + 1);
            if (countVotes.get(person) >= countVotes.get(leader)) {
                leader = person;
            }
            leaders.put(times[i], leader);
        }
    }

    public int q(int t) {
        if (leaders.containsKey(t)) {
            return leaders.get(t);
        }
        int low = 0;
        int high = times.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevent integer overflow
            if (times[mid] > t) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return leaders.get(times[high]);

    }
}
