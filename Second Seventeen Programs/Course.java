package io.github.xieyezi;

import java.util.ArrayList;

public class Course {
     private String courseName;
     private ArrayList<String> students = new ArrayList<>();
     private int numberOfStudents = 0;
     public Course(String courseName){
    	 this.courseName = courseName;
     }
     
     public String getCourseName() {
		return courseName;
	}
    
	public ArrayList<String> getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void addStudent(String student){
    	students.add(student);
    	 numberOfStudents++;
     }
	public boolean dropStudent(String student) {
		return students.remove(student);
	}
	public static void main(String[] args) {
		Course course1 = new Course("Ӣ��");
		Course course2 = new Course("����");
		course1.addStudent("��ҵ��");
		course1.addStudent("��ʥǿ");
		course2.addStudent("������");
		course2.addStudent("��Сƽ");
		System.out.println(course1.getCourseName()+"��ѧ��������:"+course1.getNumberOfStudents());
		System.out.println(course1.getCourseName()+"����:"+course1.getStudents());
		System.out.println();
		System.out.println(course2.getCourseName()+"��ѧ��������"+course2.getNumberOfStudents());
		System.out.println(course2.getCourseName()+"����:"+course2.getStudents());
		course2.dropStudent("��Сƽ");
		System.out.println();
		System.out.println("��"+course2.getCourseName()+"�е� ��Сƽ ɾ��֮��");
		System.out.println(course2.getCourseName()+"����:"+course2.getStudents());
	}
}
