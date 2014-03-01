
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Periodo],List[Disciplina],Object,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodos: List[Periodo], naoAlocadas: List[Disciplina], planejador: Object):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.78*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Planejamento de Curso")/*5.31*/ {_display_(Seq[Any](format.raw/*5.33*/("""

<div id="top1"><!-- coluna de periodos -->
	<a onclick="novoPeriodo()"><div id="novoPeriodo">Novo Período</div></a>
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*12.3*/for(periodo <- periodos) yield /*12.27*/{_display_(Seq[Any](format.raw/*12.28*/("""
		<div id="periodoBox">
			<a onclick="editaPeriodo()" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*14.89*/periodo/*14.96*/.getNumero())),format.raw/*14.108*/("""º</b> Período</div></a><!-- Numero do periodo -->
			<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			<div class="disc"><!-- Disciplinas do periodo -->
			    """),_display_(Seq[Any](/*17.9*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*17.59*/ {_display_(Seq[Any](format.raw/*17.61*/("""
			    	<a class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*18.50*/disciplinaPeriodo/*18.67*/.getPreRequisitos)),format.raw/*18.84*/("""">"""),_display_(Seq[Any](/*18.87*/disciplinaPeriodo/*18.104*/.getNome())),format.raw/*18.114*/(""" </a>  <span>"""),_display_(Seq[Any](/*18.128*/disciplinaPeriodo/*18.145*/.getCreditos())),format.raw/*18.159*/(""" / """),_display_(Seq[Any](/*18.163*/disciplinaPeriodo/*18.180*/.getDificuldade())),format.raw/*18.197*/("""</span>
			    	<br>
			    """)))})),format.raw/*20.9*/("""
			</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*23.5*/if(periodo.getTotalDeCreditos() < 14)/*23.42*/{_display_(Seq[Any](format.raw/*23.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*25.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*26.20*/periodo/*26.27*/.getTotalDeCreditos())),format.raw/*26.48*/("""  /   """),_display_(Seq[Any](/*26.55*/periodo/*26.62*/.getTotalDeDificuldade())),format.raw/*26.86*/("""
			</div>
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*29.3*/("""
	
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*40.4*/for(disciplina <- naoAlocadas) yield /*40.34*/ {_display_(Seq[Any](format.raw/*40.36*/("""
			"""),_display_(Seq[Any](/*41.5*/if(disciplina.getPeriodoSugerido() == 2)/*41.45*/{_display_(Seq[Any](format.raw/*41.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*42.46*/disciplina/*42.56*/.getPreRequisitos())),format.raw/*42.75*/("""">"""),_display_(Seq[Any](/*42.78*/disciplina/*42.88*/.getNome())),format.raw/*42.98*/("""</a>   <span>"""),_display_(Seq[Any](/*42.112*/disciplina/*42.122*/.getCreditos())),format.raw/*42.136*/("""  /  """),_display_(Seq[Any](/*42.142*/disciplina/*42.152*/.getDificuldade())),format.raw/*42.169*/("""</span>
				<br>
			""")))})),format.raw/*44.5*/("""
		""")))})),format.raw/*45.4*/("""
		<br>
		"""),_display_(Seq[Any](/*47.4*/for(disciplina <- naoAlocadas) yield /*47.34*/ {_display_(Seq[Any](format.raw/*47.36*/("""
			"""),_display_(Seq[Any](/*48.5*/if(disciplina.getPeriodoSugerido() == 3)/*48.45*/{_display_(Seq[Any](format.raw/*48.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*49.46*/disciplina/*49.56*/.getPreRequisitos())),format.raw/*49.75*/("""">"""),_display_(Seq[Any](/*49.78*/disciplina/*49.88*/.getNome())),format.raw/*49.98*/("""</a>   <span>"""),_display_(Seq[Any](/*49.112*/disciplina/*49.122*/.getCreditos())),format.raw/*49.136*/("""  /  """),_display_(Seq[Any](/*49.142*/disciplina/*49.152*/.getDificuldade())),format.raw/*49.169*/("""</span>
				<br>
			""")))})),format.raw/*51.5*/("""
		""")))})),format.raw/*52.4*/("""
		<br>
		"""),_display_(Seq[Any](/*54.4*/for(disciplina <- naoAlocadas) yield /*54.34*/ {_display_(Seq[Any](format.raw/*54.36*/("""
			"""),_display_(Seq[Any](/*55.5*/if(disciplina.getPeriodoSugerido() == 4)/*55.45*/{_display_(Seq[Any](format.raw/*55.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*56.46*/disciplina/*56.56*/.getPreRequisitos())),format.raw/*56.75*/("""">"""),_display_(Seq[Any](/*56.78*/disciplina/*56.88*/.getNome())),format.raw/*56.98*/("""</a>   <span>"""),_display_(Seq[Any](/*56.112*/disciplina/*56.122*/.getCreditos())),format.raw/*56.136*/("""  /  """),_display_(Seq[Any](/*56.142*/disciplina/*56.152*/.getDificuldade())),format.raw/*56.169*/("""</span>
				<br>
			""")))})),format.raw/*58.5*/("""
		""")))})),format.raw/*59.4*/("""
		<br>
		"""),_display_(Seq[Any](/*61.4*/for(disciplina <- naoAlocadas) yield /*61.34*/ {_display_(Seq[Any](format.raw/*61.36*/("""
			"""),_display_(Seq[Any](/*62.5*/if(disciplina.getPeriodoSugerido() == 5)/*62.45*/{_display_(Seq[Any](format.raw/*62.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*63.46*/disciplina/*63.56*/.getPreRequisitos())),format.raw/*63.75*/("""">"""),_display_(Seq[Any](/*63.78*/disciplina/*63.88*/.getNome())),format.raw/*63.98*/("""</a>   <span>"""),_display_(Seq[Any](/*63.112*/disciplina/*63.122*/.getCreditos())),format.raw/*63.136*/("""  /  """),_display_(Seq[Any](/*63.142*/disciplina/*63.152*/.getDificuldade())),format.raw/*63.169*/("""</span>
				<br>
			""")))})),format.raw/*65.5*/("""
		""")))})),format.raw/*66.4*/("""
		<br>
		"""),_display_(Seq[Any](/*68.4*/for(disciplina <- naoAlocadas) yield /*68.34*/ {_display_(Seq[Any](format.raw/*68.36*/("""
			"""),_display_(Seq[Any](/*69.5*/if(disciplina.getPeriodoSugerido() == 6)/*69.45*/{_display_(Seq[Any](format.raw/*69.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*70.46*/disciplina/*70.56*/.getPreRequisitos())),format.raw/*70.75*/("""">"""),_display_(Seq[Any](/*70.78*/disciplina/*70.88*/.getNome())),format.raw/*70.98*/("""</a>   <span>"""),_display_(Seq[Any](/*70.112*/disciplina/*70.122*/.getCreditos())),format.raw/*70.136*/("""  /  """),_display_(Seq[Any](/*70.142*/disciplina/*70.152*/.getDificuldade())),format.raw/*70.169*/("""</span>
				<br>
			""")))})),format.raw/*72.5*/("""
		""")))})),format.raw/*73.4*/("""
		<br>
		"""),_display_(Seq[Any](/*75.4*/for(disciplina <- naoAlocadas) yield /*75.34*/ {_display_(Seq[Any](format.raw/*75.36*/("""
			"""),_display_(Seq[Any](/*76.5*/if(disciplina.getPeriodoSugerido() == 7)/*76.45*/{_display_(Seq[Any](format.raw/*76.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*77.46*/disciplina/*77.56*/.getPreRequisitos())),format.raw/*77.75*/("""">"""),_display_(Seq[Any](/*77.78*/disciplina/*77.88*/.getNome())),format.raw/*77.98*/("""</a>   <span>"""),_display_(Seq[Any](/*77.112*/disciplina/*77.122*/.getCreditos())),format.raw/*77.136*/("""  /  """),_display_(Seq[Any](/*77.142*/disciplina/*77.152*/.getDificuldade())),format.raw/*77.169*/("""</span>
				<br>
			""")))})),format.raw/*79.5*/("""
		""")))})),format.raw/*80.4*/("""
		<br>
		"""),_display_(Seq[Any](/*82.4*/for(disciplina <- naoAlocadas) yield /*82.34*/ {_display_(Seq[Any](format.raw/*82.36*/("""
			"""),_display_(Seq[Any](/*83.5*/if(disciplina.getPeriodoSugerido() == 8)/*83.45*/{_display_(Seq[Any](format.raw/*83.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*84.46*/disciplina/*84.56*/.getPreRequisitos())),format.raw/*84.75*/("""">"""),_display_(Seq[Any](/*84.78*/disciplina/*84.88*/.getNome())),format.raw/*84.98*/("""</a>   <span>"""),_display_(Seq[Any](/*84.112*/disciplina/*84.122*/.getCreditos())),format.raw/*84.136*/("""  /  """),_display_(Seq[Any](/*84.142*/disciplina/*84.152*/.getDificuldade())),format.raw/*84.169*/("""</span>
				<br>
			""")))})),format.raw/*86.5*/("""
		""")))})),format.raw/*87.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*94.4*/for(disciplina <- naoAlocadas) yield /*94.34*/ {_display_(Seq[Any](format.raw/*94.36*/("""
				"""),_display_(Seq[Any](/*95.6*/if(disciplina.getPeriodoSugerido() == -1)/*95.47*/{_display_(Seq[Any](format.raw/*95.48*/("""
					<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*96.47*/disciplina/*96.57*/.getPreRequisitos())),format.raw/*96.76*/("""">"""),_display_(Seq[Any](/*96.79*/disciplina/*96.89*/.getNome())),format.raw/*96.99*/("""</a>   <span>"""),_display_(Seq[Any](/*96.113*/disciplina/*96.123*/.getCreditos())),format.raw/*96.137*/("""  /  """),_display_(Seq[Any](/*96.143*/disciplina/*96.153*/.getDificuldade())),format.raw/*96.170*/("""</span>
					<br>
				""")))})),format.raw/*98.6*/("""
		""")))})),format.raw/*99.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*106.4*/for(disciplina <- naoAlocadas) yield /*106.34*/ {_display_(Seq[Any](format.raw/*106.36*/("""
			"""),_display_(Seq[Any](/*107.5*/if(disciplina.getPeriodoSugerido() == -2)/*107.46*/{_display_(Seq[Any](format.raw/*107.47*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*108.46*/disciplina/*108.56*/.getPreRequisitos())),format.raw/*108.75*/("""">"""),_display_(Seq[Any](/*108.78*/disciplina/*108.88*/.getNome())),format.raw/*108.98*/("""</a>   <span>"""),_display_(Seq[Any](/*108.112*/disciplina/*108.122*/.getCreditos())),format.raw/*108.136*/("""  /  """),_display_(Seq[Any](/*108.142*/disciplina/*108.152*/.getDificuldade())),format.raw/*108.169*/("""</span>
				<br>
			""")))})),format.raw/*110.5*/("""
		""")))})),format.raw/*111.4*/("""
	</div>
</div>
""")))})),format.raw/*114.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Object): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Object) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Mar 01 11:50:32 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/index.scala.html
                    HASH: cabac04d03fbbd6b1dcbcfd9c9a770fbc6cd4ac1
                    MATRIX: 805->1|992->77|1022->99|1059->102|1096->131|1135->133|1367->330|1407->354|1446->355|1597->470|1613->477|1648->489|1930->736|1996->786|2036->788|2123->839|2149->856|2188->873|2227->876|2254->893|2287->903|2338->917|2365->934|2402->948|2443->952|2470->969|2510->986|2572->1017|2686->1096|2732->1133|2771->1134|2886->1218|2943->1239|2959->1246|3002->1267|3045->1274|3061->1281|3107->1305|3189->1356|3531->1663|3577->1693|3617->1695|3658->1701|3707->1741|3746->1742|3829->1789|3848->1799|3889->1818|3928->1821|3947->1831|3979->1841|4030->1855|4050->1865|4087->1879|4130->1885|4150->1895|4190->1912|4244->1935|4280->1940|4328->1953|4374->1983|4414->1985|4455->1991|4504->2031|4543->2032|4626->2079|4645->2089|4686->2108|4725->2111|4744->2121|4776->2131|4827->2145|4847->2155|4884->2169|4927->2175|4947->2185|4987->2202|5041->2225|5077->2230|5125->2243|5171->2273|5211->2275|5252->2281|5301->2321|5340->2322|5423->2369|5442->2379|5483->2398|5522->2401|5541->2411|5573->2421|5624->2435|5644->2445|5681->2459|5724->2465|5744->2475|5784->2492|5838->2515|5874->2520|5922->2533|5968->2563|6008->2565|6049->2571|6098->2611|6137->2612|6220->2659|6239->2669|6280->2688|6319->2691|6338->2701|6370->2711|6421->2725|6441->2735|6478->2749|6521->2755|6541->2765|6581->2782|6635->2805|6671->2810|6719->2823|6765->2853|6805->2855|6846->2861|6895->2901|6934->2902|7017->2949|7036->2959|7077->2978|7116->2981|7135->2991|7167->3001|7218->3015|7238->3025|7275->3039|7318->3045|7338->3055|7378->3072|7432->3095|7468->3100|7516->3113|7562->3143|7602->3145|7643->3151|7692->3191|7731->3192|7814->3239|7833->3249|7874->3268|7913->3271|7932->3281|7964->3291|8015->3305|8035->3315|8072->3329|8115->3335|8135->3345|8175->3362|8229->3385|8265->3390|8313->3403|8359->3433|8399->3435|8440->3441|8489->3481|8528->3482|8611->3529|8630->3539|8671->3558|8710->3561|8729->3571|8761->3581|8812->3595|8832->3605|8869->3619|8912->3625|8932->3635|8972->3652|9026->3675|9062->3680|9322->3905|9368->3935|9408->3937|9450->3944|9500->3985|9539->3986|9623->4034|9642->4044|9683->4063|9722->4066|9741->4076|9773->4086|9824->4100|9844->4110|9881->4124|9924->4130|9944->4140|9984->4157|10040->4182|10076->4187|10330->4405|10377->4435|10418->4437|10460->4443|10511->4484|10551->4485|10635->4532|10655->4542|10697->4561|10737->4564|10757->4574|10790->4584|10842->4598|10863->4608|10901->4622|10945->4628|10966->4638|11007->4655|11062->4678|11099->4683|11151->4703
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|51->23|51->23|51->23|53->25|54->26|54->26|54->26|54->26|54->26|54->26|57->29|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|73->45|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|79->51|80->52|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|86->58|87->59|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|93->65|94->66|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|100->72|101->73|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|107->79|108->80|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|114->86|115->87|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|134->106|134->106|134->106|135->107|135->107|135->107|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|138->110|139->111|142->114
                    -- GENERATED --
                */
            