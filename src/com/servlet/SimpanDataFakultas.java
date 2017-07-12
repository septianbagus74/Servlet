package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DaoFakultas;
import com.data.DataFakultas;

/**
 * Servlet implementation class SimpanData
 */
@WebServlet("/SimpanDataFakultas")
@MultipartConfig
public class SimpanDataFakultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpanDataFakultas() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void proses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Ambil data dari form    	
    	PrintWriter out = response.getWriter();
    	DataFakultas dataUser = new DataFakultas();
    	dataUser.setFakultas(request.getParameter("fakultas"));
    	dataUser.setJurusan(request.getParameter("jurusan"));
    	
    	// simpan data
		DaoFakultas daoUser = new DaoFakultas();
		
    	if(daoUser.insertData(dataUser)){
    		response.sendRedirect("fakultas.jsp");
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
