<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="static/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="static/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="static/js/move-top.js"></script>
    <script type="text/javascript" src="static/js/easing.js"></script>
</head>
<body>
<%@include file="../head.jsp"%>
<div class="main">
    <div class="wrap">
        <div class="content">
            <div class="section group">
                <div class="col span_2_of_3">
                    <div class="contact-form">
                        <h2>用户注册</h2>
                        <form method="post" action="user/registerUser">
                            <div>
                                <span><label>账号</label></span>
                                <span><input name="userName" type="text" class="textbox" ></span>
                            </div>
                            <div>
                                <span><label>密码</label></span>
                                <span><input name="userEmail" type="text" class="textbox"></span>
                            </div>
                            <div>
                                <span><label>昵称</label></span>
                                <span><input name="userPhone" type="text" class="textbox"></span>
                            </div>
                            <div>
                                <span><label>电话</label></span>
                                <span><input name="userPhone" type="text" class="textbox"></span>
                            </div>
                            <div>
                                <span><input type="submit" value="Submit"  class="mybutton"></span>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="../footer.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

