
class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        HashSet<String> reserved = new HashSet<>(Arrays.asList(arr));
        HashSet<String> assigned = new HashSet<>();
        HashMap<String, Integer> nextSuffix = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for (String name : arr) {
            if (!assigned.contains(name)) {
                assigned.add(name);
                ans.add(name);
            } else {
                int suffix = nextSuffix.getOrDefault(name, 1);
                String candidate;

                do {
                    candidate = name + suffix++;
                } while (reserved.contains(candidate) || assigned.contains(candidate));

                nextSuffix.put(name, suffix);
                assigned.add(candidate);
                ans.add(candidate);
            }
        }

        return ans;
    }
}
