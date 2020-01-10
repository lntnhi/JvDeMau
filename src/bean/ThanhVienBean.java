package bean;

public class ThanhVienBean {
	private int maTV;
	private String hoTen;
	private float DTB;
	public ThanhVienBean(int maTV, String hoTen, float dTB) {
		super();
		this.maTV = maTV;
		this.hoTen = hoTen;
		DTB = dTB;
	}
	public int getMaTV() {
		return maTV;
	}
	public void setMaTV(int maTV) {
		this.maTV = maTV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDTB() {
		return DTB;
	}
	public void setDTB(float dTB) {
		DTB = dTB;
	}
	
}
