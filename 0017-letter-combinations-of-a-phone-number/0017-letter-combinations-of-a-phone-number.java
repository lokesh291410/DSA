class Solution {
    private final Map<Character, char[]> key = Map.of(
        '2', new char[] { 'a', 'b', 'c' },
        '3', new char[] { 'd', 'e', 'f' },
        '4', new char[] { 'g', 'h', 'i' },
        '5', new char[] { 'j', 'k', 'l' },
        '6', new char[] { 'm', 'n', 'o' },
        '7', new char[] { 'p', 'q', 'r', 's' },
        '8', new char[] { 't', 'u', 'v' },
        '9', new char[] { 'w', 'x', 'y', 'z' }
    );

    public void findCombination(int idx, String digits, List<String> ans, StringBuilder comb) {
        if(idx == digits.length()) {
            ans.add(comb.toString());
            return;
        }

        for(int i=0; i<key.get(digits.charAt(idx)).length; i++) {
            comb.append(key.get(digits.charAt(idx))[i]);
            findCombination(idx+1, digits, ans, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        findCombination(0, digits, ans, new StringBuilder());

        return ans;
    }
}