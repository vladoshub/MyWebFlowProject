<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 20.05.2019
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="voc">
    <table border="0"  width="100%" cellpadding="5" class="one">
        <tr>
            <td><input id="searchkey" name="searchkey"  type="text" value=""><button type="submit" name="_eventId_SearchKeys" title="Поиск по ключу" style="background: url(/images/search.png);
    background-size: 38px 35px;" ></button></td>
            <td><input id="searchwrod" name="searchword" type="text" value=""><button type="submit" name="_eventId_SearchWords" style="background: url(/images/search.png);
    background-size: 38px 35px;" title="Поиск по слову"></button></td>
            <td><button type="button" onclick="addKey('table')" title="Добавить ключ" style="background: url(/images/add.png);
    background-size: 38px 35px;"></button><span style="color: red">
<c:if test="${not empty out}"><c:if test="${out.addKeyValid == true}">${out.outMess}</c:if>
</c:if></span></td>
        </tr>
    </table>
    <br>
    <table border="0"  width="100%" cellpadding="5" class="two">
        <thead>
        <tr>
            <th>Ключи</th>
            <th>Значения</th>
            <th>Действия</th>
        </tr>
        </thead>
        <c:if test="${not empty out.words}">
            <c:forEach items="${out.words}" var="items">
                <tr>
                    <td><input value="${items.key.key}" id="${items.key.id}inpK"></td>
                    <td><input value="${items.word}" readonly="readonly" id="${items.id}inpW"><button onclick="hiddRow('${items.id}WW')" style="background: url(/images/any.png);
    background-size: 40px 40px;" title="выбор слов"></button></td>
                    <td>
                        <button type="button" name="_eventId_editKey" onclick="edit('${items.key.id}inpK','key')" style="background: url(/images/edit.svg);
    background-size: 40px 40px;" title="изменить"></button>
                        <button type="button" name="_eventId_deletedKey" onclick="del('${items.key.id}inpK','key')" style="background: url(/images/delete.png);
    background-size: 40px 40px;" title="удалить"></button></td>
                </tr>
                <tr id="${items.id}WW" style="display: none;">
                    <td></td>
                    <td><input id="${items.id}inp" type="text"  value="${items.word}"/></td>
                    <td>
                        <button type="button" name="_eventId_editWord" onclick="edit('${items.id}inpW','word')">Редактировать</button>
                        <button type="button" name="_eventId_deletedWord" onclick="del('${items.id}inpW','word')">Удалить</button>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${not empty out.keys}">
            <c:forEach items="${out.keys}" var="items">
                <tr id="${items.id}">
                    <td><input type="text" name="${items.id}"  value="${items.key}" id="${items.id}inpK"/><span style="color: red">
                        <c:if test="${items.id == out.keysDtos.id and out.wordsDtos==null}">${out.outMess}</c:if>
                    </span></td>
                    <c:choose><c:when
                            test="${items.words.size()==1}">
                        <td>
                            <input type="text"  value="${items.words.get(0).word}" id="${items.id}inpOO"/><span style="color: red">
                        <c:if test="${items.words.get(0).id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                            <button type="button" onclick="hiddRow('${items.id}O')" style="background: url(/images/any.png);
    background-size: 38px 35px;" title="выбор слов"></button>
                        </td>
                    </c:when><c:when test="${items.words.size()>1}">
                        <td>
                            <input type="text" value="${items.words.get(0).word}..." readonly="readonly"/><span  style="color: red">
                        <c:if test="${items.id == out.keysDtos.id and out.wordsDtos!=null}">${out.outMess}</c:if>
                    </span>
                            <button type="button" onclick="hiddRow('${items.id}M')" style="background: url(/images/any.png);
    background-size: 38px 35px;" title="выбор слов"></button>
                        </td>

                    </c:when></c:choose>
                    <td>
                        <button type="button" name="_eventId_editKey" onclick="edit('${items.id}inpK','key')" style="background: url(/images/edit.svg);
    background-size: 38px 35px;" title="изменить"></button>
                        <button type="button" name="_eventId_deletedKey" onclick="del('${items.id}inpK','key')" style="background: url(/images/delete.png);
    background-size: 38px 35px;" title="удалить"></button>
                        <button type="button" onclick="addWord('${items.id}t2',${items.id})" style="background: url(/images/add.png);
    background-size: 38px 35px;" title="добавить слово"></button>
                    </td>
                </tr>
                <c:if test="${items.words.size()==1}">
                    <tr id="${items.id}O" style="display: none;">
                        <td></td>
                        <td><input id="${items.words.get(0).id}inpO" type="text" name="${items.words.get(0).id}"  value="${items.words.get(0).word}"/>
                            <span style="color: red">
                        <c:if test="${items.words.get(0).id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                        </td>
                        <td>
                            <button type="button" name="_eventId_editWord" onclick="edit('${items.words.get(0).id}inpO','word')" style="background: url(/images/edit.svg);
    background-size: 38px 35px;" title="изменить"></button>
                            <button type="button"  name="_eventId_deletedWord" onclick="del('${items.words.get(0).id}inpO','word')" style="background: url(/images/delete.png);
    background-size: 38px 35px;" title="удалить"></button>
                        </td>
                    </tr>
                    <tbody id="${items.id}t2">
                    </tbody>
                </c:if>
                <c:if test="${items.words.size()>1}">
                    <tbody id="${items.id}M" style="display: none;">
                    <c:forEach items="${items.words}" var="words">
                        <tr>
                            <td></td>
                            <td><input id="${words.id}inpM" type="text" name="${words.id}"  value="${words.word}"/>
                                <span style="color: red">
                        <c:if test="${words.id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                            </td>
                            <td>
                                <button type="button" name="_eventId_editWord" onclick="edit2('${words.id}inpM','${items.id}')" style="background: url(/images/edit.svg);
    background-size: 38px 35px;" title="изменить"></button>
                                <button type="button" name="_eventId_deletedWord" onclick="del2('${words.id}inpM','${items.id}')" style="background: url(/images/delete.png);
    background-size: 38px 35px;" title="удалить"></button>
                            </td>
                        </tr>
                    </c:forEach>
                    <tbody id="${items.id}t2">
                    </tbody>
                    </tbody>
                </c:if>
            </c:forEach>
        </c:if>
        <tbody id="table">
        </tbody>
    </table>
</div>
