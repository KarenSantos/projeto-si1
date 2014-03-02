
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

<div id="top1"><!-- coluna de periodos -->
	<a onclick="novoPeriodo('"""),_display_(Seq[Any](/*8.28*/planejador/*8.38*/.getTotalDePeriodos())),format.raw/*8.59*/("""+1')"><div id="novoPeriodo">Novo Período</div></a>
	<h2 style="border-bottom: none">Períodos</h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*12.3*/for(periodo <- periodos) yield /*12.27*/{_display_(Seq[Any](format.raw/*12.28*/("""
		<div id="periodoBox">
			<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*14.32*/periodo/*14.39*/.getNumero())),format.raw/*14.51*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*14.112*/periodo/*14.119*/.getNumero())),format.raw/*14.131*/("""º</b> Período</div></a><!-- Numero do periodo -->
			<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			<div class="disc"><!-- Disciplinas do periodo -->
			    """),_display_(Seq[Any](/*17.9*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*17.59*/ {_display_(Seq[Any](format.raw/*17.61*/("""
			    	"""),_display_(Seq[Any](/*18.10*/if(disciplinaPeriodo.isAlocadaCorretamente())/*18.55*/ {_display_(Seq[Any](format.raw/*18.57*/("""
			    	   	<a title="Pré-requisitos: """),_display_(Seq[Any](/*19.40*/disciplinaPeriodo/*19.57*/.getPreRequisitos)),format.raw/*19.74*/("""">"""),_display_(Seq[Any](/*19.77*/disciplinaPeriodo/*19.94*/.getNome())),format.raw/*19.104*/(""" </a>  <span>"""),_display_(Seq[Any](/*19.118*/disciplinaPeriodo/*19.135*/.getCreditos())),format.raw/*19.149*/(""" / """),_display_(Seq[Any](/*19.153*/disciplinaPeriodo/*19.170*/.getDificuldade())),format.raw/*19.187*/("""</span>
			    		<br>
			    	""")))}/*21.11*/else/*21.16*/{_display_(Seq[Any](format.raw/*21.17*/("""
			    		<a class="discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*22.53*/disciplinaPeriodo/*22.70*/.getPreRequisitos)),format.raw/*22.87*/("""">"""),_display_(Seq[Any](/*22.90*/disciplinaPeriodo/*22.107*/.getNome())),format.raw/*22.117*/(""" </a>  <span>"""),_display_(Seq[Any](/*22.131*/disciplinaPeriodo/*22.148*/.getCreditos())),format.raw/*22.162*/(""" / """),_display_(Seq[Any](/*22.166*/disciplinaPeriodo/*22.183*/.getDificuldade())),format.raw/*22.200*/("""</span>
			    		<br>
			    	""")))})),format.raw/*24.10*/("""
			    """)))})),format.raw/*25.9*/("""
			</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*28.5*/if(periodo.getTotalDeCreditos() < 14)/*28.42*/{_display_(Seq[Any](format.raw/*28.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*30.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*31.20*/periodo/*31.27*/.getTotalDeCreditos())),format.raw/*31.48*/("""  /   """),_display_(Seq[Any](/*31.55*/periodo/*31.62*/.getTotalDeDificuldade())),format.raw/*31.86*/("""
			</div>
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*34.3*/("""
	
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*45.4*/for(disciplina <- naoAlocadas) yield /*45.34*/ {_display_(Seq[Any](format.raw/*45.36*/("""
			"""),_display_(Seq[Any](/*46.5*/if(disciplina.getPeriodoSugerido() == 2)/*46.45*/{_display_(Seq[Any](format.raw/*46.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*47.32*/disciplina/*47.42*/.getPreRequisitos())),format.raw/*47.61*/("""">"""),_display_(Seq[Any](/*47.64*/disciplina/*47.74*/.getNome())),format.raw/*47.84*/("""</a>   <span>"""),_display_(Seq[Any](/*47.98*/disciplina/*47.108*/.getCreditos())),format.raw/*47.122*/("""  /  """),_display_(Seq[Any](/*47.128*/disciplina/*47.138*/.getDificuldade())),format.raw/*47.155*/("""</span>
				<br>
			""")))})),format.raw/*49.5*/("""
		""")))})),format.raw/*50.4*/("""
		<br>
		"""),_display_(Seq[Any](/*52.4*/for(disciplina <- naoAlocadas) yield /*52.34*/ {_display_(Seq[Any](format.raw/*52.36*/("""
			"""),_display_(Seq[Any](/*53.5*/if(disciplina.getPeriodoSugerido() == 3)/*53.45*/{_display_(Seq[Any](format.raw/*53.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*54.32*/disciplina/*54.42*/.getPreRequisitos())),format.raw/*54.61*/("""">"""),_display_(Seq[Any](/*54.64*/disciplina/*54.74*/.getNome())),format.raw/*54.84*/("""</a>   <span>"""),_display_(Seq[Any](/*54.98*/disciplina/*54.108*/.getCreditos())),format.raw/*54.122*/("""  /  """),_display_(Seq[Any](/*54.128*/disciplina/*54.138*/.getDificuldade())),format.raw/*54.155*/("""</span>
				<br>
			""")))})),format.raw/*56.5*/("""
		""")))})),format.raw/*57.4*/("""
		<br>
		"""),_display_(Seq[Any](/*59.4*/for(disciplina <- naoAlocadas) yield /*59.34*/ {_display_(Seq[Any](format.raw/*59.36*/("""
			"""),_display_(Seq[Any](/*60.5*/if(disciplina.getPeriodoSugerido() == 4)/*60.45*/{_display_(Seq[Any](format.raw/*60.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*61.32*/disciplina/*61.42*/.getPreRequisitos())),format.raw/*61.61*/("""">"""),_display_(Seq[Any](/*61.64*/disciplina/*61.74*/.getNome())),format.raw/*61.84*/("""</a>   <span>"""),_display_(Seq[Any](/*61.98*/disciplina/*61.108*/.getCreditos())),format.raw/*61.122*/("""  /  """),_display_(Seq[Any](/*61.128*/disciplina/*61.138*/.getDificuldade())),format.raw/*61.155*/("""</span>
				<br>
			""")))})),format.raw/*63.5*/("""
		""")))})),format.raw/*64.4*/("""
		<br>
		"""),_display_(Seq[Any](/*66.4*/for(disciplina <- naoAlocadas) yield /*66.34*/ {_display_(Seq[Any](format.raw/*66.36*/("""
			"""),_display_(Seq[Any](/*67.5*/if(disciplina.getPeriodoSugerido() == 5)/*67.45*/{_display_(Seq[Any](format.raw/*67.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*68.32*/disciplina/*68.42*/.getPreRequisitos())),format.raw/*68.61*/("""">"""),_display_(Seq[Any](/*68.64*/disciplina/*68.74*/.getNome())),format.raw/*68.84*/("""</a>   <span>"""),_display_(Seq[Any](/*68.98*/disciplina/*68.108*/.getCreditos())),format.raw/*68.122*/("""  /  """),_display_(Seq[Any](/*68.128*/disciplina/*68.138*/.getDificuldade())),format.raw/*68.155*/("""</span>
				<br>
			""")))})),format.raw/*70.5*/("""
		""")))})),format.raw/*71.4*/("""
		<br>
		"""),_display_(Seq[Any](/*73.4*/for(disciplina <- naoAlocadas) yield /*73.34*/ {_display_(Seq[Any](format.raw/*73.36*/("""
			"""),_display_(Seq[Any](/*74.5*/if(disciplina.getPeriodoSugerido() == 6)/*74.45*/{_display_(Seq[Any](format.raw/*74.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*75.32*/disciplina/*75.42*/.getPreRequisitos())),format.raw/*75.61*/("""">"""),_display_(Seq[Any](/*75.64*/disciplina/*75.74*/.getNome())),format.raw/*75.84*/("""</a>   <span>"""),_display_(Seq[Any](/*75.98*/disciplina/*75.108*/.getCreditos())),format.raw/*75.122*/("""  /  """),_display_(Seq[Any](/*75.128*/disciplina/*75.138*/.getDificuldade())),format.raw/*75.155*/("""</span>
				<br>
			""")))})),format.raw/*77.5*/("""
		""")))})),format.raw/*78.4*/("""
		<br>
		"""),_display_(Seq[Any](/*80.4*/for(disciplina <- naoAlocadas) yield /*80.34*/ {_display_(Seq[Any](format.raw/*80.36*/("""
			"""),_display_(Seq[Any](/*81.5*/if(disciplina.getPeriodoSugerido() == 7)/*81.45*/{_display_(Seq[Any](format.raw/*81.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*82.32*/disciplina/*82.42*/.getPreRequisitos())),format.raw/*82.61*/("""">"""),_display_(Seq[Any](/*82.64*/disciplina/*82.74*/.getNome())),format.raw/*82.84*/("""</a>   <span>"""),_display_(Seq[Any](/*82.98*/disciplina/*82.108*/.getCreditos())),format.raw/*82.122*/("""  /  """),_display_(Seq[Any](/*82.128*/disciplina/*82.138*/.getDificuldade())),format.raw/*82.155*/("""</span>
				<br>
			""")))})),format.raw/*84.5*/("""
		""")))})),format.raw/*85.4*/("""
		<br>
		"""),_display_(Seq[Any](/*87.4*/for(disciplina <- naoAlocadas) yield /*87.34*/ {_display_(Seq[Any](format.raw/*87.36*/("""
			"""),_display_(Seq[Any](/*88.5*/if(disciplina.getPeriodoSugerido() == 8)/*88.45*/{_display_(Seq[Any](format.raw/*88.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*89.32*/disciplina/*89.42*/.getPreRequisitos())),format.raw/*89.61*/("""">"""),_display_(Seq[Any](/*89.64*/disciplina/*89.74*/.getNome())),format.raw/*89.84*/("""</a>   <span>"""),_display_(Seq[Any](/*89.98*/disciplina/*89.108*/.getCreditos())),format.raw/*89.122*/("""  /  """),_display_(Seq[Any](/*89.128*/disciplina/*89.138*/.getDificuldade())),format.raw/*89.155*/("""</span>
				<br>
			""")))})),format.raw/*91.5*/("""
		""")))})),format.raw/*92.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*99.4*/for(disciplina <- naoAlocadas) yield /*99.34*/ {_display_(Seq[Any](format.raw/*99.36*/("""
				"""),_display_(Seq[Any](/*100.6*/if(disciplina.getPeriodoSugerido() == -1)/*100.47*/{_display_(Seq[Any](format.raw/*100.48*/("""
					<a title="Pré-requisitos: """),_display_(Seq[Any](/*101.33*/disciplina/*101.43*/.getPreRequisitos())),format.raw/*101.62*/("""">"""),_display_(Seq[Any](/*101.65*/disciplina/*101.75*/.getNome())),format.raw/*101.85*/("""</a>   <span>"""),_display_(Seq[Any](/*101.99*/disciplina/*101.109*/.getCreditos())),format.raw/*101.123*/("""  /  """),_display_(Seq[Any](/*101.129*/disciplina/*101.139*/.getDificuldade())),format.raw/*101.156*/("""</span>
					<br>
				""")))})),format.raw/*103.6*/("""
		""")))})),format.raw/*104.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*111.4*/for(disciplina <- naoAlocadas) yield /*111.34*/ {_display_(Seq[Any](format.raw/*111.36*/("""
			"""),_display_(Seq[Any](/*112.5*/if(disciplina.getPeriodoSugerido() == -2)/*112.46*/{_display_(Seq[Any](format.raw/*112.47*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*113.32*/disciplina/*113.42*/.getPreRequisitos())),format.raw/*113.61*/("""">"""),_display_(Seq[Any](/*113.64*/disciplina/*113.74*/.getNome())),format.raw/*113.84*/("""</a>   <span>"""),_display_(Seq[Any](/*113.98*/disciplina/*113.108*/.getCreditos())),format.raw/*113.122*/("""  /  """),_display_(Seq[Any](/*113.128*/disciplina/*113.138*/.getDificuldade())),format.raw/*113.155*/("""</span>
				<br>
			""")))})),format.raw/*115.5*/("""
		""")))})),format.raw/*116.4*/("""
	</div>
</div>
""")))})),format.raw/*119.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Planejador): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Planejador) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 15:44:35 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/index.scala.html
                    HASH: f7a3b67ad40923e318eeaec0763ccffe22d68cb2
                    MATRIX: 809->1|1000->81|1030->103|1067->106|1104->135|1143->137|1253->212|1271->222|1313->243|1475->370|1515->394|1554->395|1648->453|1664->460|1698->472|1796->533|1813->540|1848->552|2130->799|2196->849|2236->851|2283->862|2337->907|2377->909|2454->950|2480->967|2519->984|2558->987|2584->1004|2617->1014|2668->1028|2695->1045|2732->1059|2773->1063|2800->1080|2840->1097|2892->1131|2905->1136|2944->1137|3034->1191|3060->1208|3099->1225|3138->1228|3165->1245|3198->1255|3249->1269|3276->1286|3313->1300|3354->1304|3381->1321|3421->1338|3486->1371|3527->1381|3641->1460|3687->1497|3726->1498|3841->1582|3898->1603|3914->1610|3957->1631|4000->1638|4016->1645|4062->1669|4144->1720|4486->2027|4532->2057|4572->2059|4613->2065|4662->2105|4701->2106|4770->2139|4789->2149|4830->2168|4869->2171|4888->2181|4920->2191|4970->2205|4990->2215|5027->2229|5070->2235|5090->2245|5130->2262|5184->2285|5220->2290|5268->2303|5314->2333|5354->2335|5395->2341|5444->2381|5483->2382|5552->2415|5571->2425|5612->2444|5651->2447|5670->2457|5702->2467|5752->2481|5772->2491|5809->2505|5852->2511|5872->2521|5912->2538|5966->2561|6002->2566|6050->2579|6096->2609|6136->2611|6177->2617|6226->2657|6265->2658|6334->2691|6353->2701|6394->2720|6433->2723|6452->2733|6484->2743|6534->2757|6554->2767|6591->2781|6634->2787|6654->2797|6694->2814|6748->2837|6784->2842|6832->2855|6878->2885|6918->2887|6959->2893|7008->2933|7047->2934|7116->2967|7135->2977|7176->2996|7215->2999|7234->3009|7266->3019|7316->3033|7336->3043|7373->3057|7416->3063|7436->3073|7476->3090|7530->3113|7566->3118|7614->3131|7660->3161|7700->3163|7741->3169|7790->3209|7829->3210|7898->3243|7917->3253|7958->3272|7997->3275|8016->3285|8048->3295|8098->3309|8118->3319|8155->3333|8198->3339|8218->3349|8258->3366|8312->3389|8348->3394|8396->3407|8442->3437|8482->3439|8523->3445|8572->3485|8611->3486|8680->3519|8699->3529|8740->3548|8779->3551|8798->3561|8830->3571|8880->3585|8900->3595|8937->3609|8980->3615|9000->3625|9040->3642|9094->3665|9130->3670|9178->3683|9224->3713|9264->3715|9305->3721|9354->3761|9393->3762|9462->3795|9481->3805|9522->3824|9561->3827|9580->3837|9612->3847|9662->3861|9682->3871|9719->3885|9762->3891|9782->3901|9822->3918|9876->3941|9912->3946|10172->4171|10218->4201|10258->4203|10301->4210|10352->4251|10392->4252|10463->4286|10483->4296|10525->4315|10565->4318|10585->4328|10618->4338|10669->4352|10690->4362|10728->4376|10772->4382|10793->4392|10834->4409|10891->4434|10928->4439|11182->4657|11229->4687|11270->4689|11312->4695|11363->4736|11403->4737|11473->4770|11493->4780|11535->4799|11575->4802|11595->4812|11628->4822|11679->4836|11700->4846|11738->4860|11782->4866|11803->4876|11844->4893|11899->4916|11936->4921|11988->4941
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|36->8|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|53->25|56->28|56->28|56->28|58->30|59->31|59->31|59->31|59->31|59->31|59->31|62->34|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|84->56|85->57|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|91->63|92->64|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|99->71|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|105->77|106->78|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|112->84|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|119->91|120->92|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|131->103|132->104|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|147->119
                    -- GENERATED --
                */
            