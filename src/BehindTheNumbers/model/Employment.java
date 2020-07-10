package BehindTheNumbers.model;

public class Employment {

	// 9 attributes
	protected int EmploymentRecordID;
	protected int Year;
	protected int EmployedPopulation;
	protected int UnemployedPopulation;
	protected float UnemployedRate;
	protected int MedianHouseHoldIncomeInDollars;
	protected float MedianHouseHoldIncomePercentageOfStateTotal;
	protected int CivilianLaborForceAnnualAverage;
	protected int CountyID;
	
	
	// Constructor 1
	public Employment(int EmploymentRecordID, int Year, int EmployedPopulation, int UnemployedPopulation, 
			float UnemployedRate, int MedianHouseHoldIncomeInDollars, 
			float MedianHouseHoldIncomePercentageOfStateTotal, int CivilianLaborForceAnnualAverage, int CountyID) {
		
		this.EmploymentRecordID = EmploymentRecordID;
		this.Year = Year;
		this.EmployedPopulation = EmployedPopulation;
		this.UnemployedPopulation = UnemployedPopulation;
		this.UnemployedRate = UnemployedRate;
		this.MedianHouseHoldIncomeInDollars = MedianHouseHoldIncomeInDollars;
		this.MedianHouseHoldIncomePercentageOfStateTotal = MedianHouseHoldIncomePercentageOfStateTotal;
		this.CivilianLaborForceAnnualAverage = CivilianLaborForceAnnualAverage;
		this.CountyID = CountyID;
	}
	
	
	// Constructor 2
	public Employment(int EmploymentRecordID) {
		this.EmploymentRecordID = EmploymentRecordID;
	}
	
	
	// Constructor 3
	public Employment(int Year, int EmployedPopulation, int UnemployedPopulation, 
			float UnemployedRate, int MedianHouseHoldIncomeInDollars, 
			float MedianHouseHoldIncomePercentageOfStateTotal, int CivilianLaborForceAnnualAverage, int CountyID) {
		
		
		this.Year = Year;
		this.EmployedPopulation = EmployedPopulation;
		this.UnemployedPopulation = UnemployedPopulation;
		this.UnemployedRate = UnemployedRate;
		this.MedianHouseHoldIncomeInDollars = MedianHouseHoldIncomeInDollars;
		this.MedianHouseHoldIncomePercentageOfStateTotal = MedianHouseHoldIncomePercentageOfStateTotal;
		this.CivilianLaborForceAnnualAverage = CivilianLaborForceAnnualAverage;
		this.CountyID = CountyID;
	}


	public int getEmploymentRecordID() {
		return EmploymentRecordID;
	}


	public void setEmploymentRecordID(int employmentRecordID) {
		EmploymentRecordID = employmentRecordID;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	public int getEmployedPopulation() {
		return EmployedPopulation;
	}


	public void setEmployedPopulation(int employedPopulation) {
		EmployedPopulation = employedPopulation;
	}


	public int getUnemployedPopulation() {
		return UnemployedPopulation;
	}


	public void setUnemployedPopulation(int unemployedPopulation) {
		UnemployedPopulation = unemployedPopulation;
	}


	public float getUnemployedRate() {
		return UnemployedRate;
	}


	public void setUnemployedRate(float unemployedRate) {
		UnemployedRate = unemployedRate;
	}


	public int getMedianHouseHoldIncomeInDollars() {
		return MedianHouseHoldIncomeInDollars;
	}


	public void setMedianHouseHoldIncomeInDollars(int medianHouseHoldIncomeInDollars) {
		MedianHouseHoldIncomeInDollars = medianHouseHoldIncomeInDollars;
	}


	public float getMedianHouseHoldIncomePercentageOfStateTotal() {
		return MedianHouseHoldIncomePercentageOfStateTotal;
	}


	public void setMedianHouseHoldIncomePercentageOfStateTotal(float medianHouseHoldIncomePercentageOfStateTotal) {
		MedianHouseHoldIncomePercentageOfStateTotal = medianHouseHoldIncomePercentageOfStateTotal;
	}


	public int getCivilianLaborForceAnnualAverage() {
		return CivilianLaborForceAnnualAverage;
	}


	public void setCivilianLaborForceAnnualAverage(int civilianLaborForceAnnualAverage) {
		CivilianLaborForceAnnualAverage = civilianLaborForceAnnualAverage;
	}


	public int getCountyID() {
		return CountyID;
	}


	public void setCountyID(int countyID) {
		CountyID = countyID;
	}
}
