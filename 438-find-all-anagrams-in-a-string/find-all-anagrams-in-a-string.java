class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;
        int[] pcount = new int[26];
        int[] scount = new int[26];

        for(int i=0;i<p.length();i++){
            pcount[p.charAt(i) -'a']++;
            scount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pcount,scount)) result.add(0);

        for(int i= p.length() ; i < s.length() ; i++){
            scount[s.charAt(i)-'a']++;
            scount[s.charAt(i - p.length()) - 'a'] --;
            if(Arrays.equals(pcount, scount)){
                result.add(i -p.length() + 1);
            }
        }
        return result;
    }
}