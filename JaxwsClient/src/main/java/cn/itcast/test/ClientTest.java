package cn.itcast.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import cn.itcast.service.IUserService;

public class ClientTest {

	@Test
	public void testClient(){
		//1.创建一个jaxws的代理工厂类对象
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//2.设置要访问哪个服务器的地址
		factory.setAddress("http://localhost:12345/user?wsdl");
		//3.设置代理要将结果信息转化为哪个接口
		factory.setServiceClass(IUserService.class);
		//4.创建出代理子类对象
		IUserService ius = (IUserService) factory.create();
		
		//5.调用方法
		String result = ius.sayHi("itcast");
		
		//6.输出
		System.out.println("=======================client==================="+result);
	}
}
