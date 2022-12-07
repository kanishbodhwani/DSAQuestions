class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet set = new HashSet<>();
        List<List<String>> result = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
            ArrayList arr = new ArrayList<>();
            for(int j = i; j < strs.length; j++) {
                // check
                if(set.contains(strs[j]) && isAnagram(strs[i], strs[j])) {
                    break;
                } else {
                    arr.add(strs[i]);
                }
            }
            result.add(arr);
        }
        return result;
    }


    public boolean isAnagram(String s1, String s2) {
        HashMap map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if(map.contains(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i) + 1));
            } else {
                map.put(s1.charAt(i), 1); 
            }
        }

        for(int i = 0; i < s2.length(); i++) {
            if(map.contains(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        for(Integer a: map.values()) {
            if(a != 0) {
                return false;
            }
        }
        return true;
    }
}

//    i = 0 j = 0
// ["a"]


// i = 0
// new Array
// j = i
// map.contains(el) && isAnagram(el1, el2) 
    // break;

// else store 
// map.add(arr[0])

// ["eat", "tea", "ate"] 
// ["tan", "nat"]
// ["bat"]


