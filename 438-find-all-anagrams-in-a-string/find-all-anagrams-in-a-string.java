class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] scount = new int[26];
        int[] pcount = new int[26];
        if(p.length() > s.length()) return result;
        for(int i=0;i<p.length();i++){
            scount[s.charAt(i)-'a']++;
            pcount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(scount,pcount)) result.add(0);
        for(int i=p.length();i<s.length();i++){
            scount[s.charAt(i)-'a']++;
            scount[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(scount,pcount)){
                result.add(i-p.length()+1);
            }
        }
        return result;
    }
}