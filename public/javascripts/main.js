function novoPeriodo(periodo) {

	var novoPeriodo = parseInt(periodo) + 1;

	$
			.ajax({
				type : "GET",
				url : "/novoPeriodo",
				data : "",
				success : function() {
					window.location = "/editar/" + novoPeriodo;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					if (errorThrown == "Bad Request") {
						alert("Você já alcançou o número máximo de períodos permitido pelo curso.");
					} else {
						alert("O último período precisa ter total de créditos de no mínimo 14 e no máximo 28.");
					}
				}
			});

}

function removerDisciplina(discId, periodo, ehPreRequisito) {

	if (ehPreRequisito == "true") {
		var confirmado = confirm("Esta disciplina é pré-requisito de outras já alocadas, "
				+ "removendo-a as outras são automaticamente removidas. Você tem certeza que deseja continuar?");

		if (confirmado) {
			$
					.ajax({
						type : "GET",
						url : "/remover/" + discId + "/" + periodo,
						data : "",
						success : function() {
							window.location = "/editar/" + periodo;
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							alert("Não é possível remover esta disciplina pois o mínimo de 14 créditos por "
									+ "período seria violado. Insira alguma disciplina e tente novamente.");
							window.location = "/editar/" + periodo;
						}
					});
		}
	} else {
		$
				.ajax({
					type : "GET",
					url : "/remover/" + discId + "/" + periodo,
					data : "",
					success : function() {
						window.location = "/editar/" + periodo;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("Não é possível remover esta disciplina pois este período deve ter no mínimo de 14 créditos."
								+ " Insira alguma disciplina e tente novamente.");
						window.location = "/editar/" + periodo;
					}
				});
	}
}

function moverDisciplina(discId, periodoFuturo, periodoAtual) {

	$
			.ajax({
				type : "GET",
				url : "/mover/" + discId + "/" + periodoFuturo + "/"
						+ periodoAtual,
				data : "",
				success : function() {
					window.location = "/editar/" + periodoFuturo;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("O máximo de 28 créditos neste período seria ultrapassado e/ou mínimo de 14 "
							+ "créditos no período onde está a disciplina seria violado.");
				}
			});
}

function adicionarDisciplina(discId, periodo, temPreRequisito) {

	$
			.ajax({
				type : "GET",
				url : "/adicionar/" + discId + "/" + periodo,
				data : "",
				success : function() {
					window.location = "/editar/" + periodo;
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					if (errorThrown == "Bad Request") {
						alert("Este período tem um máximo de 28 créditos.");
					} else {
						alert("Esta disciplina possui pré-requisitos ainda não alocados em períodos anteriores.");
					}
				}
			});
}

function inverter(numPeriodo) {

	$
			.ajax({
				type : "GET",
				url : "/inverter",
				data : "",
				success : function() {
					if (numPeriodo == "0") {
						window.location = "/plano";
					} else {
						window.location = "/editar/" + numPeriodo;
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
					window.location = "/";
				}
			});

}

function ordenar(numPeriodo) {
	$
	.ajax({
		type : "GET",
		url : "/ordenar",
		data : "",
		success : function() {
			if (numPeriodo == "0") {
				window.location = "/plano";
			} else {
				window.location = "/editar/" + numPeriodo;
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
			window.location = "/";
		}
	});
}

function logout() {
	$
			.ajax({
				type : "GET",
				url : "/logout",
				data : "",
				success : function() {
					window.location = "/login";
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("Não foi possível atender a esta requisição. Por favor tente mais tarde.");
					window.location = "/login";
				}
			});
}