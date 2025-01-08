class Solution {
    public int waysToReachStair(int k) {
        int num = 1;
        int ans = 0;
        if (k==0||k==1)
            ans++;
        int[][] pasc = new int[50][50];
        pasc[0][0] = 1;
        for (int i = 1; i < 50; ++i) {
            pasc[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                pasc[i][j] = pasc[i-1][j]+pasc[i-1][j-1];
            }
        }
        for (int i = 0; i < 30; ++i) {
            num += 1<<i;
            // System.out.println(num+" "+i);
            if (num>=k&&num-k<=i+2) {
                int ncrn = i+2;
                int ncrr = num-k;
                //System.out.println(pasc[ncrn][ncrr]);
                ans += pasc[ncrn][ncrr];
            }
        }
        return ans;
    }
}