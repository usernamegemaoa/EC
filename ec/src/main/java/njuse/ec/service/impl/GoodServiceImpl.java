package njuse.ec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import njuse.ec.dao.BaseDao;
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
	 * good base dao.
	 */
	@Autowired
	private BaseDao<Good> goodBaseDao;
	
	/**
	 * stock base dao.
	 */
	@Autowired
	private BaseDao<Stock> stockBaseDao;
	
	/**
	 * picture base dao.
	 */
	@Autowired
	private BaseDao<Picture> pictureBaseDao;
	
	/**
	 * 每页最多显示20个商品.
	 */
	private final int perPage = 20;
	
	/**
	 * 每页最多显示10个同类热销.
	 */
	private final int perHot = 10;

	@Override
	public final List<KindVo> getFatherKind() {
		List<KindVo> fatherKindVo = new ArrayList<KindVo>();
		try {
			List<Kind> fatherKind = kindDao.getFatherKinds();
			for (int i = 0; i < fatherKind.size(); i++) {
				Kind kind = fatherKind.get(i);
				KindVo kindVo = convertToKindVo(kind);
				fatherKindVo.add(kindVo);
			}
			return fatherKindVo;
		} catch (Exception e) {
			e.printStackTrace();
			return fatherKindVo;
		}
	}

	@Override
	public final List<KindVo> getSonKind(final KindVo kind) {
		List<KindVo> sonKindVo = new ArrayList<KindVo>();
		int fatherId = kind.getKindId();
		try {
			List<Kind> sonKind = kindDao.getSonKinds(fatherId);
			for (int i = 0; i < sonKind.size(); i++) {
				Kind k = sonKind.get(i);
				KindVo kindVo = convertToKindVo(k);
				sonKindVo.add(kindVo);
			}
			return sonKindVo;
		} catch (Exception e) {
			e.printStackTrace();
			return sonKindVo;
		}
	}

	@Override
	public final int getLatestGoodPages() {
		int num = goodDao.getLatestGoodNum();
		if (num % perPage == 0) {
			return num / perPage;
		} else {
			return num / perPage + 1;
		}
	}

	@Override
	public final List<SimpleGoodVo> getLatestGood(final int page) {
		List<SimpleGoodVo> latestGoodVo = new ArrayList<SimpleGoodVo>();
		int firstResult = page * perPage;
		int maxResult = perPage;
		try {
			List<Good> latestGood = goodDao.getLatestGoods(firstResult, maxResult);
			for (int i = 0; i < latestGood.size(); i++) {
				Good good = latestGood.get(i);
				SimpleGoodVo sgVo = convertToSimpleGood(good);
				latestGoodVo.add(sgVo);
			}
			return latestGoodVo;
		} catch (Exception e) {
			e.printStackTrace();
			return latestGoodVo;
		}
	}

	@Override
	public final int getKindGoodPages(final KindVo kind) {
		int kindId = kind.getKindId();
		int num = goodDao.getKindGoodNum(kindId);
		if (num % perPage == 0) {
			return num / perPage;
		} else {
			return num / perPage + 1;
		}
	}

	@Override
	public final List<SimpleGoodVo> 
	getKindGood(final KindVo kind, final int page) {
		int kindId = kind.getKindId();
		List<SimpleGoodVo> kindGoodVo = new ArrayList<SimpleGoodVo>();
		int firstResult = page * perPage;
		int maxResult = perPage;

		try {
			List<Good> kindGoods = goodDao.getKindGoods(kindId, firstResult, maxResult);
			for (int i = 0; i < kindGoods.size(); i++) {
				Good good = kindGoods.get(i);
				SimpleGoodVo sgVo = convertToSimpleGood(good);
				kindGoodVo.add(sgVo);
			}
			return kindGoodVo;
		} catch (Exception e) {
			e.printStackTrace();
			return kindGoodVo;
		}
	}

	@Override
	public final int getSearchGoodPages(final String search) {
		int num = goodDao.getNameGoodNum(search);
		if (num % perPage == 0) {
			return num / perPage;
		} else {
			return num / perPage + 1;
		}
	}

	@Override
	public final List<SimpleGoodVo> 
		getSearchGood(final String search, final int page) {
		List<SimpleGoodVo> searchGoodVo = new ArrayList<SimpleGoodVo>();
		int firstResult = page * perPage;
		int maxResult = perPage;

		try {
			List<Good> searchGoods = goodDao.getNameGoods(search, firstResult, maxResult);
			for (int i = 0; i < searchGoods.size(); i++) {
				Good good = searchGoods.get(i);
				SimpleGoodVo sgVo = convertToSimpleGood(good);
				searchGoodVo.add(sgVo);
			}
			return searchGoodVo;
		} catch (Exception e) {
			e.printStackTrace();
			return searchGoodVo;
		}
	}

	@Override
	public final GoodVo getDetailGood(final int goodId) {
		GoodVo goodVo = new GoodVo();
		Good good;
		try {
			good = goodDao.getGood(goodId);
			goodVo = convertToGoodVo(good);
		} catch (Exception e) {
			return null;
		}
		List<Stock> stocks = stockBaseDao.findlist(
				Stock.class, 
				"goodId", 
				String.valueOf(good.getId()));
		goodVo.setStocks(new ArrayList<StockVo>());
		Iterator<Stock> si = stocks.iterator();
		while (si.hasNext()) {
			Stock s = si.next();
			goodVo.getStocks().add(convertToStockVo(s));
		}
		return goodVo;
	}

	@Override
	public final List<SimpleGoodVo> getHotGood(final int goodId) {
		List<SimpleGoodVo> hotGoodVo = new ArrayList<SimpleGoodVo>();
		Good good = goodDao.getGood(goodId);
		KindVo vo = new KindVo();
		vo.setKindId(good.getKindId());
		hotGoodVo.addAll(getKindGood(vo, 0));
		return hotGoodVo;

		/*int firstResult = 0;
		int maxResult = perHot;
		try {
			List<Hot> hotGood = hotDao.getHot(goodId, firstResult, maxResult);
			for (int i = 0; i < hotGood.size(); i++) {
				Hot hot = hotGood.get(i);
				int id = hot.getSecondId();
				Good good = goodDao.getGood(id);
				SimpleGoodVo sgVo = convertToSimpleGood(good);
				hotGoodVo.add(sgVo);
			}
			return hotGoodVo;
		} catch (Exception e) {
			e.printStackTrace();
			return hotGoodVo;
		}*/
	}

	@Override
	public final ResultVo 
	addGood(final GoodVo goodVo, final List<StockVo> stockVos) {
		ResultVo addGoodResult = new ResultVo();
		Good good = convertToGood(goodVo);
		try {
			int id = goodDao.addGood(good);
			List<Picture> pics = convertToPic(goodVo);
			for (int i = 0; i < pics.size(); i++) {
				Picture pic = pics.get(i);
				pic.setGoodId(id);
				pictureDao.addPic(pic);
			}
			Picture mainPic = convertToMainPic(goodVo);
			mainPic.setGoodId(id);
			pictureDao.addPic(mainPic);
			for (int i = 0; i < stockVos.size(); i++) {
				Stock stock = convertToStock(stockVos.get(i));
				stock.setGoodId(id);
				stockDao.addStock(stock);
			}
			addGoodResult.setResultCode(0);
			addGoodResult.setResultMessage("商品添加成功！");
			return addGoodResult;
		} catch (Exception e) {
			e.printStackTrace();
			addGoodResult.setResultCode(1);
			addGoodResult.setResultMessage("商品添加失败！");
			return addGoodResult;
		}
	}

	@Override
	public final ResultVo 
	addGoodConsult(final int goodId, final ConsultVo consultVo) {
		ResultVo addGoodConsultResult = new ResultVo();
		try {
			if (consultVo.getFatherConsult() != 0) {
				SubConsult consult = convertToSubConsult(consultVo);
				subConsultDao.addSubConsult(consult);
			} else {
				Consult consult = convertToConsult(consultVo);
				consultDao.addConsult(consult);
			}
			addGoodConsultResult.setResultCode(0);
			addGoodConsultResult.setResultMessage("咨询添加成功");
			return addGoodConsultResult;
		} catch (Exception e) {
			e.printStackTrace();
			addGoodConsultResult.setResultCode(1);
			addGoodConsultResult.setResultMessage("咨询添加失败");
			return addGoodConsultResult;
		}
	}

	@Override
	public final ResultVo 
	addGoodComment(final int goodId, final CommentVo commentVo) {
		ResultVo addGoodCommentResult = new ResultVo();
		try {
			if (commentVo.getFatherComment() != 0) {
				SubComment comment = convertToSubComment(commentVo);
				subCommentDao.addSubComment(comment);
			} else {
				Comment comment = convertToComment(commentVo);
				commentDao.addComment(comment);
			}
			addGoodCommentResult.setResultCode(0);
			addGoodCommentResult.setResultMessage("评论添加成功");
			return addGoodCommentResult;
		} catch (Exception e) {
			e.printStackTrace();
			addGoodCommentResult.setResultCode(1);
			addGoodCommentResult.setResultMessage("评论添加失败");
			return addGoodCommentResult;
		}
	}

	@Override
	public final int getConsultPages(final int goodId) {
		int num = consultDao.getConsultNum(goodId);
		if (num % perPage == 0) {
			return num / perPage;
		} else {
			return num / perPage + 1;
		}
	}

	@Override
	public final int getCommentPages(final int goodId) {
		int num = commentDao.getCommentNum(goodId);
		if (num % perPage == 0) {
			return num / perPage;
		} else {
			return num / perPage + 1;
		}
	}

	@Override
	public final List<ConsultVo> 
	getConsults(final int goodId, final int pages) {
		List<ConsultVo> consultsVo = new ArrayList<ConsultVo>();
		int firstResult = pages * perPage;
		int maxResult = perPage;

		try {
			List<Consult> consults = consultDao.getConsults(goodId, firstResult, maxResult);
			for (int i = 0; i < consults.size(); i++) {
				Consult consult = consults.get(i);
				ConsultVo consultVo = convertToConsultVo(consult);
				consultsVo.add(consultVo);
			}
			return consultsVo;
		} catch (Exception e) {
			e.printStackTrace();
			return consultsVo;
		}
	}

	@Override
	public final List<CommentVo> 
	getComments(final int goodId, final int pages) {
		List<CommentVo> commentsVo = new ArrayList<CommentVo>();
		int firstResult = pages * perPage;
		int maxResult = perPage;

		try {
			List<Comment> comments = commentDao.getComments(goodId, firstResult, maxResult);
			for (int i = 0; i < comments.size(); i++) {
				Comment comment = comments.get(i);
				CommentVo commentVo = convertToCommentVo(comment);
				commentsVo.add(commentVo);
			}
			return commentsVo;
		} catch (Exception e) {
			e.printStackTrace();
			return commentsVo;
		}
	}
	
	@Override
	public final List<CommentVo> getSonComments(final int commentId) {
		List<CommentVo> sonCommentVo = new ArrayList<CommentVo>();

		try {
			List<SubComment> sonComments = subCommentDao.getSubComments(commentId);
			for(int i = 0; i < sonComments.size(); i++) {
				SubComment subComment = sonComments.get(i);
				CommentVo commentVo = convertToCommentVo(subComment);
				sonCommentVo.add(commentVo);
			}
			return sonCommentVo;
		} catch (Exception e) {
			e.printStackTrace();
			return sonCommentVo;
		}
	}

	@Override
	public final List<ConsultVo> getSonConsults(final int consultId) {
		List<ConsultVo> sonConsultVo = new ArrayList<ConsultVo>();

		try {
			List<SubConsult> sonConsults = subConsultDao.getSubConsults(consultId);
			for(int i = 0; i < sonConsults.size(); i++) {
				SubConsult subConsult = sonConsults.get(i);
				ConsultVo consultVo = convertToConsultVo(subConsult);
				sonConsultVo.add(consultVo);
			}
			return sonConsultVo;
		} catch (Exception e) {
			e.printStackTrace();
			return sonConsultVo;
		}
	}
	
	@Override
	public KindVo getKind(int kindId) {
		KindVo kindVo = new KindVo();
		Kind kind = new Kind();
		try {
			kind = kindDao.getKind(kindId);
			kindVo = convertToKindVo(kind);
			return kindVo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
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
		String returnInfo = good.getReturnInfo();
		Date date = good.getTime();
		List<Picture> pics = pictureDao.getPics(id);
		ArrayList<String> stpics = new ArrayList<String>();
		for (int i = 0; i < pics.size(); i++) {
			stpics.add(pics.get(i).getFile());
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
		goodVo.setImgs(stpics);
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
		ArrayList<String> imgs = goodVo.getImgs();
		for (int i = 0; i < imgs.size(); i++) {
			Picture pic = new Picture();
			pic.setGoodId(goodId);
			pic.setFile(imgs.get(i));
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
		int goodId = goodVo.getGoodId();
		String mainPic = goodVo.getMainPic();
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
	 * stock -> stockVo.
	 * @param stock stock
	 * @return stockVo
	 */
	private StockVo convertToStockVo(final Stock stock) {
		StockVo stockVo = new StockVo();
		stockVo.setColor(stock.getColor());
		stockVo.setGoodId(stock.getGoodId());
		stockVo.setId(stock.getId());
		stockVo.setQuantity(stock.getQuantity());
		stockVo.setSize(stock.getSize());
		return stockVo;
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
		comment.setId(id);
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
		int commentId = commentVo.getFatherComment();
		String content = commentVo.getComment();
		Date time = commentVo.getTime();
		subComment.setId(id);
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
		int consultId = consultVo.getFatherConsult();
		String content = consultVo.getConsult();
		Date time = consultVo.getTime();
		subConsult.setId(id);
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
	
	/**
	 * model to vo.
	 * @param subComment model
	 * @return vo
	 */
	private CommentVo convertToCommentVo(final SubComment subComment) {
		CommentVo commentVo = new CommentVo();
		int id = subComment.getId();
		int userId = subComment.getUserId();
		int fatherId = subComment.getCommentId();
		String content = subComment.getContent();
		Date time = subComment.getTime();
		commentVo.setCommentId(id);
		commentVo.setUserId(userId);
		commentVo.setFatherComment(fatherId);
		commentVo.setComment(content);
		commentVo.setTime(time);
		return commentVo;
	}
	
	/**
	 * model to vo.
	 * @param subConsult model
	 * @return vo
	 */
	private ConsultVo convertToConsultVo(final SubConsult subConsult) {
		ConsultVo consultVo = new ConsultVo();
		int id = subConsult.getId();
		int userId = subConsult.getUserId();
		int fatherId = subConsult.getConsultId();
		String content = subConsult.getContent();
		Date time = subConsult.getTime();
		consultVo.setConsultId(id);
		consultVo.setUserId(userId);
		consultVo.setFatherConsult(fatherId);
		consultVo.setConsult(content);
		consultVo.setTime(time);
		return consultVo;
	}

	@Override
	public final List<GoodVo> getShopGood(final int shopId) {
		List<Good> goods = goodBaseDao.findlist(
				Good.class, 
				"shopId", 
				String.valueOf(shopId));
		List<GoodVo> goodVos = new ArrayList<GoodVo>();
		Iterator<Good> i = goods.iterator();
		while (i.hasNext()) {
			Good good = i.next();
			GoodVo vo = convertToGoodVo(good);
			List<Stock> stocks = stockBaseDao.findlist(
					Stock.class, 
					"goodId", 
					String.valueOf(good.getId()));
			vo.setStocks(new ArrayList<StockVo>());
			Iterator<Stock> si = stocks.iterator();
			while (si.hasNext()) {
				Stock s = si.next();
				vo.getStocks().add(convertToStockVo(s));
			}
			goodVos.add(vo);
		}
		return goodVos;
	}

	@Override
	public final ResultVo modifyGood(final GoodVo goodVo) {
		ResultVo result = new ResultVo();
		try {
			Good good = convertToGood(goodVo);
			goodBaseDao.update(good);
			Iterator<StockVo> i = goodVo.getStocks().iterator();
			while (i.hasNext()) {
				StockVo vo = i.next();
				Stock stock = stockBaseDao.load(Stock.class, vo.getId());
				if (stock == null) {
					stock = new Stock();
					stock.setColor(vo.getColor());
					stock.setGoodId(goodVo.getGoodId());
					stock.setQuantity(vo.getQuantity());
					stock.setSize(vo.getSize());
					stockBaseDao.save(stock);
				} else {
					stock.setColor(vo.getColor());
					stock.setQuantity(vo.getQuantity());
					stock.setSize(vo.getSize());
					stockBaseDao.update(stock);
				}
			}
			for (String pic:goodVo.getImgs()) {
				Picture picture = pictureBaseDao.find(
						Picture.class, 
						"name", 
						pic);
				if (picture == null) {
					picture = new Picture();
					picture.setFile(pic);
					picture.setGoodId(goodVo.getGoodId());
					picture.setIsMain("false");
					pictureDao.addPic(picture);
				}
			}
			result.setResultCode(0);
			result.setResultMessage("修改成功");
		} catch (Exception e) {
			result.setResultCode(1);
			result.setResultMessage("修改失败");
			e.printStackTrace();
		}
		return result;
	}
}
