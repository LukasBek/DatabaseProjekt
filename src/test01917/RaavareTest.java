package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;

public class RaavareTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Raavare nummer 3:");
		MySQLRaavareDAO raavare = new MySQLRaavareDAO();
		try { System.out.println(raavare.getRaavare(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny raavare med opr_id =  4");
		RaavareDTO rDTO = new RaavareDTO(8,"Agurk","WeLoveAgurk");
		try { raavare.createRaavare(rDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Raavare nummer 8:");
		try { System.out.println(raavare.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af leverandør for raavare nummer 8");
		rDTO.setLeverandoer("WeAlsoLoveAgurk");
		try { raavare.updateRaavare(rDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavare nummer 8:");
		try { System.out.println(raavare.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle raavare:");
		try { System.out.println(raavare.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavare nummer 9:");
		try { System.out.println(raavare.getRaavare(9)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
	}
}
