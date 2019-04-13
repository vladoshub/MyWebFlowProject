<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request"/>
<script type="text/javascript" src="${contextPath}/js/form/jquery.form.min.js"/>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<head>

    <title><tiles:getAsString name="title"/></title>
</head>
<form id="forma1"  method="post">
    <div><c:choose><c:when test="${rus eq true}"></c:when></c:choose></div>
    <br>
    <h1><tiles:insert attribute="messageFromServer" irgore="true"/></h1>
    <br>
    <label><tiles:insert attribute="requestFromServer" irgore="true"/></label>
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
</body>
</html>