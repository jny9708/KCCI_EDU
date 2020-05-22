package ita.framework.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ITAController {
	public static final String SEND_REDIRECT = "direct:";
	public NextPage execute(HttpServletRequest request, Map model) throws Exception;
}
