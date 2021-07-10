import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class HbOpAdd
{
	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session s = null;
		Transaction t = null;

		try
		{
			s = sf.openSession();
			System.out.println("connected");
			Console c = System.console();
			int id = Integer.parseInt(c.readLine("enter id "));
			String name = c.readLine("enter name ");
			double salary = Double.parseDouble(c.readLine("enter salary "));
			Employee e = new Employee(id , name, salary);
			t = s.beginTransaction();
			s.save(e);
			t.commit();
			System.out.println("record inserted");
		}
		catch(Exception e)
		{
			t.rollback();
			System.out.println("issue " + e);
		}
		finally
		{
			if (s != null)
			{
				s.close();
				System.out.println("disconnected");
			}
		}
	}
}