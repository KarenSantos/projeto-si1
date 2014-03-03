
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
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*13.3*/for(periodo <- periodos) yield /*13.27*/{_display_(Seq[Any](format.raw/*13.28*/("""
		"""),_display_(Seq[Any](/*14.4*/if(periodo.getNumero() == numPeriodo)/*14.41*/{_display_(Seq[Any](format.raw/*14.42*/("""
			<div id="periodoBox">
				<a onclick="sairEdicao()" title="Clique aqui para fechar edição"><div id="numPeriodoEditando"><b>"""),_display_(Seq[Any](/*16.103*/periodo/*16.110*/.getNumero())),format.raw/*16.122*/("""º</b> Período</div></a>
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*19.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*19.60*/ {_display_(Seq[Any](format.raw/*19.62*/("""
				    	"""),_display_(Seq[Any](/*20.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*20.56*/ {_display_(Seq[Any](format.raw/*20.58*/("""
				    	   	<a onclick="rDisciplina('"""),_display_(Seq[Any](/*21.40*/disciplinaPeriodo/*21.57*/.getId())),format.raw/*21.65*/("""', '"""),_display_(Seq[Any](/*21.70*/numPeriodo)),format.raw/*21.80*/("""', '"""),_display_(Seq[Any](/*21.85*/planejador/*21.95*/.ehPreRequisito(disciplinaPeriodo, periodo.getNumero()))),format.raw/*21.150*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*21.192*/disciplinaPeriodo/*21.209*/.getPreRequisitos)),format.raw/*21.226*/("""">"""),_display_(Seq[Any](/*21.229*/disciplinaPeriodo/*21.246*/.getNome())),format.raw/*21.256*/("""</a><span>"""),_display_(Seq[Any](/*21.267*/disciplinaPeriodo/*21.284*/.getCreditos())),format.raw/*21.298*/(""" / """),_display_(Seq[Any](/*21.302*/disciplinaPeriodo/*21.319*/.getDificuldade())),format.raw/*21.336*/("""</span>
				    		<br>
				    	""")))}/*23.12*/else/*23.17*/{_display_(Seq[Any](format.raw/*23.18*/("""
				    		<a onclick="rDisciplina('"""),_display_(Seq[Any](/*24.37*/disciplinaPeriodo/*24.54*/.getId())),format.raw/*24.62*/("""', '"""),_display_(Seq[Any](/*24.67*/numPeriodo)),format.raw/*24.77*/("""', '"""),_display_(Seq[Any](/*24.82*/planejador/*24.92*/.ehPreRequisito(disciplinaPeriodo, periodo.getNumero()))),format.raw/*24.147*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*24.197*/disciplinaPeriodo/*24.214*/.getPreRequisitos)),format.raw/*24.231*/("""">"""),_display_(Seq[Any](/*24.234*/disciplinaPeriodo/*24.251*/.getNome())),format.raw/*24.261*/("""</a><span>"""),_display_(Seq[Any](/*24.272*/disciplinaPeriodo/*24.289*/.getCreditos())),format.raw/*24.303*/(""" / """),_display_(Seq[Any](/*24.307*/disciplinaPeriodo/*24.324*/.getDificuldade())),format.raw/*24.341*/("""</span>
				    		<br>
				    	""")))})),format.raw/*26.11*/("""
				    """)))})),format.raw/*27.10*/("""
				</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*30.6*/if(periodo.getTotalDeCreditos() < 14)/*30.43*/{_display_(Seq[Any](format.raw/*30.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*32.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*33.21*/periodo/*33.28*/.getTotalDeCreditos())),format.raw/*33.49*/("""  /   """),_display_(Seq[Any](/*33.56*/periodo/*33.63*/.getTotalDeDificuldade())),format.raw/*33.87*/("""
				</div>
				<div id="editandoNote">Clique na disciplina para adicionar aqui ou mover de outro período para este.</div>
			</div><!-- Fim de um periodo -->
		""")))}/*37.5*/else/*37.10*/{_display_(Seq[Any](format.raw/*37.11*/("""
			<div id="periodoBox">
				<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*39.33*/periodo/*39.40*/.getNumero())),format.raw/*39.52*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*39.113*/periodo/*39.120*/.getNumero())),format.raw/*39.132*/("""º</b> Período</div></a><!-- Numero do periodo -->
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*42.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*42.60*/ {_display_(Seq[Any](format.raw/*42.62*/("""
				    	"""),_display_(Seq[Any](/*43.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*43.56*/ {_display_(Seq[Any](format.raw/*43.58*/("""
				    	   	<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*44.44*/disciplinaPeriodo/*44.61*/.getId())),format.raw/*44.69*/("""', '"""),_display_(Seq[Any](/*44.74*/numPeriodo)),format.raw/*44.84*/("""', '"""),_display_(Seq[Any](/*44.89*/periodo/*44.96*/.getNumero())),format.raw/*44.108*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*44.150*/disciplinaPeriodo/*44.167*/.getPreRequisitos)),format.raw/*44.184*/("""">"""),_display_(Seq[Any](/*44.187*/disciplinaPeriodo/*44.204*/.getNome())),format.raw/*44.214*/("""</a><span>"""),_display_(Seq[Any](/*44.225*/disciplinaPeriodo/*44.242*/.getCreditos())),format.raw/*44.256*/(""" / """),_display_(Seq[Any](/*44.260*/disciplinaPeriodo/*44.277*/.getDificuldade())),format.raw/*44.294*/("""</span>
				    		<br>
				    	""")))}/*46.12*/else/*46.17*/{_display_(Seq[Any](format.raw/*46.18*/("""
				    		<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*47.41*/disciplinaPeriodo/*47.58*/.getId())),format.raw/*47.66*/("""', '"""),_display_(Seq[Any](/*47.71*/numPeriodo)),format.raw/*47.81*/("""', '"""),_display_(Seq[Any](/*47.86*/periodo/*47.93*/.getNumero())),format.raw/*47.105*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*47.155*/disciplinaPeriodo/*47.172*/.getPreRequisitos)),format.raw/*47.189*/("""">"""),_display_(Seq[Any](/*47.192*/disciplinaPeriodo/*47.209*/.getNome())),format.raw/*47.219*/("""</a><span>"""),_display_(Seq[Any](/*47.230*/disciplinaPeriodo/*47.247*/.getCreditos())),format.raw/*47.261*/(""" / """),_display_(Seq[Any](/*47.265*/disciplinaPeriodo/*47.282*/.getDificuldade())),format.raw/*47.299*/("""</span>
				    		<br>
				    	""")))})),format.raw/*49.11*/("""
				    """)))})),format.raw/*50.10*/("""
			   	</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*53.6*/if(periodo.getTotalDeCreditos() < 14)/*53.43*/{_display_(Seq[Any](format.raw/*53.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*55.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*56.21*/periodo/*56.28*/.getTotalDeCreditos())),format.raw/*56.49*/("""  /   """),_display_(Seq[Any](/*56.56*/periodo/*56.63*/.getTotalDeDificuldade())),format.raw/*56.87*/("""
				</div>
			</div><!-- Fim de um periodo -->
		""")))})),format.raw/*59.4*/("""			
	""")))})),format.raw/*60.3*/("""
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*69.4*/for(disciplina <- naoAlocadas) yield /*69.34*/ {_display_(Seq[Any](format.raw/*69.36*/("""
			"""),_display_(Seq[Any](/*70.5*/if(disciplina.getPeriodoSugerido() == 1)/*70.45*/{_display_(Seq[Any](format.raw/*70.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*71.39*/disciplina/*71.49*/.getId())),format.raw/*71.57*/("""', '"""),_display_(Seq[Any](/*71.62*/numPeriodo)),format.raw/*71.72*/("""', '"""),_display_(Seq[Any](/*71.77*/planejador/*71.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*71.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*71.167*/disciplina/*71.177*/.getPreRequisitos())),format.raw/*71.196*/("""">"""),_display_(Seq[Any](/*71.199*/disciplina/*71.209*/.getNome())),format.raw/*71.219*/("""</a>   <span>"""),_display_(Seq[Any](/*71.233*/disciplina/*71.243*/.getCreditos())),format.raw/*71.257*/("""  /  """),_display_(Seq[Any](/*71.263*/disciplina/*71.273*/.getDificuldade())),format.raw/*71.290*/("""</span>
				<br>
			""")))})),format.raw/*73.5*/("""
		""")))})),format.raw/*74.4*/("""
		<br>
		
		"""),_display_(Seq[Any](/*77.4*/for(disciplina <- naoAlocadas) yield /*77.34*/ {_display_(Seq[Any](format.raw/*77.36*/("""
			"""),_display_(Seq[Any](/*78.5*/if(disciplina.getPeriodoSugerido() == 2)/*78.45*/{_display_(Seq[Any](format.raw/*78.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*79.39*/disciplina/*79.49*/.getId())),format.raw/*79.57*/("""', '"""),_display_(Seq[Any](/*79.62*/numPeriodo)),format.raw/*79.72*/("""', '"""),_display_(Seq[Any](/*79.77*/planejador/*79.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*79.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*79.167*/disciplina/*79.177*/.getPreRequisitos())),format.raw/*79.196*/("""">"""),_display_(Seq[Any](/*79.199*/disciplina/*79.209*/.getNome())),format.raw/*79.219*/("""</a>   <span>"""),_display_(Seq[Any](/*79.233*/disciplina/*79.243*/.getCreditos())),format.raw/*79.257*/("""  /  """),_display_(Seq[Any](/*79.263*/disciplina/*79.273*/.getDificuldade())),format.raw/*79.290*/("""</span>
				<br>
			""")))})),format.raw/*81.5*/("""
		""")))})),format.raw/*82.4*/("""
		<br>
		"""),_display_(Seq[Any](/*84.4*/for(disciplina <- naoAlocadas) yield /*84.34*/ {_display_(Seq[Any](format.raw/*84.36*/("""
			"""),_display_(Seq[Any](/*85.5*/if(disciplina.getPeriodoSugerido() == 3)/*85.45*/{_display_(Seq[Any](format.raw/*85.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*86.39*/disciplina/*86.49*/.getId())),format.raw/*86.57*/("""', '"""),_display_(Seq[Any](/*86.62*/numPeriodo)),format.raw/*86.72*/("""', '"""),_display_(Seq[Any](/*86.77*/planejador/*86.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*86.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*86.167*/disciplina/*86.177*/.getPreRequisitos())),format.raw/*86.196*/("""">"""),_display_(Seq[Any](/*86.199*/disciplina/*86.209*/.getNome())),format.raw/*86.219*/("""</a>   <span>"""),_display_(Seq[Any](/*86.233*/disciplina/*86.243*/.getCreditos())),format.raw/*86.257*/("""  /  """),_display_(Seq[Any](/*86.263*/disciplina/*86.273*/.getDificuldade())),format.raw/*86.290*/("""</span>
				<br>
			""")))})),format.raw/*88.5*/("""
		""")))})),format.raw/*89.4*/("""
		<br>
		"""),_display_(Seq[Any](/*91.4*/for(disciplina <- naoAlocadas) yield /*91.34*/ {_display_(Seq[Any](format.raw/*91.36*/("""
			"""),_display_(Seq[Any](/*92.5*/if(disciplina.getPeriodoSugerido() == 4)/*92.45*/{_display_(Seq[Any](format.raw/*92.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*93.39*/disciplina/*93.49*/.getId())),format.raw/*93.57*/("""', '"""),_display_(Seq[Any](/*93.62*/numPeriodo)),format.raw/*93.72*/("""', '"""),_display_(Seq[Any](/*93.77*/planejador/*93.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*93.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*93.167*/disciplina/*93.177*/.getPreRequisitos())),format.raw/*93.196*/("""">"""),_display_(Seq[Any](/*93.199*/disciplina/*93.209*/.getNome())),format.raw/*93.219*/("""</a>   <span>"""),_display_(Seq[Any](/*93.233*/disciplina/*93.243*/.getCreditos())),format.raw/*93.257*/("""  /  """),_display_(Seq[Any](/*93.263*/disciplina/*93.273*/.getDificuldade())),format.raw/*93.290*/("""</span>
				<br>
			""")))})),format.raw/*95.5*/("""
		""")))})),format.raw/*96.4*/("""
		<br>
		"""),_display_(Seq[Any](/*98.4*/for(disciplina <- naoAlocadas) yield /*98.34*/ {_display_(Seq[Any](format.raw/*98.36*/("""
			"""),_display_(Seq[Any](/*99.5*/if(disciplina.getPeriodoSugerido() == 5)/*99.45*/{_display_(Seq[Any](format.raw/*99.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*100.39*/disciplina/*100.49*/.getId())),format.raw/*100.57*/("""', '"""),_display_(Seq[Any](/*100.62*/numPeriodo)),format.raw/*100.72*/("""', '"""),_display_(Seq[Any](/*100.77*/planejador/*100.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*100.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*100.167*/disciplina/*100.177*/.getPreRequisitos())),format.raw/*100.196*/("""">"""),_display_(Seq[Any](/*100.199*/disciplina/*100.209*/.getNome())),format.raw/*100.219*/("""</a>   <span>"""),_display_(Seq[Any](/*100.233*/disciplina/*100.243*/.getCreditos())),format.raw/*100.257*/("""  /  """),_display_(Seq[Any](/*100.263*/disciplina/*100.273*/.getDificuldade())),format.raw/*100.290*/("""</span>
				<br>
			""")))})),format.raw/*102.5*/("""
		""")))})),format.raw/*103.4*/("""
		<br>
		"""),_display_(Seq[Any](/*105.4*/for(disciplina <- naoAlocadas) yield /*105.34*/ {_display_(Seq[Any](format.raw/*105.36*/("""
			"""),_display_(Seq[Any](/*106.5*/if(disciplina.getPeriodoSugerido() == 6)/*106.45*/{_display_(Seq[Any](format.raw/*106.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*107.39*/disciplina/*107.49*/.getId())),format.raw/*107.57*/("""', '"""),_display_(Seq[Any](/*107.62*/numPeriodo)),format.raw/*107.72*/("""', '"""),_display_(Seq[Any](/*107.77*/planejador/*107.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*107.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*107.167*/disciplina/*107.177*/.getPreRequisitos())),format.raw/*107.196*/("""">"""),_display_(Seq[Any](/*107.199*/disciplina/*107.209*/.getNome())),format.raw/*107.219*/("""</a>   <span>"""),_display_(Seq[Any](/*107.233*/disciplina/*107.243*/.getCreditos())),format.raw/*107.257*/("""  /  """),_display_(Seq[Any](/*107.263*/disciplina/*107.273*/.getDificuldade())),format.raw/*107.290*/("""</span>
				<br>
			""")))})),format.raw/*109.5*/("""
		""")))})),format.raw/*110.4*/("""
		<br>
		"""),_display_(Seq[Any](/*112.4*/for(disciplina <- naoAlocadas) yield /*112.34*/ {_display_(Seq[Any](format.raw/*112.36*/("""
			"""),_display_(Seq[Any](/*113.5*/if(disciplina.getPeriodoSugerido() == 7)/*113.45*/{_display_(Seq[Any](format.raw/*113.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*114.39*/disciplina/*114.49*/.getId())),format.raw/*114.57*/("""', '"""),_display_(Seq[Any](/*114.62*/numPeriodo)),format.raw/*114.72*/("""', '"""),_display_(Seq[Any](/*114.77*/planejador/*114.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*114.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*114.167*/disciplina/*114.177*/.getPreRequisitos())),format.raw/*114.196*/("""">"""),_display_(Seq[Any](/*114.199*/disciplina/*114.209*/.getNome())),format.raw/*114.219*/("""</a>   <span>"""),_display_(Seq[Any](/*114.233*/disciplina/*114.243*/.getCreditos())),format.raw/*114.257*/("""  /  """),_display_(Seq[Any](/*114.263*/disciplina/*114.273*/.getDificuldade())),format.raw/*114.290*/("""</span>
				<br>
			""")))})),format.raw/*116.5*/("""
		""")))})),format.raw/*117.4*/("""
		<br>
		"""),_display_(Seq[Any](/*119.4*/for(disciplina <- naoAlocadas) yield /*119.34*/ {_display_(Seq[Any](format.raw/*119.36*/("""
			"""),_display_(Seq[Any](/*120.5*/if(disciplina.getPeriodoSugerido() == 8)/*120.45*/{_display_(Seq[Any](format.raw/*120.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*121.39*/disciplina/*121.49*/.getId())),format.raw/*121.57*/("""', '"""),_display_(Seq[Any](/*121.62*/numPeriodo)),format.raw/*121.72*/("""', '"""),_display_(Seq[Any](/*121.77*/planejador/*121.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*121.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*121.167*/disciplina/*121.177*/.getPreRequisitos())),format.raw/*121.196*/("""">"""),_display_(Seq[Any](/*121.199*/disciplina/*121.209*/.getNome())),format.raw/*121.219*/("""</a>   <span>"""),_display_(Seq[Any](/*121.233*/disciplina/*121.243*/.getCreditos())),format.raw/*121.257*/("""  /  """),_display_(Seq[Any](/*121.263*/disciplina/*121.273*/.getDificuldade())),format.raw/*121.290*/("""</span>
				<br>
			""")))})),format.raw/*123.5*/("""
		""")))})),format.raw/*124.4*/("""
	</div>

	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*131.4*/for(disciplina <- naoAlocadas) yield /*131.34*/ {_display_(Seq[Any](format.raw/*131.36*/("""
			"""),_display_(Seq[Any](/*132.5*/if(disciplina.getPeriodoSugerido() == -2)/*132.46*/{_display_(Seq[Any](format.raw/*132.47*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*133.39*/disciplina/*133.49*/.getId())),format.raw/*133.57*/("""', '"""),_display_(Seq[Any](/*133.62*/numPeriodo)),format.raw/*133.72*/("""', '"""),_display_(Seq[Any](/*133.77*/planejador/*133.87*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*133.125*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*133.167*/disciplina/*133.177*/.getPreRequisitos())),format.raw/*133.196*/("""">"""),_display_(Seq[Any](/*133.199*/disciplina/*133.209*/.getNome())),format.raw/*133.219*/("""</a>   <span>"""),_display_(Seq[Any](/*133.233*/disciplina/*133.243*/.getCreditos())),format.raw/*133.257*/("""  /  """),_display_(Seq[Any](/*133.263*/disciplina/*133.273*/.getDificuldade())),format.raw/*133.290*/("""</span>
				<br>
			""")))})),format.raw/*135.5*/("""
		""")))})),format.raw/*136.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*143.4*/for(disciplina <- naoAlocadas) yield /*143.34*/ {_display_(Seq[Any](format.raw/*143.36*/("""
				"""),_display_(Seq[Any](/*144.6*/if(disciplina.getPeriodoSugerido() == -1)/*144.47*/{_display_(Seq[Any](format.raw/*144.48*/("""
					<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*145.40*/disciplina/*145.50*/.getId())),format.raw/*145.58*/("""', '"""),_display_(Seq[Any](/*145.63*/numPeriodo)),format.raw/*145.73*/("""', '"""),_display_(Seq[Any](/*145.78*/planejador/*145.88*/.temPreRequisitoNaoAlocado(disciplina))),format.raw/*145.126*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*145.168*/disciplina/*145.178*/.getPreRequisitos())),format.raw/*145.197*/("""">"""),_display_(Seq[Any](/*145.200*/disciplina/*145.210*/.getNome())),format.raw/*145.220*/("""</a>   <span>"""),_display_(Seq[Any](/*145.234*/disciplina/*145.244*/.getCreditos())),format.raw/*145.258*/("""  /  """),_display_(Seq[Any](/*145.264*/disciplina/*145.274*/.getDificuldade())),format.raw/*145.291*/("""</span>
					<br>
				""")))})),format.raw/*147.6*/("""
		""")))})),format.raw/*148.4*/("""
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
                    DATE: Mon Mar 03 15:47:55 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 3168e5e4a65a781408c8e6ce515cfd0e982ecab6
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1239->188|1257->198|1299->219|1506->391|1546->415|1585->416|1625->421|1671->458|1710->459|1877->589|1894->596|1929->608|2189->832|2255->882|2295->884|2343->896|2397->941|2437->943|2514->984|2540->1001|2570->1009|2611->1014|2643->1024|2684->1029|2703->1039|2781->1094|2860->1136|2887->1153|2927->1170|2967->1173|2994->1190|3027->1200|3075->1211|3102->1228|3139->1242|3180->1246|3207->1263|3247->1280|3301->1316|3314->1321|3353->1322|3427->1360|3453->1377|3483->1385|3524->1390|3556->1400|3597->1405|3616->1415|3694->1470|3781->1520|3808->1537|3848->1554|3888->1557|3915->1574|3948->1584|3996->1595|4023->1612|4060->1626|4101->1630|4128->1647|4168->1664|4235->1699|4278->1710|4395->1792|4441->1829|4480->1830|4597->1916|4655->1938|4671->1945|4714->1966|4757->1973|4773->1980|4819->2004|5003->2171|5016->2176|5055->2177|5151->2237|5167->2244|5201->2256|5299->2317|5316->2324|5351->2336|5637->2586|5703->2636|5743->2638|5791->2650|5845->2695|5885->2697|5966->2742|5992->2759|6022->2767|6063->2772|6095->2782|6136->2787|6152->2794|6187->2806|6266->2848|6293->2865|6333->2882|6373->2885|6400->2902|6433->2912|6481->2923|6508->2940|6545->2954|6586->2958|6613->2975|6653->2992|6707->3028|6720->3033|6759->3034|6837->3076|6863->3093|6893->3101|6934->3106|6966->3116|7007->3121|7023->3128|7058->3140|7145->3190|7172->3207|7212->3224|7252->3227|7279->3244|7312->3254|7360->3265|7387->3282|7424->3296|7465->3300|7492->3317|7532->3334|7599->3369|7642->3380|7762->3465|7808->3502|7847->3503|7964->3589|8022->3611|8038->3618|8081->3639|8124->3646|8140->3653|8186->3677|8271->3731|8309->3738|8644->4038|8690->4068|8730->4070|8771->4076|8820->4116|8859->4117|8935->4157|8954->4167|8984->4175|9025->4180|9057->4190|9098->4195|9117->4205|9178->4243|9257->4285|9277->4295|9319->4314|9359->4317|9379->4327|9412->4337|9463->4351|9483->4361|9520->4375|9563->4381|9583->4391|9623->4408|9677->4431|9713->4436|9765->4453|9811->4483|9851->4485|9892->4491|9941->4531|9980->4532|10056->4572|10075->4582|10105->4590|10146->4595|10178->4605|10219->4610|10238->4620|10299->4658|10378->4700|10398->4710|10440->4729|10480->4732|10500->4742|10533->4752|10584->4766|10604->4776|10641->4790|10684->4796|10704->4806|10744->4823|10798->4846|10834->4851|10882->4864|10928->4894|10968->4896|11009->4902|11058->4942|11097->4943|11173->4983|11192->4993|11222->5001|11263->5006|11295->5016|11336->5021|11355->5031|11416->5069|11495->5111|11515->5121|11557->5140|11597->5143|11617->5153|11650->5163|11701->5177|11721->5187|11758->5201|11801->5207|11821->5217|11861->5234|11915->5257|11951->5262|11999->5275|12045->5305|12085->5307|12126->5313|12175->5353|12214->5354|12290->5394|12309->5404|12339->5412|12380->5417|12412->5427|12453->5432|12472->5442|12533->5480|12612->5522|12632->5532|12674->5551|12714->5554|12734->5564|12767->5574|12818->5588|12838->5598|12875->5612|12918->5618|12938->5628|12978->5645|13032->5668|13068->5673|13116->5686|13162->5716|13202->5718|13243->5724|13292->5764|13331->5765|13408->5805|13428->5815|13459->5823|13501->5828|13534->5838|13576->5843|13596->5853|13658->5891|13738->5933|13759->5943|13802->5962|13843->5965|13864->5975|13898->5985|13950->5999|13971->6009|14009->6023|14053->6029|14074->6039|14115->6056|14170->6079|14207->6084|14256->6097|14303->6127|14344->6129|14386->6135|14436->6175|14476->6176|14553->6216|14573->6226|14604->6234|14646->6239|14679->6249|14721->6254|14741->6264|14803->6302|14883->6344|14904->6354|14947->6373|14988->6376|15009->6386|15043->6396|15095->6410|15116->6420|15154->6434|15198->6440|15219->6450|15260->6467|15315->6490|15352->6495|15401->6508|15448->6538|15489->6540|15531->6546|15581->6586|15621->6587|15698->6627|15718->6637|15749->6645|15791->6650|15824->6660|15866->6665|15886->6675|15948->6713|16028->6755|16049->6765|16092->6784|16133->6787|16154->6797|16188->6807|16240->6821|16261->6831|16299->6845|16343->6851|16364->6861|16405->6878|16460->6901|16497->6906|16546->6919|16593->6949|16634->6951|16676->6957|16726->6997|16766->6998|16843->7038|16863->7048|16894->7056|16936->7061|16969->7071|17011->7076|17031->7086|17093->7124|17173->7166|17194->7176|17237->7195|17278->7198|17299->7208|17333->7218|17385->7232|17406->7242|17444->7256|17488->7262|17509->7272|17550->7289|17605->7312|17642->7317|17893->7532|17940->7562|17981->7564|18023->7570|18074->7611|18114->7612|18191->7652|18211->7662|18242->7670|18284->7675|18317->7685|18359->7690|18379->7700|18441->7738|18521->7780|18542->7790|18585->7809|18626->7812|18647->7822|18681->7832|18733->7846|18754->7856|18792->7870|18836->7876|18857->7886|18898->7903|18953->7926|18990->7931|19251->8156|19298->8186|19339->8188|19382->8195|19433->8236|19473->8237|19551->8278|19571->8288|19602->8296|19644->8301|19677->8311|19719->8316|19739->8326|19801->8364|19881->8406|19902->8416|19945->8435|19986->8438|20007->8448|20041->8458|20093->8472|20114->8482|20152->8496|20196->8502|20217->8512|20258->8529|20315->8554|20352->8559
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|41->13|41->13|41->13|42->14|42->14|42->14|44->16|44->16|44->16|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|51->23|51->23|51->23|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|52->24|54->26|55->27|58->30|58->30|58->30|60->32|61->33|61->33|61->33|61->33|61->33|61->33|65->37|65->37|65->37|67->39|67->39|67->39|67->39|67->39|67->39|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|72->44|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|81->53|81->53|81->53|83->55|84->56|84->56|84->56|84->56|84->56|84->56|87->59|88->60|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|101->73|102->74|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|109->81|110->82|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|116->88|117->89|119->91|119->91|119->91|120->92|120->92|120->92|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|123->95|124->96|126->98|126->98|126->98|127->99|127->99|127->99|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|128->100|130->102|131->103|133->105|133->105|133->105|134->106|134->106|134->106|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|135->107|137->109|138->110|140->112|140->112|140->112|141->113|141->113|141->113|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|142->114|144->116|145->117|147->119|147->119|147->119|148->120|148->120|148->120|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|151->123|152->124|159->131|159->131|159->131|160->132|160->132|160->132|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|161->133|163->135|164->136|171->143|171->143|171->143|172->144|172->144|172->144|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|173->145|175->147|176->148
                    -- GENERATED --
                */
            