package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataFakultas;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoFakultas {
	private Connection conn = null;
	
	public DaoFakultas(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataFakultas data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO fakultas (id_fakultas,fakultas,jurusan) VALUES (NULL,?,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getFakultas());
			ps.setString(2, data.getJurusan());
			
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
	
	public List<DataFakultas> getDataFakultas(){
		List<DataFakultas> res = new ArrayList<DataFakultas>();
		
		try {
			String query = "SELECT id_fakultas,fakultas,jurusan FROM fakultas";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataFakultas temp = new DataFakultas();
				temp.setId_fakultas(rs.getInt("id_fakultas"));
				temp.setFakultas(rs.getString("fakultas"));
				temp.setJurusan(rs.getString("jurusan"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataFakultas getDataFakultasById(int id_fakultas){
		DataFakultas res = new DataFakultas();
		
		try {
			String query = "SELECT id_fakultas,fakultas,jurusan FROM fakultas WHERE id_fakultas="+id_fakultas;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setId_fakultas(rs.getInt("id_fakultas"));
				res.setFakultas(rs.getString("fakultas"));
				res.setJurusan(rs.getString("jurusan"));
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
	
	public boolean deleteData(int id_fakultas){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM fakultas WHERE id_fakultas=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, id_fakultas);			
			
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
	
	public boolean updateData(DataFakultas data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `kuliah`.`fakultas` SET `fakultas`=?, `jurusan`=? WHERE `id_fakultas`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getFakultas());
			ps.setString(2, data.getJurusan());
			ps.setInt(3, data.getId_fakultas());
			
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
//		x = new DaoUser().getDataUserByid_fakultas(10);
//		for (DataUser dataUser : x) {
//			System.out.println(dataUser.getNama());
//		}
		
		DataFakultas a = new DaoFakultas().getDataFakultasById(21);
		System.out.print(a.getFakultas());
	}
}
