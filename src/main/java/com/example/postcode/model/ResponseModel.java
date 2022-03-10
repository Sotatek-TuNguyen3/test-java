package com.example.postcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T response;
    private String status;
    private String message;
}
