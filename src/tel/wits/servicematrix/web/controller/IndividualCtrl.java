package tel.wits.servicematrix.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tel.wits.common.Constants;
import tel.wits.common.web.support.editor.DateEditor;
import tel.wits.servicematrix.model.infomodel.IndividualModel;
import tel.wits.servicematrix.service.IIndividualService;

//Resource UI Action Controller

@Controller
public class IndividualCtrl {

    @Autowired
    @Qualifier("IndividualService")
    private IIndividualService individualService;
    


    //---------------------Register / Login-out Action List----------------------
    
    //to register
    @RequestMapping(value = "/individual/register", method = RequestMethod.GET)
    public String toRegister(Model model) {
    	
        setCommonData(model);

        IndividualModel individual = new IndividualModel();
        
    	model.addAttribute(Constants.INDIVIDUAL_COMMAND, individual);
    	
        return "register";
    }
    
    //register
    @RequestMapping(value = "/individual/register", method = {RequestMethod.POST})
    public @ResponseBody Map<String, Object> register(HttpServletRequest request
    		, @ModelAttribute(Constants.INDIVIDUAL_COMMAND) @Valid IndividualModel individualCommand, BindingResult bindingResult) {
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
        //如果有验证错误 返回到form页面
        if(bindingResult.hasErrors()) {
        	resultMap.put(Constants.AJAX_SUCCESS, Constants.AJAX_SUCCESS_FALSE);
        	resultMap.put(Constants.AJAX_ERROR_LIST, bindingResult.getAllErrors());
            return resultMap;
        }
        
        if ( !individualCommand.getPassword().equals(individualCommand.getPasswordRepeat()) ) {
        	bindingResult.rejectValue("passwordRepeat", "validate.password_repeat.unmatch", "两次输入的密码不一致！");
        }

        IndividualModel individual = individualService.getByLoginName(individualCommand.getLoginName());
        if ( individual != null ) {
        	bindingResult.rejectValue("loginName", "validate.login_name.used", "输入的登录邮箱已经被人注册了！");
        } 
        
        individual = individualService.getByUserName(individualCommand.getUserName());
        if ( individual != null ) {
        	bindingResult.rejectValue("userName", "validate.user_name.used", "输入的用户名已经被人注册了！");
        } 
        
        //如果逻辑有验证错误 返回到form页面
        if(bindingResult.hasErrors()) {
        	resultMap.put(Constants.AJAX_SUCCESS, Constants.AJAX_SUCCESS_FALSE);
        	resultMap.put(Constants.AJAX_ERROR_LIST, bindingResult.getAllErrors());
            return resultMap;
        }
        
        //新增用户
        individualCommand.setGenerateTime(new Date());
        individualCommand.setLoginCount(0);
        individualCommand.setUserType(Constants.USER_TYPE_INDIVIDUAL);
        individualCommand.setEmail(individualCommand.getLoginName());
        
        individualCommand = individualService.save(individualCommand);
        
        resultMap.put(Constants.AJAX_SUCCESS, Constants.AJAX_SUCCESS_TRUE);
        resultMap.put(Constants.AJAX_DATA, individualCommand);
        
    	request.getSession().setAttribute(Constants.INDIVIDUAL_ACTIVE, individualCommand);

        return resultMap;
    }
    
    
    //register by channel sina
	//根据url判断是通过哪条channel提供注册信息,调用对应channel的sdk获取用户注册信息,自动保存注册individual；同时保存对应的channel信息和token信息
    @RequestMapping(value = "/individual/register/channel/sina/", method = {RequestMethod.GET})
    public String registerByChannelSina(HttpServletRequest request) {
    	
        
/*		String code = request.getParameter("code");
		
		Oauth oauth = new Oauth();
		
		try{
			AccessToken access_token = oauth.getAccessTokenByCode(code);
			request.getSession().setAttribute("access_token", access_token);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		return "demo";
*/    	
    	IndividualModel individualCommand = new IndividualModel();
    	
        individualCommand.setGenerateTime(new Date());
        individualCommand.setLoginCount(0);
        individualCommand.setUserType(Constants.USER_TYPE_INDIVIDUAL);
        
        individualService.save(individualCommand);
    	request.getSession().setAttribute(Constants.INDIVIDUAL_ACTIVE, individualCommand);

        return "resourceconsole/resourceconsole";
    }

    
    //to login
    @RequestMapping(value = "/individual/login", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, Model model) {
    	
        setCommonData(model);
        if ( request.getSession().getAttribute(Constants.INDIVIDUAL_LAST_ACTIVE) != null ) {
        	model.addAttribute(Constants.INDIVIDUAL_COMMAND, request.getSession().getAttribute(Constants.INDIVIDUAL_LAST_ACTIVE));
        }

        if (!model.containsAttribute(Constants.INDIVIDUAL_COMMAND)) {
        	IndividualModel individual = null;
        	individual = new IndividualModel();
        	model.addAttribute(Constants.INDIVIDUAL_COMMAND, individual);
        }
    	
        return "login";
    }
    
    //login
    //判断用户密码是否正确,正确则保存在session中,然后返回正确
    @RequestMapping(value = "/individual/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest request
    		, Model model, @ModelAttribute(Constants.INDIVIDUAL_COMMAND) @Valid IndividualModel individualCommand, BindingResult result) {
        
        //如果格式有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.INDIVIDUAL_COMMAND, individualCommand);
            return "login";
        }
        
        IndividualModel individual = individualService.getByLoginName(individualCommand.getLoginName());
        
        if ( individual == null ) {
        	result.rejectValue("loginName", "validate.login_name.null", "输入的用户名不存在!");
        	
        } else if ( !individual.getPassword().equals(individualCommand.getPassword()) ) {
        	result.rejectValue("password", "validate.password.unmatch", "输入密码错误！");
        }
        
        //如果逻辑有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.INDIVIDUAL_COMMAND, individualCommand);
            return "login";
        }
        
        individual.setLastLoginTime(individual.getLoginTime());
        individual.setLoginTime(new Date());
        individual.setLoginCount(individual.getLoginCount() + 1);
        
        individualService.update(individual);
   	
    	request.getSession().setAttribute(Constants.INDIVIDUAL_ACTIVE, individual);
    	
        return "redirect:/individual/" + individual.getIndividualId() + "/resource/list";
    }

    //login by channel sina
	//根据url判断是通过哪条channel登录,调用对应channel的sdk获取用户登录信息
    @RequestMapping(value = "/individual/login/channel/sina/", method = {RequestMethod.GET})
    public String loginByChannel(HttpServletRequest request) {
        
        return "resourceconsole/resourceconsole";
    }

    //logout
    //清除session
    @RequestMapping(value = "/individual/logout", method = {RequestMethod.GET})
    public String logout(HttpServletRequest request) {
    	
        IndividualModel curIndividual = (IndividualModel)request.getSession().getAttribute(Constants.INDIVIDUAL_ACTIVE);
        IndividualModel newIndividual = new IndividualModel();
        newIndividual.setLoginName(curIndividual.getLoginName());
    	
        request.getSession().setAttribute(Constants.INDIVIDUAL_LAST_ACTIVE, newIndividual);
    	request.getSession().setAttribute(Constants.INDIVIDUAL_ACTIVE, null);
    	
    	return "redirect:/individual/login";
    }
    
    @RequestMapping(value = "/individual/password", method = {RequestMethod.GET})
    public String password(HttpServletRequest request) {
    	
    	
    	return "redirect:/individual/login";
    }
     
    //------------------------End of Register / Login-out Action List------------------

    
    //------------------------Information Setting Action List------------------
    
    //to setting
    @RequestMapping(value = "/individual/{individualId}/setting", method = RequestMethod.GET)
    public @ResponseBody IndividualModel toSetting(@PathVariable("individualId")int  individualId, Model model) {
    	
        setCommonData(model);

        IndividualModel individual = individualService.get(individualId);
        
    	model.addAttribute(Constants.INDIVIDUAL_COMMAND, individual);
    	
        return individual;
    }
    
    //setting
    @RequestMapping(value = "/individual/{individualId}/setting", method = {RequestMethod.POST})
    public @ResponseBody IndividualModel setting(Model model, @ModelAttribute(Constants.INDIVIDUAL_COMMAND) @Valid IndividualModel individualCommand, BindingResult result) {
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.INDIVIDUAL_COMMAND, individualCommand);
            return null;
        }
        
        return individualService.save(individualCommand);
    }
   
    //------------------------End of Information Setting Action List------------------
    
    
 
  
    
    private void setCommonData(Model model) {
        //设置通用属性
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
  
    
}
