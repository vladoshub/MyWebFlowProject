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

    function  getList(el) {
        var name = "."+el.name;
        $(name).toggle();
    }
    function  delByKey(el){
            $("#Key").attr("value",el.value)
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_deletedKey&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            })
        }


    function  delByWord(el){

            $("#Key").attr("value",el.value)
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_deletedWord&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            })
        }



    function  edit(el) {
        var name = "." + el.value;
        $(name).toggle();

    }

    function  editKey(el) {
        var name = "#" + el.value;
        $(name).toggle();

    }

    function  editKey(el) {
        $("#editKey").attr("value",el.value);
        $("#forma1").ajaxSubmit({

            url:"${flowExecutionUrl}&_eventId_editKey&ajaxSource=true",
            success:function (html) {
                $("#list").html($(html).filter("#list"));
            },
            error:function (error) {
                console.log(error)
            }
        })
    }
    function  editWord(el) {
        $("#editWord").attr("value",el.value)
        $("#forma1").ajaxSubmit({

            url:"${flowExecutionUrl}&_eventId_editWord&ajaxSource=true",
            success:function (html) {
                $("#list").html($(html).filter("#list"));
            },
            error:function (error) {
                console.log(error)
            }
        })

    }

</script>
</head>
<body>
<form id="forma1"  method="post">
<input id="Key"  type="hidden" name="delKey" value=""/>
<input id="Word"  type="hidden" name="delWord" value=""/>
    <input id="editKey"  type="hidden" name="editKey" value=""/>
    <input id="editWord"  type="hidden" name="editWord" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <tiles:insertAttribute name="list"/>
    <br>
    <tiles:insertAttribute name="search"/>
</form>
</body>
</html>