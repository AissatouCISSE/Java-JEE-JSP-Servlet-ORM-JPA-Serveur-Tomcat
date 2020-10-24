package com.projet1.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet1.dao.IUser;
import com.projet1.dao.IVillage;
import com.projet1.dao.UserImpl;
import com.projet1.dao.VillageImpl;
import com.projet1.entities.Village;



/**
 * Servlet implementation class VillageServlet
 */
@WebServlet(name = "village", urlPatterns = { "/village" })

public class VillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IVillage villagedao;
	private IUser userdao;
  
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		villagedao = new VillageImpl();
		userdao = new UserImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/village")) {
		List<Village> villages = villagedao.villages();
		request.setAttribute("villages", villages);
		request.getRequestDispatcher("village.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomVillage = request.getParameter("nomVillage").toString();
		HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("id");
	    
	    Village village=new Village();
	    village.setNom_village(nomVillage);
	    village.setUser(userdao.get(userId));
	   
	   village.setUser(userdao.get(userId));
	    villagedao.add(village);
	    request.getRequestDispatcher("village.jsp").forward(request, response);
		doGet(request, response);
		
		/**if (!(nomVillage.isEmpty())) {
			Village village = new Village();
			village.setNom_village(nomVillage);
				
			villagedao.add(village);	

			List<Village> villages = villagedao.villages();
			request.setAttribute("villages", villages);
			request.getRequestDispatcher("village.jsp").forward(request, response);
			
		}else {
			List<Village> villages = villagedao.villages();
			request.setAttribute("villages", villages);
			request.getRequestDispatcher("").forward(request, response);
			
		}*/
		
		
	}

}

