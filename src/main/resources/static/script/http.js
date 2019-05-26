(function(Timeject,$){
    var http = Timeject.http = Timeject.http||{};
    http.getProjectTypes = function(response){
        $.ajax({
            url : "/timeject/project/type",
            type : "GET"
        }).done(function(data) {
            response(data);
        });
    };
})(com.Timeject||{},jQuery);