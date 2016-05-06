package njuse.ec.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import njuse.ec.service.GoodService;
import njuse.ec.service.UserService;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.UserVo;

/**
 * 基础Action.
 * @author 丞
 *
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {
	
	@Autowired
	private GoodService goodService;
	
	@Autowired
	private UserService userService;

	private List<KindVo> fatherKinds;

	private String headuserName;
	private int headuserId;

	private static final long serialVersionUID = -7955496034883725815L;
	/**
	 * http request.
	 */
	private HttpServletRequest request;
	/**
	 * http response.
	 */
	private HttpServletResponse response;
	/**
	 * http session.
	 */
	private Map<String, Object> session;

	/**
	 * @return the request
	 */
	public final HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public final HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @return the session
	 */
	public final Map<String, Object> getSession() {
		return session;
	}

	@Override
	public final void setServletResponse(
			final HttpServletResponse newResponse) {
		this.response = newResponse;
	}

	@Override
	public final void setServletRequest(final HttpServletRequest newRequest) {
		this.request = newRequest;
	}

	@Override
	public final void setSession(final Map<String, Object> newSession) {
		this.session = newSession;
	}
	
	public String execute() {
		fatherKinds = goodService.getFatherKind();
		if (getSession().containsKey("userId")) {
			int id = (int) getSession().get("userId");
			UserVo vo = userService.userInfo(id);
			headuserName = vo.getName();
			headuserId = vo.getId();
		} else {
			headuserId = 0;
			headuserName = "";
		}
		return SUCCESS;
	}

	/**
	 * @return the fatherKinds
	 */
	public List<KindVo> getFatherKinds() {
		return fatherKinds;
	}

	/**
	 * @return the headuserName
	 */
	public String getHeaduserName() {
		return headuserName;
	}

	/**
	 * @return the headuserId
	 */
	public int getHeaduserId() {
		return headuserId;
	}

	
}
