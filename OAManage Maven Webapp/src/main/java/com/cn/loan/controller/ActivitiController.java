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
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	FormService formService;
	
	@Autowired
	HistoryService historyService;
	
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
	
	
	@RequestMapping("/processInstanceDetail")
	public String processInstance(HttpServletRequest request,Model model,@RequestParam String deploymentId){
		ProcessDefinition processDefinition = activitiService.queryProcessDefinitionSingle(deploymentId);
		List<FormProperty> formPropertielList = formService.getStartFormData(processDefinition.getId())
												.getFormProperties();
		request.setAttribute("formPropertielList", formPropertielList);
		request.setAttribute("processDefinition", processDefinition);
		return "activiti/processInstance";
	}
	
	
	@RequestMapping("/startProcessInstance")	
	public String startProcessInstance(HttpServletRequest request,Model model){
		
		Map<String, Object> variables = new HashMap<String, Object>();
		String processDefinitionId = request.getParameter("processDefinitionId");
		List<FormProperty> formPropertielList = formService.getStartFormData(processDefinitionId)
				.getFormProperties();
		for (FormProperty formProperty : formPropertielList) {
			variables.put(formProperty.getId(), request.getParameter(formProperty.getId()));
		}	
		activitiService.startProcessInstance(processDefinitionId, variables);		
		return "activiti/deploymentList";
	}
	
	@RequestMapping("/queryTask")
	public String queryTask(HttpServletRequest request,Model model,HttpSession session){
		Group group = (Group) session.getAttribute("group");		
		List<Task> tasks =  taskService.createTaskQuery().list();
		/*List<Task> tasks =  taskService.createTaskQuery().taskCandidateGroup(group.getId()).list();*/
		request.setAttribute("task", tasks);
		return "activiti/taskList";
	}
	
	@RequestMapping("/allTask")
	public String allTask(HttpServletRequest request,Model model,HttpSession session){	
		List<HistoricTaskInstance> historicTaskInstances =  historyService.createHistoricTaskInstanceQuery()
				.orderByHistoricActivityInstanceId().asc().orderByTaskCreateTime().desc().list();	
		request.setAttribute("historicTaskInstances", historicTaskInstances);
		return "activiti/allTaskList";
	}
	
	@RequestMapping("/startCompleteTask")
	public String startCompleteTask(HttpServletRequest request,Model model,
			@RequestParam String taskId,@RequestParam String processInstanceId){
		List<FormProperty> formPropertielList = formService.getTaskFormData(taskId)
				.getFormProperties();
		request.setAttribute("formPropertielList", formPropertielList);
		request.setAttribute("taskId", taskId);
		request.setAttribute("processInstanceId", processInstanceId);
		return "activiti/startCompleteTask";
	}
	
	@RequestMapping("/completeTask")
	public String completeTask(HttpServletRequest request,Model model,HttpSession session,
			@RequestParam String taskId,@RequestParam String processInstanceId,@RequestParam String message){
		Map<String, Object> variables = new HashMap<String, Object>();
		List<FormProperty> formPropertielList = formService.getTaskFormData(taskId)
				.getFormProperties();
		for (FormProperty formProperty : formPropertielList) {
			variables.put(formProperty.getId(), request.getParameter(formProperty.getId()));
		}	
		
		taskService.addComment(taskId, processInstanceId, message);
		taskService.complete(taskId, variables);
		return "activiti/taskList";
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
