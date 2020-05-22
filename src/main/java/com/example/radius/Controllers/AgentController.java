package com.example.radius.Controllers;

import com.example.radius.Dao.PropertyEntity;
import com.example.radius.PropertyRepository.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AgentController {

    private Logger logger = LoggerFactory.getLogger(AgentController.class);

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping("/")
    public ModelAndView home() {
        String viewName="PropertyAddPage";
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("propertyEntity",new PropertyEntity());
        return new ModelAndView(viewName,model);
    }
    @PostMapping("/")
    public ModelAndView submitHome(PropertyEntity propertyEntity) {
        RedirectView redirectView = new RedirectView();
        logger.info(propertyEntity.toString());
        propertyRepository.save(propertyEntity);
        redirectView.setUrl("/");
        return new ModelAndView(redirectView);
    }
}
