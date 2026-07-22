import java.util.*;

class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * Math.max(1, n)];
            if (n > 0)
                build(1, 0, n - 1, arr);
        }

        private void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }
            int mid = l + (r - l) / 2;
            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);
            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = l + (r - l) / 2;
            return Math.max(query(node * 2, l, mid, ql, qr),
                            query(node * 2 + 1, mid + 1, r, ql, qr));
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        List<int[]> zeroBlocks = new ArrayList<>();
        int ones = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '0') {
                int j = i;
                while (j < n && s.charAt(j) == '0') j++;
                zeroBlocks.add(new int[]{i, j - 1});
                i = j;
            } else {
                ones++;
                i++;
            }
        }

        List<Integer> answer = new ArrayList<>(Collections.nCopies(queries.length, 0));

        if (zeroBlocks.size() < 2) {
            for (int k = 0; k < queries.length; k++) answer.set(k, ones);
            return answer;
        }

        int m = zeroBlocks.size();
        int[] pair = new int[m - 1];

        for (i = 1; i < m; i++) {
            int[] left = zeroBlocks.get(i - 1);
            int[] right = zeroBlocks.get(i);
            int leftLen = left[1] - left[0] + 1;
            int rightLen = right[1] - right[0] + 1;
            pair[i - 1] = leftLen + rightLen;
        }

        SegmentTree st = new SegmentTree(pair);
        int[] starts = new int[m];
        int[] ends = new int[m];
        for (i = 0; i < m; i++) {
            starts[i] = zeroBlocks.get(i)[0];
            ends[i] = zeroBlocks.get(i)[1];
        }

        for (int idx = 0; idx < queries.length; idx++) {
            int L = queries[idx][0];
            int R = queries[idx][1];
            int first = lowerBound(ends, L);
            int last = upperBound(starts, R) - 1;

            if (first >= last) {
                answer.set(idx, ones);
                continue;
            }

            int best = 0;
            int leftPairStart = first + 1;
            int rightPairEnd = last - 2;

            if (pair.length > 0 && leftPairStart <= rightPairEnd)
                best = st.query(1, 0, pair.length - 1, leftPairStart, rightPairEnd);

            int leftCurrent = overlap(zeroBlocks.get(first), L, R);
            int leftNext = overlap(zeroBlocks.get(first + 1), L, R);
            best = Math.max(best, leftCurrent + leftNext);

            int prev = overlap(zeroBlocks.get(last - 1), L, R);
            int curr = overlap(zeroBlocks.get(last), L, R);
            best = Math.max(best, prev + curr);

            answer.set(idx, ones + best);
        }

        return answer;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int overlap(int[] block, int L, int R) {
        int left = Math.max(block[0], L);
        int right = Math.min(block[1], R);
        if (left > right) return 0;
        return right - left + 1;
    }
}
