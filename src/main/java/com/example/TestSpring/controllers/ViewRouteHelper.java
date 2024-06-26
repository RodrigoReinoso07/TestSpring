package com.example.TestSpring.controllers;

public class ViewRouteHelper {

	// Home Helper

	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";

	

	// Degree Helper

	public final static String DEGREE_FORM = "degree/form";
	public final static String DEGREE_NEW = "degree/new";
	public final static String DEGREE_INDEX = "degree/index";
	
	//PERSON
	public final static String PERSON_INDEX = "person/index";
	public final static String PERSON_NEW = "person/new";
	public final static String PERSON_UPDATE = "person/update";
	public final static String PERSON_PARTIAL_VIEW = "person/partialPersonView";

	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	
	//Redirects
	public static final String DEGREE_ROOT = "/degrees/";
	public final static String ROUTE_INDEX = "/index";
	public final static String PERSON_ROOT = "/index";
}
