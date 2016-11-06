package com.springRestTests;

public class JavaTestApp {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };


        int temp;
        for (int i=0; i< array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++)
            {
                if (array[i] < array[j])
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i=0; i< array.length ; i++){
            System.out.println(array[i]);
        }


        int[][] array2 = new int[2][3];

        array2[0][0] = 1;
        array2[0][1] = 2;
        array2[0][2] = 3;
        array2[1][0] = 4;
        array2[1][1] = 5;
        array2[1][2] = 6;

        for (int i = 0; i <= 2; i++) {

            System.out.print(array2[0][i] + "\t");

        }

        System.out.println("");

        for (int i = 2; i >= 0; i--) {

            System.out.print(array2[1][i] + "\t");

        }
    }
}
