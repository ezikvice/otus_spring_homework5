$(document).ready(function(){
    $(document).on('click', "#author-add",
        function (e) {
            e.preventDefault();
            $("#author-add-dialog").dialog();
        }
    );

    $(document).on('click', ".author-edit",
        function (e) {
            e.preventDefault();
            var authorId = $(this).parent().parent().find(".author-id").get(0).innerText;
            var authorName = $(this).parent().parent().find(".author-name").get(0).innerText;
            $("#id-edit-input").val(authorId);
            $("#name-edit-input").val(authorName);

            $("#author-edit-dialog").dialog();
        }
    );


    $(document).on('submit', "#form-author-add",
        function(e) {
            e.preventDefault();
            $.post("/authors/add",
                $("#form-author-add").serialize(),
                function (data) {
                    addAuthorInList(data);
                    $('#form-author-add').find("input[type=text], textarea").val("");
                    $("#author-add-dialog").dialog("close");
                },
                'json');
        }
    );

    $(document).on('submit', "#form-author-edit",
        function(e) {
            e.preventDefault();
            let id = $("#form-author-edit").find("#id-edit-input").val();
            $.post("/authors/" + id + "/edit",
                $("#form-author-edit").serialize(),
                function (data) {
                    $("#"+id).remove(); // remove deleted row
                    addAuthorInList(data);
                    $('#form-author-edit').find("input[type=text], textarea").val(""); // clear form
                    $("#author-edit-dialog").dialog("close");
                },
                'json');
        }
    );

    var addAuthorInList = function (data) {
        let dataString = '<tr id="'+ data.id +'">' +
            '<td class="author-id">' + data.id + '</td>' +
            '<td class="author-name">' + data.name + '</td>' +
            '<td>' +
            '<a class="author-edit ui-button ui-widget ui-corner-all" href="/authors/' + data.id + '/edit" href="author-edit.html">Редактировать</a>' +
            '<a class="author-delete ui-button ui-widget ui-corner-all" href="/authors/' + data.id + '/delete" href="author-edit.html">Удалить</a>' +
            '</td>' +
            '</tr>';
        $("#authors-list tbody").append(dataString);
    }

    
});