<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 28.04.2019
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Словарь</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <script type="application/javascript">

        function hiddRow(id,el) {
            $('.'+id).toggle();
        }
        function edit() {

        }
        function del() {

        }
        function addKey(id) {
            var a = Math.random() * (10000) + 2;
          var tbody = document.getElementById(id);
            var row = document.createElement("TR");
            var td1 = document.createElement("TD");
            var td2 = document.createElement("TD");
            var td3 = document.createElement("TD");
            var inp = document.createElement("input");
            var butSave = document.createElement("button");
            var butDel = document.createElement("button");
            inp.id=a+"input";
            row.id=a+"R";
            butSave.textContent="save";
            butDel.textContent="del";
            butDel.onclick = function () {
                var id=a+"R";
                document.getElementById(id).remove();
            }
            butSave.onclick = function () {
                var id=a+"input";
                var text = document.getElementById(id).value;
                document.getElementById("word").value=text;
            }

            td2.appendChild(inp);
            td3.appendChild(butDel);
            td3.appendChild(butSave);
            row.appendChild(td1);
            row.appendChild(td2);
            row.appendChild(td3 );
          tbody.appendChild(row);
        }

        function addRow(id) {
            var a = Math.random() * (10000) + 2;
            var table = document.getElementById(id);
            var row = document.createElement("TR");
            var td1 = document.createElement("TD");
            var td2 = document.createElement("TD");
            var td3 = document.createElement("TD");
            var inp = document.createElement("input");
            var inp2 = document.createElement("input");
            var butSave = document.createElement("button");
            var butDel = document.createElement("button");
            inp.id=a+"inputWord";
            inp2.id=a+"inputKey";
            row.id=a+"R";
            butSave.textContent="save";
            butDel.textContent="del";
            butDel.onclick = function () {
                var id=a+"R";
                document.getElementById(id).remove();
            }
            butSave.onclick = function () {
                var word=a+"inputWord";
                var key=a+"inputKey";
                var word2 = document.getElementById(word).value;
                var key2 = document.getElementById(key).value;
                document.getElementById("word").value=word2;
                document.getElementById("key").value=key2;
            }

            td1.appendChild(inp2)
            td2.appendChild(inp);
            td3.appendChild(butDel);
            td3.appendChild(butSave);
            row.appendChild(td1);
            row.appendChild(td2);
            row.appendChild(td3 );
            table.appendChild(row);
        }
        function searchByKey() {

        }
        function searchByWord() {

        }

    </script>
</head>
<body>

<input id="key" type="hidden" value="">
<input id="word" type="hidden" value="">
<table border="0" width="100%" cellpadding="5">
    <tr>
        <td><input id="searchkey" type="text" value=""><button onclick="searchByKey()">ПоискПоКлючу</button></td>
        <td><input id="searchwrod" type="text" value=""><button onclick="searchByWord()">ПоискПоЗначению</button></td>
        <td><button onclick="addRow('table')">добавить</button></td>
    </tr>
</table>
<br>
<table border="1" width="100%" cellpadding="5" id="table">
    <tr>
        <th>Ключ</th>
        <th>Значения</th>
        <th>Действия</th>
    </tr>
    <c:if test="${not empty out.keys}">
        <c:forEach items="${out.keys}" var="items">
    <tbody id="${items.id}t">
            <tr id="${items.id}">
                <td><input type="text"  value="${items.key}" id="${items.id}inpK"/></td>
                <c:choose><c:when
                        test="${items.words.size()==1}">
                    <td>
                    <input type="text"  value="${items.words.get(0).word}" id="${items.id}inpOO"/>
                    </td>
                </c:when><c:when test="${items.words.size()>1}">
                    <td>
                        <input type="text" value="${items.words.get(0).word}..." readonly="readonly"/>
                        <button onclick="hiddRow('${items.id}M',this)">показать</button>
                    </td>

                </c:when></c:choose>
            <td>
                <button onclick="edit('${items.id}K',this)">edit</button>
                <button onclick="del('${items.id}K',this)">del</button>
                <button onclick="addKey('${items.id}t2')">добавить</button>
            </td>
            </tr>
            <tbody id="${items.id}t2">
            </tbody>
            <c:if test="${items.words.size()==1}">
            <tr class="${items.id}O" style="display: none;">
                <td></td>
                <td><input id="${items.words.get(0).id}inpO" type="text"  value="${items.words.get(0).id}"/></td>
                <td>
                    <button onclick="edit('${items.id}O ',this)">edit</button>
                    <button onclick="del('${items.id}O',this)">del</button>
                </td>
            </tr>
            </c:if>
            <c:if test="${items.words.size()>1}">
                <c:forEach items="${items.words}" var="words">
                    <tr class="${items.id}M" style="display: none;">
                        <td></td>
                        <td><input id="${words.id}inpM" type="text"  value="${words.word}"/></td>
                        <td>
                            <button onclick="edit('${items.id}M ',this)">edit</button>
                            <button onclick="del('${items.id}M',this)">del</button>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
    </tbody>
        </c:forEach>
    </c:if>
</table>
</body>
</html>