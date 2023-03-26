package com.michaeilgoncharov.spring.mvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {
    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }
    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }
    @RequestMapping("/showDetails")
    public String showEmpDetails(HttpServletRequest request, Model model){
        String empName = request.getParameter("employeeName");
        empName = "Mr." + empName;
        model.addAttribute("nameAttribute", empName);
        model.addAttribute("description", " - udemy instructor");
        return "show-emp-details-view";
}


}