package com.citygreen.signupin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citygreen.crud.CityGreenCRUDOperations;
import com.citygreen.crud.PlantingBean;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet(name="Adminlogin",urlPatterns={"/Adminlogin"},
initParams={@WebInitParam(name="AdminID",value="Admin"),
@WebInitParam(name="Password",value="Admin@123")})
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig sc = getServletConfig();
		String adminid = sc.getInitParameter("AdminID");
		String adminpswd = sc.getInitParameter("Password");
		
		String hadminid = request.getParameter("adminid");
		String hadminpswd = request.getParameter("password");
		
		CityGreenCRUDOperations cg = new CityGreenCRUDOperations();
		List<PlantingBean> plantingdetails = cg.getVolunteerMessage();
		
		request.setAttribute("volunteer_message", plantingdetails);
		
		if((adminid.equals(hadminid)) & (adminpswd.equals(hadminpswd))) {
			RequestDispatcher rd = request.getRequestDispatcher("Volunteer_Message.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("invalidcredentials.html");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
