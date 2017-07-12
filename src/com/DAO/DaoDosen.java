package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataDosen;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoDosen {
	private Connection conn = null;
	
	public DaoDosen(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataDosen data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO dosen (id_dosen,dosen,mapel) VALUES (NULL,?,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getDosen());
			ps.setString(2, data.getMapel());
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public List<DataDosen> getDataDosen(){
		List<DataDosen> res = new ArrayList<DataDosen>();
		
		try {
			String query = "SELECT id_dosen,dosen,mapel FROM dosen";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataDosen temp = new DataDosen();
				temp.setId_dosen(rs.getInt("id_dosen"));
				temp.setDosen(rs.getString("dosen"));
				temp.setMapel(rs.getString("mapel"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataDosen getDataDosenById(int id_dosen){
		DataDosen res = new DataDosen();
		
		try {
			String query = "SELECT id_dosen,dosen,mapel FROM dosen WHERE id_dosen="+id_dosen;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setId_dosen(rs.getInt("id_dosen"));
				res.setDosen(rs.getString("dosen"));
				res.setMapel(rs.getString("mapel"));
			}else{
				System.out.println("data kosong ....");
			}
			
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public boolean deleteData(int id_dosen){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM dosen WHERE id_dosen=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id_dosen);			
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public boolean updateData(DataDosen data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `kuliah`.`dosen` SET `dosen`=?, `mapel`=? WHERE `id_dosen`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getDosen());
			ps.setString(2, data.getMapel());
			ps.setInt(3, data.getId_dosen());
			
			// eksekusi prepare statment			
			ps.execute();
			stat = true;
			conn.close();
			
		} catch (SQLException e) {
			System.out.print("Ada yang salah");
			e.printStackTrace();
		}
		
		return stat;
	}
	
	public static void main(String[] args) {
//		List<DataUser> x = new ArrayList<DataUser>();
//		x = new DaoUser().getDataUserByid_dosen(10);
//		for (DataUser dataUser : x) {
//			System.out.println(dataUser.getNama());
//		}
		
		DataDosen a = new DaoDosen().getDataDosenById(21);
		System.out.print(a.getDosen());
	}
}
