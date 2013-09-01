package com.demo.utils;

/**
 * Created by IntelliJ IDEA.
 * User: zhangb
 * Date: Jun 4, 2009
 * Time: 3:32:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Constants {

    public static final int PAGE_SIZE = 10;
    public static final String UPLOAD_FILE_PATH_TMP = "upload/file/tmp";
    public static final String UPLOAD_USER_PATH = "upload/user";


    public static final int BUFFER_SIZE = 6 * 1024;



    /* ----------------------Session variable-----------------------------*/
    public static final String SESSION_USER_ID = "userID";
    public static final String SESSION_USER_NICKNANE = "nickName";
    public static final String SESSION_USER_EMAIL = "email";
    public static final String SESSION_USER_LOGO_URL = "userLogoUrl";
    public static final String SESSION_OPEN_ID = "openId";
    public static final String SESSION_FEATURE_URL = "featureUrl";
    public static final String SESSION_COMMUNITY_ID = "communityId";





    public static final String DEFAULT_PERSON_IMAGE = "images/defaultImgs/portrait.png";           //person



    public static final String ACTION_SUFFIX = "Action";
    public static final String ACTION_PACKAGE="com.demo.action";
    public static final String ACTION_METHOD_SPLIT="!";
    public static final String ACTION_METHOD_DEFAULT ="index";
    public static final String ACTION_RESULT_DEFAULT="/product-index.jsp:";
    public static final String ACTION_RESULT_REDIRECT="redirect:";
    public static final String ACTION_RESULT_SPLIT=":";
    public static final String ACTION_DEFAULT ="product";


    public static final String BASIC_PACKAGE = "basic-package";
    public static final String BASE_NAME_SPACE = "/";
    public static final String RESULT_JSON = "json";
    public static final String RESULT_NAME_TILES = "tiles";
    public static final String RESULT_NAME_REDIRECT_ACTION = "redirectAction";
    public static final String RESULT_CHAIN_ACTION = "chain";
}

