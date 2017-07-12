package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataRayon;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoRayon {
	private Connection conn = null;
	
	public DaoRayon(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataRayon data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO rayon (id_rayon,rayon) VALUES (NULL,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getRayon());
			
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
	
	public List<DataRayon> getDataRayon(){
		List<DataRayon> res = new ArrayList<DataRayon>();
		
		try {
			String query = "SELECT id_rayon,rayon FROM rayon";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataRayon temp = new DataRayon();
				temp.setId_rayon(rs.getInt("id_rayon"));
				temp.setRayon(rs.getString("rayon"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataRayon getDataRayonById(int id_rayon){
		DataRayon res = new DataRayon();
		
		try {
			String query = "SELECT id_rayon,rayon FROM rayon WHERE id_rayon="+id_rayon;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setId_rayon(rs.getInt("id_rayon"));
				res.setRayon(rs.getString("rayon"));
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
	
	public boolean deleteData(int id_rayon){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM rayon WHERE id_rayon=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id_rayon);			
			
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
	
	public boolean updateData(DataRayon data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `kuliah`.`rayon` SET `rayon`=? WHERE `id_rayon`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getRayon());
			ps.setInt(2, data.getId_rayon());
			
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
		
		DataRayon a = new DaoRayon().getDataRayonById(21);
		System.out.print(a.getRayon());
	}
}
