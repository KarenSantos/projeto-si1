
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

<div id="top1"><!-- coluna de periodos -->
	<a onclick="novoPeriodo('"""),_display_(Seq[Any](/*8.28*/planejador/*8.38*/.getTotalDePeriodos())),format.raw/*8.59*/("""+1')"><div id="novoPeriodo">Novo Período</div></a>
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*12.3*/for(periodo <- periodos) yield /*12.27*/{_display_(Seq[Any](format.raw/*12.28*/("""
		"""),_display_(Seq[Any](/*13.4*/if(periodo.getNumero() == numPeriodo)/*13.41*/{_display_(Seq[Any](format.raw/*13.42*/("""
			<div id="periodoBox">
				<a onclick="sairEdicao()" title="Clique aqui para fechar edição"><div id="numPeriodoEditando"><b>"""),_display_(Seq[Any](/*15.103*/periodo/*15.110*/.getNumero())),format.raw/*15.122*/("""º</b> Período</div></a>
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*18.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*18.60*/ {_display_(Seq[Any](format.raw/*18.62*/("""
				    	"""),_display_(Seq[Any](/*19.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*19.56*/ {_display_(Seq[Any](format.raw/*19.58*/("""
				    	   	<a onclick="rDisciplina('"""),_display_(Seq[Any](/*20.40*/disciplinaPeriodo/*20.57*/.getId())),format.raw/*20.65*/("""', '"""),_display_(Seq[Any](/*20.70*/numPeriodo)),format.raw/*20.80*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*20.122*/disciplinaPeriodo/*20.139*/.getPreRequisitos)),format.raw/*20.156*/("""">"""),_display_(Seq[Any](/*20.159*/disciplinaPeriodo/*20.176*/.getNome())),format.raw/*20.186*/("""</a><span>"""),_display_(Seq[Any](/*20.197*/disciplinaPeriodo/*20.214*/.getCreditos())),format.raw/*20.228*/(""" / """),_display_(Seq[Any](/*20.232*/disciplinaPeriodo/*20.249*/.getDificuldade())),format.raw/*20.266*/("""</span>
				    		<br>
				    	""")))}/*22.12*/else/*22.17*/{_display_(Seq[Any](format.raw/*22.18*/("""
				    		<a onclick="rDisciplina('"""),_display_(Seq[Any](/*23.37*/disciplinaPeriodo/*23.54*/.getId())),format.raw/*23.62*/("""', '"""),_display_(Seq[Any](/*23.67*/numPeriodo)),format.raw/*23.77*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*23.127*/disciplinaPeriodo/*23.144*/.getPreRequisitos)),format.raw/*23.161*/("""">"""),_display_(Seq[Any](/*23.164*/disciplinaPeriodo/*23.181*/.getNome())),format.raw/*23.191*/("""</a><span>"""),_display_(Seq[Any](/*23.202*/disciplinaPeriodo/*23.219*/.getCreditos())),format.raw/*23.233*/(""" / """),_display_(Seq[Any](/*23.237*/disciplinaPeriodo/*23.254*/.getDificuldade())),format.raw/*23.271*/("""</span>
				    		<br>
				    	""")))})),format.raw/*25.11*/("""
				    """)))})),format.raw/*26.10*/("""
				</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*29.6*/if(periodo.getTotalDeCreditos() < 14)/*29.43*/{_display_(Seq[Any](format.raw/*29.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*31.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*32.21*/periodo/*32.28*/.getTotalDeCreditos())),format.raw/*32.49*/("""  /   """),_display_(Seq[Any](/*32.56*/periodo/*32.63*/.getTotalDeDificuldade())),format.raw/*32.87*/("""
				</div>
				<div id="editandoNote">Clique na disciplina para adicionar aqui ou mover de outro período para este.</div>
			</div><!-- Fim de um periodo -->
		""")))}/*36.5*/else/*36.10*/{_display_(Seq[Any](format.raw/*36.11*/("""
			<div id="periodoBox">
				<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*38.33*/periodo/*38.40*/.getNumero())),format.raw/*38.52*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*38.113*/periodo/*38.120*/.getNumero())),format.raw/*38.132*/("""º</b> Período</div></a><!-- Numero do periodo -->
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*41.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*41.60*/ {_display_(Seq[Any](format.raw/*41.62*/("""
				    	"""),_display_(Seq[Any](/*42.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*42.56*/ {_display_(Seq[Any](format.raw/*42.58*/("""
				    	   	<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*43.44*/disciplinaPeriodo/*43.61*/.getId())),format.raw/*43.69*/("""', '"""),_display_(Seq[Any](/*43.74*/numPeriodo)),format.raw/*43.84*/("""', '"""),_display_(Seq[Any](/*43.89*/periodo/*43.96*/.getNumero())),format.raw/*43.108*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*43.150*/disciplinaPeriodo/*43.167*/.getPreRequisitos)),format.raw/*43.184*/("""">"""),_display_(Seq[Any](/*43.187*/disciplinaPeriodo/*43.204*/.getNome())),format.raw/*43.214*/("""</a><span>"""),_display_(Seq[Any](/*43.225*/disciplinaPeriodo/*43.242*/.getCreditos())),format.raw/*43.256*/(""" / """),_display_(Seq[Any](/*43.260*/disciplinaPeriodo/*43.277*/.getDificuldade())),format.raw/*43.294*/("""</span>
				    		<br>
				    	""")))}/*45.12*/else/*45.17*/{_display_(Seq[Any](format.raw/*45.18*/("""
				    		<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*46.41*/disciplinaPeriodo/*46.58*/.getId())),format.raw/*46.66*/("""', '"""),_display_(Seq[Any](/*46.71*/numPeriodo)),format.raw/*46.81*/("""', '"""),_display_(Seq[Any](/*46.86*/periodo/*46.93*/.getNumero())),format.raw/*46.105*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*46.155*/disciplinaPeriodo/*46.172*/.getPreRequisitos)),format.raw/*46.189*/("""">"""),_display_(Seq[Any](/*46.192*/disciplinaPeriodo/*46.209*/.getNome())),format.raw/*46.219*/("""</a><span>"""),_display_(Seq[Any](/*46.230*/disciplinaPeriodo/*46.247*/.getCreditos())),format.raw/*46.261*/(""" / """),_display_(Seq[Any](/*46.265*/disciplinaPeriodo/*46.282*/.getDificuldade())),format.raw/*46.299*/("""</span>
				    		<br>
				    	""")))})),format.raw/*48.11*/("""
				    """)))})),format.raw/*49.10*/("""
			   	</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*52.6*/if(periodo.getTotalDeCreditos() < 14)/*52.43*/{_display_(Seq[Any](format.raw/*52.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*54.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*55.21*/periodo/*55.28*/.getTotalDeCreditos())),format.raw/*55.49*/("""  /   """),_display_(Seq[Any](/*55.56*/periodo/*55.63*/.getTotalDeDificuldade())),format.raw/*55.87*/("""
				</div>
			</div><!-- Fim de um periodo -->
		""")))})),format.raw/*58.4*/("""			
	""")))})),format.raw/*59.3*/("""
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*69.4*/for(disciplina <- naoAlocadas) yield /*69.34*/ {_display_(Seq[Any](format.raw/*69.36*/("""
			"""),_display_(Seq[Any](/*70.5*/if(disciplina.getPeriodoSugerido() == 2)/*70.45*/{_display_(Seq[Any](format.raw/*70.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*71.39*/disciplina/*71.49*/.getId())),format.raw/*71.57*/("""', '"""),_display_(Seq[Any](/*71.62*/numPeriodo)),format.raw/*71.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*71.114*/disciplina/*71.124*/.getPreRequisitos())),format.raw/*71.143*/("""">"""),_display_(Seq[Any](/*71.146*/disciplina/*71.156*/.getNome())),format.raw/*71.166*/("""</a>   <span>"""),_display_(Seq[Any](/*71.180*/disciplina/*71.190*/.getCreditos())),format.raw/*71.204*/("""  /  """),_display_(Seq[Any](/*71.210*/disciplina/*71.220*/.getDificuldade())),format.raw/*71.237*/("""</span>
				<br>
			""")))})),format.raw/*73.5*/("""
		""")))})),format.raw/*74.4*/("""
		<br>
		"""),_display_(Seq[Any](/*76.4*/for(disciplina <- naoAlocadas) yield /*76.34*/ {_display_(Seq[Any](format.raw/*76.36*/("""
			"""),_display_(Seq[Any](/*77.5*/if(disciplina.getPeriodoSugerido() == 3)/*77.45*/{_display_(Seq[Any](format.raw/*77.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*78.39*/disciplina/*78.49*/.getId())),format.raw/*78.57*/("""', '"""),_display_(Seq[Any](/*78.62*/numPeriodo)),format.raw/*78.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*78.114*/disciplina/*78.124*/.getPreRequisitos())),format.raw/*78.143*/("""">"""),_display_(Seq[Any](/*78.146*/disciplina/*78.156*/.getNome())),format.raw/*78.166*/("""</a>   <span>"""),_display_(Seq[Any](/*78.180*/disciplina/*78.190*/.getCreditos())),format.raw/*78.204*/("""  /  """),_display_(Seq[Any](/*78.210*/disciplina/*78.220*/.getDificuldade())),format.raw/*78.237*/("""</span>
				<br>
			""")))})),format.raw/*80.5*/("""
		""")))})),format.raw/*81.4*/("""
		<br>
		"""),_display_(Seq[Any](/*83.4*/for(disciplina <- naoAlocadas) yield /*83.34*/ {_display_(Seq[Any](format.raw/*83.36*/("""
			"""),_display_(Seq[Any](/*84.5*/if(disciplina.getPeriodoSugerido() == 4)/*84.45*/{_display_(Seq[Any](format.raw/*84.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*85.39*/disciplina/*85.49*/.getId())),format.raw/*85.57*/("""', '"""),_display_(Seq[Any](/*85.62*/numPeriodo)),format.raw/*85.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*85.114*/disciplina/*85.124*/.getPreRequisitos())),format.raw/*85.143*/("""">"""),_display_(Seq[Any](/*85.146*/disciplina/*85.156*/.getNome())),format.raw/*85.166*/("""</a>   <span>"""),_display_(Seq[Any](/*85.180*/disciplina/*85.190*/.getCreditos())),format.raw/*85.204*/("""  /  """),_display_(Seq[Any](/*85.210*/disciplina/*85.220*/.getDificuldade())),format.raw/*85.237*/("""</span>
				<br>
			""")))})),format.raw/*87.5*/("""
		""")))})),format.raw/*88.4*/("""
		<br>
		"""),_display_(Seq[Any](/*90.4*/for(disciplina <- naoAlocadas) yield /*90.34*/ {_display_(Seq[Any](format.raw/*90.36*/("""
			"""),_display_(Seq[Any](/*91.5*/if(disciplina.getPeriodoSugerido() == 5)/*91.45*/{_display_(Seq[Any](format.raw/*91.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*92.39*/disciplina/*92.49*/.getId())),format.raw/*92.57*/("""', '"""),_display_(Seq[Any](/*92.62*/numPeriodo)),format.raw/*92.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*92.114*/disciplina/*92.124*/.getPreRequisitos())),format.raw/*92.143*/("""">"""),_display_(Seq[Any](/*92.146*/disciplina/*92.156*/.getNome())),format.raw/*92.166*/("""</a>   <span>"""),_display_(Seq[Any](/*92.180*/disciplina/*92.190*/.getCreditos())),format.raw/*92.204*/("""  /  """),_display_(Seq[Any](/*92.210*/disciplina/*92.220*/.getDificuldade())),format.raw/*92.237*/("""</span>
				<br>
			""")))})),format.raw/*94.5*/("""
		""")))})),format.raw/*95.4*/("""
		<br>
		"""),_display_(Seq[Any](/*97.4*/for(disciplina <- naoAlocadas) yield /*97.34*/ {_display_(Seq[Any](format.raw/*97.36*/("""
			"""),_display_(Seq[Any](/*98.5*/if(disciplina.getPeriodoSugerido() == 6)/*98.45*/{_display_(Seq[Any](format.raw/*98.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*99.39*/disciplina/*99.49*/.getId())),format.raw/*99.57*/("""', '"""),_display_(Seq[Any](/*99.62*/numPeriodo)),format.raw/*99.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*99.114*/disciplina/*99.124*/.getPreRequisitos())),format.raw/*99.143*/("""">"""),_display_(Seq[Any](/*99.146*/disciplina/*99.156*/.getNome())),format.raw/*99.166*/("""</a>   <span>"""),_display_(Seq[Any](/*99.180*/disciplina/*99.190*/.getCreditos())),format.raw/*99.204*/("""  /  """),_display_(Seq[Any](/*99.210*/disciplina/*99.220*/.getDificuldade())),format.raw/*99.237*/("""</span>
				<br>
			""")))})),format.raw/*101.5*/("""
		""")))})),format.raw/*102.4*/("""
		<br>
		"""),_display_(Seq[Any](/*104.4*/for(disciplina <- naoAlocadas) yield /*104.34*/ {_display_(Seq[Any](format.raw/*104.36*/("""
			"""),_display_(Seq[Any](/*105.5*/if(disciplina.getPeriodoSugerido() == 7)/*105.45*/{_display_(Seq[Any](format.raw/*105.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*106.39*/disciplina/*106.49*/.getId())),format.raw/*106.57*/("""', '"""),_display_(Seq[Any](/*106.62*/numPeriodo)),format.raw/*106.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*106.114*/disciplina/*106.124*/.getPreRequisitos())),format.raw/*106.143*/("""">"""),_display_(Seq[Any](/*106.146*/disciplina/*106.156*/.getNome())),format.raw/*106.166*/("""</a>   <span>"""),_display_(Seq[Any](/*106.180*/disciplina/*106.190*/.getCreditos())),format.raw/*106.204*/("""  /  """),_display_(Seq[Any](/*106.210*/disciplina/*106.220*/.getDificuldade())),format.raw/*106.237*/("""</span>
				<br>
			""")))})),format.raw/*108.5*/("""
		""")))})),format.raw/*109.4*/("""
		<br>
		"""),_display_(Seq[Any](/*111.4*/for(disciplina <- naoAlocadas) yield /*111.34*/ {_display_(Seq[Any](format.raw/*111.36*/("""
			"""),_display_(Seq[Any](/*112.5*/if(disciplina.getPeriodoSugerido() == 8)/*112.45*/{_display_(Seq[Any](format.raw/*112.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*113.39*/disciplina/*113.49*/.getId())),format.raw/*113.57*/("""', '"""),_display_(Seq[Any](/*113.62*/numPeriodo)),format.raw/*113.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*113.114*/disciplina/*113.124*/.getPreRequisitos())),format.raw/*113.143*/("""">"""),_display_(Seq[Any](/*113.146*/disciplina/*113.156*/.getNome())),format.raw/*113.166*/("""</a>   <span>"""),_display_(Seq[Any](/*113.180*/disciplina/*113.190*/.getCreditos())),format.raw/*113.204*/("""  /  """),_display_(Seq[Any](/*113.210*/disciplina/*113.220*/.getDificuldade())),format.raw/*113.237*/("""</span>
				<br>
			""")))})),format.raw/*115.5*/("""
		""")))})),format.raw/*116.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*123.4*/for(disciplina <- naoAlocadas) yield /*123.34*/ {_display_(Seq[Any](format.raw/*123.36*/("""
				"""),_display_(Seq[Any](/*124.6*/if(disciplina.getPeriodoSugerido() == -1)/*124.47*/{_display_(Seq[Any](format.raw/*124.48*/("""
					<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*125.40*/disciplina/*125.50*/.getId())),format.raw/*125.58*/("""', '"""),_display_(Seq[Any](/*125.63*/numPeriodo)),format.raw/*125.73*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*125.115*/disciplina/*125.125*/.getPreRequisitos())),format.raw/*125.144*/("""">"""),_display_(Seq[Any](/*125.147*/disciplina/*125.157*/.getNome())),format.raw/*125.167*/("""</a>   <span>"""),_display_(Seq[Any](/*125.181*/disciplina/*125.191*/.getCreditos())),format.raw/*125.205*/("""  /  """),_display_(Seq[Any](/*125.211*/disciplina/*125.221*/.getDificuldade())),format.raw/*125.238*/("""</span>
					<br>
				""")))})),format.raw/*127.6*/("""
		""")))})),format.raw/*128.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*135.4*/for(disciplina <- naoAlocadas) yield /*135.34*/ {_display_(Seq[Any](format.raw/*135.36*/("""
			"""),_display_(Seq[Any](/*136.5*/if(disciplina.getPeriodoSugerido() == -2)/*136.46*/{_display_(Seq[Any](format.raw/*136.47*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*137.39*/disciplina/*137.49*/.getId())),format.raw/*137.57*/("""', '"""),_display_(Seq[Any](/*137.62*/numPeriodo)),format.raw/*137.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*137.114*/disciplina/*137.124*/.getPreRequisitos())),format.raw/*137.143*/("""">"""),_display_(Seq[Any](/*137.146*/disciplina/*137.156*/.getNome())),format.raw/*137.166*/("""</a>   <span>"""),_display_(Seq[Any](/*137.180*/disciplina/*137.190*/.getCreditos())),format.raw/*137.204*/("""  /  """),_display_(Seq[Any](/*137.210*/disciplina/*137.220*/.getDificuldade())),format.raw/*137.237*/("""</span>
				<br>
			""")))})),format.raw/*139.5*/("""
		""")))})),format.raw/*140.4*/("""
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
                    DATE: Sun Mar 02 15:44:35 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 6cd3d7af2709326b1d0a977bc432f9a22d26b880
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1284->233|1302->243|1344->264|1506->391|1546->415|1585->416|1625->421|1671->458|1710->459|1877->589|1894->596|1929->608|2189->832|2255->882|2295->884|2343->896|2397->941|2437->943|2514->984|2540->1001|2570->1009|2611->1014|2643->1024|2722->1066|2749->1083|2789->1100|2829->1103|2856->1120|2889->1130|2937->1141|2964->1158|3001->1172|3042->1176|3069->1193|3109->1210|3163->1246|3176->1251|3215->1252|3289->1290|3315->1307|3345->1315|3386->1320|3418->1330|3505->1380|3532->1397|3572->1414|3612->1417|3639->1434|3672->1444|3720->1455|3747->1472|3784->1486|3825->1490|3852->1507|3892->1524|3959->1559|4002->1570|4119->1652|4165->1689|4204->1690|4321->1776|4379->1798|4395->1805|4438->1826|4481->1833|4497->1840|4543->1864|4727->2031|4740->2036|4779->2037|4875->2097|4891->2104|4925->2116|5023->2177|5040->2184|5075->2196|5361->2446|5427->2496|5467->2498|5515->2510|5569->2555|5609->2557|5690->2602|5716->2619|5746->2627|5787->2632|5819->2642|5860->2647|5876->2654|5911->2666|5990->2708|6017->2725|6057->2742|6097->2745|6124->2762|6157->2772|6205->2783|6232->2800|6269->2814|6310->2818|6337->2835|6377->2852|6431->2888|6444->2893|6483->2894|6561->2936|6587->2953|6617->2961|6658->2966|6690->2976|6731->2981|6747->2988|6782->3000|6869->3050|6896->3067|6936->3084|6976->3087|7003->3104|7036->3114|7084->3125|7111->3142|7148->3156|7189->3160|7216->3177|7256->3194|7323->3229|7366->3240|7486->3325|7532->3362|7571->3363|7688->3449|7746->3471|7762->3478|7805->3499|7848->3506|7864->3513|7910->3537|7995->3591|8033->3598|8372->3902|8418->3932|8458->3934|8499->3940|8548->3980|8587->3981|8663->4021|8682->4031|8712->4039|8753->4044|8785->4054|8864->4096|8884->4106|8926->4125|8966->4128|8986->4138|9019->4148|9070->4162|9090->4172|9127->4186|9170->4192|9190->4202|9230->4219|9284->4242|9320->4247|9368->4260|9414->4290|9454->4292|9495->4298|9544->4338|9583->4339|9659->4379|9678->4389|9708->4397|9749->4402|9781->4412|9860->4454|9880->4464|9922->4483|9962->4486|9982->4496|10015->4506|10066->4520|10086->4530|10123->4544|10166->4550|10186->4560|10226->4577|10280->4600|10316->4605|10364->4618|10410->4648|10450->4650|10491->4656|10540->4696|10579->4697|10655->4737|10674->4747|10704->4755|10745->4760|10777->4770|10856->4812|10876->4822|10918->4841|10958->4844|10978->4854|11011->4864|11062->4878|11082->4888|11119->4902|11162->4908|11182->4918|11222->4935|11276->4958|11312->4963|11360->4976|11406->5006|11446->5008|11487->5014|11536->5054|11575->5055|11651->5095|11670->5105|11700->5113|11741->5118|11773->5128|11852->5170|11872->5180|11914->5199|11954->5202|11974->5212|12007->5222|12058->5236|12078->5246|12115->5260|12158->5266|12178->5276|12218->5293|12272->5316|12308->5321|12356->5334|12402->5364|12442->5366|12483->5372|12532->5412|12571->5413|12647->5453|12666->5463|12696->5471|12737->5476|12769->5486|12848->5528|12868->5538|12910->5557|12950->5560|12970->5570|13003->5580|13054->5594|13074->5604|13111->5618|13154->5624|13174->5634|13214->5651|13269->5674|13306->5679|13355->5692|13402->5722|13443->5724|13485->5730|13535->5770|13575->5771|13652->5811|13672->5821|13703->5829|13745->5834|13778->5844|13858->5886|13879->5896|13922->5915|13963->5918|13984->5928|14018->5938|14070->5952|14091->5962|14129->5976|14173->5982|14194->5992|14235->6009|14290->6032|14327->6037|14376->6050|14423->6080|14464->6082|14506->6088|14556->6128|14596->6129|14673->6169|14693->6179|14724->6187|14766->6192|14799->6202|14879->6244|14900->6254|14943->6273|14984->6276|15005->6286|15039->6296|15091->6310|15112->6320|15150->6334|15194->6340|15215->6350|15256->6367|15311->6390|15348->6395|15609->6620|15656->6650|15697->6652|15740->6659|15791->6700|15831->6701|15909->6742|15929->6752|15960->6760|16002->6765|16035->6775|16115->6817|16136->6827|16179->6846|16220->6849|16241->6859|16275->6869|16327->6883|16348->6893|16386->6907|16430->6913|16451->6923|16492->6940|16549->6965|16586->6970|16840->7188|16887->7218|16928->7220|16970->7226|17021->7267|17061->7268|17138->7308|17158->7318|17189->7326|17231->7331|17264->7341|17344->7383|17365->7393|17408->7412|17449->7415|17470->7425|17504->7435|17556->7449|17577->7459|17615->7473|17659->7479|17680->7489|17721->7506|17776->7529|17813->7534
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|36->8|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|53->25|54->26|57->29|57->29|57->29|59->31|60->32|60->32|60->32|60->32|60->32|60->32|64->36|64->36|64->36|66->38|66->38|66->38|66->38|66->38|66->38|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|76->48|77->49|80->52|80->52|80->52|82->54|83->55|83->55|83->55|83->55|83->55|83->55|86->58|87->59|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|101->73|102->74|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|108->80|109->81|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|115->87|116->88|118->90|118->90|118->90|119->91|119->91|119->91|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|122->94|123->95|125->97|125->97|125->97|126->98|126->98|126->98|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|129->101|130->102|132->104|132->104|132->104|133->105|133->105|133->105|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|136->108|137->109|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|151->123|151->123|151->123|152->124|152->124|152->124|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|155->127|156->128|163->135|163->135|163->135|164->136|164->136|164->136|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|167->139|168->140
                    -- GENERATED --
                */
            