<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <style><%@include file="/WEB-INF/css/styleVoc.css"%></style>
    <script type="application/javascript">

        function  formSubmit(input) {
            if(input.name!="_eventId_nextPrint"){
                $("#inp").attr("value",prompt('введите слово'));
            }
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
</head>
<body id="voc">
<form id="forma1"  method="post">
    <div id="first"><c:choose><c:when test="${out.voc == 1}"><h1>Вы выбрали Русско-Латинский словарь</h1></c:when><c:when test="${out.voc == 2}"><h1>Вы выбрали Десятично-двоичный словарь</h1></c:when></c:choose></div>
    <div><tiles:insertAttribute name="hello"/></div>
    <tiles:insertAttribute name="messageFromServer"/>
    <tiles:insertAttribute name="requestFromServer"/>
    <input id="inp"  type="hidden" name="inputNameRus" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <button id="knopka1" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextDelete" value="Delete"><img src="${pageContext.request.contextPath}/images/delete.png"/>удалить</button>
    <br>
    <button id="knopka3" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextSearch"><img src="${pageContext.request.contextPath}/images/search.png"/>поиск</button>
    <br>
    <button id="knopka4" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextAdd"><img src="${pageContext.request.contextPath}/images/add.jpg"/>добавить</button>
    <br>
    <button id="knopka5" onclick="formSubmit(this)" type="button" class="button" name="_eventId_nextPrint"><img src="${pageContext.request.contextPath}/images/print.png"/>вывести</button>
    <br>
    <c:choose><c:when test="${out.voc == 1}"><button id="knopka7"  type="submit" class="button" name="_eventId_nextBin"><img src="${pageContext.request.contextPath}/images/Bin.jpg"/>другой словарь</button></c:when><c:when test="${out.voc == 2}"><button id="knopka7"  type="submit" class="button" name="_eventId_nextRus"><img src="${pageContext.request.contextPath}/images/rus.png"/>другой словарь</button></c:when></c:choose>
    <br>
    <button id="knopka6"  type="submit" class="button" name="_eventId_next"><img src="${pageContext.request.contextPath}/images/main.png"/>Главная страница</button>
    <button id="knopka7"  type="submit" class="button" name="_eventId_view">Вывод Всего</button>
    <button id="knopka8"  type="submit" class="button" name="_eventId_addMany">Добавление значений</button>
    <button id="knopka8"  type="submit" class="button" name="_eventId_search">Поиск</button>
</form>
</body>
</html>
