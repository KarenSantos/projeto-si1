
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

<div id="col1"><h2 style="border-bottom: none">Períodos</h2><!-- coluna de periodos -->

	<div class="disciplinasPeriodo"><!-- Começo de um periodo -->
	
		"""),_display_(Seq[Any](/*11.4*/for(periodo <- periodos) yield /*11.28*/{_display_(Seq[Any](format.raw/*11.29*/("""
			"""),_display_(Seq[Any](/*12.5*/if(periodo.getNumero() == numPeriodo && periodo.getNumero != 1)/*12.68*/{_display_(Seq[Any](format.raw/*12.69*/("""
				<div class="numPriodo">"""),_display_(Seq[Any](/*13.29*/periodo/*13.36*/.getNumero())),format.raw/*13.48*/("""º Período<span><a class="addDiscPeriodo" onclick="deletaPeriodo('"""),_display_(Seq[Any](/*13.114*/numPeriodo)),format.raw/*13.124*/("""', '"""),_display_(Seq[Any](/*13.129*/periodo/*13.136*/.getTotalDeDisciplinas())),format.raw/*13.160*/("""')">Deletar</a></span></div><!-- Numero do periodo -->
			""")))}/*14.6*/else/*14.11*/{_display_(Seq[Any](format.raw/*14.12*/("""
				<div class="numPriodo">"""),_display_(Seq[Any](/*15.29*/periodo/*15.36*/.getNumero())),format.raw/*15.48*/("""º Período</div><!-- Numero do periodo -->
			""")))})),format.raw/*16.5*/("""
			<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*19.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*19.60*/ {_display_(Seq[Any](format.raw/*19.62*/("""
				    	"""),_display_(Seq[Any](/*20.11*/if(disciplinaPeriodo.getPeriodoSugerido() != 1 && periodo.getNumero() == numPeriodo)/*20.95*/{_display_(Seq[Any](format.raw/*20.96*/("""
						    <a class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*21.52*/disciplinaPeriodo/*21.69*/.getPreRequisitos)),format.raw/*21.86*/("""">"""),_display_(Seq[Any](/*21.89*/disciplinaPeriodo/*21.106*/.getNome())),format.raw/*21.116*/(""" </a>  <span>"""),_display_(Seq[Any](/*21.130*/disciplinaPeriodo/*21.147*/.getCreditos())),format.raw/*21.161*/("""  /  """),_display_(Seq[Any](/*21.167*/disciplinaPeriodo/*21.184*/.getDificuldade())),format.raw/*21.201*/("""
						    <a class="addDiscPeriodo" onclick="rmDisc('"""),_display_(Seq[Any](/*22.55*/planejador/*22.65*/.ehPreRequisito(disciplinaPeriodo, numPeriodo))),format.raw/*22.111*/("""', '"""),_display_(Seq[Any](/*22.116*/disciplinaPeriodo/*22.133*/.getId())),format.raw/*22.141*/("""', '"""),_display_(Seq[Any](/*22.146*/numPeriodo)),format.raw/*22.156*/("""')">Rm</a></span>
						    <br>
				    	""")))}/*24.12*/else/*24.17*/{_display_(Seq[Any](format.raw/*24.18*/("""
						    <a class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*25.52*/disciplinaPeriodo/*25.69*/.getPreRequisitos)),format.raw/*25.86*/("""">"""),_display_(Seq[Any](/*25.89*/disciplinaPeriodo/*25.106*/.getNome())),format.raw/*25.116*/(""" </a>  <span>"""),_display_(Seq[Any](/*25.130*/disciplinaPeriodo/*25.147*/.getCreditos())),format.raw/*25.161*/(""" / """),_display_(Seq[Any](/*25.165*/disciplinaPeriodo/*25.182*/.getDificuldade())),format.raw/*25.199*/("""</span><br>
				    	""")))})),format.raw/*26.11*/("""
					""")))})),format.raw/*27.7*/("""
				</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*30.5*/if(periodo.getTotalDeCreditos() < 14)/*30.42*/{_display_(Seq[Any](format.raw/*30.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*32.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*33.20*/periodo/*33.27*/.getTotalDeCreditos())),format.raw/*33.48*/("""  /   """),_display_(Seq[Any](/*33.55*/periodo/*33.62*/.getTotalDeDificuldade())),format.raw/*33.86*/("""
			</div>
			"""),_display_(Seq[Any](/*35.5*/if(periodo.getNumero() == numPeriodo)/*35.42*/ {_display_(Seq[Any](format.raw/*35.44*/("""
				<center id="edd">Clique em Add para adicionar e Rm para remover<a id="closeEdit"href="../../periodos">X</a></center>
			""")))})),format.raw/*37.5*/("""
			
			"""),_display_(Seq[Any](/*39.5*/if(periodo.getNumero() != numPeriodo)/*39.42*/ {_display_(Seq[Any](format.raw/*39.44*/("""
				"""),_display_(Seq[Any](/*40.6*/form(routes.Application.editar(periodo.getNumero()))/*40.58*/ {_display_(Seq[Any](format.raw/*40.60*/("""
					<input class="addDisc" type="submit" value="Editar período">
				""")))})),format.raw/*42.6*/("""
			""")))})),format.raw/*43.5*/("""
			
	    """)))})),format.raw/*45.7*/("""
	   
	</div><!-- Fim de um periodo -->
	
	<div id="addPeriodo">
		 """),_display_(Seq[Any](/*50.5*/form(routes.Application.novoPeriodo())/*50.43*/ {_display_(Seq[Any](format.raw/*50.45*/("""
              <input class="bAdd" type="submit" value="+ Novo Periodo">
         """)))})),format.raw/*52.11*/(""" 
	</div><!-- div para criar novo periodo -->
</div>


<div id="col2"><h2>Disciplinas Obrigatórias</h2><!-- coluna de disciplinas -->
	
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	<div class="disc2">
		"""),_display_(Seq[Any](/*61.4*/for(disciplina <- naoAlocadas) yield /*61.34*/ {_display_(Seq[Any](format.raw/*61.36*/("""
			"""),_display_(Seq[Any](/*62.5*/if(disciplina.getPeriodoSugerido() == 2)/*62.45*/{_display_(Seq[Any](format.raw/*62.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*63.46*/disciplina/*63.56*/.getPreRequisitos())),format.raw/*63.75*/("""">"""),_display_(Seq[Any](/*63.78*/disciplina/*63.88*/.getNome())),format.raw/*63.98*/("""</a>   
				<span>"""),_display_(Seq[Any](/*64.12*/disciplina/*64.22*/.getCreditos())),format.raw/*64.36*/("""  /  """),_display_(Seq[Any](/*64.42*/disciplina/*64.52*/.getDificuldade())),format.raw/*64.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*64.115*/disciplina/*64.125*/.getId())),format.raw/*64.133*/("""', '"""),_display_(Seq[Any](/*64.138*/numPeriodo)),format.raw/*64.148*/("""', '"""),_display_(Seq[Any](/*64.153*/planejador/*64.163*/.temPreRequisito(disciplina))),format.raw/*64.191*/("""')">Add</a></span> 
				<br>
			""")))})),format.raw/*66.5*/("""
		""")))})),format.raw/*67.4*/("""
		<br>
		"""),_display_(Seq[Any](/*69.4*/for(disciplina <- naoAlocadas) yield /*69.34*/ {_display_(Seq[Any](format.raw/*69.36*/("""
			"""),_display_(Seq[Any](/*70.5*/if(disciplina.getPeriodoSugerido() == 3)/*70.45*/{_display_(Seq[Any](format.raw/*70.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*71.46*/disciplina/*71.56*/.getPreRequisitos())),format.raw/*71.75*/("""">"""),_display_(Seq[Any](/*71.78*/disciplina/*71.88*/.getNome())),format.raw/*71.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*72.12*/disciplina/*72.22*/.getCreditos())),format.raw/*72.36*/("""  /  """),_display_(Seq[Any](/*72.42*/disciplina/*72.52*/.getDificuldade())),format.raw/*72.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*72.115*/disciplina/*72.125*/.getId())),format.raw/*72.133*/("""', '"""),_display_(Seq[Any](/*72.138*/numPeriodo)),format.raw/*72.148*/("""', '"""),_display_(Seq[Any](/*72.153*/planejador/*72.163*/.temPreRequisito(disciplina))),format.raw/*72.191*/("""')">Add</a></span> 
				<br>
			""")))})),format.raw/*74.5*/("""
		""")))})),format.raw/*75.4*/("""
		<br>
		"""),_display_(Seq[Any](/*77.4*/for(disciplina <- naoAlocadas) yield /*77.34*/ {_display_(Seq[Any](format.raw/*77.36*/("""
			"""),_display_(Seq[Any](/*78.5*/if(disciplina.getPeriodoSugerido() == 4)/*78.45*/{_display_(Seq[Any](format.raw/*78.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*79.46*/disciplina/*79.56*/.getPreRequisitos())),format.raw/*79.75*/("""">"""),_display_(Seq[Any](/*79.78*/disciplina/*79.88*/.getNome())),format.raw/*79.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*80.12*/disciplina/*80.22*/.getCreditos())),format.raw/*80.36*/("""  /  """),_display_(Seq[Any](/*80.42*/disciplina/*80.52*/.getDificuldade())),format.raw/*80.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*80.115*/disciplina/*80.125*/.getId())),format.raw/*80.133*/("""', '"""),_display_(Seq[Any](/*80.138*/numPeriodo)),format.raw/*80.148*/("""', '"""),_display_(Seq[Any](/*80.153*/planejador/*80.163*/.temPreRequisito(disciplina))),format.raw/*80.191*/("""')">Add</a></span>
				<br>
			""")))})),format.raw/*82.5*/("""
		""")))})),format.raw/*83.4*/("""
		<br>
		"""),_display_(Seq[Any](/*85.4*/for(disciplina <- naoAlocadas) yield /*85.34*/ {_display_(Seq[Any](format.raw/*85.36*/("""
			"""),_display_(Seq[Any](/*86.5*/if(disciplina.getPeriodoSugerido() == 5)/*86.45*/{_display_(Seq[Any](format.raw/*86.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*87.46*/disciplina/*87.56*/.getPreRequisitos())),format.raw/*87.75*/("""">"""),_display_(Seq[Any](/*87.78*/disciplina/*87.88*/.getNome())),format.raw/*87.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*88.12*/disciplina/*88.22*/.getCreditos())),format.raw/*88.36*/("""  /  """),_display_(Seq[Any](/*88.42*/disciplina/*88.52*/.getDificuldade())),format.raw/*88.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*88.115*/disciplina/*88.125*/.getId())),format.raw/*88.133*/("""', '"""),_display_(Seq[Any](/*88.138*/numPeriodo)),format.raw/*88.148*/("""', '"""),_display_(Seq[Any](/*88.153*/planejador/*88.163*/.temPreRequisito(disciplina))),format.raw/*88.191*/("""')">Add</a></span>
				<br>
			""")))})),format.raw/*90.5*/("""
		""")))})),format.raw/*91.4*/("""
		<br>
		"""),_display_(Seq[Any](/*93.4*/for(disciplina <- naoAlocadas) yield /*93.34*/ {_display_(Seq[Any](format.raw/*93.36*/("""
			"""),_display_(Seq[Any](/*94.5*/if(disciplina.getPeriodoSugerido() == 6)/*94.45*/{_display_(Seq[Any](format.raw/*94.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*95.46*/disciplina/*95.56*/.getPreRequisitos())),format.raw/*95.75*/("""">"""),_display_(Seq[Any](/*95.78*/disciplina/*95.88*/.getNome())),format.raw/*95.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*96.12*/disciplina/*96.22*/.getCreditos())),format.raw/*96.36*/("""  /  """),_display_(Seq[Any](/*96.42*/disciplina/*96.52*/.getDificuldade())),format.raw/*96.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*96.115*/disciplina/*96.125*/.getId())),format.raw/*96.133*/("""', '"""),_display_(Seq[Any](/*96.138*/numPeriodo)),format.raw/*96.148*/("""', '"""),_display_(Seq[Any](/*96.153*/planejador/*96.163*/.temPreRequisito(disciplina))),format.raw/*96.191*/("""')">Add</a></span>
				<br>
			""")))})),format.raw/*98.5*/("""
		""")))})),format.raw/*99.4*/("""
		<br>
		"""),_display_(Seq[Any](/*101.4*/for(disciplina <- naoAlocadas) yield /*101.34*/ {_display_(Seq[Any](format.raw/*101.36*/("""
			"""),_display_(Seq[Any](/*102.5*/if(disciplina.getPeriodoSugerido() == 7)/*102.45*/{_display_(Seq[Any](format.raw/*102.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*103.46*/disciplina/*103.56*/.getPreRequisitos())),format.raw/*103.75*/("""">"""),_display_(Seq[Any](/*103.78*/disciplina/*103.88*/.getNome())),format.raw/*103.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*104.12*/disciplina/*104.22*/.getCreditos())),format.raw/*104.36*/("""  /  """),_display_(Seq[Any](/*104.42*/disciplina/*104.52*/.getDificuldade())),format.raw/*104.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*104.115*/disciplina/*104.125*/.getId())),format.raw/*104.133*/("""', '"""),_display_(Seq[Any](/*104.138*/numPeriodo)),format.raw/*104.148*/("""', '"""),_display_(Seq[Any](/*104.153*/planejador/*104.163*/.temPreRequisito(disciplina))),format.raw/*104.191*/("""')">Add</a></span>
				<br>
			""")))})),format.raw/*106.5*/("""
		""")))})),format.raw/*107.4*/("""
		<br>
		"""),_display_(Seq[Any](/*109.4*/for(disciplina <- naoAlocadas) yield /*109.34*/ {_display_(Seq[Any](format.raw/*109.36*/("""
			"""),_display_(Seq[Any](/*110.5*/if(disciplina.getPeriodoSugerido() == 8)/*110.45*/{_display_(Seq[Any](format.raw/*110.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*111.46*/disciplina/*111.56*/.getPreRequisitos())),format.raw/*111.75*/("""">"""),_display_(Seq[Any](/*111.78*/disciplina/*111.88*/.getNome())),format.raw/*111.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*112.12*/disciplina/*112.22*/.getCreditos())),format.raw/*112.36*/("""  /  """),_display_(Seq[Any](/*112.42*/disciplina/*112.52*/.getDificuldade())),format.raw/*112.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*112.115*/disciplina/*112.125*/.getId())),format.raw/*112.133*/("""', '"""),_display_(Seq[Any](/*112.138*/numPeriodo)),format.raw/*112.148*/("""', '"""),_display_(Seq[Any](/*112.153*/planejador/*112.163*/.temPreRequisito(disciplina))),format.raw/*112.191*/("""')">Add</a></span>
				<br>
			""")))})),format.raw/*114.5*/("""
		""")))})),format.raw/*115.4*/("""
		<br>

	</div>
</div>
<div id="col3"><h2>Disciplinas Optativas</h2><!-- coluna de disciplinas optativas -->
	<div id="header">Outros cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	<div class="disc2">
		"""),_display_(Seq[Any](/*124.4*/for(disciplina <- naoAlocadas) yield /*124.34*/ {_display_(Seq[Any](format.raw/*124.36*/("""
			"""),_display_(Seq[Any](/*125.5*/if(disciplina.getPeriodoSugerido() == -1)/*125.46*/{_display_(Seq[Any](format.raw/*125.47*/("""
				<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*126.46*/disciplina/*126.56*/.getPreRequisitos())),format.raw/*126.75*/("""">"""),_display_(Seq[Any](/*126.78*/disciplina/*126.88*/.getNome())),format.raw/*126.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*127.12*/disciplina/*127.22*/.getCreditos())),format.raw/*127.36*/("""  /  """),_display_(Seq[Any](/*127.42*/disciplina/*127.52*/.getDificuldade())),format.raw/*127.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*127.115*/disciplina/*127.125*/.getId())),format.raw/*127.133*/("""', '"""),_display_(Seq[Any](/*127.138*/numPeriodo)),format.raw/*127.148*/("""', '"""),_display_(Seq[Any](/*127.153*/planejador/*127.163*/.temPreRequisito(disciplina))),format.raw/*127.191*/("""')">Add</a></span> 
				<br>
			""")))})),format.raw/*129.5*/("""
		""")))})),format.raw/*130.4*/("""
	</div>
			
	<div id="header">TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*137.4*/for(disciplina <- naoAlocadas) yield /*137.34*/ {_display_(Seq[Any](format.raw/*137.36*/("""
			"""),_display_(Seq[Any](/*138.5*/if(disciplina.getPeriodoSugerido() == -2)/*138.46*/{_display_(Seq[Any](format.raw/*138.47*/("""
				<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*139.46*/disciplina/*139.56*/.getPreRequisitos())),format.raw/*139.75*/("""">"""),_display_(Seq[Any](/*139.78*/disciplina/*139.88*/.getNome())),format.raw/*139.98*/("""</a>
				<span>"""),_display_(Seq[Any](/*140.12*/disciplina/*140.22*/.getCreditos())),format.raw/*140.36*/("""  /  """),_display_(Seq[Any](/*140.42*/disciplina/*140.52*/.getDificuldade())),format.raw/*140.69*/(""" <a class="addDiscPeriodo" onclick="addDisc('"""),_display_(Seq[Any](/*140.115*/disciplina/*140.125*/.getId())),format.raw/*140.133*/("""', '"""),_display_(Seq[Any](/*140.138*/numPeriodo)),format.raw/*140.148*/("""', '"""),_display_(Seq[Any](/*140.153*/planejador/*140.163*/.temPreRequisito(disciplina))),format.raw/*140.191*/("""')">Add</a></span> 
				<br>
			""")))})),format.raw/*142.5*/("""
		""")))})),format.raw/*143.4*/("""
	</div>
</div>
""")))})),format.raw/*146.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],numPeriodo:Integer,planejador:Planejador): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,numPeriodo,planejador)
    
    def f:((List[Periodo],List[Disciplina],Integer,Planejador) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,numPeriodo,planejador) => apply(periodos,naoAlocadas,numPeriodo,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Feb 28 11:29:35 BRT 2014
                    SOURCE: /home/karen/workspace/projeto-si1/app/views/editar.scala.html
                    HASH: ac3d926f384f7d6e12c6073b9be08fb152c79962
                    MATRIX: 818->1|1030->102|1058->121|1094->123|1131->152|1170->154|1364->313|1404->337|1443->338|1483->343|1555->406|1594->407|1659->436|1675->443|1709->455|1812->521|1845->531|1887->536|1904->543|1951->567|2028->627|2041->632|2080->633|2145->662|2161->669|2195->681|2272->727|2505->924|2571->974|2611->976|2658->987|2751->1071|2790->1072|2878->1124|2904->1141|2943->1158|2982->1161|3009->1178|3042->1188|3093->1202|3120->1219|3157->1233|3200->1239|3227->1256|3267->1273|3358->1328|3377->1338|3446->1384|3488->1389|3515->1406|3546->1414|3588->1419|3621->1429|3683->1473|3696->1478|3735->1479|3823->1531|3849->1548|3888->1565|3927->1568|3954->1585|3987->1595|4038->1609|4065->1626|4102->1640|4143->1644|4170->1661|4210->1678|4264->1700|4302->1707|4414->1784|4460->1821|4499->1822|4612->1904|4668->1924|4684->1931|4727->1952|4770->1959|4786->1966|4832->1990|4882->2005|4928->2042|4968->2044|5125->2170|5169->2179|5215->2216|5255->2218|5296->2224|5357->2276|5397->2278|5500->2350|5536->2355|5578->2366|5682->2435|5729->2473|5769->2475|5884->2558|6210->2849|6256->2879|6296->2881|6336->2886|6385->2926|6424->2927|6506->2973|6525->2983|6566->3002|6605->3005|6624->3015|6656->3025|6711->3044|6730->3054|6766->3068|6808->3074|6827->3084|6866->3101|6949->3147|6969->3157|7000->3165|7042->3170|7075->3180|7117->3185|7137->3195|7188->3223|7252->3256|7287->3260|7333->3271|7379->3301|7419->3303|7459->3308|7508->3348|7547->3349|7629->3395|7648->3405|7689->3424|7728->3427|7747->3437|7779->3447|7831->3463|7850->3473|7886->3487|7928->3493|7947->3503|7986->3520|8069->3566|8089->3576|8120->3584|8162->3589|8195->3599|8237->3604|8257->3614|8308->3642|8372->3675|8407->3679|8453->3690|8499->3720|8539->3722|8579->3727|8628->3767|8667->3768|8749->3814|8768->3824|8809->3843|8848->3846|8867->3856|8899->3866|8951->3882|8970->3892|9006->3906|9048->3912|9067->3922|9106->3939|9189->3985|9209->3995|9240->4003|9282->4008|9315->4018|9357->4023|9377->4033|9428->4061|9491->4093|9526->4097|9572->4108|9618->4138|9658->4140|9698->4145|9747->4185|9786->4186|9868->4232|9887->4242|9928->4261|9967->4264|9986->4274|10018->4284|10070->4300|10089->4310|10125->4324|10167->4330|10186->4340|10225->4357|10308->4403|10328->4413|10359->4421|10401->4426|10434->4436|10476->4441|10496->4451|10547->4479|10610->4511|10645->4515|10691->4526|10737->4556|10777->4558|10817->4563|10866->4603|10905->4604|10987->4650|11006->4660|11047->4679|11086->4682|11105->4692|11137->4702|11189->4718|11208->4728|11244->4742|11286->4748|11305->4758|11344->4775|11427->4821|11447->4831|11478->4839|11520->4844|11553->4854|11595->4859|11615->4869|11666->4897|11729->4929|11764->4933|11811->4944|11858->4974|11899->4976|11940->4981|11990->5021|12030->5022|12113->5068|12133->5078|12175->5097|12215->5100|12235->5110|12268->5120|12321->5136|12341->5146|12378->5160|12421->5166|12441->5176|12481->5193|12565->5239|12586->5249|12618->5257|12661->5262|12695->5272|12738->5277|12759->5287|12811->5315|12875->5347|12911->5351|12958->5362|13005->5392|13046->5394|13087->5399|13137->5439|13177->5440|13260->5486|13280->5496|13322->5515|13362->5518|13382->5528|13415->5538|13468->5554|13488->5564|13525->5578|13568->5584|13588->5594|13628->5611|13712->5657|13733->5667|13765->5675|13808->5680|13842->5690|13885->5695|13906->5705|13958->5733|14022->5765|14058->5769|14397->6072|14444->6102|14485->6104|14526->6109|14577->6150|14617->6151|14700->6197|14720->6207|14762->6226|14802->6229|14822->6239|14855->6249|14908->6265|14928->6275|14965->6289|15008->6295|15028->6305|15068->6322|15152->6368|15173->6378|15205->6386|15248->6391|15282->6401|15325->6406|15346->6416|15398->6444|15463->6477|15499->6481|15736->6682|15783->6712|15824->6714|15865->6719|15916->6760|15956->6761|16039->6807|16059->6817|16101->6836|16141->6839|16161->6849|16194->6859|16247->6875|16267->6885|16304->6899|16347->6905|16367->6915|16407->6932|16491->6978|16512->6988|16544->6996|16587->7001|16621->7011|16664->7016|16685->7026|16737->7054|16802->7087|16838->7091|16887->7108
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|55->27|58->30|58->30|58->30|60->32|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|65->37|67->39|67->39|67->39|68->40|68->40|68->40|70->42|71->43|73->45|78->50|78->50|78->50|80->52|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|94->66|95->67|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|103->75|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|110->82|111->83|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|115->87|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|118->90|119->91|121->93|121->93|121->93|122->94|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|131->103|131->103|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|134->106|135->107|137->109|137->109|137->109|138->110|138->110|138->110|139->111|139->111|139->111|139->111|139->111|139->111|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|142->114|143->115|152->124|152->124|152->124|153->125|153->125|153->125|154->126|154->126|154->126|154->126|154->126|154->126|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|157->129|158->130|165->137|165->137|165->137|166->138|166->138|166->138|167->139|167->139|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|170->142|171->143|174->146
                    -- GENERATED --
                */
            