<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
    <style>
        <%@include file="/WEB-INF/css/table.css"%>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.simplePagination.js"></script>
    <script type="application/javascript">


        $(window).load(function () {
            $('#light-pagination').pagination({
                items: 100,
                itemsOnPage: 10,
                hrefTextPrefix: '',
                hrefTextSuffix: '.html',
                prevText: 'Начало',
                nextText: 'Конец'
            });

        });
        function edit(id, op)
        {
            if ((op + '') == 'key') {
                document.getElementById("key").value = document.getElementById(id).value;
                document.getElementById("ID").value = document.getElementById(id).name;
                $("#forma1").ajaxSubmit({

                    url: "${flowExecutionUrl}&_eventId_editKey&ajaxSource=true",
                    success: function (html) {
                        $("#voc").html($(html).filter("#voc")),
                            $("#answer").html($(html).filter("#answer"));
                    },
                    error: function (error) {
                        console.log(error)
                    }
                });
            }
            else {
                document.getElementById("word").value = document.getElementById(id).value;
                document.getElementById("ID").value = document.getElementById(id).name;
                $("#forma1").ajaxSubmit({

                    url: "${flowExecutionUrl}&_eventId_editWord&ajaxSource=true",
                    success: function (html) {
                        $("#voc").html($(html).filter("#voc")),
                            $("#answer").html($(html).filter("#answer"));
                    },
                    error: function (error) {
                        console.log(error)
                    }
                });
            }
        }


        function hiddRow(id) {
            $('.' + id).toggle();
        }






            function del(id, op) {
                if ((op + '') == 'key') {
                    document.getElementById("ID").value = document.getElementById(id).name;
                    $("#forma1").ajaxSubmit({

                        url: "${flowExecutionUrl}&_eventId_deletedKey&ajaxSource=true",
                        success: function (html) {
                            $("#voc").html($(html).filter("#voc")),
                                $("#answer").html($(html).filter("#answer"));

                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                }
                else {
                    document.getElementById("ID").value = document.getElementById(id).name;
                    $("#forma1").ajaxSubmit({

                        url: "${flowExecutionUrl}&_eventId_deletedWord&ajaxSource=true",
                        success: function (html) {
                            $("#voc").html($(html).filter("#voc")),
                                $("#answer").html($(html).filter("#answer"));
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                }

            }


            function addWord(id, idKey) {
                var a = Math.random() * (10000) + 2;
                var tbody = document.getElementById(id);
                var row = document.createElement("TR");
                var td1 = document.createElement("TD");
                var td2 = document.createElement("TD");
                var td3 = document.createElement("TD");
                var inp = document.createElement("input");
                var butSave = document.createElement("button");
                var butDel = document.createElement("button");
                inp.id = a + "input";
                inp.name = idKey + '';
                row.id = a + "R";
                butSave.textContent = "Сохранить";
                butSave.type = "button";
                butSave.name = "_eventId_addWordsss"
                butDel.textContent = "Удалить";
                butDel.onclick = function () {
                    var id = a + "R";
                    document.getElementById(id).remove();
                }
                butSave.onclick = function () {
                    var id = a + "input";
                    var id2 = a + "R";
                    var text = document.getElementById(id).value;
                    var text2 = document.getElementById(id).name;
                    document.getElementById("word").value = text;
                    document.getElementById("ID").value = text2;
                    $("#forma1").ajaxSubmit({

                        url: "${flowExecutionUrl}&_eventId_addWordsss&ajaxSource=true",
                        success: function (html) {
                            $("#voc").html($(html).filter("#voc")),
                                $("#answer").html($(html).filter("#answer"));
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                }

                td2.appendChild(inp);
                td3.appendChild(butDel);
                td3.appendChild(butSave);
                row.appendChild(td1);
                row.appendChild(td2);
                row.appendChild(td3);
                tbody.appendChild(row);
            }

            function addKey(id) {
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
                inp.id = a + "inputWord";
                inp2.id = a + "inputKey";
                row.id = a + "R";
                butSave.textContent = "Сохранить";
                butSave.type = "button";
                butSave.name = "_eventId_addWordss"
                butDel.textContent = "Удалить";
                butDel.onclick = function () {
                    var id = a + "R";
                    document.getElementById(id).remove();
                }
                butSave.onclick = function () {
                    var word = a + "inputWord";
                    var id2 = a + "R";
                    var key = a + "inputKey";
                    var word2 = document.getElementById(word).value;
                    var key2 = document.getElementById(key).value;
                    document.getElementById("word").value = word2;
                    document.getElementById("key").value = key2;
                    $("#forma1").ajaxSubmit({

                        url: "${flowExecutionUrl}&_eventId_addWordss&ajaxSource=true",
                        success: function (html) {
                            $("#voc").html($(html).filter("#voc")),
                                $("#answer").html($(html).filter("#answer"));
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                }

                td1.appendChild(inp2)
                td2.appendChild(inp);
                td3.appendChild(butDel);
                td3.appendChild(butSave);
                row.appendChild(td1);
                row.appendChild(td2);
                row.appendChild(td3);
                table.appendChild(row);
            }


        function edit2(id,id2)
            {
                document.getElementById("word").value = document.getElementById(id).value;
                document.getElementById("ID").value = document.getElementById(id).name;
                var ids="";
                ids=ids+id2;
                document.getElementById("kID").value = ids;
                $("#forma1").ajaxSubmit({

                    url: "${flowExecutionUrl}&_eventId_editWord&ajaxSource=true",
                    success: function (html) {
                        $("#voc").html($(html).filter("#voc")),
                            $("#answer").html($(html).filter("#answer"));
                    },
                    error: function (error) {
                        console.log(error)
                    }
                });
            }

        function del2(id,id2) {
                document.getElementById("ID").value = document.getElementById(id).name;
            var ids="";
            ids=ids+id2;
            document.getElementById("kID").value = ids;
                $("#forma1").ajaxSubmit({

                    url: "${flowExecutionUrl}&_eventId_deletedWord&ajaxSource=true",
                    success: function (html) {
                        $("#voc").html($(html).filter("#voc")),
                            $("#answer").html($(html).filter("#answer"));

                    },
                    error: function (error) {
                        console.log(error)
                    }
                });

        }





    </script>
</head>
<body>
<form id="forma1" method="post">
    <input id="key" name="key" type="hidden" value="">
    <input id="word" name="word" type="hidden" value="">
    <input id="ID" name="ID" type="hidden" value="">
    <input id="kID" name="kID" type="hidden" value="">
    <tiles:insertAttribute name="voc"/>
</form>
</body>
</html>