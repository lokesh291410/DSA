class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = nums.length - 1;
                while(k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum < target) k++;
                    else if(sum > target) l--;
                    else {
                        List<Integer> quad = new LinkedList<>();
                        quad.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        list.add(quad);
                        k++; l--;
                        while(k<l && nums[k] == nums[k-1]) k++;
                        while(k<l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }
}