class Solution {
    class Comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comp());
        int lastEnd = intervals[0][1], cnt = 1;

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] >= lastEnd) {
                cnt++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - cnt;
    }
}