package project_java;

import java.util.Scanner;


class BankAccount{
	double balance;
	double previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String customerName, String customerId){
		this.customerName=customerName;
		this.customerId= customerId;
	}
	
	void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			previousTransaction=amount;
		}
	}
	
	void withdraw(double amt) {
		if(amt>0 && balance>=amt) {
			this.balance=balance-amt;
			previousTransaction=-amt;
		}
		else if(balance<amt) {
			System.out.println("Bank balance Insufficient");
		}
	}
	
	void getPreviousTransaction() 
	{
		if(previousTransaction>0)
		{
			System.out.println("Deposited: "+previousTransaction);
		}
		else if(previousTransaction<0)
		{
			System.out.println("Withdrawn: "+Math.abs(previousTransaction));
			
		}
		else {
			System.out.println("No transaction occured");
		}
		
	}
	
	void simpleIntrest() {
		double principal =balance ;
		double time;
		double rate;
		Scanner s= new Scanner(System.in);
		
		System.out.println("\nEnter rate");
		rate=s.nextDouble();
		System.out.println("\nEnter time");
		time=s.nextDouble();
		
		 double interest = (principal * rate * time) / 100;
		 System.out.println("Simple Interest: " + interest);
	}
	
	void menu() {
		char option;
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID: "+customerId);
		System.out.println("\n");
		System.out.println("a) Check Balance");
		System.out.println("b) Deposit Amount");
		System.out.println("c) Withdraw Amount");
		System.out.println("d) Previous Transaction");
		System.out.println("e) Simple Intrest ");
		System.out.println("f) Exit");
		
		do {
			System.out.println("************************************");
			System.out.println("Choose an Option");
			option=s.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'a':
				System.out.println("..............................");
				System.out.println("Balance ="+balance);
				System.out.println("..............................");
				System.out.println("\n");
				break;
			
			case 'b':
				System.out.println("..............................");
				System.out.println("Enter a amount to deposit :");
				System.out.println("..............................");
				double amt=s.nextDouble();
				deposit(amt);
				System.out.println("\n");
				break;
				
			case 'c':
				System.out.println("..............................");
				System.out.println("Enter a amount to withdraw :");
				System.out.println("..............................");
				double amtW=s.nextDouble();
				withdraw(amtW);
				System.out.println("\n");
				break;
			
			case 'd':
				System.out.println("..............................");
				System.out.println("Previous Transaction :");
				getPreviousTransaction();
				System.out.println("..............................");
				System.out.println("\n");
				break;
				
			case 'e':
				System.out.println("..............................");
				System.out.print("simpleIntrest ");
				System.out.println("\n");
				simpleIntrest();
		        System.out.println("..............................");
				System.out.println("\n");
				break;
				
			case 'f':
				System.out.println("..............................");
				break;
			}
			
		}
		while(option!='f');
		
		System.out.println("Thank you for using our banking services");
			
		}
		
	}
public class Bank {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		System.out.println("Enter your 'Name' and 'CustomerID' to access your bank account");
		String name=s.nextLine();
		String customerId=s.nextLine();
		BankAccount obj1=new BankAccount(name,customerId);
		obj1.menu();
		
	}
}
	