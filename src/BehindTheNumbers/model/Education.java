package BehindTheNumbers.model;

public class Education {

	protected int RecordID;
	protected int Year;
	protected int EducationLevelID;				
	protected String EducationLevel;
	protected int NumberOfPeople;
	protected float Percentage;				// what is decimal equivalent here?
	protected int CountyID;
	
	
	// Constructor 1
		public Education(int RecordID, int Year, int EducationLevelID, String EducationLevel,
				int NumberOfPeople, float Percentage, int CountyID) {
			
			this.RecordID = RecordID;
			this.Year = Year;
			this.EducationLevelID = EducationLevelID;
			this.EducationLevel = EducationLevel;
			this.NumberOfPeople = NumberOfPeople;
			this.Percentage = Percentage;
			this.CountyID = CountyID;
		}
		
		// Constructor 2
		public Education(int RecordID) {
			this.RecordID = RecordID;
		}

		
		// Constructor 3
		public Education(int Year, int EducationLevelID, String EducationLevel,
				int NumberOfPeople, float Percentage, int CountyID) {
			
			this.Year = Year;
			this.EducationLevelID = EducationLevelID;
			this.EducationLevel = EducationLevel;
			this.NumberOfPeople = NumberOfPeople;
			this.Percentage = Percentage;
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

		public int getEducationLevelID() {
			return EducationLevelID;
		}

		public void setEducationLevelID(int educationLevelID) {
			EducationLevelID = educationLevelID;
		}

		public String getEducationLevel() {
			return EducationLevel;
		}

		public void setEducationLevel(String educationLevel) {
			EducationLevel = educationLevel;
		}

		public int getNumberOfPeople() {
			return NumberOfPeople;
		}

		public void setNumberOfPeople(int numberOfPeople) {
			NumberOfPeople = numberOfPeople;
		}

		public float getPercentage() {
			return Percentage;
		}

		public void setPercentage(float percentage) {
			Percentage = percentage;
		}

		public int getCountyID() {
			return CountyID;
		}

		public void setCountyID(int countyID) {
			CountyID = countyID;
		}
}
