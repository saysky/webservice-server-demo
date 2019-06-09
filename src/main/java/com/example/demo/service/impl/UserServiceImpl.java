package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 言曌
 * @date 2019-06-09 17:39
 */

@WebService(serviceName = "UserService",//对外发布的服务名
        targetNamespace = "http://service.demo.example.com",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface = "com.example.demo.service.UserService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
public class UserServiceImpl implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();

    public UserServiceImpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId("111111");
        user.setUserName("zhangsan");
        user.setEmail("zhangsan@qq.com");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("222222");
        user.setUserName("lisi");
        user.setEmail("lisi@126.com");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId("333333");
        user.setUserName("wangwu");
        user.setEmail("wangwu@gmail.com");
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getUserName(String userId) {
        return "userName为：" + userMap.get(userId) != null ? userMap.get(userId).getUserName() : "【用户不存在！】";
    }

    @Override
    public User getUser(String userId) {
        System.out.println("userMap是:" + userMap);
        return userMap.get(userId);
    }

}
