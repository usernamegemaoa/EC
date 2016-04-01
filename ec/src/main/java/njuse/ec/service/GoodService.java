package njuse.ec.service;

import java.util.List;

import njuse.ec.vo.CommentVo;
import njuse.ec.vo.ConsultVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.ResultVo;

/**
 * 商品模块.
 * @author 阳
 *
 */
public interface GoodService {

	/**
	 * 获取第一层分类.
	 * @return 第一层次类别列表
	 */
	List<KindVo> getFatherKind();

	/**
	 * 获取子分类.
	 * @param kind 要获取子分类列表的父分类
	 * @return 指定父分类的子分类列表
	 */
	List<KindVo> getSonKind(KindVo kind);

	/**
	 * 查看最新单品页数.
	 * @return 最新单品页数
	 */
	int getLatestGoodPages();

	/**
	 * 指定页数的新品列表（从0开始）.
	 * @param page 要查看的页数
	 * @return 相应页数的商品列表
	 */
	List<SimpleGoodVo> getLatestGood(int page);

	/**
	 * 获取k种类商品的商品页数.
	 * @param kind 商品种类
	 * @return 商品列表页数
	 */
	int getKindGoodPages(KindVo kind);
	
	/**
	 * 获取k种类商品指定页数的商品列表（从0开始）.
	 * @param kind 商品种类
	 * @param page 商品列表页数
	 * @return 指定页数的商品列表
	 */
	List<SimpleGoodVo> getKindGood(KindVo kind, int page);

	/**
	 * 获取关键字搜索的商品页数.
	 * @param search 关键字
	 * @return 商品列表
	 */
	int getSearchGoodPages(String search);

	/**
	 * 获取关键字搜索指定页数的商品列表（从0开始）.
	 * @param search 关键字
	 * @param page 商品列表页数
	 * @return 指定页数的商品列表
	 */
	List<SimpleGoodVo> getSearchGood(String search, int page);

	/**
	 * 根据商品id获得具体商品信息.
	 * @param goodId 商品id
	 * @return 具体商品信息
	 */
	GoodVo getDetailGood(int goodId);

	/**
	 * 获取同类热销商品列表（10个）.
	 * @param goodId 商品id
	 * @return 同类热销商品列表
	 */
	List<SimpleGoodVo> gotHotGood(int goodId);

	/**
	 * 为商品添加咨询.
	 * @param goodId 商品id
	 * @param consult 咨询内容
	 * @return 添加结果
	 */
	ResultVo addGoodConsult(int goodId, ConsultVo consult);
	
	/**
	 * 为商品添加评价.
	 * @param goodId 商品id
	 * @param comment 评价内容
	 * @return 添加结果
	 */
	ResultVo addGoodComment(int goodId, CommentVo comment);
	
	/**
	 * 获取咨询页数.
	 * @param goodId 商品id
	 * @return 商品的咨询页数
	 */
	int getConsultPages(int goodId);
	
	/**
	 * 获取评论页数.
	 * @param goodId 评论id
	 * @return 商品的评论页数
	 */
	int getCommentPages(int goodId);
	
	/**
	 * 获取咨询.
	 * @param goodId 商品id
	 * @param pages 咨询列表页数
	 * @return 指定页的咨询列表
	 */
	List<ConsultVo> getConsults(int goodId, int pages);
	
	/**
	 * 获取评论.
	 * @param goodId 商品id
	 * @param pages 评论列表页数
	 * @return 指定页的评论列表
	 */
	List<CommentVo> getComments(int goodId, int pages);
}
