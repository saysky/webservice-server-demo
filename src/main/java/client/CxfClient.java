package client;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


/**
 * @author 言曌
 * @date 2019-06-09 18:39
 */

public class CxfClient {
    public static void main(String[] args) {
        CxfClient.main1();
//        CxfClient.main2();
    }

    /**
     * 1.代理类工厂的方式,需要拿到对的接口地址
     */
    public static void main1() {
        try {
            // 接口地址
            String address = "http://127.0.0.1:8080/soap/user?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
            // 创建一个代理接口实现
            UserService us = (UserService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userId = "111111";
            // 调用代理接口的方法调用并返回结果
            String userName = us.getUserName(userId);
            User user = us.getUser(userId);
            System.out.println("用户名:" + userName);
            System.out.println("用户:" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2：动态调用
     */
    public static void main2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://127.0.0.1:8080/soap/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUserName", "222222");
            System.out.println("用户名:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
