package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
@Controller
public class CustomerManagerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerManagerController.class);
    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String index() {
        logger.info("跳转到index页面");
        return "redirect:/list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        logger.info("输出会员{}个",customers.size());
        // 直接到resources资源文件下templates寻找响应文件
        //next 1： 热部署
        //next 2：日志
        //next 3：错误提示
        return "customer/list";
    }
}
