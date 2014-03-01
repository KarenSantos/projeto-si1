
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
                    DATE: Fri Feb 28 22:13:28 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 14b8620da6eb1c6ca1fb74ad163247cf94b6bedb
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1374->323|1414->347|1453->348|1494->354|1566->417|1605->418|1671->448|1687->455|1721->467|1824->533|1857->543|1899->548|1916->555|1963->579|2041->640|2054->645|2093->646|2159->676|2175->683|2209->695|2287->742|2523->942|2589->992|2629->994|2677->1006|2770->1090|2809->1091|2898->1144|2924->1161|2963->1178|3002->1181|3029->1198|3062->1208|3113->1222|3140->1239|3177->1253|3220->1259|3247->1276|3287->1293|3379->1349|3398->1359|3467->1405|3509->1410|3536->1427|3567->1435|3609->1440|3642->1450|3706->1496|3719->1501|3758->1502|3847->1555|3873->1572|3912->1589|3951->1592|3978->1609|4011->1619|4062->1633|4089->1650|4126->1664|4167->1668|4194->1685|4234->1702|4289->1725|4328->1733|4443->1813|4489->1850|4528->1851|4643->1935|4700->1956|4716->1963|4759->1984|4802->1991|4818->1998|4864->2022|4916->2039|4962->2076|5002->2078|5161->2206|5207->2217|5253->2254|5293->2256|5335->2263|5396->2315|5436->2317|5541->2391|5578->2397|5622->2410|5731->2484|5778->2522|5818->2524|5935->2609|6270->2909|6316->2939|6356->2941|6397->2947|6446->2987|6485->2988|6568->3035|6587->3045|6628->3064|6667->3067|6686->3077|6718->3087|6774->3107|6793->3117|6829->3131|6871->3137|6890->3147|6929->3164|7012->3210|7032->3220|7063->3228|7105->3233|7138->3243|7180->3248|7200->3258|7251->3286|7317->3321|7353->3326|7401->3339|7447->3369|7487->3371|7528->3377|7577->3417|7616->3418|7699->3465|7718->3475|7759->3494|7798->3497|7817->3507|7849->3517|7902->3534|7921->3544|7957->3558|7999->3564|8018->3574|8057->3591|8140->3637|8160->3647|8191->3655|8233->3660|8266->3670|8308->3675|8328->3685|8379->3713|8445->3748|8481->3753|8529->3766|8575->3796|8615->3798|8656->3804|8705->3844|8744->3845|8827->3892|8846->3902|8887->3921|8926->3924|8945->3934|8977->3944|9030->3961|9049->3971|9085->3985|9127->3991|9146->4001|9185->4018|9268->4064|9288->4074|9319->4082|9361->4087|9394->4097|9436->4102|9456->4112|9507->4140|9572->4174|9608->4179|9656->4192|9702->4222|9742->4224|9783->4230|9832->4270|9871->4271|9954->4318|9973->4328|10014->4347|10053->4350|10072->4360|10104->4370|10157->4387|10176->4397|10212->4411|10254->4417|10273->4427|10312->4444|10395->4490|10415->4500|10446->4508|10488->4513|10521->4523|10563->4528|10583->4538|10634->4566|10699->4600|10735->4605|10783->4618|10829->4648|10869->4650|10910->4656|10959->4696|10998->4697|11081->4744|11100->4754|11141->4773|11180->4776|11199->4786|11231->4796|11284->4813|11303->4823|11339->4837|11381->4843|11400->4853|11439->4870|11522->4916|11542->4926|11573->4934|11615->4939|11648->4949|11690->4954|11710->4964|11761->4992|11826->5026|11862->5031|11911->5044|11958->5074|11999->5076|12041->5082|12091->5122|12131->5123|12215->5170|12235->5180|12277->5199|12317->5202|12337->5212|12370->5222|12424->5239|12444->5249|12481->5263|12524->5269|12544->5279|12584->5296|12668->5342|12689->5352|12721->5360|12764->5365|12798->5375|12841->5380|12862->5390|12914->5418|12980->5452|13017->5457|13066->5470|13113->5500|13154->5502|13196->5508|13246->5548|13286->5549|13370->5596|13390->5606|13432->5625|13472->5628|13492->5638|13525->5648|13579->5665|13599->5675|13636->5689|13679->5695|13699->5705|13739->5722|13823->5768|13844->5778|13876->5786|13919->5791|13953->5801|13996->5806|14017->5816|14069->5844|14135->5878|14172->5883|14520->6195|14567->6225|14608->6227|14650->6233|14701->6274|14741->6275|14825->6322|14845->6332|14887->6351|14927->6354|14947->6364|14980->6374|15034->6391|15054->6401|15091->6415|15134->6421|15154->6431|15194->6448|15278->6494|15299->6504|15331->6512|15374->6517|15408->6527|15451->6532|15472->6542|15524->6570|15591->6605|15628->6610|15872->6818|15919->6848|15960->6850|16002->6856|16053->6897|16093->6898|16177->6945|16197->6955|16239->6974|16279->6977|16299->6987|16332->6997|16386->7014|16406->7024|16443->7038|16486->7044|16506->7054|16546->7071|16630->7117|16651->7127|16683->7135|16726->7140|16760->7150|16803->7155|16824->7165|16876->7193|16943->7228|16980->7233|17032->7253
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|55->27|58->30|58->30|58->30|60->32|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|65->37|67->39|67->39|67->39|68->40|68->40|68->40|70->42|71->43|73->45|78->50|78->50|78->50|80->52|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|94->66|95->67|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|103->75|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|110->82|111->83|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|115->87|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|118->90|119->91|121->93|121->93|121->93|122->94|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|131->103|131->103|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|134->106|135->107|137->109|137->109|137->109|138->110|138->110|138->110|139->111|139->111|139->111|139->111|139->111|139->111|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|142->114|143->115|152->124|152->124|152->124|153->125|153->125|153->125|154->126|154->126|154->126|154->126|154->126|154->126|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|157->129|158->130|165->137|165->137|165->137|166->138|166->138|166->138|167->139|167->139|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|170->142|171->143|174->146
                    -- GENERATED --
                */
            