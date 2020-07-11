package BehindTheNumbers.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import BehindTheNumbers.model.Education;


public class EducationDao {

	protected static ConnectionManager connectionManager;

	private static EducationDao instance = null;
	
	protected EducationDao() {
		
		connectionManager = new ConnectionManager();
	}
	
	
	public static EducationDao getInstance() {
		if(instance == null) {
			instance = new EducationDao();
		}
		return instance;
	}
	
	
	
	/**
	 * Create the Education instance.
	 * This runs a DELETE statement.
	 */
	
	public static Education create(Education education) throws SQLException {
		
		String insertEducation =
			"INSERT INTO Education(Year,EducationLevelID,EducationLevel,NumberOfPeople,"
			+ "Percentage,CountyID) VALUES(?,?,?,?,?,?);";
		
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		
		try {
			connection = connectionManager.getConnection();
			
			// Education has an auto-generated key. So we want to retrieve that key.
			insertStmt = connection.prepareStatement(insertEducation,
				Statement.RETURN_GENERATED_KEYS);
			
			insertStmt.setInt(1, education.getYear());
			insertStmt.setInt(2, education.getEducationLevelID());
			insertStmt.setString(3, education.getEducationLevel());
			insertStmt.setObject(4, education.getNumberOfPeople(), Types.INTEGER);		// nullable
			insertStmt.setObject(5, education.getPercentage(), Types.DECIMAL);			// nullable
			insertStmt.setInt(6, education.getCountyID());
			
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			
			resultKey = insertStmt.getGeneratedKeys();
			int RecordID = -1;
			if(resultKey.next()) {
				RecordID = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			education.setRecordID(RecordID);;;
			return education;
			
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
	 * Get the education record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Education instance.
	 * 
	 * 
	 */
	public Education getEducationRecordByID(int recordID) throws SQLException {
		
		String selectEducation =
			"SELECT RecordID,Year,EducationLevelID,EducationLevel,NumberOfPeople,Percentage,CountyID " +
			"FROM Education " +
			"WHERE CountyID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectEducation);
			selectStmt.setInt(1, recordID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int EducationLevelID = results.getInt("EducationLevelID");
				String EducationLevel = results.getString("EducationLevel");
				Integer NumberOfPeople = (Integer) results.getObject("NumberOfPeople");
				BigDecimal Percentage = (BigDecimal) results.getObject("Percentage");
				int CountyID = results.getInt("CountyID");
				
				Education education = new Education(RecordID, Year, EducationLevelID, EducationLevel,
						NumberOfPeople, Percentage, CountyID);
				
				return education;
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
	 * Get the education record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Education instance.
	 * 
	 * 
	 */
	public Education getEducationRecordByCountyID(int countyID) throws SQLException {
		
		String selectEducation =
			"SELECT RecordID,Year,EducationLevelID,EducationLevel,NumberOfPeople,Percentage,CountyID " +
			"FROM Education " +
			"WHERE CountyID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectEducation);
			selectStmt.setInt(1, countyID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int EducationLevelID = results.getInt("EducationLevelID");		// do i need long?
				String EducationLevel = results.getString("EducationLevel");
				Integer NumberOfPeople = (Integer) results.getObject("NumberOfPeople");
				BigDecimal Percentage = (BigDecimal) results.getObject("Percentage");
				int CountyID = results.getInt("CountyID");
				
				Education education = new Education(RecordID, Year, EducationLevelID, EducationLevel,
						NumberOfPeople, Percentage, CountyID);
				
				return education;
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
	 * Get the education record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Education instance.
	 * 
	 * 
	 */
	public Education getEducationRecordByEducationLevel(int educationLevelID) throws SQLException {
		
		String selectEducation =
			"SELECT RecordID,Year,EducationLevelID,EducationLevel,NumberOfPeople,Percentage,CountyID " +
			"FROM Education " +
			"WHERE AgeGroupID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectEducation);
			selectStmt.setInt(1, educationLevelID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int EducationLevelID = results.getInt("EducationPopulation");				// do i need long?
				String EducationLevel = results.getString("PercentEducationPopulation");
				Integer NumberOfPeople = (Integer) results.getObject("NumberOfPeople");
				BigDecimal Percentage = (BigDecimal) results.getObject("Percentage");
				int CountyID = results.getInt("CountyID");
				
				Education education = new Education(RecordID, Year, EducationLevelID, EducationLevel,
						NumberOfPeople, Percentage, CountyID);
				
				return education;
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
	
	
	
	/*
	 * Updates the number of people that are educated in a particular education level category, in a particular
	 * year for a particular county by indexing the Education table by its Record Id.
	 * Performs an UPDATE procedure
	 */
	public Education updateNumPeopleEducated(Education education, int newNumPeople) throws SQLException {
		String updateExpiration = "UPDATE Poverty SET NumberOfPeople=? WHERE RecordID=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateExpiration);
			updateStmt.setInt(1, newNumPeople);
			updateStmt.setInt(2, education.getRecordID());
			updateStmt.executeUpdate();

			// Update the total education value of the Java object before returning to the caller.
			education.setNumberOfPeople(newNumPeople);
			return education;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	
	
	
	/**
	 * Delete the Education instance.
	 * This runs a DELETE statement.
	 */
	public Education delete(Education education) throws SQLException {
		
		String deleteEducation = "DELETE FROM Education WHERE RecordID=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteEducation);
			deleteStmt.setInt(1, education.getRecordID());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Education instance.
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
