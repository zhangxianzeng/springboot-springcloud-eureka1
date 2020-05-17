package com.example.demoxiaofeizhe.dao;

import com.example.demoxiaofeizhe.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CartDao {
    List<Cart> findcart();
}
