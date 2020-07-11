package BehindTheNumbers.tools;

import java.sql.SQLException;

import BehindTheNumbers.dal.EducationDao;
import BehindTheNumbers.dal.EmploymentDao;
import BehindTheNumbers.dal.PovertyDao;


public class Inserter {

	public static void main(String[] args) throws SQLException {
		
		// DAO instances.
		PovertyDao povertyDao = PovertyDao.getInstance();
		EducationDao educationDao = EducationDao.getInstance();
		EmploymentDao employmentDao = EmploymentDao.getInstance();
	}

		
}
