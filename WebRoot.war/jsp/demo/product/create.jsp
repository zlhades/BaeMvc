<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>--%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>

<script type="text/javascript">
    $(function () {
        $("#button")
                .button()
                .click(function (event) {
                    if ($("#button").button("option", "disabled") == false && $("#productForm").valid()) {
                        $("#button").button("option", "disabled", true);
                        document.getElementById('productForm').submit();
                    }
                });
    });
</script>
<table class="ui-widget ui-widget-content" width="80%">
    <tr>
        <td valign="top" align="center">
            <div id="ui-widget ui-widget-content">
                <tr>
                    <td colspan="2" align="center">
                        <p class="ui-widget-header "></p>
                    </td>
                </tr>
                <form id="productForm" action="/Product!proC" method="post">
                    <fieldset>
                        <tr>
                            <td align="right" width="50%">
                                <label for="name">名称:</label>
                            </td>
                            <td  width="50%">
                                <input type="text"  name="product.name" id="name"
                                             cssClass="text ui-widget-content ui-corner-all required"
                                             maxLength="100"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">

                                <label for="price">价格:</label>
                            </td>
                            <td>
                                <input type="text"  name="productDetail.price" id="price"
                                             cssClass="text ui-widget-content ui-corner-all required number" size="18"/>元
                            </td>
                        </tr>


                        <tr>
                            <td align="right">

                                <label for="description">描述:</label>
                            </td>
                            <td>
                                <input type="textarea" name="productDetail.description" id="description"
                                            cssClass="text ui-widget-content ui-corner-all" cols="18" value="${productDetail.description}" /><c:out value="${productDetail.description}"/> 比如，地点或联系人手机
                            </td>
                        </tr>
                    </fieldset>

                    <tr>
                        <td colspan="2" align="center">
                            <button id="button"
                                    class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">
                                <span class="ui-button-text">创建</span></button>
                        <td>
                    </tr>
                </form>
            </div>
        </td>
        <script type="text/javascript">
//            $(document).ready(function () {
//                $("#productForm").validate();
//            });
        </script>
    </tr>

    <tr>
        <td  colspan="2" height="280px">
            <%--<div id='container2' style="height: 100%;width: 100%"></div>--%>
            <iframe src="Product!list" width="100%" height="100%" id="proIframe" scrolling="no"/>
        </td>
    </tr>


</table>

