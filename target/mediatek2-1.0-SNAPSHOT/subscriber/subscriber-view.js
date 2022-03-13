window.onload = function () {
    $("#listTo1").sortable();
    $("#listTo1").disableSelection();

    $(document).on("click", "#listFrom1 li", function () {
        $(this).unbind("click").appendTo("#listTo1");
    });
    $(document).on("click", "#listTo1 li", function () {
        $(this).unbind("click").appendTo("#listFrom1");
    });

    $("#submit1").click(function () {
        $("#hidden1").val("");
        $("#listTo1 li").each(function () {
            $("#hidden1").val($("#hidden1").val() + $(this).data("id") + ",");
        });
        $("#hidden1").val($("#hidden1").val().replace(/,\s*$/, ""));
    });


    $("#listTo2").sortable();
    $("#listTo2").disableSelection();

    $(document).on("click", "#listFrom2 li", function () {
        $(this).unbind("click").appendTo("#listTo2");
    });
    $(document).on("click", "#listTo2 li", function () {
        $(this).unbind("click").appendTo("#listFrom2");
    });

    $("#submit2").click(function () {
        $("#hidden2").val("");
        $("#listTo2 li").each(function () {
            $("#hidden2").val($("#hidden2").val() + $(this).data("id") + ",");
        });
        $("#hidden2").val($("#hidden2").val().replace(/,\s*$/, ""));
    });
};
