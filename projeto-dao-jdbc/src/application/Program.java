package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//TESTE 1 findById
		
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		//TESTE 2 findByDepartment
		
		System.out.println("\n === TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List <Seller> list = sellerDao.findByDepartment(department);
			for (Seller obj : list) {
				System.out.println(obj);
				}
			
		//TESTE 3 findAll
			
		System.out.println("\n === TEST 3: seller findAll ====");
		list = sellerDao.findAll();
			for (Seller obj : list) {
				System.out.println(obj);
				}
			
		//TESTE 4 insert
			
		System.out.println("\n === TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date (), 4000.0, department);
		sellerDao.insert(newSeller);
		System.err.println("Inserted! New id = " + newSeller.getId());
		
		//TESTE 5 update
		
		System.out.println("\n === TEST 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		//TESTE 6 delete
		
		System.out.println("\n === TEST 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		
		
		sc.close();		
	}

}
