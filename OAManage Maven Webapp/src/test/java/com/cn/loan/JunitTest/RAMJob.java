package com.cn.loan.JunitTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RAMJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Logger _log = LoggerFactory.getLogger(RAMJob.class);

		// TODO Auto-generated method stub
		Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);		 
		 _log.info("****:" + dateString);
	}

}
