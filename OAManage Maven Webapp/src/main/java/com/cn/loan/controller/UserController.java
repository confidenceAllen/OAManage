package com.cn.loan.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cn.loan.pojo.ActivitiUser;
import com.cn.loan.service.ActivitiService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	  protected Logger logger = LoggerFactory.getLogger(getClass());
	
	  @Autowired
	  private ActivitiService activitiService;
	
	  @Autowired
	  RepositoryService repositoryService;
	  
	  @Autowired	  
	  IdentityService identityService;
	  
	  @RequestMapping("/userList")
	  public String userList(HttpServletRequest request){
		  
		  List<User> userList = identityService.createUserQuery().list();
		  List<Group> grouplList = identityService.createGroupQuery().list();
		  
		  Map<String,List> map = new HashMap<String,List>();
		  ActivitiUser activitiUser = new ActivitiUser();
		  
		  List list = new ArrayList();
		  for(Group group:grouplList){
			  String groupId = group.getId();
			  List<User> users = identityService.createUserQuery().memberOfGroup(groupId).list();
			  
			  map.put(groupId,identityService.createUserQuery().memberOfGroup(groupId).list());
		  }
		  request.setAttribute("userList", userList);
		  request.setAttribute("grouplList", grouplList);
		  request.setAttribute("maps", map);
		  
		  return "user/userList";
	  }
	  
	  @RequestMapping("/groupList")
	  public String groupList(HttpServletRequest request){
		  	 
		  List<Group> grouplList = identityService.createGroupQuery().list();
			 
		  request.setAttribute("grouplList", grouplList);
		  
		  return "user/groupList";
	  }
	  
	  @RequestMapping("/createUser")
	  public String createUser(HttpServletRequest request,
			  @RequestParam String userName,@RequestParam String password,@RequestParam String email,
			  @RequestParam String firstName,@RequestParam String lastName,@RequestParam String groupId){
		  
		  User user = identityService.newUser(userName);
		  user.setEmail(email);
		  user.setFirstName(firstName);
		  user.setLastName(lastName);
		  user.setPassword(password);
		  identityService.saveUser(user);
		  //创建group关联
		  identityService.createMembership(user.getId(), groupId);
		  return "redirect:/user/userList";
	  }
	  
	  @RequestMapping("/createGroup")
	  public String createGroup(HttpServletRequest request,@RequestParam String groupId,
			  @RequestParam String groupName,@RequestParam String type){
		  try {
			  Group group = identityService.newGroup(groupId);			  
			  group.setName(groupName);
			  group.setType(type);
			  identityService.saveGroup(group);
			  return "redirect:/user/groupList";
			} catch (Exception e) {
				logger.debug("groupId--已存在--不能重复");
				return null;
			}
		
	  }
	  
}
