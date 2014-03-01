
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
	<a onclick="novoPeriodo()"><div id="novoPeriodo">Novo Período</div></a>
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*12.3*/for(periodo <- periodos) yield /*12.27*/{_display_(Seq[Any](format.raw/*12.28*/("""
		<div id="periodoBox">
			"""),_display_(Seq[Any](/*14.5*/if(periodo.getNumero() == numPeriodo)/*14.42*/{_display_(Seq[Any](format.raw/*14.43*/("""
				<a onclick="sairEdicao()" title="Clique aqui para fechar edição"><div id="numPeriodo" class="editando"><b>"""),_display_(Seq[Any](/*15.112*/periodo/*15.119*/.getNumero())),format.raw/*15.131*/("""º</b> Período</div></a>
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
			""")))}/*28.6*/else/*28.11*/{_display_(Seq[Any](format.raw/*28.12*/("""
				<a onclick="editaPeriodo('"""),_display_(Seq[Any](/*29.32*/periodo/*29.39*/.getNumero())),format.raw/*29.51*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*29.112*/periodo/*29.119*/.getNumero())),format.raw/*29.131*/("""º</b> Período</div></a><!-- Numero do periodo -->
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*32.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*32.60*/ {_display_(Seq[Any](format.raw/*32.62*/("""
				    	"""),_display_(Seq[Any](/*33.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*33.56*/ {_display_(Seq[Any](format.raw/*33.58*/("""
				    	   	<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*34.44*/disciplinaPeriodo/*34.61*/.getId())),format.raw/*34.69*/("""', '"""),_display_(Seq[Any](/*34.74*/numPeriodo)),format.raw/*34.84*/("""', '"""),_display_(Seq[Any](/*34.89*/periodo/*34.96*/.getNumero())),format.raw/*34.108*/("""')" class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*34.150*/disciplinaPeriodo/*34.167*/.getPreRequisitos)),format.raw/*34.184*/("""">"""),_display_(Seq[Any](/*34.187*/disciplinaPeriodo/*34.204*/.getNome())),format.raw/*34.214*/("""</a><span>"""),_display_(Seq[Any](/*34.225*/disciplinaPeriodo/*34.242*/.getCreditos())),format.raw/*34.256*/(""" / """),_display_(Seq[Any](/*34.260*/disciplinaPeriodo/*34.277*/.getDificuldade())),format.raw/*34.294*/("""</span>
				    		<br>
				    	""")))}/*36.12*/else/*36.17*/{_display_(Seq[Any](format.raw/*36.18*/("""
				    		<a onclick="moverDisciplina('"""),_display_(Seq[Any](/*37.41*/disciplinaPeriodo/*37.58*/.getId())),format.raw/*37.66*/("""', '"""),_display_(Seq[Any](/*37.71*/numPeriodo)),format.raw/*37.81*/("""', '"""),_display_(Seq[Any](/*37.86*/periodo/*37.93*/.getNumero())),format.raw/*37.105*/("""')" class="cada1 discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*37.155*/disciplinaPeriodo/*37.172*/.getPreRequisitos)),format.raw/*37.189*/("""">"""),_display_(Seq[Any](/*37.192*/disciplinaPeriodo/*37.209*/.getNome())),format.raw/*37.219*/("""</a><span>"""),_display_(Seq[Any](/*37.230*/disciplinaPeriodo/*37.247*/.getCreditos())),format.raw/*37.261*/(""" / """),_display_(Seq[Any](/*37.265*/disciplinaPeriodo/*37.282*/.getDificuldade())),format.raw/*37.299*/("""</span>
				    		<br>
				    	""")))})),format.raw/*39.11*/("""
				    """)))})),format.raw/*40.10*/("""
			""")))})),format.raw/*41.5*/("""			
			</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*44.5*/if(periodo.getTotalDeCreditos() < 14)/*44.42*/{_display_(Seq[Any](format.raw/*44.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*46.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*47.20*/periodo/*47.27*/.getTotalDeCreditos())),format.raw/*47.48*/("""  /   """),_display_(Seq[Any](/*47.55*/periodo/*47.62*/.getTotalDeDificuldade())),format.raw/*47.86*/("""
			</div>
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*50.3*/("""
	
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*61.4*/for(disciplina <- naoAlocadas) yield /*61.34*/ {_display_(Seq[Any](format.raw/*61.36*/("""
			"""),_display_(Seq[Any](/*62.5*/if(disciplina.getPeriodoSugerido() == 2)/*62.45*/{_display_(Seq[Any](format.raw/*62.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*63.39*/disciplina/*63.49*/.getId())),format.raw/*63.57*/("""', '"""),_display_(Seq[Any](/*63.62*/numPeriodo)),format.raw/*63.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*63.114*/disciplina/*63.124*/.getPreRequisitos())),format.raw/*63.143*/("""">"""),_display_(Seq[Any](/*63.146*/disciplina/*63.156*/.getNome())),format.raw/*63.166*/("""</a>   <span>"""),_display_(Seq[Any](/*63.180*/disciplina/*63.190*/.getCreditos())),format.raw/*63.204*/("""  /  """),_display_(Seq[Any](/*63.210*/disciplina/*63.220*/.getDificuldade())),format.raw/*63.237*/("""</span>
				<br>
			""")))})),format.raw/*65.5*/("""
		""")))})),format.raw/*66.4*/("""
		<br>
		"""),_display_(Seq[Any](/*68.4*/for(disciplina <- naoAlocadas) yield /*68.34*/ {_display_(Seq[Any](format.raw/*68.36*/("""
			"""),_display_(Seq[Any](/*69.5*/if(disciplina.getPeriodoSugerido() == 3)/*69.45*/{_display_(Seq[Any](format.raw/*69.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*70.39*/disciplina/*70.49*/.getId())),format.raw/*70.57*/("""', '"""),_display_(Seq[Any](/*70.62*/numPeriodo)),format.raw/*70.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*70.114*/disciplina/*70.124*/.getPreRequisitos())),format.raw/*70.143*/("""">"""),_display_(Seq[Any](/*70.146*/disciplina/*70.156*/.getNome())),format.raw/*70.166*/("""</a>   <span>"""),_display_(Seq[Any](/*70.180*/disciplina/*70.190*/.getCreditos())),format.raw/*70.204*/("""  /  """),_display_(Seq[Any](/*70.210*/disciplina/*70.220*/.getDificuldade())),format.raw/*70.237*/("""</span>
				<br>
			""")))})),format.raw/*72.5*/("""
		""")))})),format.raw/*73.4*/("""
		<br>
		"""),_display_(Seq[Any](/*75.4*/for(disciplina <- naoAlocadas) yield /*75.34*/ {_display_(Seq[Any](format.raw/*75.36*/("""
			"""),_display_(Seq[Any](/*76.5*/if(disciplina.getPeriodoSugerido() == 4)/*76.45*/{_display_(Seq[Any](format.raw/*76.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*77.39*/disciplina/*77.49*/.getId())),format.raw/*77.57*/("""', '"""),_display_(Seq[Any](/*77.62*/numPeriodo)),format.raw/*77.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*77.114*/disciplina/*77.124*/.getPreRequisitos())),format.raw/*77.143*/("""">"""),_display_(Seq[Any](/*77.146*/disciplina/*77.156*/.getNome())),format.raw/*77.166*/("""</a>   <span>"""),_display_(Seq[Any](/*77.180*/disciplina/*77.190*/.getCreditos())),format.raw/*77.204*/("""  /  """),_display_(Seq[Any](/*77.210*/disciplina/*77.220*/.getDificuldade())),format.raw/*77.237*/("""</span>
				<br>
			""")))})),format.raw/*79.5*/("""
		""")))})),format.raw/*80.4*/("""
		<br>
		"""),_display_(Seq[Any](/*82.4*/for(disciplina <- naoAlocadas) yield /*82.34*/ {_display_(Seq[Any](format.raw/*82.36*/("""
			"""),_display_(Seq[Any](/*83.5*/if(disciplina.getPeriodoSugerido() == 5)/*83.45*/{_display_(Seq[Any](format.raw/*83.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*84.39*/disciplina/*84.49*/.getId())),format.raw/*84.57*/("""', '"""),_display_(Seq[Any](/*84.62*/numPeriodo)),format.raw/*84.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*84.114*/disciplina/*84.124*/.getPreRequisitos())),format.raw/*84.143*/("""">"""),_display_(Seq[Any](/*84.146*/disciplina/*84.156*/.getNome())),format.raw/*84.166*/("""</a>   <span>"""),_display_(Seq[Any](/*84.180*/disciplina/*84.190*/.getCreditos())),format.raw/*84.204*/("""  /  """),_display_(Seq[Any](/*84.210*/disciplina/*84.220*/.getDificuldade())),format.raw/*84.237*/("""</span>
				<br>
			""")))})),format.raw/*86.5*/("""
		""")))})),format.raw/*87.4*/("""
		<br>
		"""),_display_(Seq[Any](/*89.4*/for(disciplina <- naoAlocadas) yield /*89.34*/ {_display_(Seq[Any](format.raw/*89.36*/("""
			"""),_display_(Seq[Any](/*90.5*/if(disciplina.getPeriodoSugerido() == 6)/*90.45*/{_display_(Seq[Any](format.raw/*90.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*91.39*/disciplina/*91.49*/.getId())),format.raw/*91.57*/("""', '"""),_display_(Seq[Any](/*91.62*/numPeriodo)),format.raw/*91.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*91.114*/disciplina/*91.124*/.getPreRequisitos())),format.raw/*91.143*/("""">"""),_display_(Seq[Any](/*91.146*/disciplina/*91.156*/.getNome())),format.raw/*91.166*/("""</a>   <span>"""),_display_(Seq[Any](/*91.180*/disciplina/*91.190*/.getCreditos())),format.raw/*91.204*/("""  /  """),_display_(Seq[Any](/*91.210*/disciplina/*91.220*/.getDificuldade())),format.raw/*91.237*/("""</span>
				<br>
			""")))})),format.raw/*93.5*/("""
		""")))})),format.raw/*94.4*/("""
		<br>
		"""),_display_(Seq[Any](/*96.4*/for(disciplina <- naoAlocadas) yield /*96.34*/ {_display_(Seq[Any](format.raw/*96.36*/("""
			"""),_display_(Seq[Any](/*97.5*/if(disciplina.getPeriodoSugerido() == 7)/*97.45*/{_display_(Seq[Any](format.raw/*97.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*98.39*/disciplina/*98.49*/.getId())),format.raw/*98.57*/("""', '"""),_display_(Seq[Any](/*98.62*/numPeriodo)),format.raw/*98.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*98.114*/disciplina/*98.124*/.getPreRequisitos())),format.raw/*98.143*/("""">"""),_display_(Seq[Any](/*98.146*/disciplina/*98.156*/.getNome())),format.raw/*98.166*/("""</a>   <span>"""),_display_(Seq[Any](/*98.180*/disciplina/*98.190*/.getCreditos())),format.raw/*98.204*/("""  /  """),_display_(Seq[Any](/*98.210*/disciplina/*98.220*/.getDificuldade())),format.raw/*98.237*/("""</span>
				<br>
			""")))})),format.raw/*100.5*/("""
		""")))})),format.raw/*101.4*/("""
		<br>
		"""),_display_(Seq[Any](/*103.4*/for(disciplina <- naoAlocadas) yield /*103.34*/ {_display_(Seq[Any](format.raw/*103.36*/("""
			"""),_display_(Seq[Any](/*104.5*/if(disciplina.getPeriodoSugerido() == 8)/*104.45*/{_display_(Seq[Any](format.raw/*104.46*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*105.39*/disciplina/*105.49*/.getId())),format.raw/*105.57*/("""', '"""),_display_(Seq[Any](/*105.62*/numPeriodo)),format.raw/*105.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*105.114*/disciplina/*105.124*/.getPreRequisitos())),format.raw/*105.143*/("""">"""),_display_(Seq[Any](/*105.146*/disciplina/*105.156*/.getNome())),format.raw/*105.166*/("""</a>   <span>"""),_display_(Seq[Any](/*105.180*/disciplina/*105.190*/.getCreditos())),format.raw/*105.204*/("""  /  """),_display_(Seq[Any](/*105.210*/disciplina/*105.220*/.getDificuldade())),format.raw/*105.237*/("""</span>
				<br>
			""")))})),format.raw/*107.5*/("""
		""")))})),format.raw/*108.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*115.4*/for(disciplina <- naoAlocadas) yield /*115.34*/ {_display_(Seq[Any](format.raw/*115.36*/("""
				"""),_display_(Seq[Any](/*116.6*/if(disciplina.getPeriodoSugerido() == -1)/*116.47*/{_display_(Seq[Any](format.raw/*116.48*/("""
					<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*117.40*/disciplina/*117.50*/.getId())),format.raw/*117.58*/("""', '"""),_display_(Seq[Any](/*117.63*/numPeriodo)),format.raw/*117.73*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*117.115*/disciplina/*117.125*/.getPreRequisitos())),format.raw/*117.144*/("""">"""),_display_(Seq[Any](/*117.147*/disciplina/*117.157*/.getNome())),format.raw/*117.167*/("""</a>   <span>"""),_display_(Seq[Any](/*117.181*/disciplina/*117.191*/.getCreditos())),format.raw/*117.205*/("""  /  """),_display_(Seq[Any](/*117.211*/disciplina/*117.221*/.getDificuldade())),format.raw/*117.238*/("""</span>
					<br>
				""")))})),format.raw/*119.6*/("""
		""")))})),format.raw/*120.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*127.4*/for(disciplina <- naoAlocadas) yield /*127.34*/ {_display_(Seq[Any](format.raw/*127.36*/("""
			"""),_display_(Seq[Any](/*128.5*/if(disciplina.getPeriodoSugerido() == -2)/*128.46*/{_display_(Seq[Any](format.raw/*128.47*/("""
				<a onclick="adicionarDisciplina('"""),_display_(Seq[Any](/*129.39*/disciplina/*129.49*/.getId())),format.raw/*129.57*/("""', '"""),_display_(Seq[Any](/*129.62*/numPeriodo)),format.raw/*129.72*/("""')" class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*129.114*/disciplina/*129.124*/.getPreRequisitos())),format.raw/*129.143*/("""">"""),_display_(Seq[Any](/*129.146*/disciplina/*129.156*/.getNome())),format.raw/*129.166*/("""</a>   <span>"""),_display_(Seq[Any](/*129.180*/disciplina/*129.190*/.getCreditos())),format.raw/*129.204*/("""  /  """),_display_(Seq[Any](/*129.210*/disciplina/*129.220*/.getDificuldade())),format.raw/*129.237*/("""</span>
				<br>
			""")))})),format.raw/*131.5*/("""
		""")))})),format.raw/*132.4*/("""
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
                    DATE: Sat Mar 01 15:07:43 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 24c1985f47f678f5f899d59070f293cc416e5b46
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1406->355|1446->379|1485->380|1551->411|1597->448|1636->449|1786->562|1803->569|1838->581|2098->805|2164->855|2204->857|2252->869|2306->914|2346->916|2423->957|2449->974|2479->982|2520->987|2552->997|2631->1039|2658->1056|2698->1073|2738->1076|2765->1093|2798->1103|2846->1114|2873->1131|2910->1145|2951->1149|2978->1166|3018->1183|3072->1219|3085->1224|3124->1225|3198->1263|3224->1280|3254->1288|3295->1293|3327->1303|3414->1353|3441->1370|3481->1387|3521->1390|3548->1407|3581->1417|3629->1428|3656->1445|3693->1459|3734->1463|3761->1480|3801->1497|3868->1532|3911->1543|3947->1562|3960->1567|3999->1568|4068->1601|4084->1608|4118->1620|4216->1681|4233->1688|4268->1700|4554->1950|4620->2000|4660->2002|4708->2014|4762->2059|4802->2061|4883->2106|4909->2123|4939->2131|4980->2136|5012->2146|5053->2151|5069->2158|5104->2170|5183->2212|5210->2229|5250->2246|5290->2249|5317->2266|5350->2276|5398->2287|5425->2304|5462->2318|5503->2322|5530->2339|5570->2356|5624->2392|5637->2397|5676->2398|5754->2440|5780->2457|5810->2465|5851->2470|5883->2480|5924->2485|5940->2492|5975->2504|6062->2554|6089->2571|6129->2588|6169->2591|6196->2608|6229->2618|6277->2629|6304->2646|6341->2660|6382->2664|6409->2681|6449->2698|6516->2733|6559->2744|6596->2750|6713->2832|6759->2869|6798->2870|6913->2954|6970->2975|6986->2982|7029->3003|7072->3010|7088->3017|7134->3041|7216->3092|7558->3399|7604->3429|7644->3431|7685->3437|7734->3477|7773->3478|7849->3518|7868->3528|7898->3536|7939->3541|7971->3551|8050->3593|8070->3603|8112->3622|8152->3625|8172->3635|8205->3645|8256->3659|8276->3669|8313->3683|8356->3689|8376->3699|8416->3716|8470->3739|8506->3744|8554->3757|8600->3787|8640->3789|8681->3795|8730->3835|8769->3836|8845->3876|8864->3886|8894->3894|8935->3899|8967->3909|9046->3951|9066->3961|9108->3980|9148->3983|9168->3993|9201->4003|9252->4017|9272->4027|9309->4041|9352->4047|9372->4057|9412->4074|9466->4097|9502->4102|9550->4115|9596->4145|9636->4147|9677->4153|9726->4193|9765->4194|9841->4234|9860->4244|9890->4252|9931->4257|9963->4267|10042->4309|10062->4319|10104->4338|10144->4341|10164->4351|10197->4361|10248->4375|10268->4385|10305->4399|10348->4405|10368->4415|10408->4432|10462->4455|10498->4460|10546->4473|10592->4503|10632->4505|10673->4511|10722->4551|10761->4552|10837->4592|10856->4602|10886->4610|10927->4615|10959->4625|11038->4667|11058->4677|11100->4696|11140->4699|11160->4709|11193->4719|11244->4733|11264->4743|11301->4757|11344->4763|11364->4773|11404->4790|11458->4813|11494->4818|11542->4831|11588->4861|11628->4863|11669->4869|11718->4909|11757->4910|11833->4950|11852->4960|11882->4968|11923->4973|11955->4983|12034->5025|12054->5035|12096->5054|12136->5057|12156->5067|12189->5077|12240->5091|12260->5101|12297->5115|12340->5121|12360->5131|12400->5148|12454->5171|12490->5176|12538->5189|12584->5219|12624->5221|12665->5227|12714->5267|12753->5268|12829->5308|12848->5318|12878->5326|12919->5331|12951->5341|13030->5383|13050->5393|13092->5412|13132->5415|13152->5425|13185->5435|13236->5449|13256->5459|13293->5473|13336->5479|13356->5489|13396->5506|13451->5529|13488->5534|13537->5547|13584->5577|13625->5579|13667->5585|13717->5625|13757->5626|13834->5666|13854->5676|13885->5684|13927->5689|13960->5699|14040->5741|14061->5751|14104->5770|14145->5773|14166->5783|14200->5793|14252->5807|14273->5817|14311->5831|14355->5837|14376->5847|14417->5864|14472->5887|14509->5892|14770->6117|14817->6147|14858->6149|14901->6156|14952->6197|14992->6198|15070->6239|15090->6249|15121->6257|15163->6262|15196->6272|15276->6314|15297->6324|15340->6343|15381->6346|15402->6356|15436->6366|15488->6380|15509->6390|15547->6404|15591->6410|15612->6420|15653->6437|15710->6462|15747->6467|16001->6685|16048->6715|16089->6717|16131->6723|16182->6764|16222->6765|16299->6805|16319->6815|16350->6823|16392->6828|16425->6838|16505->6880|16526->6890|16569->6909|16610->6912|16631->6922|16665->6932|16717->6946|16738->6956|16776->6970|16820->6976|16841->6986|16882->7003|16937->7026|16974->7031
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|53->25|54->26|56->28|56->28|56->28|57->29|57->29|57->29|57->29|57->29|57->29|60->32|60->32|60->32|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|62->34|64->36|64->36|64->36|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|65->37|67->39|68->40|69->41|72->44|72->44|72->44|74->46|75->47|75->47|75->47|75->47|75->47|75->47|78->50|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|93->65|94->66|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|100->72|101->73|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|107->79|108->80|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|114->86|115->87|117->89|117->89|117->89|118->90|118->90|118->90|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|119->91|121->93|122->94|124->96|124->96|124->96|125->97|125->97|125->97|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|126->98|128->100|129->101|131->103|131->103|131->103|132->104|132->104|132->104|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|135->107|136->108|143->115|143->115|143->115|144->116|144->116|144->116|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|147->119|148->120|155->127|155->127|155->127|156->128|156->128|156->128|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|157->129|159->131|160->132
                    -- GENERATED --
                */
            