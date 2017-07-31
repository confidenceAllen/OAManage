package com.cn.loan.util.quartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

public class CreateTrigger extends CronTriggerFactoryBean{
	
	public Trigger create(Date statTime,String description,String cronSchedule){
		Trigger trigger = TriggerBuilder.newTrigger()
                .withDescription(description).startAt(statTime)  //默认当前时间启动
                .withSchedule(CronScheduleBuilder.cronSchedule(cronSchedule)) //两秒执行一次
                .build();
		return trigger;
	}
}
