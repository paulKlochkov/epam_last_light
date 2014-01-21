<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: pklochkov
  Date: 05.01.14
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I am the Jedi Knight!</title>
</head>
<body>
     ${value.time}
<%=new Date().getTime()%>
</body>
</html>