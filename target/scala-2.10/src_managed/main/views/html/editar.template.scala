
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
		 """),_display_(Seq[Any](/*50.5*/form(routes.Application.novoPeriodo(planejador.getTotalDePeriodos()+1))/*50.76*/ {_display_(Seq[Any](format.raw/*50.78*/("""
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
                    DATE: Sat Mar 01 11:50:32 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/editar.scala.html
                    HASH: 8c41b8c04e051956fa14bfa38b95b8b869943757
                    MATRIX: 818->1|1031->102|1061->124|1098->127|1135->156|1174->158|1374->323|1414->347|1453->348|1494->354|1566->417|1605->418|1671->448|1687->455|1721->467|1824->533|1857->543|1899->548|1916->555|1963->579|2041->640|2054->645|2093->646|2159->676|2175->683|2209->695|2287->742|2523->942|2589->992|2629->994|2677->1006|2770->1090|2809->1091|2898->1144|2924->1161|2963->1178|3002->1181|3029->1198|3062->1208|3113->1222|3140->1239|3177->1253|3220->1259|3247->1276|3287->1293|3379->1349|3398->1359|3467->1405|3509->1410|3536->1427|3567->1435|3609->1440|3642->1450|3706->1496|3719->1501|3758->1502|3847->1555|3873->1572|3912->1589|3951->1592|3978->1609|4011->1619|4062->1633|4089->1650|4126->1664|4167->1668|4194->1685|4234->1702|4289->1725|4328->1733|4443->1813|4489->1850|4528->1851|4643->1935|4700->1956|4716->1963|4759->1984|4802->1991|4818->1998|4864->2022|4916->2039|4962->2076|5002->2078|5161->2206|5207->2217|5253->2254|5293->2256|5335->2263|5396->2315|5436->2317|5541->2391|5578->2397|5622->2410|5731->2484|5811->2555|5851->2557|5968->2642|6303->2942|6349->2972|6389->2974|6430->2980|6479->3020|6518->3021|6601->3068|6620->3078|6661->3097|6700->3100|6719->3110|6751->3120|6807->3140|6826->3150|6862->3164|6904->3170|6923->3180|6962->3197|7045->3243|7065->3253|7096->3261|7138->3266|7171->3276|7213->3281|7233->3291|7284->3319|7350->3354|7386->3359|7434->3372|7480->3402|7520->3404|7561->3410|7610->3450|7649->3451|7732->3498|7751->3508|7792->3527|7831->3530|7850->3540|7882->3550|7935->3567|7954->3577|7990->3591|8032->3597|8051->3607|8090->3624|8173->3670|8193->3680|8224->3688|8266->3693|8299->3703|8341->3708|8361->3718|8412->3746|8478->3781|8514->3786|8562->3799|8608->3829|8648->3831|8689->3837|8738->3877|8777->3878|8860->3925|8879->3935|8920->3954|8959->3957|8978->3967|9010->3977|9063->3994|9082->4004|9118->4018|9160->4024|9179->4034|9218->4051|9301->4097|9321->4107|9352->4115|9394->4120|9427->4130|9469->4135|9489->4145|9540->4173|9605->4207|9641->4212|9689->4225|9735->4255|9775->4257|9816->4263|9865->4303|9904->4304|9987->4351|10006->4361|10047->4380|10086->4383|10105->4393|10137->4403|10190->4420|10209->4430|10245->4444|10287->4450|10306->4460|10345->4477|10428->4523|10448->4533|10479->4541|10521->4546|10554->4556|10596->4561|10616->4571|10667->4599|10732->4633|10768->4638|10816->4651|10862->4681|10902->4683|10943->4689|10992->4729|11031->4730|11114->4777|11133->4787|11174->4806|11213->4809|11232->4819|11264->4829|11317->4846|11336->4856|11372->4870|11414->4876|11433->4886|11472->4903|11555->4949|11575->4959|11606->4967|11648->4972|11681->4982|11723->4987|11743->4997|11794->5025|11859->5059|11895->5064|11944->5077|11991->5107|12032->5109|12074->5115|12124->5155|12164->5156|12248->5203|12268->5213|12310->5232|12350->5235|12370->5245|12403->5255|12457->5272|12477->5282|12514->5296|12557->5302|12577->5312|12617->5329|12701->5375|12722->5385|12754->5393|12797->5398|12831->5408|12874->5413|12895->5423|12947->5451|13013->5485|13050->5490|13099->5503|13146->5533|13187->5535|13229->5541|13279->5581|13319->5582|13403->5629|13423->5639|13465->5658|13505->5661|13525->5671|13558->5681|13612->5698|13632->5708|13669->5722|13712->5728|13732->5738|13772->5755|13856->5801|13877->5811|13909->5819|13952->5824|13986->5834|14029->5839|14050->5849|14102->5877|14168->5911|14205->5916|14553->6228|14600->6258|14641->6260|14683->6266|14734->6307|14774->6308|14858->6355|14878->6365|14920->6384|14960->6387|14980->6397|15013->6407|15067->6424|15087->6434|15124->6448|15167->6454|15187->6464|15227->6481|15311->6527|15332->6537|15364->6545|15407->6550|15441->6560|15484->6565|15505->6575|15557->6603|15624->6638|15661->6643|15905->6851|15952->6881|15993->6883|16035->6889|16086->6930|16126->6931|16210->6978|16230->6988|16272->7007|16312->7010|16332->7020|16365->7030|16419->7047|16439->7057|16476->7071|16519->7077|16539->7087|16579->7104|16663->7150|16684->7160|16716->7168|16759->7173|16793->7183|16836->7188|16857->7198|16909->7226|16976->7261|17013->7266|17065->7286
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|55->27|58->30|58->30|58->30|60->32|61->33|61->33|61->33|61->33|61->33|61->33|63->35|63->35|63->35|65->37|67->39|67->39|67->39|68->40|68->40|68->40|70->42|71->43|73->45|78->50|78->50|78->50|80->52|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|92->64|94->66|95->67|97->69|97->69|97->69|98->70|98->70|98->70|99->71|99->71|99->71|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|103->75|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|108->80|110->82|111->83|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|115->87|115->87|115->87|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|116->88|118->90|119->91|121->93|121->93|121->93|122->94|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|131->103|131->103|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|132->104|134->106|135->107|137->109|137->109|137->109|138->110|138->110|138->110|139->111|139->111|139->111|139->111|139->111|139->111|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|140->112|142->114|143->115|152->124|152->124|152->124|153->125|153->125|153->125|154->126|154->126|154->126|154->126|154->126|154->126|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|155->127|157->129|158->130|165->137|165->137|165->137|166->138|166->138|166->138|167->139|167->139|167->139|167->139|167->139|167->139|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|168->140|170->142|171->143|174->146
                    -- GENERATED --
                */
            