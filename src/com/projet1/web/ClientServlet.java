package com.projet1.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet1.dao.ClientImpl;
import com.projet1.dao.IClient;
import com.projet1.dao.IUser;
import com.projet1.dao.IVillage;
import com.projet1.dao.UserImpl;
import com.projet1.dao.VillageImpl;
import com.projet1.entities.Client;
import com.projet1.entities.User;
import com.projet1.entities.Village;



@WebServlet (name="cs", urlPatterns= {"/controleur", "*.aissatou"})
public class ClientServlet extends HttpServlet {

	private IVillage villagedao;
	private IUser userdao;
	private IClient clientdao;
	IClient metier;
	@Override
	public void init(ServletConfig config) throws ServletException{
		metier = new ClientImpl();
		villagedao = new VillageImpl();
		userdao = new UserImpl();
		clientdao = new ClientImpl();
		
		
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		String path = request.getServletPath();
		if(path.equals("/index.aissatou")){
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else if(path.equals("/chercher.aissatou")) {
			String motCle = request.getParameter("motCle");
			/*
			 * ProduitModele mod = new ProduitModele(); mod.setMotCle(motCle); List<Produit>
			 * prods = metier.produitsParMC("motCle"); mod.setProduits(prods);
			 
			request.setAttribute("model", mod);
			*/
			
			ClientImpl clientDb = new ClientImpl();
			
			
			request.setAttribute("clients",  clientDb.clientParMC(motCle));
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = request.getServletPath();
		if(path.equals("/save.aissatou")){
		String nomDeFamille = request.getParameter("nom").toString();;
		String telephone = request.getParameter("telephone").toString();;
		String adresse = request.getParameter("adresse").toString();;
		HttpSession session = request.getSession();
	    int userId = (int) session.getAttribute("id");
	    
		
		//String nomVillage = request.getParameter("village");
		//Village village = villagedao.getVillageByName(nomVillage);
		
		
	    Client client=new Client();
	       
	    client.setAdresse_client(adresse);
	    client.setNom_client(nomDeFamille);
	    client.setTelephone_client(telephone);
	    client.setUser(userdao.get(userId));
	   
	    clientdao.add(client);
	    
	    //request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}
	}
	
}
