package examples.entity;

public class EmployeeModel {
	private String id = null;
	private String family_name = null;
	private String first_name = null;
	private String sex = null;
	private String birthday = null;
	private String sort = null;
	private String cend = null;
	private String msg = null;


	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		if(sort.equals("ID")) {
		this.sort = "sort_id";
		}else if(sort.equals("姓")) {
			this.sort = "family_name";
		}else if(sort.equals("名")) {
			this.sort = "first_name";
		}else if(sort.equals("性別")) {
			this.sort = "sex";
		}else if(sort.equals("生年月日")) {
			this.sort = "birthday";
		}

	}
	public String getCend() {
		return cend;
	}
	public void setCend(String cend) {
		this.cend = cend;
	}


	public EmployeeModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}