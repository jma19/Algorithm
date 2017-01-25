#### Group Strings
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:

~~~
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
~~~


Solution

~~~
  /**
     * Solution: transform each element into string which starts with letter 'a'
     */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();

        for (String emem : strings) {
            char[] chs = emem.toCharArray();
            int diff = chs[0] - 'a';
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] - diff < 'a') {
                    chs[i] = (char) (chs[i] - diff + 26);
                } else {
                    chs[i] = (char) (chs[i] - diff);
                }
            }
            String key = new String(chs);
            if (map.containsKey(key)) {
                map.get(key).add(emem);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(emem);
                map.put(key, temp);
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
~~~