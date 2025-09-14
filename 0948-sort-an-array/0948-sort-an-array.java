class Solution {
    public void mergeSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, mid, left, right);
    }

    public void merge(int[] arr, int mid, int low, int high) {
        int i = low, j = mid + 1;
        List<Integer> list = new ArrayList<>();

        while(i <= mid && j <= high) { 
            if(arr[i] < arr[j]) list.add(arr[i++]);
            else list.add(arr[j++]);
        }

        while(i <= mid) list.add(arr[i++]);
        while(j <= high) list.add(arr[j++]);
        
        for(int k=low; k<=high; k++) arr[k] = list.get(k - low);
    }

    public int[] sortArray(int[] nums) {
        if(nums == null) return null;

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }
}