package com.hcfa.material.inte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * WebService接口
 * @作者 Administrator
 * @创建日期 2018/6/23 0023
 * @创建时间 11:21.//      http://localhost:8090/services/MaterialService?wsdl
 */
@WebService(name = "MaterialService", // 暴露服务名称
        targetNamespace = "http://www.inte.material.hcfa.com")   //命名空间,一般是接口的包名倒序
public interface MaterialService {
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    public String getWLInfo(@WebParam(name = "para1") String para1);
    
    @WebMethod
    @WebResult(name = "String",targetNamespace = "")
    public String getDWInfo(@WebParam(name = "para2") String para2);
}
