package com.mratcliff23;

import java.util.Scanner;

public class Matrix {
    private final Scanner in;
    private final int[][] mat;

    public Matrix(int rows, int cols){
        this.mat = new int[rows][cols];
        in = new Scanner(System.in);
    }

    public void fillMatrix(){
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[row].length; col++){
                System.out.print("Enter a value for the matrix at position ["+row+"]["+col+"]: ");
                mat[row][col] = in.nextInt();
            }
        }
    }

    public int[][] multiplyMatrices(int[][] secondMat){
        int[][] result = new int[mat.length][secondMat[0].length];
        if(mat[0].length != secondMat.length){
            throw new ArithmeticException("these matrcices cant be multiplied");
        }


        for(int resultRow = 0; resultRow < result.length; resultRow++) {
            for (int resultCol = 0; resultCol < result[0].length; resultCol++) {

                for(int i = 0; i < mat[0].length; i++){
                    result[resultRow][resultCol] += mat[resultRow][i] * secondMat[i][resultCol];
                }

            }
        }



        return result;
    }

    public int[][] addOrSubMatrices(int[][] secondMat, boolean adding){
        int[][] result = new int[mat.length][mat[0].length];
        if(mat.length != secondMat.length || mat[0].length != secondMat[0].length){
            throw new ArithmeticException("these matrices cant be added or subtracted");
        }
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                if(adding){result[row][col] = mat[row][col] + secondMat[row][col];}
                else{result[row][col] = mat[row][col] - secondMat[row][col];}
            }
        }

        return result;
    }

    public int[][] multiplyMatrix(int constant){
        int[][] result = new int[mat.length][mat[0].length];

        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[row].length; col++){
                result[row][col] = constant * mat[row][col];
            }
        }

        return result;
    }

    public int[][] getMat() {
        return mat;
    }

    public static void printMat(int[][] mat){
        for(int[] row: mat){
            for(int col: row){
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }
}