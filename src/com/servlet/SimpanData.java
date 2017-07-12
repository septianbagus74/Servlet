package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DaoDosen;
import com.data.DataDosen;

/**
 * Servlet implementation class SimpanData
 */
@WebServlet("/SimpanData")
@MultipartConfig
public class SimpanData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpanData() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void proses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Ambil data dari form    	
    	PrintWriter out = response.getWriter();
    	DataDosen dataUser = new DataDosen();
    	dataUser.setDosen(request.getParameter("dosen"));
    	dataUser.setMapel(request.getParameter("mapel"));
    	
    	// simpan data
		DaoDosen daoUser = new DaoDosen();
		
    	if(daoUser.insertData(dataUser)){
    		response.sendRedirect("dosen.jsp");
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
