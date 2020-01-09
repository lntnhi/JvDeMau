package controller;

import java.io.IOException;

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
//			String maLoai = request.getParameter("txtMaLoai");
//			String tenLoai = request.getParameter("txtTenLoai");
//			if (request.getParameter("btnThem")!=null) {
//				int n = bo.them(maLoai, tenLoai);
//				if (n==0) request.setAttribute("kqThem", 0);
//			}
//			if (request.getParameter("btnSua")!=null) {
//				bo.sua(maLoai, tenLoai);
//			}
//			if (request.getParameter("maLoaiChon")!=null) {
//				request.setAttribute("loaiChon", bo.getLoaiByMa(request.getParameter("maLoaiChon")));
//			}
//			if (request.getParameter("maLoaiXoa")!=null) {
//				int n = bo.xoa(request.getParameter("maLoaiXoa"));
//				if (n==0) request.setAttribute("kqXoa", 0);
//			}
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
