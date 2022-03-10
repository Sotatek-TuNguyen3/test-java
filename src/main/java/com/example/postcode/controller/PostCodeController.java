package com.example.postcode.controller;

import com.example.postcode.model.PostCodeDto;
import com.example.postcode.model.PostCodeRequest;
import com.example.postcode.model.ResponseModel;
import com.example.postcode.service.PostCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/api")
public class PostCodeController {

    private static final String ERROR_STATUS = "ERROR";

    @Autowired
    PostCodeService postCodeService;

    @RequestMapping("/all")
    public ResponseModel<List<PostCodeDto>> getAllPostCode() {

        ResponseModel<List<PostCodeDto>> responseModel = new ResponseModel<>();

        try {
            responseModel = postCodeService.getAllPostCode();
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    @RequestMapping("/postcode")
    public ResponseModel<List<PostCodeDto>> getByPostCode(@RequestBody(required = false) List<String> postcodes) {

        ResponseModel<List<PostCodeDto>> responseModel = new ResponseModel<>();

        try {
            responseModel = postCodeService.getByPostCode(postcodes);
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    @RequestMapping("/create-new")
    public ResponseModel<?> createNewPostCode(@RequestBody PostCodeRequest requestModel) {

        ResponseModel<?> responseModel = new ResponseModel<>();
        try {
            responseModel = postCodeService.createNewPostCode(requestModel);
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }
}
