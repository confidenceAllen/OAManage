package com.cn.loan.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.cn.loan.service.ActivitiService;

@Controller
@RequestMapping("/activiti")
public class ActivitiController {
	
	@Autowired
	private ActivitiService activitiService;
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request,Model model){
		
		return "activiti/main";
	}
	
	
	@RequestMapping("/list")
	public String deploymentList(HttpServletRequest request,Model model){
		List<Deployment> deployments = activitiService.queryDeployment();
		request.setAttribute("deployments", deployments);
		return "activiti/deploymentList";
	}
	
	@RequestMapping("/startDeployment")
	public String startDeployment(HttpServletRequest request,Model model){
		
		return "activiti/table";
	}
	
	@RequestMapping("/modeler")
	public String table(HttpServletRequest request,Model model){
		
		return "modeler";
	}
	
	@RequestMapping("/viewShow")
	public void viewShow(HttpServletRequest request,Model model,@RequestParam String deploymentId,HttpServletResponse response){		
		InputStream imageStream = activitiService.viewShow(deploymentId);
        try {
    		byte[] b = new byte[1024];
            int len;
			while ((len = imageStream.read(b, 0, 1024)) != -1) {
			    response.getOutputStream().write(b, 0, len);
}				
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/viewShowHight")
	public void viewShowHight(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam String processDefinitionId,@RequestParam String taskId,@RequestParam String processInstanceId){
		
		InputStream imageStream = activitiService.viewShow(taskId,processDefinitionId,processInstanceId);
        try {
    		byte[] b = new byte[1024];
            int len;
			while ((len = imageStream.read(b, 0, 1024)) != -1) {
			    response.getOutputStream().write(b, 0, len);
}				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/processInstanceDetail")
	public String processInstance(HttpServletRequest request,Model model,@RequestParam String deploymentId){
		ProcessDefinition processDefinition = activitiService.queryProcessDefinitionSingle(deploymentId);
		request.setAttribute("processDefinition", processDefinition);
		return "activiti/processInstance";
	}
	
	
	@RequestMapping("/startProcessInstance")	
	public String startProcessInstance(HttpServletRequest request,Model model,
			@RequestParam String processDefinitionKey,
			@RequestParam String username,
			@RequestParam String reason,@RequestParam String dates){
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("name", username);
		variables.put("原因", reason);
		variables.put("dates", dates);		
		activitiService.startProcessInstance(processDefinitionKey, variables);		
		return "activiti/deploymentList";
	}
	
	@RequestMapping("/queryTask")
	public String queryTask(HttpServletRequest request,Model model){
		List<Task> tasks = activitiService.queryTask();
		request.setAttribute("task", tasks);
		return "activiti/taskList";
	}
	
	@RequestMapping("/startCompleteTask")
	public String startCompleteTask(HttpServletRequest request,Model model){
		return "activiti/startCompleteTask";
	}
	
/*	@RequestMapping("/completeTask")
	public String completeTask(HttpServletRequest request,Model model,HttpSession session,
			@RequestParam String taskId,@RequestParam String message ,@RequestParam String processInstanceId){
		User user = (User)session.getAttribute("user");
		String userId =  user.getId();
		activitiService.completeTaskByTaskId(taskId,userId,processInstanceId,message);
		return "activiti/taskList";
	}*/
	
	@RequestMapping("/completeTask")
	public String completeTask(HttpServletRequest request,Model model,HttpSession session,
			@RequestParam String taskId){
		User user = (User)session.getAttribute("user");
		String userId =  user.getId();
		activitiService.completeTaskByTaskId(taskId);
		return "activiti/taskList";
	}
	
}
