$(document).ready(function(){
    $(document).on('click', "#genre-add",
        function (e) {
            e.preventDefault();
            $("#genre-add-dialog").dialog();
        }
    );

    $(document).on('click', ".genre-edit",
        function (e) {
            e.preventDefault();
            var genreId = $(this).parent().parent().find(".genre-id").get(0).innerText;
            var genreName = $(this).parent().parent().find(".genre-name").get(0).innerText;
            var genreDescription = $(this).parent().parent().find(".genre-description").get(0).innerText;
            $("#id-edit-input").val(genreId);
            $("#name-edit-input").val(genreName);
            $("#description-edit-input").val(genreDescription);

            $("#genre-edit-dialog").dialog();
        }
    );


    $(document).on('submit', "#form-genre-add",
        function(e) {
            e.preventDefault();
            $.post("/genres/add",
                $("#form-genre-add").serialize(),
                function (data) {
                    addGenreInList(data);
                    $('#form-genre-add').find("input[type=text], textarea").val(""); // clear form
                    $("#genre-add-dialog").dialog("close");
                },
                'json');
        }
    );

    $(document).on('submit', "#form-genre-edit",
        function(e) {
            e.preventDefault();
            let id = $("#form-genre-edit").find("#id-edit-input").val();
            $.post("/genres/" + id + "/edit",
                $("#form-genre-edit").serialize(),
                function (data) {
                    $("#"+id).remove(); // remove deleted row
                    addGenreInList(data);
                    $('#form-genre-edit').find("input[type=text], textarea").val(""); // clear form
                    $("#genre-edit-dialog").dialog("close");
                },
                'json');
        }
    );

    var addGenreInList = function (data) {
        let dataString = '<tr id="'+ data.id +'">' +
            '<td class="genre-id">' + data.id + '</td>' +
            '<td class="genre-name">' + data.name + '</td>' +
            '<td class="genre-description">' + data.description + '</td>' +
            '<td>' +
            '<a class="genre-edit ui-button ui-widget ui-corner-all" href="/genres/' + data.id + '/edit" href="genre-edit.html">Редактировать</a>' +
            '<a class="genre-delete ui-button ui-widget ui-corner-all" href="/genres/' + data.id + '/delete" href="genre-edit.html">Удалить</a>' +
            '</td>' +
            '</tr>';
        $("#genres-list tbody").append(dataString);
    }

    
});