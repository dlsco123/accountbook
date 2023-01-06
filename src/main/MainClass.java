package main;

import java.util.Scanner;

import dao.AccountDao;

public class MainClass {

	public static void main(String[] args) {
		
		// menu
		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();
		boolean end = false;
		
		out:while (true) {
			System.out.println("<< 가 계 부 >>");
			System.out.println("1. 가계부 입력");
			System.out.println("2. 삭제하기");
			System.out.println("3. 선택하기");
			System.out.println("4. 수정하기");
			System.out.println("5. 모두 보기");
			System.out.println("6. 데이터저장");
			System.out.println("7. 종료");
			
			System.out.println(">>");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				dao.insert();
				break;
			case 2:
				dao.delete();
				break;
			case 3:
				dao.selectMonth();
				dao.selectClassify();
				dao.selectMemo();
				dao.selectMoney();
				dao.selectUse();
				break;
			case 4:
				dao.update();
				break;
			case 5:
				dao.allDataPrint();
				break;
			case 6:
				dao.filesave();
				break;
			case 7:
				end=true;
				break out;
			default:
			}
			System.out.println("종료되었습니다");}

	}

}
