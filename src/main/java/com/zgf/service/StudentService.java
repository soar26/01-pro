package com.zgf.service;

import java.util.List;
import java.util.Map;

import com.zgf.dto.StudentDto;
import com.zgf.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService{

	@Autowired
	private StudentMapper mapper;
	
	public List<StudentDto> student(Map<String,Object> paramsFrom){
		return mapper.selectAllStudent(paramsFrom);
	}

	public Integer count(Map<String, Object> params) {
		return mapper.countAllStudent(params);
	}

	public Integer addStudent(StudentDto studentDto) {
		return mapper.addStudent(studentDto);
	}

	public Integer editStudent(StudentDto studentDto) {
		return mapper.editStudent(studentDto);
	}

	public Integer removeStudent(Integer id) {
		return mapper.removeStudent(id);
	}

	public Integer removeStudents(int[] ids) {
		Integer nowLen = 0;
		for (int i = 0; i < ids.length; i++){
			nowLen += mapper.removeStudent(ids[i]);
		}
		return nowLen;
	}

	public StudentDto detailStudent(Integer id) {
		return mapper.detailStudent(id);
	}

}
