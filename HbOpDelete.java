import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;

class HbOpDelete
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
			int id = Integer.parseInt(c.readLine("enter id to be deleted "));
			Employee emp = (Employee)s.get(Employee.class, id);
			if (emp != null)
			{
				t = s.beginTransaction();
				s.delete(emp);
				t.commit();
				System.out.println("record deleted");
			}
			else
			{
				System.out.println("record does not exists ");
			}
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