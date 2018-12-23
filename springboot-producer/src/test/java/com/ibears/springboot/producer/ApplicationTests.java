package com.ibears.springboot.producer;

import com.ibears.springboot.producer.entity.Order;
import com.ibears.springboot.producer.producer.RabbitOrderSender;
import com.ibears.springboot.producer.start.Application;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private RabbitOrderSender rabbitOrderSender;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSend1() throws Exception{
		Order order = new Order();
		order.setOrderId("OR201800000000");
		order.setName("测试订单1");
		order.setMessageId(System.currentTimeMillis()+"#"+ UUID.randomUUID());
		rabbitOrderSender.send(order);
	}
	
	
}

