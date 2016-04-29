package com.slavisa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slavisa.battleship.BattleshipGridGenerator;

/**
 * Servlet implementation class BattleshipServlet
 */
@WebServlet("/BattleshipServlet")
public class BattleshipServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BattleshipGridGenerator battleShip;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BattleshipServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		battleShip = new BattleshipGridGenerator();
		
		request.setAttribute("battleship", battleShip.getBattleshipBoard());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
