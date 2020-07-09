$('document').ready(function(){
  $('#rentsTable').DataTable({
//    dom: 'Bfrtip',
//    buttons: [ 'copyHtml5', 'excelHtml5', 'csvHtml5', 'pdfHtml5' ]
  });

  $('[data-toggle="tooltip"]').tooltip();

  $('table').on('click', '#editButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $.get(href, function(rent, status){
      $('#rentIdEdit').val(rent.rentId);
      $('#customerIdEdit').val(rent.customerId);
      $('#productIdEdit').val(rent.productId);
      $('#rentFromEdit').val(rent.rentFrom);
      $('#rentTillEdit').val(rent.rentTill);
      $('#rentLocationEdit').val(rent.rentLocation);
    });
    $('#editRent').modal();
  });

  $('table').on('click', '#customerDetailsButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $.get(href, function(customer, status){
      $('#idEdit').val(customer.customerId);
      $('#firstNameEdit').val(customer.firstName);
      $('#lastNameEdit').val(customer.lastName);
      $('#idNumberEdit').val(customer.idNumber);
      $('#dateOfBirthEdit').val(customer.dateOfBirth);
      $('#addressEdit').val(customer.address);
      $('#phoneNumberEdit').val(customer.phoneNumber);
    });
    $('#customerDetails').modal();
  });

  $('table').on('click', '#productDetailsButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $.get(href, function(product, status){
      $('#productId').val(product.productId);
      $('#makeEdit').val(product.make);
      $('#modelEdit').val(product.model);
      $('#typeEdit').val(product.type);
      $('#categoryEdit').val(product.category);
      $('#yearEdit').val(product.year);
    });
    $('#productDetails').modal();
  });

  $('table').on('click', '#deleteButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $('#confirmDeleteButton').attr('href', href);
    $('#deleteRent').modal();
  });

});