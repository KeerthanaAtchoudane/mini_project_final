package mini_project_backup;
import java.util.Scanner;
public class Menu {
	void menu() {
		Menu nn=new Menu();
	    nn.menumod();
		       }
	//public static void main(String[] args) {
		void menumod() {
		try 
		{   System.out.println();
			System.out.println("WELCOME TO MENU PAGE");
			System.out.println();
			Scanner sc = new Scanner(System.in);
			System.out.println("Automated Teller Machine");  
	        System.out.println("Choose 1 for Check Balance");  
	        System.out.println("Choose 2 for Deposit");  
	        System.out.println("Choose 3 for Withdraw");
	        System.out.println("Choose 4 for Money Transfer");
	        System.out.println("Choose 5 for Transaction History Page");
	        System.out.println("Choose 6 for EXIT"); 
	        System.out.println();
	        System.out.print("Choose the operation you want to perform (1-6) :");
			int choice=sc.nextInt();
			switch(choice) {                                                   
			case 1:
				balancecheck bc=new balancecheck();
			    bc.balcheck();
			    Menu nn=new Menu();
			    nn.menu();
			    break;
			case 2:
				deposit_tran dp=new deposit_tran();
			    dp.credited();
			    Menu n=new Menu();
			    n.menu();
			    break;
			case 3:
				withdraw_tran wd=new withdraw_tran();
			    wd.with();
			    Menu wn=new Menu();
			    wn.menu();
			    break;
			case 4:
				transfer_tran tf=new transfer_tran();
			    tf.trans();
			    Menu tn=new Menu();
			    tn.menu();
			    break;
			case 5:
				Transaction_History th=new Transaction_History();
			    th.history();
			    Menu hn=new Menu();
			    hn.menu();
			    break;
			case 6:   
				System.out.println();
				System.out.println("You are successfully logged out.....Collect your ATM card from ATM machine");
				System.out.println();
				System.out.println("*************BYE!!!!!HAVE A NICE DAY!!!!!*************");
				System.exit(0);
			default:
				System.out.println("Enter Valid choice(1-5)");
	                    }
		       }
			catch (Exception e) {
				System.out.println(e);
			}
        }
    }
