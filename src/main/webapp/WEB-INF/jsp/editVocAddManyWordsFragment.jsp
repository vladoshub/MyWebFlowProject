<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
<style><%@include file="/WEB-INF/css/styleVoc.css"%></style>
<script type="application/javascript">

    function  addWord() {
        var element = document.createElement('input');
        element.innerHTML = element.type="text";
        document.body.appendChild(element);
    }


    function readAll(){
        var values = $('input[name="text[]"]').map(function(){
            return this.value
        }).get()
        $('#all').setAttribute("value",values);
    }

</script>

<body>
<input type="hidden"  value="" name="inputNameRus" id="all">
<p>Введите ключ</p>
<input type="text" value="">
<p>Введите слово</p>
<input type="text" value="">
<button id="addWord" onclick="addWord()" type="button" class="button"><img src="${pageContext.request.contextPath}/images/delete.png"/>добавить еще слово</button>
<button id="readAll" onclick="readAll()" type="button" class="button" name="_eventId_nextAdd" value="Delete"><img src="${pageContext.request.contextPath}/images/delete.png"/>добавить в словарь</button>
</body>