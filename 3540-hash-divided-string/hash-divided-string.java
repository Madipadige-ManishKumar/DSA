class Solution {

    public int cal_sum(String s, int start, int end, HashMap<Character,Integer> map) {
        int sum = 0;

        while(start <= end) {
            sum += map.get(s.charAt(start));
            start++;
        }

        return sum;
    }

    public String stringHash(String s, int k) {

        HashMap<Character,Integer> map = new HashMap<>();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < alpha.length(); i++)
            map.put(alpha.charAt(i), i);

        for(int i = 0; i < s.length(); i += k) {

            int sum = cal_sum(s, i, i + k - 1, map);
            sum = sum % 26;

            res.append(alpha.charAt(sum));
        }

        return res.toString();
    }
}