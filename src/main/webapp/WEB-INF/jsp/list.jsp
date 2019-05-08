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
            <li value="${items.id}">key: <b>${items.key}</b><button  type="button"  onclick="del(this)" class="button" value="${items.id}" name="_eventId_deletedKey"><img src="${pageContext.request.contextPath}/images/delete.png"/>Удалить</button>
                <button type="button" class="close" name="_eventId_editKey" id="${items.id}C" value="${items.id}" onclick="ed(this,'KeyDiv')"><img src="${pageContext.request.contextPath}/images/edit.svg"/>Редактировать</button><div hidden="false" id="${items.id}KeyDiv"><input type="text"  value="${items.key}"/><button type="button" class="list"  onclick="closeBut(this,'KeyDiv')" id="${items.id}" value="${items.id}">отмена</button></div>
                <c:choose><c:when test="${items.words.size()==1}"><b>word:${items.words.get(0).word}</b>
                    <button  type="button"  class="list" onclick="del(this)"  name="_eventId_deletedWord" value="${items.words.get(0).id}"><img src="${pageContext.request.contextPath}/images/delete.png"/>Удалить</button>
                    <button type="button" class="close" name="_eventId_editWord" id="${items.words.get(0).id}C" value="${items.words.get(0).id}"  onclick="ed(this,'WordDiv')"><img src="${pageContext.request.contextPath}/images/edit.svg"/>Редактировать</button><div hidden="false" id="${items.words.get(0).id}WordDiv"><input type="text" value="${items.words.get(0).word}"/><button type="button"  onclick="closeBut(this,'WordDiv')" class="list" id="${items.words.get(0).id}" value="${items.words.get(0).id}">отмена</button></div>
                </c:when><c:when test="${items.words.size()>1}">
                    <button class="list" type="button" name="${items.id}" onclick="getList(this)">несколько значений</button>
                    <div id="${items.id}List" hidden="false"><ul><c:forEach items="${items.words}" var="words"><li><b>word:${words.word}</b>
                        <button type="button" class="list" onclick="del(this)" name="_eventId_deletedWord" value="${words.id}" ><img src="${pageContext.request.contextPath}/images/delete.png"/>Удалить</button>
                        <button type="button" class="close" name="_eventId_editWord" id="${words.id}C" value="${words.id}"  onclick="ed(this,'WordDiv')"><img src="${pageContext.request.contextPath}/images/edit.svg"/>Редактировать</button><div id="${words.id}WordDiv" hidden="false"><input type="text"  value="${words.word}"/><button type="button" onclick="closeBut(this,'WordDiv')" class="list" id="${words.id}" value="${words.id}">отмена</button></div>
                    </li></c:forEach></li></ul></div></c:when></c:choose></li>
        </c:forEach>
        ${out.outList=null}
    </c:if>
</ul>
