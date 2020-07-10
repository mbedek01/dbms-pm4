package BehindTheNumbers.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BehindTheNumbers.model.Employment;

public class EmploymentDao {

	protected static ConnectionManager connectionManager;

	private static EmploymentDao instance = null;
	
	protected EmploymentDao() {
		
		connectionManager = new ConnectionManager();
	}
	
	
	public static EmploymentDao getInstance() {
		if(instance == null) {
			instance = new EmploymentDao();
		}
		return instance;
	}
	
	
	
	/**
	 * Create the Employment instance.
	 * This runs a DELETE statement.
	 */
	
	public static Employment create(Employment employment) throws SQLException {
		
		String insertEmployment =
			"INSERT INTO Employment(Year,EmployedPopulation,UnemployedPopulation,UnemployedRate,"
			+ "MedianHouseHoldIncomeInDollars,MedianHouseHoldIncomePercentageOfStateTotal,"
			+ "CivilianLaborForceAnnualAverage,CountyID) VALUES(?,?,?,?,?,?,?,?,);";
		
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		
		try {
			connection = connectionManager.getConnection();
			
			// Employment has an auto-generated key. So we want to retrieve that key.
			insertStmt = connection.prepareStatement(insertEmployment,
				Statement.RETURN_GENERATED_KEYS);
			
			insertStmt.setInt(1, employment.getYear());
			insertStmt.setInt(2, employment.getEmployedPopulation());
			insertStmt.setInt(3, employment.getUnemployedPopulation());
			insertStmt.setFloat(4, employment.getUnemployedRate());
			insertStmt.setInt(5, employment.getMedianHouseHoldIncomeInDollars());
			insertStmt.setFloat(6, employment.getMedianHouseHoldIncomePercentageOfStateTotal());
			insertStmt.setInt(7, employment.getCivilianLaborForceAnnualAverage());
			insertStmt.setInt(8, employment.getCountyID());
			
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			
			resultKey = insertStmt.getGeneratedKeys();
			int EmploymentRecordID = -1;
			if(resultKey.next()) {
				EmploymentRecordID = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			employment.setEmploymentRecordID(EmploymentRecordID);
			return employment;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}
	
	
	
	
	/**
	 * Get the employment record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Employment instance.
	 * 
	 * 
	 */
	public Employment getEmploymentRecordByCountyID(int countyID) throws SQLException {
		
		String selectEmployment =
			"SELECT EmploymentRecordID,Year,EmployedPopulation,UnemployedPopulation,UnemployedRate,"
			+ "MedianHouseHoldIncomeInDollars,MedianHouseHoldIncomePercentageOfStateTotal,"
			+ "CivilianLaborForceAnnualAverage,CountyID " +
			"FROM Employment " +
			"WHERE CountyID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectEmployment);
			selectStmt.setInt(1, countyID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int EmploymentRecordID = results.getInt("EmploymentRecordID");
				int Year = results.getInt("Year");
				int EmployedPopulation = results.getInt("EmployedPopulation");		// do i need long?
				int UnemployedPopulation = results.getInt("UnemployedPopulation");
				float UnemployedRate = results.getFloat("UnemployedRate");
				int MedianHouseHoldIncomeInDollars = results.getInt("MedianHouseHoldIncomeInDollars");
				float MedianHouseHoldIncomePercentageOfStateTotal = 
						results.getFloat("MedianHouseHoldIncomePercentageOfStateTotal");
				int CivilianLaborForceAnnualAverage = results.getInt("CivilianLaborForceAnnualAverage");
				int CountyID = results.getInt("CountyID");
				
				Employment employment = new Employment(EmploymentRecordID, Year, EmployedPopulation, 
						UnemployedPopulation, UnemployedRate, MedianHouseHoldIncomeInDollars, 
						MedianHouseHoldIncomePercentageOfStateTotal, CivilianLaborForceAnnualAverage, CountyID);
				
				return employment;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * Get the employment record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Employment instance.
	 * 
	 * 
	 */
	public Employment getEmploymentRecordByID(int employmentrecordID) throws SQLException {
		
		String selectEmployment =
			"SELECT RecordID,Year,EmploymentLevelID,EmploymentLevel,NumberOfPeople,Percentage,CountyID " +
			"FROM Employment " +
			"WHERE AgeGroupID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectEmployment);
			selectStmt.setInt(1, employmentrecordID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int EmploymentRecordID = results.getInt("EmploymentRecordID");
				int Year = results.getInt("Year");
				int EmployedPopulation = results.getInt("EmployedPopulation");		// do i need long?
				int UnemployedPopulation = results.getInt("UnemployedPopulation");
				float UnemployedRate = results.getFloat("UnemployedRate");
				int MedianHouseHoldIncomeInDollars = results.getInt("MedianHouseHoldIncomeInDollars");
				float MedianHouseHoldIncomePercentageOfStateTotal = 
						results.getFloat("MedianHouseHoldIncomePercentageOfStateTotal");
				int CivilianLaborForceAnnualAverage = results.getInt("CivilianLaborForceAnnualAverage");
				int CountyID = results.getInt("CountyID");
				
				Employment employment = new Employment(EmploymentRecordID, Year, EmployedPopulation, 
						UnemployedPopulation, UnemployedRate, MedianHouseHoldIncomeInDollars, 
						MedianHouseHoldIncomePercentageOfStateTotal, CivilianLaborForceAnnualAverage, CountyID);
				
				return employment;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * Delete the Employment instance.
	 * This runs a DELETE statement.
	 */
	public Employment delete(Employment employment) throws SQLException {
		
		String deleteEmployment = "DELETE FROM Employment WHERE RecordID=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteEmployment);
			deleteStmt.setInt(1, employment.getEmploymentRecordID());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Employment instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
	
	
}
