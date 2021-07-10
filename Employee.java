// pojo class

class Employee
{
	private int id;
	private String name;
	private double salary;

	Employee(){}

	Employee(int id, String name, double salary)
	{
		this.id = id;		this.name = name;	this.salary = salary;
	}

	//getter --> Acessor methods
	public int getId() { return id; }
	public String getName() { return name; }
	public double getSalary() { return salary; }	
	
	//setter --> Mutator methods
	public void setId(int id) { this.id = id; }
	public void setName(String name) { this.name = name; } 
	public void setSalary(double salary) { this.salary = salary; }
}