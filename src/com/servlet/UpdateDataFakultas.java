package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.DaoFakultas;
import com.data.DataFakultas;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateDataFakultas")
public class UpdateDataFakultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataFakultas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoFakultas du = new DaoFakultas();
		DataFakultas user = du.getDataFakultasById(Integer.parseInt(request.getParameter("id")));
		
		
		// send data to servlet
		request.setAttribute("id", user.getId_fakultas());
		request.setAttribute("fakultas", user.getFakultas());
		request.setAttribute("jurusan", user.getJurusan());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePageFakultas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataFakultas dataUser = new DataFakultas();
	    	dataUser.setFakultas(request.getParameter("fakultas"));
	    	dataUser.setJurusan(request.getParameter("jurusan"));
	    	dataUser.setId_fakultas(Integer.parseInt(request.getParameter("id")));
	    	
	    	// simpan data
			DaoFakultas daoUser = new DaoFakultas();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("fakultas.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("fakultas.jsp");
		}
		
		
	}

}
