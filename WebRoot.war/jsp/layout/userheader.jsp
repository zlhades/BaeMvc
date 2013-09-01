<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--<div class="uho">--%>
    <%--<div class="uh">--%>
        <%--<div class="uh1">--%>
            <%--<ul class="menu_section">--%>
                <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_home">--%>
                        <%--<s:a action="index"><s:property value="%{getText('label.homepage')}"/></s:a>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_course">--%>
                        <%--<s:a action="courseSquare"><s:property value="%{getText('frame.course.center')}"/></s:a>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_show">--%>
                        <%--<s:a action="showSquare"><s:property value="%{getText('frame.show.center')}"/></s:a>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_live">--%>
                        <%--<s:a action="liveSquare"><s:property value="%{getText('frame.onlive.center')}"/></s:a>--%>
                    <%--</div>--%>
                <%--</li>--%>


                  <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_download">--%>
                        <%--<s:a action="ggw4android"><s:property value="%{getText('download.center')}"/></s:a>--%>
                    <%--</div>--%>
                <%--</li>--%>

                <%--<li class="hp_item">--%>
                   <%--<div class="menu_base menu_base_userCenter">--%>
                       <%--<a href="myfirstPage.html"><s:property value="%{getText('usermenu.item.myhomepage')}"/></a>--%>
                   <%--</div>--%>
               <%--</li>--%>

                <%--<li class="hp_item">--%>
                    <%--<div class="menu_base menu_base_about"><a href="javascript:;"><s:property value="%{getText('link.about.us')}"/></a></div>--%>
                    <%--<div class="menu_popup popup1">--%>
                        <%--<ul class="menu_popup_section">--%>
                            <%--<li><a href="aboutUs.html"><s:property value="%{getText('nav.firm.info')}"/></a></li>--%>
                            <%--<li><a href="team.html"><s:property value="%{getText('nav.team.info')}"/></a></li>--%>
                            <%--<li><a href="history.html"><s:property value="%{getText('nav.development.history')}"/></a></li>--%>
                            <%--<li><a href="contactUs.html"><s:property value="%{getText('nav.contact.us')}"/></a></li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</li>--%>


            <%--</ul>--%>
        <%--</div>--%>

        <%--<div class="uh3">--%>
            <%--<s:if test="#session.email !=null">--%>
            <%--<div class="user_info">--%>
                <%--<ul class="ul_out">--%>
                    <%--<li id="account" class="account1" onMouseOver="this.className='account2',document.getElementById('accountlist').className='accountlist2'" onMouseOut="this.className='account1',document.getElementById('accountlist').className='accountlist1'">--%>
                        <%--<s:property value="%{getText('menu.item.account')}" /> ▼--%>
                    <%--</li>--%>
                    <%--<li id="accountlist" class="accountlist1" onmouseover="this.className='accountlist2',document.getElementById('account').className='account2'" onMouseOut="this.className='accountlist1',document.getElementById('account').className='account1'">--%>
                        <%--<ul>--%>
                            <%--<li class="info">--%>
                                <%--<a href="userBlog.html?user.id=<s:property value="#session.userID"/>" title="<s:property value="#session.nickName"/>"><img id="userheader_user_img" src="<s:property value='#session.userLogoUrl' />"/></a>--%>
                                <%--<span class="name">--%>
                                    <%--<s:if test="#session.nickName !=null && #session.nickName !=\"\""><s:property value="#session.nickName"/></s:if>--%>
                                    <%--<s:else><s:property value="#session.email"/> </s:else>--%>
                                <%--</span>--%>
                            <%--</li>--%>
                            <%--<li class="setting bg"><a href="initUpdate.html"><span></span><s:property value="%{getText('account.item.accountsettings')}" /></a></li>--%>
                            <%--<li class="coupons bg"><a href="javascript:;"><span></span><s:property value="%{getText('menu.item.ticket')}" /></a></li>--%>
                            <%--<li class="money bg"><a href="javascript:;"><span></span><s:property value="%{getText('menu.item.currency')}" /></a></li>--%>
                            <%--<li class="exit bg"><a href="exitSystem.html"><span></span><s:property value="%{getText('href.logout')}" /></a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--</s:if>--%>
            <%--<s:else>--%>
                <%--<div class="handle">--%>
                    <%--<a href="login.html" id="login_btn"><s:property value="%{getText('Login')}"/></a>&nbsp;&nbsp;<strong>|</strong>&nbsp;&nbsp;<a href="initReg.html"><s:property value="%{getText('user.info.identity.finish.reg')}"/></a>--%>
                <%--</div>--%>
            <%--</s:else>--%>
        <%--</div>--%>

        <%--<div class="uh2">--%>
            <%--<s:form method="POST" action="searchResult" theme="simple" validate="true">--%>

                <%--<s:hidden name="searchType" value="1"/>--%>
                <%--&lt;%&ndash;<input name="courseName" class="keyWords"/>&ndash;%&gt;--%>
                <%--<s:textfield cssClass="keyWords" name="searchStr" />--%>
                <%--<input type="hidden" name="searchTyp" value="1"/>--%>
                <%--<input class="searchButton" type="submit" value="" />--%>
                <%--&lt;%&ndash;<a class="searchButton" href="search.html"></a>&ndash;%&gt;--%>
            <%--</s:form>--%>
        <%--</div>--%>

    <%--</div>--%>
<%--</div>--%>

<%--<script type="text/javascript">--%>
    <%--$(function(){--%>
        <%--$("#login_btn").fancybox({--%>
            <%--"type":"iframe",--%>
            <%--"width":350,--%>
            <%--"height":270--%>
        <%--});--%>


        <%--var menuInterval = 0;--%>
        <%--$("div.menu_popup").hover(function(){--%>
            <%--menuInterval = window.clearInterval(menuInterval);--%>
        <%--},function(){--%>
            <%--var thisObj = $(this);--%>
            <%--menuInterval = window.setTimeout(function(){--%>
                <%--$(thisObj).slideUp();--%>
            <%--},3000);--%>
        <%--});--%>
        <%--$("div.menu_base").click(function(){--%>
            <%--var menuObj = $(this);--%>
            <%--var nextItemList = $(this).next("div");--%>
            <%--var isVisible = $(this).next("div").is(":visible");--%>
            <%--$("div.menu_popup").not(nextItemList).hide();--%>
            <%--$(this).next("div").slideToggle();--%>
            <%--if(!isVisible){--%>
                <%--menuInterval = window.setTimeout(function(){--%>
                    <%--$(nextItemList).slideUp();--%>
                <%--},6000);--%>
            <%--}--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>