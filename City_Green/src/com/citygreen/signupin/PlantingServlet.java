package com.citygreen.signupin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.citygreen.crud.CityGreenCRUDOperations;
import com.citygreen.crud.PlantingBean;
import com.citygreen.crud.UserBean;

/**
 * Servlet implementation class PlantingServlet
 */
@WebServlet("/PlantingServlet")
public class PlantingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		@SuppressWarnings("unchecked")
		List<UserBean> users = (List<UserBean>) sess.getAttribute("plants");
		
		String contact = null, name = null;	
		for(UserBean userlist: users) {
			contact = userlist.GetUser_Contactnumber();
			name = userlist.GetUser_Name();
		}
		
		CityGreenCRUDOperations cg = new CityGreenCRUDOperations();
		//cg.getplanUserdetails(userid);
		PlantingBean plant = new PlantingBean();
		plant.SetName(name);
		plant.SetContact(contact);
		plant.SetArea_details(request.getParameter("areadetails"));
		String participants = request.getParameter("participants");
		int participant = Integer.parseInt(participants);
		String plants = request.getParameter("plants");
		int no_of_plant = Integer.parseInt(plants);
		plant.SetParticipants(participant);
		plant.SetPlants(no_of_plant);
		plant.SetDate_Time(request.getParameter("datetime"));
		plant.SetNotes(request.getParameter("notes"));
		
		cg.postPlantingDetails(plant);
		RequestDispatcher rd = request.getRequestDispatcher("cityhome.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
