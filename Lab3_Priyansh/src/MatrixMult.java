/**
 * importing java libraries
 */

import java.util.Scanner;

public class MatrixMult {

    public static void main(String[] args) {

        /**
         * Variables of time measurements
         */
        long startTime, endTime, executionTime;


        /**
         * Scanner scan will scan inputs for the size and values
         */
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int value = scan.nextInt();

        double[][] a = new double[size][size];
        double[][] b = new double[size][size];


        /**
         * readins the matrices 1 and 2
         */
        for (int i = 0; i <size ; i++)
            for (int j = 0; j <size ; j++)
                a[i][j]=value;

        //System.out.println("----------------------------");

        /**
         * nested loop
         */
        for (int i = 0; i <size ; i++)
            for (int j = 0; j <size ; j++)
                b[i][j]=value;

/*
        //printing matrix 1 and matrix 2
        System.out.println("Matrix A");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Matrix B");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
*/


        //declaring a matrix to store the result of the multiplication of matrix 1 and matrix 2
        double[][] resultmatrix = new double[size][size];
        /**
         * time measurement for the above method to work
         */
        startTime = System.currentTimeMillis();
        resultmatrix = multiplyMatrix(a,b);
        endTime = System.currentTimeMillis();
        executionTime=endTime-startTime;


/*
        //printing the resultant matrix
        System.out.println("Matrix Result");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(resultmatrix[i][j] + "\t");
            }
            System.out.println();
        }
*/

        System.out.println("Size:"+size+" Time:"+executionTime+" ms");


    }

    /**
     * multiplies the 2 matrices
     * @param a
     * @param b
     * @return
     */
    public static double[][] multiplyMatrix(double[][] a, double[][] b){

        double[][] resultMatrix = new double[a.length][a.length];

        //YOUR WORK STARTS HERE
        /**
         * nested loop for the result Matrix
         */
        for(int i=0; i< a.length;i++){
            for(int j=0;j<a.length;j++){
                resultMatrix[i][j]=0;

                for(int k=0; k< a.length; k++){
                    resultMatrix[i][j] += a[i][k]*b[k][j];
                }
            }
        }

        return resultMatrix;

    }


}
