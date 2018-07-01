package com.honeypotato.security.auth.common.constants;

/**
 * Created by Lenovo on 2018/7/2.
 */
public class CommonConstants {

    public static final String RESOURCE_TYPE_MENU = "menu";
    public static final String RESOURCE_TYPE_BTN = "button";
    public static final int EX_TOKEN_ERROR_CODE = 40401;

    /*用户token异常*/
    public static final int EX_USER_INVALID_CODE = 40102;
    /*客户端token异常*/
    public static final int EX_CLIENT_INVALID__CODE = 40131;
    public static final int EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final int EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";

}
