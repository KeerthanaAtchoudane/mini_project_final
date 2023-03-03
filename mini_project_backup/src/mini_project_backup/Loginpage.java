package mini_project_backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Loginpage {
		void login() {
   try {
	   System.out.println("**********WELCOME TO ATM INTERFACE MINI-PROJECT**********");
	   System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ('Y'/'y') if you have ATM card (or) ('N'/'n') if you not have ATM card:");
		char atm_card=sc.next().charAt(0);
		switch(atm_card) {                                                
		case 'y','Y':
			Scanner ip=new Scanner(System.in);System.out.println();
			System.out.println("***********WELCOME TO ASSURED BANK ATM SERIVE***********");System.out.println();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/keerthana","root","Keerth@1");
				Statement ss=(Statement) con.createStatement();
				System.out.println();
				System.out.print("Enter user_id:");
				String user_id=ip.next();
				System.out.println();
				System.out.print("Enter pin:");
				String pin=ip.next();
				System.out.println();
				String SQL="select * from mini_project.loginpage where user_id= '"+ user_id +"' and pin='" + pin + "'";
				ResultSet rs=ss.executeQuery(SQL);
				if(rs.next())
					System.out.println("***********You are successfully logged into the portal***********");
				
				else
					System.out.println("Invalid user_id or pin!!! Refresh and Try again later");
				
			   }
			    catch(Exception e)
		       {
			    System.out.println("!!!!!Please contact Support Team!!!!!"+e);
			    break;
		       }
			   break;
		     case 'N','n':	
			   System.out.println();
			   System.out.println("SORRY!!! ATM CARD IS MANDATORY");System.out.println();
			   System.out.println("*****THANK YOU*****");
			  break;
		    default:
			   System.out.println("Waring!!!!Please enter either ('Y'/'y' or 'N'/'n')");
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


