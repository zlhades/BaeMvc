<%@ page language="java" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:wb="http://open.weibo.com/wb">
    <head>
        <link href="favicon.ico" rel="icon" type="image/x-icon" />
        <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <title>
           DEMO
        </title>
        <style type="text/css">
            #together{
                width:100%;
                min-height: 100%;
                height: auto !important;
                height: 100%;
                margin: 0 auto -120px;
            }
            #ggw_footer_transition{
                height: 120px;
            }
            #ggw_footer{
                width: 100%;
                margin: 0 auto;
                height: 120px;
            }
            .ggw_tile{float:left;width: 100%;position: relative;}


        </style>

        <META content="MSHTML 6.00.2800.1106" name=GENERATOR>
        <%@ include file="jsp/layout/includeForLayOut.jsp" %>
    </head>

    <body>

        <div id="together">
                <div id="ggw_header" class="ggw_tile"><jsp:include page="/jsp/layout/header.jsp" /> </div>
            <div id="ggw_userheader" class="ggw_tile" style="z-index: 5;">
                <jsp:include page="/jsp/layout/userheader.jsp" />
            </div>
            <div id="ggw_content" class="ggw_tile" style="z-index: 0;"><jsp:include page="${contentPageJsp}"/></div>
            <div id="ggw_footer_transition" class="ggw_tile"></div>
        </div>
        <div id="ggw_footer"><jsp:include page="/jsp/layout/footer.jsp"/></div>

    </body>
</html>
