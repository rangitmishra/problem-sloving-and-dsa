package codingPatterns.leetcode;

/*
https://www.youtube.com/watch?v=SoxrXQbhCPI

example:   -->
[1,2,3]      [3,6,9]
[4,5,6]      [2,5,8]
[7,8,9]      [1,4,7]

Transpose:
[
1,4,7
2,5,8
3,6,9
]
Then Reverse:

 */
public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        printer(mat);
        transpose(mat);
        System.out.println("---------------");
        printer(mat);
        System.out.println("---------------");
        reverseColumn(mat);
        printer(mat);
    }

    private static void reverseColumn(int[][] mat) {
        for(int i=0;i<mat[0].length;i++){
            int b = 0;
            int e = mat.length-1;
            while (b<e){
                int temp = mat[b][i];
                mat[b][i] = mat[e][i];
                mat[e][i] = temp;
                b++;
                e--;
            }
        }

    }

    private static void transpose(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=i;j<mat[0].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

    }

    private static void printer(int[][] mat) {
        for (int[] row : mat) {
            for (int i = 0; i < mat[0].length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
}
