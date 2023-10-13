package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367977L;

    private List<Document> documents;

    @Data
    @Builder
    @ToString
    public static class Document implements Serializable {
        private static final long serialVersionUID = -723782142242312163L;
        private Long documentId;
        private CRBCheckRequestResponse.CRBCheckRequest crbCheckRequest;
        private String documentType;
        private String documentUrl;
    }
}
