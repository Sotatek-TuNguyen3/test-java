package com.example.postcode.service;

import com.example.postcode.model.PostCodeDto;
import com.example.postcode.model.PostCodeRequest;
import com.example.postcode.model.ResponseModel;

import java.util.List;

public interface PostCodeService {

    ResponseModel<List<PostCodeDto>> getAllPostCode();

    ResponseModel<List<PostCodeDto>> getByPostCode(List<Integer> postcodes);

    ResponseModel<?> createNewPostCode(PostCodeRequest requestModel);
}
