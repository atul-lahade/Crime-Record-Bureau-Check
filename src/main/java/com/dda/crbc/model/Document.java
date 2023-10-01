package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private CRBCheckRequest crbCheckRequest;

    @Column(name = "document_type", length = 50)
    private String documentType;

    @Column(name = "document_url")
    private String documentUrl;

    public Document() {
    }

    public Document(CRBCheckRequest crbCheckRequest, String documentType, String documentUrl) {
        this.crbCheckRequest = crbCheckRequest;
        this.documentType = documentType;
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", crbCheckRequest=" + crbCheckRequest +
                ", documentType='" + documentType + '\'' +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}