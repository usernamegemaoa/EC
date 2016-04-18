package njuse.ec.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础Action.
 * @author 丞
 *
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

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

}
