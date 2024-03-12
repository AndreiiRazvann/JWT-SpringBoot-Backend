package com.getarrays.project3.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 432_000_000;  //5 days expressed in miliseconds
    public static final String TOKEN_PREFIX = "Bearer "; // who has this token, it is not required for any further checks
    public static final String JWT_TOKEN_HEADER = "Jwt-Token"; //attach the token to the http header
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String ANDREI_WAS_HERE = "Andrei Was Here, INC"; //provided by
    public static final String ANDREI_ADMINISTRATION = "User Management Portal"; //token issued for who?
    public static final String AUTHORITIES = "Authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/user/resetpassword/**", "/user/image/**" };
//    public static final String[] PUBLIC_URLS = { "**" };
}
