package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.CommentDAO;
import njuse.ec.dao.ConsultDAO;
import njuse.ec.dao.GoodDAO;
import njuse.ec.dao.HotDAO;
import njuse.ec.dao.KindDAO;
import njuse.ec.dao.PictureDAO;
import njuse.ec.dao.StockDAO;
import njuse.ec.dao.SubCommentDAO;
import njuse.ec.dao.SubConsultDAO;
import njuse.ec.model.Comment;
import njuse.ec.model.Consult;
import njuse.ec.model.Good;
import njuse.ec.model.Hot;
import njuse.ec.model.Kind;
import njuse.ec.model.Picture;
import njuse.ec.model.Stock;
import njuse.ec.model.SubComment;
import njuse.ec.model.SubConsult;
import njuse.ec.service.GoodService;
import njuse.ec.vo.CommentVo;
import njuse.ec.vo.ConsultVo;
import njuse.ec.vo.GoodVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.ResultVo;
import njuse.ec.vo.SimpleGoodVo;
import njuse.ec.vo.StockVo;

/**
 * 商品服务实现.
 * @author 阳
 *
 */
@Service
public class GoodServiceImpl implements GoodService {
	
	/**
	 * KindDAO.
	 */
	@Autowired
	private KindDAO kindDao;
	
	/**
	 * GoodDAO.
	 */
	@Autowired
	private GoodDAO goodDao;
	
	/**
	 * CommentDAO.
	 */
	@Autowired
	private CommentDAO commentDao;
	
	/**
	 * ConsultDAO.
	 */
	@Autowired
	private ConsultDAO consultDao;
	
	/**
	 * SubCommentDAO.
	 */
	@Autowired
	private SubCommentDAO subCommentDao;
	
	/**
	 * SubConsultDAO.
	 */
	@Autowired
	private SubConsultDAO subConsultDao;
	
	/**
	 * PictureDAO.
	 */
	@Autowired
	private PictureDAO pictureDao;
	
	/**
	 * HotDAO.
	 */
	@Autowired
	private HotDAO hotDao;
	
	/**
	 * StockDAO.
	 */
	@Autowired
	private StockDAO stockDao;
	
	/**
	 * 每页最多显示20个商品.
	 */
	private final int perPage = 20;

	@Override
	public final List<KindVo> getFatherKind() {
		List<KindVo> fatherKindVo = new ArrayList<KindVo>();
		List<Kind> fatherKind = kindDao.getFatherKinds();
		for (int i = 0; i < fatherKind.size(); i++) {
			Kind kind = fatherKind.get(i);
			KindVo kindVo = convertToKindVo(kind);
			fatherKindVo.add(kindVo);
		}
		return fatherKindVo;
	}

	@Override
	public final List<KindVo> getSonKind(final KindVo kind) {
		List<KindVo> sonKindVo = new ArrayList<KindVo>();
		int fatherId = kind.getFatherKind();
		List<Kind> sonKind = kindDao.getSonKinds(fatherId);
		for (int i = 0; i < sonKind.size(); i++) {
			Kind k = sonKind.get(i);
			KindVo kindVo = convertToKindVo(k);
			sonKindVo.add(kindVo);
		}
//		if (kind != null) {
//			return sonKind;
//		} else {
//			return null;
//		}
		return sonKindVo;
	}

	@Override
	public final int getLatestGoodPages() {
		List<Good> latestGood = goodDao.getLatestGoods();
		int num = latestGood.size();
		int pages = 0;
		if (num % perPage == 0) {
			pages = num / perPage;
		} else {
			pages = num / perPage + 1;
		}
		return pages;
	}

	@Override
	public final List<SimpleGoodVo> getLatestGood(final int page) {
		List<SimpleGoodVo> latestGoodVo = new ArrayList<SimpleGoodVo>();
		List<Good> latestGood = goodDao.getLatestGoods();
		for (int i = (page * perPage); i < ((page + 1) * perPage); i++) {
			Good good = latestGood.get(i);
			SimpleGoodVo sgVo = convertToSimpleGood(good);
			latestGoodVo.add(sgVo);
		}
		return latestGoodVo;
	}

	@Override
	public final int getKindGoodPages(final KindVo kind) {
		int kindId = kind.getKindId();
		List<Good> kindGoods = goodDao.getKindGoods(kindId);
		int num = kindGoods.size();
		int pages = 0;
		if (num % perPage == 0) {
			pages = num / perPage;
		} else {
			pages = num / perPage + 1;
		}
		return pages;
	}

	@Override
	public final List<SimpleGoodVo> 
	getKindGood(final KindVo kind, final int page) {
		int kindId = kind.getKindId();
		List<SimpleGoodVo> kindGoodVo = new ArrayList<SimpleGoodVo>();
		List<Good> kindGoods = goodDao.getKindGoods(kindId);
		for (int i = (page * perPage); i < ((page + 1) * perPage); i++) {
			Good good = kindGoods.get(i);
			SimpleGoodVo sgVo = convertToSimpleGood(good);
			kindGoodVo.add(sgVo);
		}
		return kindGoodVo;
	}

	@Override
	public final int getSearchGoodPages(final String search) {
		List<Good> searchGoods = goodDao.getNameGoods(search);
		int num = searchGoods.size();
		int pages = 0;
		if (num % perPage == 0) {
			pages = num / perPage;
		} else {
			pages = num / perPage + 1;
		}
		return pages;
	}

	@Override
	public final List<SimpleGoodVo> 
		getSearchGood(final String search, final int page) {
		List<SimpleGoodVo> searchGoodVo = new ArrayList<SimpleGoodVo>();
		List<Good> searchGoods = goodDao.getNameGoods(search);
		for (int i = (page * perPage); i < ((page + 1) * perPage); i++) {
			Good good = searchGoods.get(i);
			SimpleGoodVo sgVo = convertToSimpleGood(good);
			searchGoodVo.add(sgVo);
		}
		return searchGoodVo;
	}

	@Override
	public final GoodVo getDetailGood(final int goodId) {
		Good good = goodDao.getGood(goodId);
		return convertToGoodVo(good);
	}

	@Override
	public final List<SimpleGoodVo> getHotGood(final int goodId) {
		List<SimpleGoodVo> hotGoodVo = new ArrayList<SimpleGoodVo>();
		List<Hot> hotGood = hotDao.getHot(goodId);
		for (int i = 0; i < (perPage / 2); i++) {
			Hot hot = hotGood.get(i);
			int id = hot.getSecondId();
			Good good = goodDao.getGood(id);
			SimpleGoodVo sgVo = convertToSimpleGood(good);
			hotGoodVo.add(sgVo);
		}
		return hotGoodVo;
	}

	@Override
	public final ResultVo 
	addGood(final GoodVo goodVo, final List<StockVo> stockVos) {
		Good good = convertToGood(goodVo);
		goodDao.addGood(good);
		List<Picture> pics = convertToPic(goodVo);
		for (int i = 0; i < pics.size(); i++) {
			Picture pic = pics.get(i);
			pictureDao.addPic(pic);
		}
		Picture mainPic = convertToMainPic(goodVo);
		pictureDao.addPic(mainPic);
		for (int i = 0; i < stockVos.size(); i++) {
			Stock stock = convertToStock(stockVos.get(i));
			stockDao.addStock(stock);
		}
		ResultVo addGoodResult = new ResultVo();
//		if ((goodVo != null) && (stockVos != null)) {
//			addGoodResult.setResultCode(0);
//			addGoodResult.setResultMessage("商品添加成功！");
//		} else {
//			addGoodResult.setResultCode(1);
//			addGoodResult.setResultMessage("商品添加失败！");
//		}
		return addGoodResult;
	}

	@Override
	public final ResultVo 
	addGoodConsult(final int goodId, final ConsultVo consultVo) {
		if (consultVo.getFatherConsult() != null) {
			SubConsult consult = convertToSubConsult(consultVo);
			subConsultDao.addSubConsult(consult);
		} else {
			Consult consult = convertToConsult(consultVo);
			consultDao.addConsult(consult);
		}		
		ResultVo addGoodConsultResult = new ResultVo();
//		if (consult != null) {
//			addGoodConsultResult.setResultCode(0);
//			addGoodConsultResult.setResultMessage("咨询添加成功！");
//		} else {
//			addGoodConsultResult.setResultCode(1);
//			addGoodConsultResult.setResultMessage("咨询添加失败！");
//		}
		return addGoodConsultResult;
	}

	@Override
	public final ResultVo 
	addGoodComment(final int goodId, final CommentVo commentVo) {
		if (commentVo.getFatherComment() != null) {
			SubComment comment = convertToSubComment(commentVo);
			subCommentDao.addSubComment(comment);
		} else {
			Comment comment = convertToComment(commentVo);
			commentDao.addComment(comment);
		}	
		ResultVo addGoodCommentResult = new ResultVo();
//		if (comment != null) {
//			addGoodCommentResult.setResultCode(0);
//			addGoodCommentResult.setResultMessage("评论添加成功！");
//		} else {
//			addGoodCommentResult.setResultCode(1);
//			addGoodCommentResult.setResultMessage("评论添加失败！");
//		}
		return addGoodCommentResult;
	}

	@Override
	public final int getConsultPages(final int goodId) {
		List<Consult> consults = consultDao.getConsults(goodId);
		int num = consults.size();
		int pages = 0;
		if (num % perPage == 0) {
			pages = num / perPage;
		} else {
			pages = num / perPage + 1;
		}
		return pages;
	}

	@Override
	public final int getCommentPages(final int goodId) {
		List<Comment> comments = commentDao.getComments(goodId);
		int num = comments.size();
		int pages = 0;
		if (num % perPage == 0) {
			pages = num / perPage;
		} else {
			pages = num / perPage + 1;
		}
		return pages;
	}

	@Override
	public final List<ConsultVo> 
	getConsults(final int goodId, final int pages) {
		List<ConsultVo> consultsVo = new ArrayList<ConsultVo>();
		List<Consult> consults = consultDao.getConsults(goodId);
		for (int i = (pages * perPage); i < ((pages + 1) * perPage); i++) {
			Consult consult = consults.get(i);
			ConsultVo consultVo = convertToConsultVo(consult);
			consultsVo.add(consultVo);
		}
		return consultsVo;
	}

	@Override
	public final List<CommentVo> 
	getComments(final int goodId, final int pages) {
		List<CommentVo> commentsVo = new ArrayList<CommentVo>();
		List<Comment> comments = commentDao.getComments(goodId);
		for (int i = (pages * perPage); i < ((pages + 1) * perPage); i++) {
			Comment comment = comments.get(i);
			CommentVo commentVo = convertToCommentVo(comment);
			commentsVo.add(commentVo);
		}
		return commentsVo;
	}
	
	/**
	 * 将kind实体转化为kindVo.
	 * @param kind kind实体
	 * @return kindVo
	 */
	private KindVo convertToKindVo(final Kind kind) {
		KindVo kindVo = new KindVo();
		int id = kind.getId();
		int fatherId = kind.getFatherId();
		String name = kind.getKindName();
		kindVo.setKindId(id);
		kindVo.setFatherKind(fatherId);
		kindVo.setName(name);
		return kindVo;
	}
	
	/**
	 * 将good实体转化为goodVo.
	 * @param good good实体
	 * @return goodVo
	 */
	private GoodVo convertToGoodVo(final Good good) {
		GoodVo goodVo = new GoodVo();
		int id = good.getId();
		int kindId = good.getKindId();
		int shopId = good.getShopId();
		String name = good.getName();
		String goodNum = good.getGoodNum();
		String description = good.getDescription();
		double price = good.getPrice();
		String deliverInfo = good.getDeliverInfo();
		String returnInfo = good.getDeliverInfo();
		Date date = good.getTime();
		List<Picture> pics = pictureDao.getPics(id);
		int num = pics.size();
		String[] pic = new String[num - 1];
		for (int i = 0; i < num; i++) {
			pic[i] = pics.get(i).getFile();
		}
		String mainPic = pictureDao.getMainPic(id).getFile();
		goodVo.setGoodId(id);
		goodVo.setKindId(kindId);
		goodVo.setSellerId(shopId);
		goodVo.setGoodNum(goodNum);
		goodVo.setName(name);
		goodVo.setDescription(description);
		goodVo.setPrice(price);
		goodVo.setDeliverInfo(deliverInfo);
		goodVo.setReturnInfo(returnInfo);
		goodVo.setTime(date);
		goodVo.setImgs(pic);
		goodVo.setMainPic(mainPic);
		return goodVo;
	}
	
	/**
	 * 将Good实体转化为simpleGoodVo.
	 * @param good good实体
	 * @return simpleGoodVo
	 */
	private SimpleGoodVo convertToSimpleGood(final Good good) {
		SimpleGoodVo sgVo = new SimpleGoodVo();
		int id = good.getId();
		int shopId = good.getShopId();
		String name = good.getName();
		double price = good.getPrice();
		String img = pictureDao.getMainPic(id).getFile();
		sgVo.setGoodId(id);
		sgVo.setSellerId(shopId);
		sgVo.setName(name);
		sgVo.setImg(img);
		sgVo.setPrice(price);	
		return sgVo;
	}
	
	/**
	 * 将GoodVo转化为good实体.
	 * @param goodVo GoodVo
	 * @return good实体
	 */
	private Good convertToGood(final GoodVo goodVo) {
		Good good = new Good();
		int id = goodVo.getGoodId();
		int kindId = goodVo.getKindId();
		int shopId = goodVo.getSellerId();
		String name = goodVo.getName();
		String goodNum = goodVo.getGoodNum();
		String description = goodVo.getDescription();
		double price = goodVo.getPrice();
		String deliverInfo = goodVo.getDeliverInfo();
		String returnInfo = goodVo.getReturnInfo();
		Date time = goodVo.getTime();
		good.setId(id);
		good.setKindId(kindId);
		good.setShopId(shopId);
		good.setName(name);
		good.setGoodNum(goodNum);
		good.setDescription(description);
		good.setPrice(price);
		good.setDeliverInfo(deliverInfo);
		good.setReturnInfo(returnInfo);
		good.setTime(time);
		return good;
	}
	
	/**
	 * 将字符串数组转化为Picture实体列表.
	 * @param goodVo goodVo
	 * @return Picture实体列表
	 */
	private List<Picture> convertToPic(final GoodVo goodVo) {
		List<Picture> pics = new ArrayList<Picture>();
		int goodId = goodVo.getGoodId();
		String[] imgs = goodVo.getImgs();
		int num = imgs.length;
		for (int i = 0; i < num; i++) {
			Picture pic = new Picture();
			pic.setGoodId(goodId);
			pic.setFile(imgs[i]);
			pic.setIsMain("false");
			pics.add(pic);
		}
		return pics;
	}
	
	/**
	 * 将字符串转化为Picture实体.
	 * @param goodVo goodVo
	 * @return Picture实体
	 */
	private Picture convertToMainPic(final GoodVo goodVo) {
		Picture pic = new Picture();
		String mainPic = goodVo.getMainPic();
		int goodId = goodVo.getGoodId();
		pic.setGoodId(goodId);
		pic.setFile(mainPic);
		pic.setIsMain("true");
		return pic;
	}
	
	/**
	 * 将stockVo转化为stock实体.
	 * @param stockVo stockVo
	 * @return stock实体
	 */
	private Stock convertToStock(final StockVo stockVo) {
		Stock stock = new Stock();
		int goodId = stockVo.getGoodId();
		String size = stockVo.getSize();
		String color = stockVo.getColor();
		int quantity = stockVo.getQuantity();
		stock.setGoodId(goodId);
		stock.setSize(size);
		stock.setColor(color);
		stock.setQuantity(quantity);
		return stock;
	}
	
	/**
	 * 将commentVo转化为comment实体.
	 * @param commentVo commentVo
	 * @return comment实体
	 */
	private Comment convertToComment(final CommentVo commentVo) {
		Comment comment = new Comment();
		int id = commentVo.getCommentId();
		int userId = commentVo.getUserId();
		int goodId = commentVo.getGoodId();
		int score = comment.getScore();
		String content = commentVo.getComment();
		Date time = commentVo.getTime();
		comment.setGoodId(id);
		comment.setGoodId(goodId);
		comment.setUserId(userId);
		comment.setScore(score);
		comment.setContent(content);
		comment.setTime(time);
		return comment;
	}
	
	/**
	 * 将consultVo转化为consult实体.
	 * @param consultVo consultVo
	 * @return consult实体
	 */
	private Consult convertToConsult(final ConsultVo consultVo) {
		Consult consult = new Consult();
		int id = consultVo.getConsultId();
		int userId = consultVo.getUserId();
		int goodId = consultVo.getGoodId();
		String content = consultVo.getConsult();
		Date time = consultVo.getTime();
		consult.setGoodId(id);
		consult.setGoodId(goodId);
		consult.setUserId(userId);
		consult.setContent(content);
		consult.setTime(time);
		return consult;
	}
	
	/**
	 * 将commentVo转化为subComment实体.
	 * @param commentVo commentVo
	 * @return subComment实体
	 */
	private SubComment convertToSubComment(final CommentVo commentVo) {
		SubComment subComment = new SubComment();
		int id = commentVo.getCommentId();
		int userId = commentVo.getUserId();
		int goodId = commentVo.getGoodId();
		int commentId = commentVo.getFatherComment().getCommentId();
		String content = commentVo.getComment();
		Date time = commentVo.getTime();
		subComment.setGoodId(id);
		subComment.setGoodId(goodId);
		subComment.setUserId(userId);
		subComment.setCommentId(commentId);
		subComment.setContent(content);
		subComment.setTime(time);
		return subComment;
	}
	
	/**
	 * 将consultVo转化为subConsult实体.
	 * @param consultVo consultVo
	 * @return subConsult实体
	 */
	private SubConsult convertToSubConsult(final ConsultVo consultVo) {
		SubConsult subConsult = new SubConsult();
		int id = consultVo.getConsultId();
		int userId = consultVo.getUserId();
		int goodId = consultVo.getGoodId();
		int consultId = consultVo.getFatherConsult().getConsultId();
		String content = consultVo.getConsult();
		Date time = consultVo.getTime();
		subConsult.setGoodId(id);
		subConsult.setGoodId(goodId);
		subConsult.setUserId(userId);
		subConsult.setConsultId(consultId);
		subConsult.setContent(content);
		subConsult.setTime(time);
		return subConsult;
	}
	
	/**
	 * 将comment实体转化为CommentVo.
	 * @param comment comment实体
	 * @return CommentVo
	 */
	private CommentVo convertToCommentVo(final Comment comment) {
		CommentVo commentVo = new CommentVo();
		int id = comment.getId();
		int goodId = comment.getGoodId();
		int userId = comment.getUserId();
		int score = comment.getScore();
		String content = comment.getContent();
		Date time = comment.getTime();
		commentVo.setCommentId(id);
		commentVo.setGoodId(goodId);
		commentVo.setUserId(userId);
		commentVo.setScore(score);
		commentVo.setComment(content);
		commentVo.setTime(time);
		return commentVo;
	}
	
	/**
	 * 将consult实体转化为ConsultVo.
	 * @param consult consult实体
	 * @return ConsultVo
	 */
	private ConsultVo convertToConsultVo(final Consult consult) {
		ConsultVo consultVo = new ConsultVo();
		int id = consult.getId();
		int goodId = consult.getGoodId();
		int userId = consult.getUserId();
		String content = consult.getContent();
		Date time = consult.getTime();
		consultVo.setConsultId(id);
		consultVo.setGoodId(goodId);
		consultVo.setUserId(userId);
		consultVo.setConsult(content);
		consultVo.setTime(time);
		return consultVo;
	}
}
