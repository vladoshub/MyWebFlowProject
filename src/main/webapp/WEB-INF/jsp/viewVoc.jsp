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
    <style><%@include file="/WEB-INF/css/listPage.css"%></style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form/jquery.form.js"></script>
<script type="application/javascript">

    function  getList(el) {
        var name = "#"+el.name+"List";
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



    function  editWords(el) {

        var name = "#" + el.value+"WordDiv";
        if(el.id[el.id.length-1]=="C"){
            el.id=el.id.slice(0, -1) + 'O';
            el.innerText="ok";
            $(name).toggle();
        }
        else{
           el.id=el.id.slice(0, -1) + 'C';
            el.innerText="Редактировать";
            $("#editWord").attr("value",$(name).children('input').attr("value"));
            $("#ids").attr("value",el.value);
            $(name).toggle();
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_editWord&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            });
        }
    }

    function  editKeys(el) {

        var name = "#" + el.value+"KeyDiv";
        if(el.id[el.id.length-1]=="C"){
            el.id=el.id.slice(0, -1) + 'O';
            el.innerText="ok";
            $(name).toggle();
        }
        else{
            el.id=el.id.slice(0, -1) + 'C';
            el.innerText="Редактировать";
            $("#editKey").attr("value",$(name).children('input').attr("value"));
            $("#ids").attr("value",el.value);
            $(name).toggle();
            $("#forma1").ajaxSubmit({

                url:"${flowExecutionUrl}&_eventId_editKey&ajaxSource=true",
                success:function (html) {
                    $("#list").html($(html).filter("#list"));
                },
                error:function (error) {
                    console.log(error)
                }
            });
        }
    }



</script>
</head>
<body>
<form id="forma1"  method="post">
    <input id="ids"  type="hidden" name="ids" value=""/>
    <input id="editKey"  type="hidden" name="editKey" value=""/>
    <input id="editWord"  type="hidden" name="editWord" value=""/>
    <input type="hidden" name="_flowExecutionKey"/>
    <tiles:insertAttribute name="list"/>
</form>
</body>
</html>