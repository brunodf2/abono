$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoAbono = button.data('codigo');
	var nomeAbono = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoAbono);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o registro <strong>' + nomeAbono + '</strong>?');
});

$(function(){
	$('[rel="tooltip"]').tooltip();
	
	$('#matricula').mask('99.999-9');
	$('#dataConsulta').mask('99/99/9999')
	
	
})