$('document').ready(function(){
  $('#customerTable').DataTable();
  $('[data-toggle="tooltip"]').tooltip();

  $('table').on('click', ' #editButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $.get(href, function(customer, status){
  //        alert("Customer is: " + customer);
      $('#idEdit').val(customer.customerId);
      $('#firstNameEdit').val(customer.firstName);
      $('#lastNameEdit').val(customer.lastName);
      $('#idNumberEdit').val(customer.idNumber);
      $('#dateOfBirthEdit').val(customer.dateOfBirth);
      $('#addressEdit').val(customer.address);
      $('#phoneNumberEdit').val(customer.phoneNumber);
    });
    $('#editCustomer').modal();
  });

  $('table').on('click', ' #deleteButton', function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $('#confirmDeleteButton').attr('href', href);
    $('#deleteCustomer').modal();
  });
});