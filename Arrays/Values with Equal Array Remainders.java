class Solution {
    public int sameMod(int[] arr) {
        int g = 0;
        
        for(int i = 1; i < arr.length; i++) {
            g = gcd(g, Math.abs(arr[i] - arr[0]));
        }
        
        if(g == 0) return -1;
        
        int ans = 0;
        
        for(int i = 1; i * i <= g; i++) {
            if(g % i == 0) {
                ans++;
                if(i != g / i) ans++;
            }
        }
        
        return ans;
    }
    
    int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}
