package BehindTheNumbers.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BehindTheNumbers.dal.PovertyDao;
import BehindTheNumbers.model.Poverty;



@WebServlet("/povertyread")
@SuppressWarnings("serial")
public class PovertyRead extends HttpServlet {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
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

		List<Poverty> povList = new ArrayList<Poverty>();
		String CountyID = req.getParameter("CountyID");
		
		if (CountyID == null || CountyID.trim().isEmpty()) {
            messages.put("success", "Please enter a valid integer for countyID.");
        } else {
        	try {

        		int countyId = Integer.parseInt(req.getParameter("CountyID"));
        		povList = povertyDao.getPovertyRecordsByCountyID(countyId);
        	} catch (SQLException e) {
        		e.printStackTrace();
        		throw new IOException(e);
        	}
        	messages.put("success", "Displaying poverty records for County " + CountyID);
        	messages.put("previousCountyID", "" + CountyID.toString());
        	req.setAttribute("povList", povList);

        	req.getRequestDispatcher("/PovertyRead.jsp").forward(req, resp);
        }
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}