$(function() {
  $('#deleteModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var employee = button.data('employee')
    var name = button.data('name')
    var delurl = button.data('delurl')
    var modal = $(this)
    modal.find('.modal-employee').text(employee)
    modal.find('.modal-name').text(name)
    var action = modal.find('.modal-form').attr('action');
    modal.find('.modal-form').attr('action', action + delurl)
  })
})