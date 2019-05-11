<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<ul id="editVocDelFragment">
    <c:if test="${not empty out.keys}">
        <c:forEach items="${out.keys}" var="items">
            <li value="${items.id}">key: <b>${items.key}</b> <c:choose><c:when test="${items.words.size()==1}"><b>${items.words.get(0).word}</b><button>Удалить</button></c:when><c:when test="${items.words.size()>1}"><button onclick="getList()">несколько значений</button>
                <div id="hidden" hidden="false"><ul><c:forEach items="${items.words}" var="words"><li><b>${words.word}</b><button>Удалить</button></li></c:forEach></li></ul></div></c:when></c:choose></li>
        </c:forEach>
        ${out.keys=null}
    </c:if>
</ul>