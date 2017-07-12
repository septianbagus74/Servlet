package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.*;
import com.data.*;

/**
 * Servlet implementation class SimpanData
 */
@WebServlet("/SimpanDataMahasiswa")
@MultipartConfig
public class SimpanDataMahasiswa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpanDataMahasiswa() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void proses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// Ambil data dari form    	
    	PrintWriter out = response.getWriter();
    	DataMahasiswa dataUser = new DataMahasiswa();
    	dataUser.setNim(Integer.parseInt(request.getParameter("nim")));
    	dataUser.setNama(request.getParameter("nama"));
    	dataUser.setJk(request.getParameter("jk"));
    	dataUser.setId_rayon(Integer.parseInt(request.getParameter("id_rayon")));
    	dataUser.setAlamat(request.getParameter("alamat"));
    	dataUser.setId_fakultas(Integer.parseInt(request.getParameter("id_fakultas")));
    	dataUser.setAngkatan(Integer.parseInt(request.getParameter("angkatan")));
    	dataUser.setId_eskul(Integer.parseInt(request.getParameter("id_eskul")));
    	dataUser.setPrestasi(request.getParameter("prestasi"));
    	dataUser.setId_dosen(Integer.parseInt(request.getParameter("id_dosen")));
    	dataUser.setNilai(Integer.parseInt(request.getParameter("nilai")));
    	
    	// simpan data
		DaoMahasiswa daoUser = new DaoMahasiswa();
		
    	if(daoUser.insertData(dataUser)){
    		response.sendRedirect("mahasiswa.jsp");
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
