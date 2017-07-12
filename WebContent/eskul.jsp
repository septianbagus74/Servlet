<%@page import="com.DAO.DaoEskul"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.data.DataEskul"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Eskul</title>
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Kelola <span class="caret"></span></a>
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
	<form action="SimpanDataEskul" method="POST">
	<table align="center">
		<thead>
			<tr>
				<td>Eskul</td>
				<td>:</td>
				<td><input type="text" name="eskul" class="form-control"></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="hidden">---------------------------------------</td>
			</tr>
			<tr>
				<td>Pembimbing</td>
				<td>:</td>
				<td><input type="text" name="pembimbing" class="form-control"></td>
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
				<th>Eskul</th>
				<th>Pembimbing</th>
				<th colspan="2">Aksi</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DataEskul> kuliah = new ArrayList<DataEskul>();
				kuliah = new DaoEskul().getDataEskul();
				
				for(DataEskul user : kuliah){
					out.print("<tr>");
					out.print("<td>"+user.getEskul() + "</td><td>" + user.getPembimbing()+"</td>");
					out.print("<td align='center'><a href='UpdateDataEskul?id="+user.getId_eskul()+"'><i class='glyphicon glyphicon-pencil'></a></td>");
					out.print("<td align='center'><a href='HapusDataEskul?id="+user.getId_eskul()+"'><i class='glyphicon glyphicon-trash'></a></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	</form>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>