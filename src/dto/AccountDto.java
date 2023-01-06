package dto;

public class AccountDto {

	// 항목들
	private String date;		// 날짜			- 22/12/30		22/12/27
	private String use;			// 용도			- 영화관람			월급
	private String classify;	// 수입 or 지출	- 지출			수입
	private int money;			// 금액			- 25000			30000000
	private String memo;		// 내용			- 아바타2			12월 급여
	
	public AccountDto() {
	}

	public AccountDto(String date, String use, String classify, int money, String memo) {
		super();
		this.date = date;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "AccountDto [date=" + date + ", use=" + use + ", classify=" + classify + ", money=" + money + ", memo="
				+ memo + "]";
	}
}
