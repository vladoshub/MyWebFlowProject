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
            <td><input id="searchkey" name="searchkey"  type="text" value=""><button type="submit" name="_eventId_SearchKeys">ПоискПоКлючу</button></td>
            <td><input id="searchwrod" name="searchword" type="text" value=""><button type="submit" name="_eventId_SearchWords">ПоискПоЗначению</button></td>
            <td><button type="button" onclick="addKey('table')">добавить</button></td>
        </tr>
    </table>
    <br>
    <table border="1" width="100%" cellpadding="5" id="table" class="two">
        <tr>
            <th>Ключ</th>
            <th>Значения</th>
            <th>Действия</th>
        </tr>
        <c:if test="${not empty out.words}">
            <c:forEach items="${out.words}" var="items">
                <tr>
                    <td><input value="${items.key.key}" id="${items.key.id}inpK"></td>
                    <td><input value="${items.word}" readonly="readonly" id="${items.id}inpW"><button onclick="hiddRow('${items.id}WW')">Изменить</button></td>
                    <td>
                        <button type="button" name="_eventId_editKey" onclick="edit('${items.key.id}inpK','key')">Редактировать</button>
                        <button type="button" name="_eventId_deletedKey" onclick="del('${items.key.id}inpK','key')">Удалить</button></td>
                </tr>
                <tr class="${items.id}WW" style="display: none;">
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
                        <c:if test="${items.id == out.keysDtos.id}">${out.outMess}</c:if>
                    </span></td>
                    <c:choose><c:when
                            test="${items.words.size()==1}">
                        <td>
                            <input type="text"  value="${items.words.get(0).word}" id="${items.id}inpOO"/><span style="color: red">
                        <c:if test="${items.words.get(0).id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                            <button type="button" onclick="hiddRow('${items.id}O')"><></button>
                        </td>
                    </c:when><c:when test="${items.words.size()>1}">
                        <td>
                            <input type="text" value="${items.words.get(0).word}..." readonly="readonly"/><span  style="color: red">
                        <c:if test="${items.id == out.keysDtos.id}">${out.outMess}</c:if>
                    </span>
                            <button type="button" onclick="hiddRow('${items.id}M')"><></button>
                        </td>

                    </c:when></c:choose>
                    <td>
                        <button type="button" name="_eventId_editKey" onclick="edit('${items.id}inpK','key')">Редактировать</button>
                        <button type="button" name="_eventId_deletedKey" onclick="del('${items.id}inpK','key')">Удалить</button>
                        <button type="button" onclick="addWord('${items.id}t2',${items.id})">Добавить</button>
                    </td>
                </tr>
                <tbody id="${items.id}t2">
                </tbody>
                <c:if test="${items.words.size()==1}">
                    <tr class="${items.id}O" style="display: none;">
                        <td></td>
                        <td><input id="${items.words.get(0).id}inpO" type="text" name="${items.words.get(0).id}"  value="${items.words.get(0).word}"/>
                            <span style="color: red">
                        <c:if test="${items.words.get(0).id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                        </td>
                        <td>
                            <button type="button" name="_eventId_editWord" onclick="edit('${items.words.get(0).id}inpO','word')">Редактировать</button>
                            <button type="button"  name="_eventId_deletedWord" onclick="del('${items.words.get(0).id}inpO','word')">Удалить</button>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${items.words.size()>1}">
                    <c:forEach items="${items.words}" var="words">
                        <tr class="${items.id}M" style="display: none;">
                            <td></td>
                            <td><input id="${words.id}inpM" type="text" name="${words.id}"  value="${words.word}"/>
                                <span style="color: red">
                        <c:if test="${words.id == out.wordsDtos.id}">${out.outMess}</c:if>
                    </span>
                            </td>
                            <td>
                                <button type="button" name="_eventId_editWord" onclick="edit('${words.id}inpM','${items.id}')">Редактировать</button>
                                <button type="button" name="_eventId_deletedWord" onclick="del('${words.id}inpM','word')">Удалить</button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </c:if>
    </table>
</div>
