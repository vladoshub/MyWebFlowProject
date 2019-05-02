<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<input type="hidden"  value="" name="inputNameKey" id="Keyhidden">
<input type="hidden"  value="" name="inputNameWord" id="allWord">
<p>Введите ключ</p>
<input type="text" value="" id="input2">
<p>Введите слово</p>
<input type="text" value="" id="input">
<button id="addWord" onclick="addWord()" type="button" class="button">добавить еще слово</button>
<button id="readAll" onclick="readAll()" type="button" class="button" name="_eventId_nextAdd" value="Delete">добавить в словарь</button>