
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Periodo],List[Disciplina],Planejador,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodos: List[Periodo], naoAlocadas: List[Disciplina], planejador: Planejador):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.82*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Planejamento de Curso")/*5.31*/ {_display_(Seq[Any](format.raw/*5.33*/("""

<a onclick="novoPeriodo('"""),_display_(Seq[Any](/*7.27*/planejador/*7.37*/.getTotalDePeriodos())),format.raw/*7.58*/("""')"><div id="botaoPeriodo">Novo Período</div></a>

<div id="top1"><!-- coluna de periodos -->
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*13.3*/for(periodo <- periodos) yield /*13.27*/{_display_(Seq[Any](format.raw/*13.28*/("""
		<div id="periodoBox">
			<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*15.32*/periodo/*15.39*/.getNumero())),format.raw/*15.51*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*15.112*/periodo/*15.119*/.getNumero())),format.raw/*15.131*/("""º</b> Período</div></a><!-- Numero do periodo -->
			<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			<div class="disc"><!-- Disciplinas do periodo -->
			    """),_display_(Seq[Any](/*18.9*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*18.59*/ {_display_(Seq[Any](format.raw/*18.61*/("""
			    	"""),_display_(Seq[Any](/*19.10*/if(disciplinaPeriodo.isAlocadaCorretamente())/*19.55*/ {_display_(Seq[Any](format.raw/*19.57*/("""
			    	   	<a title="Pré-requisitos: """),_display_(Seq[Any](/*20.40*/disciplinaPeriodo/*20.57*/.getPreRequisitos)),format.raw/*20.74*/("""">"""),_display_(Seq[Any](/*20.77*/disciplinaPeriodo/*20.94*/.getNome())),format.raw/*20.104*/(""" </a>  <span>"""),_display_(Seq[Any](/*20.118*/disciplinaPeriodo/*20.135*/.getCreditos())),format.raw/*20.149*/(""" / """),_display_(Seq[Any](/*20.153*/disciplinaPeriodo/*20.170*/.getDificuldade())),format.raw/*20.187*/("""</span>
			    		<br>
			    	""")))}/*22.11*/else/*22.16*/{_display_(Seq[Any](format.raw/*22.17*/("""
			    		<a class="discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*23.53*/disciplinaPeriodo/*23.70*/.getPreRequisitos)),format.raw/*23.87*/("""">"""),_display_(Seq[Any](/*23.90*/disciplinaPeriodo/*23.107*/.getNome())),format.raw/*23.117*/(""" </a>  <span>"""),_display_(Seq[Any](/*23.131*/disciplinaPeriodo/*23.148*/.getCreditos())),format.raw/*23.162*/(""" / """),_display_(Seq[Any](/*23.166*/disciplinaPeriodo/*23.183*/.getDificuldade())),format.raw/*23.200*/("""</span>
			    		<br>
			    	""")))})),format.raw/*25.10*/("""
			    """)))})),format.raw/*26.9*/("""
			</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*29.5*/if(periodo.getTotalDeCreditos() < 14)/*29.42*/{_display_(Seq[Any](format.raw/*29.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*31.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*32.20*/periodo/*32.27*/.getTotalDeCreditos())),format.raw/*32.48*/("""  /   """),_display_(Seq[Any](/*32.55*/periodo/*32.62*/.getTotalDeDificuldade())),format.raw/*32.86*/("""
			</div>
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*35.3*/("""
	
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*45.4*/for(disciplina <- naoAlocadas) yield /*45.34*/ {_display_(Seq[Any](format.raw/*45.36*/("""
			"""),_display_(Seq[Any](/*46.5*/if(disciplina.getPeriodoSugerido() == 1)/*46.45*/{_display_(Seq[Any](format.raw/*46.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*47.32*/disciplina/*47.42*/.getPreRequisitos())),format.raw/*47.61*/("""">"""),_display_(Seq[Any](/*47.64*/disciplina/*47.74*/.getNome())),format.raw/*47.84*/("""</a>   <span>"""),_display_(Seq[Any](/*47.98*/disciplina/*47.108*/.getCreditos())),format.raw/*47.122*/("""  /  """),_display_(Seq[Any](/*47.128*/disciplina/*47.138*/.getDificuldade())),format.raw/*47.155*/("""</span>
				<br>
			""")))})),format.raw/*49.5*/("""
		""")))})),format.raw/*50.4*/("""
		<br>
		
		"""),_display_(Seq[Any](/*53.4*/for(disciplina <- naoAlocadas) yield /*53.34*/ {_display_(Seq[Any](format.raw/*53.36*/("""
			"""),_display_(Seq[Any](/*54.5*/if(disciplina.getPeriodoSugerido() == 2)/*54.45*/{_display_(Seq[Any](format.raw/*54.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*55.32*/disciplina/*55.42*/.getPreRequisitos())),format.raw/*55.61*/("""">"""),_display_(Seq[Any](/*55.64*/disciplina/*55.74*/.getNome())),format.raw/*55.84*/("""</a>   <span>"""),_display_(Seq[Any](/*55.98*/disciplina/*55.108*/.getCreditos())),format.raw/*55.122*/("""  /  """),_display_(Seq[Any](/*55.128*/disciplina/*55.138*/.getDificuldade())),format.raw/*55.155*/("""</span>
				<br>
			""")))})),format.raw/*57.5*/("""
		""")))})),format.raw/*58.4*/("""
		<br>
		"""),_display_(Seq[Any](/*60.4*/for(disciplina <- naoAlocadas) yield /*60.34*/ {_display_(Seq[Any](format.raw/*60.36*/("""
			"""),_display_(Seq[Any](/*61.5*/if(disciplina.getPeriodoSugerido() == 3)/*61.45*/{_display_(Seq[Any](format.raw/*61.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*62.32*/disciplina/*62.42*/.getPreRequisitos())),format.raw/*62.61*/("""">"""),_display_(Seq[Any](/*62.64*/disciplina/*62.74*/.getNome())),format.raw/*62.84*/("""</a>   <span>"""),_display_(Seq[Any](/*62.98*/disciplina/*62.108*/.getCreditos())),format.raw/*62.122*/("""  /  """),_display_(Seq[Any](/*62.128*/disciplina/*62.138*/.getDificuldade())),format.raw/*62.155*/("""</span>
				<br>
			""")))})),format.raw/*64.5*/("""
		""")))})),format.raw/*65.4*/("""
		<br>
		"""),_display_(Seq[Any](/*67.4*/for(disciplina <- naoAlocadas) yield /*67.34*/ {_display_(Seq[Any](format.raw/*67.36*/("""
			"""),_display_(Seq[Any](/*68.5*/if(disciplina.getPeriodoSugerido() == 4)/*68.45*/{_display_(Seq[Any](format.raw/*68.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*69.32*/disciplina/*69.42*/.getPreRequisitos())),format.raw/*69.61*/("""">"""),_display_(Seq[Any](/*69.64*/disciplina/*69.74*/.getNome())),format.raw/*69.84*/("""</a>   <span>"""),_display_(Seq[Any](/*69.98*/disciplina/*69.108*/.getCreditos())),format.raw/*69.122*/("""  /  """),_display_(Seq[Any](/*69.128*/disciplina/*69.138*/.getDificuldade())),format.raw/*69.155*/("""</span>
				<br>
			""")))})),format.raw/*71.5*/("""
		""")))})),format.raw/*72.4*/("""
		<br>
		"""),_display_(Seq[Any](/*74.4*/for(disciplina <- naoAlocadas) yield /*74.34*/ {_display_(Seq[Any](format.raw/*74.36*/("""
			"""),_display_(Seq[Any](/*75.5*/if(disciplina.getPeriodoSugerido() == 5)/*75.45*/{_display_(Seq[Any](format.raw/*75.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*76.32*/disciplina/*76.42*/.getPreRequisitos())),format.raw/*76.61*/("""">"""),_display_(Seq[Any](/*76.64*/disciplina/*76.74*/.getNome())),format.raw/*76.84*/("""</a>   <span>"""),_display_(Seq[Any](/*76.98*/disciplina/*76.108*/.getCreditos())),format.raw/*76.122*/("""  /  """),_display_(Seq[Any](/*76.128*/disciplina/*76.138*/.getDificuldade())),format.raw/*76.155*/("""</span>
				<br>
			""")))})),format.raw/*78.5*/("""
		""")))})),format.raw/*79.4*/("""
		<br>
		"""),_display_(Seq[Any](/*81.4*/for(disciplina <- naoAlocadas) yield /*81.34*/ {_display_(Seq[Any](format.raw/*81.36*/("""
			"""),_display_(Seq[Any](/*82.5*/if(disciplina.getPeriodoSugerido() == 6)/*82.45*/{_display_(Seq[Any](format.raw/*82.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*83.32*/disciplina/*83.42*/.getPreRequisitos())),format.raw/*83.61*/("""">"""),_display_(Seq[Any](/*83.64*/disciplina/*83.74*/.getNome())),format.raw/*83.84*/("""</a>   <span>"""),_display_(Seq[Any](/*83.98*/disciplina/*83.108*/.getCreditos())),format.raw/*83.122*/("""  /  """),_display_(Seq[Any](/*83.128*/disciplina/*83.138*/.getDificuldade())),format.raw/*83.155*/("""</span>
				<br>
			""")))})),format.raw/*85.5*/("""
		""")))})),format.raw/*86.4*/("""
		<br>
		"""),_display_(Seq[Any](/*88.4*/for(disciplina <- naoAlocadas) yield /*88.34*/ {_display_(Seq[Any](format.raw/*88.36*/("""
			"""),_display_(Seq[Any](/*89.5*/if(disciplina.getPeriodoSugerido() == 7)/*89.45*/{_display_(Seq[Any](format.raw/*89.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*90.32*/disciplina/*90.42*/.getPreRequisitos())),format.raw/*90.61*/("""">"""),_display_(Seq[Any](/*90.64*/disciplina/*90.74*/.getNome())),format.raw/*90.84*/("""</a>   <span>"""),_display_(Seq[Any](/*90.98*/disciplina/*90.108*/.getCreditos())),format.raw/*90.122*/("""  /  """),_display_(Seq[Any](/*90.128*/disciplina/*90.138*/.getDificuldade())),format.raw/*90.155*/("""</span>
				<br>
			""")))})),format.raw/*92.5*/("""
		""")))})),format.raw/*93.4*/("""
		<br>
		"""),_display_(Seq[Any](/*95.4*/for(disciplina <- naoAlocadas) yield /*95.34*/ {_display_(Seq[Any](format.raw/*95.36*/("""
			"""),_display_(Seq[Any](/*96.5*/if(disciplina.getPeriodoSugerido() == 8)/*96.45*/{_display_(Seq[Any](format.raw/*96.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*97.32*/disciplina/*97.42*/.getPreRequisitos())),format.raw/*97.61*/("""">"""),_display_(Seq[Any](/*97.64*/disciplina/*97.74*/.getNome())),format.raw/*97.84*/("""</a>   <span>"""),_display_(Seq[Any](/*97.98*/disciplina/*97.108*/.getCreditos())),format.raw/*97.122*/("""  /  """),_display_(Seq[Any](/*97.128*/disciplina/*97.138*/.getDificuldade())),format.raw/*97.155*/("""</span>
				<br>
			""")))})),format.raw/*99.5*/("""
		""")))})),format.raw/*100.4*/("""
	</div>

	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*107.4*/for(disciplina <- naoAlocadas) yield /*107.34*/ {_display_(Seq[Any](format.raw/*107.36*/("""
			"""),_display_(Seq[Any](/*108.5*/if(disciplina.getPeriodoSugerido() == -2)/*108.46*/{_display_(Seq[Any](format.raw/*108.47*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*109.32*/disciplina/*109.42*/.getPreRequisitos())),format.raw/*109.61*/("""">"""),_display_(Seq[Any](/*109.64*/disciplina/*109.74*/.getNome())),format.raw/*109.84*/("""</a>   <span>"""),_display_(Seq[Any](/*109.98*/disciplina/*109.108*/.getCreditos())),format.raw/*109.122*/("""  /  """),_display_(Seq[Any](/*109.128*/disciplina/*109.138*/.getDificuldade())),format.raw/*109.155*/("""</span>
				<br>
			""")))})),format.raw/*111.5*/("""
		""")))})),format.raw/*112.4*/("""
	</div>
	
	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*119.4*/for(disciplina <- naoAlocadas) yield /*119.34*/ {_display_(Seq[Any](format.raw/*119.36*/("""
				"""),_display_(Seq[Any](/*120.6*/if(disciplina.getPeriodoSugerido() == -1)/*120.47*/{_display_(Seq[Any](format.raw/*120.48*/("""
					<a title="Pré-requisitos: """),_display_(Seq[Any](/*121.33*/disciplina/*121.43*/.getPreRequisitos())),format.raw/*121.62*/("""">"""),_display_(Seq[Any](/*121.65*/disciplina/*121.75*/.getNome())),format.raw/*121.85*/("""</a>   <span>"""),_display_(Seq[Any](/*121.99*/disciplina/*121.109*/.getCreditos())),format.raw/*121.123*/("""  /  """),_display_(Seq[Any](/*121.129*/disciplina/*121.139*/.getDificuldade())),format.raw/*121.156*/("""</span>
					<br>
				""")))})),format.raw/*123.6*/("""
		""")))})),format.raw/*124.4*/("""
	</div>
</div>
""")))})),format.raw/*127.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Planejador): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Planejador) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Mar 03 15:47:55 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/index.scala.html
                    HASH: c095c0764f3e0fca76ad5acc9cbbd59933d8ff71
                    MATRIX: 809->1|1000->81|1030->103|1067->106|1104->135|1143->137|1208->167|1226->177|1268->198|1475->370|1515->394|1554->395|1648->453|1664->460|1698->472|1796->533|1813->540|1848->552|2130->799|2196->849|2236->851|2283->862|2337->907|2377->909|2454->950|2480->967|2519->984|2558->987|2584->1004|2617->1014|2668->1028|2695->1045|2732->1059|2773->1063|2800->1080|2840->1097|2892->1131|2905->1136|2944->1137|3034->1191|3060->1208|3099->1225|3138->1228|3165->1245|3198->1255|3249->1269|3276->1286|3313->1300|3354->1304|3381->1321|3421->1338|3486->1371|3527->1381|3641->1460|3687->1497|3726->1498|3841->1582|3898->1603|3914->1610|3957->1631|4000->1638|4016->1645|4062->1669|4144->1720|4482->2023|4528->2053|4568->2055|4609->2061|4658->2101|4697->2102|4766->2135|4785->2145|4826->2164|4865->2167|4884->2177|4916->2187|4966->2201|4986->2211|5023->2225|5066->2231|5086->2241|5126->2258|5180->2281|5216->2286|5268->2303|5314->2333|5354->2335|5395->2341|5444->2381|5483->2382|5552->2415|5571->2425|5612->2444|5651->2447|5670->2457|5702->2467|5752->2481|5772->2491|5809->2505|5852->2511|5872->2521|5912->2538|5966->2561|6002->2566|6050->2579|6096->2609|6136->2611|6177->2617|6226->2657|6265->2658|6334->2691|6353->2701|6394->2720|6433->2723|6452->2733|6484->2743|6534->2757|6554->2767|6591->2781|6634->2787|6654->2797|6694->2814|6748->2837|6784->2842|6832->2855|6878->2885|6918->2887|6959->2893|7008->2933|7047->2934|7116->2967|7135->2977|7176->2996|7215->2999|7234->3009|7266->3019|7316->3033|7336->3043|7373->3057|7416->3063|7436->3073|7476->3090|7530->3113|7566->3118|7614->3131|7660->3161|7700->3163|7741->3169|7790->3209|7829->3210|7898->3243|7917->3253|7958->3272|7997->3275|8016->3285|8048->3295|8098->3309|8118->3319|8155->3333|8198->3339|8218->3349|8258->3366|8312->3389|8348->3394|8396->3407|8442->3437|8482->3439|8523->3445|8572->3485|8611->3486|8680->3519|8699->3529|8740->3548|8779->3551|8798->3561|8830->3571|8880->3585|8900->3595|8937->3609|8980->3615|9000->3625|9040->3642|9094->3665|9130->3670|9178->3683|9224->3713|9264->3715|9305->3721|9354->3761|9393->3762|9462->3795|9481->3805|9522->3824|9561->3827|9580->3837|9612->3847|9662->3861|9682->3871|9719->3885|9762->3891|9782->3901|9822->3918|9876->3941|9912->3946|9960->3959|10006->3989|10046->3991|10087->3997|10136->4037|10175->4038|10244->4071|10263->4081|10304->4100|10343->4103|10362->4113|10394->4123|10444->4137|10464->4147|10501->4161|10544->4167|10564->4177|10604->4194|10658->4217|10695->4222|10946->4437|10993->4467|11034->4469|11076->4475|11127->4516|11167->4517|11237->4550|11257->4560|11299->4579|11339->4582|11359->4592|11392->4602|11443->4616|11464->4626|11502->4640|11546->4646|11567->4656|11608->4673|11663->4696|11700->4701|11962->4927|12009->4957|12050->4959|12093->4966|12144->5007|12184->5008|12255->5042|12275->5052|12317->5071|12357->5074|12377->5084|12410->5094|12461->5108|12482->5118|12520->5132|12564->5138|12585->5148|12626->5165|12683->5190|12720->5195|12772->5215
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|41->13|41->13|41->13|43->15|43->15|43->15|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|51->23|53->25|54->26|57->29|57->29|57->29|59->31|60->32|60->32|60->32|60->32|60->32|60->32|63->35|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|83->55|85->57|86->58|88->60|88->60|88->60|89->61|89->61|89->61|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|90->62|92->64|93->65|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|97->69|99->71|100->72|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|104->76|106->78|107->79|109->81|109->81|109->81|110->82|110->82|110->82|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|111->83|113->85|114->86|116->88|116->88|116->88|117->89|117->89|117->89|118->90|118->90|118->90|118->90|118->90|118->90|118->90|118->90|118->90|118->90|118->90|118->90|120->92|121->93|123->95|123->95|123->95|124->96|124->96|124->96|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|125->97|127->99|128->100|135->107|135->107|135->107|136->108|136->108|136->108|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|137->109|139->111|140->112|147->119|147->119|147->119|148->120|148->120|148->120|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|149->121|151->123|152->124|155->127
                    -- GENERATED --
                */
            