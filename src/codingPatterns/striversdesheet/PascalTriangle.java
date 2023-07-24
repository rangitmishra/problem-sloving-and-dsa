package codingPatterns.striversdesheet;

/*
Q1. print pascal triangle

   1
  1 1
 1 2 1
1 3 3 1

Problem Statement: This problem has 3 variations. They are stated below:

Variation 1: Given row number r and column number c. Print the element at position (row, col) in Pascal’s triangle.
sol : nCr = where n = row -1; and r = col -1

Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
first element will be 1, after that use this formula --> Current element = prevElement * (rowNumber - colIndex) / colIndex

Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle
--> use variation 2 n times
 */

public class PascalTriangle {

    public static void main(String[] args) {
        // Variation 2
        // printRowN(5);

        // Variation 3

        for(int i=1;i<6;i++){
            printRowN(i);
            System.out.println();
        }
    }

    private static void printRowN(int row) {
        int prevElement = 1;
        for(int col=1;col<row;col++){
            System.out.print(prevElement + " ");
            prevElement = prevElement * (row-col)/col;
        }
        System.out.print(prevElement);
    }


}
