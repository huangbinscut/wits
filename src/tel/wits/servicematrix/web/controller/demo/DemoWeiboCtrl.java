package tel.wits.servicematrix.web.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import weibo4j.Oauth;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.PostParameter;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.WeiboException;


@Controller
@RequestMapping("/demo/weibo")
public class DemoWeiboCtrl {
	
    @RequestMapping(value = "/weibo", method = {RequestMethod.GET})
    public String weibo() {
        return "demo/weibo/weibo";
    }


	@RequestMapping(value = "/showuser/{id}", method = RequestMethod.POST)
	public @ResponseBody String showuser(javax.servlet.http.HttpServletRequest request
			, @PathVariable("id")String  id)
			throws WeiboException{
		
		String rlt = null;
		
		if (request.getSession().getAttribute("access_token") == null) {
			rlt = "invalid token";
			
		} else {
			
			try{
				String token = ((AccessToken)request.getSession().getAttribute("access_token")).getAccessToken();
				Users um = new Users();
				um.client.setToken(token);
				User user = um.showUserById(id);
				rlt = user.toString();
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}
		
		return rlt;
	}	
	
	@RequestMapping(value = "/timeline", method = RequestMethod.POST)
	public @ResponseBody String getUserTimeline(javax.servlet.http.HttpServletRequest request)
			throws WeiboException{
		
		String rlt = null;
		
		if (request.getSession().getAttribute("access_token") == null) {
			rlt = "invalid token";
			
		} else {
			
			String token = ((AccessToken)request.getSession().getAttribute("access_token")).getAccessToken();
			Timeline tm = new Timeline();
			tm.client.setToken(token);
			try {
				StatusWapper status = tm.getUserTimeline();
				for(Status s : status.getStatuses()){
					rlt += s.toString() + "<br><br>";
				}
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}
		
		return rlt;
	}	
	
	
	@RequestMapping(value = "/toauth", method = RequestMethod.GET)
	public String toAuth(javax.servlet.http.HttpServletRequest request)
			throws WeiboException{
		
		String code = request.getParameter("code");
		
		Oauth oauth = new Oauth();
		
		try{
			AccessToken access_token = oauth.getAccessTokenByCode(code);
			request.getSession().setAttribute("access_token", access_token);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		return "demo";
		
	}	
    
	@RequestMapping(value = "/cleartoken", method = RequestMethod.POST)
	public void clearToken(javax.servlet.http.HttpServletRequest request) throws WeiboException{
		
			String token = ((AccessToken)request.getSession().getAttribute("access_token")).getAccessToken();
			
			Oauth oauth = new Oauth();
			oauth.client.setToken(token);
			oauth.client.post("https://api.weibo.com/oauth2/revokeoauth2" 
					,new PostParameter[] {
							new PostParameter("access_token", token)});
			
			request.getSession().setAttribute("access_token", null);

	}	
}
