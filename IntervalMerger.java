import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalMerger {
    public static List<int[]> mergeIntervals(List<int[]> intervals) {
        
        int writeIndex = 0; 

        for (int i = 1; i < intervals.size(); i++) {
            int[] first = intervals.get(i);
            int[] second = intervals.get(writeIndex);

            if (first[0] <= second[1]) {
                
                second[1] = Math.max(second[1], first[1]);
            } else {
                
                writeIndex++;
                intervals.set(writeIndex, first);
            }
        }

        
        
        int newSize = writeIndex + 1;
        while (intervals.size() > newSize) {
            intervals.remove(intervals.size() - 1);
        }

        return intervals;
    }

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>(Arrays.asList(
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        ));

        mergeIntervals(intervals);

        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            System.out.println(Arrays.toString(interval));
        }
    }
}
