package resources;

import pojo.PostBody;

public class TestDataBuild {
	
	public PostBody addDataPayload()
	{
		
		 PostBody p =new PostBody();
			p.setName("AVNISH");
			p.setAge(25);
			p.setSalary(3500);
			return p;
		    
	}
	
	public PostBody addDataDriven(String name, String salary, String age)
	{
		
		 PostBody p =new PostBody();
		 int salarytemp=Integer.parseInt(salary);
		 int agetemp = Integer.parseInt(age);
			p.setName(name);
			p.setAge(agetemp);
			p.setSalary(salarytemp);
			return p;
		    
	}

}
