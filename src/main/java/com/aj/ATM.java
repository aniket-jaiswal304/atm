package com.aj;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class ATM
{
    Scanner input = new Scanner(System.in);
    int balance = 1000;

    public void getMainMenu()
    {
        int selection;
        System.out.println("\nATM Main Menu");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Add funds");
        System.out.println("4. Exit");
        System.out.print("\nEnter Choice: ");

        selection = input.nextInt();
        switch (selection)
        {
            case 1:
                viewBalance();
                break;
            case 2:
                withdrawFunds();
                break;
            case 3:
                addFunds();
                break;
            case 4:
                System.out.println("Thanks for using this ATM!!");
                break;
            default:
                System.out.println("Invalid choice. Please try again!!");
                getMainMenu();
        }
    }

    public int userAccount()
    {
        int accountNo;
        System.out.print("Enter your account number: ");
        accountNo = input.nextInt();
        return accountNo;
    }

    public int userPin()
    {
        int pin;
        System.out.print("Enter your pin number: ");
        pin = input.nextInt();
        return pin;
    }

    public void startATM()
    {
        userAccount();
        userPin();
        getMainMenu();
    }

    public void viewBalance()
    {
        System.out.println("Current Balance: " + balance);
        getMainMenu();
    }

    public void addFunds()
    {
        int depositAmount;
        System.out.print("Please enter amount: ");
        depositAmount = input.nextInt();

        balance += depositAmount;
        System.out.println("Rs." + depositAmount + " deposited");
        getMainMenu();
    }

    public void withdrawFunds()
    {
        int amount;
        do
        {
            System.out.println("Select Amount:");
            System.out.println("=> 100");
            System.out.println("=> 500");
            System.out.println("=> 1000");
            System.out.print("Enter Amount: ");
            amount = input.nextInt();
            if(amount != 100 && amount != 500 && amount != 1000)
                System.out.println("Invalid amount!!");
        } while (amount != 100 && amount != 500 && amount != 1000);


        if(balance < amount)
        {
            System.out.println("Insufficient Funds!!\n");
            withdrawFunds();
        }
        else
        {
            balance -= amount;
            System.out.println("Rs." + amount + " withdrawn");
            getMainMenu();
        }
    }

    public static void main( String[] args )
    {
        ATM atm = new ATM();
        atm.startATM();
    }
}
