package com.baobaotao.web;


import com.baobaotao.domain.UserEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.baobaotao.domain.User;


/**
 * @author www72
 */
public class MyBindingInitializer implements WebBindingInitializer{
  public void initBinder(WebDataBinder binder, WebRequest request) {
	  binder.registerCustomEditor(User.class, new UserEditor());
   }
}