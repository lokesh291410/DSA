class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int[] ans = new int[nums.length];
        for(int num : nums) {
            if(num < pivot) less.add(num);
            if(num > pivot) greater.add(num);
        }

        for(int i=0; i<less.size(); i++) {
            ans[i] = less.get(i);
        }
        int pivotLen = nums.length - (less.size() + greater.size());

        for(int i=0; i<pivotLen; i++) {
            ans[i+less.size()] = pivot;
        }

        int k = less.size() + pivotLen;
        for(int i=0; i<greater.size(); i++) {
            ans[i+k] = greater.get(i);
        }

        return ans;
    }
}