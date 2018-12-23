package com.ibears.springboot.customer;

import com.ibears.springboot.customer.statrt.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.APOptions;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringbootProducerApplicationTests {

	@Test
	public void contextLoads() {
	}

}

