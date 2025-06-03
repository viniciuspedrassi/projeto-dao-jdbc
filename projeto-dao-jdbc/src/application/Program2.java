package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		//TESTE 1 findById

		System.out.println("=== TEST 1: department findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		//TESTE 2 findAll
		
		System.out.println("\n === TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
			for (Department d : list) 
			System.out.println(d);
					
		//TESTE 3 insert
		
		System.out.println("\n === TEST 3: department insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.err.println("Inserted! New id = " + newDepartment.getId());
		

		
		//TESTE 4 update
		System.out.println("\n=== TEST 4: department update ====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		//TESTE 5 delete
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		sc.close();
		
	


}
}