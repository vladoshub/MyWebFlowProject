<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <script type="application/javascript">

        function  formSubmit(input) {
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&"+input.name+"&ajaxSource=true",
                success:function (html) {
                    $("#requestFromServer").html($(html).filter("#requestFromServer"));
                    $("#messageFromServer").html($(html).filter("#messageFromServer"));
                },
                error:function (error) {
                    console.log(error)
                }
            })
        }

    </script>

    <title>hellooooooo</title>
</head>
<body>
<form id="forma1"  method="post">
    <div><tiles:insertAttribute name="hello"/></div>
    <div><c:choose><c:when test="${out.voc == 1}"><h1>you chose Russ to Latin</h1></c:when><c:when test="${out.voc == 2}"><h1>you chose Bin to Dec</h1></c:when></c:choose></div>
    <br>
    <tiles:insertAttribute name="messageFromServer"/>
    <br>
    <tiles:insertAttribute name="requestFromServer"/>
    <br>
    <input  type="text" name="inputNameRus" value=""/>
    <br>
    <input type="hidden" name="_flowExecutionKey"/>
    <br>
    <input id="knopka1" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextDelete" value="Delete"/>
    <br>
    <input id="knopka3" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextSearch" value="search by key"/>
    <br>
    <input  id="knopka4" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextAdd" value="add by key"/>
    <br>
    <input  id="knopka5" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextPrint" value="out vocabulary"/>
    <br>
    <input  id="knopka6"  type="button" class="button" name="_eventId_next" value="Main"/>
    <br>
    <input  id="knopka7"  type="button" class="button" name="_eventId_nextBin" value="Bin-Dec"/>
</form>
</body>
</html>
