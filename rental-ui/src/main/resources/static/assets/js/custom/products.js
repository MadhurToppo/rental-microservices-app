$('document').ready(function(){
  $('#productsTable').DataTable();
  $('[data-toggle="tooltip"]').tooltip();

  $('table').on('click', '#productEditButton', function(event){
      event.preventDefault();

  //event.stopPropagation();
    var href = $(this).attr('href');
    $.get(href, function(product, status){
      $('#idEdit').val(product.id);
      $('#makeEdit').val(product.make);
      $('#modelEdit').val(product.model);
      $('#typeEdit').val(product.type);
      $('#categoryEdit').val(product.category);
      $('#yearEdit').val(product.year);
    });
    $('#editProduct').modal();
  });

  $('table').on('click', ' #productDeleteButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $('#confirmProductDeleteButton').attr('href', href);
    $('#deleteProduct').modal();
  });
});