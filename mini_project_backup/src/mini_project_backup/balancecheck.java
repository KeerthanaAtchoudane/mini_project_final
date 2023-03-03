package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class balancecheck {
//	public static void main(String[] args) {
	void balcheck() {
		Scanner ip=new Scanner(System.in);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/keerthana","root","Keerth@1");
			Statement ss=(Statement) con.createStatement();
			System.out.println();
			System.out.println("*****BALANCE CHECKING PAGE*****");
			System.out.print("Enter your account number to check your current balance :");
			String Account_Number=ip.next();
			ResultSet rs=ss.executeQuery("select CURRENT_BAL from mini_project.ACCINFO where ACC_NO='"+ Account_Number +"'");
			while(rs.next())
			{
				System.out.println();
				System.out.println("CURRENT_BALANCE =" + rs.getString(1));System.out.println();
				System.out.println("********************************************");
			}
		} catch (Exception e) {
			System.out.println("Please contact Support Team "+e);
			System.exit(0);
		}
	}
}
