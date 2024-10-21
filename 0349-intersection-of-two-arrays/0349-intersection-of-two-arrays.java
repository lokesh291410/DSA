class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer> list = new ArrayList<>();
        while(i!=nums1.length && j!=nums2.length){
            if((nums1[i] == nums2[j])){
                if(!list.contains(nums1[i]))
                    list.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] arr = new int[list.size()];
        for( i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}