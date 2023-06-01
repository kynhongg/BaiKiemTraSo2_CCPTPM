package main;
import java.util.*;
import java.io.*;
public class RunMain {

	static ArrayList<Xe> listXe = new ArrayList<Xe>();
	
	public static void main(String[] args) throws Exception{
		
		
		do {
			System.out.println("======> MENU <========"
					+ "\n1.Nhap vao xe"
					+"\n2.In danh sach xe"
					+"\n3.Xoa xe theo stt"
					+"\n4.Tim kiem xe trong tai max" 
					+"\n5.Sap xep xe tang dan theo nam san xuat"
					+"\n6.Thoat");
			System.out.println("Lua chon cua ban : ");
			int choose = new Scanner(System.in).nextInt();
			switch(choose) {
			case 1:
				nhapXe();//ghi du lieu xe vao file 
				break;
				
			case 2:
				inDanhSachXe();
				break;
				
			case 3:
				xoaXe();
				break;
				
			case 4:
				timKiemXe();
				break;
				
			case 5:
				sapXepXe();//sap xep xe theo collection 
				break;
				
			case 6:
				System.exit(0);
				
			default:	
				System.out.println("Lua chon cua ban khong dung");
				break;
			}
			
		}while(true);	
	}
	
	static void nhapXe() throws Exception {
		Xe xe = new Xe();
		System.out.println("Nhap thong tin cho xe ");
		xe.input();
		listXe.add(xe);
		
		//Ghi vao file 
		FileWriter fileWritter = null;
		BufferedWriter bufferedWritter = null;
		PrintWriter printWritter = null;
		
		try {
			File file = new File("input.dat");
			if(!file.exists()) {
				file.createNewFile();
			}
			fileWritter = new FileWriter(file , true);
			bufferedWritter = new BufferedWriter(fileWritter);
			printWritter = new PrintWriter(bufferedWritter);
			
			printWritter.println(xe.toString());
		}catch(Exception exception) {
			exception.getMessage();
		}finally {
			printWritter.close();
			bufferedWritter.close();
			fileWritter.close();
		}
	}
	
	static void inDanhSachXe() {
		inTieuDe();
		for(Xe xe : listXe) {
			System.out.println(xe.toString());
		}
	}
	static void xoaXe() {
		System.out.println("Nhap so thu tu xe muon xoa : ");
		int flag=0;
		int stt = new Scanner(System.in).nextInt();
		for(int i = 0 ; i < listXe.size() ; i++) {
			if(i == stt) {
				flag = 1; listXe.remove(i); break;
			}
		}
		if(flag == 0) {
			System.out.println("Stt xe muon xoa khong hop le");
		}else {
			System.out.println("\t\tDanh Sach Xe Sau Khi Xoa");
			inDanhSachXe();
		}
	}
   
	static void inTieuDe(){
		 System.out.printf("%-10s %-10s %-10s %-25s %-10s %-10s %-10s%n",
		 " ten xe", "ten kh"," nhien lieu"," Doanh nghiep",
		 " tai trong","tien DC"," Nam sx");
		 }
	
	static void timKiemXe() {
		int trongTaiMax = listXe.get(0).getTrongTai();
		for(Xe xe : listXe) {
			if(xe.getTrongTai() < trongTaiMax) {
				trongTaiMax = xe.getTrongTai();
			}
		}
		//In danh sach xe co trong tai max 
		inTieuDe();
		for(Xe item : listXe) {
			if(item.getTrongTai() == trongTaiMax) {
				System.out.println(item.toString());
			}
		}
	}
	
	static void sapXepXe() {
		Collections.sort(listXe);
		//In ra danh sach sau khi sort
		inDanhSachXe();
	}
	
}
