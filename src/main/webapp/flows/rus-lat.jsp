<form method="post">
    <h>Rus-Lat</h>
    <br>
    <h2>Hello ${out.outMess}!!!</h2>
    <br>
    <c:forEach items="${out.outList}" var="iteme">
        ${iteme}<br>
    </c:forEach>
    <br>
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