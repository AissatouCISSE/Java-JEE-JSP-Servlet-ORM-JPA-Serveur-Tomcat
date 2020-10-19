package com.projet1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet1.dao.ClientImpl;
import com.projet1.dao.IClient;



@WebServlet (name="cs", urlPatterns= {"/controleur", "*.aissatou"})
public class ClientServlet extends HttpServlet {

	IClient metier;
	@Override
	public void init() throws ServletException{
		metier = new ClientImpl();
		
	}
	
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		String path = request.getServletPath();
		if(path.equals("/index.aissatou")){
			request.getRequestDispatcher("clients.jsp").forward(request,response);
		}else if(path.equals("/chercher.aissatou")) {
			String motCle = request.getParameter("motCle");
			/*
			 * ProduitModele mod = new ProduitModele(); mod.setMotCle(motCle); List<Produit>
			 * prods = metier.produitsParMC("motCle"); mod.setProduits(prods);
			 
			request.setAttribute("model", mod);
			*/
			
			ClientImpl clientDb = new ClientImpl();
			
			
			request.setAttribute("clients",  clientDb.clientParMC(motCle));
			
			
			request.getRequestDispatcher("clients.jsp").forward(request, response);
		}
		
	}
	
}
