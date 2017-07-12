<%@page import="com.DAO.DaoRayon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.data.DataRayon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Rayon</title>
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
	<form action="UpdateDataRayon" method="POST">
	<input type="hidden" value="${id}" name="id">
	<table align="center">
		<thead>
			<tr>
				<td>RAYON</td>
				<td>:</td>
				<td><input type="text" name="rayon" class="form-control" value="${rayon}"></td>
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
				<th>Rayon</th>
				<th colspan="2">Aksi</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DataRayon> kuliah = new ArrayList<DataRayon>();
				kuliah = new DaoRayon().getDataRayon();
				
				for(DataRayon user : kuliah){
					out.print("<tr>");
					out.print("<td>"+user.getRayon() + "</td>");
					out.print("<td  align='center'><a href='UpdateDataRayon?id="+user.getId_rayon()+"'><i class='glyphicon glyphicon-pencil'></a></td>");
					out.print("<td  align='center'><a href='HapusDataRayon?id="+user.getId_rayon()+"'><i class='glyphicon glyphicon-trash'></i></a></td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	</form>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>