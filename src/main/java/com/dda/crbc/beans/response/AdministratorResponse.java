package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367917L;

    private List<Administrator> administrators;

    @Data
    @Builder
    @ToString
    public static class Administrator implements Serializable {
        private static final long serialVersionUID = -723792142642112163L;
        private Long administratorId;
        private CrbUserResponse.CrbUser user;
        private String fullName;
        private String contactNumber;
    }
}
