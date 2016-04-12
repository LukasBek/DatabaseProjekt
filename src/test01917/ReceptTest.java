package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.ReceptDTO;

public class ReceptTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Recept nummer 3:");
		MySQLReceptDAO recept = new MySQLReceptDAO();
		try { System.out.println(recept.getRecept(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny recept med recept_id =  4");
		ReceptDTO receptDTO = new ReceptDTO(4,"Cheeseburgers");
		try { recept.createRecept(receptDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Recept nummer 4:");
		try { System.out.println(recept.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af navn for recept nummer 4");
		receptDTO.setReceptNavn("Cheeseburger");
		try { recept.updateRecept(receptDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Recept nummer 4:");
		try { System.out.println(recept.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle recepter:");
		try { System.out.println(recept.getReceptList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Recept nummer 5:");
		try { System.out.println(recept.getRecept(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
	}

}
