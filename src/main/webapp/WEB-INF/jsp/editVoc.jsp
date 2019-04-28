<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 13.04.2019
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<style><%@include file="/WEB-INF/css/buttonView.css"%></style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
<script type="application/javascript">

    function  getList() {
        $('#hidden').toggle();
    }

</script>
<html>
<body>
<tiles:insertAttribute name="editVocAddManyWordsFragment"/>
<tiles:insertAttribute name="editVocDelFragment"/>
</body>
</html>