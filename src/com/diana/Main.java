package com.diana;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	/* String [][] tabla = new String[][]{
     new String[]{}
    };
        System.out.println(Arrays.deepToString(tabla));
*/

        String fName = "C:\\Users\\diana\\OneDrive\\Desktop\\2D_Array\\2021.csv";
        String thisLine;
        int count=0;
        FileInputStream fis = new FileInputStream(fName);
        DataInputStream myInput = new DataInputStream(fis);
        int i=0;

        String[][] data = new String[0][];//csv data line count=0 initially
        while ((thisLine = myInput.readLine()) != null) {
            ++i;//increment the line count when new line found

            String[][] newdata = new String[i][2];//create new array for data

            String strar[] = thisLine.split(";");//get contents of line as an array
            newdata[i - 1] = strar;//add new line to the array

            System.arraycopy(data, 0, newdata, 0, i - 1);//copy previously read values to new array
            data = newdata;//set new array as csv data
        }
        for (String[] strings : data) {
            for (String string : strings) {
                System.out.print("\t" + string);
            }
            System.out.println();
        }

        int rows, cols, sumRow, sumCol;
        //Calculates number of rows and columns present in given matrix
        rows = data.length;
        cols = data[0].length;

        //Calculates sum of each column of given matrix
        for(i = 7; i < 8;i++){
            sumCol = 0;
            for(int j = 1; j < rows; j++){
                sumCol = sumCol + Integer.parseInt(data[j][i]); //4840
            }
            System.out.println("Sum of " + (i+1) +" column: " + sumCol);
        }

    }
}
