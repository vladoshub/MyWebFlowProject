<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 12.05.2019
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="answer">
    <c:if test="${not empty out.outMess}">
        <b>${out.outMess}</b>
    </c:if>
</div>

