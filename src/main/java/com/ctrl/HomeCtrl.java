package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.ToDo;

@Controller
public class HomeCtrl {

	@Autowired
	ServletContext sc;
	
	@RequestMapping("/home")
	public String Home(Model m) {

		String str = "home";
		m.addAttribute("page",str);
//		ServletContext sc = null;
		List<ToDo> list = (List<ToDo>) sc.getAttribute("list");
		m.addAttribute("todos",list);
		return "home";
	}
	
	@RequestMapping("/add")
	public String addToDo(Model m) {
		
		ToDo t = new ToDo();
		m.addAttribute("page","add");
		m.addAttribute("todo", t);
		return "home";
	}
	
	@RequestMapping(value="/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") ToDo t, Model m) {
		
		System.out.println("t: "+t);
		t.setTodoDate(new Date());
//		ServletContext sc = null;
		List<ToDo> list = (List<ToDo>) sc.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "successfulattributeValue");
		
		return "home";
	}

}
