package com.talexu.domain;

import java.util.LinkedList;
import java.util.List;

public class Student {

	private String name;
	private String snippet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public Student() {

	}

	public Student(String name, String snippet) {
		this.name = name;
		this.snippet = snippet;
	}

	public static Student getStudent() {
		return new Student("XU Yunlong", "S1");
	}

	public static List<Student> getStudents() {
		List<Student> students = new LinkedList<Student>();
		students.add(new Student("XU Yunlong", "S1"));
		students.add(new Student("LIU Xu", "S2"));
		
		return students;
	}
}
