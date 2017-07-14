package com.cn.loan.JunitTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.cmd.CreateUserCmd;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class Test1 {
	
	//获取流程引擎对象  
    //getDefaultProcessEngine方法内部会自动读取名为activiti.cfg.xml文件的配置信息  
	
     ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();  
     
     @Test
	public void ccc(){
    	List<Task> tasks = processEngine.getTaskService().createTaskQuery().list();
    	System.out.println(tasks.get(0));
	}
     
     
 	@Test
 	public void createUser(){
 		IdentityService inIdentityService = processEngine.getProcessEngineConfiguration().getIdentityService();
 		User user = inIdentityService.newUser("3");
 		user.setPassword("2");
 		user.setEmail("3");
 		inIdentityService.saveUser(user);
 		inIdentityService.setUserInfo(user.getId(), "phone", "123");
 	}
 	
 	@Test
 	public void cc(){
 		IdentityService identityService = processEngine.getProcessEngineConfiguration().getIdentityService();
 		List<User> users = identityService.createUserQuery().list();
 		for (User user : users) {
			identityService.getUserInfo(user.getId(), "groupName");
			List<String> list = identityService.getUserInfoKeys(user.getId());
			for (String string : list) {
				identityService.getUserInfo(user.getId(), "");
			}
		}
 	}
      
    /**部署流程定义*/  
    @Test  
    public void deploymentProcessDefinition(){  
        //与流程定义和部署对象相关的Service  
        RepositoryService repositoryService=processEngine.getRepositoryService();  
          
        DeploymentBuilder deploymentBuilder=repositoryService.createDeployment();//创建一个部署对象  
        deploymentBuilder.name("审批流程");//添加部署的名称  
        deploymentBuilder.addClasspathResource("diagrams/Myprocess.bpmn");//从classpath的资源加载，一次只能加载一个文件  
        deploymentBuilder.addClasspathResource("diagrams/MyProcess.png");//从classpath的资源加载，一次只能加载一个文件  
        Deployment deployment=deploymentBuilder.deploy();//完成部署  
          
        //打印我们的流程信息  
        System.out.println("流程Id:"+deployment.getId());  
        System.out.println("流程Name:"+deployment.getName());  
    }  
    
    /** 
     * 查询部署列表 
     */  
    @Test  
    public void deploymentQuery() {  
        // 部署查询对象，查询表act_re_deployment  
        DeploymentQuery query = processEngine.getRepositoryService()  
                .createDeploymentQuery();  
        List<Deployment> list = query.list(); 
        if("".equals(list)||list.size()==0){
        	System.out.println("没有部署列表");
        }else{
            for (Deployment deployment : list) {  
                System.out.println("正在进行的流程Id:"+deployment.getId());  
                System.out.println("正在进行的流程Name:"+deployment.getName()); 
            }  
        }

    }  
    
    /** 
     * 查询流程定义列表 
     */  
    @Test  
    public void queryProcessDefinition() {  
        // 流程定义查询对象，查询表act_re_procdef  
        ProcessDefinitionQuery query = processEngine.getRepositoryService()  
                .createProcessDefinitionQuery();  
        List<ProcessDefinition> list = query.list(); 
        if("".equals(list)||list.size()==0){
        	System.out.println("没有流程定义列表");
        	}else{
	        for (ProcessDefinition pd : list) {  
	            System.out.println("流程定义name:"+pd.getName() + "*** 流程定义ID:" + pd.getId()  
	            		+"*** 所属的部署ID:" +pd.getDeploymentId());  
        }  
        }
    }  
    
    /** 
     * 删除部署信息 
     */  
    @Test  
    public void deleteDeployment() {  
        String deploymentId = "2501";  //部署ID
        // processEngine.getRepositoryService().deleteDeployment(deploymentId);  
        processEngine.getRepositoryService().deleteDeployment(deploymentId,//级联删除,通过删除部署信息达到删除流程定义的目的,删除流程定义使用相同方法
                true);  
    }  
    
    /** 
     * 启动流程实例 
     */  
    @Test  
    public void startProcessInstance() {  
    	
    	Map<String, Object> variables = new HashMap<String, Object>();
    	variables.put("申请人", "张三");
    	variables.put("请假天数", "7");
    	
        // 流程定义的key  
        String processDefinitionKey = "process";  
        ProcessInstance pi = processEngine.getRuntimeService()// 于正在执行的流程实例和执行对象相关的Service  
                .startProcessInstanceByKey(processDefinitionKey,variables);// 使用流程定义的key启动流程实例，key对应hellworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动  
       
        System.out.println("流程实例ID:" + pi.getId());// 流程实例ID 101  
        System.out.println("流程定义ID:" + pi.getProcessDefinitionId()); // 流程定义ID HelloWorld:1:4
    }
    
    /**
     * 查询进行流程实例列表,查询act_ru_execution表 
     * */
    @Test  
    public void processInstanceQuery(){  
        //流程实例查询对象，查询act_ru_execution表  
        ProcessInstanceQuery query = processEngine.getRuntimeService().createProcessInstanceQuery();  
        query.processDefinitionKey("Test");  
        query.orderByProcessInstanceId().desc();  
        query.listPage(0, 10);//分页  
        List<ProcessInstance> list = query.list();  
        for (ProcessInstance pi : list) {  
            System.out.println("正执行的事例ID："+pi.getId() + "*** 所属的流程定义ID：" 
            		+ pi.getProcessDefinitionId()+"*** 开始的ActivityId:"+pi.getActivityId()
            		
            		+"-------他的name属性"+pi.getProcessVariables().get("name"));  
        }  
    }  
    
    /**
     * 结束流程实例,操作的表act_ru_execution act_ru_task
     * */
    @Test  
    public void deleteProcessInstance(){  
        String processInstanceId = "2601";  
        processEngine.getRuntimeService().deleteProcessInstance(processInstanceId , "我愿意");  
    }  
    
    /**查询进行的任务*/
    @Test
    public void taskQuery(){
    	List<Task> tasks =  processEngine.getTaskService().createTaskQuery().list();
    	for (Task task:tasks) {
    		System.out.println("执行ID:"+task.getId());
    		
    		System.out.println(task.getProcessInstanceId()+task.getProcessDefinitionId());
    		
    	}
        
    }

    /**查询当前的个人任务(实际就是查询act_ru_task表)*/  
    @Test  
    public void findMyPersonalTask(){  
        String assignee="李组长";  
        //获取事务Service  
        TaskService taskService=processEngine.getTaskService();  
        processEngine.getTaskService().getSubTasks(null);
        List<Task> taskList=taskService.createTaskQuery()//创建任务查询对象  
                   .taskAssignee(assignee)//指定个人任务查询，指定办理人  
                   .list();//获取该办理人下的事务列表  
          
        if(taskList!=null&&taskList.size()>0){  
            for(Task task:taskList){  
                System.out.println("任务ID："+task.getId());  
                System.out.println("任务名称："+task.getName());  
                System.out.println("任务的创建时间："+task.getCreateTime());  
                System.out.println("任务办理人："+task.getAssignee());  
                System.out.println("流程实例ID："+task.getProcessInstanceId());  
                System.out.println("执行对象ID："+task.getExecutionId());  
                System.out.println("流程定义ID："+task.getProcessDefinitionId());  
                System.out.println("#############################################");  
            }  
        }  
    }
    
    
    /** 
     * 完成我的任务 
     */  
    @Test  
    public void completeMyPersonTask(){  
        //任务Id  
        String taskId="5006";  
        processEngine.getTaskService()//与正在执行的认为管理相关的Service  
                .complete(taskId); 
        System.out.println("完成任务:任务ID:"+taskId);  
      
    }  
    
    /** 
     * 查询最新版本的流程定义列表 
     */  
    @Test  
    public void processDefinitionQueryAll(){  
        ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();  
        query.orderByProcessDefinitionVersion().asc();  
        List<ProcessDefinition> list = query.list();  
        Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();  
        for (ProcessDefinition pd : list) {  
            map.put(pd.getKey(), pd);  
        }  
        ArrayList<ProcessDefinition> lastList = new ArrayList(map.values());  
        for (ProcessDefinition processDefinition : lastList) {  
            System.out.println(processDefinition.getName() + "  "+ processDefinition.getVersion()+" "+processDefinition.getId() );  
        }  
    }  
    
    
    /** 
     * 查询历史流程实例列表 
     */  
    @Test  
    public void historicProcessInstanceQuery() {  
        HistoricProcessInstanceQuery query = processEngine.getHistoryService()  
                .createHistoricProcessInstanceQuery();  
        List<HistoricProcessInstance> list = query.list();  
        for (HistoricProcessInstance hi : list) {  
            System.out.println("getId:"+hi.getId());
            System.out.println("getStartUserId:"+hi.getStartUserId());
            System.out.println("getStartActivityId:"+hi.getStartActivityId());
            System.out.println("getStartTime:"+hi.getStartTime());
            System.out.println("getEndTime:"+hi.getEndTime());
            System.out.println(""+hi.getProcessVariables());
            System.out.println("所属的流程："+hi.getProcessDefinitionId());
        }  
    }  
    
    /** 
     * 查询历史活动数据列表 
     */  
    @Test  
    public void historicActivityInstanceQuery() {  
        HistoricActivityInstanceQuery query = processEngine.getHistoryService()  
                .createHistoricActivityInstanceQuery();  
        // 按照流程实例排序  
        query.orderByProcessInstanceId().desc();  
        query.orderByHistoricActivityInstanceEndTime().asc();  
        List<HistoricActivityInstance> list = query.list();  
        for (HistoricActivityInstance hi : list) {  
            System.out.println("ActivityId："+hi.getActivityId()+"*** Assignee:"+hi.getAssignee() + "*** ActivityName" + hi.getActivityName()  
                    + "*** ActivityType：" + hi.getActivityType()+"*** ExecutionId:"+hi.getExecutionId()+"*** StartTime"+hi.getStartTime()
                    + "*** EndTime"+hi.getEndTime());  
        }  
    } 
    
    /** 
     * 查询历史任务数据列表 
     */  
    @Test  
    public void historicTaskInstanceQuery() {  
    	
        HistoricTaskInstanceQuery query = processEngine.getHistoryService()  
                .createHistoricTaskInstanceQuery();  
        query.orderByProcessInstanceId().asc();  //根据ProcessInstanceId升序
        query.orderByHistoricTaskInstanceEndTime().desc();  //结束时间降序
        List<HistoricTaskInstance> list = query.list();  
        for (HistoricTaskInstance hi : list) {  
            System.out.println("执行ID：" + hi.getId()+"*** 关键人KEY："+hi.getAssignee() + "*** 执行事件:" + hi.getName() + "*** 开始时间："  
                    + hi.getStartTime()+"*** 结束时间："+ hi.getEndTime() + "*** ExecutionId:"+hi.getExecutionId() 
                    + "*** 结束原因："+hi.getDeleteReason()+"*** 所属实例："+hi.getProcessInstanceId());  
        }  
    }  
    
    /** 
     * 查询流程定义列表 
     */  
    @Test  
    public void processDefinitionQueryTest() {  
        /* 
         * processEngine.getRepositoryService().createDeploymentQuery().list(); 
         * processEngine 
         * .getRuntimeService().createProcessInstanceQuery().list(); 
         * processEngine.getTaskService().createTaskQuery().list(); 
         */  
  
        // 流程定义查询对象,用于查询表act_re_procdef  
        ProcessDefinitionQuery query = processEngine.getRepositoryService()  
                .createProcessDefinitionQuery();  
        // 添加过滤条件  
  /*      query.processDefinitionKey("qjlc");  */
        // 添加排序条件  
        query.orderByProcessDefinitionVersion().desc();  
        // 添加分页查询  
        query.listPage(0, 10);  
        List<ProcessDefinition> list = query.list();  
        for (ProcessDefinition pd : list) {  
            System.out.println(pd.getId());  
        }  
    }  
    
/*    public static void main(String[] args){
    	
    	Test1.deploymentProcessDefinition();
    	startProcessInstance();
    	findMyPersonalTask();
    	completeMyPersonTask();
    }*/
    
    
}


