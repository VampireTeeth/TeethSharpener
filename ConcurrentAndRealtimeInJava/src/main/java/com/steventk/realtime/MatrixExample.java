package com.steventk.realtime;


public class MatrixExample {

    private int [][][] table;
    private static int [][] unity = {{1, 0}, {0, 1}};
    public MatrixExample(int size) {
        table = new int[size][2][2];
        //Initialize the table
    }
    
    public int match(int[][] matrix) {
        int found = 0;
        for(int i = 0; i < table.length; i++) {
            int [][] product = dotProduct(table[i], matrix);
            if(equals(product, unity)) {
                found++;
            }
        }
        return found;
    }
    
    private int[][] dotProduct(int[][] matrix1, int[][] matrix2){
        int [][] result = new int[2][2];
        return result;
    }
    
    private boolean equals(int[][] a, int [][] b) {
        
        return true;
    }
}
