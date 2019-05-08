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
<html>
<head>
    <style>
        <%@include file="/WEB-INF/css/listPage.css" %>
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
    <script type="application/javascript">

        function getList(el) {
            var name = "#" + el.name + "List";
            $(name).toggle();
        }

        function del(el) {

            $("#edit").attr("value", el.value)
            $("#forma1").ajaxSubmit({

                url: "${flowExecutionUrl}&" + el.name + "&ajaxSource=true",
                success: function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error: function (error) {
                    console.log(error)
                }
            })
        }

        function closeBut(el, type) {

            var id = el.id+"";
            var name ="#"+el.value + type;
            $("#"+id + "O").attr("id", id + "C");
            document.getElementById(id + "C").innerText="Редактировать";
            $(name).toggle();

        }


        function ed(el, word) {

            var name = "#" + el.value + word;
            if (el.id[el.id.length - 1] == "C") {
                el.id = el.id.slice(0, -1) + 'O';
                el.innerText = "ok";
                $(name).toggle();
            }
            else {
                if ($(name).children('input').attr("value").length >= 1) {
                    el.id = el.id.slice(0, -1) + 'C';
                    el.innerText = "Редактировать";
                    $("#edit").attr("value", $(name).children('input').attr("value"));
                    $("#ids").attr("value", el.value);
                    $(name).toggle();
                    $("#forma1").ajaxSubmit({

                        url: "${flowExecutionUrl}&" + el.name + "&ajaxSource=true",
                        success: function (html) {
                            $("#list").html($(html).filter("#list"));
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                }
                else {
                    alert("введите ключ");
                }
            }
        }


    </script>
</head>
<body>
<form id="forma1" method="post">
    <input id="ids" type="hidden" name="ids" value=""/>
    <input id="edit" type="hidden" name="edit" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <tiles:insertAttribute name="list"/>
</form>
</body>
</html>