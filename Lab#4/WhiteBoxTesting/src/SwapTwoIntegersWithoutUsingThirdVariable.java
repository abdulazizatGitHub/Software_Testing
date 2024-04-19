/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abdul
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class SwapTwoIntegersWithoutUsingThirdVariable {
    public static void swapNumbers(int num1, int num2) {
        
        if (num1 == num2) {
            System.out.println("Both numbers are same. No need for swapping");
        } else {
            System.out.println("Numbers before swapping are:\nnum1 = " + num1 + " , " + "num2 = " + num2);
            
            num1 = num1 + num2;
            num2 = num1 - num2;
            num1 = num1 - num2;
        
            System.out.println("\nNumbers after swapping is:\nnum1 = "+ num1 + " , " + "num2 = " + num2);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int num1;
            int num2;
        
            System.out.println("Enter first number:");
            num1 = scanner.nextInt();
            System.out.println("Enter second number:");
            num2 = scanner.nextInt();
            
            swapNumbers(num1 , num2);
            
        } catch (InputMismatchException e) {
            System.out.println("Inavlid Input please enter a integer value.");
        }
        scanner.close();
    }
}
