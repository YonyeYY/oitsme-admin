package com.oitsme.admin.pub.dao.dev;

import com.oitsme.admin.fad.pub.model.dev.Employee;
import com.oitsme.admin.common.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long selectByConditionCount(@Param("condition") Employee condition);

    List<Employee> selectByCondition(@Param("condition") Employee condition);

    List<Employee> selectByConditionPage(@Param("condition") Employee condition, @Param("page") Page page);

    Employee selectByPrimaryKey(String employeeCode);

    Employee selectByUniqueIndexPRIMARY(String employeeCode);

    int deleteByPrimaryKey(String employeeCode);

    int deleteByUniqueIndexPRIMARY(String employeeCode);

    int insert(Employee record);

    int insertSelective(Employee record);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int updateByUniqueIndexSelectivePRIMARY(Employee record);

    int updateByUniqueIndexPRIMARY(Employee record);
}