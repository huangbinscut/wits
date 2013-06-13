package tel.wits.servicematrix.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author timearrow
 * @version 1.0
 */
@Controller

public class IndexCtrl {
    
    @RequestMapping(value = "/demo")
    public String demo(HttpServletRequest request){
        return "demo/demo";
    }

	@RequestMapping(value="/visit", method = RequestMethod.GET) 
    public String defaultHandler() { 

        return "redirect:individual/login"; 
    } 
	
}
