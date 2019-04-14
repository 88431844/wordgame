<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar" class="sidebar                  responsive">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>
    <ul class="nav nav-list">

        <li class="">
            <a href="child/listMovie">
                <i class="menu-icon fa fa-film"></i>
                <span class="menu-text"> 儿童管理 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="ticket/listTicket">
                <i class="menu-icon glyphicon glyphicon-book"></i>
                <span class="menu-text"> 票务管理 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-credit-card"></i>
                <span class="menu-text">商城套餐管理 </span>
                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="shop/listShop">
                        <i class="menu-icon fa fa-caret-right"></i>
                        查询商城套餐
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="">
                    <a href="shop/toAddShop">
                        <i class="menu-icon fa fa-caret-right"></i>
                        添加商城套餐
                    </a>

                    <b class="arrow"></b>
                </li>
            </ul>

        </li>

    </ul><!-- /.nav-list -->
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
