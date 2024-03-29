package com.getarrays.project3.enumeration;

import com.getarrays.project3.constant.Authority;

public enum Role {
    ROLE_USER(Authority.USER_AUTHORITIES),
    ROLE_HR(Authority.HR_AUTHORITIES),
    ROLE_MANAGER(Authority.MANAGER_AUTHORITIES),
    ROLE_ADMIN(Authority.ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(Authority.SUPER_ADMIN_AUTHORITIES);

    private String[] authorities; //field to get all the values

    Role(String...authorities) { //indicates that the constructor can accept zero or more strings.
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
