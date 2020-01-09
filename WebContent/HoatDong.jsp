<%@page import="java.util.ArrayList"%>
<%@page import="bean.HoatDongBean"%>
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
<%HoatDongBean hd = (HoatDongBean)request.getAttribute("hd"); %>
<div class="container">
<form action="AdminLoaiController">
	<label>Ma HD</label>
	<input type="text" name="txtMaHD" value="<%if (hd!=null) out.print(hd.getMaHD()); %>" class="form-control"> <br>
	<label>Ten HD</label>
	<input type="text" name="txtTenHD" value="<%if (hd!=null) out.print(hd.getTenHD()); %>" class="form-control"> <br>
	<label>Mo ta HD</label>
	<input type="text" name="txtMoTaHD" value="<%if (hd!=null) out.print(hd.getMoTaHD()); %>" class="form-control"> <br>
	<label>Ngay gio bat dau</label>
	<input type="datetime-local" name="txtNgayGioBD" value="<%if (hd!=null) out.print(hd.getNgayGioBD()); %>" class="form-control"> <br>
	<label>Ngay gio ket thuc</label>
	<input type="datetime-local" name="txtNgayGioKT" value="<%if (hd!=null) out.print(hd.getNgayGioKT()); %>" class="form-control"> <br>
	<label>So luong toi thieu yeu cau</label>
	<input type="number" name="txtSLToiThieuYC" value="<%if (hd!=null) out.print(hd.getSlToiThieuYC()); %>" class="form-control"> <br>
	<label>So luong toi da yeu cau</label>
	<input type="number" name="txtSLToiDaYC" value="<%if (hd!=null) out.print(hd.getSlToiDaYC()); %>" class="form-control"> <br>
	<label>Thoi han dang ky</label>
	<input type="datetime-local" name="txtThoiHanDK" value="<%if (hd!=null) out.print(hd.getThoiHanDK()); %>" class="form-control"> <br>
	<%if (hd!=null) { %>
	<label>Trang thai</label>
	<select name="cbbTrangThai" class="form-control">
	    <option  <% if (hd.getTrangThai().equals("Dang moi dang ky")) out.print("selected"); %>>
	    	Dang moi dang ky
	    </option>
	    <option  <% if (hd.getTrangThai().equals("Da het han dang ky")) out.print("selected"); %>>
	    	Da het han dang ky
	    </option>
	    <option  <% if (hd.getTrangThai().equals("Truong doan tu huy")) out.print("selected"); %>>
	    	Truong doan tu huy
	    </option>
	    <option  <% if (hd.getTrangThai().equals("Da ket thuc")) out.print("selected"); %>>
	    	Da ket thuc
	    </option>
	</select>
	
	<input type="text" name="txtTrangThai" value="<% out.print(hd.getMaHD()); %>" class="form-control"> <br>
	<%} %>
	<label>Ma TV</label>
	<input type="text" name="txtMaTV" value="<%if (hd!=null) out.print(hd.getMaTV()); %>" class="form-control"> <br>
	<%if (hd!=null) { %>
	<label>Ly do huy HD</label>
	<input type="text" name="txtLyDoHuyHD" value="<% out.print(hd.getLyDoHuyHD()); %>" class="form-control"> <br>
	<%} %>
	<input type="submit" name="btnThem" value="Them" class="btn btn-primary">
	<input type="submit" name="btnSua" value="Sua" class="btn btn-primary"> <br>
</form>
<table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Ma HD</th>
        <th scope="col">Ten HD</th>
        <th scope="col">Mo ta HD</th>
        <th scope="col">Ngay gio BD</th>
        <th scope="col">Ngay gio KT</th>
        <th scope="col">SL toi thieu</th>
        <th scope="col">SL toi da</th>
        <th scope="col">Thoi han dang ky</th>
        <th scope="col">Trang thai</th>
        <th scope="col">Truong doan</th>
        <th scope="col">Thao tac</th>
      </tr>
    </thead>
    <tbody>
       <% ArrayList<HoatDongBean> dsLoai = (ArrayList<HoatDongBean>) request.getAttribute("dsLoai");
		for (int i =0; i<dsLoai.size(); i++) {
			HoatDongBean loai = dsLoai.get(i); %>
			<tr>
				<td><%=loai.getMaHD() %></td>
				<td><%=loai.getTenHD() %></td>
				<td><%=loai.getMoTaHD() %></td>
				<td><%=loai.getNgayGioBD() %></td>
				<td><%=loai.getNgayGioKT() %></td>
				<td><%=loai.getSlToiThieuYC() %></td>
				<td><%=loai.getSlToiDaYC() %></td>
				<td><%=loai.getThoiHanDK() %></td>
				<td><%=loai.getTrangThai() %></td>
				<td><%=loai.getMaTV() %></td>
				<td class="d-flex">
		         <a href="HoatDongController?maChon=<%=loai.getMaHD()%>" class="btn btn-primary mr-2">Chon</a>
		         <a href="HoatDongController?maXoa=<%=loai.getMaHD()%>" class="btn btn-danger">Xoa</a>
		       </td>
		     </tr>	
		<%} %>   
    </tbody>
  </table>
</div>
</body>
</html>