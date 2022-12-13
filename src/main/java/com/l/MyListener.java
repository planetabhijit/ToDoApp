package com.l;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entity.ToDo;

public class MyListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
		System.out.println("Context");
		List<ToDo> list = new ArrayList<ToDo>();
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", list);
		
	}

	
	
}
