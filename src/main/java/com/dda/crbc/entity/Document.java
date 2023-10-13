package com.dda.crbc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}