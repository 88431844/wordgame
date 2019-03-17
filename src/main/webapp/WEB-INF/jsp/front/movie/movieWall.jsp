<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<head>
    <base href="<%=basePath%>">
    <title>电影墙</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="static/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="static/css/slider.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="static/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="static/js/move-top.js"></script>
    <script type="text/javascript" src="static/js/easing.js"></script>
    <script type="text/javascript" src="static/js/jquery.nivo.slider.js"></script>

    <script type="text/javascript" src="static/js/HZRecorder.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            $('#slider').nivoSlider();
        });
    </script>
    <script>
        function myAlert() {
            var message = "${message}";
            var messageStr = message.toString();
            if (null != messageStr && !"".endsWith(messageStr)) {
                alert(messageStr);
            }

        }

    </script>
</head>
<body onload="myAlert()">
<%@include file="../head.jsp"%>
<!------------End Header ------------>



    <div>
            <audio controls autoplay></audio>
            <input onclick="startRecording()" type="button" value="录音" />
            <input onclick="stopRecording()" type="button" value="停止" />
            <input onclick="playRecording()" type="button" value="播放" />
            <input onclick="uploadAudio()" type="button" value="提交" />
        </div>

   
<audio src="uploadFile/test.wav" controls="controls" width="30px"></audio>
    <script>
    var recorder;
    var audio = document.querySelector('audio');
    function startRecording() {
        HZRecorder.get(function (rec) {
            recorder = rec;
            recorder.start();
        });
    }
    function stopRecording() {
        recorder.stop();
    }
    function playRecording() {
        recorder.play(audio);
    }
    function uploadAudio() {
        recorder.upload("asr", function (state, e) {
            switch (state) {
                case 'uploading':
                    var percentComplete = Math.round(e.loaded * 100 / e.total) + '%';
                    break;
                case 'ok':
                    alert(e.target.responseText);
                    alert("上传成功");
                    window.location.href="asr";
                    break;
                case 'error':
                    alert("上传失败");
                    break;
                case 'cancel':
                    alert("上传被取消");
                    break;
            }
        });
    }

</script>
<form action="tts" method="post">
    <table>
        <tr>
            <td><label>username: </label></td>
            <td><input type="text" id="username" name="username"></td>
        </tr>

        <tr>
            <td><input id="submit" type="submit" value="提交"></td>
        </tr>
    </table>
</form>


<%@include file="../footer.jsp"%>
<script type="text/javascript">
    $(document).ready(function () {
        $().UItoTop({easingType: 'easeOutQuart'});
    });
</script>
<a href="#" id="toTop"><span id="toTopHover"> </span></a>
<div style="display:none">
    <script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script>
</div>
</body>
</html>


