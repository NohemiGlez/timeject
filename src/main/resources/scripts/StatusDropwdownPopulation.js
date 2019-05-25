$.ajax({
	type : "GET",
	url : "/types/view",
	success : function(data) {
		helpers.buildDropdown(jQuery.parseJSON(data),
				$('#project-type-select'), 'Select an option');
	}
});