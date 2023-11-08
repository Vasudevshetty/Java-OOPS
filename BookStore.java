/*Write a program to read a list containing Book Title, Book Code, Cost and 
Quantity interactively for min. of 10 books and produce a five column output 
as shown below.
NAME CODE UNIT PRICE QUANTITY TOTAL PRICE
Define the suitable functions and perform the transactions */

import java.util.Scanner;

// create a class book containg the follwoing members.
// can be made the book information public (members) instead used getters and setters to ensure encapsulation (data hiding)
class Book {
    private String title;
    private String code;
    private double cost;
    private int quantity;

    public Book(String title, String code, double cost, int quantity) {
        this.title = title;
        this.code = code;
        this.cost = cost;
        this.quantity = quantity;
    }

    // getter methods
    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    // setter methods is for only quantity and cost, coz it varies...
    // setter methods for title and code not needed assuming it is constant and and
    // set during creation of object.
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // method to return the total price.
    public double getTotalPrice() {
        return cost * quantity;
    }
}

public class BookStore {
    // create a method to calculate total cost of the books.
    public static double calculateTotalCost(Book[] books){
        double totalCost = 0;
        for(Book book: books){
            totalCost += book.getTotalPrice();
        }
        return totalCost;
    }

    // create a method to display the details of the books present.
    public static void displayInformation(Book[] books){
        System.out.println("\nName\t\tCode\t\tCost\t\tQuantity\t\tTotalPrice\n");
        for(Book book: books){
            // indent the way you want
            System.out.println(
                book.getTitle() + "\t\t" +
                book.getCode() + "\t\t" +
                book.getCost() + "\t\t" +
                book.getQuantity() + "\t\t" +
                book.getTotalPrice()
            );
        }

        double totalCost = calculateTotalCost(books);
        System.out.println("Total cost : " + totalCost);
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        // create a array of books(objects)
        int bookNum = 2;
        Book[] books = new Book[bookNum];

        for(int i = 0; i < bookNum; i++){
            System.out.println("\nEnter details for book " + (i+1) + ", ");
            System.out.print("Title : ");
            String title = scan.nextLine();
            System.out.print("Code : ");
            String code = scan.nextLine();
            System.out.print("Cost : ");
            double cost = scan.nextDouble();
            System.out.print("Quantity : ");
            int quantity = scan.nextInt();

            scan.nextLine();// consume next line.

            // create the object using constructor.
            books[i] = new Book(title, code, cost, quantity);
        }

        // call the display function.
        displayInformation(books);

        scan.close();
    }
}
