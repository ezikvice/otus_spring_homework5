$(document).ready(function(){
    $(document).on('click', "#book-add",
        function (e) {
            e.preventDefault();
            $("#book-add-dialog").dialog();
        }
    );

    $(document).on('click', ".book-edit",
        function (e) {
            e.preventDefault();
            var bookId = $(this).parent().parent().find(".book-id").get(0).innerText;
            var bookName = $(this).parent().parent().find(".book-name").get(0).innerText;
            var bookDescription = $(this).parent().parent().find(".book-description").get(0).innerText;
            $("#id-edit-input").val(bookId);
            $("#name-edit-input").val(bookName);
            $("#description-edit-input").val(bookDescription);

            $("#book-edit-dialog").dialog();
        }
    );


    $(document).on('submit', "#form-book-add",
        function(e) {
            e.preventDefault();
            $.post("/books/add",
                $("#form-book-add").serialize(),
                function (data) {
                    addBookInList(data);
                    $('#form-book-add').find("input[type=text], textarea").val(""); // clear form
                    $("#book-add-dialog").dialog("close");
                },
                'json');
        }
    );

    $(document).on('submit', "#form-book-edit",
        function(e) {
            e.preventDefault();
            let id = $("#form-book-edit").find("#id-edit-input").val();
            $.post("/books/" + id + "/edit",
                $("#form-book-edit").serialize(),
                function (data) {
                    $("#"+id).remove(); // remove deleted row
                    addBookInList(data);
                    $('#form-book-edit').find("input[type=text], textarea").val(""); // clear form
                    $("#book-edit-dialog").dialog("close");
                },
                'json');
        }
    );

    $(document).on('click', "#book-add-author-button",
        function (e) {
            e.preventDefault();
            $("#book-add-author-dialog").dialog();
        }
    );

    $(document).on('click', "#book-add-genre-button",
        function (e) {
            e.preventDefault();
            $("#book-add-genre-dialog").dialog();
        }
    );

    $(document).on('click', "#book-add-comment-button",
        function (e) {
            e.preventDefault();
            $("#book-add-comment-dialog").dialog();
        }
    );

    var addBookInList = function (data) {
        let dataString = '<tr id="'+ data.id +'">' +
            '<td class="book-id">' + data.id + '</td>' +
            '<td class="book-name">' + data.name + '</td>' +
            '<td class="book-description">' + data.description + '</td>' +
            '<td>' +
            '<a class="book-info ui-button ui-widget ui-corner-all" href="/books/' + data.id + '/edit" href="book-edit.html">Инфо</a>' +
            '<a class="book-edit ui-button ui-widget ui-corner-all" href="/books/' + data.id + '/edit" href="book-edit.html">Редактировать</a>' +
            '<a class="book-delete ui-button ui-widget ui-corner-all" href="/books/' + data.id + '/delete" href="book-edit.html">Удалить</a>' +
            '</td>' +
            '</tr>';
        $("#books-list tbody").append(dataString);
    }

    
});