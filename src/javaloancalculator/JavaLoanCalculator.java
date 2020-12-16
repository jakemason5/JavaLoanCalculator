/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaloancalculator;
import java.util.Scanner;
/**
 *
 * @author Jacob
 */
public class JavaLoanCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char again;//needed for repetition of program
        
        //Welcoming User and introducing program
        System.out.println("Welcome to the Java Loan Amortization Calculator");
        System.out.println("This program is used to help you structure your "
                + "loan payments.");
        System.out.println("Let us begin:");
        
        do{
        //Asking for user input for information
        System.out.print("\n\nEnter the loan amount: $");
        Scanner input = new Scanner(System.in);
        double loan = input.nextDouble(); //varaible for loan amount
        
        System.out.print("Enter the number of months for the loan: ");
        Scanner input2 = new Scanner(System.in);
        int months = input2.nextInt(); //variable for months until payed full
        
        System.out.print("Enter the APR you have been quoted: ");
        Scanner input3 = new Scanner(System.in);
        double apr = input3.nextDouble(); //variable for interest amount
        
        //Creating monthly interest rate
        double mrate = (apr/1200);
        System.out.println(mrate);
        
        //Informing the user on the monnthly payment and total payed
        double monthpay =  (mrate * loan)/(1-Math.pow(1+mrate, -months));
      //Equation for monthly payment
        System.out.print("Your monthly payment will be: ");
        System.out.printf("%.2f\n", monthpay);
        
        double totalPay = monthpay * months;
        System.out.print("The total you will pay (with interest) will be: ");
        System.out.printf("%.2f\n", totalPay);
        
        //Setting up a schedule table
        System.out.println("\n\nYour Amortization Schedule is\n\n");
        System.out.println("Payment#\t Interest\t Principal\t Balance");
        
        //Looping the data inside of the table
        //double principal = loan;
        double newloan = loan;
        for(int i=1; i<=months; i++)
        {
            double interest = (mrate * newloan);
            double principalpay = (monthpay - interest);
            newloan -= principalpay;
            System.out.print(i+"\t\t  ");
            System.out.printf("$%.2f           ", interest);
            System.out.printf("$%.2f         ", principalpay);
            System.out.printf("$%.2f\n", newloan);
        }
        
        
        //Promping user for restarting the program
        System.out.print("\nWould you like to run the program agian?(Y/N): ");
        Scanner inputq = new Scanner(System.in);
        again = inputq.next().charAt(0);
        } while ( again == 'Y');
    System.out.println("Thank you for using the Loan Amortization Calculator"
            + "Goodbye.");
    } 
    
}
