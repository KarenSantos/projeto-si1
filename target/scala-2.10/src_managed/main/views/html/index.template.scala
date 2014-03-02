
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
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Object): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Object) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 14:47:57 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/index.scala.html
                    HASH: 99b721d12ffd556f4cafc794367917e122322dee
                    MATRIX: 805->1|992->77|1022->99|1059->102|1096->131|1135->133|1367->330|1407->354|1446->355|1540->413|1556->420|1590->432|1688->493|1705->500|1740->512|2022->759|2088->809|2128->811|2175->822|2229->867|2269->869|2346->910|2372->927|2411->944|2450->947|2476->964|2509->974|2560->988|2587->1005|2624->1019|2665->1023|2692->1040|2732->1057|2784->1091|2797->1096|2836->1097|2926->1151|2952->1168|2991->1185|3030->1188|3057->1205|3090->1215|3141->1229|3168->1246|3205->1260|3246->1264|3273->1281|3313->1298|3378->1331|3419->1341|3533->1420|3579->1457|3618->1458|3733->1542|3790->1563|3806->1570|3849->1591|3892->1598|3908->1605|3954->1629|4036->1680|4378->1987|4424->2017|4464->2019|4505->2025|4554->2065|4593->2066|4662->2099|4681->2109|4722->2128|4761->2131|4780->2141|4812->2151|4862->2165|4882->2175|4919->2189|4962->2195|4982->2205|5022->2222|5076->2245|5112->2250|5160->2263|5206->2293|5246->2295|5287->2301|5336->2341|5375->2342|5444->2375|5463->2385|5504->2404|5543->2407|5562->2417|5594->2427|5644->2441|5664->2451|5701->2465|5744->2471|5764->2481|5804->2498|5858->2521|5894->2526|5942->2539|5988->2569|6028->2571|6069->2577|6118->2617|6157->2618|6226->2651|6245->2661|6286->2680|6325->2683|6344->2693|6376->2703|6426->2717|6446->2727|6483->2741|6526->2747|6546->2757|6586->2774|6640->2797|6676->2802|6724->2815|6770->2845|6810->2847|6851->2853|6900->2893|6939->2894|7008->2927|7027->2937|7068->2956|7107->2959|7126->2969|7158->2979|7208->2993|7228->3003|7265->3017|7308->3023|7328->3033|7368->3050|7422->3073|7458->3078|7506->3091|7552->3121|7592->3123|7633->3129|7682->3169|7721->3170|7790->3203|7809->3213|7850->3232|7889->3235|7908->3245|7940->3255|7990->3269|8010->3279|8047->3293|8090->3299|8110->3309|8150->3326|8204->3349|8240->3354|8288->3367|8334->3397|8374->3399|8415->3405|8464->3445|8503->3446|8572->3479|8591->3489|8632->3508|8671->3511|8690->3521|8722->3531|8772->3545|8792->3555|8829->3569|8872->3575|8892->3585|8932->3602|8986->3625|9022->3630|9070->3643|9116->3673|9156->3675|9197->3681|9246->3721|9285->3722|9354->3755|9373->3765|9414->3784|9453->3787|9472->3797|9504->3807|9554->3821|9574->3831|9611->3845|9654->3851|9674->3861|9714->3878|9768->3901|9804->3906|10064->4131|10110->4161|10150->4163|10193->4170|10244->4211|10284->4212|10355->4246|10375->4256|10417->4275|10457->4278|10477->4288|10510->4298|10561->4312|10582->4322|10620->4336|10664->4342|10685->4352|10726->4369|10783->4394|10820->4399|11074->4617|11121->4647|11162->4649|11204->4655|11255->4696|11295->4697|11365->4730|11385->4740|11427->4759|11467->4762|11487->4772|11520->4782|11571->4796|11592->4806|11630->4820|11674->4826|11695->4836|11736->4853|11791->4876|11828->4881|11880->4901
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|53->25|56->28|56->28|56->28|58->30|59->31|59->31|59->31|59->31|59->31|59->31|62->34|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|84->56|85->57|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|91->63|92->64|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|99->71|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|105->77|106->78|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|112->84|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|119->91|120->92|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|131->103|132->104|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|147->119
                    -- GENERATED --
                */
            