package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.DaoDosen;
import com.data.DataDosen;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoDosen du = new DaoDosen();
		DataDosen user = du.getDataDosenById(Integer.parseInt(request.getParameter("id")));
		
		
		// send data to servlet
		request.setAttribute("id", user.getId_dosen());
		request.setAttribute("dosen", user.getDosen());
		request.setAttribute("mapel", user.getMapel());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataDosen dataUser = new DataDosen();
	    	dataUser.setDosen(request.getParameter("dosen"));
	    	dataUser.setMapel(request.getParameter("mapel"));
	    	dataUser.setId_dosen(Integer.parseInt(request.getParameter("id")));
	    	
	    	// simpan data
			DaoDosen daoUser = new DaoDosen();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("dosen.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("dosen.jsp");
		}
		
		
	}

}
