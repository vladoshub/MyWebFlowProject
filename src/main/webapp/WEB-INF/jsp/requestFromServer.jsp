<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 13.04.2019
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<p id="requestFromServer">
<c:if test="${not empty out.outList}">
    <c:forEach items="${out.outList}" var="items">
        ${items}
    </c:forEach>
    ${out.outList=null}
</c:if>
</p>