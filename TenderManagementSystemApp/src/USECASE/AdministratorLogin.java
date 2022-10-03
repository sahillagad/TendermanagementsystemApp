package USECASE;

import java.util.Scanner;

import DAO.AdministratorDao;
import DAO.AdministratorDaoImpl;
import USERDEFINEEXCEPTION.AdminstratorException;

public class AdministratorLogin {
	public static void main(String[] args) {
		System.out.println("---- Welcome  ----");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username=sc.next();
		
		
		System.out.println("Enter Password");
		String password=sc.next();
		
		
		AdministratorDao  administratorDao=new AdministratorDaoImpl();

		try {
			administratorDao.administratorLogin(username, password);
		} catch (AdminstratorException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("---- Thank You ----");
		
	}

}
