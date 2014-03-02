function novoPeriodo(periodo) {
	$.ajax({
		  type: "GET",
		  url: "/novoPeriodo",
		  data: "",
		  success: function(){
		        window.location = "/editar/" + periodo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Você já alcançou o número máximo de períodos permitido pelo curso.");
		  }
	});
	
}

function editarPeriodo(periodo){
	
	$.ajax({
		  success: function(){
		        window.location = "/editar/" + periodo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
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
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
		  }
	});
}

function moverDisciplina(discId, periodoFuturo, periodoAtual) {
	
	$.ajax({
		  success: function(){
		        window.location = "/mover/" + discId + "/" + periodoFuturo + "/" + periodoAtual;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
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
			  if (errorThrown == "Bad Request") {
				  alert("Com esta disciplina o máximo de créditos seria ultrapassado.");
			  } else {
				  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  }
		  }
	});
}

function sairEdicao(){
	$.ajax({
		  success: function(){
		        window.location = "/";
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
		  }
	});
}