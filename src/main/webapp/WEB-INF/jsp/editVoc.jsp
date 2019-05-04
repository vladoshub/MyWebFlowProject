<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: влад
  Date: 13.04.2019
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
<script type="application/javascript">


    function  getList() {
        $('#hidden').toggle();
    }

    function  addWord() {
        var element = document.createElement('input');
        var element2 = document.createElement('br');
        element.innerHTML = element.type="text";
        element.innerHTML = element.id="input";
        document.body.appendChild(element2);
        document.body.appendChild(element);
    }


    function readAllWords(){
        var values2=$('body').find('#input2');
        var values=$('body').find('#input');

            var Key="";
            Key = Key + values2[0].value;
        if(!(Key==""||Key==null)) {
            $('#Keyhidden').attr("value",Key);
            var all = "";
            if (values.length >= 1) {
                for (var i = 0; i < values.length; ++i) {
                    if (!values[i].value=='')
                    all = all + values[i].value + "%_%";
                }
                if(!(all==""||all==null))
                $('#allWord').attr("value", all),
                    $('body').find('#input2').attr("value",""),
                $('body').find('#input').attr("value",""),
                $("#forma2").ajaxSubmit({

                    url:"${flowExecutionUrl}&_eventId_addWords&ajaxSource=true",
                    success:function (html) {
                        $("#editVocAddManyWordsFragment").html($(html).filter("#editVocAddManyWordsFragment")),
                    },
                    error:function (error) {
                        console.log(error)
                    }
                });
                else {
                    alert("введите слово");
                }
            }
            else {
                alert("введите слово");
            }
        }
        else {
            alert("введите ключ");
        }
    }

</script>
</head>
<html>
<body>
<form id="forma2"  method="post">
<tiles:insertAttribute name="editVocAddManyWordsFragment"/>
</form>
</body>
</html>