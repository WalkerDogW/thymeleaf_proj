package site.javaee.thymeleaf_proj.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import site.javaee.thymeleaf_proj.entities.Department;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "信息部"));
		departments.put(102, new Department(102, "行政部"));
		departments.put(103, new Department(103, "人力资源部"));
		departments.put(104, new Department(104, "财务部"));
		departments.put(105, new Department(105, "销售部"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
