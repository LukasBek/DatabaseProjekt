package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;
import dto01917.RaavareBatchDTO;

public class RaavareBatchTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("RaavareBatch nummer 3:");
		MySQLRaavareBatchDAO rb = new MySQLRaavareBatchDAO();
		try { System.out.println(rb.getRaavareBatch(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny raavarebatch med rb_id =  4");
		RaavareBatchDTO rbDTO = new RaavareBatchDTO(4, 7, 100);
		try { rb.createRaavareBatch(rbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("RaavareBatch nummer 4:");
		try { System.out.println(rb.getRaavareBatch(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af raavareid for raavarebatch nummer 4");
		rbDTO.setRaavareId(99);
		try { rb.updateRaavareBatch(rbDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavarebatch nummer 4:");
		try { System.out.println(rb.getRaavareBatch(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle raavarebathes:");
		try { System.out.println(rb.getRaavareBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Raavarebatch nummer 5:");
		try { System.out.println(rb.getRaavareBatch(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
		
	}
}
