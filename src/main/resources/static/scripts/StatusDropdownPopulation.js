$(document).ready(function loadProjectTypesDrowdown() {

	var select = $("#project-status-select");
	select.find('option').remove();

	$.ajax({
		url : "/timeject/status",
		type : "GET"
	}).done(function(data) {
		window.currentStatus = data;
		$.each(data, function() {
			select.append($("<option />").val(this.status).text(this.status));
		})
	});
});