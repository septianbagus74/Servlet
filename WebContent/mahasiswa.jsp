<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.data.*"%>
<%@page import="com.DAO.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Mahasiswa</title>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<!--Kode Navbar-->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Multipolar Technology</a>
              </div>
 
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li class="dropdown">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Kelola <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="dosen.jsp">Dosen</a></li>
                      <li><a href="eskul.jsp">Eskul</a></li>
                      <li><a href="rayon.jsp">Rayon</a></li>
                      <li><a href="fakultas.jsp">Fakultas</a>
                      <li role="separator" class="divider"></li>
                      <li><a href="mahasiswa.jsp">Mahasiswa</a></li>
                    </ul>
                  </li>
                </ul>
                <form class="navbar-form navbar-left">
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                  </div>
                  <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#">Logout</a></li>
                    </ul>
              </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!--Akhir Navbar-->
	<form action="SimpanDataMahasiswa" method="POST">
	<table align="center">
		<thead>
			<tr>
				<td>NIM</td>
				<td>:</td>
				<td><input type="text" name="nim" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Nama</td>
				<td>:</td>
				<td><input type="text" name="nama" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>JK</td>
				<td>:</td>
				<td>
				<select name="jk" class="form-control">
					<option value="">---Pilih JK---</option>
					<option value="L">Laki - laki</option>
					<option value="P">Perempuan</option>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Rayon</td>
				<td>:</td>
				<td>
				<select name="id_rayon" class="form-control">
				<option value="">---Pilih Rayon---</option>
					<% 
				List<DataRayon> kuliah = new ArrayList<DataRayon>();
				kuliah = new DaoRayon().getDataRayon();
				
				for(DataRayon user : kuliah){
				%>
				<option value="<%out.print(user.getId_rayon());%>"><%out.print(user.getRayon());%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Alamat</td>
				<td>:</td>
				<td><textarea name="alamat" class="form-control"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Fakultas</td>
				<td>:</td>
				<td>
				<select name="id_fakultas" class="form-control">
				<option>---Pilih Fakultas---</option>
					<% 
				List<DataFakultas> fakultas = new ArrayList<DataFakultas>();
				fakultas = new DaoFakultas().getDataFakultas();
				
				for(DataFakultas user : fakultas){
				%>
				<option value="<%out.print(user.getId_fakultas());%>"><%out.print(user.getFakultas());%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Angkatan</td>
				<td>:</td>
				<td><input type="number" name="angkatan" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Eskul</td>
				<td>:</td>
				<td>
				<select name="id_eskul" class="form-control">
				<option value="">----Pilih Eskul----</option>
					<% 
				List<DataEskul> eskul = new ArrayList<DataEskul>();
				eskul = new DaoEskul().getDataEskul();
				
				for(DataEskul user : eskul){
				%>
				<option value="<%out.print(user.getId_eskul());%>"><%out.print(user.getEskul());%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Prestasi</td>
				<td>:</td>
				<td><textarea name="prestasi" class="form-control"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Dosen</td>
				<td>:</td>
				<td>
				<select name="id_dosen" class="form-control">
				<option>---Pilih Dosen---</option>
				<% 
				List<DataDosen> dosen = new ArrayList<DataDosen>();
				dosen = new DaoDosen().getDataDosen();
				
				for(DataDosen user : dosen){
				%>
				<option value="<%out.print(user.getId_dosen());%>"><%out.print(user.getDosen());%></option>
				<% } %>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Nilai</td>
				<td>:</td>
				<td><input type="number" name="nilai" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="kirim" class="btn btn-primary"></td>
			</tr>
	</table>
	<br>
	<table border="1" align="center" class="table table-bordered">
		<thead>
			<tr>
				<th>NIM</th>
				<th>Nama</th>
				<th>Jk</th>
				<th>Rayon</th>
				<th>Alamat</th>
				<th>Fakultas</th>
				<th>Angkatan</th>
				<th>Eskul</th>
				<th>Prestasi</th>
				<th>Dosen</th>
				<th>Nilai</th>
				<th colspan="2">Aksi</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DataMahasiswa> m = new ArrayList<DataMahasiswa>();
				m = new DaoMahasiswa().getDataMahasiswa();
				
				for(DataMahasiswa user : m){
					out.print("<tr>");
					out.print("<td>"+user.getNim() + "</td><td>" + user.getNama()+"</td><td>"+ user.getJk()+"</td><td>"+ user.getRayon()+"</td><td>"+ user.getAlamat()+"</td><td>"+ user.getFakultas()+"</td><td>"+ user.getAngkatan()+"</td><td>"+ user.getEskul()+"</td><td>"+ user.getPrestasi()+"</td><td>"+ user.getDosen()+"</td><td>"+ user.getNilai()+"</td>");
					out.print("<td><a href='UpdateDataMahasiswa?nim="+user.getNim()+"'><i class='glyphicon glyphicon-pencil'></a></td>");
					out.print("<td><a href='HapusDataMahasiswa?nim="+user.getNim()+"'><i class='glyphicon glyphicon-trash'></i></a></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	</form>
</body>
