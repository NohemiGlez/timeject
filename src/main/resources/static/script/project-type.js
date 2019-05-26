(function(Timeject,$){
    Timeject.ProjectType = Timeject.ProjectType || {};
    var projectType = Timeject.ProjectType;
    projectType.displayModalTypes=function(projectTypes){
        var projectTypeSelect = $('#project-type-select');
        for(var i = 0; i < projectTypes.length;i++){
          var projectOption = $('<option>');
          projectOption.append(projectTypes[i]);
          projectTypeSelect.append(projectOption);
        }
    };
})(com.Timeject||{},jQuery);