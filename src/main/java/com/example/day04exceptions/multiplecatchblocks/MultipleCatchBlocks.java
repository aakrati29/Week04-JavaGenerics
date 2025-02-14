package com.example.day04exceptions.multiplecatchblocks;

import java.util.Scanner;

public class MultipleCatchBlocks {

    public static void multipleCatches(int[] arr, int number){

        try{
            int a = arr[0];
            System.out.println(arr[1]/number);
            System.out.println(arr[3]);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occur");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception occur, enter valid input");
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception occur");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number : ");
        int number = s.nextInt();

        int[] arr = {10,20,30};
        int[] arr1 = null;

        multipleCatches(arr, number);
        multipleCatches(arr1, number);
    }
}



