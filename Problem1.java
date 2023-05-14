import java.util.HashMap;
/*
Online Election
approach: all we have to do is keep track of leader at a given time, we can use 2 maps, if the query is not in leadersMap
we do a bst on times array to find key and return leader at that time.
time: O(log n)
space: O(n)
 */
public class Problem1 {
    HashMap<Integer, Integer> leaderMap;
    int[] timesList;
    int currLeader;
    public Problem1(int[] persons, int[] times) {
        this.leaderMap = new HashMap<>();
        this.currLeader = persons[0];
        this.buildMaps(persons, times);
        this.timesList = times;
    }

    private void buildMaps(int[] persons, int[] times) {
        HashMap<Integer, Integer> votesMap = new HashMap<>();
        for (int i=0;i<times.length;i++) {
            votesMap.put(persons[i], votesMap.getOrDefault(persons[i], 0)+1);
            if (votesMap.containsKey(persons[i]) &&
                    votesMap.get(persons[i]) >= votesMap.get(currLeader)) {
                currLeader = persons[i];
            }
            leaderMap.put(times[i], currLeader);

        }
    }

    public int q(int t) {
        if (!leaderMap.containsKey(t)) {
            int index = bst(t);
            return leaderMap.get(index);
        }

        return leaderMap.get(t);
    }

    private int bst(int t) {
        int l = 0, h = timesList.length-1;

        while (l<=h) {
            int m = l+(h-l)/2;

            if (timesList[m] < t) {
                l = m+1;
            }
            else h = m-1;
        }

        return timesList[h];
    }
}
