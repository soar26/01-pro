package com.zgf.dto;

public class StudentDto {

	private Integer id;
	private String name;
	private Integer age;
	
	public StudentDto() {
		super();
	}
	public StudentDto(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
/*	
	public static StudentDto toStudentVO(StudentPO po) {
		StudentDto vo = new StudentDto();
		vo.setId(String.valueOf(po.getId()));
		vo.setName(po.getName());
		vo.setAge(String.valueOf(po.getAge()));
		return vo;
	}*/
	
	@Override
	public String toString() {
		return "StudentPO [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
