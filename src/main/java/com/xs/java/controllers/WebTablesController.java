package com.xs.java.controllers;

import com.xs.java.model.WebTables;
import com.xs.java.service.WebTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebTablesController {


    @Autowired
    private WebTablesService webTablesService;

    @RequestMapping("/manager/wts/list")
    public String index(Model model){
        List<WebTables> lsWTs = webTablesService.getAll();
        model.addAttribute("lsWTs",lsWTs);
        return "manage/webtables/WTSList";
    }

    @RequestMapping("/manager/wts/toAdd")
    public String toAdd(Model model) {
        int maxId =webTablesService.findMaxId();
        model.addAttribute("maxId", maxId);
        return "manage/webtables/WTSAdd";
    }

    @RequestMapping("/manager/wts/add")
    public String add(WebTables webTables) {
        webTablesService.save(webTables);
        return "redirect:/manager/wts/list";
    }

    @RequestMapping("/manager/wts/toEdit")
    public String toEdit(Model model,int id) {
        System.out.println("WebTablesController.toEdit id:"+id);
        WebTables wts=webTablesService.findById(id);
        model.addAttribute("wts", wts);
        return "manage/webtables/WTSEdit";
    }

    @RequestMapping("/manager/wts/edit")
    public String edit(WebTables webTables) {
        System.out.println("WebTablesController.edit id:"+String.valueOf(webTables.getID()));
        webTablesService.edit(webTables);
        return "redirect:/manager/wts/list";
    }


    @RequestMapping("/manager/wts/delete")
    public String delete(int id) {
        System.out.println("WebTablesController.delete id:"+id);
        webTablesService.delete(id);
        return "redirect:/manager/wts/list";
    }



}
