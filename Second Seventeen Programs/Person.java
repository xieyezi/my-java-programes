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
		return "���Person" + "\n" + "������ " + name + "\n" + "��ַ��" + address + "\n" + "�绰���룺" + phoneNumber + "\n"
				+ "�ʼ���ַ��" + emailAddress;
	}
	public static void main(String[] args) {
		Student stu = new Student("������","�żҿ�","15310490690","610915518@qq.com",Student.ONE);
		java.util.Date date = new java.util.Date();
		Faculty faculty = new Faculty("��Сƽ","����","18875214426","3184916908@qq.com","�Ķ�801",1800,date,"8:00-18:00","��ʦ");
		Staff staff = new Staff("���ٻ�","����","15310494536","1435398529@qq.com","�Ķ�801",2000,date,"��һѧ��");
		System.out.println(stu.toString());
		System.out.println();
		System.out.println(faculty.toString());
		System.out.println();
		System.out.println(staff.toString());
	}
}

class Student extends Person {
	final static String ONE = "��һ";
	final static String TWO = "���";
	final static String THREE = "����";
	final static String FOUR = "����";
	private String grade;

	public Student(String name, String address, String phoneNumber, String emailAddress, String grade) {
		super(name, address, phoneNumber, emailAddress);
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "������ " + name + "\n"+"���Student" + "\n" + "�꼶��" + grade + "\n" + "��ַ��" + address
				+ "\n" + "�绰���룺" + phoneNumber + "\n" + "�ʼ���ַ��" + emailAddress;
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
		return "���Employee" + "\n" + "������ " + name + "\n" + "��Ƹ���ڣ�" + dateEmployee + "\n" + "�칫�ң�" + office + "\n"
				+ "н�ʣ�" + salary + "\n" + "��ַ��" + address + "\n" + "�绰���룺" + phoneNumber + "\n" + "�ʼ���ַ��"
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
		return "������ " + name + "\n" + "���Faculty" + "\n" + "��Ƹ���ڣ�" + dateEmployee + "\n" + "�칫�ң�" + office + "\n"
				+ "����ʱ�䣺" + worktime + "\n" + "����" + level + "\n" + "н�ʣ�" + salary + "\n" + "��ַ��" + address + "\n"
				+ "�绰���룺" + phoneNumber + "\n" + "�ʼ���ַ��" + emailAddress;
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
		return "������ " + name + "\n" + "���Staff" + "\n" + "��Ƹ���ڣ�" + dateEmployee + "\n" + "�칫�ң�" + office + "\n"
				+ "�ȼ�:" + position + "\n" + "н�ʣ�" + salary + "\n" + "��ַ��" + address + "\n" + "�绰���룺" + phoneNumber
				+ "\n" + "�ʼ���ַ��" + emailAddress;
	}
}