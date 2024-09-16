package dailyChallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePointsInMinutes = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] time = timePoint.split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            timePointsInMinutes.add(hours * 60 + minutes);
        }
        Collections.sort(timePointsInMinutes);
        timePointsInMinutes.add(timePointsInMinutes.getFirst() + 24 * 60);
        int minDifference = 24 * 60;
        for (int i = 1; i < timePointsInMinutes.size(); i++) {
            minDifference = Math.min(minDifference, timePointsInMinutes.get(i) - timePointsInMinutes.get(i - 1));
        }
        return minDifference;
    }

    public static void main(String[] args) {
        List<String> timePoints1 = new ArrayList<>();
        timePoints1.add("00:00");
        timePoints1.add("23:59");
        MinimumTimeDifference_539 mtd = new MinimumTimeDifference_539();
        int minDiff = mtd.findMinDifference(timePoints1);
        System.out.println(minDiff);
        timePoints1.add("00:00");
        minDiff = mtd.findMinDifference(timePoints1);
        System.out.println(minDiff);
    }
}
