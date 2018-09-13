package com.oitsme.admin.pub.dao.dev;

import com.oitsme.admin.fad.pub.model.dev.ManageUser;
import com.oitsme.admin.common.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManageUserMapper {
    long selectByConditionCount(@Param("condition") ManageUser condition);

    List<ManageUser> selectByCondition(@Param("condition") ManageUser condition);

    List<ManageUser> selectByConditionPage(@Param("condition") ManageUser condition, @Param("page") Page page);

    ManageUser selectByPrimaryKey(Integer id);

    ManageUser selectByUniqueIndexPRIMARY(Integer id);

    int deleteByPrimaryKey(Integer id);

    int deleteByUniqueIndexPRIMARY(Integer id);

    int insert(ManageUser record);

    int insertSelective(ManageUser record);

    int updateByPrimaryKeySelective(ManageUser record);

    int updateByPrimaryKey(ManageUser record);

    int updateByUniqueIndexSelectivePRIMARY(ManageUser record);

    int updateByUniqueIndexPRIMARY(ManageUser record);
}