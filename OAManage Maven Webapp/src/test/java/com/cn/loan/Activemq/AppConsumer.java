package com.cn.loan.Activemq;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class AppConsumer {
	
	 private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;  
	 private static final String queueName="queue-test";  

	 public static void main(String[] args) throws JMSException{
		 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		 
		 Connection connection =connectionFactory.createConnection();
		 
		 connection.start();
		 
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 
		 Destination destination = session.createQueue(queueName);
		 
		 MessageConsumer messageConsumer = session.createConsumer(destination);		 
		 
		/* TextMessage msg = (TextMessage) messageConsumer.receive();*/
		 
/*		 System.out.println(msg.getText());*/
		 
		 while (true) {
             TextMessage textMessage = (TextMessage) messageConsumer.receive();
             if(textMessage != null){
                 System.out.println("收到的消息:" + textMessage.getText());
             }else {
                 break;
             }
         }

     
		 
/*		 messageConsumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage)message;
				System.out.println(textMessage);
			}
		});*/
		 
		 connection.close();
	 }
}
