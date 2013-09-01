<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/tiles-jsp.tld" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link href="favicon.ico" rel="icon" type="image/x-icon" />
            <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <title>
            DEMO
        </title>
        <%@ include file="includeForLayOut.jsp" %>
        <style type="text/css">
             .together{width:1024px;margin: 0 auto;}
             .together_inner{float:left;width:1024px;background: #fff;}
            .allthiediv{width:1000px;margin: 0 auto;}
             html {
                 font: 12px/1 Arial, Helvetica, "\5FAE\8F6F\96C5\9ED1","\5b8b\4f53", sans-serif;
                 height: 100%;
             }
        </style>
    </head>

    <body>
        <div class="together">
            <div class="together_inner">
                <div class="allthiediv"><tiles:insertAttribute name="header"/></div>
                <div class="allthiediv"><tiles:insertAttribute name="right"/></div>
                <div class="allthiediv"><tiles:insertAttribute name="bottom"/></div>
            </div>
        </div>



        </div>
    </body>
</html>
