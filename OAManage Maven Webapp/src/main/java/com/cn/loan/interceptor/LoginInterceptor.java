package com.cn.loan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.identity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//登录认证的拦截器 
public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		
        //判断session  
        HttpSession session=request.getSession();  
        //从session中取出用户份信息  
       User user = (User)session.getAttribute("user");  
          
        if(user!=null){  
            //身份存在，放行  
            return true;  
        }  
        
		//获取请求的url  
        String url=request.getRequestURI();  
        //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)  
        if(url.indexOf("/sign/")>=0){  
            //如果要进行登录提交，放行  
            return true;  
        }  
          

          
        //执行这里表示用户身份需要验证，跳转到登录界面  
        request.getRequestDispatcher("/WEB-INF/jsp/sys/login.jsp").forward(request, response);  
          
        //return false表示拦截，不向下执行  
        //return true表示放行          
        return false;  
	}

}
