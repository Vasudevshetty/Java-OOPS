/*The annual examination results of 20 students are to be tabulated as follows:
Roll No. Subject-1 Subject-2 Subject 3
Develop an application to read the data and determine the following:
a) Total marks obtained by each student.
b) The highest marks in each subject and the Roll No. of the student.
c) The student who obtained the highest total marks. */


import java.util.Scanner;


// create a class student private information rollnumber and marks of subjects.
class Student{
    private int rollNumber;
    private int[] subjectMarks = new int[3];
    // making this public makes the task of finding highest marks in each subject things but that gives access to the marks
    // which results in inapporiprate changes to the marks.

    // constructor to create the student obj with roll no and marks.
    public Student(int rollNumber, int[] subjectMarks){
        this.rollNumber = rollNumber;
        this.subjectMarks = subjectMarks;
    }

    // getter method to the roll no.
    public int getRollNumber(){
        return rollNumber;
    }

    // getter method to the marks of the respective subject entered.
    public int getSubjectMarks(int subjectNumber) {
        if (subjectNumber >= 1 && subjectNumber <= 3) {
            return subjectMarks[subjectNumber - 1];
        } else 
        throw new IllegalArgumentException("Invalid subject number"); // upon finding the no as invalid throws a exception. 
    }
    
    // getter method for the total marks.
    public int getTotalMarks(){
        int total = 0;
        for(int marks : subjectMarks){
            total += marks;
        }
        return total;
    }
}


// create a class which extends main method and performs necessary actions.

public class StudentMarksApplication {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        Student[] students = new Student[3];
        // create a array of objects for 20 students
    
        // fetch the information from the user.
        for(int i = 0; i < 3; i++){
            // input the roll no
            System.out.print("\nEnter the roll number of the student : ");
            int rollNumber = scan.nextInt();
            System.out.println();

            // input the marks one by one using a array and a loop.
            int[] subjectMarks = new int[3];    
            for(int j = 0; j < 3; j++){
                System.out.print("Enter the marks of the Subject " + (j+1) + " : ");
                subjectMarks[j] = scan.nextInt();
            }
            
            // construct the student object with inputted necessary information.
            students[i] = new Student(rollNumber, subjectMarks);
        }
        System.out.println();

        // calculate the total marks and display the marks of each subject along side the roll no.
        System.out.println("Results.");
        System.out.println("Roll no.\tSubject-1\tSubject-2\tSubject-3\tTotal Marks");
        for(Student student : students){

            // indent the way you want to display.

            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n", student.getRollNumber(), student.getSubjectMarks(1),
            student.getSubjectMarks(2), student.getSubjectMarks(3), student.getTotalMarks());
        }

        System.out.println();

        // Now process the information for highest in each subject and highest total marks.
        // create varialbes to store all those information.
        int[] maxSubjectMarks = new int[3];
        int[] maxRollNumber = new int[3];

        // initalise with -1 
        for(int i = 0; i < 3; i++) maxSubjectMarks[i] = maxRollNumber[i] = -1;

        for(Student student : students){
            for(int i = 0; i < 3; i++){
                // while traversing every student's subject check the marks whether it is the highest if found do necessary updation.
                int subjectMarks = student.getSubjectMarks(i+1);
                if(subjectMarks > maxSubjectMarks[i]){
                    maxSubjectMarks[i] = subjectMarks;
                    maxRollNumber[i] = student.getRollNumber();
                }
            }
        }
        
        // indent the way you want to display.
        for(int i = 0; i < 3; i++){
            System.out.println("Highest Score in Subject " + (i+1) + " is " + maxSubjectMarks[i] + " by Roll number " + maxRollNumber[i]);
        }

        // create variable for highest marks and his/her roll no
        int maxMarks = -1;
        int maxRollNo = -1;

        for(Student student : students){
            // traverse along if found the higest marks among the student make suitable updation.
            int totalMarks = student.getTotalMarks();
            if(totalMarks > maxMarks){
                maxMarks = totalMarks;
                maxRollNo = student.getRollNumber();
            }
        }

        // indent the way you want to display.
        System.out.println("Highest marks scored is " + maxMarks + " by Roll number " + maxRollNo);

        scan.close();
    }
}
