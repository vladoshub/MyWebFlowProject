<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 28.04.2019
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="list">
    <ul class="list_ul">
        <c:if test="${not empty out.keys}">
            <c:forEach items="${out.keys}" var="items">
                <li value="${items.id}"><span>key: <b>${items.key}</b></span>
                    <button type="button" onclick="del(this)" class="button" value="${items.id}"
                            name="_eventId_deletedKey"><img src="${pageContext.request.contextPath}/images/delete.png"/>
                    </button>
                    <button type="button" name="_eventId_editKey" id="${items.id}C" value="${items.id}"
                            onclick="ed(this,'KeyDiv','${items.key}')"><img
                            src="${pageContext.request.contextPath}/images/edit1.svg"/></button>
                    <div class="inp" hidden="false" id="${items.id}KeyDiv"><input type="text" value="${items.key}"/>
                        <button type="button" class="list" onclick="closeBut(this,'KeyDiv')" id="${items.id}"
                                value="${items.id}"><img src="${pageContext.request.contextPath}/images/undo.png"/>
                        </button>
                    </div>
                    <c:choose><c:when
                            test="${items.words.size()==1}"><span><b>word:${items.words.get(0).word}</b></span>
                        <button type="button" onclick="del(this)" name="_eventId_deletedWord"
                                value="${items.words.get(0).id}"><img
                                src="${pageContext.request.contextPath}/images/delete.png"/></button>
                        <button type="button" name="_eventId_editWord" id="${items.words.get(0).id}C"
                                value="${items.words.get(0).id}"
                                onclick="ed(this,'WordDiv','${items.words.get(0).word}')" ><img
                                src="${pageContext.request.contextPath}/images/edit1.svg"/></button>
                        <div class="inp" hidden="false" id="${items.words.get(0).id}WordDiv"><input type="text"
                                                                                                    value="${items.words.get(0).word}"/>

                                    id="${items.words.get(0).id}" value="${items.words.get(0).id}"><img
                                    src="${pageContext.request.contextPath}/images/undo.png"/></button>
                        </div>
                    </c:when><c:when test="${items.words.size()>1}">
                        <button type="button" name="${items.id}" onclick="getList(this)"><img
                                src="${pageContext.request.contextPath}/images/any.png"/></button>
                        <div id="${items.id}List" hidden="false">
                            <ul><c:forEach items="${items.words}" var="words">
                                <li><b>word:${words.word}</b>
                                    <button type="button" onclick="del(this)" name="_eventId_deletedWord"
                                            value="${words.id}"><img
                                            src="${pageContext.request.contextPath}/images/delete.png"/></button>
                                    <button type="button" name="_eventId_editWord" id="${words.id}C" value="${words.id}"
                                            onclick="ed(this,'WordDiv','${words.word}')"><img
                                            src="${pageContext.request.contextPath}/images/edit1.svg"/></button>
                                    <div class="inp" id="${words.id}WordDiv" hidden="false"><input type="text"
                                                                                                   value="${words.word}"/>
                                        <button type="button" onclick="closeBut(this,'WordDiv')" class="list"
                                                id="${words.id}" value="${words.id}"><img
                                                src="${pageContext.request.contextPath}/images/undo.png"/></button>
                                    </div>
                                </li>
                            </c:forEach></ul>
                        </div>
                    </c:when></c:choose></li>
            </c:forEach>
        </c:if>
    </ul>
</div>
