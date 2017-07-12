package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.Koneksi;
import com.data.DataMahasiswa;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoMahasiswa {
	private Connection conn = null;
	
	public DaoMahasiswa(){
		// Get connection
		conn = new Koneksi().getKoneksi();
	}
	
	public boolean insertData(DataMahasiswa data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "INSERT INTO mahasiswa (nim,nama,jk,id_rayon,alamat,id_fakultas,angkatan,id_eskul,prestasi,id_dosen,nilai) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, data.getNim());
			ps.setString(2, data.getNama());
			ps.setString(3, data.getJk());
			ps.setInt(4, data.getId_rayon());
			ps.setString(5, data.getAlamat());
			ps.setInt(6, data.getId_fakultas());
			ps.setInt(7, data.getAngkatan());
			ps.setInt(8, data.getId_eskul());
			ps.setString(9, data.getPrestasi());
			ps.setInt(10, data.getId_dosen());
			ps.setInt(11, data.getNilai());
			
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
	
	public List<DataMahasiswa> getDataMahasiswa(){
		List<DataMahasiswa> res = new ArrayList<DataMahasiswa>();
		
		try {
			Statement st = (Statement) conn.createStatement();
			String query = "SELECT * FROM qw_mahasiswa";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				DataMahasiswa temp = new DataMahasiswa();
				temp.setNim(rs.getInt("nim"));
				temp.setNama(rs.getString("nama"));
				temp.setJk(rs.getString("jk"));
				temp.setId_rayon(rs.getInt("id_rayon"));
				temp.setRayon(rs.getString("rayon"));
				temp.setAlamat(rs.getString("alamat"));
				temp.setId_fakultas(rs.getInt("id_fakultas"));
				temp.setFakultas(rs.getString("fakultas"));
				temp.setJurusan(rs.getString("jurusan"));
				temp.setAngkatan(rs.getInt("angkatan"));
				temp.setId_eskul(rs.getInt("id_eskul"));
				temp.setEskul(rs.getString("eskul"));
				temp.setPembimbing(rs.getString("pembimbing"));
				temp.setPrestasi(rs.getString("prestasi"));
				temp.setId_dosen(rs.getInt("id_dosen"));
				temp.setDosen(rs.getString("dosen"));
				temp.setMapel(rs.getString("mapel"));
				temp.setNilai(rs.getInt("nilai"));
				res.add(temp);
			}
			conn.close();
;		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public DataMahasiswa getDataMahasiswaById(int nim){
		DataMahasiswa res = new DataMahasiswa();
		
		try {
			String query = "SELECT * FROM qw_mahasiswa WHERE nim="+nim;
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()){
				res.setNim(rs.getInt("nim"));
				res.setNama(rs.getString("nama"));
				res.setJk(rs.getString("jk"));
				res.setId_rayon(rs.getInt("id_rayon"));
				res.setRayon(rs.getString("rayon"));
				res.setAlamat(rs.getString("alamat"));
				res.setId_fakultas(rs.getInt("id_fakultas"));
				res.setFakultas(rs.getString("fakultas"));
				res.setJurusan(rs.getString("jurusan"));
				res.setAngkatan(rs.getInt("angkatan"));
				res.setId_eskul(rs.getInt("id_eskul"));
				res.setEskul(rs.getString("eskul"));
				res.setPembimbing(rs.getString("pembimbing"));
				res.setPrestasi(rs.getString("prestasi"));
				res.setId_dosen(rs.getInt("id_dosen"));
				res.setDosen(rs.getString("dosen"));
				res.setMapel(rs.getString("mapel"));
				res.setNilai(rs.getInt("nilai"));
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
	
	public boolean deleteData(int nim){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "DELETE FROM mahasiswa WHERE nim=?;";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setInt(1, nim);			
			
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
	
	public boolean updateData(DataMahasiswa data){
		Boolean stat = false;
		
		try {
			// Query Insert 			
			String query = "UPDATE `kuliah`.`mahasiswa` SET `nama`=?, `jk`=?, `id_rayon`=?, `alamat`=?, `id_fakultas`=?, `angkatan`=?, `id_eskul`=?, `prestasi`=?, `id_dosen`=?, `nilai`=?  WHERE `nim`=?";
			// prepare Statment			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
			ps.setString(1, data.getNama());
			ps.setString(2, data.getJk());
			ps.setInt(3, data.getId_rayon());
			ps.setString(4, data.getAlamat());
			ps.setInt(5, data.getId_fakultas());
			ps.setInt(6, data.getAngkatan());
			ps.setInt(7, data.getId_eskul());
			ps.setString(8, data.getPrestasi());
			ps.setInt(9, data.getId_dosen());
			ps.setInt(10, data.getNilai());
			ps.setInt(11, data.getNim());
			
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
//		x = new DaoUser().getDataUserByid_Mahasiswa(10);
//		for (DataUser dataUser : x) {
//			System.out.println(dataUser.getNama());
//		}
		
		DataMahasiswa a = new DaoMahasiswa().getDataMahasiswaById(21);
		System.out.print(a.getNim());
	}
}
