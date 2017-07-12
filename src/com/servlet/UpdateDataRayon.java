package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.DaoRayon;
import com.data.DataRayon;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateDataRayon")
public class UpdateDataRayon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataRayon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoRayon du = new DaoRayon();
		DataRayon user = du.getDataRayonById(Integer.parseInt(request.getParameter("id")));
		
		
		// send data to servlet
		request.setAttribute("id", user.getId_rayon());
		request.setAttribute("rayon", user.getRayon());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePageRayon.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataRayon dataUser = new DataRayon();
	    	dataUser.setRayon(request.getParameter("rayon"));
	    	dataUser.setId_rayon(Integer.parseInt(request.getParameter("id")));
	    	
	    	// simpan data
			DaoRayon daoUser = new DaoRayon();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("rayon.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("rayon.jsp");
		}
		
		
	}

}
