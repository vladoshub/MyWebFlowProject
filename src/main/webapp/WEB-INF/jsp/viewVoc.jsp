<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 13.04.2019
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<body>
<p>
    <ul>
    <c:if test="${not empty out.keys}">
        <c:forEach items="${out.keys}" var="items">
            <li value="${items.id}">key: <b>${items.key}</b> <c:choose><c:when test="${items.words.size()==1}"><b>${items.words.get(0).word}</b></c:when><c:when test="${items.words.size()>1}"><button>несколько значений</button></c:when></c:choose></li>
        </c:forEach>
        ${out.outList=null}
    </c:if>
    </ul>
</p>
</body>
</html>