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

import com.projet1.dao.IVillage;
import com.projet1.dao.VillageImpl;
import com.projet1.entities.Village;



/**
 * Servlet implementation class VillageServlet
 */
@WebServlet(name = "village", urlPatterns = { "/village" })
public class VillageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IVillage villagedao;
  
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		villagedao = new VillageImpl();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Village> villages = villagedao.villages();
		request.setAttribute("villages", villages);
		request.getRequestDispatcher("").forward(request, response);
		String path = request.getServletPath();
		if (path.equals("/supprimer")) {
			Village village = null;
			HttpSession session = request.getSession();
			int id = (int) session.getAttribute("id");
			villagedao.delete(id,village);
			request.getRequestDispatcher("").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomVillage = request.getParameter("nomVillage").toString();
		
		if (!(nomVillage.isEmpty())) {
			Village village = new Village();
			village.setNom_village(nomVillage);
				
			villagedao.add(village);	

			List<Village> villages = villagedao.villages();
			request.setAttribute("villages", villages);
			request.getRequestDispatcher("/listevillage.jsp").forward(request, response);
			
		}else {
			List<Village> villages = villagedao.villages();
			request.setAttribute("villages", villages);
			request.getRequestDispatcher("").forward(request, response);
			
		}
		
		
		
	}

}

