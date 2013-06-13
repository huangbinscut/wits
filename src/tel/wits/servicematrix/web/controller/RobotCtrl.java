package tel.wits.servicematrix.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tel.wits.common.Constants;
import tel.wits.common.pagination.Page;
import tel.wits.common.web.support.editor.DateEditor;
import tel.wits.servicematrix.model.infomodel.AbilityModel;
import tel.wits.servicematrix.model.infomodel.AbilityQueryModel;
import tel.wits.servicematrix.model.infomodel.AccessTokenModel;
import tel.wits.servicematrix.model.infomodel.PermissionModel;
import tel.wits.servicematrix.model.infomodel.RobotModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeModel;
import tel.wits.servicematrix.model.infomodel.RobotPrototypeQueryModel;
import tel.wits.servicematrix.model.infomodel.RobotQueryModel;
import tel.wits.servicematrix.service.IAbilityService;
import tel.wits.servicematrix.service.IAccessTokenService;
import tel.wits.servicematrix.service.IPermissionService;
import tel.wits.servicematrix.service.IRobotPrototypeService;
import tel.wits.servicematrix.service.IRobotService;

//Robot UI Action Controller

@Controller
public class RobotCtrl {

    @Autowired
    @Qualifier("RobotService")
    private IRobotService robotService;
    
    @Autowired
    @Qualifier("RobotPrototypeService")
    private IRobotPrototypeService prototypeService;
    
    @Autowired
    @Qualifier("AbilityService")
    private IAbilityService abilityService;
    
    @Autowired
    @Qualifier("AccessTokenService")
    private IAccessTokenService accessTokenService;
    
    @Autowired
    @Qualifier("PermissionService")
    private IPermissionService permissionService;

    //--------------Purchase Robot Action List-------------------------
    
    //use this method to turn page and refresh the page.
    @RequestMapping(value = "/prototype/list", method = {RequestMethod.GET})
    public String listPrototype(HttpServletRequest request, Model model) {
    	
    	setCommonData(model);

    	int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        Page<RobotPrototypeModel> page = null;
        if(id > 0) {
            if(pre) {
                page = prototypeService.pre(id, pn);
            }
            else {
                page = prototypeService.next(id, pn);
            }
        } 
        else {
            page = prototypeService.listAll(pn);
        }
        
        //set page into request for display when refresh the page.
        request.setAttribute(Constants.PROTOTYPE_PAGE, page);
        
        return "console/robotmarket";
    }

    //get next page and don't refresh the page.
    @RequestMapping(value = "/prototype/page", method = {RequestMethod.GET})
    public @ResponseBody Page<RobotPrototypeModel> pagePrototype(HttpServletRequest request) {
    	
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        Page<RobotPrototypeModel> page = null;
        if(id > 0) {
            if(pre) {
                page = prototypeService.pre(id, pn);
            }
            else {
                page = prototypeService.next(id, pn);
            }
        } 
        else {
            page = prototypeService.listAll(pn);
        }
        
        return page;
    }

    
    @RequestMapping(value = "/robot/prototype/query", method = {RequestMethod.GET})
    public @ResponseBody Page<RobotPrototypeModel> queryPrototype(HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.PROTOTYPE_QUERY) RobotPrototypeQueryModel prototypeQuery) {
        
    	setCommonData(model);
        
        model.addAttribute(Constants.PROTOTYPE_QUERY, prototypeQuery);
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of prototype name now, need to support all field query
        Page<RobotPrototypeModel> page = prototypeService.query(pn, Constants.DEFAULT_PAGE_SIZE, prototypeQuery);
        
        return page;
    }

    @RequestMapping(value = "/robot/prototype/{prototypeId}", method = RequestMethod.GET)
	public @ResponseBody RobotPrototypeModel detailPrototype(@PathVariable("prototypeId")int  prototypeId) {
		return prototypeService.get(prototypeId);
	}
   
    //to purchase
    @RequestMapping(value = "/individual/{individualId}/prototype/{prototypeId}/purchase"
    		, method = RequestMethod.GET)
    public @ResponseBody RobotModel toPurchase(@PathVariable("prototypeId")int  prototypeId
			, @PathVariable("individualId")int  individualId, Model model) {
    	
        setCommonData(model);
        
        RobotModel robot = new RobotModel();
    	robot.setIndividualId(individualId);
    	robot.setPrototypeId(prototypeId);
        
        model.addAttribute(Constants.ROBOT_COMMAND, robot);

        return robot;
    }
    
    //purchase
    @RequestMapping(value = "/robot/purchase", method = {RequestMethod.POST})
    public @ResponseBody RobotModel purchase(Model model, @ModelAttribute(Constants.ROBOT_COMMAND) @Valid RobotModel robotCommand, BindingResult result) {
    	
    	setCommonData(model);
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.ROBOT_COMMAND, robotCommand);
            return null;
        }
        
        robotCommand.setManufactureTime(new Date());
        robotCommand = robotService.save(robotCommand);
        
        // purchase count ++
        RobotPrototypeModel prototype = prototypeService.get(robotCommand.getPrototypeId());
        prototype.setPurchaseCount(prototype.getPurchaseCount() + 1);
        prototypeService.update(prototype);
        
        model.addAttribute(Constants.PROTOTYPE_COMMAND, prototype);
        model.addAttribute(Constants.ROBOT_COMMAND, robotCommand);
        return robotCommand;
    }
    
    //-------------------------End of Purchase Robot Action List-------------------------
    
    
    //-------------------------Organize Robot Action List-------------------------
        
    @RequestMapping(value = "/individual/{individualId}/robot/list", method = {RequestMethod.GET})
    public @ResponseBody Page<RobotModel> listRobotByIndividual(@PathVariable("individualId")int  individualId
    		, HttpServletRequest request, Model model) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);

        Page<RobotModel> page = robotService.queryByIndividualId(pn, Constants.DEFAULT_PAGE_SIZE, individualId);
        
        return page;
    }

    @RequestMapping(value = "/individual/{individualId}/robot/query", method = {RequestMethod.GET})
    public @ResponseBody Page<RobotModel> queryRobotOfIndividual(@PathVariable("individualId")int  individualId
    		, HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.ROBOT_QUERY) RobotQueryModel robotQuery) {
    	
        setCommonData(model);
        
        robotQuery.setIndividualId(individualId);
        model.addAttribute(Constants.ROBOT_QUERY, robotQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<RobotModel> page = robotService.query(pn, Constants.DEFAULT_PAGE_SIZE, robotQuery);

        return page;
    }

    @RequestMapping(value = "/robot/query", method = {RequestMethod.GET})
    public @ResponseBody Page<RobotModel> queryRobot(HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.ROBOT_QUERY) RobotQueryModel robotQuery) {
    	
        setCommonData(model);
        
        model.addAttribute(Constants.ROBOT_QUERY, robotQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<RobotModel> page = robotService.query(pn, Constants.DEFAULT_PAGE_SIZE, robotQuery);

        return page;
    }

    @RequestMapping(value = "/robot/{robotId}", method = RequestMethod.GET)
	public @ResponseBody RobotModel detailRobot(@PathVariable("robotId")int  robotId) {
		return robotService.get(robotId);
	}
    
    //-----------------------End of Organize Robot Action List----------------------
    
    
    //------------------------Customize Robot Action List-------------------------
    
    //to customize
    @RequestMapping(value = "/robot/{robotId}/customize", method = RequestMethod.GET)
    public @ResponseBody RobotModel toCustomize(@PathVariable("robotId")int  robotId, Model model) {
    	
        setCommonData(model);

        RobotModel robot = robotService.get(robotId);
        
    	model.addAttribute(Constants.ROBOT_COMMAND, robot);
    	
        return robot;
    }
    
    //customize
    @RequestMapping(value = "/robot/{robotId}/customize", method = {RequestMethod.POST})
    public @ResponseBody RobotModel customize(Model model, @ModelAttribute(Constants.ROBOT_COMMAND) @Valid RobotModel robotCommand, BindingResult result) {
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.ROBOT_COMMAND, robotCommand);
            return null;
        }
        
        return robotService.save(robotCommand);
    }

    //to authorize
    @RequestMapping(value = "/robot/{robotId}/auth", method = {RequestMethod.GET})
    public @ResponseBody Map<AbilityModel, List<AccessTokenModel>> toAuthorize(@PathVariable("robotId")int  robotId
    		, Model model
    		, @ModelAttribute(Constants.ABILITY_QUERY) AbilityQueryModel abilityQuery) {
    	
        setCommonData(model);

        Map<AbilityModel, List<AccessTokenModel>> resultMap = new HashMap<AbilityModel, List<AccessTokenModel>>();
    	
    	RobotModel robot = robotService.get(robotId);
    	
    	// get ability list
    	abilityQuery.setPrototypeId(robot.getPrototypeId());
        model.addAttribute(Constants.ABILITY_COMMAND, abilityQuery);
        
        List<AbilityModel> abilityList = abilityService.queryByPrototypeId(abilityQuery.getPrototypeId());
        
        // iterator ability list and get access token for each ability
        for (Iterator<AbilityModel> i = abilityList.iterator(); i.hasNext();)  {
        	AbilityModel ability = i.next();

            List<AccessTokenModel> tokenList = accessTokenService.queryByChannelId(ability.getChannelId());
            
            resultMap.put(ability, tokenList);
        }
        
        return resultMap;
    }

    //authorize
    @RequestMapping(value = "/robot/{robotId}/auth/{tokenId}", method = {RequestMethod.POST})
    public @ResponseBody PermissionModel authorize(@PathVariable("robotId")int  robotId, @PathVariable("tokenId")int  tokenId) {
    	
    	PermissionModel permission = new PermissionModel();
    	
    	permission.setRobotId(robotId);
    	permission.setTokenId(tokenId);
    	permission.setIsAvailable(Constants.IS_AVAILABLE_YES);
    	permission.setGenerateTime(new Date());
    	
        return permissionService.save(permission);
    }
    
    //------------------End of Customize Robot Action List--------------------
    
    //-------------------Refresh Notice Action List-------------------
    
    @RequestMapping(value = "/individual/{individualId}/robot/clearallnotice", method = {RequestMethod.POST})
    public @ResponseBody int clearNotice(@PathVariable("individualId")int  individualId) {
    	    	
        return robotService.clearNotice(individualId);
    }

    
    //----------------End of Refresh Notice Action List------------------------
    
    
    private void setCommonData(Model model) {
        //设置通用属性
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
  
    
}
