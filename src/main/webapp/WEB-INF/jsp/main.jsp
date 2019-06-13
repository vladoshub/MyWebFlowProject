<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<style><%@include file="/WEB-INF/css/choicePage.css"%></style>
<form method="post">
    <body id="main">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <br>
        <b style="margin-left: 55px">Выберите словарь</b>
        <br>
        <button type="submit" class="button" name="_eventId_nextRus"><img class="main" src="${pageContext.request.contextPath}/images/rus.png"/></button>
        <br>
        <button type="submit" class="button" name="_eventId_nextBin"><img  class="main" src="${pageContext.request.contextPath}/images/Bin.jpg"/></button>
    </body>
</form>