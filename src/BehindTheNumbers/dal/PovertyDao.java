package BehindTheNumbers.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import BehindTheNumbers.model.Poverty;




public class PovertyDao {

	
	protected static ConnectionManager connectionManager;

	private static PovertyDao instance = null;
	
	protected PovertyDao() {
		
		connectionManager = new ConnectionManager();
	}
	
	
	public static PovertyDao getInstance() {
		if(instance == null) {
			instance = new PovertyDao();
		}
		return instance;
	}
	
	
	
	/**
	 * Create the Poverty instance.
	 * This runs a DELETE statement.
	 */
	
	public static Poverty create(Poverty poverty) throws SQLException {
		
		String insertPoverty =
			"INSERT INTO Poverty(Year,PovertyPopulation,PercentPovertyPopulation,ConfidenceInterval,"
			+ "AgeGroupID,CountyID) VALUES(?,?,?,?,?,?);";
		
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		
		try {
			connection = connectionManager.getConnection();
			
			// Poverty has an auto-generated key. So we want to retrieve that key.
			insertStmt = connection.prepareStatement(insertPoverty,
				Statement.RETURN_GENERATED_KEYS);
			
			insertStmt.setInt(1, poverty.getYear());
			insertStmt.setInt(2, poverty.getPovertyPopulation());
			insertStmt.setFloat(3, poverty.getPercentPovertyPopulation());
			insertStmt.setString(4, poverty.getConfidenceInterval());
			insertStmt.setInt(5, poverty.getAgeGroupID());
			insertStmt.setInt(6, poverty.getCountyID());
			
			insertStmt.executeUpdate();
			
			// Retrieve the auto-generated key and set it, so it can be used by the caller.
			
			resultKey = insertStmt.getGeneratedKeys();
			int RecordID = -1;
			if(resultKey.next()) {
				RecordID = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			poverty.setRecordID(RecordID);;;
			return poverty;
			
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
	 * Get the poverty record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Poverty instance.
	 * 
	 * 
	 */
	public Poverty getPovertyRecordByID(int recordID) throws SQLException {
		
		String selectPoverty =
			"SELECT RecordID,Year,PovertyPopulation,PercentPovertyPopulation,ConfidenceInterval,"
			+ "AgeGroupID,CountyID " +
			"FROM Poverty " +
			"WHERE CountyID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPoverty);
			selectStmt.setInt(1, recordID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int PovertyPopulation = results.getInt("PovertyPopulation");				// do i need long?
				float PercentPovertyPopulation = results.getInt("PercentPovertyPopulation");
				String ConfidenceInterval = results.getString("ConfidenceInterval");
				int AgeGroupID = results.getInt("AgeGroupID");
				int CountyID = results.getInt("CountyID");
				
				Poverty poverty = new Poverty(RecordID, Year, PovertyPopulation, PercentPovertyPopulation,
						ConfidenceInterval, AgeGroupID, CountyID);
				
				return poverty;
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
	 * Get the poverty record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Poverty instance.
	 * 
	 * 
	 */
	public Poverty getPovertyRecordByCountyID(int countyID) throws SQLException {
		
		String selectPoverty =
			"SELECT RecordID,Year,PovertyPopulation,PercentPovertyPopulation,ConfidenceInterval,"
			+ "AgeGroupID,CountyID " +
			"FROM Poverty " +
			"WHERE CountyID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPoverty);
			selectStmt.setInt(1, countyID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int PovertyPopulation = results.getInt("PovertyPopulation");				// do i need long?
				float PercentPovertyPopulation = results.getInt("PercentPovertyPopulation");
				String ConfidenceInterval = results.getString("ConfidenceInterval");
				int AgeGroupID = results.getInt("AgeGroupID");
				int CountyID = results.getInt("CountyID");
				
				Poverty poverty = new Poverty(RecordID, Year, PovertyPopulation, PercentPovertyPopulation,
						ConfidenceInterval, AgeGroupID, CountyID);
				
				return poverty;
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
	 * Get the poverty record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Poverty instance.
	 * 
	 * 
	 */
	public Poverty getPovertyRecordByAgeGroup(int ageGroupID) throws SQLException {
		
		String selectPoverty =
			"SELECT RecordID,Year,PovertyPopulation,PercentPovertyPopulation,ConfidenceInterval,"
			+ "AgeGroupID,CountyID " +
			"FROM Poverty " +
			"WHERE AgeGroupID=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPoverty);
			selectStmt.setInt(1, ageGroupID);
			results = selectStmt.executeQuery();
			
			
			if(results.next()) {
				int RecordID = results.getInt("RecordID");
				int Year = results.getInt("Year");
				int PovertyPopulation = results.getInt("PovertyPopulation");				// do i need long?
				float PercentPovertyPopulation = results.getInt("PercentPovertyPopulation");
				String ConfidenceInterval = results.getString("ConfidenceInterval");
				int AgeGroupID = results.getInt("AgeGroupID");
				int CountyID = results.getInt("CountyID");
				
				Poverty poverty = new Poverty(RecordID, Year, PovertyPopulation, PercentPovertyPopulation,
						ConfidenceInterval, AgeGroupID, CountyID);
				
				return poverty;
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
	 * Delete the Poverty instance.
	 * This runs a DELETE statement.
	 */
	public Poverty delete(Poverty poverty) throws SQLException {
		
		String deletePoverty = "DELETE FROM Poverty WHERE RecordID=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deletePoverty);
			deleteStmt.setInt(1, poverty.getRecordID());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Poverty instance.
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
