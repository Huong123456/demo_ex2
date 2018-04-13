package com.ifi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifi.domain.Student;
import com.ifi.domain.Subj;

import com.ifi.service.StudentService;
import com.ifi.service.SubService;




@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubService subService;
	
	

    @GetMapping("/student")
    public String index(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
    
    @GetMapping("/sub")
    public String index1(Model model) {
    	model.addAttribute("subs", subService.findAll());
    	return "list_monhoc";
    }
    
    
    @GetMapping("/student/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }
    
    @GetMapping("/sub/create")
    public String create1(Model model) {
    	model.addAttribute("sub", new Subj());
    	return "form_monhoc";
    }
    
    @GetMapping("/student/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.findOne(id));
        return "form";
    }
    @GetMapping("/sub/{idsub}/edit") 
    public String edit1(@PathVariable int idsub, Model model) {
    	model.addAttribute("sub", subService.findOne(idsub));
        return "form_monhoc";
    }
    
    @PostMapping("/student/save")
    public String save(@Valid Student student, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        studentService.save(student);
        redirect.addFlashAttribute("success", "Saved student successfully!");
        return "redirect:/student";
    }
    @PostMapping("/sub/save")
    public String save1(@Valid Subj sub, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form_monhoc";
        }
        subService.save(sub);
        redirect.addFlashAttribute("success", "Saved sub successfully!");
        return "redirect:/sub";
    }
    
    
    
    @GetMapping("/student/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	studentService.delete(id);
        redirect.addFlashAttribute("success", "Deleted student successfully!");
        return "redirect:/student";
     }
    
    @GetMapping("/sub/{idsub}/delete")
    public String delete1(@PathVariable int idsub, RedirectAttributes redirect) {
    	subService.delete(idsub);
        redirect.addFlashAttribute("success", "Deleted sub successfully!");
        return "redirect:/sub";
     }
    
    
    @GetMapping("/student/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/student";
        }
        
        model.addAttribute("students", studentService.search(q));
        return "list";
    }
    
   

}
