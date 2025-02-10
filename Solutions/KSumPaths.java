class Solution {

    int count;

    public int sumK(Node root, int k) {

        count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        solve(root, k, map, 0);

        return count;
    }

    void solve(Node root, int k, Map<Integer, Integer> map, int sum) {

        if (root == null)
            return;

        sum += root.data;

        if (sum == k)
            count++;

        if (map.containsKey(sum - k))
            count += map.get(sum - k);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        solve(root.left, k, map, sum);
        solve(root.right, k, map, sum);

        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0)
            map.remove(sum);
    }
}