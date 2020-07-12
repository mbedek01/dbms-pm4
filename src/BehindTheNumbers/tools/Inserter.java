package BehindTheNumbers.tools;

import java.sql.SQLException;
import java.util.List;

import BehindTheNumbers.dal.EducationDao;
import BehindTheNumbers.dal.EmploymentDao;
import BehindTheNumbers.dal.PovertyDao;
import BehindTheNumbers.model.Poverty;



public class Inserter {

	public static void main(String[] args) throws SQLException {
		
		// DAO instances.
		PovertyDao povertyDao = PovertyDao.getInstance();
		EducationDao educationDao = EducationDao.getInstance();
		EmploymentDao employmentDao = EmploymentDao.getInstance();
		
		
		
		// read
		
		Poverty p1 = povertyDao.getPovertyRecordByID(1428);
		
		System.out.printf("Record: %d, Year: %d, povertyPop: %d, PercentPov: %f, AgeGroupID: %d, CountyID: %d \n",
				p1.getRecordID(), p1.getYear(), p1.getPovertyPopulation(), p1.getPercentPovertyPopulation(), 
				p1.getAgeGroupID(), p1.getCountyID());
		
		
		
		List<Poverty> pList1 = povertyDao.getPovertyRecordsByCountyID(1428);
		
		for(Poverty p : pList1) {
			System.out.format("Reading poverty records: Record: %d, Year: %d, povertyPop: %d, "
					+ "PercentPov: %f, AgeGroupID: %d, CountyID: %d \n",
				p.getRecordID(), p.getYear(), p.getPovertyPopulation(), p.getPercentPovertyPopulation(), 
				p.getAgeGroupID(), p.getCountyID());
		}
		
		
		
		Poverty p2 = povertyDao.updateTotalPopulationinPoverty(p1, 450);
	}

		
}
