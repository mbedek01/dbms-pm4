package BehindTheNumbers.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BehindTheNumbers.dal.PovertyDao;
import BehindTheNumbers.model.Poverty;



@WebServlet("/povertycreate")
public class PovertyCreate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected PovertyDao povertyDao;

	@Override
	public void init() throws ServletException {
		povertyDao = PovertyDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		// Just render the JSP.
		req.getRequestDispatcher("/PovertyCreate.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve and validate CountyID.
		String countyId = req.getParameter("CountyID");
		if (countyId == null || countyId.trim().isEmpty()) {
			messages.put("success", "Invalid County ID");
		} else {
			// Create the Poverty record.
			//int recordId = Integer.parseInt(req.getParameter("RecordID"));
			int year = Integer.parseInt(req.getParameter("Year"));
			//String s_povertyPopulation = req.getParameter("povertyPopulation");
        	int povertyPopulation = Integer.parseInt(req.getParameter("PovertyPopulation"));
        	
        	//String s_percentPovertyPopulation = req.getParameter("percentPovertyPopulation");
        	BigDecimal percentPovertyPopulation = new BigDecimal(req.getParameter("PercentPovertyPopulation"));
        	
        	//String ConfidenceInterval = req.getParameter("ConfidenceInterval");
        	
        	//String s_ageGroupId = req.getParameter("ageGroupId");
        	Integer ageGroupId = Integer.parseInt(req.getParameter("AgeGroupID"));
        	
			Integer countyID = Integer.parseInt(req.getParameter("CountyID"));

			try {
				Poverty poverty = new Poverty(year, povertyPopulation, percentPovertyPopulation, 
						 ageGroupId, countyID);
	        	
	        	poverty = PovertyDao.create(poverty);
				messages.put("success", "Successfully created record" + poverty.getRecordID());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}

		req.getRequestDispatcher("/PovertyCreate.jsp").forward(req, resp);
	
	
	
	
	/**
	private static final long serialVersionUID = 1L;				// added this, check if correct
	protected PovertyDao povertyDao;
	
	@Override
	public void init() throws ServletException {
		povertyDao = PovertyDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/PovertyCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String s_recordId = req.getParameter("recordId");
        int recordId = Integer.parseInt(s_recordId);
        
        if (s_recordId == null || s_recordId.trim().isEmpty()) {
            messages.put("success", "Invalid RecordID");
        } else {
        	// Create the Poverty Record.
        	String s_year = req.getParameter("year");
        	int year = Integer.parseInt(s_year);
        	
        	String s_povertyPopulation = req.getParameter("povertyPopulation");
        	int povertyPopulation = Integer.parseInt(s_povertyPopulation);
        	
        	String s_percentPovertyPopulation = req.getParameter("percentPovertyPopulation");
        	BigDecimal percentPovertyPopulation = new BigDecimal(s_percentPovertyPopulation);
        	
        	String confidenceInterval = req.getParameter("confidenceInterval");
        	
        	String s_ageGroupId = req.getParameter("ageGroupId");
        	int ageGroupId = Integer.parseInt(s_ageGroupId);
        	
        	String s_countyId = req.getParameter("countyId");
        	int countyId = Integer.parseInt(s_countyId);
        	
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Poverty poverty = new Poverty(recordId, year, povertyPopulation, percentPovertyPopulation, 
	        			confidenceInterval, ageGroupId, countyId);
	        	
	        	poverty = PovertyDao.create(poverty);
	        	messages.put("success", "Successfully created " + recordId);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/PovertyCreate.jsp").forward(req, resp);
        */
    }
}
