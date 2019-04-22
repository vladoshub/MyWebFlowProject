<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<style><%@include file="/WEB-INF/css/styleMain.css"%></style>
<form method="post">
    <body id="main">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <br>
        <h>Выберите словарь</h>
        <br>
        <button type="submit" class="button" name="_eventId_nextRus"><img src="${pageContext.request.contextPath}/images/rus.png"/></button>
        <br>
        <button type="submit" class="button" name="_eventId_nextBin"><img src="${pageContext.request.contextPath}/images/Bin.jpg"/></button>
    </body>
</form>