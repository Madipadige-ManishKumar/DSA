class Pair<K,V>{
    private  K  key;
    private V value;
    public Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    public K getKey()
    {
        return key;
    }
    public V getValue()
    {
        return value;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue <Pair<String , Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));
        Set<String> st = new HashSet<>(wordList);
        st.remove(beginWord);
        while(!queue.isEmpty())
        {
            String word = queue.peek().getKey();
            Integer step = queue.peek().getValue();
            queue.poll();
            if(word.equals(endWord))
                return step;
            for(int i =0;i<word.length();i++)
            {
                char []arr = word.toCharArray();
                char originalchar = arr[i];
                for(char ch ='a';ch<='z';ch++)
                {
                    arr[i]=ch;
                    String newWord = new String(arr);
                    if(st.contains(newWord))
                    {
                        queue.offer(new Pair<>(newWord,step+1));
                        st.remove(newWord);
                    }
                }
                arr[i]=originalchar;
            }
        }
        return 0;
    }
}
