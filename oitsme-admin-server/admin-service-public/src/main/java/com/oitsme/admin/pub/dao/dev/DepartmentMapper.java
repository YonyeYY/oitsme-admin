package com.oitsme.admin.pub.dao.dev;

import com.oitsme.admin.fad.pub.model.dev.Department;
import com.oitsme.admin.common.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    long selectByConditionCount(@Param("condition") Department condition);

    List<Department> selectByCondition(@Param("condition") Department condition);

    List<Department> selectByConditionPage(@Param("condition") Department condition, @Param("page") Page page);

    Department selectByPrimaryKey(String departmentCode);

    Department selectByUniqueIndexPRIMARY(String departmentCode);

    int deleteByPrimaryKey(String departmentCode);

    int deleteByUniqueIndexPRIMARY(String departmentCode);

    int insert(Department record);

    int insertSelective(Department record);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    int updateByUniqueIndexSelectivePRIMARY(Department record);

    int updateByUniqueIndexPRIMARY(Department record);
}