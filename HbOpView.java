import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class HbOpView
{
	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session s = null;

		try
		{
			s = sf.openSession();
			System.out.println("connected");
			List<Employee> emp = new ArrayList<>();
			emp = s.createQuery("from Employee").list();
			for(Employee k : emp)
				System.out.println("id = " + k.getId() + " name = " + k.getName() + " salary = " + k.getSalary());
		}
		catch(Exception e)
		{
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