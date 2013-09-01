<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table class="ui-widget ui-widget-content" width="100%" id="proTable" height="100%" align="center" border="1">
    <tr class="ui-widget-header " >
        <td width="100px" >名称</td>
        <td width="100px">价格</td>
        <td >描述 </td>
        <%--<td width="50px">分享者</td>--%>

    </tr>

    <c:forEach items="${productDetails}" var="productDetail" varStatus="num">
         <tr>
            <td >${productDetail.product.name}</td>
            <td >${productDetail.price}</td>
            <td >${productDetail.description}</td>
            <%--<td style="white-space:nowrap"><s:property value="creator.nickName"/></td>--%>
        </tr>
   </c:forEach>


</table>

<div class="pagination" style="padding-top:0px;">
    <%--<tiles:insertTemplate template="../pagination.jsp">--%>
        <%--<tiles:putAttribute name="pagination" value="${pagination}"/>--%>
    <%--</tiles:insertTemplate>--%>
</div>
<%--<script type="text/javascript">--%>
    <%--alert(parent.document.getElementById('proIframe').offsetWidth);--%>
    <%--alert(parent.document.getElementById('proIframe').width);--%>
    <%--document.getElementById("proTable").width = parent.document.getElementById('proIframe').offsetWidth;--%>
    <%--document.getElementById("proTable").height = parent.document.getElementById('proIframe').offsetHeight;--%>
<%--</script>--%>

