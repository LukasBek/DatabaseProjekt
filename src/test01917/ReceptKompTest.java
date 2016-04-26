package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public class ReceptKompTest {

	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		
		System.out.println("Recept 3, råvare 1:");
		MySQLReceptDAO receptKomp = new MySQLReceptDAO();
		try { System.out.println(receptKomp.getReceptKomp(3, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Indsaettelse af ny receptkomponent med recept_id =  3, raavare_id = 5");
		ReceptKompDTO receptKompDTO = new ReceptKompDTO(4, 2, 5.0, 0.1);
		try { receptKomp.createReceptKomp(receptKompDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Recept nummer 4, raavare nummer 5:");
		try { System.out.println(receptKomp.getReceptKomp(4, 5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af nom_netto for recept nummer 4, raavare 5");
		receptKompDTO.setNomNetto(7.0);
		try { receptKomp.updateReceptKomp(receptKompDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Recept nummer 4 raavare 5:");
		try { System.out.println(receptKomp.getReceptKomp(4, 5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Alle recepter:");
		try { System.out.println(receptKomp.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Recept nummer 5 raavare 1:");
		try { System.out.println(receptKomp.getReceptKomp(4, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
	}

}
