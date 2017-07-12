package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.*;
import com.data.*;

/**
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateDataMahasiswa")
public class UpdateDataMahasiswa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataMahasiswa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		DaoMahasiswa du = new DaoMahasiswa();
		DataMahasiswa user = du.getDataMahasiswaById(Integer.parseInt(request.getParameter("nim")));
		
		
		// send data to servlet
		request.setAttribute("nim", user.getNim());
		request.setAttribute("nama", user.getNama());
		request.setAttribute("jk", user.getJk());
		request.setAttribute("id_rayon", user.getId_rayon());
		request.setAttribute("rayon", user.getRayon());
		request.setAttribute("alamat", user.getAlamat());
		request.setAttribute("id_fakultas", user.getId_fakultas());
		request.setAttribute("fakultas", user.getFakultas());
		request.setAttribute("jurusan", user.getJurusan());
		request.setAttribute("angkatan", user.getAngkatan());
		request.setAttribute("id_eskul", user.getId_eskul());
		request.setAttribute("eskul", user.getEskul());
		request.setAttribute("pembimbing", user.getPembimbing());
		request.setAttribute("prestasi", user.getPrestasi());
		request.setAttribute("id_dosen", user.getId_dosen());
		request.setAttribute("dosen", user.getDosen());
		request.setAttribute("mapel", user.getMapel());
		request.setAttribute("nilai", user.getNilai());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePageMahasiswa.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	
		if(request.getParameter("batal")==null){
			// Ambil data dari form    	
	    	DataMahasiswa dataUser = new DataMahasiswa();
	    	dataUser.setNama(request.getParameter("nama"));
	    	dataUser.setJk(request.getParameter("jk"));
	    	dataUser.setId_rayon(Integer.parseInt(request.getParameter("id_rayon")));
	    	dataUser.setRayon(request.getParameter("rayon"));
	    	dataUser.setAlamat(request.getParameter("alamat"));
	    	dataUser.setId_fakultas(Integer.parseInt(request.getParameter("id_fakultas")));
	    	dataUser.setFakultas(request.getParameter("fakultas"));
	    	dataUser.setJurusan(request.getParameter("jurusan"));
	    	dataUser.setAngkatan(Integer.parseInt(request.getParameter("angkatan")));
	    	dataUser.setId_eskul(Integer.parseInt(request.getParameter("id_eskul")));
	    	dataUser.setEskul(request.getParameter("eskul"));
	    	dataUser.setPembimbing(request.getParameter("pembimbing"));
	    	dataUser.setPrestasi(request.getParameter("prestasi"));
	    	dataUser.setId_dosen(Integer.parseInt(request.getParameter("id_dosen")));
	    	dataUser.setDosen(request.getParameter("dosen"));
	    	dataUser.setMapel(request.getParameter("mapel"));
	    	dataUser.setNilai(Integer.parseInt(request.getParameter("nilai")));
	    	dataUser.setNim(Integer.parseInt(request.getParameter("nim")));
	    	
	    	// simpan data
			DaoMahasiswa daoUser = new DaoMahasiswa();
			
	    	if(daoUser.updateData(dataUser)){
	    		response.sendRedirect("mahasiswa.jsp");
	    	}else{
	    		out.print("gagal");
	    	}
		}else{
			response.sendRedirect("mahasiswa.jsp");
		}
		
		
	}

}
