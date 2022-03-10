package com.example.postcode.repository;

import com.example.postcode.model.PostCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCodeRepository extends JpaRepository<PostCodeEntity, Long> {

    List<PostCodeEntity> findByPostCodeInOrderBySuburbName(List<Integer> postcodes);
}
