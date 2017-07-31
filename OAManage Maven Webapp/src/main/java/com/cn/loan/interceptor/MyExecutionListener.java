package com.cn.loan.interceptor;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;

public class MyExecutionListener implements ExecutionListener,TaskListener {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;

	public void notify(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String eventName = execution.getEventName();  
		//start  
		if ("start".equals(eventName)) {  
		System.out.println("start=========");  
		}else if ("end".equals(eventName)) {  
		System.out.println("end=========");  
		}  
	}

	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		String eventName = delegateTask.getEventName();  
		if ("create".endsWith(eventName)) {  
		System.out.println("create=========我已经准备开始");  
		}else if ("assignment".endsWith(eventName)) {  
		System.out.println("assignment========我已经准备开始");  
		}else if ("complete".endsWith(eventName)) {  
		System.out.println("complete===========");  
		}else if ("delete".endsWith(eventName)) {  
		System.out.println("delete=============");  
		}  
	}

}
