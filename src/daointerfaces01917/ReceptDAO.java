package daointerfaces01917;

import java.util.List;

import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public interface ReceptDAO {
	//Methods for "recept" table acces
	ReceptDTO getRecept(int receptId) throws DALException;
	List<ReceptDTO> getReceptList() throws DALException;
	void createRecept(ReceptDTO recept) throws DALException;
	void updateRecept(ReceptDTO recept) throws DALException;
	
	//Methods for "receptkomponent" table access
	ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException;
	List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException;
	List<ReceptKompDTO> getReceptKompList() throws DALException;
	void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException;
	void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException;
}
