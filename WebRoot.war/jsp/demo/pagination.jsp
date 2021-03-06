<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="struts-tags.tld" %>
<%@ taglib uri="/WEB-INF/tld/tiles-jsp.tld" prefix="tiles" %>

<tiles:useAttribute name="pagination" classname="com.demo.domain.Pagination"/>

<link rel="stylesheet" href="css/pagination.css" />

<table class="pagination">
    <tr>
        <td>
            <s:if test="pagination.hasPre">
                <s:url id="url_pre" action="%{pagination.actionName}">
                    <s:param name="pagination.pageNow" value="pagination.pageNow-1"></s:param>
                </s:url>
                <s:a href="%{url_pre}" cssClass="page_pre" title="上一页">上一页<s:property value="actionName"/></s:a>
            </s:if>

            <s:bean name="org.apache.struts2.util.Counter" id="counter">
                <s:param name="first" value="1"/>
                <s:param name="last" value="pagination.totalPage"/>
            </s:bean>

            <s:iterator value="counter"  status="status">
                <s:url id="getNextPage" action="%{pagination.actionName}">
                    <s:param name="pagination.pageNow"><s:property/></s:param>
                </s:url>
                <s:if test="pagination.pageNow==#status.index+1">
                    <s:a href="javascript:;" cssClass="page_now"><s:property/></s:a>
                </s:if>
                <s:else>
                    <s:a href="%{getNextPage}" cssClass="page_other"><s:property/></s:a>
                </s:else>
            </s:iterator>

            <s:if test="pagination.hasNext">
                <s:url id="url_next" action="%{pagination.actionName}">
                    <s:param name="pagination.pageNow" value="pagination.pageNow+1"></s:param>
                </s:url>
                <s:a href="%{url_next}" cssClass="page_next" title="下一页">下一页</s:a>
            </s:if>
        </td>
    </tr>
</table>

