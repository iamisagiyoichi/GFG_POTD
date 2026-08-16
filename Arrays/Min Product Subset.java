class Solution {
public:
    int minProd(vector<int>& arr) {
        int negativeCount = 0;
        int zeroCount = 0;
        int smallestPositive = INT_MAX;
        int largestNegative = INT_MIN;
        long long product = 1;

        for (int x : arr) {
            if (x < 0) {
                negativeCount++;
                product *= x;
                largestNegative = max(largestNegative, x);
            } else if (x == 0) {
                zeroCount++;
            } else {
                smallestPositive = min(smallestPositive, x);
            }
        }

        if (negativeCount == 0) {
            if (zeroCount > 0) return 0;
            return smallestPositive;
        }

        if (negativeCount % 2 == 0) {
            product /= largestNegative;
        }

        for (int x : arr) {
            if (x > 0) {
                product *= x;
            }
        }

        return (int) product;
    }
};
