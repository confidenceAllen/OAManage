package com.cn.loan.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzJob {
	
	public void doSomething() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);		 
          System.out.println("****:" + dateString);
    }

}
