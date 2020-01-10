<%@page import="bean.ThanhVienBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
<table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Ma TV</th>
        <th scope="col">Ten TV</th>
        <th scope="col">Diem TB</th>
      </tr>
    </thead>
    <tbody>
       <% ArrayList<ThanhVienBean> dsLoai = (ArrayList<ThanhVienBean>) request.getAttribute("dsLoai");
		for (int i =0; i<dsLoai.size(); i++) {
			ThanhVienBean loai = dsLoai.get(i); %>
			<tr>
				<td><%=loai.getMaTV() %></td>
				<td><%=loai.getHoTen() %></td>
				<td><%=loai.getDTB() %></td>
		     </tr>	
		<%}%>   
    </tbody>
  </table>
</div>
</body>
</html>