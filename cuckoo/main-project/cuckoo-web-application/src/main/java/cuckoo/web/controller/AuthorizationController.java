package cuckoo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cuckoo.web.service.AuthorizationService;

@Controller
public class AuthorizationController implements ErrorController {

	@Autowired
	AuthorizationService authorizationService;

	@Override
	@RequestMapping("/error")
	@ResponseBody
	public String getErrorPath() {
		return "<center><h1>Something went wrong</h1></center>";
	}

}
