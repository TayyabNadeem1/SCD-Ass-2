import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerger {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
       
        List<int[]> mergingList = new ArrayList<>();
        mergingList.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int[] first = intervals.get(i);
            int[] second = mergingList.get(mergingList.size() - 1);

            if (first[0] <= second[1]) {
                
                second[1] = Math.max(second[1], first[1]);
            } else {
                
                mergingList.add(first);
            }
        }

        return mergingList;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>(Arrays.asList(
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        ));

        List<int[]> result = mergeIntervals(intervals);

        
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
