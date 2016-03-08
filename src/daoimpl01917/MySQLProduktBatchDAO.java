package daoimpl01917;

import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
//		ResultSet rs = Connector.doQuery("SELECT * ")
		return null;
	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
