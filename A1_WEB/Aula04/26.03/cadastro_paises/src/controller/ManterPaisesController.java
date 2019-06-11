package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Paises;
import service.PaisesService;

/**
 * Servlet implementation class ManterPaisesController
 */
@WebServlet("/ManterPaises.do")
public class ManterPaisesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String nome = request.getParameter("nome");	
		   long populacao = Long.parseLong(request.getParameter("população"));
		   double area = Double.parseDouble(request.getParameter("area"));
		   Paises paises = new Paises(nome,populacao,area);
		   PaisesService paisService = new PaisesService();
		   try {
			int id = paisService.inserir(paises);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		   PrintWriter out = response.getWriter();
			out.println("<html><head><title>Pais Cadastrado</title></head><body>");
			out.println(	"id: "+paises.getId()+"<br>");
			out.println(	"nome: "+paises.getNome()+"<br>");
			out.println(	"populacao: "+paises.getPopulacao()+"<br>");
			out.println(	"area: "+paises.getArea()+"<br>");
		    out.println("</body></html>");
			
		}
		}
	
	
	


