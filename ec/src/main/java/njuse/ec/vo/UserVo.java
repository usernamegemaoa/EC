package njuse.ec.vo;

import java.util.Date;
import java.util.List;

/**
 * 用户信息Vo.
 * @author 丞
 *
 */
public class UserVo {

	int id;
	String account;
	String name;
	String email;
	Date birthday;
	String iconPath;
	int score;
	int male;
	int role;
	List<AddressVo> addressVoList;
	
}
