package com.cn.loan.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.Group;
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
	
	@RequestMapping("/deletedeployment")
	public String startDeployment(HttpServletRequest request,Model model,@RequestParam String deploymentId){
		activitiService.deleteDeployment(deploymentId);
		return "redirect:/activiti/list.do";
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
}
