package main;
import java.util.Scanner;

public class DoanhNghiep {
	private String TenDN;
	private String SoDT;
	private String DiaChi;
	
	DoanhNghiep(){
		this.TenDN = "";
		this.SoDT = "";
		this.DiaChi = "";
	}
	DoanhNghiep(String TenDN , String SoDT , String DiaChi){
		this.TenDN = TenDN;
		this.SoDT = SoDT;
		this.DiaChi = DiaChi;
	}
	
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten doanh nghiep");
		setTenDN(sc.nextLine());
		
		System.out.println("Nhap so dien thoai");
		setSoDT(sc.nextLine());
		
		System.out.println("Nhap dia chi");
		setDiaChi(sc.nextLine());
	}
	@Override
	public String toString() {
		 return "("+TenDN + "," + SoDT + "," + DiaChi+")";
	}
	
}
