$(document).ready(function loadProjectTypesDrowdown() {

	var select = $("#project-type-select");
	select.find('option').remove();

	$.ajax({
		url : "/timeject/types",
		type : "GET"
	}).done(function(data) {
		window.currentType = data;
		$.each(data, function() {
			select.append($("<option />").val(this.type).text(this.type));
		})
	});
});