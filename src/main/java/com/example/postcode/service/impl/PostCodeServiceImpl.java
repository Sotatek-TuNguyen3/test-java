package com.example.postcode.service.impl;

import com.example.postcode.model.PostCodeDto;
import com.example.postcode.model.PostCodeEntity;
import com.example.postcode.model.PostCodeRequest;
import com.example.postcode.model.ResponseModel;
import com.example.postcode.repository.PostCodeRepository;
import com.example.postcode.service.PostCodeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostCodeServiceImpl implements PostCodeService {

    private static final String SUCCESS_STATUS = "SUCCESS";

    @Autowired
    PostCodeRepository postCodeRepository;

    @Override
    public ResponseModel<List<PostCodeDto>> getAllPostCode() {
        try {
            ResponseModel<List<PostCodeDto>> responseModel = new ResponseModel<>();
            List<PostCodeDto> listPostCodeDto = new ArrayList<>();

            List<PostCodeEntity> listEntity = postCodeRepository.findAll();

            if (!listEntity.isEmpty()) {
                listEntity.forEach(x -> {
                    PostCodeDto temp = new PostCodeDto();
                    temp.setId(x.getId());
                    temp.setPostCode(x.getPostCode());
                    temp.setSuburbName(x.getSuburbName());
                    listPostCodeDto.add(temp);
                });
            }

            responseModel.setResponse(listPostCodeDto);
            responseModel.setStatus(SUCCESS_STATUS);

            return responseModel;
        } catch (Exception exception) {
            throw new ServiceException("ERROR: " + exception);
        }
    }

    @Override
    public ResponseModel<List<PostCodeDto>> getByPostCode(List<Integer> postcodes) {
        try {
            ResponseModel<List<PostCodeDto>> responseModel = new ResponseModel<>();
            List<PostCodeDto> listPostCodeDto = new ArrayList<>();

            List<PostCodeEntity> listEntity = postCodeRepository.findByPostCodeInOrderBySuburbName(postcodes);

            if (!listEntity.isEmpty()) {
                listEntity.forEach(x -> {
                    PostCodeDto temp = new PostCodeDto();
                    temp.setId(x.getId());
                    temp.setPostCode(x.getPostCode());
                    temp.setSuburbName(x.getSuburbName());
                    listPostCodeDto.add(temp);
                });
            }

            responseModel.setResponse(listPostCodeDto);
            responseModel.setStatus(SUCCESS_STATUS);

            return responseModel;
        } catch (Exception exception) {
            throw new ServiceException("ERROR: " + exception);
        }
    }

    @Override
    public ResponseModel<?> createNewPostCode(PostCodeRequest requestModel) {
        try {
            ResponseModel<?> responseModel = new ResponseModel<>();

            List<PostCodeDto> listRequest = requestModel.getListPostCodes();
            List<PostCodeEntity> listSave = new ArrayList<>();

            if (!listRequest.isEmpty()) {
                listRequest.forEach(x -> {
                    PostCodeEntity entity = new PostCodeEntity();
                    entity.setPostCode(x.getPostCode());
                    entity.setSuburbName(x.getSuburbName());
                    listSave.add(entity);
                });
            }

            postCodeRepository.saveAll(listSave);
            responseModel.setStatus(SUCCESS_STATUS);

            return responseModel;
        } catch (Exception exception) {
            throw new ServiceException("ERROR: " + exception);
        }
    }
}
