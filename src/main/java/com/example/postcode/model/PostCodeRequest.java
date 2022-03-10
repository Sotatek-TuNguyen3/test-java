package com.example.postcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCodeRequest {

    @JsonProperty("list_post_code")
    private List<PostCodeDto> listPostCodes;

}
