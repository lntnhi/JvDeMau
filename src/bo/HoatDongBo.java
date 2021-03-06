package bo;

import java.util.ArrayList;

import bean.HoatDongBean;
import dao.HoatDongDao;

public class HoatDongBo {
	HoatDongDao dao = new HoatDongDao();
	
	public ArrayList<HoatDongBean> getHD() throws Exception {
		return dao.getHD();
	}
	
	public HoatDongBean getHDByMa(int maHD) throws Exception {	
		return dao.getHDByMa(maHD);
	}
	
	public int them (String tenHD, String moTaHD, String ngayGioBD, String ngayGioKT, int slToiThieuYC, int slToiDaYC, String thoiHanDK, int maTV) throws Exception {
		return dao.them(tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, maTV);
	}
	
	public int sua (int maHD, String tenHD, String moTaHD, String ngayGioBD, String ngayGioKT, int slToiThieuYC, int slToiDaYC, String thoiHanDK, String trangThai, int maTV, String lyDoHuyHD) throws Exception {
		return dao.sua(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV, lyDoHuyHD);
	}
	
	public int xoa (int maHD, String trangThai) throws Exception {
		return dao.xoa(maHD, trangThai);
	}
}
