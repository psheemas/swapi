package com.work.job.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiPlanetsWrapper {
    private int count;
    private String next;
    private String previous;
    private List<SwapiPlanetsDto> results;
}
