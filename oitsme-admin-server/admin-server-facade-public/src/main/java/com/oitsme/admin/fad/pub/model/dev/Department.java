package com.oitsme.admin.fad.pub.model.dev;

import java.io.Serializable;

/**
 * 描述:department表的实体类
 * @version:  1.0.0
 * @author:  Yonye
 * @创建时间: 2018-09-10
 */
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String departmentCode;

    /**
     * 
     */
    private String departmentName;

    /**
     * 
     * @return department_code 
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * 
     * @param departmentCode 
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    /**
     * 
     * @return department_name 
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 
     * @param departmentName 
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", departmentCode=").append(departmentCode);
        sb.append(", departmentName=").append(departmentName);
        sb.append("]");
        return sb.toString();
    }
}