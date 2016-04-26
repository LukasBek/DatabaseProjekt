package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public class MySQLReceptDAO implements ReceptDAO{

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {
		ResultSet recept = Connector.doQuery("SELECT * FROM recept WHERE recept_id = "+receptId);
		try{
			if (!recept.first()){
				throw new DALException("Recept nonexistent");
			}
			return new ReceptDTO (recept.getInt("recept_id"), recept.getString("recept_navn"));
		}catch(SQLException e) {throw new DALException(e);}
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recept");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptDTO(rs.getInt("recept_id"), rs.getString("recept_navn")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
	
	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(
				"INSERT INTO recept(recept_id, recept_navn) VALUES " +
				"(" + recept.getReceptId() + ", '" + recept.getReceptNavn() + "')"
			);
	}
	
	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate(
				"UPDATE recept SET  recept_navn = '" + recept.getReceptNavn() + "' WHERE recept_id = " +
				recept.getReceptId()
		);
	}
	
	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptId + " AND raavare_id = " + raavareId);
	    try {
	    	if (!rs.first()) throw new DALException("Receptkomponent " + receptId + " findes ikke");
	    	return new ReceptKompDTO (rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent WHERE recept_id = " + receptId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM receptkomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ReceptKompDTO(rs.getInt("recept_id"), rs.getInt("raavare_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate(
				"INSERT INTO receptkomponent(recept_id, raavare_id, nom_netto, tolerance) VALUES " +
				"(" + receptkomponent.getReceptId() + ", '" + receptkomponent.getRaavareId() + "', '" + receptkomponent.getNomNetto() + "', '" + 
				receptkomponent.getTolerance() + "')"
			);
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doUpdate(
				"UPDATE receptkomponent SET nom_netto = '" + receptkomponent.getNomNetto() + "', tolerance = '" + receptkomponent.getTolerance()
				+ "' WHERE raavare_id = " + receptkomponent.getRaavareId() + " AND recept_id = " + receptkomponent.getReceptId()
		);
	}

}
