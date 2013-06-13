package tel.wits.servicematrix.web.controller.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tel.wits.servicematrix.model.DemoUser;

@Controller
@RequestMapping("/demo/ajax")
public class DemoAjaxController {

	/**
	 * 根据映射跳转到指定的页面
	 */
	@RequestMapping(value = "/ajaxpage", method = RequestMethod.GET)
	public String getAjaxAddPage() {
		// 解析 /WEB-INF/jsp/ajax-add-page.jsp
		return "demo/ajax/ajax-add-page";
	}

	/**	 
     * 提交表单并进行运算.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Integer add(
			@RequestParam(value = "inputNumber1", required = true)Integer inputNumber1,
			@RequestParam(value = "inputNumber2", required = true)Integer inputNumber2) {
		// 实现运算
		Integer sum = inputNumber1 + inputNumber2;
		System.out.println("sum: " + sum);
		// @ResponseBody 会自动的将返回值转换成JSON格式
		// 但是你必须添加jackson的jar包!!!
		return sum;
	}	

	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.POST)
	public @ResponseBody DemoUser getUser(@PathVariable("userId")String  userId) {
		System.out.println("根据ID获取用户对象: " + userId);		
		Map<String,DemoUser> users = new HashMap<String,DemoUser>();
		users.put("1", new DemoUser("123456", "李逵", "123", "成都市", "1", 23));
		users.put("2", new DemoUser("565676", "张三", "123", "北京市", "2", 53));
		users.put("3", new DemoUser("325566", "李四", "123", "河南省", "2", 93));
		users.put("4", new DemoUser("989654", "刘邦", "123", "蒙古包", "1", 13));
		users.put("5", new DemoUser("234444", "王熙凤", "123", "成都市", "1", 43));		
		return users.get(userId);
	}

	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public @ResponseBody
	List<DemoUser> getUsers() {		
		List<DemoUser> users = new ArrayList<DemoUser>();
		users.add(new DemoUser("123456", "李逵", "123", "成都市", "1", 23));
		users.add(new DemoUser("123457", "李四", "124", "北京市", "2", 53));
		users.add(new DemoUser("123458", "李三", "125", "河南市", "0", 73));
		users.add(new DemoUser("123459", "李五", "126", "大路市", "3", 93));
		return users;
	}
	
	@RequestMapping(value = "/userMap", method = RequestMethod.POST)
	public @ResponseBody Map<String,DemoUser> getUserMap() {		
		Map<String,DemoUser> users = new HashMap<String,DemoUser>();
		users.put("1", new DemoUser("123456", "李逵", "123", "成都市", "1", 23));
		users.put("2",new DemoUser("123457", "李四", "124", "北京市", "2", 53));
		users.put("3",new DemoUser("123458", "李三", "125", "河南市", "0", 73));
		users.put("4",new DemoUser("123459", "李五", "126", "大路市", "3", 93));
		return users;
	}
}
