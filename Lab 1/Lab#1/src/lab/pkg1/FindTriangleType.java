/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg1;

/**
 *
 * @author abdul
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class FindTriangleType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double side1, side2, side3;

        try {
            System.out.println("Enter the lengths of the sides of the triangle:");
            side1 = scanner.nextDouble();
            side2 = scanner.nextDouble();
            side3 = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid numeric input only.");
            return;
        }

        if (isValidTriangle(side1, side2, side3)) {
            String type = triangleType(side1, side2, side3);
            System.out.println("The triangle is " + type + ".");
        } else {
            System.out.println("Invalid triangle. The sum of the lengths of any two sides must be greater than the length of the remaining side.");
        }

        scanner.close();
    }

    public static boolean isValidTriangle(double side1, double side2, double side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    public static String triangleType(double side1, double side2, double side3) {
        if (side1 == side2 && side2 == side3) {
            return "equilateral";
        } else if (side1 == side2 || side1 == side3 || side2 == side3) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
