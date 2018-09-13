package com.oitsme.admin.fad.pub.model.dev;

import java.io.Serializable;

/**
 * 描述:sys_menu表的实体类
 * @version:  1.0.0
 * @author:  Yonye
 * @创建时间: 2018-09-10
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private String menuId;

    /**
     * 
     */
    private String sysNo;

    /**
     * 
     */
    private String menuDetail;

    /**
     * 
     */
    private String menuLink;

    /**
     * 
     */
    private String menuParen;

    /**
     * 
     */
    private Integer menuLevel;

    /**
     * 
     */
    private String menuStatus;

    /**
     * 
     */
    private String createTime;

    /**
     * 
     */
    private String modifyTime;

    /**
     * 
     */
    private Integer menuType;

    /**
     * 
     * @return menu_id 
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 
     * @param menuId 
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    /**
     * 
     * @return sys_no 
     */
    public String getSysNo() {
        return sysNo;
    }

    /**
     * 
     * @param sysNo 
     */
    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    /**
     * 
     * @return menu_detail 
     */
    public String getMenuDetail() {
        return menuDetail;
    }

    /**
     * 
     * @param menuDetail 
     */
    public void setMenuDetail(String menuDetail) {
        this.menuDetail = menuDetail == null ? null : menuDetail.trim();
    }

    /**
     * 
     * @return menu_link 
     */
    public String getMenuLink() {
        return menuLink;
    }

    /**
     * 
     * @param menuLink 
     */
    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink == null ? null : menuLink.trim();
    }

    /**
     * 
     * @return menu_paren 
     */
    public String getMenuParen() {
        return menuParen;
    }

    /**
     * 
     * @param menuParen 
     */
    public void setMenuParen(String menuParen) {
        this.menuParen = menuParen == null ? null : menuParen.trim();
    }

    /**
     * 
     * @return menu_level 
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * 
     * @param menuLevel 
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 
     * @return menu_status 
     */
    public String getMenuStatus() {
        return menuStatus;
    }

    /**
     * 
     * @param menuStatus 
     */
    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 
     * @return modify_time 
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime == null ? null : modifyTime.trim();
    }

    /**
     * 
     * @return menu_type 
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 
     * @param menuType 
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", menuId=").append(menuId);
        sb.append(", sysNo=").append(sysNo);
        sb.append(", menuDetail=").append(menuDetail);
        sb.append(", menuLink=").append(menuLink);
        sb.append(", menuParen=").append(menuParen);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", menuStatus=").append(menuStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", menuType=").append(menuType);
        sb.append("]");
        return sb.toString();
    }
}