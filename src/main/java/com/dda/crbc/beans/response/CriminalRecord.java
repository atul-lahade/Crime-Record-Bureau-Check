package com.dda.crbc.beans.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriminalRecord implements Serializable {

    private static final long serialVersionUID = 3410901327251362917L;

    private String crimeDescription;

    private Date convictionDate;

    private String severityLevel;

    private String judicialAuthority;
}
