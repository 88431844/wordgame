<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<head>
    <base href="<%=basePath%>">
    <title>电影详情</title>
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

        <div class="section group">
            <div class="cont-desc span_1_of_2">
                <div class="product-details">
                    <div class="grid static/images_3_of_2">
                        <img src="static/images/1.jpg" alt="电影海报" />
                    </div>
                    <div class="desc span_3_of_2">
                        <h2>电影名称 ： 惊奇队长 Captain Marvel </h2>
                        <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore.</p>--%>
                        <div class="price">
                            <p>票价: <span>50 元/张</span></p>
                        </div>
                        <div class="available">
                            <ul>
                                <li><span>导演:</span> &nbsp; 安娜?波顿 / 瑞安?弗雷克</li>
                                <li><span>编剧:</span>&nbsp;  安娜?波顿 / 瑞安?弗雷克 / 吉内瓦?德沃莱特-罗宾森 / 尼科尔?帕尔曼 / 梅格?勒福夫</li>
                                <li><span>主演:</span>&nbsp;  布丽?拉尔森 / 裘德?洛 / 塞缪尔?杰克逊 / 本?门德尔森 / 安妮特?贝宁</li>
                                <li><span>类型:</span>&nbsp; 动作 / 科幻 / 冒险</li>
                                <li><span>语言:</span>&nbsp; 英语</li>
                                <li><span>上映日期:</span>&nbsp; 2019-03-08(美国/中国大陆)</li>
                                <li><span>片长:</span>&nbsp; 124分钟</li>
                                <li>
                                        <p>日期选择 :</p>
                                        <select>
                                            <option>3月10日</option>
                                            <option>3月11日</option>
                                            <option>3月12日</option>
                                            <option>3月13日</option>
                                            <option>3月14日</option>
                                            <option>3月15日</option>
                                        </select>
                                </li>

                                <li>
                                        <p>影院选择 :</p>
                                        <select>
                                            <option>中街比高电影院</option>
                                            <option>3月11日</option>
                                            <option>3月12日</option>
                                            <option>3月13日</option>
                                            <option>3月14日</option>
                                            <option>3月15日</option>
                                        </select>
                                </li>
                                <li>
                                        <div class="button"><span><a href="movie/seat">电影选座</a></span></div>
                                        <div class="clear"></div>
                                </li>

                            </ul>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="product_desc">
                    <h2>剧情简介 :</h2>
                    <p>漫画中的初代“惊奇女士”原名Carol Danvers，她曾经是一名美国空军情报局探员，暗恋惊奇先生。此后她得到了超能力，成为“惊奇女士”，在漫画中是非常典型的女性英雄人物。她可以吸收并控制任意形态的能量，拥有众多超能力。《惊奇队长》将是漫威首部以女性超级英雄为主角的电影。</p>
                </div>
            </div>
            <div class="rightsidebar span_3_of_1 sidebar">
                <h2>最新电影</h2>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="movie/detail"><img src="static/images/end-game.jpg" alt="" /></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="movie/detail">End Game</a></h3>
                        <p></p>
                        <span><a href="movie/detail">电影详情</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="movie/detail"><img src="static/images/Coraline.jpg" alt="" /></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="movie/detail">Coraline</a></h3>
                        <p></p>
                        <span><a href="movie/detail">电影详情</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="movie/detail"><img src="static/images/Eclipse.jpg" alt="" /></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="movie/detail">Eclipse</a></h3>
                        <p></p>
                        <span><a href="movie/detail">电影详情</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="movie/detail"><img src="static/images/Priest.jpg" alt="" /></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="movie/detail">Priest 3D</a></h3>
                        <p></p>
                        <span><a href="movie/detail">电影详情</a></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="special_movies">
                    <div class="movie_poster">
                        <a href="movie/detail"><img src="static/images/Sorority_Wars.jpg" alt="" /></a>
                    </div>
                    <div class="movie_desc">
                        <h3><a href="movie/detail">Sorority Wars</a></h3>
                        <p></p>
                        <span><a href="movie/detail">电影详情</a></span>
                    </div>
                    <div class="clear"></div>
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

