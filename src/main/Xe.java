package main;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Xe implements MayMoc , Comparable<Xe> {
	
	private String tenXe;
	private int trongTai;
	private int tienDatCoc;
	private String tenKhachHang;
	private DoanhNghiep doanhNghiep;
	private String NL;
	private int NamSX;
	
	Xe(){
		this.tenXe = "";
		this.trongTai = 0;
		this.tienDatCoc = 0;
		this.tenKhachHang = "";
		this.doanhNghiep = new DoanhNghiep();
	}

	public Xe(String tenXe, int trongTai, int tienDatCoc, String tenKhachHang) {
		this.tenXe = tenXe;
		this.trongTai = trongTai;
		this.tienDatCoc = tienDatCoc;
		this.tenKhachHang = tenKhachHang;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public int getTrongTai() {
		return trongTai;
	}

	public void setTrongTai(int trongTai) {
		this.trongTai = trongTai;
	}

	public int getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(int tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public DoanhNghiep getDoanhNghiep() {
		return doanhNghiep;
	}

	public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
		this.doanhNghiep = doanhNghiep;
	}
	
	public String getNL() {
		return NL;
	}
	
	public int getNamSx() {
		return NamSX;
	}
	
	void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ten xe");
		setTenXe(sc.nextLine());
		

		try {
			System.out.println("Nhap trong tai");
			setTrongTai(sc.nextInt());
		}catch(InputMismatchException  e) {
			System.out.println("Khong dung dinh dang trong tai xe");
			sc.nextLine();
		}
		
		try {
		System.out.println("Nhap tien dat coc");
		setTienDatCoc(sc.nextInt());
		}catch(InputMismatchException  e) {
			System.out.println("Khong dung dinh dang tien");
		}

		sc.nextLine();
		System.out.println("Nhap ten khach hang");
		setTenKhachHang(sc.nextLine());
		
		doanhNghiep.nhap();
		
		System.out.println("Nhap nhien lieu");
		setNhienLieu(sc.nextLine());
		
		try {
		System.out.println("Nhap nam san xuat");
		setNamSX(sc.nextInt());
		}catch(InputMismatchException  e) {
			System.out.println("Khong dung dinh dang nam san xuat");
			sc.nextLine();
		}
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-25s %-10d %-10d %-10d", 
				tenXe ,tenKhachHang,NL,doanhNghiep, trongTai , tienDatCoc, NamSX);
	}

	public void setNhienLieu(String NL) {
		this.NL = NL;
	}

	public void setNamSX(int NamSX) {
		this.NamSX = NamSX;
	}

	@Override
	public int compareTo(Xe o) {
		return this.NamSX - o.getNamSx();
	}
}
