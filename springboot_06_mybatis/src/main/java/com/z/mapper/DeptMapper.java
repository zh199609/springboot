package com.z.mapper;

import com.z.entity.Deptment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//指定这是一个操作数据库的mapper
//@Mapper
public interface DeptMapper {

    @Select("select * from deptment where id = #{id}")
    public Deptment getDeptById(Integer id);

    @Select("select * from deptment")
    List<Deptment> getDepts();

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into deptment(id,deptment_name) values(#{id},#{deptmentName})")
    int insertDept(Deptment deptment);

    @Update("update deptment set deptment_name = #{deptmentName} where id = #{id}")
    int updateDept(Deptment deptment);
}
