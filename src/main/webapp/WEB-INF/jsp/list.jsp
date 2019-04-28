<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 28.04.2019
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul id="list">
    <c:if test="${not empty out.keys}">
        <c:forEach items="${out.keys}" var="items">
            <li value="${items.id}">key: <b>${items.key}</b><button  type="button" class="button" name="${items.key}">Удалить</button>
                <button type="button" class="editbutKey" onclick="edit(this)">Редактировать</button><input type="hidden" class="editText" value="${items.key}">
                <c:choose><c:when test="${items.words.size()==1}"><b>${items.words.get(0).word}</b>
                    <button  type="button"  class="list" name="${items.words.get(0).word}">Удалить</button>
                    <button type="button" class="editbutWord" onclick="edit(this)">Редактировать</button><input type="hidden" class="editText" value="${items.words.get(0).word}">
                </c:when><c:when test="${items.words.size()>1}">
                    <button class="list" type="button" onclick="getList()">несколько значений</button>
                    <div id="hidden" hidden="false"><ul><c:forEach items="${items.words}" var="words"><li><b>${words.word}</b>
                        <button type="button" class="list" name="${words.word}">Удалить</button>
                        <button type="button" class="editbutWord" onclick="edit(this)">Редактировать</button><input type="hidden" class="editText" value="${words.word}">
                    </li></c:forEach></li></ul></div></c:when></c:choose></li>
        </c:forEach>
        ${out.outList=null}
    </c:if>
</ul>
