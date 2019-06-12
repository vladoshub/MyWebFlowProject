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
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <title>Словарь</title>
    <style>
        <%@include file="/WEB-INF/css/table.css"%>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.simplePagination.js"></script>
    <script type="application/javascript">

        var rows = 0;
        var rows1 = 0;
        var wordInKey = 0;
        var check=0;

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

        function edit(id, op, newword) {
            newword = newword + "";
            if (newword == document.getElementById(id).value || newword == "") {
                alert("введите что-нибудь или измененное значение");
            }
            else {
                check=0;
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
        }


        function hiddRow(id) {
            $('#' + id).toggle();
        }


        function del(id, op) {
            check=0;
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

        function addAllWord(id, idKey){
            check=0;
            var words="";
            var x = document.getElementById(id).getElementsByTagName('input');
            for (var i=0;i<x.length;i++) {
                if (x[i].value != "") {
                    words = words + x[i].value + "#_#";
                }
            }
            if(words!=""){
                words=words.substring(0, words.length - 3);
                document.getElementById("word").value = words;
                document.getElementById("ID").value = idKey;
                $("#forma1").ajaxSubmit({
                    url: "${flowExecutionUrl}&_eventId_editManyWordsInKey&ajaxSource=true",
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
                alert("введите что-нибудь")
            }
        }

        function addWord(id, idKey) {
            if(check==0) {
                $("button[name~='WordsInK']").toggle();
                $('#butAddOneWord' + idKey).toggle();
            }
            check++;
            if(check==2){
                $('#butAllWord' + idKey).attr("style","background: url(/images/addAll.png);background-size:38px 35px");
                $('#butAllWord' + idKey).attr("disabled",false);
            }
            var a = "rows" + rows;
            rows++;
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
            butSave.title = "Сохранить";
            butSave.type = "button";
            butSave.name = "_eventId_addWordsss";
            butSave.style = "background: url(/images/upload.png);background-size: 38px 35px;";
            butDel.title = "Удалить";
            butDel.style = "background: url(/images/del.png);background-size: 38px 35px;";
            butDel.onclick = function () {
                document.getElementById(row.id).remove();
                check--;
                var x = document.getElementById(id).getElementsByTagName('input');
                if(check==1){
                    $('#butAllWord' + idKey).attr("style","background: url(/images/addAllBW.png);background-size:38px 35px");
                    $('#butAllWord' + idKey).attr("disabled",true);
                }
                if (!x[0]){
                    check=0;
                    $( "button[name~='WordsInK']" ).toggle();
                    $('#butAddOneWord' + idKey).toggle();
                    $('#butAllWord' + idKey).attr("style","background: url(/images/addAllBW.png);background-size:38px 35px");
                    $('#butAllWord' + idKey).attr("disabled",true);
                }
            }
            butSave.onclick = function () {
                check=0;
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
            row.style = "background: deepskyblue;";
            tbody.appendChild(row);
        }

        function addKey(id) {
            var a = "rows1" + rows1;
            rows1++;
            var table = document.getElementById(id);
            var row = document.createElement("TR");
            var td1 = document.createElement("TD");
            var td2 = document.createElement("TD");
            var td3 = document.createElement("TD");
            var inp = document.createElement("input");
            var inp2 = document.createElement("input");
            var butSave = document.createElement("button");
            var butDel = document.createElement("button");
            var addWord = document.createElement("button");
            inp.id = a + "inputWord";
            inp2.id = a + "inputKey";
            row.id = a + "R";
            addWord.title = "Добавить слово";
            addWord.type = "button";
            addWord.style = "background: url(/images/add.png);background-size: 38px 35px;  margin-left:25px;";
            butSave.title = "Сохранить";
            butSave.type = "button";
            butSave.style = "background: url(/images/upload.png);background-size: 38px 35px; float:right; margin-left:10px;";
            butDel.title = "Удалить";
            butDel.style = "background: url(/images/del.png);background-size: 38px 35px;";
            butDel.onclick = function () {
                var id = a + "R";
                var x = document.getElementsByName("rowWord");
                while (x[0]) x[0].remove();//при обычном for длина массива будет динамически менятся при удалении элемента
                document.getElementById(id).remove();
                $('#ButAdd').attr('disabled', false);
                $('#ButAdd').attr('style', "background: url(/images/addKey.png);background-size: 38px 35px;float:right;margin-left:10px");
            }
            addWord.onclick = function () {
                var butDel = document.createElement("button");
                var id = wordInKey + "manyWord";
                butDel.onclick = function () {
                    document.getElementById(id).remove();
                }
                butDel.style = "background: url(/images/del.png);background-size: 38px 35px;";
                var tdW = document.createElement("TD");
                var tdWInp = document.createElement("TD");
                var tdWBut = document.createElement("TD");
                var inpW = document.createElement("input");
                inpW.setAttribute("name", "allInp");
                tdWBut.appendChild(butDel);
                var rowW = document.createElement("TR");
                rowW.setAttribute("name", "rowWord");
                rowW.setAttribute("id", id);
                wordInKey = wordInKey + 1;
                tdWInp.appendChild(inpW);
                rowW.appendChild(tdW);
                rowW.appendChild(tdWInp);
                rowW.appendChild(tdWBut);
                table.appendChild(rowW);


            }

            butSave.onclick = function () {
                check=0;
                var word = a + "inputWord";
                var id2 = a + "R";
                var key = a + "inputKey";
                var allW = "";
                var word2 = document.getElementById(word).value;
                var key2 = document.getElementById(key).value;
                var x = document.getElementsByName("allInp");
                for (var i=0;i<x.length;i++) {
                    if (x[i].value != "") {
                        allW = allW + x[i].value + "#_#";
                    }
                }
                if (allW != "") {
                    allW=allW.substring(0, allW.length - 3);
                    butSave.name = "_addManyWordsAndKey";
                    document.getElementById("word").value = word2 + "#_#" + allW;
                    document.getElementById("key").value = key2;
                    $("#forma1").ajaxSubmit({
                        url: "${flowExecutionUrl}&_eventId_addManyWordsAndKey&ajaxSource=true",
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
                    butSave.name = "_eventId_addWordss";
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
            }

            td1.appendChild(inp2)
            td2.appendChild(inp);
            td3.appendChild(butDel);
            td3.appendChild(butSave);
            td3.appendChild(addWord);
            row.appendChild(td1);
            row.appendChild(td2);
            row.appendChild(td3);
            row.style = "background: lightblue;";
            table.appendChild(row);
            table.appendChild(row);
            $('#ButAdd').attr('disabled', true);
            $('#ButAdd').attr('style', "background: url(/images/addKeyBW.png);background-size: 38px 35px;float:right;margin-left:10px");
        }


        function edit2(id, id2, newword) {
            newword = newword + "";
            if (newword == document.getElementById(id).value || newword == "") {
                alert("введите что-нибудь или измененное значение");
            }
            else {
                check=0;
                document.getElementById("word").value = document.getElementById(id).value;
                document.getElementById("ID").value = document.getElementById(id).name;
                var ids = "";
                ids = ids + id2;
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
        }

        function del2(id, id2) {
            document.getElementById("ID").value = document.getElementById(id).name;
            var ids = "";
            ids = ids + id2;
            document.getElementById("kID").value = ids;
            check=0;
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