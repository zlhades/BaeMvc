<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="struts-tags.tld" %>
<script type="text/javascript" src="js/fancybox/jquery.fancybox.pack.js"></script>
<link rel="stylesheet" type="text/css" href="js/fancybox/jquery.fancybox.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="css/index.css" media="screen"/>


<input type="hidden" value="<s:property value='#session.openId'/>" id="openId"/>


<div align="center">
    <table width="80%" class="ui-widget ui-widget-content">
        <tr>
            <th height="300px" width="30%" scope="col">
                <table height="100%" width="100%" border="1">
                    <tr class="ui-widget-header " style="height: 10%">
                        <td colspan="4" scope="col">菜米油盐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div style="float: right">
                                <a href="iniProC.html" id="dialog-link" title="分享你所知道的"
                                   class="ui-state-default ui-corner-all ui-state-hover">
                                    <span class="ui-icon ui-icon-newwin"></span>
                                    分享</a>
                            </div>


                        </td>
                    </tr>


                    <tr>
                        <td>
                            <%--<div id='container2' style="height: 100%;width: 100%"></div>--%>
                            <iframe src="proL.html" id="proIframe" height="100%" width="100%" scrolling="no"></iframe>
                        </td>
                    </tr>

                </table>
            </th>
            <th width="70%" height="100%">
                <%--<div id='container' style="height: 100%;width: 100%"></div>--%>
                <iframe width="100%" height="100%" src="plaIni.html" id="mapIframe" scrolling="no"></iframe>
            </th>
        </tr>

        <tr>
            <td colspan="5">
                <table align="right">
                    <tr>
                        <td>
                            Test                           <div style="float: right">
                            <a href="iniProC.html" id="skill-link" title="分享你所知道的"
                               class="ui-state-default ui-corner-all ui-state-hover">
                                <span class="ui-icon ui-icon-newwin"></span>
                                分享</a>
                        </div>
                        </td>

                    </tr>
                </table>
            </td>
        </tr>
    </table>


</div>

<script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript">

        $("#dialog-link").fancybox({
            'transitionIn': 'elastic',
            'transitionOut': 'elastic',
            'hideOnOverlayClick': 'false',
            'showCloseButton': 'true',
            "type": "iframe",
            "width": '100%',
            "height": '100%'
        });


        $("#skill-link").fancybox({
            'transitionIn': 'elastic',
            'transitionOut': 'elastic',
            'hideOnOverlayClick': 'false',
            'showCloseButton': 'true',
            "type": "iframe",
            "width": '100%',
            "height": '100%'
        });


</script>