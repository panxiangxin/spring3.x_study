package com.baobaotao.web;

import com.baobaotao.UserService;
import com.baobaotao.domain.User;
import com.google.inject.internal.cglib.proxy.$FixedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author pxx
 * Date 2020/2/2 11:34
 * @Description
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView createUser(User user) {
		userService.createUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/createSuccess");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping("/{userId}")
	public ModelAndView showDetail(@PathVariable("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/showDetail");
		modelAndView.addObject("user", userService.getUserById(userId));
		return modelAndView;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST, params = "userId")
	public String test1(@RequestParam("userId") String userId) {
		return "user/test1";
	}
	
	@RequestMapping(value = "show", headers = "content-type=text/*")
	public String test2(@RequestParam("userId") String userId) {
		return "user/test2";
	}
	
	// ①请求参数按名称匹配的方式绑定到方法入参中，方法返回对应的字符串代表逻辑视图名
	@RequestMapping(value = "/handle1")
	public String handle1(@RequestParam("userName") String userName,
						  @RequestParam("password") String password,
						  @RequestParam("realName") String realName) {
		return "success";
	}
	
	// ②将Cooke值及报文头属性绑定到入参中、方法返回ModelAndView
	@RequestMapping(value = "/handle2")
	public ModelAndView handle2(@CookieValue("JSESSIONID") String sessionId,
								@RequestHeader("Accept-Language") String accpetLanguage) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		mav.addObject("user", new User());
		return mav;
	}
	
	// ③请求参数按名称匹配的方式绑定到user的属性中、方法返回对应的字符串代表逻辑视图名
	@RequestMapping(value = "/handle3")
	public String handle3(User user) {
		return "success";
	}
	
	// ④直接将HTTP请求对象传递给处理方法、方法返回对应的字符串代表逻辑视图名
	@RequestMapping(value = "/handle4")
	public String handle4(HttpServletRequest request) {
		return "success";
	}
	
	
	@RequestMapping(value = "/handler41")
	public String handler41(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/handler42/{imageId}")
	public byte[] handler42(@PathVariable("imageId") String imageId) throws IOException {
		System.out.println("load iamge of" + imageId);
		Resource resource = new ClassPathResource("image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
		return fileData;
	}
	
	@RequestMapping(value = "/handler43")
	public String handler43(HttpEntity<String> httpEntity) {
		long contentLen = httpEntity.getHeaders().getContentLength();
		System.out.println(httpEntity.getBody());
		return "success";
	}
	
	@RequestMapping(value = "/handler44/{imageId}")
	public ResponseEntity<byte[]> handler44(@PathVariable("imageId") String imageId) throws IOException {
		Resource resource = new ClassPathResource("image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping(value = "/handler51")
	public HttpEntity<User> handler51(HttpEntity<User> requestEntity) {
		User user = requestEntity.getBody();
		user.setUserId("1000");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@ModelAttribute("user")
	public User getUser() {
		User user = new User();
		user.setUserId("1001");
		user.setUserName("<>");
		return user;
	}
	
	@RequestMapping(value = "/handler81")
	public String handler81(@RequestParam("user") User user, ModelMap modelMap) {
		modelMap.put("user", user);
		System.out.println(user);
		return "/user/showUser";
	}
	@RequestMapping(value = "/handler82",method = RequestMethod.POST)
	public String handle82(User user) {
		System.out.println(user);
		return "/user/showUser";
	}
	@RequestMapping(value = "/register3")
	public String register3() {
		return "/user/register3";
	}
	
	@RequestMapping(value = "/handle91")
	public String handle91(@Valid @ModelAttribute("user") User user,
						   BindingResult bindingResult, ModelMap mm) {
		System.out.println(bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			return "/user/register3";
		} else {
			return "/user/showUser";
		}
	}
	
	
	@RequestMapping(value = "/showUserList")
	public String showUserList(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "user/userList";
	}
	
	@RequestMapping(value = "/showUserListByFtl")
	public String showUserListInFtl(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListFtl";
	}
	
	@RequestMapping(value = "/showUserListByXls")
	public String showUserListInExcel(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListExcel";
	}
	
	@RequestMapping(value = "/showUserListByPdf")
	public String showUserListInPdf(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListPdf";
	}
	
	@RequestMapping(value = "/showUserListByXml")
	public String showUserListInXml(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListXml";
	}
	
	@RequestMapping(value = "/showUserListByJson")
	public String showUserListInJson(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListJson";
	}
	
	@RequestMapping(value = "/showUserListByJson1")
	public String showUserListInJson1(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆1");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListJson1";
	}
	
	@RequestMapping(value = "/showUserListByI18n")
	public String showUserListInI18n(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆1");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListi18n";
	}
	
	@RequestMapping(value = "/showUserListMix")
	public String showUserListMix(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆1");
		calendar.set(1980, 1, 1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListMix";
	}
	
}
