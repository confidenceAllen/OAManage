package com.cn.loan.Activemq;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AppProducer {
	
	 private static final String url=ActiveMQConnection.DEFAULT_BROKER_URL;  
	 private static final String queueName="queue-test";  
	
	 public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queueName);
		
		MessageProducer messageProducer = session.createProducer(destination);
		
		TextMessage textMessage = session.createTextMessage("我发出的消息11");
		
		messageProducer.send(textMessage);
		
		System.out.println(textMessage.getText());
		
		connection.close();
	}

}
