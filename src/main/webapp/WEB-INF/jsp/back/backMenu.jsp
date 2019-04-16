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
            <a href="backWordRoom/list">
                <i class="menu-icon fa fa-comments"></i>
                <span class="menu-text"> 字库管理 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="backWord/list">
                <i class="menu-icon fa fa-comment"></i>
                <span class="menu-text"> 汉字管理 </span>
            </a>

            <b class="arrow"></b>
        </li>

        <li class="">
            <a href="child/list">
                <i class="menu-icon fa fa-users"></i>
                <span class="menu-text"> 儿童管理 </span>
            </a>

            <b class="arrow"></b>
        </li>

    </ul><!-- /.nav-list -->
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
