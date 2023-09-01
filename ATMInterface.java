package internship;
import java.util.Scanner;
class BankAccount{
	String name;
	String username;
	String password;
	String AccountNo;
	float balance=1000;
	int transaction=0;
	String transactionHistory="";
	



public void register() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your Name");
	this.name=sc.nextLine();
	System.out.println("Enter your UserName");
	this.username=sc.nextLine();
	System.out.println("Enter your Password");
	this.password=sc.nextLine();
	System.out.println("Enter your Account Number");
	this.AccountNo=sc.nextLine();
	System.out.println("Registration complete...!!");
}


public boolean login()
{
	boolean isLogin=false;
	Scanner sc=new Scanner(System.in);
	while(!isLogin){
		System.out.println("Enter your UserName");
		String Username=sc.nextLine();
		if(Username.equals(username)) {
			while(!isLogin){
				System.out.println("Enter your Password");
				String Password=sc.nextLine();
				if(Password.equals(password)) {
					System.out.print("Login Successful!!");
					isLogin=true;	
				}
				else
					System.out.print("Wrong Password");
					
				}

		} 
		else 
			System.out.print("User Not Found!!");
	}
	return isLogin;
		}

public void withdraw()
{
	System.out.println("Enter the amount to withdraw");
	Scanner sc=new Scanner(System.in);
	float amount=sc.nextFloat();
	try {
	if(balance>=amount)
	{
		transaction++;
		balance=balance-amount;
		System.out.println("withdrawn Sucessfully!!");
		String str=amount+"Rs withdrawned\n";
		transactionHistory=transactionHistory.concat(str);
		
	}
	else
		System.out.println("\n insufficient balance");
}catch(Exception e) {
	
}
}



	public void deposite()
	{
		System.out.println("Enter the amount to deposit");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
		if(amount>=500&&amount<=1000000)
		{
			transaction++;
			balance=balance+amount;
			System.out.println("Deposite Sucessfully!!");
			String str=amount+"Rs Deposite\n";
			transactionHistory=transactionHistory.concat(str);
			
		}
		else
			System.out.println("\n Sorry!! The limit is between 500 to 1000000");
		}catch(Exception e) {
		
		}
	}		

	
	public void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter receipent's name");
		String receipent=sc.nextLine();
		System.out.println("Enter the amount to transfer");
		float amount=sc.nextFloat();
		try {
		if(balance>=amount)
		{
			if(amount<5000) {
		
			transaction++;
			balance=balance-amount;
			System.out.println("Transfered Sucessfully to"+receipent);
			String str=amount+"Rs Transferd";
			transactionHistory=transactionHistory.concat(str);
			}
			else
				System.out.println("Sorry!! Limit is 5000");
		}
		else
			System.out.println("\n insufficient balance");
		}catch(Exception e) {
		
		}
	}	
	
	
	public void transHistory()
	{
		if(transaction ==0)
			System.out.println("\nEmpty!!");
		else
		System.out.println("\n"+transactionHistory);
	}
	
	
	
	public void checkBalance()
	{
		System.out.println("\n"+balance+"Rs");
	}
	
	

}
public class ATMInterface {

	public static int takeIntegerInput(int limit) {
		int input =0;
		boolean flag=false;
		while(!flag) {
			try { 
				Scanner sc= new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag&&input>limit||input<1)
				{
					System.out.println("choose the number between 1 to "+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("enter the integer value");
				flag=false;
			}
			
		};
		return input;
	}
	public static void main(String[] arg)
	{
		System.out.println("****WELCOME TO ATM SYSTEM****");
		System.out.println("1.REGISTER\n2.EXIT");
		System.out.println("Enter Your Choice");
		int  choice=takeIntegerInput(2);
		if(choice==1)
		{
			BankAccount b=new BankAccount();
			b.register();
			while(true){
				System.out.println("\n1.LOGIN\n2.EXIT");
				System.out.println("Enter Your Choice");
				int ch=takeIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("*****WELCOME BACK "+b.name+"*****");
						boolean isFinished=false;
						while(!isFinished){
							System.out.println("\n1.WITHDRAW\n2.DEPOSIT\n3.TRANSFER\n4.CHECKBALANCE\n5.HISTORY\n6.EXIT");
							System.out.println("Enter your choice");
							int c=takeIntegerInput(6);
							switch(c) {
							case 1:
								b.withdraw();
							break;
							case 2:
								b.deposite();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transHistory();
								break;
							case 6:
								isFinished=true;
								break;
								
								
								
							}
						}
					}
					else
						System.exit(0);
				}
				else {
					
				System.exit(0);
				}
				
			}
		}
		System.exit(0);
		
	}
}