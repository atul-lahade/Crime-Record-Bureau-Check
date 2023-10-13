package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrbUserResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367957L;

    private List<CrbUser> crbUsers;

    @Data
    @Builder
    @ToString
    public static class CrbUser implements Serializable {
        private static final long serialVersionUID = -723792242687312163L;
        private Long userId;
        private String username;
        private String email;
        private String userType;
    }
}

