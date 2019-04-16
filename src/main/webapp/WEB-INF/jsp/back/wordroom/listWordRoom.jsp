<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>查看字库</title>

    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="static/assets/css/font-awesome.min.css"/>

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="static/assets/css/ace-fonts.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="static/assets/css/ace.min.css" id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/assets/css/ace-part2.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="static/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="static/assets/css/ace-rtl.min.css"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="static/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="static/assets/js/html5shiv.min.js"></script>
    <script src="static/assets/js/respond.min.js"></script>
    <![endif]-->
    <script>
        function del(id) {
            if (confirm('您确定删除吗？')) {
                window.location.href = "backWordRoom/del?id=" + id;
            }
        }

        function toEdit(id) {
            window.location.href = "backWordRoom/toEdit?id=" + id;
        }

        function toAdd() {
            window.location.href = "backWordRoom/toAdd";
        }

        function myAlert() {
            var message = "${message}";
            var messageStr = message.toString();
            if (null != messageStr && !"".endsWith(messageStr)) {
                alert(messageStr);
            }

        }

    </script>
</head>

<body class="no-skin" onload="myAlert()">
<!-- #section:basics/navbar.layout -->
<%@include file="../backTop.jsp" %>
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <!-- #section:basics/sidebar -->
    <%@include file="../backMenu.jsp" %>
    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <!-- #section:basics/content.breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <span>查看字库</span>
                </li>
                <li>
                    <button onclick="toAdd()">添加字库</button>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>

        <!-- /section:basics/content.breadcrumbs -->
        <div class="page-content">

            <!-- /section:settings.box -->
            <div class="page-content-area">
                <div class="row">
                    <div class="col-xs-12">

                        <!-- <div class="table-responsive"> -->

                        <!-- <div class="dataTables_borderWrap"> -->
                        <div>
                            <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th width="20%">字库名称</th>
                                    <th width="25%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${wordRoomList}" var="wordRoomList">
                                    <tr>

                                        <td><span>${wordRoomList.wordroomname}</span></td>
                                        <td>
                                            <div class="">
                                                <button class="green" onclick="toEdit(${wordRoomList.id})">
                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                    编辑字库
                                                </button>

                                                <button class="red" onclick="del(${wordRoomList.id})">
                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                    删除字库
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content-area -->
</div><!-- /.page-content -->
</div><!-- /.main-content -->

<%@include file="../backFooter.jsp" %>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='static/assets/js/jquery.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='static/assets/js/jquery1x.min.js'>" + "<" + "/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='static/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="static/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="static/assets/js/jquery.dataTables.min.js"></script>
<script src="static/assets/js/jquery.dataTables.bootstrap.js"></script>
<!-- ace scripts -->
<script src="static/assets/js/ace-elements.min.js"></script>
<script src="static/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function ($) {
        var oTable1 =
            $('#sample-table-2')
            //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
                .dataTable({
                    bAutoWidth: true,
                    "aoColumns": [
                        {"bSortable": false},

                        {"bSortable": false}
                    ],
                    "aaSorting": [],

                    //,
                    //"sScrollY": "200px",
                    //"bPaginate": false,

                    //"sScrollX": "100%",
                    // "sScrollXInner": "120%",
                    //"bScrollCollapse": true,
                    //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
                    //you may want to wrap the table inside a "div.dataTables_borderWrap" element

                    //"iDisplayLength": 50
                });
        /**
         var tableTools = new $.fn.dataTable.TableTools( oTable1, {
					"sSwfPath": "../../copy_csv_xls_pdf.swf",
			        "buttons": [
			            "copy",
			            "csv",
			            "xls",
						"pdf",
			            "print"
			        ]
			    } );
         $( tableTools.fnContainer() ).insertBefore('#sample-table-2');
         */


        $(document).on('click', 'th input:checkbox', function () {
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function () {
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });
        });


        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table');
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }

    })
</script>
<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="static/assets/css/ace.onpage-help.css"/>
<link rel="stylesheet" href="static/docs/assets/js/themes/sunburst.css"/>

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="static/assets/js/ace/elements.onpage-help.js"></script>
<script src="static/assets/js/ace/ace.onpage-help.js"></script>
<script src="static/docs/assets/js/rainbow.js"></script>
<script src="static/docs/assets/js/language/generic.js"></script>
<script src="static/docs/assets/js/language/html.js"></script>
<script src="static/docs/assets/js/language/css.js"></script>
<script src="static/docs/assets/js/language/javascript.js"></script>
</body>
</html>
