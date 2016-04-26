package test01917;

import java.sql.SQLException;
import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class ProduktBatchKompTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("ProduktBatchKomp 3:");
		MySQLProduktBatchDAO pbk = new MySQLProduktBatchDAO();
		try { System.out.println(pbk.getProduktBatchKomp(3, 3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny produktbatchkomponent med pb_id =  4");
		ProduktBatchKompDTO pbkDTO = new ProduktBatchKompDTO(4, 2, 56, 34, 2);
		try { pbk.createProduktBatchKomp(pbkDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Produktbatchkomponent nummer 4:");
		try { System.out.println(pbk.getProduktBatchKompList(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af netto for pb_id nummer 4");
		pbkDTO.setNetto(40);
		try { pbk.updateProduktBatchKomp(pbkDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("PBK nummer 4:");
		try { System.out.println(pbk.getProduktBatchKompList(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle Produkt Batches:");
		try { System.out.println(pbk.getProduktBatchKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Produkt Batch nummer 3:");
		try { System.out.println(pbk.getProduktBatchKompList(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
	}
}
