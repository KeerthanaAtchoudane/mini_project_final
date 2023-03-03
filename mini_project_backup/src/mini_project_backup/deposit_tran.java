package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class deposit_tran {
 //public static void main(String[] args) {
	void credited() {
		                try 
						{
						    Scanner ip=new Scanner(System.in);
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Keerth@1");
							Statement ss=(Statement) con.createStatement();
							System.out.println("*****WELCOME TO MONEY DEPOSIT PAGE*****");
							System.out.println();
							System.out.println("*****CHECK YOUR BALANCE BEFORE DOING TRANSACTION*****");
							System.out.println();
							System.out.print("Enter your account number to check your current balance :");
							String Account_Number=ip.next();
							ResultSet rs=ss.executeQuery("select CURRENT_BAL from mini_project.ACCINFO where ACC_NO='"+ Account_Number +"'");
							while(rs.next())
							{
								System.out.println();
								System.out.println("CURRENT_BALANCE =" + rs.getString(1));
								System.out.println();
								System.out.println("*****DEPOSIT PROCESS STARTS*****");
								System.out.println();
								System.out.print("Re-Enter your account number  :");
								String Account_Number1=ip.next();
								System.out.println();
								System.out.print("Enter amount you want to credited to your account :");
								String credit=ip.next();
								System.out.println();
								String ins="insert into TRANINFO(ACCOUNT_NO,TRANS_AMOUNT,TRANS_TYPE,CURRENT_BALANCE) VALUES "+" ("+Account_Number1+","+credit+",'C',"+rs.getString(1)+"+"+credit+")";
								int in=ss.executeUpdate(ins);
								String SQL="update mini_project.ACCINFO set CURRENT_BAL=CURRENT_BAL + " +credit+ " where ACC_NO='" + Account_Number1 +"'";
								int rs1=ss.executeUpdate(SQL);
								if(rs1==0)
									
								{
									System.out.println("Enter valid account number");
							     }
								else 
								{
									System.out.println("Amount has credited successsfully to your account");System.out.println();
									System.out.println("********************************************");
									break;
								}
								
							}
						 } catch (Exception e) {
							System.out.println("Please contact Support Team "+e);
							System.exit(0);
						}
                    }
                  }
                           
