package com.cn.loan.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.multipart.MultipartFile;

import com.cn.loan.service.ActivitiService;

@Controller
@RequestMapping("/sign")
public class LoginController {
	
	@Autowired
	private ActivitiService activitiService;
	
	@Autowired
	IdentityService identityService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpSession session,@RequestParam String userName,
			@RequestParam String password){
		
		if(session.getAttribute("user")!=null){
			return "main";
		}else {		
			/*Boolean isUser = identityService.createUserQuery().userId(userName).memberOfGroup(groupId).equals(null);*/
			Boolean check = identityService.checkPassword(userName, password);
			if(check){
				User user = activitiService.getUserInfo(request);
				session.setAttribute("user", user);
				Group group = identityService.createGroupQuery().groupMember(user.getId()).singleResult();
				session.setAttribute("group", group);
				return "main";
			}else {
				return null;
			}
		}		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession session){		
		session.removeAttribute("user");
		return "sys/logout";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Model model){	
		List<Group> groups = activitiService.getGroups();
		request.setAttribute("groups", groups);
		return "sys/register";
	}
	
	@RequestMapping("/signin")
	public String register(HttpServletRequest request,Model model,
			@RequestParam String userName,@RequestParam String password,@RequestParam String email,
			@RequestParam String firstName,@RequestParam String lastName,@RequestParam("file") MultipartFile file){
		
		 if (file!=null) {
				String path = null;
				String type = null;
				String fileName = file.getOriginalFilename();
				type = fileName.indexOf(".")!=-1?
						fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):null;
						if (type!=null){
							if("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())){
								// 项目在容器中实际发布运行的根路径
								String realPath=request.getSession().getServletContext().getRealPath("/");
					                 // 自定义的文件名称
								String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
					                 // 设置存放图片文件的路径
								path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
								  System.out.println("存放图片文件的路径:"+path);
			                      // 转存文件到指定的路径
								  try {
									file.transferTo(new File(path));
								} catch (IllegalStateException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
			} else {

			}
		
		activitiService.createUser(request);
		return "sys/login";
	}
	
	  @RequestMapping("/uploadPic")
	  public String uploadPic(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		  
		  if (file!=null) {
			String path = null;
			String type = null;
			String fileName = file.getOriginalFilename();
			type = fileName.indexOf(".")!=-1?
					fileName.substring(fileName.lastIndexOf(".")+1,fileName.length()):null;
					if (type!=null){
						if("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())){
							// 项目在容器中实际发布运行的根路径
							String realPath=request.getSession().getServletContext().getRealPath("/");
				                 // 自定义的文件名称
							String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
				                 // 设置存放图片文件的路径
							path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
							  System.out.println("存放图片文件的路径:"+path);
		                      // 转存文件到指定的路径
							  try {
								file.transferTo(new File(path));
							} catch (IllegalStateException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
		} else {

		}
		  return null;
	  }
}
