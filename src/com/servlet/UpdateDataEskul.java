package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.DaoEskul;
import com.data.DataEskul;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateDataEskul")
public class UpdateDataEskul extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataEskul() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoEskul du = new DaoEskul();
		DataEskul user = du.getDataEskulById(Integer.parseInt(request.getParameter("id")));
		
		
		// send data to servlet
		request.setAttribute("id", user.getId_eskul());
		request.setAttribute("eskul", user.getEskul());
		request.setAttribute("pembimbing", user.getPembimbing());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePageEskul.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataEskul dataUser = new DataEskul();
	    	dataUser.setEskul(request.getParameter("eskul"));
	    	dataUser.setPembimbing(request.getParameter("pembimbing"));
	    	dataUser.setId_eskul(Integer.parseInt(request.getParameter("id")));
	    	
	    	// simpan data
			DaoEskul daoUser = new DaoEskul();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("eskul.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("eskul.jsp");
		}
		
		
	}

}
