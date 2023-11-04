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
class Account{
    private String name;
    private long accountNumber;
    private String accountType;
    private double balance;

    // create a static member to track no of accounts created.
    private static int noOfAccounts = 0;

    // construct the objects accorindly.
    Account(String name, long accountNumber, String accountType, double balance){
        // indicate the usage of this keyword.
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;

        // increment the static member since addition of a account,
        noOfAccounts++;
    }

    // method to deposit an amount
    public void deposit(double amount){
        balance += amount;
        // need not to worry about default value since in java default is zero.
    }

    // method to withdraw amount from the account upon checking the balance.
    public void withdraw(double amount){
        if(amount >= balance){
            balance -= amount;
            // decrement or take out the amount.
        }else{
            System.out.println("Insufficient balance to withdraw.");
        }
    }

    // method to display name and balance.
    public void display(){
        System.out.println("Account details,");
        System.out.println("Account holder name : "+ name);
        System.out.println("Account number : "+ accountNumber);
        System.out.println("Account type : "+ accountType);
        System.out.println("Balance : "+ balance);
    }

    // method to get the total number of accounts 
    public static int getNoOfAccounts(){
        return noOfAccounts;
    }
}


// create a execute account class to handle the account and define main method in this class.
public class ExecuteAccount {
    public static void main(String args[]){
        // as said create a array of account class.
        Account[] accounts = new Account[5];

        // either get the details from the user (Scanner) or initalise.
        // accounts[0] = new Account("vasu", 0, "savings", 0);
        // accounts[1] = new Account(null, 0, null, 0);
        // accounts[2] = new Account(null, 0, null, 0);
        // accounts[3] = new Account(null, 0, null, 0);
        // accounts[4] = new Account(null, 0, null, 0);
    
        // accounts[0].deposit(1000);
        // accounts[0].withdraw(1000);

        // display information of accounts.
        for(Account account : accounts){
            account.display();
            System.out.println();
        }

        // Get the total no of accounts. since it is a static method it can be invoked using class name itself.
        System.out.println("Total Account holders : " + Account.getNoOfAccounts());

    }
}
