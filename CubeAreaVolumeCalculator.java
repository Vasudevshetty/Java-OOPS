/*Create a class of objects CUBE. Develop an application to read the side for three cubes and print the 
 * volume and the outer area.*/

import java.util.Scanner;

// create a class cube to have its side length and methods to calculate volume and outer area.
class Cube{
    private double sideLength;

    // create a constructor to create a cube.
    public Cube(double sideLength){
        this.sideLength = sideLength;
    }

    // function to calculate the volume of the cube.
    public double getVolume(){
        return sideLength*sideLength*sideLength;
    }

    // function to calculate the outer area. which is 6 times the area of square.
    public double getOuterArea(){
        return sideLength*sideLength*6;
    }
}

public class CubeAreaVolumeCalculator {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        
        for(int i = 1; i<=3; i++){
            System.out.print("Enter the side length of the cube "+i+": ");
            double sideLength = s.nextDouble();

            if(sideLength < 0){
                System.out.println("Side length cannot be negative.");
                continue;
            }

            // if the side is valid create a new object calculate the area and volume display.
            Cube cube = new Cube(sideLength);

            double volume = cube.getVolume();
            double outerArea = cube.getOuterArea();

            System.out.println("Outer surface area of the cube " + i + ": " + outerArea);
            System.out.println("Volume of the cube " + i + ": " + volume);
            System.out.println();
        }

        s.close();
    }
}
