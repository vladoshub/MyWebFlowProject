<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>hellooooooo</title>
    <script src="/js/form/jquery.js"></script>
    <script src="/js/form/jquery.form.js"></script>
    <script src="/js/Render.js"></script>
    <script type="application/javascript">
        Render("_eventId_nextRusSearch");
    </script>
</head>
<body>
<form id="forma1"  method="post">
    <div><tiles:insertAttribute name="hello"/></div>
    <div><c:choose><c:when test="${out.rus eq true}"><h1>you chose Russ to Latin</h1></c:when><c:when test="${out.rus ne true}"><h1>you chose Bin to Dec</h1></c:when></c:choose></div>
    <br>
    <div id="mess"><tiles:insertAttribute name="messageFromServer"/></div>
    <br>
    <div id="req"><tiles:insertAttribute name="requestFromServer"/></div>
    <br>
    <input  type="text" name="inputNameRus" value=""/>
    <br>
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
</body>
</html>