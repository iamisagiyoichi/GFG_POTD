class Solution {
    public int digitSum(String s) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }

    public int findMax(int n) {
        String s = String.valueOf(n);

        int ans = n;
        int maxSum = digitSum(s);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {
                continue;
            }

            char[] temp = s.toCharArray();

            temp[i]--;

            for (int j = i + 1; j < s.length(); j++) {
                temp[j] = '9';
            }

            String str = new String(temp);
            int num = Integer.parseInt(str);
            int sum = digitSum(str);

            if (sum > maxSum || (sum == maxSum && num > ans)) {
                maxSum = sum;
                ans = num;
            }
        }

        return ans;
    }
}
