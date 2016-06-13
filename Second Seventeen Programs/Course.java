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
		Course course1 = new Course("英语");
		Course course2 = new Course("高数");
		course1.addStudent("苏业纯");
		course1.addStudent("吴圣强");
		course2.addStudent("张晓君");
		course2.addStudent("马小平");
		System.out.println(course1.getCourseName()+"的学生人数有:"+course1.getNumberOfStudents());
		System.out.println(course1.getCourseName()+"中有:"+course1.getStudents());
		System.out.println();
		System.out.println(course2.getCourseName()+"的学生人数有"+course2.getNumberOfStudents());
		System.out.println(course2.getCourseName()+"中有:"+course2.getStudents());
		course2.dropStudent("马小平");
		System.out.println();
		System.out.println("将"+course2.getCourseName()+"中的 马小平 删除之后");
		System.out.println(course2.getCourseName()+"中有:"+course2.getStudents());
	}
}
