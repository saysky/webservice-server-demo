package com.example.demo.service;

import com.example.demo.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author 言曌
 * @date 2019-06-09 17:39
 */

@WebService(targetNamespace = "http://service.demo.example.com")
public interface UserService {

    @WebMethod
    //标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String getUserName(@WebParam(name = "userId") String userId);

}
