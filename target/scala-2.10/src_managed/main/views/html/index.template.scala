
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

<div id="col1"><h2 style="border-bottom: none">Períodos</h2><!-- coluna de periodos -->

	<div id="periodoBox">
		<div class="disciplinasPeriodo"><!-- Começo de um periodo -->
		
			"""),_display_(Seq[Any](/*12.5*/for(periodo <- periodos) yield /*12.29*/{_display_(Seq[Any](format.raw/*12.30*/("""
			<div class="numPriodo">"""),_display_(Seq[Any](/*13.28*/periodo/*13.35*/.getNumero())),format.raw/*13.47*/("""º Período</div><!-- Numero do periodo -->
				<div id="headerDescription" style="display:;">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*16.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*16.60*/ {_display_(Seq[Any](format.raw/*16.62*/("""
				    	<a class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*17.51*/disciplinaPeriodo/*17.68*/.getPreRequisitos)),format.raw/*17.85*/("""">"""),_display_(Seq[Any](/*17.88*/disciplinaPeriodo/*17.105*/.getNome())),format.raw/*17.115*/(""" </a>  <span>"""),_display_(Seq[Any](/*17.129*/disciplinaPeriodo/*17.146*/.getCreditos())),format.raw/*17.160*/(""" / """),_display_(Seq[Any](/*17.164*/disciplinaPeriodo/*17.181*/.getDificuldade())),format.raw/*17.198*/("""</span>
				    	<br>
				    """)))})),format.raw/*19.10*/("""
				</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*22.6*/if(periodo.getTotalDeCreditos() < 14)/*22.43*/{_display_(Seq[Any](format.raw/*22.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*24.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*25.21*/periodo/*25.28*/.getTotalDeCreditos())),format.raw/*25.49*/("""  /   """),_display_(Seq[Any](/*25.56*/periodo/*25.63*/.getTotalDeDificuldade())),format.raw/*25.87*/("""
				</div>
				"""),_display_(Seq[Any](/*27.6*/form(routes.Application.editar(periodo.getNumero()))/*27.58*/ {_display_(Seq[Any](format.raw/*27.60*/("""
					<input class="addDisc" type="submit" value="Editar período">
				""")))})),format.raw/*29.6*/("""
				
		    """)))})),format.raw/*31.8*/("""
		</div>
	</div><!-- Fim de um periodo -->
	
	<div id="addPeriodo">
		 """),_display_(Seq[Any](/*36.5*/form(routes.Application.novoPeriodo())/*36.43*/ {_display_(Seq[Any](format.raw/*36.45*/("""
              <input class="bAdd" type="submit" value="+ Novo Periodo">
         """)))})),format.raw/*38.11*/(""" 
	</div><!-- div para criar novo periodo -->
</div>

<div id="col3"><h2>Disciplinas</h2><!-- coluna de disciplinas -->

	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*49.4*/for(disciplina <- naoAlocadas) yield /*49.34*/ {_display_(Seq[Any](format.raw/*49.36*/("""
			"""),_display_(Seq[Any](/*50.5*/if(disciplina.getPeriodoSugerido() == 2)/*50.45*/{_display_(Seq[Any](format.raw/*50.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*51.46*/disciplina/*51.56*/.getPreRequisitos())),format.raw/*51.75*/("""">"""),_display_(Seq[Any](/*51.78*/disciplina/*51.88*/.getNome())),format.raw/*51.98*/("""</a>   <span>"""),_display_(Seq[Any](/*51.112*/disciplina/*51.122*/.getCreditos())),format.raw/*51.136*/("""  /  """),_display_(Seq[Any](/*51.142*/disciplina/*51.152*/.getDificuldade())),format.raw/*51.169*/("""</span>
				<br>
			""")))})),format.raw/*53.5*/("""
		""")))})),format.raw/*54.4*/("""
		<br>
		"""),_display_(Seq[Any](/*56.4*/for(disciplina <- naoAlocadas) yield /*56.34*/ {_display_(Seq[Any](format.raw/*56.36*/("""
			"""),_display_(Seq[Any](/*57.5*/if(disciplina.getPeriodoSugerido() == 3)/*57.45*/{_display_(Seq[Any](format.raw/*57.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*58.46*/disciplina/*58.56*/.getPreRequisitos())),format.raw/*58.75*/("""">"""),_display_(Seq[Any](/*58.78*/disciplina/*58.88*/.getNome())),format.raw/*58.98*/("""</a>   <span>"""),_display_(Seq[Any](/*58.112*/disciplina/*58.122*/.getCreditos())),format.raw/*58.136*/("""  /  """),_display_(Seq[Any](/*58.142*/disciplina/*58.152*/.getDificuldade())),format.raw/*58.169*/("""</span>
				<br>
			""")))})),format.raw/*60.5*/("""
		""")))})),format.raw/*61.4*/("""
		<br>
		"""),_display_(Seq[Any](/*63.4*/for(disciplina <- naoAlocadas) yield /*63.34*/ {_display_(Seq[Any](format.raw/*63.36*/("""
			"""),_display_(Seq[Any](/*64.5*/if(disciplina.getPeriodoSugerido() == 4)/*64.45*/{_display_(Seq[Any](format.raw/*64.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*65.46*/disciplina/*65.56*/.getPreRequisitos())),format.raw/*65.75*/("""">"""),_display_(Seq[Any](/*65.78*/disciplina/*65.88*/.getNome())),format.raw/*65.98*/("""</a>   <span>"""),_display_(Seq[Any](/*65.112*/disciplina/*65.122*/.getCreditos())),format.raw/*65.136*/("""  /  """),_display_(Seq[Any](/*65.142*/disciplina/*65.152*/.getDificuldade())),format.raw/*65.169*/("""</span>
				<br>
			""")))})),format.raw/*67.5*/("""
		""")))})),format.raw/*68.4*/("""
		<br>
		"""),_display_(Seq[Any](/*70.4*/for(disciplina <- naoAlocadas) yield /*70.34*/ {_display_(Seq[Any](format.raw/*70.36*/("""
			"""),_display_(Seq[Any](/*71.5*/if(disciplina.getPeriodoSugerido() == 5)/*71.45*/{_display_(Seq[Any](format.raw/*71.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*72.46*/disciplina/*72.56*/.getPreRequisitos())),format.raw/*72.75*/("""">"""),_display_(Seq[Any](/*72.78*/disciplina/*72.88*/.getNome())),format.raw/*72.98*/("""</a>   <span>"""),_display_(Seq[Any](/*72.112*/disciplina/*72.122*/.getCreditos())),format.raw/*72.136*/("""  /  """),_display_(Seq[Any](/*72.142*/disciplina/*72.152*/.getDificuldade())),format.raw/*72.169*/("""</span>
				<br>
			""")))})),format.raw/*74.5*/("""
		""")))})),format.raw/*75.4*/("""
		<br>
		"""),_display_(Seq[Any](/*77.4*/for(disciplina <- naoAlocadas) yield /*77.34*/ {_display_(Seq[Any](format.raw/*77.36*/("""
			"""),_display_(Seq[Any](/*78.5*/if(disciplina.getPeriodoSugerido() == 6)/*78.45*/{_display_(Seq[Any](format.raw/*78.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*79.46*/disciplina/*79.56*/.getPreRequisitos())),format.raw/*79.75*/("""">"""),_display_(Seq[Any](/*79.78*/disciplina/*79.88*/.getNome())),format.raw/*79.98*/("""</a>   <span>"""),_display_(Seq[Any](/*79.112*/disciplina/*79.122*/.getCreditos())),format.raw/*79.136*/("""  /  """),_display_(Seq[Any](/*79.142*/disciplina/*79.152*/.getDificuldade())),format.raw/*79.169*/("""</span>
				<br>
			""")))})),format.raw/*81.5*/("""
		""")))})),format.raw/*82.4*/("""
		<br>
		"""),_display_(Seq[Any](/*84.4*/for(disciplina <- naoAlocadas) yield /*84.34*/ {_display_(Seq[Any](format.raw/*84.36*/("""
			"""),_display_(Seq[Any](/*85.5*/if(disciplina.getPeriodoSugerido() == 7)/*85.45*/{_display_(Seq[Any](format.raw/*85.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*86.46*/disciplina/*86.56*/.getPreRequisitos())),format.raw/*86.75*/("""">"""),_display_(Seq[Any](/*86.78*/disciplina/*86.88*/.getNome())),format.raw/*86.98*/("""</a>   <span>"""),_display_(Seq[Any](/*86.112*/disciplina/*86.122*/.getCreditos())),format.raw/*86.136*/("""  /  """),_display_(Seq[Any](/*86.142*/disciplina/*86.152*/.getDificuldade())),format.raw/*86.169*/("""</span>
				<br>
			""")))})),format.raw/*88.5*/("""
		""")))})),format.raw/*89.4*/("""
		<br>
		"""),_display_(Seq[Any](/*91.4*/for(disciplina <- naoAlocadas) yield /*91.34*/ {_display_(Seq[Any](format.raw/*91.36*/("""
			"""),_display_(Seq[Any](/*92.5*/if(disciplina.getPeriodoSugerido() == 8)/*92.45*/{_display_(Seq[Any](format.raw/*92.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*93.46*/disciplina/*93.56*/.getPreRequisitos())),format.raw/*93.75*/("""">"""),_display_(Seq[Any](/*93.78*/disciplina/*93.88*/.getNome())),format.raw/*93.98*/("""</a>   <span>"""),_display_(Seq[Any](/*93.112*/disciplina/*93.122*/.getCreditos())),format.raw/*93.136*/("""  /  """),_display_(Seq[Any](/*93.142*/disciplina/*93.152*/.getDificuldade())),format.raw/*93.169*/("""</span>
				<br>
			""")))})),format.raw/*95.5*/("""
		""")))})),format.raw/*96.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*103.4*/for(disciplina <- naoAlocadas) yield /*103.34*/ {_display_(Seq[Any](format.raw/*103.36*/("""
				"""),_display_(Seq[Any](/*104.6*/if(disciplina.getPeriodoSugerido() == -1)/*104.47*/{_display_(Seq[Any](format.raw/*104.48*/("""
					<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*105.47*/disciplina/*105.57*/.getPreRequisitos())),format.raw/*105.76*/("""">"""),_display_(Seq[Any](/*105.79*/disciplina/*105.89*/.getNome())),format.raw/*105.99*/("""</a>   <span>"""),_display_(Seq[Any](/*105.113*/disciplina/*105.123*/.getCreditos())),format.raw/*105.137*/("""  /  """),_display_(Seq[Any](/*105.143*/disciplina/*105.153*/.getDificuldade())),format.raw/*105.170*/("""</span>
					<br>
				""")))})),format.raw/*107.6*/("""
		""")))})),format.raw/*108.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*115.4*/for(disciplina <- naoAlocadas) yield /*115.34*/ {_display_(Seq[Any](format.raw/*115.36*/("""
			"""),_display_(Seq[Any](/*116.5*/if(disciplina.getPeriodoSugerido() == -2)/*116.46*/{_display_(Seq[Any](format.raw/*116.47*/("""
				<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*117.46*/disciplina/*117.56*/.getPreRequisitos())),format.raw/*117.75*/("""">"""),_display_(Seq[Any](/*117.78*/disciplina/*117.88*/.getNome())),format.raw/*117.98*/("""</a>   <span>"""),_display_(Seq[Any](/*117.112*/disciplina/*117.122*/.getCreditos())),format.raw/*117.136*/("""  /  """),_display_(Seq[Any](/*117.142*/disciplina/*117.152*/.getDificuldade())),format.raw/*117.169*/("""</span>
				<br>
			""")))})),format.raw/*119.5*/("""
		""")))})),format.raw/*120.4*/("""
	</div>
</div>
""")))})),format.raw/*123.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Object): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Object) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 27 15:46:51 BRT 2014
                    SOURCE: /home/karen/workspace/projeto-si1/app/views/index.scala.html
                    HASH: f08130f7db8d1f520b0d95112bcdf4057c161745
                    MATRIX: 805->1|991->77|1019->96|1055->98|1092->127|1131->129|1351->314|1391->338|1430->339|1494->367|1510->374|1544->386|1837->643|1903->693|1943->695|2030->746|2056->763|2095->780|2134->783|2161->800|2194->810|2245->824|2272->841|2309->855|2350->859|2377->876|2417->893|2480->924|2594->1003|2640->1040|2679->1041|2794->1125|2851->1146|2867->1153|2910->1174|2953->1181|2969->1188|3015->1212|3067->1229|3128->1281|3168->1283|3271->1355|3315->1368|3423->1441|3470->1479|3510->1481|3625->1564|3978->1882|4024->1912|4064->1914|4104->1919|4153->1959|4192->1960|4274->2006|4293->2016|4334->2035|4373->2038|4392->2048|4424->2058|4475->2072|4495->2082|4532->2096|4575->2102|4595->2112|4635->2129|4687->2150|4722->2154|4768->2165|4814->2195|4854->2197|4894->2202|4943->2242|4982->2243|5064->2289|5083->2299|5124->2318|5163->2321|5182->2331|5214->2341|5265->2355|5285->2365|5322->2379|5365->2385|5385->2395|5425->2412|5477->2433|5512->2437|5558->2448|5604->2478|5644->2480|5684->2485|5733->2525|5772->2526|5854->2572|5873->2582|5914->2601|5953->2604|5972->2614|6004->2624|6055->2638|6075->2648|6112->2662|6155->2668|6175->2678|6215->2695|6267->2716|6302->2720|6348->2731|6394->2761|6434->2763|6474->2768|6523->2808|6562->2809|6644->2855|6663->2865|6704->2884|6743->2887|6762->2897|6794->2907|6845->2921|6865->2931|6902->2945|6945->2951|6965->2961|7005->2978|7057->2999|7092->3003|7138->3014|7184->3044|7224->3046|7264->3051|7313->3091|7352->3092|7434->3138|7453->3148|7494->3167|7533->3170|7552->3180|7584->3190|7635->3204|7655->3214|7692->3228|7735->3234|7755->3244|7795->3261|7847->3282|7882->3286|7928->3297|7974->3327|8014->3329|8054->3334|8103->3374|8142->3375|8224->3421|8243->3431|8284->3450|8323->3453|8342->3463|8374->3473|8425->3487|8445->3497|8482->3511|8525->3517|8545->3527|8585->3544|8637->3565|8672->3569|8718->3580|8764->3610|8804->3612|8844->3617|8893->3657|8932->3658|9014->3704|9033->3714|9074->3733|9113->3736|9132->3746|9164->3756|9215->3770|9235->3780|9272->3794|9315->3800|9335->3810|9375->3827|9427->3848|9462->3852|9716->4070|9763->4100|9804->4102|9846->4108|9897->4149|9937->4150|10021->4197|10041->4207|10083->4226|10123->4229|10143->4239|10176->4249|10228->4263|10249->4273|10287->4287|10331->4293|10352->4303|10393->4320|10448->4343|10484->4347|10731->4558|10778->4588|10819->4590|10860->4595|10911->4636|10951->4637|11034->4683|11054->4693|11096->4712|11136->4715|11156->4725|11189->4735|11241->4749|11262->4759|11300->4773|11344->4779|11365->4789|11406->4806|11459->4827|11495->4831|11544->4848
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|41->13|41->13|41->13|44->16|44->16|44->16|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|45->17|47->19|50->22|50->22|50->22|52->24|53->25|53->25|53->25|53->25|53->25|53->25|55->27|55->27|55->27|57->29|59->31|64->36|64->36|64->36|66->38|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|79->51|81->53|82->54|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|88->60|89->61|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|93->65|93->65|93->65|93->65|93->65|93->65|93->65|93->65|93->65|95->67|96->68|98->70|98->70|98->70|99->71|99->71|99->71|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|100->72|102->74|103->75|105->77|105->77|105->77|106->78|106->78|106->78|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|107->79|109->81|110->82|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|114->86|116->88|117->89|119->91|119->91|119->91|120->92|120->92|120->92|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|123->95|124->96|131->103|131->103|131->103|132->104|132->104|132->104|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|133->105|135->107|136->108|143->115|143->115|143->115|144->116|144->116|144->116|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|145->117|147->119|148->120|151->123
                    -- GENERATED --
                */
            