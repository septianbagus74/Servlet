package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataEskul;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoEskul {
	private Connection conn = null;
	
	public DaoEskul(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataEskul data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO eskul (id_eskul,eskul,pembimbing) VALUES (NULL,?,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getEskul());
			ps.setString(2, data.getPembimbing());
			
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
	
	public List<DataEskul> getDataEskul(){
		List<DataEskul> res = new ArrayList<DataEskul>();
		
		try {
			String query = "SELECT id_eskul,eskul,pembimbing FROM eskul";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataEskul temp = new DataEskul();
				temp.setId_eskul(rs.getInt("id_eskul"));
				temp.setEskul(rs.getString("eskul"));
				temp.setPembimbing(rs.getString("pembimbing"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataEskul getDataEskulById(int id_eskul){
		DataEskul res = new DataEskul();
		
		try {
			String query = "SELECT id_eskul,eskul,pembimbing FROM eskul WHERE id_eskul="+id_eskul;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setId_eskul(rs.getInt("id_eskul"));
				res.setEskul(rs.getString("eskul"));
				res.setPembimbing(rs.getString("pembimbing"));
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
	
	public boolean deleteData(int id_eskul){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM eskul WHERE id_eskul=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id_eskul);			
			
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
	
	public boolean updateData(DataEskul data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `kuliah`.`eskul` SET `eskul`=?, `pembimbing`=? WHERE `id_eskul`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getEskul());
			ps.setString(2, data.getPembimbing());
			ps.setInt(3, data.getId_eskul());
			
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
//		x = new DaoUser().getDataUserByid_eskul(10);
//		for (DataUser dataUser : x) {
//			System.out.println(dataUser.getNama());
//		}
		
		DataEskul a = new DaoEskul().getDataEskulById(21);
		System.out.print(a.getEskul());
	}
}
