//Time: O(Log(N)) | Space: O(1) - q func

class TopVotedCandidate {
    int[] times;
    Map<Integer, Integer> userToVoteMap;
    Map<Integer, Integer> timeToLeadingMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int leader = -1;
        userToVoteMap = new HashMap<>();
        timeToLeadingMap = new HashMap<>();
        for(int i=0;i<persons.length;i++) {
            int currVote = userToVoteMap.getOrDefault(persons[i], 0)+1;
            if(leader == -1 || leader != persons[i] && currVote >= userToVoteMap.get(leader)) {
                leader = persons[i];
            }
            userToVoteMap.put(persons[i], currVote);

            timeToLeadingMap.put(times[i], leader);
        }
    }

    public int q(int t) {
        int low = 0;
        int high = times.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(times[mid] == t) {
                high = mid;
                break;
            }else if(t > times[mid]) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return timeToLeadingMap.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */