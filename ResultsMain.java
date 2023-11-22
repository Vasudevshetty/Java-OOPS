/*Student class consists the following attributes:
a) roll number
b) read Number(): to initialize roll number
c) print Number(): to display the roll number
 class Test inherits Student and will identify marks for 2 subjects for each 
student and will display the same.
 Each student can also be recognized with sports weightage using an 
interface Sports which will have attributes to assign weightage value and 
display it. Each Student is rated with total score which is the summation of 
marks in 2 subjects and sports weightage.
 Develop an application Results to extend Test and implement Sports 
which displays the student score card as below:
Roll No
Marks Obtained in Subject-1 and Subject-2
Sports weight
Total Score  */

// created a interface for sports having attributes
interface Sports{
    void assignWeightage(double sportsWeightage);
    void displayWeightage();
}

// created a students class 
class Students{
    private int roll_no;

    public void readNumber(int roll_no){
        this.roll_no = roll_no;
    }
    public void printNumber(){
        System.out.println("The roll no of the student is " + roll_no);
    }
}


// class test inheriting students and identifies two marks and calcualtes total score getting weightage from the resutls class
class Test extends Students {
    double subject1Marks;
    double subject2Marks;

    public void identifyMarks(double subject1Marks, double subject2Marks){
        this.subject1Marks = subject1Marks;
        this.subject2Marks = subject2Marks;
    }
    
    public double calculateTotalScore(double sportsWeightage){
        return subject1Marks + subject2Marks + sportsWeightage;
    }
    
    public void displayScoreCard(){
        printNumber();
        System.out.println("Subject 1 marks is " + subject1Marks);
        System.out.println("Subject 2 marks is " + subject2Marks);
    }   
}


// here is the resutls class which overrides the methods and make necessary actions.
class Results extends Test implements Sports{
    private double sportsWeightage;
    
    // weightage of the sports is assigned here and displayed (the logic can be changed when and how required.)
    @Override
    public void assignWeightage(double sportsWeightage){
        this.sportsWeightage = sportsWeightage;
    }
    @Override 
    public void displayWeightage(){
        System.out.println("Weightage from sports is " + sportsWeightage);
    }

    // upon identifying the sports weightage of the porticular student override again the display score card function
    @Override
    public void displayScoreCard(){
        super.displayScoreCard(); // invoke the function of the inherited class.
        displayWeightage();
        double totalScore = calculateTotalScore(sportsWeightage);
        System.out.println("Total score is " + totalScore);
    }
}


// example of how the program works can be done by using a scanner and input from the user also.
public class ResultsMain{
    public static void main(String args[]){
        Results student = new Results();
        student.readNumber(62);
        student.identifyMarks(89.5, 89.2);
        student.assignWeightage(34.4);
        student.displayScoreCard();
    }
}
