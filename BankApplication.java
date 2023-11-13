/*Develop an application with an abstract Bank class consisting of below 
features:
a) Bank_Type (National/International)
b) getRoi() is an abstract method
c) deposit()
d) offerCreditCard
 Identify various (atleast 4) banks which will extend bank class with below 
conditions:
o If the bank is type of nationalized the roi is 7% else 8%. The interest is 
offered only if the term deposit is minimum of 3 years.
o If the bank is international, then it can offer platinum credit card 
otherwise not.
o Override one of the method and use the concept of dynamic method 
dispatch */

// create a abstract class bank and have methods to over ride.
abstract class Bank{
    private String bankType;
    double roi;

    public Bank(String bankType){
        this.bankType = bankType;
    }

    // create a abstract roi calculating method which can be overrided.
    public abstract double getRoi();
    
    public void deposit(double amount){
        // can add required deposit logic.
        System.out.println("Amount " + amount + " deposited in " + bankType + " bank for your acoount.");
    }

    public void offerCreditCard(){
        // again can add required credit card logic.
        System.out.println(bankType + " Doesn't Offeres Credit card.");
    }
    // later override the method.

    // getters method./\
    public String getBankType(){
        return bankType;
    }
}   

// create a class extending from bank class
class NationalBank extends Bank{
    private int termDeposit;

    public NationalBank(String bankType, int termDeposit){
        super(bankType); // obsere the usage of super keyword.
        this.termDeposit = termDeposit;
    }
    @Override
    public double getRoi(){
        if(termDeposit >= 3){
            roi = 0.07; // 7%
        }else roi = 0.08; // 8%

        return roi;
    }
    // override the deposit method to deposit amount for a minimum of 3 years.
    @Override
    public void deposit(double amount){
        System.out.println("Amount " + amount + " deposited in " + getBankType() + " bank to your acoount for a minimum of 3 years.");
    }

    // override the credit card method
    @Override 
    public void offerCreditCard(){
        System.out.println("Offers Credit card.");
    }
}

// similarly create one more nationalized bank with your own overrided type. 

// a internation bank type class extending bank
class InternationalBank extends Bank{
    public InternationalBank(String bankType){
        super(bankType); // invoke the constructor  of super class.
    }    

    // over ride the get roi method.
    @Override
    public double getRoi(){
        return 0.08; // 8%
    }

    // if needed add a new termdeposit varible and add logic to override deposit method.

    // override the credit card method.
    @Override
    public void offerCreditCard(){
        System.out.println("Platinum credit card offered by " + getBankType() + " bank.");
    }

}

public class BankApplication {
    public static void main(String args[]){
        // create objects using its parent class (Dyanmic method dispatch)
        Bank bank = new NationalBank("National", 155550);
        Bank bankI = new InternationalBank("Internation");

        System.out.println(bank.getRoi());
        bank.deposit(789); 
        bank.offerCreditCard();
        System.out.println();
        System.out.println(bankI.getRoi());
        bankI.offerCreditCard();
    }
}   
