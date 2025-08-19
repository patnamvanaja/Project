
package com.developer.SPRINGBOOT_PROJECT12.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.developer.SPRINGBOOT_PROJECT12.Entity.EmployeeDetails;
import com.developer.SPRINGBOOT_PROJECT12.Service.IEmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService eservice;

    @GetMapping("/employees")
    public String getAllEmployeeDetails(Model model) {
        model.addAttribute("employees", eservice.fetchAllRecords());
        return "display_employee";
    }

    @GetMapping("/employees/new")
    public String viewCreateEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDetails());
        return "create_employee";
    }

    @PostMapping("/employees")
    public String save(@Valid @ModelAttribute("employee") EmployeeDetails empDetails,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "create_employee";
        }
        eservice.insertNewRecord(empDetails);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String viewEditEmployee(@PathVariable long id, Model model) {
        model.addAttribute("employee", eservice.fetchRecordById(id));
        return "update_employee";
    }

    @PostMapping("/employees/{id}")
    public String updateDetails(@PathVariable long id,
                                @Valid @ModelAttribute("employee") EmployeeDetails details,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            return "update_employee";
        }
        eservice.updateRecordById(id, details);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        eservice.deleteById(id);
        return "redirect:/employees";
    }
}