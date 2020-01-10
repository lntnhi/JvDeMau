package bo;

import java.util.ArrayList;

import bean.ThanhVienBean;
import dao.ThanhVienDao;

public class ThanhVienBo {
	ThanhVienDao dao = new ThanhVienDao();
	public ArrayList<ThanhVienBean> getTV() throws Exception {
		return dao.getTV();
	}
}
