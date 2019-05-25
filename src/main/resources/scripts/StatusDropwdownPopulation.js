$.ajax({
	type : "GET",
	url : urlPath,
	success : function(data) {
		helpers.buildDropdown(jQuery.parseJSON(data), $('#dropdown'),
				'Select an option');
	}
});