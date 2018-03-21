package com.zgf.repository;

import com.zgf.dto.StudentDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface StudentMapper{

	//@Param 解决多参数传值的问题
	@Select("<script>"
			+"select * from ("
				+" select * from t_student "
				+" <where> "
				+" <if test='name !=null and name!=\"\"'> "
				+" and name like CONCAT(CONCAT('%', #{name}),'%') "
				+" </if> "
				+" <if test='minAge !=null and minAge!=\"\"'> "
				+" and age <![CDATA[ >= ]]> #{minAge} "
				+" </if> "
				+" <if test='maxAge !=null and maxAge!=\"\"'> "
				+" and age <![CDATA[ <= ]]> #{maxAge} "
				+" </if> "
				+" </where> "
			+") temp"
			+" limit #{page},#{limit} "
			+" </script>")
	public List<StudentDto> selectAllStudent(Map<String, Object> params);

	@Select("<script>"
			+"select count(id) from ("
				+"select * from ("
					+" select * from t_student "
					+" <where> "
					+" <if test='name !=null and name!=\"\"'> "
					+" and name like CONCAT(CONCAT('%', #{name}),'%') "
					+" </if> "
					+" <if test='minAge !=null and minAge!=\"\"'> "
					+" and age <![CDATA[ >= ]]> #{minAge} "
					+" </if> "
					+" <if test='maxAge !=null and maxAge!=\"\"'> "
					+" and age <![CDATA[ <= ]]> #{maxAge} "
					+" </if> "
					+" </where> "
				+") temp"
			+") temp2"
			+" </script>")
	public Integer countAllStudent(Map<String, Object> params);

	//添加数据
	@Insert("insert into t_student values(null,#{name},#{age})")
	public Integer addStudent(StudentDto studentDto);

	//修改数据
	@Update("update t_student set name=#{name},age=#{age} where id=#{id}")
	public Integer editStudent(StudentDto studentDto);

	//删除数据
	@Delete("delete from t_student where id=#{id}")
	public Integer removeStudent(Integer id);

	//查看详情
	@Select("select * from t_student where id=#{id}")
	public StudentDto detailStudent(Integer id);
}
