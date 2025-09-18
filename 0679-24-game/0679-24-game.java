class Solution {
    double epsilon = 0.1;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int i : cards) nums.add(1.0 * i);

        return find(nums);
    }

    public boolean find(List<Double> nums) {
        if(nums.size() == 1) return Math.abs(nums.get(0) - 24) <= epsilon;

        for(int i=0; i<nums.size(); i++) {
            for(int j=0; j<nums.size(); j++) {
                if(i == j) continue;

                List<Double> temp = new ArrayList<>();
                for(int k=0; k<nums.size(); k++) {
                    if(k != i && k != j) temp.add(nums.get(k));
                }

                Double a = nums.get(i);
                Double b = nums.get(j);
                List<Double> operations = new ArrayList<>(Arrays.asList(
                    a + b, a - b, b - a, a * b
                ));
                if(Math.abs(b) != 0.0) operations.add(a/b);
                if(Math.abs(a) != 0.0) operations.add(b/a);

                for(Double op : operations) {
                    temp.add(op);
                    if(find(temp)) return true;
                    temp.remove(temp.size() - 1);
                }
            }
        }

        return false;
    }
}