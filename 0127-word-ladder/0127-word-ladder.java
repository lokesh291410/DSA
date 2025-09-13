class Solution {
    class Pair {
        String word;
        int step;
        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++) set.add(wordList.get(i));
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().step;
            q.poll();
            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++) {
                for(char ch='a'; ch<='z'; ch++) {
                    char[] wordArr = word.toCharArray();
                    wordArr[i] = ch;
                    String changedWord = new String(wordArr);
                    if(set.contains(changedWord)) {
                        set.remove(changedWord);
                        q.add(new Pair(changedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}