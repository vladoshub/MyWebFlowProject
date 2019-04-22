<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 12.04.2019
  Time: 18:24
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<p id="messageFromServer">
<c:if test="${not empty out.outMess}">
    Message from Server: ${out.outMess}
    ${out.outMess=null}
</c:if>
</p>
