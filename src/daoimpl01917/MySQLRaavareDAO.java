package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RaavareBatchDAO;
import dto01917.RaavareBatchDTO;

public class MySQLRaavareDAO implements RaavareBatchDAO{

	@Override
	public RaavareBatchDTO getRaavareBatch(int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM Raavarebatch rb_id = " + rbId);
		try{
	    	if (!rs.first()) throw new DALException("Raavarebatchen " + rbId + " findes ikke");
	    	return new RaavareBatchDTO(rs.getInt("rb_id"), rs.getInt("raavare_id"), rs.getInt("maengde"));		
		}
		catch (SQLException e) {throw new DALException(e);}
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RaavareBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRaavareBatch(RaavareBatchDTO raavarebatch) throws DALException {
		// TODO Auto-generated method stub
		
	}
	

}
