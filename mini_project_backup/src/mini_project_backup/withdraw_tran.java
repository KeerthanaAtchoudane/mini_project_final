package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class withdraw_tran {
	//public static void main(String[] args) {
	void with() {
			   try 
				{
				   Scanner ip=new Scanner(System.in);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Keerth@1");
					Statement ss=(Statement) con.createStatement();
					System.out.println("*****WELCOME TO MONEY WITHDRAW PAGE*****");
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
						System.out.println("*****WITHDRAW PROCESS STARTS*****");
						System.out.println();
						System.out.print("Re-Enter your account number  :");
						String Account_Number1=ip.next();
						System.out.println();
						System.out.print("Enter amount you want to withdraw :");
						String with_draw=ip.next();
						System.out.println();
						String ins="insert into mini_project.TRANINFO(ACCOUNT_NO,TRANS_AMOUNT,TRANS_TYPE,CURRENT_BALANCE) VALUES "+" ("+Account_Number1+","+with_draw+",'D',"+rs.getString(1)+"-"+with_draw+")";
						int in=ss.executeUpdate(ins);
						String SQL="select CURRENT_BAL from mini_project.ACCINFO where ACC_NO='" + Account_Number1 +"'";
						ResultSet rs1=ss.executeQuery(SQL);
						while(rs1.next())
						{    
							String sal=rs1.getString(1);
							int ss1=Integer.parseInt(sal);
							int ss2=Integer.parseInt(with_draw);
							if((with_draw.equals(rs1.getString(1)))|| (ss2<=ss1))  
					        {  
								
								String SQL1="update mini_project.ACCINFO set CURRENT_BAL=CURRENT_BAL-"+ with_draw +" where ACC_NO='" + Account_Number1 +"'";
								int rs11=ss.executeUpdate(SQL1);
					            System.out.println("Collect your money");
					            System.out.println();
								System.out.println("********************************************");
					            break;
					        }  
					        else  
					        {  
					            System.out.println("Insufficient Balance");  
					          
					        }  
							break;
						}
						break; 
	         	        } 
				      }
					catch(Exception e)
				       {
					System.out.println("Please contact Support Team "+e);
					System.exit(0);
				       }
		           }
	            }
  