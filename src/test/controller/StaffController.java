package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.service.StaffService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenjiansheng on 2016-4-26.
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @RequestMapping("/addStaff")
    public String addUser(HttpServletRequest request, Model model) {
        if(staffService.addStaff(request.getParameter("id"))){
            model.addAttribute("staff", "YES");
        }else{
            model.addAttribute("staff", "NO");
        }
        return "showStaff";
    }
}