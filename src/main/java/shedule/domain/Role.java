package shedule.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, OTHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
