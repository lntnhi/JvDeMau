package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.HoatDongBo;

/**
 * Servlet implementation class HoatDongController
 */
@WebServlet("/HoatDongController")
public class HoatDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoatDongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HoatDongBo bo = new HoatDongBo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tenHD = request.getParameter("txtTenHD");
			String moTaHD = request.getParameter("txtMoTaHD");
			String ngayGioBD = request.getParameter("txtNgayGioBD");
			String ngayGioKT = request.getParameter("txtNgayGioKT");
			String slToiThieuYC = request.getParameter("txtSLToiThieuYC");
			String slToiDaYC = request.getParameter("txtSLToiDaYC");
			String thoiHanDK = request.getParameter("txtThoiHanDK");
			String maTV = request.getParameter("txtMaTV");
			if (request.getParameter("btnThem")!=null) {
				bo.them(tenHD, moTaHD, ngayGioBD.replace('T', ' ')+":00", ngayGioKT.replace('T', ' ')+":00", Integer.parseInt(slToiThieuYC), Integer.parseInt(slToiDaYC), thoiHanDK.replace('T', ' ')+":00", Integer.parseInt(maTV));
			}
			if (request.getParameter("btnSua")!=null) {
			String maHD = request.getParameter("txtMaHD");
			String trangThai = request.getParameter("cbbTrangThai");
			String lyDoHuyHD = request.getParameter("txtLyDoHuyHD");
				bo.sua(Integer.parseInt(maHD), tenHD, moTaHD, ngayGioBD.replace('T', ' '), ngayGioKT.replace('T', ' '), Integer.parseInt(slToiThieuYC), Integer.parseInt(slToiDaYC), thoiHanDK.replace('T', ' '), trangThai, Integer.parseInt(maTV), lyDoHuyHD);
			}
			if (request.getParameter("maChon")!=null) {
				request.setAttribute("hd", bo.getHDByMa(Integer.parseInt(request.getParameter("maChon"))));
			}
			if (request.getParameter("maXoa")!=null) {
				bo.xoa(Integer.parseInt(request.getParameter("maXoa")),request.getParameter("tt"));
			}
			request.setAttribute("dsLoai", bo.getHD());
			RequestDispatcher rd = request.getRequestDispatcher("HoatDong.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
