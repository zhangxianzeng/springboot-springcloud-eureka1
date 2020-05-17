package com.example.demoxiaofeizhe.controller;

import com.example.demoxiaofeizhe.pojo.Cart;
import com.example.demoxiaofeizhe.pojo.User;
import com.example.demoxiaofeizhe.sercvice.CartService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/find")
    public List<Cart> find(){
        return cartService.findcart();
    }

    @RequestMapping("/xiaofei")
    public Object findxiaofei(){

        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        URI uri= instance.getUri();
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/b/";
        System.out.println(baseUrl+"张现增");
//用Object进行接收可以避免无法接收json数据到问题

        return  this.restTemplate.getForObject(baseUrl, Object.class);
    }

//当需要的变量少时可以写到路径上
//    @RequestMapping("/xiaofei1")
//    public Object findxiaofei1(String username){
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        // 因为只有一个UserService,因此我们直接get(0)获取
//        ServiceInstance instance = instances.get(0);
//        URI uri= instance.getUri();
//        // 获取ip和端口信息
//        //get方法是可以这样拼接
//       // String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/findbyname?username={username}";
//        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/findbyname/{username}";
//        System.out.println(baseUrl+"张现增");
////用Object进行接收可以避免无法接收json数据到问题
////get方法时这样拼接
//    //    return  this.restTemplate.getForObject(baseUrl, Object.class,username);
//        Object object = restTemplate.postForObject(baseUrl, null, Object.class,username);
//        return  object;
//
//    }

    //数据可以写在路径上的可以使用一下方法
    @RequestMapping("/save1")
    public Object save1(User user){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // URI uri= instance.getUri();
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/save/{username}/{password}";


        //新增数据
        return  restTemplate.postForObject(baseUrl, null, Object.class,user.getUsername(),user.getPassword());
    }




    //post请求时根据变量进行增删改查不用在路径上进行操作，但是需要使用object来接收传过来的值，只有list的时候需要不是list可以用pojo类接收
@RequestMapping("/xiaofei1")
public  Object findxiaofei1(String username){

    List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
    // 因为只有一个UserService,因此我们直接get(0)获取
    ServiceInstance instance = instances.get(0);
    // URI uri= instance.getUri();
    // 获取ip和端口信息
    String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/findbyname";

    MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
    params.add("username", username);

    ResponseEntity<Object> userResponseEntity = restTemplate.postForEntity(baseUrl, params, Object.class);
    return userResponseEntity.getBody();
}



//调用接口进行新增操作
    @RequestMapping("/save2")
    public Object save2(User user){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // URI uri= instance.getUri();
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/save2/";

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("username", user.getUsername());
        params.add("password", user.getPassword());

        ResponseEntity<Object> userResponseEntity = restTemplate.postForEntity(baseUrl, params, Object.class);
        //新增数据
        return userResponseEntity.getBody() ;
    }

    //调用接口后删除
    @RequestMapping("/delete1")
    public Object save2(String username){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // URI uri= instance.getUri();
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/delete/";

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("username", username);

        ResponseEntity<Object> userResponseEntity = restTemplate.postForEntity(baseUrl, params, Object.class);

        return userResponseEntity.getBody() ;
    }
    //调用接口后修改数据
    @RequestMapping("/update")
    public Object update(User user){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        // URI uri= instance.getUri();
        // 获取ip和端口信息
        String baseUrl = "http://"+instance.getHost() + ":" + instance.getPort()+"/a/updata/";

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("username", user.getUsername());
        params.add("password", user.getPassword());
        ResponseEntity<Object> userResponseEntity = restTemplate.postForEntity(baseUrl, params, Object.class);

        return userResponseEntity.getBody() ;
    }
}
