package com.example.demoxiaofeizhe.sercvice;

import com.example.demoxiaofeizhe.dao.CartDao;
import com.example.demoxiaofeizhe.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;
    @Override
    public List<Cart> findcart() {
        return cartDao.findcart();
    }
}
