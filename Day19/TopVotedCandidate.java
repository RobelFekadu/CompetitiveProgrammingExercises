public class TopVotedCandidate {

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0}, new int[] {0,5,10,15,20,25,30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
    }

    int[] times;
    int[] winnersAtEachGivenTime;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.winnersAtEachGivenTime = new int[persons.length];
        preCalculateWinnersAtEachGivenTime(persons);
    }
    
    public int q(int t) {
        return winnersAtEachGivenTime[getIndex(t)];
    }

    public void preCalculateWinnersAtEachGivenTime(int[] persons){
        int[] votes = new int[persons.length];
        int currentWinnerIndex = 0;
       for (int i = 0; i < persons.length; i++) {
           votes[persons[i]]++;
           if(votes[persons[i]] >= votes[currentWinnerIndex]){
               currentWinnerIndex = persons[i];
           }
           winnersAtEachGivenTime[i] = currentWinnerIndex;
       }
    }

    public int getIndex(int t){
        if(times[times.length - 1] < t)
            return times.length - 1;
        if(times[0] == t)
            return 0;

        int min = 0;
        int max = times.length - 1;
        int mid = (max + min) / 2;

        while (min < max) {
            if(times[mid] == t)
                return mid;
            if(times[mid] < t){
                if(mid + 1 < times.length && times[mid + 1] > t)
                    return mid;
                if(mid + 1 < times.length && times[mid + 1] == t)
                    return mid + 1;

                min = mid + 1;
            }else{
                if(mid - 1 >= 0 && times[mid - 1] <= t)
                    return mid - 1;

                max = mid - 1;
            }
            mid = (max + min) / 2;
        }
        return min;
    }
}