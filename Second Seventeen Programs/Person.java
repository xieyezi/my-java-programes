package io.github.xieyezi;

public class Person {
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String emailAddress;

	public Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "类别：Person" + "\n" + "姓名： " + name + "\n" + "地址：" + address + "\n" + "电话号码：" + phoneNumber + "\n"
				+ "邮件地址：" + emailAddress;
	}
	public static void main(String[] args) {
		Student stu = new Student("张晓君","张家口","15310490690","610915518@qq.com",Student.ONE);
		java.util.Date date = new java.util.Date();
		Faculty faculty = new Faculty("马小平","重庆","18875214426","3184916908@qq.com","四栋801",1800,date,"8:00-18:00","教师");
		Staff staff = new Staff("苏仲基","重庆","15310494536","1435398529@qq.com","四栋801",2000,date,"大一学生");
		System.out.println(stu.toString());
		System.out.println();
		System.out.println(faculty.toString());
		System.out.println();
		System.out.println(staff.toString());
	}
}

class Student extends Person {
	final static String ONE = "大一";
	final static String TWO = "大二";
	final static String THREE = "大三";
	final static String FOUR = "大四";
	private String grade;

	public Student(String name, String address, String phoneNumber, String emailAddress, String grade) {
		super(name, address, phoneNumber, emailAddress);
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "姓名： " + name + "\n"+"类别：Student" + "\n" + "年级：" + grade + "\n" + "地址：" + address
				+ "\n" + "电话号码：" + phoneNumber + "\n" + "邮件地址：" + emailAddress;
	}
}

class Employee extends Person {
	protected String office;
	protected double salary;
	protected java.util.Date dateEmployee;

	public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary,
			java.util.Date dateEmployee) {
		super(name, address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateEmployee = dateEmployee;
	}

	@Override
	public String toString() {
		return "类别：Employee" + "\n" + "姓名： " + name + "\n" + "受聘日期：" + dateEmployee + "\n" + "办公室：" + office + "\n"
				+ "薪资：" + salary + "\n" + "地址：" + address + "\n" + "电话号码：" + phoneNumber + "\n" + "邮件地址："
				+ emailAddress;
	}
}

class Faculty extends Employee {
	private String worktime;
	private String level;

	public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary,
			java.util.Date dateEmployee, String worktime, String level) {
		super(name, address, phoneNumber, emailAddress, office, salary, dateEmployee);
		this.worktime = worktime;
		this.level = level;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "姓名： " + name + "\n" + "类别：Faculty" + "\n" + "受聘日期：" + dateEmployee + "\n" + "办公室：" + office + "\n"
				+ "工作时间：" + worktime + "\n" + "级别：" + level + "\n" + "薪资：" + salary + "\n" + "地址：" + address + "\n"
				+ "电话号码：" + phoneNumber + "\n" + "邮件地址：" + emailAddress;
	}
}

class Staff extends Employee {
	private String position;

	public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary,
			java.util.Date dateEmployee, String position) {
		super(name, address, phoneNumber, emailAddress, office, salary, dateEmployee);
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "姓名： " + name + "\n" + "类别：Staff" + "\n" + "受聘日期：" + dateEmployee + "\n" + "办公室：" + office + "\n"
				+ "等级:" + position + "\n" + "薪资：" + salary + "\n" + "地址：" + address + "\n" + "电话号码：" + phoneNumber
				+ "\n" + "邮件地址：" + emailAddress;
	}
}