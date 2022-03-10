package com.example.postcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCodeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("post_code")
    private Integer postCode;

    @JsonProperty("suburb_name")
    private String suburbName;
}
