function listCategories() {

	$.ajax({
		url: "./rest/books/listCategories/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {
		$.each(response, function(key, value) {
			var lstResults = "<a href ='./index.jsp?view=list&page=" + value.Category + "'list-group-item'>" + value.Category + "</a>";

			if ($("#categoryList").text()) {
				document.getElementById('categoryList').innerHTML += lstResults;
			}
		});
	});
}

function listByCategory(category) {
	$.ajax({
		url: "./rest/books/listByCategory/" + category + "/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {
		$.each(response, function(key, value) {
			var lstResults =
				"<div class='card' style='width: 18rem;'> <img src='" + value.Image + "' class='card-img-top' alt='...'>" +
				"<div class='card-body'>" +
				"<h5 class='card-title'>" + value.Name + "</h5>" +
				"<p class='card-text'>" + "$" + value.Price + "</p>" +
				"<a href='./update.jsp?view=update&item=" + value.ID + "'class='btn btn-primary'>Edit</a>" +
				"</div>" +
				"</div>";
			if ($("#bookList").text()) {
				document.getElementById('bookList').innerHTML += lstResults;
			}
		});
	});
}

function getBook(ID) {
	$.ajax({
		url: "./rest/books/" + ID + "/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
	}).done(function(response) {
		var lstResults =
			"<div class='card' style='width: 30rem;'> <img src='" + response.Image + "' class='card-img-top' alt='...'>" +
			"<div class='card-body'>" +
			"<div class='form-group col-xs-12 col-md-6'><label for='bookName'>Name</label><input type='text' class='form-control' id='bookName' value='' required autofocus></div>"+
			"<div class='form-group col-xs-12 col-md-6'><label for='bookPrice'>Price</label><input type='text' class='form-control' id='bookPrice' value='' required autofocus></div>"+
			"<a href='./update.jsp?view=update&item=" + response.ID + "'class='btn btn-primary mr-2' onclick=updateBook();>Update</a>" +		
			"<a href='./index.jsp?view=list&page=" + response.Category + "'class='btn btn-primary mr-2' onclick=deleteBook();>Delete</a>" +
			"<a href='./index.jsp?view=list&page=" + response.Category + "'class='btn btn-primary mr-2'>Cancel</a>" +
			"</div>" +
			"</div>";
		if ($("#editBook").text()) {
			document.getElementById('editBook').innerHTML += lstResults;
			$("#bookName").val(response.Name);
			$("#bookPrice").val(response.Price);
		}

	});
}

function updateBook() {
	var bookName = $("#bookName").val();
	var bookPrice = $("#bookPrice").val();
	
	var parms = { bookName: bookName, bookPrice: bookPrice, bookID:bookID}
	console.log(JSON.stringify(parms));
	$.ajax({
		url: "./rest/books/",
		type: 'PUT',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {
		window.location = "./index.jsp?view=list&page=" + response.Category;
	});
}

function deleteBook() {

	var parms = { bookID: bookID };
	console.log(bookID);
	$.ajax({
		url: "./rest/books/",
		type: 'DELETE',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {
		window.location = "./index.jsp?view=list";
	});
}


function addBook() {

	var bookName = $("#bookName").val();
	var bookAuthor = $("#bookAuthor").val();
	var bookImage = $("#bookImage").val();
	var bookFormat = $("#bookFormat").val();
	var bookISBN = $("#bookISBN").val();
	var bookCategory = $("#bookCategory").val();
	var bookPrice = $("#bookPrice").val();
	
	var parms = { bookName: bookName, bookAuthor: bookAuthor, bookImage: bookImage, bookFormat: bookFormat, bookISBN: bookISBN, bookCategory: bookCategory, bookPrice: bookPrice };

	$.ajax({
		url: "./rest/books",
		type: 'POST',
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

	}).done(function(response) {

		window.location.reload(true);
	});
}

