
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
			<a onclick="editaPeriodo('"""),_display_(Seq[Any](/*14.31*/periodo/*14.38*/.getNumero())),format.raw/*14.50*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*14.111*/periodo/*14.118*/.getNumero())),format.raw/*14.130*/("""º</b> Período</div></a><!-- Numero do periodo -->
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
                    DATE: Sat Mar 01 15:07:43 GMT-03:00 2014
                    SOURCE: E:/Workspace/projeto-si1/app/views/index.scala.html
                    HASH: 7eff108247984f81b2f2d16940b7a1bd47ea108f
                    MATRIX: 805->1|992->77|1022->99|1059->102|1096->131|1135->133|1367->330|1407->354|1446->355|1539->412|1555->419|1589->431|1687->492|1704->499|1739->511|2021->758|2087->808|2127->810|2174->821|2228->866|2268->868|2345->909|2371->926|2410->943|2449->946|2475->963|2508->973|2559->987|2586->1004|2623->1018|2664->1022|2691->1039|2731->1056|2783->1090|2796->1095|2835->1096|2925->1150|2951->1167|2990->1184|3029->1187|3056->1204|3089->1214|3140->1228|3167->1245|3204->1259|3245->1263|3272->1280|3312->1297|3377->1330|3418->1340|3532->1419|3578->1456|3617->1457|3732->1541|3789->1562|3805->1569|3848->1590|3891->1597|3907->1604|3953->1628|4035->1679|4377->1986|4423->2016|4463->2018|4504->2024|4553->2064|4592->2065|4661->2098|4680->2108|4721->2127|4760->2130|4779->2140|4811->2150|4861->2164|4881->2174|4918->2188|4961->2194|4981->2204|5021->2221|5075->2244|5111->2249|5159->2262|5205->2292|5245->2294|5286->2300|5335->2340|5374->2341|5443->2374|5462->2384|5503->2403|5542->2406|5561->2416|5593->2426|5643->2440|5663->2450|5700->2464|5743->2470|5763->2480|5803->2497|5857->2520|5893->2525|5941->2538|5987->2568|6027->2570|6068->2576|6117->2616|6156->2617|6225->2650|6244->2660|6285->2679|6324->2682|6343->2692|6375->2702|6425->2716|6445->2726|6482->2740|6525->2746|6545->2756|6585->2773|6639->2796|6675->2801|6723->2814|6769->2844|6809->2846|6850->2852|6899->2892|6938->2893|7007->2926|7026->2936|7067->2955|7106->2958|7125->2968|7157->2978|7207->2992|7227->3002|7264->3016|7307->3022|7327->3032|7367->3049|7421->3072|7457->3077|7505->3090|7551->3120|7591->3122|7632->3128|7681->3168|7720->3169|7789->3202|7808->3212|7849->3231|7888->3234|7907->3244|7939->3254|7989->3268|8009->3278|8046->3292|8089->3298|8109->3308|8149->3325|8203->3348|8239->3353|8287->3366|8333->3396|8373->3398|8414->3404|8463->3444|8502->3445|8571->3478|8590->3488|8631->3507|8670->3510|8689->3520|8721->3530|8771->3544|8791->3554|8828->3568|8871->3574|8891->3584|8931->3601|8985->3624|9021->3629|9069->3642|9115->3672|9155->3674|9196->3680|9245->3720|9284->3721|9353->3754|9372->3764|9413->3783|9452->3786|9471->3796|9503->3806|9553->3820|9573->3830|9610->3844|9653->3850|9673->3860|9713->3877|9767->3900|9803->3905|10063->4130|10109->4160|10149->4162|10192->4169|10243->4210|10283->4211|10354->4245|10374->4255|10416->4274|10456->4277|10476->4287|10509->4297|10560->4311|10581->4321|10619->4335|10663->4341|10684->4351|10725->4368|10782->4393|10819->4398|11073->4616|11120->4646|11161->4648|11203->4654|11254->4695|11294->4696|11364->4729|11384->4739|11426->4758|11466->4761|11486->4771|11519->4781|11570->4795|11591->4805|11629->4819|11673->4825|11694->4835|11735->4852|11790->4875|11827->4880|11879->4900
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|40->12|40->12|40->12|42->14|42->14|42->14|42->14|42->14|42->14|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|50->22|52->24|53->25|56->28|56->28|56->28|58->30|59->31|59->31|59->31|59->31|59->31|59->31|62->34|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|84->56|85->57|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|91->63|92->64|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|99->71|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|105->77|106->78|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|112->84|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|119->91|120->92|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|131->103|132->104|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|147->119
                    -- GENERATED --
                */
            