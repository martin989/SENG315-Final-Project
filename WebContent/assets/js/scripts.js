$(document).ready(function() {
	listCategories();
	
	view = getQueryStringVariable('view');

	if (view == 'list') {
		category = getQueryStringVariable('page');
		listByCategory(category);
	}
	if (view == 'update'){
		bookID = getQueryStringVariable('item');
		getBook(bookID);
	}
});

var getQueryStringVariable = function(field, url) {
	var href = url ? url : window.location.href;
	var reg = new RegExp('[?&]' + field + '=([^&#]*)', 'i');
	var string = reg.exec(href);
	return string ? string[1] : null;
};