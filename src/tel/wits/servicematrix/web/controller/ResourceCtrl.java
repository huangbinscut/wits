package tel.wits.servicematrix.web.controller;

import java.util.Date;

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
import tel.wits.servicematrix.model.infomodel.ExecutionModel;
import tel.wits.servicematrix.model.infomodel.ExecutionQueryModel;
import tel.wits.servicematrix.model.infomodel.ResourceModel;
import tel.wits.servicematrix.model.infomodel.ResourceQueryModel;
import tel.wits.servicematrix.service.IExecutionService;
import tel.wits.servicematrix.service.IResourceService;

//Resource UI Action Controller

@Controller
public class ResourceCtrl {

    @Autowired
    @Qualifier("ResourceService")
    private IResourceService resourceService;
    
    @Autowired
    @Qualifier("ExecutionService")
    private IExecutionService executionService;
    


    //---------------------Retrieve Resource Action List----------------------
    
    //use this method to turn page and refresh the page.
    @RequestMapping(value = "/individual/{individualId}/resource/list", method = {RequestMethod.GET})
    public String listResourceByIndividual(HttpServletRequest request, Model model
    		, @PathVariable("individualId")int  individualId) {
/*    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Page<ResourceModel> page = resourceService.queryByIndividualId(pn, Constants.DEFAULT_PAGE_SIZE, individualId);
        
        //set page into request for display when refresh the page.
        request.setAttribute(Constants.RESOURCE_PAGE, page);
        
*/    	return "console/resourceconsole";
    }

    //get next page and don't refresh the page.
    @RequestMapping(value = "/individual/{individualId}/resource/page", method = {RequestMethod.GET})
    public @ResponseBody Page<ResourceModel> pageResourceByIndividual(HttpServletRequest request, Model model
    		, @PathVariable("individualId")int  individualId) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);

        Page<ResourceModel> page = resourceService.queryByIndividualId(pn, Constants.DEFAULT_PAGE_SIZE, individualId);
        
        return page;
    }
    
    @RequestMapping(value = "execution/{executionId}/resource/page", method = {RequestMethod.GET})
    public @ResponseBody Page<ResourceModel> pageResourceByExecution(HttpServletRequest request, Model model
    		, @PathVariable("executionId")int  executionId) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);

        Page<ResourceModel> page = resourceService.queryByExecutionId(pn, Constants.DEFAULT_PAGE_SIZE, executionId);
        
        return page;
    }

    @RequestMapping(value = "robot/{robotId}/resource/page", method = {RequestMethod.GET})
    public @ResponseBody Page<ResourceModel> pageResourceByRobot(HttpServletRequest request, Model model
    		, @PathVariable("robotId")int  robotId) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);

        Page<ResourceModel> page = resourceService.queryByRobotId(pn, Constants.DEFAULT_PAGE_SIZE, robotId);
        
        return page;
    }

    @RequestMapping(value = "/individual/{individualId}/resource/query", method = {RequestMethod.GET})
    public @ResponseBody Page<ResourceModel> queryResourceOfIndividual(@PathVariable("individualId")int  individualId
    		, HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.RESOURCE_QUERY) ResourceQueryModel resourceQuery) {
    	
        setCommonData(model);
        
        resourceQuery.setIndividualId(individualId);
        model.addAttribute(Constants.RESOURCE_QUERY, resourceQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<ResourceModel> page = resourceService.query(pn, Constants.DEFAULT_PAGE_SIZE, resourceQuery);

        return page;
    }

    @RequestMapping(value = "/resource/query", method = {RequestMethod.GET})
    public @ResponseBody Page<ResourceModel> queryResource(HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.RESOURCE_QUERY) ResourceQueryModel resourceQuery) {
    	
        setCommonData(model);
        
        model.addAttribute(Constants.RESOURCE_QUERY, resourceQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<ResourceModel> page = resourceService.query(pn, Constants.DEFAULT_PAGE_SIZE, resourceQuery);

        return page;
    }

    @RequestMapping(value = "/resource/{resourceId}", method = RequestMethod.GET)
	public @ResponseBody ResourceModel detailResource(@PathVariable("resourceId")int  resourceId) {
		return resourceService.get(resourceId);
	}
    
    //------------------------End of Retrieve Resource Action List------------------

    
    //------------------------Retrieve Execution Action List------------------
    
    //use this method to turn page and refresh the page.
    @RequestMapping(value = "/individual/{individualId}/execution/list", method = {RequestMethod.GET})
    public String listExecutionByIndividual(HttpServletRequest request, Model model
    		, @PathVariable("individualId")int  individualId) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Page<ExecutionModel> page = executionService.queryByIndividualId(pn, Constants.DEFAULT_PAGE_SIZE, individualId);
        
        //set page into request for display when refresh the page.
        request.setAttribute(Constants.EXECUTION_PAGE, page);
        
        return "resourceconsole/resourceconsole";
    }

    //get next page and don't refresh the page.
    @RequestMapping(value = "/individual/{individualId}/execution/page", method = {RequestMethod.GET})
    public @ResponseBody Page<ExecutionModel> pageExecutionByIndividual(HttpServletRequest request, Model model
    		, @PathVariable("individualId")int  individualId) {
    	
        setCommonData(model);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);

        Page<ExecutionModel> page = executionService.queryByIndividualId(pn, Constants.DEFAULT_PAGE_SIZE, individualId);
        
        return page;
    }
    
    @RequestMapping(value = "/individual/{individualId}/execution/query", method = {RequestMethod.GET})
    public @ResponseBody Page<ExecutionModel> queryExecutionOfIndividual(@PathVariable("individualId")int  individualId
    		, HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.EXECUTION_QUERY) ExecutionQueryModel executionQuery) {
    	
        setCommonData(model);
        
        executionQuery.setIndividualId(individualId);
        model.addAttribute(Constants.EXECUTION_QUERY, executionQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<ExecutionModel> page = executionService.query(pn, Constants.DEFAULT_PAGE_SIZE, executionQuery);

        return page;
    }

    @RequestMapping(value = "/execution/query", method = {RequestMethod.GET})
    public @ResponseBody Page<ExecutionModel> queryExecution(HttpServletRequest request, Model model
    		, @ModelAttribute(Constants.EXECUTION_QUERY) ExecutionQueryModel executionQuery) {
    	
        setCommonData(model);
        
        model.addAttribute(Constants.EXECUTION_QUERY, executionQuery);
        
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        
        //TODO only support query of individual id now, need to support all field query
        Page<ExecutionModel> page = executionService.query(pn, Constants.DEFAULT_PAGE_SIZE, executionQuery);

        return page;
    }

    @RequestMapping(value = "/execution/{executionId}", method = RequestMethod.GET)
	public @ResponseBody ExecutionModel detailExecution(@PathVariable("executionId")int  executionId) {
		return executionService.get(executionId);
	}
    
    
    //------------------------End of Retrieve Execution Action List------------------
    
    
    //------------------------Share and Reposit Resource Action List------------------
    
    @RequestMapping(value = "/resource/{resourceId}/reserve", method = {RequestMethod.POST})
    public @ResponseBody ResourceModel reserve(Model model
    		, @ModelAttribute(Constants.RESOURCE_COMMAND) @Valid ResourceModel resourceCommand, BindingResult result) {
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.RESOURCE_COMMAND, resourceCommand);
            return null;
        }
        
        resourceCommand.setIsReserved(Constants.IS_RESERVED_YES);
        
        return resourceService.save(resourceCommand);
    }


    
    //------------------------End of Share and Reposit Resource Action List------------------

  
    
    private void setCommonData(Model model) {
        //设置通用属性
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
  
    
}
