<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 29.04.2019
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/css/searchPage.css"%></style>
<form method="post">
<body id="main">
<input type="hidden" name="_flowExecutionKey"/>

<button type="submit" class="button" name="_eventId_SearchKey" >поиск по ключу</button>
<input type="text"  value="" name="Key">
<button type="submit" class="button" name="_eventId_SearchWord" >поиск по слову</button>
<input type="text"  value="" name="Word">
<br>

<c:if test="${not empty out.outMess}">
    <b>${out.outMess}</b>
</c:if>
<c:if test="${not empty out.words}"><c:choose>
    <c:when test="${out.words.size()==1}"><b>Key:${out.words.get(0).key.key} Word:${out.words.get(0).word}</b></c:when>
    <c:when test="${out.words.size()>1}"><ul><c:forEach items="${out.words}" var="words"><li><b>Key:${words.key.key} Word:${words.word}</b>
    </c:forEach></c:when></c:choose></c:if>
    <c:if test="${not empty out.keys}">
    <b>Key:${out.keys.get(0).key}</b>
    <br>
    <c:choose>
    <c:when test="${out.keys.get(0).words.size()==1}"><b>Word:${out.words.get(0).word}</b></c:when>
    <c:when test="${out.keys.get(0).words.size()>1}"><ul><c:forEach items="${out.keys.get(0).words}" var="words"><li><b>Word:${words.word}</b>
        </c:forEach></c:when></c:choose></c:if>
</body>
</form>