(function(){
    com.Timeject = com.Timeject||{};
    com.Timeject.init=function($){
        $(document).ready(function(){
            console.debug('hello darkness my old friend');
            com.Timeject.http.getProjectTypes(com.Timeject.ProjectType.displayModalTypes);
        });
    };
})();