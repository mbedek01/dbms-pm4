package BehindTheNumbers.model;

public class Poverty {

	// 7 attributes
	protected int RecordID;
	protected int Year;
	protected int PovertyPopulation;				// do i need long?
	protected float PercentPovertyPopulation;
	protected String ConfidenceInterval;
	protected int AgeGroupID;
	protected int CountyID;
	
	// Constructor 1
	public Poverty(int RecordID, int Year, int PovertyPopulation, float PercentPovertyPopulation,
			String ConfidenceInterval, int AgeGroupID, int CountyID) {
		
		this.RecordID = RecordID;
		this.Year = Year;
		this.PovertyPopulation = PovertyPopulation;
		this.PercentPovertyPopulation = PercentPovertyPopulation;
		this.ConfidenceInterval = ConfidenceInterval;
		this.AgeGroupID = AgeGroupID;
		this.CountyID = CountyID;
	}
	
	// Constructor 2
	public Poverty(int RecordID) {
		this.RecordID = RecordID;
	}

	
	// Constructor 3
	public Poverty(int Year, int PovertyPopulation, float PercentPovertyPopulation,
			String ConfidenceInterval, int AgeGroupID, int CountyID) {
		
		this.Year = Year;
		this.PovertyPopulation = PovertyPopulation;
		this.PercentPovertyPopulation = PercentPovertyPopulation;
		this.ConfidenceInterval = ConfidenceInterval;
		this.AgeGroupID = AgeGroupID;
		this.CountyID = CountyID;
	}
	
	public int getRecordID() {
		return RecordID;
	}

	public void setRecordID(int recordID) {
		RecordID = recordID;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getPovertyPopulation() {
		return PovertyPopulation;
	}

	public void setPovertyPopulation(int povertyPopulation) {
		PovertyPopulation = povertyPopulation;
	}

	public float getPercentPovertyPopulation() {
		return PercentPovertyPopulation;
	}

	public void setPercentPovertyPopulation(float percentPovertyPopulation) {
		PercentPovertyPopulation = percentPovertyPopulation;
	}

	public String getConfidenceInterval() {
		return ConfidenceInterval;
	}

	public void setConfidenceInterval(String confidenceInterval) {
		ConfidenceInterval = confidenceInterval;
	}

	public int getAgeGroupID() {
		return AgeGroupID;
	}

	public void setAgeGroupID(int ageGroupID) {
		AgeGroupID = ageGroupID;
	}

	public int getCountyID() {
		return CountyID;
	}

	public void setCountyID(int countyID) {
		CountyID = countyID;
	}
}
