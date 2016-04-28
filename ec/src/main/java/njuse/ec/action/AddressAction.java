package njuse.ec.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import njuse.ec.service.PlaceService;
import njuse.ec.service.UserService;
import njuse.ec.vo.AddressVo;
import njuse.ec.vo.KindVo;
import njuse.ec.vo.PlaceVo;
import njuse.ec.vo.UserVo;

@Repository
public class AddressAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7386156973597624589L;

	@Autowired
	private UserService userService;
	@Autowired
	private PlaceService placeService;
	private List<AddressVo> addressList;
	private List<PlaceVo> cityList;
	private List<PlaceVo> districtList;
	private List<PlaceVo> provinceList;
	private UserVo userVo;
	private int provinceId;
	private int cityId;
	private int placeCode;
	private String placeName;
	private Map<String, Object> jsonResult;
	private String people;
	private String phone;
	


	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String execute(){
		return SUCCESS;
	}
	
	public String addAddress(){
		System.out.println("TEST +++++++++++++++ADDRESS");
		AddressVo newAddress=new AddressVo();
		newAddress.setPeople(people);
		newAddress.setPhone(phone);
		newAddress.setPlaceCode(placeCode);
		newAddress.setPlaceName(placeName);
		addressList.add(newAddress);
		int userId=0;
		if (getSession().containsKey("userId")) {
		userId = (int) getSession().get("userId");
		}
		userVo=userService.userInfo(userId);
		userVo.setAddressVoList(addressList);
		userService.modify(userVo);
		return SUCCESS;
	}
	
	public String getAddress(){
		provinceList=placeService.getProvince();
		cityList=placeService.getCity(110000);
		int userId=0;
		if (getSession().containsKey("userId")) {
		userId = (int) getSession().get("userId");
		System.out.println(userId);}
		userVo=userService.userInfo(userId);
		setAddressList(userVo.getAddressVoList());
		return SUCCESS;
	}
	
	public String getCity() {
		jsonResult = new HashMap<String, Object>();
		cityList = placeService.getCity(provinceId);
		cityId=cityList.get(0).getPlaceCode();
		districtList=placeService.getDistrict(cityId);
		System.out.println(provinceId);
		jsonResult.put("cityList", cityList);
		jsonResult.put("districtList", districtList);
		return SUCCESS;
	}
	
	public String getDistrict(){
		jsonResult = new HashMap<String, Object>();
		districtList = placeService.getDistrict(cityId);
		System.out.println(cityId);
		jsonResult.put("districtList", districtList);
		return SUCCESS;
	}
	
	
	public String deleteAddress(){
		return SUCCESS;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public List<AddressVo> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressVo> addressList) {
		this.addressList = addressList;
	}

	public List<PlaceVo> getCityList() {
		return cityList;
	}

	public void setCityList(List<PlaceVo> cityList) {
		this.cityList = cityList;
	}

	public List<PlaceVo> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<PlaceVo> districtList) {
		this.districtList = districtList;
	}

	public List<PlaceVo> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<PlaceVo> provinceList) {
		this.provinceList = provinceList;
	}

	public int getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(int placeCode) {
		this.placeCode = placeCode;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
}
