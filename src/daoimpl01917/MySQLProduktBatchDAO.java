package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;

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
				list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("Status"), rs.getInt("recept_id")));
			}
		}catch(SQLException e){
			throw new DALException(e);
		}
		return list;
	}


	@Override
	public void createProduktBatch(ProduktBatchDTO pb) throws DALException {
		Connector.doUpdate(
				"INSERT INTO produktbatch(pb_id, status, recept_id) VALUES"
					+ "(" + pb.getPbId() + ", " + pb.getStatus() + ", " + pb.getReceptId() + ")"
				);

	}

	@Override
	public void updateProduktBatch(ProduktBatchDTO pb) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatch SET  status =  " + pb.getStatus() + 
				", recept_id = " + pb.getReceptId() + " WHERE pb_id = " + pb.getPbId()
		);

	}
	
	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId + " AND rb_id = " + rbId);
		try {
			if (!rs.first()) throw new DALException("Produktbatchkomponent " + pbId + " findes ikke");
			return new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		}
		catch (SQLException e) {throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException{
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId);
		try{
			while (rs.next()){
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
		try{
			while (rs.next()) {
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"INSERT INTO produktbatchkomponent(pb_id, rb_id, tara, netto, opr_id) VALUES " +
						"(" + produktbatchkomponent.getPbId() + ", " + produktbatchkomponent.getRbId() + ", " + produktbatchkomponent.getNetto() + ", " + 
						produktbatchkomponent.getTara() + ", " + produktbatchkomponent.getOprId() + ")"
				);
	}

	@Override
	public void updateProduktBatchKomp(ProduktBatchKompDTO produktbatchkomponent) throws DALException {
		Connector.doUpdate(
				"UPDATE produktbatchkomponent SET  netto = " + produktbatchkomponent.getNetto() + ", tara = " + produktbatchkomponent.getTara() + " WHERE pb_id = " +
				produktbatchkomponent.getPbId()
				);
	}


}
