package codingPatterns.leetcode;

/*

 */
public class RatInMaze {

    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };

        int n = arr.length;
        int m = arr[0].length;
        int[][] ans = new int[n][m];

        solve(arr, ans, 0,0);
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean solve(int[][] arr, int[][] ans, int r, int c) {
        int n = arr.length;
        int m = arr[0].length;
        if(!isValid(arr, r, c)){
            return false;
        }
        ans[r][c] = 1;
        if(r == n-1 && c == m-1){
            return true;
        }
        boolean forward = solve(arr, ans, r, c+1);
        if(forward){
            return true;
        }
        boolean downward = solve(arr, ans, r+1, c);
        if(downward){
            return true;
        }
        ans[r][c] = 0;
        return false;
    }

    private static boolean isValid(int[][] arr, int r, int c) {
        if(r >= arr.length || c > arr[0].length || arr[r][c] == 0){
            return false;
        }
        return true;
    }
}
