package njuse.ec.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.CastService;
import njuse.ec.vo.CastVo;
import njuse.ec.vo.GoodElement;

@Repository
public class MyCastAction extends BaseAction {

	/**
	 * 序列化.
	 */
	private static final long serialVersionUID = 163048096722316521L;
	
	@Autowired
	private CastService castService;
	
	private int userId;
	
	private List<CastVo> casts;
	
	private List<GoodElement> castElement;

	public final int getUserId() {
		return userId;
	}

	public final void setUserId(int userId) {
		this.userId = userId;
	}

	public final List<CastVo> getCasts() {
		return casts;
	}

	public final void setCasts(List<CastVo> casts) {
		this.casts = casts;
	}
	
	public final List<GoodElement> getCastElement() {
		return castElement;
	}

	public final void setCastElement(List<GoodElement> castElement) {
		this.castElement = castElement;
	}

	public String execute() {
		castElement = castService.getCastElement(userId);
		return "success";
	}
}
