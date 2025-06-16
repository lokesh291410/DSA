class StockSpanner {
    Stack<Pair<Integer, Integer>> st;
    int idx;

    public StockSpanner() {
        this.idx = -1;
        this.st = new Stack<>();
        this.st.clear();
    }
    
    public int next(int price) {
        idx += 1;

        while(!st.isEmpty() && st.peek().getValue() <= price) st.pop();

        int ans = idx - (st.isEmpty() ? -1 : st.peek().getKey());
        st.push(new Pair<>(idx, price));

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */