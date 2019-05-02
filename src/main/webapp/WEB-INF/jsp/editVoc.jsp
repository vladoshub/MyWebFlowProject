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


    function readAll(){
        var values2=$('body').find('#input2');
        var values=$('body').find('#input');

            var Key="";
            Key = Key + values2[0].value;
        if(!(Key==""||Key==null)) {
            $('#Keyhidden').attr("inputNameKey",Key);
            var all = "";
            if (values.length >= 1) {
                for (var i = 0; i < values.length; ++i) {
                    if (!values[i].value=='')
                    all = all + values[i].value + "%_%";
                }
                if(!(all==""||all==null))
                $('#allWord').attr("inputNameWord", all);
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
        $('body').find('#input2').attr("value","");
        $('body').find('#input').attr("value","");

    }

</script>
<html>
<body>
<tiles:insertAttribute name="editVocAddManyWordsFragment"/>
</body>
</html>