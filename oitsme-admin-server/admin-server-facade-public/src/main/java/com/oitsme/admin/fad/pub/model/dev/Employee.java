package com.oitsme.admin.fad.pub.model.dev;

import java.io.Serializable;

/**
 * 描述:employee表的实体类
 * @version:  1.0.0
 * @author:  Yonye
 * @创建时间: 2018-09-10
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String employeeCode;

    /**
     * 
     */
    private String employeeName;

    /**
     * 
     */
    private String departmentCode;

    /**
     * 
     */
    private String userName;

    /**
     * 
     * @return employee_code 
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * 
     * @param employeeCode 
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    /**
     * 
     * @return employee_name 
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 
     * @param employeeName 
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

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
     * @return user_name 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", employeeCode=").append(employeeCode);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", departmentCode=").append(departmentCode);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}