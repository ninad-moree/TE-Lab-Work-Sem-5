import java.sql.*;
import java.util.*;

public class assign {
	public static void main(String []args) {
		
		System.out.println("*** Check Connection ***");
		
		boolean result = true;
		while(result) {
			System.out.println("1.Create Table");
			System.out.println("2.Insert Values");
			System.out.println("3.Update Values");
			System.out.println("4.Delete Values");
			System.out.println("5.Exit");
			System.out.println("Enter choice: ");
			
			Scanner sc1=new Scanner(System.in);
			int ch=sc1.nextInt();
			
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection(
				"jdbc:mysql://10.10.13.128/31253_db","te31253","te31253");
				Statement smt=con.createStatement();
				if(con!=null && !con.isClosed())
				{
					System.out.println("Database Connected");
				}
				else
				{
					System.out.println("Not connected");
				}
		
				switch(ch) {
					case 1:
						String st="create table ";
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter the name of the table: ");
						String name=sc.nextLine();
						System.out.println("Enter the attributes with the datatype: ");
						String values=sc.nextLine();
						st=st+name+"("+values+");";
						System.out.println(st);
						smt.executeUpdate(st);
						System.out.println("Table is created!");
//						sc.close();
						break;
					case 2:
						String st1="insert into Consumer values( ";
						Scanner sc2=new Scanner(System.in);
						System.out.println("Enter the values: ");
						String val=sc2.nextLine();
						st1=st1+val+");";
						System.out.println(st1);
						smt.executeUpdate(st1);
						System.out.println("Inserted data!");
//						sc2.close();
						break;
					case 3:
						String st2="update Consumer set name = ";
						Scanner sc3=new Scanner(System.in);
						System.out.println("Enter the value to be updated: ");
						int cid=sc3.nextInt();
						System.out.println("Enter new name: ");
						String new_name=sc3.nextLine();
						st2=st2+new_name+"where rollno="+cid+";";
						smt.executeUpdate(st2);
						System.out.println("Updated data!");
//						sc3.close();
						break;
					case 4:
						String st3="delete from Consumer where ";
						Scanner sc4=new Scanner(System.in);
						System.out.println("Enter the constraints");
						String constraint=sc4.nextLine();
						st3=st3+constraint;
						smt.executeUpdate(st3);
						System.out.println("Deleted data!");
//						sc4.close();
						break;
					case 5:
						System.out.println("Exiting the code");
						result = false;
						sc1.close();
						break;
					default:
						System.out.println("Invalid choice");
				}
			}
			catch(Exception e)
			{ 
				System.out.println(e);
				System.out.println("ERRROORRRRR");
			}
		}
		  
	}
}



