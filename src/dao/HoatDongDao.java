package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.HoatDongBean;

public class HoatDongDao {
	DungChung dc = new DungChung();
	public ArrayList<HoatDongBean> getHD() throws Exception {
		ArrayList<HoatDongBean> ds = new ArrayList<HoatDongBean>();		
		dc.KetNoi();
		String sql = "SELECT * FROM HOATDONG";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maHD = rs.getInt("MaHD");
			String tenHD = rs.getString("TenHD");
			String moTaHD = rs.getString("MoTaHD");
			String ngayGioBD = rs.getString("NgayGioBD");
			String ngayGioKT = rs.getString("NgayGioKT");
			int slToiThieuYC = rs.getInt("SLToiThieuYC");
			int slToiDaYC = rs.getInt("SLToiDaYC");
			String thoiHanDK = rs.getString("ThoiHanDK");
			String trangThai = rs.getString("TrangThai");
			int maTV = rs.getInt("MaTV");
			String lyDoHuyHD = rs.getString("LyDoHuyHD");
			HoatDongBean bean = new HoatDongBean(maHD, tenHD, moTaHD, ngayGioBD, ngayGioKT, slToiThieuYC, slToiDaYC, thoiHanDK, trangThai, maTV, lyDoHuyHD);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
	
	public int them (String tenHD, String moTaHD, String ngayGioBD, String ngayGioKT, int slToiThieuYC, int slToiDaYC, String thoiHanDK, String trangThai, int maTV, String lyDoHuyHD) throws Exception {
		dc.KetNoi();
		String sql = "INSERT INTO HOATDONG(TenHD, MoTaHD, NgayGioBD, NgayGioKT, SLToiThieuYC, SLToiDaYC, ThoiHanDK, TrangThai, MaTV, LyDoHuyHD) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenHD);
		cmd.setString(2, moTaHD);
		cmd.setString(3, ngayGioBD);
		cmd.setString(4, ngayGioKT);
		cmd.setInt(5, slToiThieuYC);
		cmd.setInt(6, slToiDaYC);
		cmd.setString(7, thoiHanDK);
		cmd.setString(8, trangThai);
		cmd.setInt(9, maTV);
		cmd.setString(10, lyDoHuyHD);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public int sua (int maHD, String tenHD, String moTaHD, String ngayGioBD, String ngayGioKT, int slToiThieuYC, int slToiDaYC, String thoiHanDK, String trangThai, int maTV, String lyDoHuyHD) throws Exception {
		dc.KetNoi();
		String sql = "UPDATE HOATDONG SET TenHD=?, MoTaHD=?, NgayGioBD=?, NgayGioKT=?, SLToiThieuYC=?, SLToiDaYC=?, ThoiHanDK=?, TrangThai=?, MaTV=?, LyDoHuyHD=? where MaHD=?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, tenHD);
		cmd.setString(2, moTaHD);
		cmd.setString(3, ngayGioBD);
		cmd.setString(4, ngayGioKT);
		cmd.setInt(5, slToiThieuYC);
		cmd.setInt(6, slToiDaYC);
		cmd.setString(7, thoiHanDK);
		cmd.setString(8, trangThai);
		cmd.setInt(9, maTV);
		cmd.setString(10, lyDoHuyHD);
		cmd.setInt(11, maHD);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
	
	public int xoa (int maHD) throws Exception {
		dc.KetNoi();
		String sql = "DELETE FROM HOATDONG WHERE MaHD = ?";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setInt(1, maHD);
		int kq = cmd.executeUpdate();
		dc.cn.close();
		return kq;
	}
}
