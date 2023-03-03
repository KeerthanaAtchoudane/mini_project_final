package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class transfer_tran {
	//public static void main(String[] args) {
	void trans() {	
			try {  
				            Scanner sc = new Scanner(System.in);
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Keerth@1");
							Statement ss=(Statement) con.createStatement();
							System.out.println("*****WELCOME TO MONEY TRANSFER PAGE*****");
							System.out.println();
							System.out.println("*****CHECK YOUR BALANCE BEFORE DOING TRANSACTION*****");
							System.out.println();
							System.out.print("Enter your account number to check your current balance :");
							String Account_Number=sc.next();
							ResultSet rsb=ss.executeQuery("select CURRENT_BAL from mini_project.ACCINFO where ACC_NO='"+ Account_Number +"'");
							while(rsb.next())
							{
							System.out.println("CURRENT_BALANCE =" + rsb.getString(1));
							System.out.println();
							System.out.println("*****MONEY TRANSFER PROCESS STARTS*****");
							System.out.println();
							System.out.print("Enter your account number :");
							String Src_Account_Number=sc.next();
							System.out.println();
							System.out.print("Enter the account number to transfer money :");
							String Des_Account_Number=sc.next();
							System.out.println();
							System.out.print("Enter amount to transfer :");
							String credit=sc.next();
							System.out.println();
							String ins1="insert into mini_project.TRANINFO(ACCOUNT_NO,TRANS_AMOUNT,TRANS_TYPE,CURRENT_BALANCE) VALUES "+" ("+Src_Account_Number+","+credit+",'D',"+rsb.getString(1)+"-"+credit+")";
							int in=ss.executeUpdate(ins1);
							String SQL="update mini_project.ACCINFO set CURRENT_BAL=CURRENT_BAL - " +credit+ " where ACC_NO='" + Src_Account_Number +"'";
							int s1=ss.executeUpdate(SQL);
							String SQL1="update mini_project.ACCINFO set CURRENT_BAL=CURRENT_BAL + " +credit+ " where ACC_NO='" + Des_Account_Number +"'";
							int s2=ss.executeUpdate(SQL1);
							ResultSet rs=ss.executeQuery("select * from ACCINFO");
							if(s1==0 || s2==0)
							{
								System.out.println("Enter valid account number");
						     }
							else 
							{
								System.out.println("Amount has been transferred successsfully to your destinated account");
								System.out.println();
								System.out.println("********************************************");
							}
							break;
			               } 
							
						   }
			                  catch (Exception e)
			               {
				              System.out.println("Insufficient Balance in your account to do transaction" +e);
						      System.exit(0);
			               }
	                    }
	                  }

