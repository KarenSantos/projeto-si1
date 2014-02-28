
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
                    DATE: Fri Feb 28 11:29:34 BRT 2014
                    SOURCE: /home/karen/workspace/projeto-si1/app/views/index.scala.html
                    HASH: d11e132af184b136c0ecab476f4cb9aae38d74bd
                    MATRIX: 805->1|991->77|1019->96|1055->98|1092->127|1131->129|1356->319|1396->343|1435->344|1584->457|1600->464|1635->476|1914->720|1980->770|2020->772|2106->822|2132->839|2171->856|2210->859|2237->876|2270->886|2321->900|2348->917|2385->931|2426->935|2453->952|2493->969|2553->998|2664->1074|2710->1111|2749->1112|2862->1194|2918->1214|2934->1221|2977->1242|3020->1249|3036->1256|3082->1280|3161->1328|3492->1624|3538->1654|3578->1656|3618->1661|3667->1701|3706->1702|3788->1748|3807->1758|3848->1777|3887->1780|3906->1790|3938->1800|3989->1814|4009->1824|4046->1838|4089->1844|4109->1854|4149->1871|4201->1892|4236->1896|4282->1907|4328->1937|4368->1939|4408->1944|4457->1984|4496->1985|4578->2031|4597->2041|4638->2060|4677->2063|4696->2073|4728->2083|4779->2097|4799->2107|4836->2121|4879->2127|4899->2137|4939->2154|4991->2175|5026->2179|5072->2190|5118->2220|5158->2222|5198->2227|5247->2267|5286->2268|5368->2314|5387->2324|5428->2343|5467->2346|5486->2356|5518->2366|5569->2380|5589->2390|5626->2404|5669->2410|5689->2420|5729->2437|5781->2458|5816->2462|5862->2473|5908->2503|5948->2505|5988->2510|6037->2550|6076->2551|6158->2597|6177->2607|6218->2626|6257->2629|6276->2639|6308->2649|6359->2663|6379->2673|6416->2687|6459->2693|6479->2703|6519->2720|6571->2741|6606->2745|6652->2756|6698->2786|6738->2788|6778->2793|6827->2833|6866->2834|6948->2880|6967->2890|7008->2909|7047->2912|7066->2922|7098->2932|7149->2946|7169->2956|7206->2970|7249->2976|7269->2986|7309->3003|7361->3024|7396->3028|7442->3039|7488->3069|7528->3071|7568->3076|7617->3116|7656->3117|7738->3163|7757->3173|7798->3192|7837->3195|7856->3205|7888->3215|7939->3229|7959->3239|7996->3253|8039->3259|8059->3269|8099->3286|8151->3307|8186->3311|8232->3322|8278->3352|8318->3354|8358->3359|8407->3399|8446->3400|8528->3446|8547->3456|8588->3475|8627->3478|8646->3488|8678->3498|8729->3512|8749->3522|8786->3536|8829->3542|8849->3552|8889->3569|8941->3590|8976->3594|9229->3812|9275->3842|9315->3844|9356->3850|9406->3891|9445->3892|9528->3939|9547->3949|9588->3968|9627->3971|9646->3981|9678->3991|9729->4005|9749->4015|9786->4029|9829->4035|9849->4045|9889->4062|9943->4085|9978->4089|10225->4300|10272->4330|10313->4332|10354->4337|10405->4378|10445->4379|10528->4425|10548->4435|10590->4454|10630->4457|10650->4467|10683->4477|10735->4491|10756->4501|10794->4515|10838->4521|10859->4531|10900->4548|10953->4569|10989->4573|11038->4590
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|46->18|48->20|51->23|51->23|51->23|53->25|54->26|54->26|54->26|54->26|54->26|54->26|57->29|68->40|68->40|68->40|69->41|69->41|69->41|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|70->42|72->44|73->45|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|77->49|79->51|80->52|82->54|82->54|82->54|83->55|83->55|83->55|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|84->56|86->58|87->59|89->61|89->61|89->61|90->62|90->62|90->62|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|91->63|93->65|94->66|96->68|96->68|96->68|97->69|97->69|97->69|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|98->70|100->72|101->73|103->75|103->75|103->75|104->76|104->76|104->76|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|105->77|107->79|108->80|110->82|110->82|110->82|111->83|111->83|111->83|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|114->86|115->87|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|134->106|134->106|134->106|135->107|135->107|135->107|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|136->108|138->110|139->111|142->114
                    -- GENERATED --
                */
            