public class AnWeiYu {
}

/*
算法：由于与运算只有一个为0就会变成0，所以这道题的实质是求这些数的公共二进制前缀，或者可以说只是求n和m的公共前缀
步骤：右移s步直到相等，然后左移s步就是公共前缀
 */
class Solution3 {
    public int rangeBitwiseAnd(int m, int n) {
        int step=0;
        while (m<n) {
            m=m>>1;
            n=n>>1;
            step++;
        }
        return m << step;
    }
}