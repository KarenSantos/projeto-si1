
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
                    DATE: Sun Mar 02 14:47:57 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: a830faf875ebe2fda35d4ef9b1bc621d0f0e6ee0
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1406->355|1446->379|1485->380|1525->385|1571->422|1610->423|1777->553|1794->560|1829->572|2089->796|2155->846|2195->848|2243->860|2297->905|2337->907|2414->948|2440->965|2470->973|2511->978|2543->988|2622->1030|2649->1047|2689->1064|2729->1067|2756->1084|2789->1094|2837->1105|2864->1122|2901->1136|2942->1140|2969->1157|3009->1174|3063->1210|3076->1215|3115->1216|3189->1254|3215->1271|3245->1279|3286->1284|3318->1294|3405->1344|3432->1361|3472->1378|3512->1381|3539->1398|3572->1408|3620->1419|3647->1436|3684->1450|3725->1454|3752->1471|3792->1488|3859->1523|3902->1534|4019->1616|4065->1653|4104->1654|4221->1740|4279->1762|4295->1769|4338->1790|4381->1797|4397->1804|4443->1828|4627->1995|4640->2000|4679->2001|4775->2061|4791->2068|4825->2080|4923->2141|4940->2148|4975->2160|5261->2410|5327->2460|5367->2462|5415->2474|5469->2519|5509->2521|5590->2566|5616->2583|5646->2591|5687->2596|5719->2606|5760->2611|5776->2618|5811->2630|5890->2672|5917->2689|5957->2706|5997->2709|6024->2726|6057->2736|6105->2747|6132->2764|6169->2778|6210->2782|6237->2799|6277->2816|6331->2852|6344->2857|6383->2858|6461->2900|6487->2917|6517->2925|6558->2930|6590->2940|6631->2945|6647->2952|6682->2964|6769->3014|6796->3031|6836->3048|6876->3051|6903->3068|6936->3078|6984->3089|7011->3106|7048->3120|7089->3124|7116->3141|7156->3158|7223->3193|7266->3204|7386->3289|7432->3326|7471->3327|7588->3413|7646->3435|7662->3442|7705->3463|7748->3470|7764->3477|7810->3501|7895->3555|7933->3562|8272->3866|8318->3896|8358->3898|8399->3904|8448->3944|8487->3945|8563->3985|8582->3995|8612->4003|8653->4008|8685->4018|8764->4060|8784->4070|8826->4089|8866->4092|8886->4102|8919->4112|8970->4126|8990->4136|9027->4150|9070->4156|9090->4166|9130->4183|9184->4206|9220->4211|9268->4224|9314->4254|9354->4256|9395->4262|9444->4302|9483->4303|9559->4343|9578->4353|9608->4361|9649->4366|9681->4376|9760->4418|9780->4428|9822->4447|9862->4450|9882->4460|9915->4470|9966->4484|9986->4494|10023->4508|10066->4514|10086->4524|10126->4541|10180->4564|10216->4569|10264->4582|10310->4612|10350->4614|10391->4620|10440->4660|10479->4661|10555->4701|10574->4711|10604->4719|10645->4724|10677->4734|10756->4776|10776->4786|10818->4805|10858->4808|10878->4818|10911->4828|10962->4842|10982->4852|11019->4866|11062->4872|11082->4882|11122->4899|11176->4922|11212->4927|11260->4940|11306->4970|11346->4972|11387->4978|11436->5018|11475->5019|11551->5059|11570->5069|11600->5077|11641->5082|11673->5092|11752->5134|11772->5144|11814->5163|11854->5166|11874->5176|11907->5186|11958->5200|11978->5210|12015->5224|12058->5230|12078->5240|12118->5257|12172->5280|12208->5285|12256->5298|12302->5328|12342->5330|12383->5336|12432->5376|12471->5377|12547->5417|12566->5427|12596->5435|12637->5440|12669->5450|12748->5492|12768->5502|12810->5521|12850->5524|12870->5534|12903->5544|12954->5558|12974->5568|13011->5582|13054->5588|13074->5598|13114->5615|13169->5638|13206->5643|13255->5656|13302->5686|13343->5688|13385->5694|13435->5734|13475->5735|13552->5775|13572->5785|13603->5793|13645->5798|13678->5808|13758->5850|13779->5860|13822->5879|13863->5882|13884->5892|13918->5902|13970->5916|13991->5926|14029->5940|14073->5946|14094->5956|14135->5973|14190->5996|14227->6001|14276->6014|14323->6044|14364->6046|14406->6052|14456->6092|14496->6093|14573->6133|14593->6143|14624->6151|14666->6156|14699->6166|14779->6208|14800->6218|14843->6237|14884->6240|14905->6250|14939->6260|14991->6274|15012->6284|15050->6298|15094->6304|15115->6314|15156->6331|15211->6354|15248->6359|15509->6584|15556->6614|15597->6616|15640->6623|15691->6664|15731->6665|15809->6706|15829->6716|15860->6724|15902->6729|15935->6739|16015->6781|16036->6791|16079->6810|16120->6813|16141->6823|16175->6833|16227->6847|16248->6857|16286->6871|16330->6877|16351->6887|16392->6904|16449->6929|16486->6934|16740->7152|16787->7182|16828->7184|16870->7190|16921->7231|16961->7232|17038->7272|17058->7282|17089->7290|17131->7295|17164->7305|17244->7347|17265->7357|17308->7376|17349->7379|17370->7389|17404->7399|17456->7413|17477->7423|17515->7437|17559->7443|17580->7453|17621->7470|17676->7493|17713->7498
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|53->25|54->26|57->29|57->29|57->29|59->31|60->32|60->32|60->32|60->32|60->32|60->32|64->36|64->36|64->36|66->38|66->38|66->38|66->38|66->38|66->38|69->41|69->41|69->41|70->42|70->42|70->42|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|71->43|73->45|73->45|73->45|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|74->46|76->48|77->49|80->52|80->52|80->52|82->54|83->55|83->55|83->55|83->55|83->55|83->55|86->58|87->59|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|99->71|101->73|102->74|104->76|104->76|104->76|105->77|105->77|105->77|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|106->78|108->80|109->81|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|113->85|115->87|116->88|118->90|118->90|118->90|119->91|119->91|119->91|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|120->92|122->94|123->95|125->97|125->97|125->97|126->98|126->98|126->98|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|127->99|129->101|130->102|132->104|132->104|132->104|133->105|133->105|133->105|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|134->106|136->108|137->109|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|151->123|151->123|151->123|152->124|152->124|152->124|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|153->125|155->127|156->128|163->135|163->135|163->135|164->136|164->136|164->136|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|165->137|167->139|168->140
                    -- GENERATED --
                */
            