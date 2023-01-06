package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import file.FileProc;

public class AccountDao {
	
	Scanner sc = new Scanner(System.in);
	private List<AccountDto> list = new ArrayList<AccountDto>();
	
	private int count;
	private FileProc fileProc = null;
	
	public AccountDao() {
	fileProc = new FileProc("accountbook");
	fileload();
	}
	
	//CRUD
	//TODO
	public void insert() {
		System.out.println("가계부에 입력을 시작합니다");
		
		System.out.print("날짜 =");
		String date = sc.next();
		System.out.print("용도 =");
		String use = sc.next();
		System.out.print("수입 / 지출 =");
		String classify = sc.next();
		System.out.print("금액 =");
		int money = sc.nextInt();
		System.out.print("내용 =");
		String memo = sc.next();
		
		AccountDto dto = new AccountDto(date, use, classify, money, memo);
		list.add(dto);
	}
	
	
	//TODO
	public void delete() {
		System.out.print("삭제할 내용 = ");
		String name = sc.next();
		
		int index = search(name);
		if (index==-1) {
			System.out.println("그러한 내용이 존재하지 않습니다");
		} else {
			list.remove(index);
			System.out.println("지정한 내용을 삭제했습니다");
		}
	}
	
	
	//TODO Select
	public void selectMonth() {
		// 연도, 월별 결산
		System.out.print("선택할 날짜 = ");
		String date = sc.next();
		for (AccountDto h : list) {
			if (date.equals(h.getDate())) {
				System.out.println(h.toString());
			}
		}
	}
	
	
	public void selectUse() {
		// 용도
		System.out.print("선택할 용도 = ");
		String use = sc.next();
		for (AccountDto h : list) {
			if (use.equals(h.getUse())) {
				System.out.println(h.toString());
			}
		}	
	}
	
	public void selectClassify() {
		// 분류(수입 or 지출)
		System.out.print("선택할 분류 = ");
		String classify = sc.next();
		for (AccountDto h : list) {
			if (classify.equals(h.getClassify())) {
				System.out.println(h.toString());
			}
		}	
	}
	
	public void selectMoney() {
		// 용도
		System.out.print("선택할 금액 = ");
		int money = sc.nextInt();
		for (AccountDto h : list) {
			if (money==h.getMoney()) {
				System.out.println(h.toString());
			}
		}	
	}
	
	public void selectMemo() {
		// 용도
		System.out.print("선택할 내용 = ");
		String memo = sc.next();
		for (AccountDto h : list) {
			if (memo.equals(h.getMemo())) {
				System.out.println(h.toString());
			}
		}	
	}
	
	//TODO update
	public void update() {
		System.out.print("수정할 내용 =");
		String memo = sc.next();
		int index = search(memo);
		if(index == -1) {
			System.out.println("수정할 내용을 찾을 수 없습니다.");
			return;
		}
		System.out.println("데이터를 찾았습니다.");
		
		
		System.out.print("날짜 = ");
		String date = sc.next();
		System.out.print("용도 = ");
		String use = sc.next();
		System.out.print("수입 / 지출 = ");
		String classify = sc.next();
		System.out.print("금액 = ");
		int money = sc.nextInt();
		System.out.print("내용 = ");
		String fmemo = sc.next();
		
		list.get(index).setClassify(classify);
		list.get(index).setMemo(memo);
		list.get(index).setDate(date);
		list.get(index).setMoney(money);
		list.get(index).setUse(use);
	}
	
	
	public int search(String use) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			AccountDto h = list.get(i);
			if(use.equals(h.getUse())) {
				index = i;
				break;
			}
		
		}
		return index;
	}
	
	//TODO 모두 출력
	public void allDataPrint() {
		for (AccountDto accountDto : list) {
			System.out.println(accountDto.toString());
		}
	}
	
	public void filesave() {
		String dataArr[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			dataArr[i]=list.get(i).toString();
		}
		fileProc.write(dataArr);
	}
	
	
	public void fileload() {
		String data[] = fileProc.read();
//		if (data==null) {
//			return;
//		}
		for (int i = 0; i < data.length; i++) {
			String split[] = data[i].split(",");
			AccountDto m = new AccountDto(split[0],
					split[1],
					split[2],
					Integer.parseInt(split[3]),
					split[4]);
			list.add(m);
		}
	}
}

