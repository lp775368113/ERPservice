package com.hcfa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcfa.inteImpl.CommonServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HcfaApplicationTests {

	@Test
	public void contextLoads() {
		CommonServiceImpl csi=new CommonServiceImpl();
		String str=csi.getQueryData("{endTime:\"\",startTime:\"\",xh:\""+"X3E"+"\"}");
		System.out.println(str);
	}

}
