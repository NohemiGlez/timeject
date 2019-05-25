$(document).ready(
		function loadProjectTypesDrowdown() {

			var select = $("#project-type-select");
			select.find('option').remove();

			$.ajax({
				url : "/types/view",
				type : "GET"
			}).done(
					function(data) {
						window.currentSteps = data;
						$.each(data, function() {
							select.append($("<option />").val(this.step).text(
									"Step " + this.step));
						})
					});
		}
);