<%--
  Created by IntelliJ IDEA.
  User: sakura
  Date: 2019-3-26 0026
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function myAlert() {
            <%--var message = "${message}";--%>
            <%--var messageStr = message.toString();--%>
            <%--if (null != messageStr && !"".endsWith(messageStr)) {--%>
            <%--alert(messageStr);--%>
            <%--}--%>

            <%
                String sessionMessage = (String)session.getAttribute("sessionMessage");
                session.setAttribute("sessionMessage",null);
                if (null != sessionMessage){
                    out.print("alert(sessionMessage : "+sessionMessage+");");
                }

                String requestMessage = (String)request.getAttribute("requestMessage");
                request.setAttribute("requestMessage",null);
                if (null != requestMessage){
                    out.print("alert(requestMessage : "+requestMessage+");");
                }
            %>

        }

    </script>
</head>

<body onload="myAlert()">

</body>
</html>
