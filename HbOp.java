import org.hibernate.*;
import org.hibernate.cfg.*;

class HbOp
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
			System.out.println("Connected");
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
				System.out.println("Disconnected");
			}
		}
	}
}