<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="headertop_desc">
        <div class="wrap">
            <div class="account_desc">
                <ul>
                    <%
                        String nickName = (String)session.getAttribute("nickName");
                        if (null == nickName || "".equals(nickName)){
                            out.print("<li><a href=\"user/toLogin\">登录</a></li>");
                            out.print("<li><a href=\"user/toRegisterUser\">注册</a></li>");
                        }
                        else {
                            out.print("<li><a href=>欢迎:"+nickName+"</a></li>");
                            out.print("<li><a href=\"user/userLogout\">登出</a></li>");
                        }
                    %>


                    <li><a href="admin/toAdminLogin">后台管理</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="wrap">
        <div class="header_top">
            <div class="logo">
                <a href="movie/wall"><img src="static/images/logo.png" alt=""/></a>
            </div>
            <div class="header_top_right">
                <div class="search_box">
                    <form>
                        <input type="text" value="搜索电影" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
                    </form>
                </div>
                <div class="clear"></div>
            </div>
            <script type="text/javascript">
                function DropDown(el) {
                    this.dd = el;
                    this.initEvents();
                }

                DropDown.prototype = {
                    initEvents: function () {
                        var obj = this;

                        obj.dd.on('click', function (event) {
                            $(this).toggleClass('active');
                            event.stopPropagation();
                        });
                    }
                }

                $(function () {

                    var dd = new DropDown($('#dd'));

                    $(document).click(function () {
                        // all dropdowns
                        $('.wrapper-dropdown-2').removeClass('active');
                    });

                });
            </script>
            <div class="clear"></div>
        </div>
    </div>
</div>