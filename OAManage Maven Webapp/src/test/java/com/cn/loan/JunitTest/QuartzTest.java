package com.cn.loan.JunitTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest implements Job{
	
	public void getTime(){
		Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);		 
        System.out.println("****:" + dateString);
	}
	
	@Test
	public void startSchedule() throws SchedulerException {
		   //1.创建Scheduler的工厂
		 SchedulerFactory sf = new StdSchedulerFactory();
	       
		try {
			 //2.从工厂中获取调度器实例
			 Scheduler scheduler = sf.getScheduler();
			//3.创建JobDetail
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("请输入方法描述");
			 String description = scanner.nextLine();
		        JobDetail jb = JobBuilder.newJob(RAMJob.class)
		                .withDescription(description) //job的描述
		                .build();
		        
		        //任务运行的时间，SimpleSchedle类型触发器有效
		        long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
		        Date statTime = new Date(time);
		        scanner = new Scanner(System.in);
		        System.out.println("时间维度");
		        /*0/2 * * * * ?*/
		        String timeString = scanner.nextLine();
		        //4.创建Trigger
		        //使用SimpleScheduleBuilder或者CronScheduleBuilder
		        Trigger t = TriggerBuilder.newTrigger()
		                .withDescription("")
		                //.withSchedule(SimpleScheduleBuilder.simpleSchedule())
		                .startAt(statTime)  //默认当前时间启动
		                .withSchedule(CronScheduleBuilder.cronSchedule(timeString)) //两秒执行一次
		                .build();
		        //5.注册任务和定时器

		        scheduler.scheduleJob(jb, t);
				  //6.启动 调度器
		        scheduler.start();
		       System.out.println("启动时间 ： " + new Date());
		} catch (SchedulerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
       
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String dateString = formatter.format(currentTime);		 
      System.out.println("****:" + dateString);
	}
}
