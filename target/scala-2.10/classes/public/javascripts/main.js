function novoPeriodo() {
	
}

function editarPeriodo(periodo){
	
	$.ajax({
		  success: function(){
		        window.location = "/editar/" + periodo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  //parser pra achar a Excecao lancada
			  var ind = XMLHttpRequest.responseText.indexOf("Exception:");
			  var res = XMLHttpRequest.responseText.substring(ind +11 , ind + 500);
			  var ind2 = res.indexOf("]");
			  var res2 = res.substring(0, ind2);
		      alert(res2);
		  }
	});
}

function removerDisciplina(discId, periodo) {
	
	$.ajax({
		  type: "GET",
		  url: "/remover/" + discId + "/" + periodo,
		  data: "",
		  success: function(){
		        window.location = "/editar/" + periodo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  //parser pra achar a Excecao lancada
			  var ind = XMLHttpRequest.responseText.indexOf("Exception:");
			  var res = XMLHttpRequest.responseText.substring(ind +11 , ind + 500);
			  var ind2 = res.indexOf("]");
			  var res2 = res.substring(0, ind2);
		      alert(res2);
		  }
	});
}

function moverDisciplina(discId, periodoFuturo, periodoAtual) {
	
	$.ajax({
		  success: function(){
		        window.location = "/mover/" + discId + "/" + periodoFuturo + "/" + periodoAtual;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  //parser pra achar a Excecao lancada
			  var ind = XMLHttpRequest.responseText.indexOf("Exception:");
			  var res = XMLHttpRequest.responseText.substring(ind +11 , ind + 500);
			  var ind2 = res.indexOf("]");
			  var res2 = res.substring(0, ind2);
		      alert(res2);
		  }
	});
}

function adicionarDisciplina(discId, periodo){

	$.ajax({
		  type: "GET",
		  url: "/adicionar/"  + discId + "/" + periodo,
		  data: "",
		  success: function(){
		        window.location = "/editar/" + periodo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  //parser pra achar a Excecao lancada
			  var ind = XMLHttpRequest.responseText.indexOf("Exception:");
			  var res = XMLHttpRequest.responseText.substring(ind +11 , ind + 500);
			  var ind2 = res.indexOf("]");
			  var res2 = res.substring(0, ind2);
		      alert(res2);
		  }
	});
}