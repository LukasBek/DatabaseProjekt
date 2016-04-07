package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		ResultSet pb = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = "+pbId);
		try{
			if (!pb.first()){
				throw new DALException("Produkt batch nonexistent");
			}
			return new ProduktBatchDTO (pb.getInt("pb_id"), pb.getInt("status"), pb.getInt("recept_id"));
		}catch(SQLException e) {throw new DALException(e);}

	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try{
			while (rs.next()){
				list.add(new ProduktBatchDTO(rs.getInt("produktbatch_id"), rs.getInt("Status"), rs.getInt("recept_id")));
			}
		}catch(SQLException e){
			throw new DALException(e);
		}
		return list;
	}


	@Override
	public void createProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		Connector.doUpdate(
				"INSER INTO produktbatch(pb_id, status, recept_id) VALUES"
				+ "")

	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub

	}

}
