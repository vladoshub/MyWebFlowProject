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
            <li value="${items.id}">key: <b>${items.key}</b><button  type="button"  onclick="delByKey(this)" class="button" name="${items.key}">Удалить</button>
                <button type="button" class="editbutKey" name="${items.key}" value="edit" onclick="edit(this)">Редактировать</button><div hidden="false" class="${items.key}"><input type="text"  value="${items.key}"/></div>
                <c:choose><c:when test="${items.words.size()==1}"><b>${items.words.get(0).word}</b>
                    <button  type="button"  class="list" onclick="delByWord(this)" name="${items.words.get(0).word}">Удалить</button>
                    <button type="button" class="editbutWord" name="${items.id+items.words.get(0).id}" value="edit"  onclick="edit(this)">Редактировать</button><div hidden="false" class="${items.id+items.words.get(0).id}"><input type="text"  value="${items.words.get(0).word}"/></div>
                </c:when><c:when test="${items.words.size()>1}">
                    <button class="list" type="button" name="${items.id}" onclick="getList(this)">несколько значений</button>
                    <div id="hidden" class="${items.id}" hidden="false"><ul><c:forEach items="${items.words}" var="words"><li><b>${words.word}</b>
                        <button type="button" class="list" onclick="delByWord(this)" name="${words.word}">Удалить</button>
                        <button type="button" class="editbutWord" name="${items.id+words.id}" value="edit"  onclick="edit(this)">Редактировать</button><div hidden="false" class="${items.id+words.id}"><input type="text"  value="${words.word}"/></div>
                    </li></c:forEach></li></ul></div></c:when></c:choose></li>
        </c:forEach>
        ${out.outList=null}
    </c:if>
</ul>
