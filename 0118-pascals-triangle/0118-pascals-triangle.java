class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) return triangle;
        List<Integer> lst = new ArrayList<>();
        triangle.add(lst);
        triangle.get(0).add(1);
        for(int i=1; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prevList = triangle.get(i-1);
            list.add(1);
            for(int j=1; j<i; j++) {
                list.add(prevList.get(j-1) + prevList.get(j));
            }
            list.add(1);
            triangle.add(list);
        }
        return triangle;
    }
}