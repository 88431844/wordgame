<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<head>
    <base href="<%=basePath%>">
    <title>识字游戏</title>
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
    <%--<script>--%>
        <%--function myAlert() {--%>
            <%--&lt;%&ndash;var message = "${message}";&ndash;%&gt;--%>
            <%--&lt;%&ndash;var messageStr = message.toString();&ndash;%&gt;--%>
            <%--&lt;%&ndash;if (null != messageStr && !"".endsWith(messageStr)) {&ndash;%&gt;--%>
                <%--&lt;%&ndash;alert(messageStr);&ndash;%&gt;--%>
            <%--&lt;%&ndash;}&ndash;%&gt;--%>

            <%--<%--%>
                <%--String sessionMessage = (String)session.getAttribute("sessionMessage");--%>
                <%--session.setAttribute("sessionMessage",null);--%>
                <%--if (null != sessionMessage){--%>
                    <%--out.print("alert(sessionMessage : "+sessionMessage+");");--%>
                <%--}--%>

                <%--String requestMessage = (String)request.getAttribute("requestMessage");--%>
                <%--request.setAttribute("requestMessage",null);--%>
                <%--if (null != requestMessage){--%>
                    <%--out.print("alert(requestMessage : "+requestMessage+");");--%>
                <%--}--%>
            <%--%>--%>

        <%--}--%>

    <%--</script>--%>
</head>
<body>
<%@include file="../head.jsp"%>
<!------------End Header ------------>
    <div>
            <audio controls autoplay></audio>
            <input onclick="startRecording()" type="button" value="录音" />
            <input onclick="stopRecording()" type="button" value="停止" />
            <input onclick="playRecording()" type="button" value="播放" />
            <input onclick="uploadAudio()" type="button" value="提交" />
        </div>

   
<audio src="uploadFile/test.wav" controls="controls" width="30px">音频文件</audio>
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
        recorder.upload("word/asr", function (state, e) {
            switch (state) {
                case 'uploading':
                    var percentComplete = Math.round(e.loaded * 100 / e.total) + '%';
                    break;
                case 'ok':
                    // alert(e.target.responseText);
                    <%--alert("message : " + <%String message = (String)session.getAttribute("sessionMessage"); out.print(message);%>);--%>
                    window.location.href="word/toMessage";
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
<form action="word/tts" method="post">
    <table>
        <tr>
            <td><label>tts word: </label></td>
            <td><input type="text" id="word" name="word"></td>
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

</body>
</html>


