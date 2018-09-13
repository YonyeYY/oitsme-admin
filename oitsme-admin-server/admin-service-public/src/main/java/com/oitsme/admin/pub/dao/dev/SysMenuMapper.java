package com.oitsme.admin.pub.dao.dev;

import com.oitsme.admin.fad.pub.model.dev.SysMenu;
import com.oitsme.admin.common.model.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    long selectByConditionCount(@Param("condition") SysMenu condition);

    List<SysMenu> selectByCondition(@Param("condition") SysMenu condition);

    List<SysMenu> selectByConditionPage(@Param("condition") SysMenu condition, @Param("page") Page page);

    SysMenu selectByPrimaryKey(String menuId);

    SysMenu selectByUniqueIndexPRIMARY(String menuId);

    int deleteByPrimaryKey(String menuId);

    int deleteByUniqueIndexPRIMARY(String menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    int updateByUniqueIndexSelectivePRIMARY(SysMenu record);

    int updateByUniqueIndexPRIMARY(SysMenu record);
}