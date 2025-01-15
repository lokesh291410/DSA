class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
            (pair1, pair2) -> {
                if (!pair1.getValue().equals(pair2.getValue())) {
                    return Integer.compare(pair2.getValue(), pair1.getValue());  // Descending frequency
                } else {
                    return Character.compare(pair1.getKey(), pair2.getKey());  // Ascending lexicographical order
                }
            }
        );

        
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char i : s.toCharArray()) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        for(char i: hash.keySet())
        {
            Pair<Character,Integer> pair=new Pair<>(i,hash.get(i));
            pq.offer(pair);
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Character, Integer> pair = pq.poll();
            char ch = pair.getKey();
            int freq = pair.getValue();
            ans.append(String.valueOf(ch).repeat(freq));
        }
        return ans.toString();
    }
}