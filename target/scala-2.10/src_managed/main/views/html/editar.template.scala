
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object editar extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[List[Periodo],List[Disciplina],Integer,Planejador,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodos: List[Periodo], naoAlocadas: List[Disciplina], numPeriodo: Integer, planejador: Planejador):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.103*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Planejamento de Curso")/*5.31*/ {_display_(Seq[Any](format.raw/*5.33*/("""

<a onclick="novoPeriodo('"""),_display_(Seq[Any](/*7.27*/planejador/*7.37*/.getTotalDePeriodos())),format.raw/*7.58*/("""')"><div id="botaoPeriodo">Novo Período</div></a>

<div id="top1"><!-- coluna de periodos -->
	"""),_display_(Seq[Any](/*10.3*/if(planejador.isInvertido())/*10.31*/{_display_(Seq[Any](format.raw/*10.32*/("""
		<a onclick="inverter('"""),_display_(Seq[Any](/*11.26*/numPeriodo)),format.raw/*11.36*/("""')" title="Ordenação crescente"><div id="inverter"> v </div></a>
	""")))}/*12.4*/else/*12.9*/{_display_(Seq[Any](format.raw/*12.10*/("""
		<a onclick="inverter('"""),_display_(Seq[Any](/*13.26*/numPeriodo)),format.raw/*13.36*/("""')" title="Ordenação decrescente"><div id="inverter"> ^ </div></a>
	""")))})),format.raw/*14.3*/("""
	<h2>Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*18.3*/for(periodo <- periodos) yield /*18.27*/{_display_(Seq[Any](format.raw/*18.28*/("""
		"""),_display_(Seq[Any](/*19.4*/if(periodo.getNumero() == numPeriodo)/*19.41*/{_display_(Seq[Any](format.raw/*19.42*/("""
			<div id="periodoBox">
				<a onclick="sairEdicao()" title="Clique aqui para fechar edição"><div id="numPeriodoEditando"><b>"""),_display_(Seq[Any](/*21.103*/periodo/*21.110*/.getNumero())),format.raw/*21.122*/("""º</b> Período</div></a>
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*24.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*24.60*/ {_display_(Seq[Any](format.raw/*24.62*/("""
				    	"""),_display_(Seq[Any](/*25.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*25.56*/ {_display_(Seq[Any](format.raw/*25.58*/("""
				    	   	<a onclick="rDisciplina('"""),_display_(Seq[Any](/*26.40*/disciplinaPeriodo/*26.57*/.getId())),format.raw/*26.65*/("""', '"""),_display_(Seq[Any](/*26.70*/numPeriodo)),format.raw/*26.80*/("""', '"""),_display_(Seq[Any](/*26.85*/planejador/*26.95*/.ehPreRequisito(disciplinaPeriodo, periodo.getNumero()))),format.raw/*26.150*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*26.192*/disciplinaPeriodo/*26.209*/.getPreRequisitos)),format.raw/*26.226*/("""">"""),_display_(Seq[Any](/*26.229*/disciplinaPeriodo/*26.246*/.getNome())),format.raw/*26.256*/("""</a>
				    	   	<span>"""),_display_(Seq[Any](/*27.21*/disciplinaPeriodo/*27.38*/.getCreditos())),format.raw/*27.52*/(""" / """),_display_(Seq[Any](/*27.56*/disciplinaPeriodo/*27.73*/.getDificuldade())),format.raw/*27.90*/("""</span>
				    		<br>
				    	""")))}/*29.12*/else/*29.17*/{_display_(Seq[Any](format.raw/*29.18*/("""
				    		<a onclick="rDisciplina('"""),_display_(Seq[Any](/*30.37*/disciplinaPeriodo/*30.54*/.getId())),format.raw/*30.62*/("""', '"""),_display_(Seq[Any](/*30.67*/numPeriodo)),format.raw/*30.77*/("""', '"""),_display_(Seq[Any](/*30.82*/planejador/*30.92*/.ehPreRequisito(disciplinaPeriodo, periodo.getNumero()))),format.raw/*30.147*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*30.197*/disciplinaPeriodo/*30.214*/.getPreRequisitos)),format.raw/*30.231*/("""">"""),_display_(Seq[Any](/*30.234*/disciplinaPeriodo/*30.251*/.getNome())),format.raw/*30.261*/("""</a>
				    		<span>"""),_display_(Seq[Any](/*31.18*/disciplinaPeriodo/*31.35*/.getCreditos())),format.raw/*31.49*/(""" / """),_display_(Seq[Any](/*31.53*/disciplinaPeriodo/*31.70*/.getDificuldade())),format.raw/*31.87*/("""</span>
				    		<br>
				    	""")))})),format.raw/*33.11*/("""
				    """)))})),format.raw/*34.10*/("""
				</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*37.6*/if(periodo.getTotalDeCreditos() < 14)/*37.43*/{_display_(Seq[Any](format.raw/*37.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*39.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*40.21*/periodo/*40.28*/.getTotalDeCreditos())),format.raw/*40.49*/("""  /   """),_display_(Seq[Any](/*40.56*/periodo/*40.63*/.getTotalDeDificuldade())),format.raw/*40.87*/("""
				</div>
				<div id="editandoNote">Clique na disciplina para adicionar aqui ou mover de outro período para este.</div>
			</div><!-- Fim de um periodo -->
		""")))}/*44.5*/else/*44.10*/{_display_(Seq[Any](format.raw/*44.11*/("""
			<div id="periodoBox">
				<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*46.33*/periodo/*46.40*/.getNumero())),format.raw/*46.52*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*46.113*/periodo/*46.120*/.getNumero())),format.raw/*46.132*/("""º</b> Período</div></a><!-- Numero do periodo -->
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*49.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*49.60*/ {_display_(Seq[Any](format.raw/*49.62*/("""
				    	"""),_display_(Seq[Any](/*50.11*/if(planejador.ehDisciplinaOptativaGenerica(disciplinaPeriodo))/*50.73*/ {_display_(Seq[Any](format.raw/*50.75*/("""
				    		<a>"""),_display_(Seq[Any](/*51.15*/disciplinaPeriodo/*51.32*/.getNome())),format.raw/*51.42*/("""</a>
					    	<span>"""),_display_(Seq[Any](/*52.18*/disciplinaPeriodo/*52.35*/.getCreditos())),format.raw/*52.49*/(""" / _</span>
					  		<br>
				    	""")))}/*54.12*/else/*54.17*/{_display_(Seq[Any](format.raw/*54.18*/("""
					    	"""),_display_(Seq[Any](/*55.12*/if(disciplinaPeriodo.isAlocadaCorretamente())/*55.57*/ {_display_(Seq[Any](format.raw/*55.59*/("""
					    	   	<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*56.45*/disciplinaPeriodo/*56.62*/.getId())),format.raw/*56.70*/("""', '"""),_display_(Seq[Any](/*56.75*/numPeriodo)),format.raw/*56.85*/("""', '"""),_display_(Seq[Any](/*56.90*/periodo/*56.97*/.getNumero())),format.raw/*56.109*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*56.151*/disciplinaPeriodo/*56.168*/.getPreRequisitos)),format.raw/*56.185*/("""">"""),_display_(Seq[Any](/*56.188*/disciplinaPeriodo/*56.205*/.getNome())),format.raw/*56.215*/("""</a>
					    	   	<span>"""),_display_(Seq[Any](/*57.22*/disciplinaPeriodo/*57.39*/.getCreditos())),format.raw/*57.53*/(""" / """),_display_(Seq[Any](/*57.57*/disciplinaPeriodo/*57.74*/.getDificuldade())),format.raw/*57.91*/("""</span>
					    		<br>
					    	""")))}/*59.13*/else/*59.18*/{_display_(Seq[Any](format.raw/*59.19*/("""
					    		<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*60.42*/disciplinaPeriodo/*60.59*/.getId())),format.raw/*60.67*/("""', '"""),_display_(Seq[Any](/*60.72*/numPeriodo)),format.raw/*60.82*/("""', '"""),_display_(Seq[Any](/*60.87*/periodo/*60.94*/.getNumero())),format.raw/*60.106*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*60.156*/disciplinaPeriodo/*60.173*/.getPreRequisitos)),format.raw/*60.190*/("""">"""),_display_(Seq[Any](/*60.193*/disciplinaPeriodo/*60.210*/.getNome())),format.raw/*60.220*/("""</a>
					    		<span>"""),_display_(Seq[Any](/*61.19*/disciplinaPeriodo/*61.36*/.getCreditos())),format.raw/*61.50*/(""" / """),_display_(Seq[Any](/*61.54*/disciplinaPeriodo/*61.71*/.getDificuldade())),format.raw/*61.88*/("""</span>
					    		<br>
					    	""")))})),format.raw/*63.12*/("""
				    	""")))})),format.raw/*64.11*/("""
				    """)))})),format.raw/*65.10*/("""
			   	</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*68.6*/if(periodo.getTotalDeCreditos() < 14)/*68.43*/{_display_(Seq[Any](format.raw/*68.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*70.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*71.21*/periodo/*71.28*/.getTotalDeCreditos())),format.raw/*71.49*/("""  /   """),_display_(Seq[Any](/*71.56*/periodo/*71.63*/.getTotalDeDificuldade())),format.raw/*71.87*/("""
				</div>
			</div><!-- Fim de um periodo -->
		""")))})),format.raw/*74.4*/("""			
	""")))})),format.raw/*75.3*/("""
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*84.4*/for(disciplina <- naoAlocadas) yield /*84.34*/ {_display_(Seq[Any](format.raw/*84.36*/("""
			"""),_display_(Seq[Any](/*85.5*/if(disciplina.getPeriodoSugerido() == 1)/*85.45*/{_display_(Seq[Any](format.raw/*85.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*86.39*/disciplina/*86.49*/.getId())),format.raw/*86.57*/("""', '"""),_display_(Seq[Any](/*86.62*/numPeriodo)),format.raw/*86.72*/("""', '"""),_display_(Seq[Any](/*86.77*/planejador/*86.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*86.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*86.167*/disciplina/*86.177*/.getPreRequisitos())),format.raw/*86.196*/("""">"""),_display_(Seq[Any](/*86.199*/disciplina/*86.209*/.getNome())),format.raw/*86.219*/("""</a>   <span>"""),_display_(Seq[Any](/*86.233*/disciplina/*86.243*/.getCreditos())),format.raw/*86.257*/("""  /  """),_display_(Seq[Any](/*86.263*/disciplina/*86.273*/.getDificuldade())),format.raw/*86.290*/("""</span>
				<br>
			""")))})),format.raw/*88.5*/("""
		""")))})),format.raw/*89.4*/("""
		<br>
		
		"""),_display_(Seq[Any](/*92.4*/for(disciplina <- naoAlocadas) yield /*92.34*/ {_display_(Seq[Any](format.raw/*92.36*/("""
			"""),_display_(Seq[Any](/*93.5*/if(disciplina.getPeriodoSugerido() == 2)/*93.45*/{_display_(Seq[Any](format.raw/*93.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*94.39*/disciplina/*94.49*/.getId())),format.raw/*94.57*/("""', '"""),_display_(Seq[Any](/*94.62*/numPeriodo)),format.raw/*94.72*/("""', '"""),_display_(Seq[Any](/*94.77*/planejador/*94.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*94.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*94.167*/disciplina/*94.177*/.getPreRequisitos())),format.raw/*94.196*/("""">"""),_display_(Seq[Any](/*94.199*/disciplina/*94.209*/.getNome())),format.raw/*94.219*/("""</a>   <span>"""),_display_(Seq[Any](/*94.233*/disciplina/*94.243*/.getCreditos())),format.raw/*94.257*/("""  /  """),_display_(Seq[Any](/*94.263*/disciplina/*94.273*/.getDificuldade())),format.raw/*94.290*/("""</span>
				<br>
			""")))})),format.raw/*96.5*/("""
		""")))})),format.raw/*97.4*/("""
		<br>
		"""),_display_(Seq[Any](/*99.4*/for(disciplina <- naoAlocadas) yield /*99.34*/ {_display_(Seq[Any](format.raw/*99.36*/("""
			"""),_display_(Seq[Any](/*100.5*/if(disciplina.getPeriodoSugerido() == 3)/*100.45*/{_display_(Seq[Any](format.raw/*100.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*101.39*/disciplina/*101.49*/.getId())),format.raw/*101.57*/("""', '"""),_display_(Seq[Any](/*101.62*/numPeriodo)),format.raw/*101.72*/("""', '"""),_display_(Seq[Any](/*101.77*/planejador/*101.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*101.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*101.167*/disciplina/*101.177*/.getPreRequisitos())),format.raw/*101.196*/("""">"""),_display_(Seq[Any](/*101.199*/disciplina/*101.209*/.getNome())),format.raw/*101.219*/("""</a>   <span>"""),_display_(Seq[Any](/*101.233*/disciplina/*101.243*/.getCreditos())),format.raw/*101.257*/("""  /  """),_display_(Seq[Any](/*101.263*/disciplina/*101.273*/.getDificuldade())),format.raw/*101.290*/("""</span>
				<br>
			""")))})),format.raw/*103.5*/("""
		""")))})),format.raw/*104.4*/("""
		<br>
		"""),_display_(Seq[Any](/*106.4*/for(disciplina <- naoAlocadas) yield /*106.34*/ {_display_(Seq[Any](format.raw/*106.36*/("""
			"""),_display_(Seq[Any](/*107.5*/if(disciplina.getPeriodoSugerido() == 4)/*107.45*/{_display_(Seq[Any](format.raw/*107.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*108.39*/disciplina/*108.49*/.getId())),format.raw/*108.57*/("""', '"""),_display_(Seq[Any](/*108.62*/numPeriodo)),format.raw/*108.72*/("""', '"""),_display_(Seq[Any](/*108.77*/planejador/*108.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*108.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*108.167*/disciplina/*108.177*/.getPreRequisitos())),format.raw/*108.196*/("""">"""),_display_(Seq[Any](/*108.199*/disciplina/*108.209*/.getNome())),format.raw/*108.219*/("""</a>   <span>"""),_display_(Seq[Any](/*108.233*/disciplina/*108.243*/.getCreditos())),format.raw/*108.257*/("""  /  """),_display_(Seq[Any](/*108.263*/disciplina/*108.273*/.getDificuldade())),format.raw/*108.290*/("""</span>
				<br>
			""")))})),format.raw/*110.5*/("""
		""")))})),format.raw/*111.4*/("""
		<br>
		"""),_display_(Seq[Any](/*113.4*/for(disciplina <- naoAlocadas) yield /*113.34*/ {_display_(Seq[Any](format.raw/*113.36*/("""
			"""),_display_(Seq[Any](/*114.5*/if(disciplina.getPeriodoSugerido() == 5)/*114.45*/{_display_(Seq[Any](format.raw/*114.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*115.39*/disciplina/*115.49*/.getId())),format.raw/*115.57*/("""', '"""),_display_(Seq[Any](/*115.62*/numPeriodo)),format.raw/*115.72*/("""', '"""),_display_(Seq[Any](/*115.77*/planejador/*115.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*115.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*115.167*/disciplina/*115.177*/.getPreRequisitos())),format.raw/*115.196*/("""">"""),_display_(Seq[Any](/*115.199*/disciplina/*115.209*/.getNome())),format.raw/*115.219*/("""</a>   <span>"""),_display_(Seq[Any](/*115.233*/disciplina/*115.243*/.getCreditos())),format.raw/*115.257*/("""  /  """),_display_(Seq[Any](/*115.263*/disciplina/*115.273*/.getDificuldade())),format.raw/*115.290*/("""</span>
				<br>
			""")))})),format.raw/*117.5*/("""
		""")))})),format.raw/*118.4*/("""
		<br>
		"""),_display_(Seq[Any](/*120.4*/for(disciplina <- naoAlocadas) yield /*120.34*/ {_display_(Seq[Any](format.raw/*120.36*/("""
			"""),_display_(Seq[Any](/*121.5*/if(disciplina.getPeriodoSugerido() == 6)/*121.45*/{_display_(Seq[Any](format.raw/*121.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*122.39*/disciplina/*122.49*/.getId())),format.raw/*122.57*/("""', '"""),_display_(Seq[Any](/*122.62*/numPeriodo)),format.raw/*122.72*/("""', '"""),_display_(Seq[Any](/*122.77*/planejador/*122.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*122.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*122.167*/disciplina/*122.177*/.getPreRequisitos())),format.raw/*122.196*/("""">"""),_display_(Seq[Any](/*122.199*/disciplina/*122.209*/.getNome())),format.raw/*122.219*/("""</a>   <span>"""),_display_(Seq[Any](/*122.233*/disciplina/*122.243*/.getCreditos())),format.raw/*122.257*/("""  /  """),_display_(Seq[Any](/*122.263*/disciplina/*122.273*/.getDificuldade())),format.raw/*122.290*/("""</span>
				<br>
			""")))})),format.raw/*124.5*/("""
		""")))})),format.raw/*125.4*/("""
		<br>
		"""),_display_(Seq[Any](/*127.4*/for(disciplina <- naoAlocadas) yield /*127.34*/ {_display_(Seq[Any](format.raw/*127.36*/("""
			"""),_display_(Seq[Any](/*128.5*/if(disciplina.getPeriodoSugerido() == 7)/*128.45*/{_display_(Seq[Any](format.raw/*128.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*129.39*/disciplina/*129.49*/.getId())),format.raw/*129.57*/("""', '"""),_display_(Seq[Any](/*129.62*/numPeriodo)),format.raw/*129.72*/("""', '"""),_display_(Seq[Any](/*129.77*/planejador/*129.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*129.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*129.167*/disciplina/*129.177*/.getPreRequisitos())),format.raw/*129.196*/("""">"""),_display_(Seq[Any](/*129.199*/disciplina/*129.209*/.getNome())),format.raw/*129.219*/("""</a>   <span>"""),_display_(Seq[Any](/*129.233*/disciplina/*129.243*/.getCreditos())),format.raw/*129.257*/("""  /  """),_display_(Seq[Any](/*129.263*/disciplina/*129.273*/.getDificuldade())),format.raw/*129.290*/("""</span>
				<br>
			""")))})),format.raw/*131.5*/("""
		""")))})),format.raw/*132.4*/("""
		<br>
		"""),_display_(Seq[Any](/*134.4*/for(disciplina <- naoAlocadas) yield /*134.34*/ {_display_(Seq[Any](format.raw/*134.36*/("""
			"""),_display_(Seq[Any](/*135.5*/if(disciplina.getPeriodoSugerido() == 8)/*135.45*/{_display_(Seq[Any](format.raw/*135.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*136.39*/disciplina/*136.49*/.getId())),format.raw/*136.57*/("""', '"""),_display_(Seq[Any](/*136.62*/numPeriodo)),format.raw/*136.72*/("""', '"""),_display_(Seq[Any](/*136.77*/planejador/*136.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*136.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*136.167*/disciplina/*136.177*/.getPreRequisitos())),format.raw/*136.196*/("""">"""),_display_(Seq[Any](/*136.199*/disciplina/*136.209*/.getNome())),format.raw/*136.219*/("""</a>   <span>"""),_display_(Seq[Any](/*136.233*/disciplina/*136.243*/.getCreditos())),format.raw/*136.257*/("""  /  """),_display_(Seq[Any](/*136.263*/disciplina/*136.273*/.getDificuldade())),format.raw/*136.290*/("""</span>
				<br>
			""")))})),format.raw/*138.5*/("""
		""")))})),format.raw/*139.4*/("""
	</div>

	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*146.4*/for(disciplina <- naoAlocadas) yield /*146.34*/ {_display_(Seq[Any](format.raw/*146.36*/("""
			"""),_display_(Seq[Any](/*147.5*/if(disciplina.getPeriodoSugerido() == -2)/*147.46*/{_display_(Seq[Any](format.raw/*147.47*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*148.39*/disciplina/*148.49*/.getId())),format.raw/*148.57*/("""', '"""),_display_(Seq[Any](/*148.62*/numPeriodo)),format.raw/*148.72*/("""', '"""),_display_(Seq[Any](/*148.77*/planejador/*148.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*148.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*148.167*/disciplina/*148.177*/.getPreRequisitos())),format.raw/*148.196*/("""">"""),_display_(Seq[Any](/*148.199*/disciplina/*148.209*/.getNome())),format.raw/*148.219*/("""</a>   <span>"""),_display_(Seq[Any](/*148.233*/disciplina/*148.243*/.getCreditos())),format.raw/*148.257*/("""  /  """),_display_(Seq[Any](/*148.263*/disciplina/*148.273*/.getDificuldade())),format.raw/*148.290*/("""</span>
				<br>
			""")))})),format.raw/*150.5*/("""
		""")))})),format.raw/*151.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*158.4*/for(disciplina <- naoAlocadas) yield /*158.34*/ {_display_(Seq[Any](format.raw/*158.36*/("""
				"""),_display_(Seq[Any](/*159.6*/if(disciplina.getPeriodoSugerido() == -1)/*159.47*/{_display_(Seq[Any](format.raw/*159.48*/("""
					<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*160.40*/disciplina/*160.50*/.getId())),format.raw/*160.58*/("""', '"""),_display_(Seq[Any](/*160.63*/numPeriodo)),format.raw/*160.73*/("""', '"""),_display_(Seq[Any](/*160.78*/planejador/*160.88*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*160.126*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*160.168*/disciplina/*160.178*/.getPreRequisitos())),format.raw/*160.197*/("""">"""),_display_(Seq[Any](/*160.200*/disciplina/*160.210*/.getNome())),format.raw/*160.220*/("""</a>   <span>"""),_display_(Seq[Any](/*160.234*/disciplina/*160.244*/.getCreditos())),format.raw/*160.258*/("""  /  """),_display_(Seq[Any](/*160.264*/disciplina/*160.274*/.getDificuldade())),format.raw/*160.291*/("""</span>
					<br>
				""")))})),format.raw/*162.6*/("""
		""")))})),format.raw/*163.4*/("""
	</div>
			
	
</div>
""")))})))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],numPeriodo:Integer,planejador:Planejador): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,numPeriodo,planejador)
    
    def f:((List[Periodo],List[Disciplina],Integer,Planejador) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,numPeriodo,planejador) => apply(periodos,naoAlocadas,numPeriodo,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 05 15:24:30 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 35ae1b0b558e4c8ce6ef0947a19c4605e5351c65
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1239->188|1257->198|1299->219|1433->318|1470->346|1509->347|1572->374|1604->384|1690->453|1702->458|1741->459|1804->486|1836->496|1937->566|2021->615|2061->639|2100->640|2140->645|2186->682|2225->683|2392->813|2409->820|2444->832|2704->1056|2770->1106|2810->1108|2858->1120|2912->1165|2952->1167|3029->1208|3055->1225|3085->1233|3126->1238|3158->1248|3199->1253|3218->1263|3296->1318|3375->1360|3402->1377|3442->1394|3482->1397|3509->1414|3542->1424|3604->1450|3630->1467|3666->1481|3706->1485|3732->1502|3771->1519|3825->1555|3838->1560|3877->1561|3951->1599|3977->1616|4007->1624|4048->1629|4080->1639|4121->1644|4140->1654|4218->1709|4305->1759|4332->1776|4372->1793|4412->1796|4439->1813|4472->1823|4531->1846|4557->1863|4593->1877|4633->1881|4659->1898|4698->1915|4765->1950|4808->1961|4925->2043|4971->2080|5010->2081|5127->2167|5185->2189|5201->2196|5244->2217|5287->2224|5303->2231|5349->2255|5533->2422|5546->2427|5585->2428|5681->2488|5697->2495|5731->2507|5829->2568|5846->2575|5881->2587|6167->2837|6233->2887|6273->2889|6321->2901|6392->2963|6432->2965|6484->2981|6510->2998|6542->3008|6601->3031|6627->3048|6663->3062|6720->3101|6733->3106|6772->3107|6821->3120|6875->3165|6915->3167|6997->3213|7023->3230|7053->3238|7094->3243|7126->3253|7167->3258|7183->3265|7218->3277|7297->3319|7324->3336|7364->3353|7404->3356|7431->3373|7464->3383|7527->3410|7553->3427|7589->3441|7629->3445|7655->3462|7694->3479|7750->3517|7763->3522|7802->3523|7881->3566|7907->3583|7937->3591|7978->3596|8010->3606|8051->3611|8067->3618|8102->3630|8189->3680|8216->3697|8256->3714|8296->3717|8323->3734|8356->3744|8416->3768|8442->3785|8478->3799|8518->3803|8544->3820|8583->3837|8652->3874|8696->3886|8739->3897|8859->3982|8905->4019|8944->4020|9061->4106|9119->4128|9135->4135|9178->4156|9221->4163|9237->4170|9283->4194|9368->4248|9406->4255|9741->4555|9787->4585|9827->4587|9868->4593|9917->4633|9956->4634|10032->4674|10051->4684|10081->4692|10122->4697|10154->4707|10195->4712|10214->4722|10275->4760|10354->4802|10374->4812|10416->4831|10456->4834|10476->4844|10509->4854|10560->4868|10580->4878|10617->4892|10660->4898|10680->4908|10720->4925|10774->4948|10810->4953|10862->4970|10908->5000|10948->5002|10989->5008|11038->5048|11077->5049|11153->5089|11172->5099|11202->5107|11243->5112|11275->5122|11316->5127|11335->5137|11396->5175|11475->5217|11495->5227|11537->5246|11577->5249|11597->5259|11630->5269|11681->5283|11701->5293|11738->5307|11781->5313|11801->5323|11841->5340|11895->5363|11931->5368|11979->5381|12025->5411|12065->5413|12107->5419|12157->5459|12197->5460|12274->5500|12294->5510|12325->5518|12367->5523|12400->5533|12442->5538|12462->5548|12524->5586|12604->5628|12625->5638|12668->5657|12709->5660|12730->5670|12764->5680|12816->5694|12837->5704|12875->5718|12919->5724|12940->5734|12981->5751|13036->5774|13073->5779|13122->5792|13169->5822|13210->5824|13252->5830|13302->5870|13342->5871|13419->5911|13439->5921|13470->5929|13512->5934|13545->5944|13587->5949|13607->5959|13669->5997|13749->6039|13770->6049|13813->6068|13854->6071|13875->6081|13909->6091|13961->6105|13982->6115|14020->6129|14064->6135|14085->6145|14126->6162|14181->6185|14218->6190|14267->6203|14314->6233|14355->6235|14397->6241|14447->6281|14487->6282|14564->6322|14584->6332|14615->6340|14657->6345|14690->6355|14732->6360|14752->6370|14814->6408|14894->6450|14915->6460|14958->6479|14999->6482|15020->6492|15054->6502|15106->6516|15127->6526|15165->6540|15209->6546|15230->6556|15271->6573|15326->6596|15363->6601|15412->6614|15459->6644|15500->6646|15542->6652|15592->6692|15632->6693|15709->6733|15729->6743|15760->6751|15802->6756|15835->6766|15877->6771|15897->6781|15959->6819|16039->6861|16060->6871|16103->6890|16144->6893|16165->6903|16199->6913|16251->6927|16272->6937|16310->6951|16354->6957|16375->6967|16416->6984|16471->7007|16508->7012|16557->7025|16604->7055|16645->7057|16687->7063|16737->7103|16777->7104|16854->7144|16874->7154|16905->7162|16947->7167|16980->7177|17022->7182|17042->7192|17104->7230|17184->7272|17205->7282|17248->7301|17289->7304|17310->7314|17344->7324|17396->7338|17417->7348|17455->7362|17499->7368|17520->7378|17561->7395|17616->7418|17653->7423|17702->7436|17749->7466|17790->7468|17832->7474|17882->7514|17922->7515|17999->7555|18019->7565|18050->7573|18092->7578|18125->7588|18167->7593|18187->7603|18249->7641|18329->7683|18350->7693|18393->7712|18434->7715|18455->7725|18489->7735|18541->7749|18562->7759|18600->7773|18644->7779|18665->7789|18706->7806|18761->7829|18798->7834|19049->8049|19096->8079|19137->8081|19179->8087|19230->8128|19270->8129|19347->8169|19367->8179|19398->8187|19440->8192|19473->8202|19515->8207|19535->8217|19597->8255|19677->8297|19698->8307|19741->8326|19782->8329|19803->8339|19837->8349|19889->8363|19910->8373|19948->8387|19992->8393|20013->8403|20054->8420|20109->8443|20146->8448|20407->8673|20454->8703|20495->8705|20538->8712|20589->8753|20629->8754|20707->8795|20727->8805|20758->8813|20800->8818|20833->8828|20875->8833|20895->8843|20957->8881|21037->8923|21058->8933|21101->8952|21142->8955|21163->8965|21197->8975|21249->8989|21270->8999|21308->9013|21352->9019|21373->9029|21414->9046|21471->9071|21508->9076
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|39->11|39->11|40->12|40->12|40->12|41->13|41->13|42->14|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|55->27|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|61->33|62->34|65->37|65->37|65->37|67->39|68->40|68->40|68->40|68->40|68->40|68->40|72->44|72->44|72->44|74->46|74->46|74->46|74->46|74->46|74->46|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|85->57|85->57|85->57|85->57|85->57|85->57|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|91->63|92->64|93->65|96->68|96->68|96->68|98->70|99->71|99->71|99->71|99->71|99->71|99->71|102->74|103->75|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|116->88|117->89|120->92|120->92|120->92|121->93|121->93|121->93|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|122->94|124->96|125->97|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|131->103|132->104|134->106|134->106|134->106|135->107|135->107|135->107|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|138->110|139->111|141->113|141->113|141->113|142->114|142->114|142->114|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|143->115|145->117|146->118|148->120|148->120|148->120|149->121|149->121|149->121|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|152->124|153->125|155->127|155->127|155->127|156->128|156->128|156->128|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|159->131|160->132|162->134|162->134|162->134|163->135|163->135|163->135|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|164->136|166->138|167->139|174->146|174->146|174->146|175->147|175->147|175->147|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|176->148|178->150|179->151|186->158|186->158|186->158|187->159|187->159|187->159|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|188->160|190->162|191->163
                    -- GENERATED --
                */
            