import java.util.ArrayList;

class NumberOfBSTFromArray {

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;

        // 🔥 Precompute Catalan numbers once
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        if (n >= 1) catalan[1] = 1;

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }

            // ✅ Use Catalan values
            al.add(catalan[left] * catalan[right]);
        }

        return al;
    }

    // 🔽 Main method for testing
    public static void main(String[] args) {
        NumberOfBSTFromArray sol = new NumberOfBSTFromArray();

        int[] arr = {3, 4, 1, 2, 5};

        ArrayList<Integer> result = sol.countBSTs(arr);

        System.out.println(result);  // Expected: [4, 5, 14, 5, 14]
    }
}
