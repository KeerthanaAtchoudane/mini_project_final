package mini_project_backup;
public class main_module 
{
	public static void main(String[] args) 
	{
		try 
		{   Loginpage obj=new Loginpage();
		    obj.login();
		    	
		   	Menu mn=new Menu();
		    mn.menumod();
		} 
		catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}
}