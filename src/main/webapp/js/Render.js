function Render(str) {
    $(document).ready(function () {
        $("#knopka1").on("click",function () {
            $("#forma1").ajaxSubmit({
                url:"${flowExecutionUrl}&"+str,
                success:function (html) {
                    $("#req").html(html);
                },
                error:function (error) {
                    console.log(error)
                }
            })
        })
    })
}