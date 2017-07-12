package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DaoRayon;
import com.data.DataRayon;

/**
 * Servlet implementation class SimpanData
 */
@WebServlet("/SimpanDataRayon")
@MultipartConfig
public class SimpanDataRayon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpanDataRayon() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void proses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Ambil data dari form    	
    	PrintWriter out = response.getWriter();
    	DataRayon dataUser = new DataRayon();
    	dataUser.setRayon(request.getParameter("rayon"));
    	
    	// simpan data
		DaoRayon daoUser = new DaoRayon();
		
    	if(daoUser.insertData(dataUser)){
    		response.sendRedirect("rayon.jsp");
    	}else{
    		out.print("gagal");
    	}
    	
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proses(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proses(request, response);
	}

}
