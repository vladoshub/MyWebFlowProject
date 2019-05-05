<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<ul id="editVocAddManyWordsFragment">
<input type="hidden" name="_flowExecutionKey"/>
<input type="hidden"  value="" name="inputNameKey" id="Keyhidden">
<input type="hidden"  value="" name="inputNameWord" id="allWord">
    <c:if test="${not empty out.outMess}">
     <p>${out.outMess}</p>
    </c:if>
<br>
<p>Введите ключ</p>
<input type="text" value="" id="input2">
<p>Введите слово</p>
<input type="text" value="" id="input">
<button id="addWord" onclick="func1()" type="button" class="button">добавить еще слово</button>
<button id="readAll" onclick="readAllWords()" type="button" class="button" name="_eventId_addWords">добавить в словарь</button>
</ul>