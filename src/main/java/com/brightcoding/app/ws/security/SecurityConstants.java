package com.brightcoding.app.ws.security;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 1800000000; // 30mins
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/users";
	public static final String TOKEN_SECRET = "926D96C90030DD58429D2751AC1BDBBC";
}
