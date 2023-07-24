package codingPatterns.xor;

/*
Example 1
a = 5 (101)
right most set bit mask will be - 001 (1)

a = 7 (111)
right most set bit mask will be - 001 (1)
 */
public class RightMostSetBitMask {

    public static void main(String[] args) {
        int a = 5;
        int rmsbm = a & (-a);
        /*
        a = 101
        -a = a1's complement + 1 = 010 + 1 = 011
        a & -a = 101 & 011 = 001
         */
        System.out.println(rmsbm);
    }
}
