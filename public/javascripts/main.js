function novoPeriodo(periodo) {
	
	var novoPeriodo = parseInt(periodo) + 1;
	
	$.ajax({
		  type: "GET",
		  url: "/novoPeriodo",
		  data: "",
		  success: function(){
		        window.location = "/editar/" + novoPeriodo;
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

function removerDisciplina(discId, periodo, ehPreRequisito) {
	
	if (ehPreRequisito == "true") {
		var confirmado = confirm("Esta disciplina é pré-requisito de outras já alocadas, " +
				"removendo-a as outras são automaticamente removidas. Você tem certeza que deseja continuar?");
	
		if (confirmado) {
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
	} else {
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
}

function moverDisciplina(discId, periodoFuturo, periodoAtual) {
	
	$.ajax({
		type: "GET",
		url: "/mover/" + discId + "/" + periodoFuturo + "/" + periodoAtual,
		data: "",
		success: function(){
			window.location = "/editar/" + periodoFuturo;
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Com esta disciplina o máximo de créditos seria ultrapassado.");
		  }
	});
}

function adicionarDisciplina(discId, periodo, temPreRequisito){
	
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
				  alert("Esta disciplina possui pré-requisitos ainda não alocados em períodos anteriores.");
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

function inverter(numPeriodo) {
	
	$.ajax({
		  type: "GET",
		  url: "/inverter",
		  data: "",
		  success: function(){
			  if (numPeriodo == "0") {
				  window.location = "/";
			  } else {
				  window.location = "/editar/" + numPeriodo;
			  }
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
		  }
	});
	
}

function logout(){
	$.ajax({
		  type: "GET",
		  url: "/logout",
		  data: "",
		  success: function(){
			  window.location = "/login";
		  },
		  error: function(XMLHttpRequest, textStatus, errorThrown) {
			  alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			  window.location = "/";
		  }
	});
}

