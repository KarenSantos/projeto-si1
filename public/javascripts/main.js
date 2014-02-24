
function rmDisc(ehPreRequisito, discId, periodo) {
	
	if (ehPreRequisito== "true") {
		var confirmado = confirm("Esta disciplina é pre-requisito de outra já alocada, removendo-a as outras disciplinas serão automaticamente removidas. Você tem certeza que deseja continuar?");
		
		if (confirmado==true) {
			$.ajax({
				  type: "POST",
				  url: "/remover/" + periodo + "/" + discId,
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
		
	} else {
		$.ajax({
			  type: "POST",
			  url: "/remover/" + periodo + "/" + discId,
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

function addDisc(discId, periodo, temPre){

	if (temPre=="true") {
		alert("Esta disciplina tem pré-requisitos ainda não alocados.");
	}
	else {
		$.ajax({
			  type: "GET",
			  url: "/adicionar/"  + periodo + "/" + discId,
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
}