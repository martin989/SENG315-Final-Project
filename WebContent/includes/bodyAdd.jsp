<h1 class="page-header">Add Book</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="bookName">Name</label>
    <input type="text" class="form-control" id="bookName" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookAuthor">Author</label>
    <input type="text" class="form-control" id="bookAuthor" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookImage">Image</label>
    <input type="text" class="form-control" id="bookImage" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookFormat">Format</label>
    <input type="text" class="form-control" id="bookFormat" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookISBN">ISBN</label>
    <input type="text" class="form-control" id="bookISBN" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookCategory">Category</label>
    <input type="text" class="form-control" id="bookCategory" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookPrice">Price</label>
    <input type="text" class="form-control" id="bookPrice"  required>
</div>
 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addBook()" id="articleAdd" data-toggle="tooltip" title="Add Article">Add Article</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>