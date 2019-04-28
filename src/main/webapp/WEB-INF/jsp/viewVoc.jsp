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
<style><%@include file="/WEB-INF/css/buttonView.css"%></style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
<script type="application/javascript">

    function  getList() {
        $('#hidden').toggle();//-будет работать ко всем
    }
    $(function(){
        $(".button").on("click", function(){
            $("#Key").attr("value",this.name)
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_deletedKey&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            })
        })
    });

    $(function(){
        $(".list").on("click", function(){
            $("#Key").attr("value",this.name)
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_deletedWord&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            })
        })
    });

    function  add(input) {
            $("#"+input.name).attr("value",prompt('введите слово'));

        $("#forma1").ajaxSubmit({

            url:"${flowExecutionUrl}&_eventId_Search"+input.name+"&ajaxSource=true",
            success:function (html) {
                $("#list").html($(html).filter("#list"));
            },
            error:function (error) {
                console.log(error)
            }
        })
    }

    function  edit(input) {
        $('.editText').toggle();
    }

</script>
</head>
<body>
<form id="forma1"  method="post">
<input id="Key"  type="hidden" name="delKey" value=""/>
<input id="Word"  type="hidden" name="delWord" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <tiles:insertAttribute name="list"/>
    <br>
    <tiles:insertAttribute name="search"/>
</form>
</body>
</html>