function novoPeriodo() {
	
}

function editarPeriodo(periodo){
	$.ajax({
		  type: "GET",
		  url: "/editar/" + periodo,
		  data: "",
		  success: function(){
//		        window.location = "/editar/" + periodo;
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

function moverDisciplina(discId, periodoFuturu, periodoAtual) {
	
	$.ajax({
		  type: "GET",
		  url: "/mover/" + discId + "/" + periodoFurutu + "/" + periodoAtual,
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

function deletaPeriodo(numPeriodo, totalDeDisciplinas){
	if (totalDeDisciplinas != 0){
		var confirmado = confirm("Você tem certeza que deseja deletar este periodo, todas as suas disciplinas e todas as outras que tem estas como pre-requisitos?");
		
		if (confirmado == true) {
			$.ajax({
				  type: "POST",
				  url: "/deletar/" + numPeriodo,
				  data: "",
				  success: function(){
				        window.location = "/";
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
	} else {
		$.ajax({
			  type: "POST",
			  url: "/deletar/" + numPeriodo,
			  data: "",
			  success: function(){
			        window.location = "/";
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
}

