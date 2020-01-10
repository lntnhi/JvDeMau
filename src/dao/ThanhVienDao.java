package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.ThanhVienBean;

public class ThanhVienDao {
	DungChung dc = new DungChung();
	public ArrayList<ThanhVienBean> getTV() throws Exception {
		ArrayList<ThanhVienBean> ds = new ArrayList<ThanhVienBean>();		
		dc.KetNoi();
		String sql = "SELECT TV.MaTV, TV.HoTen, DTB.DiemTB FROM DTB INNER JOIN THANHVIEN AS TV ON TV.MaTV = DTB.MaTV";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			int maTV = rs.getInt("MaTV");
			String hoTen = rs.getString("HoTen");
			float dTB = rs.getFloat("DiemTB");
			ThanhVienBean bean = new ThanhVienBean(maTV, hoTen, dTB);
			ds.add(bean);
		}
		rs.close();
		dc.cn.close();
		return ds;
	}	
}
