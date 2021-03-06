/*Omkar Raskar
  SEITB232
  OOP Project
*/
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Omkar", "B32");
        obj1.showMenu();
    }
        
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount){
        if(amount !=0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount!=0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn: "+Math.abs(previousTransaction));
        }
        else{
            System.out.println("No Transaction occurred");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println(" ");
        
        do{
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            System.out.println("=====================================================================");
            System.out.println("Enter an option");
            System.out.println("=====================================================================");
            System.out.println("");
            option = scanner.next().charAt(0);
            System.out.println(" ");

            switch(option){

            case 'A':
                System.out.println("------------------------------------------------------");
                System.out.println("Balance = "+balance);
                System.out.println("------------------------------------------------------");
                System.out.println(" ");
                break;

            case 'B':
                System.out.println("------------------------------------------------------");
                System.out.println("Enter an amount to deposit");
                System.out.println("------------------------------------------------------");
                int amount = scanner.nextInt();
                deposit(amount);
                System.out.println(" ");
                break;

            case 'C':
                System.out.println("------------------------------------------------------");
                System.out.println("Enter an amount to withdraw");
                System.out.println("------------------------------------------------------");
                int amount2 = scanner.nextInt();
                withdraw(amount2);
                System.out.println(" ");
                break;

            case 'D':
                System.out.println("------------------------------------------------------");
                getPreviousTransaction();
                System.out.println("------------------------------------------------------");
                System.out.println(" ");
                break;

            case 'E':
                System.out.println("******************************************************");
                break;
                

            default :
                System.out.println("Invalid Option!! Please Enter again");
            }
        }while(option !='E');

        System.out.println("Thank You For Using Our Services");
        
        scanner.close();
    }
}
