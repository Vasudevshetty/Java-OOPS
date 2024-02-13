// Question 2. 

/*Define a class to represent a bank ACCOUNT and include the following 
members:
    
    I. Data Members(States):
    a) Name of Depositor
    b) Account number
    c) Type of Account
    d) Balance amount in the account
    
    II. Member Methods(Behaviors):
    a) To assign initial values 
    b) To deposit an amount 
    c) To withdraw an amount after checking for the balance
    d) To display name & balance
    
    III. Define EXECUTEACCOUNT class that defines main method to test 
    above class.
    
    IV. In the above class, maintain the total number of account holders 
    present in the bank and also define a method to define it. Change the 
    main method appropriately.
    
    V. In main method of EXECUTEACCOUNT class, define an array to 
    handle five accounts.
    
    VI. In ACCOUNT class constructor, demonstrate the use of “this” 
    keyword*/

// create a account class with members and methods.
import java.util.Scanner;

class Account {
    private String name;
    private long accountNumber;
    private String accountType;
    private double balance;

    // create a static member to track no of accounts created.
    private static int noOfAccounts = 0;

    // construct the objects accorindly.
    public Account(String name, long accountNumber, String accountType, double balance) {
        // indicate the usage of this keyword.
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;

        // increment the static member since addition of a account,
        noOfAccounts++;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    // method to deposit an amount
    public void deposit(double amount) {
        balance += amount;
        // need not to worry about default value since in java default is zero.
    }

    // method to withdraw amount from the account upon checking the balance.
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            // decrement or take out the amount.
        } else {
            System.out.println("Insufficient balance to withdraw.");
        }
    }

    // method to display name and balance.
    public void display() {
        System.out.println("Account details,");
        System.out.println("Account holder name : " + name);
        System.out.println("Account number : " + accountNumber);
        System.out.println("Account type : " + accountType);
        System.out.println("Balance : " + balance);
    }

    // method to get the total number of accounts
    public static int getNoOfAccounts() {
        return noOfAccounts;
    }

    public double getBalance() {
        return this.balance;
    }
}

// create a execute account class to handle the account and define main method
// in this class.
public class ExecuteAccount {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // as said create a array of account class.
        System.out.print("Enter the number of Account holders: ");
        int n = scan.nextInt();
        Account[] accounts = new Account[n];

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Enter the details of the account holder " + (i + 1) + ",");
            System.out.print("Enter the name : ");
            String name = scan.next();
            System.out.print("Enter the account number : ");
            long accountNumber = scan.nextLong();
            System.out.print("Enter the account type : ");
            String accountType = scan.next();
            System.out.print("Enter the Balance : ");
            double balance = scan.nextDouble();

            accounts[i] = new Account(name, accountNumber, accountType, balance);
            System.out.println("\n");
        }

        int choice;
        do {
            System.out.println();
            System.out.println("Menu.\n1. Deposit\n2. Withdraw\n3. Exit");
            System.out.print("Enter choice : ");
            choice = scan.nextInt();
            int idx;
            if (choice != 3) {
                System.out.print("Enter the account number : ");
                long accountNumber = scan.nextLong();
                for (idx = 0; idx < accounts.length; idx++) {
                    if (accountNumber == accounts[idx].getAccountNumber())
                        break;
                }
                if (idx == accounts.length) {
                    System.out.println("Enter valid account number only.");   
                    continue;
                }
                System.out.println();
                System.out.println("The details of the account number is : ");
                accounts[idx].display();
                System.out.println();
                System.out.print("Enter the amount to " + (choice == 1 ? "deposit :  " : "withdraw : "));
                double amount = scan.nextDouble();
                if (choice == 1)
                    accounts[idx].deposit(amount);
                else
                    accounts[idx].withdraw(amount);
                System.out.println("The balance is " + accounts[idx].getBalance());
                System.out.println();
            }
        } while (choice != 3);

        System.out.println();
        // Get the total no of accounts. since it is a static method it can be invoked
        // using class name itself.
        System.out.println("Total Account holders : " + Account.getNoOfAccounts());

        scan.close();
    }
}
