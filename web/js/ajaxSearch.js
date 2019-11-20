function f() {
    if ($("#query").val().length >= 1) {
        $.ajax({
                url: "/doSearch",
                data: {"query": $("#query").val(), "search_param": $("#search_param").val()},
                dataType: "json",
                success: function (msg) {
                    if (msg.concerts.length > 0) {
                        $("#res").html("");
                        for (var i = 0; i < msg.concerts.length; i++) {
                            var o = msg.concerts[i];
                            var id = o.id;
                            var poster = o.poster;
                            var title = o.title;
                            $("#res").html("No results..");

                           /* $("#res").append(".card(style=\"height: 430px\")\n" +
                                "    .card-image\n" +
                                "      img(src= "+poster+")\n" +
                                "      a.btn-floating.btn-large.halfway-fab.waves-effect.waves-light(style=\"background-color: \" + theme.primary + \";\")\n" +
                                "        i.material-icons shopping_cart\n" +
                                "    .card-content\n" +
                                "      span.card-title= "+title+"\n" +
                                "      p= cost"
                            );*/
                        }
                    } else {
                        $("#res").html("No results..");
                    }
                }
            }
        )
    } else {
        $("#res").html("");
    }
}