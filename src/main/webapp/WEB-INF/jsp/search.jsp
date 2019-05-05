<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 29.04.2019
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<button type="submit" name="_eventId_SearchKey" >поиск по ключу</button>
<input type="text"  value="" name="Key">
<button type="submit" name="_eventId_SearchWord" >поиск по слову</button>
<input type="text"  value="" name="Word">

<c:if test="${not empty out.words}"><c:choose><c:when test="${out.words.size()==1}"><b>Word:${out.words.get(0).word}</b></c:when><c:when test="${out.words.size()>1}"><ul><c:forEach items="${out.words}" var="words"><li><b>Word:${words.word}</b></c:forEach></c:when></c:choose></c:if>
<c:if test="${not empty out.keys}"><b>Word:${out.keys.get(0)}</b></c:if>