<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <style><%@include file="/WEB-INF/css/choicePage.css"%></style>
</head>
<body id="voc">
<form id="forma1"  method="post">
    <div id="first"><c:choose><c:when test="${type.type == 1}"><h1 style=" float: left;margin-left: -166px;width: 800px;">Вы выбрали Русско-Латинский словарь</h1></c:when><c:when test="${type.type == 2}"><h1 style=" float: left;margin-left: -166px;width: 800px;">Вы выбрали Десятично-двоичный словарь</h1></c:when></c:choose></div>
    <input id="inp"  type="hidden" name="inputNameRus" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <br>
    <button id="knopka1"  type="submit" class="button" name="_eventId_next">Главная страница</button>
    <c:choose><c:when test="${type.type == 1}"><button id="knopka7"  type="submit" class="button" name="_eventId_nextBin">другой словарь</button></c:when><c:when test="${type.type == 2}"><button id="knopka5"  type="submit" class="button" name="_eventId_nextRus">другой словарь</button></c:when></c:choose>
    <button id="knopka8"  type="submit" class="button" name="_eventId_voc">Словарь</button>
</form>
</body>
</html>
