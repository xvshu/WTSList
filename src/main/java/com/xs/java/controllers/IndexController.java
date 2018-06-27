package com.xs.java.controllers;

import com.sun.javafx.collections.MappingChange;
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
public class IndexController {

    @Autowired
    private WebTablesService webTablesService;

    @RequestMapping("/wlist")
    public String index(Model model){
        List<WebTables> lsWTs = webTablesService.getAll();
        Map<String,Map<String,List<WebTables>>> mapWTS = webChangeList(lsWTs);
        System.out.println(lsWTs.size());
        model.addAttribute("mapWTS",mapWTS);
        return "index";
    }

    private Map<String,Map<String,List<WebTables>>> webChangeList(List<WebTables> in){
        Map<String,Map<String,List<WebTables>>> out = new HashMap<String,Map<String,List<WebTables>>>();

        for(WebTables onew : in){
            if(!out.containsKey(onew.getENV())){
                Map<String,List<WebTables>> mape = new HashMap<String,List<WebTables>>();
                out.put(onew.getENV(),mape);
            }
            if(!out.get(onew.getENV()).containsKey(onew.getTAG())){
                List<WebTables> listT= new ArrayList<WebTables>();
                out.get(onew.getENV()).put(onew.getTAG(),listT);
            }
            out.get(onew.getENV()).get(onew.getTAG()).add(onew);
        }
        return out;
    }

}
