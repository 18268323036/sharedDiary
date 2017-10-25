package com.heartBar.sharedDiary.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author zhangxy 2017/10/24 10:14
 */
public class Module implements Serializable {
    private static final long serialVersionUID = -5248354001965657734L;

    private Integer mid;
    private String mname;
    private Set<Role> roles;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
