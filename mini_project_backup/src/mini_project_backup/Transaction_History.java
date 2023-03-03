package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Transaction_History {
	//public static void main(String[] args) {
	void history() {	
			try {  
				            Scanner sc = new Scanner(System.in);
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Keerth@1");
							Statement ss=(Statement) con.createStatement();
							System.out.println();
							System.out.println("*****TRANSACTION HISTORY PAGE*****");
							System.out.println();
							System.out.print("Enter your account number to see your transaction history :");
							String Account_Number=sc.next();
							ResultSet rs=ss.executeQuery("select * from mini_project.TRANINFO where ACCOUNT_NO='"+ Account_Number +"'");
							while(rs.next())
							{
								System.out.println(rs.getString(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"     "+rs.getString(4)+"     "+rs.getString(5)+"     "+rs.getString(6));
							}
							
							}
			                catch (Exception e)
			                {
				             System.out.println("Enter Valid Account number" +e);
						     System.exit(0);
			                }
	                    }
	                  }

