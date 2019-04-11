<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<form method="post">
    <h>Rus-Lat</h>
    <br>
    <h2>Message from Server: ${out.outMess}</h2>
    <br>
    <c:if test="${not empty out.outList}">
    <c:forEach items="${out.outList}" var="items">
        ${items}
    </c:forEach>
    </c:if>
    <br>
    <c:out value = "${out.outMess}"/>
    <br>
    <h>Change the Operations</h>
    <br>
    <input type="text" name="inputNameRus" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <br>
    <input type="submit" class="button" name="_eventId_nextRusDelete" value="Delete"/>
    <br>
    <input type="submit" class="button" name="_eventId_nextRusSearch" value="search by key"/>
    <br>
    <input type="submit" class="button" name="_eventId_nextRusAdd" value="add by key"/>
    <br>
    <input type="submit" class="button" name="_eventId_nextRusPrint" value="out vocabulary"/>
    <br>
    <input type="submit" class="button" name="_eventId_next" value="Main"/>
    <br>
    <input type="submit" class="button" name="_eventId_nextBin" value="Bin-Dec"/>

</form>