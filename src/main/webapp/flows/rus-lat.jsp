<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.min.js"/>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<form id="forma1"  method="post">
    <h><c:choose><c:when test="${rus eq true}"></c:when></c:choose></h>
    <br>
    <h2>Message from Server: ${out.outMess}</h2>
    <br>
    <c:if test="${not empty out.outList}">
    <c:forEach items="${out.outList}" var="items">
        ${items}
    </c:forEach>
    </c:if>
    <br>
    <h3 id="h3"><tiles:insertAttribute name="view1" ignore="true"/> </h3>
    <br>
    <c:out value = "${out.outMess}"/>
    <br>
    <h>Change the Operations</h>
    <br>
    <input  type="text" name="inputNameRus" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <br>
    <input id="knopka1" type="submit" class="button" name="_eventId_nextRusDelete" value="Delete"/>
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

<script type="application/javascript">
    $(document).ready(function () {
        $("#knopka1").on("click",function () {
            $("#forma1").ajaxSubmit({
                url:"${flowExecutionUrl}&_eventId=nextRusDelete",
                success:function (html) {
                    $("#h3").html(html);
                },
                error:function (error) {
                    console.log(error)
                }
            })
        })
    })
</script>