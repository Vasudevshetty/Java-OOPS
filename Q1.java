/*a) Generate prime numbers for the given range.
b) Find all the roots of a quadratic equation.
c) Print ‘N’ Fibonacci numbers.
d) Print pyramid shape using * symbols */

import java.util.Scanner;

// for this question created static functions for each and every sub problem.
public class Q1 {
    static Scanner scan = new Scanner(System.in);

    // method to print the prime no in the given range.
    public static void primeNumber() {
        System.out.print("Enter the range (low - high): ");
        int low = scan.nextInt();
        int high = scan.nextInt();
        System.out.println("Prime numbers in the range (" + low + "-" + high + "),");
        for (int num = low; num < high; num++) {
            boolean flag = false;
            for (int i = 2; i < (num / 2); i++) {
                if (num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.printf("%d ", num);
            }
        }
    }

    // method to find all the roots of quadratic equation.
    public static void quadraticRoots() {
        System.out.print("Enter the co-effcients of the equation (ax^2 + bx + c): ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if(discriminant > 0){
            double root1 = (-b + Math.sqrt(discriminant));
            double root2 = (-b - Math.sqrt(discriminant));
            System.out.println("Root1 : " + root1);
            System.out.println("Root2 : " + root2);
        }else if(discriminant == 0){
            double root = -b / (2*a);
            System.out.println("Roots are : " + root);
        }else{
            double realPart = -b / (2*a);
            double imaginaryPart = Math.sqrt(-discriminant)/(2*a);
            System.out.println("Real part is " + realPart);
            System.out.println("Imaginary part is " + imaginaryPart);
        }
    }

    // method to print fibonacci sequence
    public static void fibonacci() {
        System.out.print("Enter n : ");
        int n = scan.nextInt();

        int first = 0;
        int second = 1;
        System.out.print(first + " " + second + " ");
        int third = first + second;

        while (n > 0) {
            System.out.print(third + " ");
            first = second;
            second = third;
            third = first + second;
            n--;
        }
    }

    // method to print pyramid shape using *
    public static void printPyramid(){
        int space = 4;
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= space; j++){
                System.out.print("  ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            for(int j = 0; j < i-1; j++){
                System.out.print("* ");
            }
            space--;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        System.out.println("1. Print prime no in the range");
        System.out.println("2. Print fibanocii for n");
        System.out.println("3. Find the roots of quadratic equation.");
        System.out.println("4. Print pyramid pattern.");
        System.out.println();
        System.out.print("Enter the choice: ");
        int choice = scan.nextInt();
        System.out.println();
        switch(choice){
            case 1: primeNumber();
            break;
            case 2: fibonacci();
            break;
            case 3: quadraticRoots();
            break;
            case 4: printPyramid();
            break;
            default: System.out.println("Invalid choice.");
            break;
        }
        scan.close();
    }
}
