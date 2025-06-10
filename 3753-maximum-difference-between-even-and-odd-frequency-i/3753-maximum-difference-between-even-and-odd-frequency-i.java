class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddF = 0;
        int evenF = Integer.MAX_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) % 2 == 0) evenF = Math.min(evenF, map.get(key));
            else oddF = Math.max(oddF, map.get(key));
        }

        return oddF - evenF;
    }
}