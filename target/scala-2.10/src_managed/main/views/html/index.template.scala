
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

	"""),_display_(Seq[Any](/*9.3*/for(periodo <- periodos) yield /*9.27*/{_display_(Seq[Any](format.raw/*9.28*/("""
		<div id="periodoBox">
			<div class="numPriodo">"""),_display_(Seq[Any](/*11.28*/periodo/*11.35*/.getNumero())),format.raw/*11.47*/("""º Período</div><!-- Numero do periodo -->
				<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
				<div class="disc"><!-- Disciplinas do periodo -->
				    """),_display_(Seq[Any](/*14.10*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*14.60*/ {_display_(Seq[Any](format.raw/*14.62*/("""
				    	<a class="cada1" title="Pré-requisitos: """),_display_(Seq[Any](/*15.51*/disciplinaPeriodo/*15.68*/.getPreRequisitos)),format.raw/*15.85*/("""">"""),_display_(Seq[Any](/*15.88*/disciplinaPeriodo/*15.105*/.getNome())),format.raw/*15.115*/(""" </a>  <span>"""),_display_(Seq[Any](/*15.129*/disciplinaPeriodo/*15.146*/.getCreditos())),format.raw/*15.160*/(""" / """),_display_(Seq[Any](/*15.164*/disciplinaPeriodo/*15.181*/.getDificuldade())),format.raw/*15.198*/("""</span>
				    	<br>
				    """)))})),format.raw/*17.10*/("""
				</div>
				<div class="totalC"><!-- Total de créditos do periodo -->
				"""),_display_(Seq[Any](/*20.6*/if(periodo.getTotalDeCreditos() < 14)/*20.43*/{_display_(Seq[Any](format.raw/*20.44*/("""
					<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
				""")))})),format.raw/*22.6*/("""
					<b>Total: </b>"""),_display_(Seq[Any](/*23.21*/periodo/*23.28*/.getTotalDeCreditos())),format.raw/*23.49*/("""  /   """),_display_(Seq[Any](/*23.56*/periodo/*23.63*/.getTotalDeDificuldade())),format.raw/*23.87*/("""
				</div>
				"""),_display_(Seq[Any](/*25.6*/form(routes.Application.editar(periodo.getNumero()))/*25.58*/ {_display_(Seq[Any](format.raw/*25.60*/("""
					<input class="addDisc" type="submit" value="Editar período">
				""")))})),format.raw/*27.6*/("""
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*29.3*/("""
	
	<div id="addPeriodo">
		 """),_display_(Seq[Any](/*32.5*/form(routes.Application.novoPeriodo())/*32.43*/ {_display_(Seq[Any](format.raw/*32.45*/("""
              <input class="bAdd" type="submit" value="+ Novo Periodo">
         """)))})),format.raw/*34.11*/(""" 
	</div><!-- div para criar novo periodo -->
</div>

<div id="col3"><h2>Disciplinas</h2><!-- coluna de disciplinas -->

	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		
		"""),_display_(Seq[Any](/*45.4*/for(disciplina <- naoAlocadas) yield /*45.34*/ {_display_(Seq[Any](format.raw/*45.36*/("""
			"""),_display_(Seq[Any](/*46.5*/if(disciplina.getPeriodoSugerido() == 2)/*46.45*/{_display_(Seq[Any](format.raw/*46.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*47.46*/disciplina/*47.56*/.getPreRequisitos())),format.raw/*47.75*/("""">"""),_display_(Seq[Any](/*47.78*/disciplina/*47.88*/.getNome())),format.raw/*47.98*/("""</a>   <span>"""),_display_(Seq[Any](/*47.112*/disciplina/*47.122*/.getCreditos())),format.raw/*47.136*/("""  /  """),_display_(Seq[Any](/*47.142*/disciplina/*47.152*/.getDificuldade())),format.raw/*47.169*/("""</span>
				<br>
			""")))})),format.raw/*49.5*/("""
		""")))})),format.raw/*50.4*/("""
		<br>
		"""),_display_(Seq[Any](/*52.4*/for(disciplina <- naoAlocadas) yield /*52.34*/ {_display_(Seq[Any](format.raw/*52.36*/("""
			"""),_display_(Seq[Any](/*53.5*/if(disciplina.getPeriodoSugerido() == 3)/*53.45*/{_display_(Seq[Any](format.raw/*53.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*54.46*/disciplina/*54.56*/.getPreRequisitos())),format.raw/*54.75*/("""">"""),_display_(Seq[Any](/*54.78*/disciplina/*54.88*/.getNome())),format.raw/*54.98*/("""</a>   <span>"""),_display_(Seq[Any](/*54.112*/disciplina/*54.122*/.getCreditos())),format.raw/*54.136*/("""  /  """),_display_(Seq[Any](/*54.142*/disciplina/*54.152*/.getDificuldade())),format.raw/*54.169*/("""</span>
				<br>
			""")))})),format.raw/*56.5*/("""
		""")))})),format.raw/*57.4*/("""
		<br>
		"""),_display_(Seq[Any](/*59.4*/for(disciplina <- naoAlocadas) yield /*59.34*/ {_display_(Seq[Any](format.raw/*59.36*/("""
			"""),_display_(Seq[Any](/*60.5*/if(disciplina.getPeriodoSugerido() == 4)/*60.45*/{_display_(Seq[Any](format.raw/*60.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*61.46*/disciplina/*61.56*/.getPreRequisitos())),format.raw/*61.75*/("""">"""),_display_(Seq[Any](/*61.78*/disciplina/*61.88*/.getNome())),format.raw/*61.98*/("""</a>   <span>"""),_display_(Seq[Any](/*61.112*/disciplina/*61.122*/.getCreditos())),format.raw/*61.136*/("""  /  """),_display_(Seq[Any](/*61.142*/disciplina/*61.152*/.getDificuldade())),format.raw/*61.169*/("""</span>
				<br>
			""")))})),format.raw/*63.5*/("""
		""")))})),format.raw/*64.4*/("""
		<br>
		"""),_display_(Seq[Any](/*66.4*/for(disciplina <- naoAlocadas) yield /*66.34*/ {_display_(Seq[Any](format.raw/*66.36*/("""
			"""),_display_(Seq[Any](/*67.5*/if(disciplina.getPeriodoSugerido() == 5)/*67.45*/{_display_(Seq[Any](format.raw/*67.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*68.46*/disciplina/*68.56*/.getPreRequisitos())),format.raw/*68.75*/("""">"""),_display_(Seq[Any](/*68.78*/disciplina/*68.88*/.getNome())),format.raw/*68.98*/("""</a>   <span>"""),_display_(Seq[Any](/*68.112*/disciplina/*68.122*/.getCreditos())),format.raw/*68.136*/("""  /  """),_display_(Seq[Any](/*68.142*/disciplina/*68.152*/.getDificuldade())),format.raw/*68.169*/("""</span>
				<br>
			""")))})),format.raw/*70.5*/("""
		""")))})),format.raw/*71.4*/("""
		<br>
		"""),_display_(Seq[Any](/*73.4*/for(disciplina <- naoAlocadas) yield /*73.34*/ {_display_(Seq[Any](format.raw/*73.36*/("""
			"""),_display_(Seq[Any](/*74.5*/if(disciplina.getPeriodoSugerido() == 6)/*74.45*/{_display_(Seq[Any](format.raw/*74.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*75.46*/disciplina/*75.56*/.getPreRequisitos())),format.raw/*75.75*/("""">"""),_display_(Seq[Any](/*75.78*/disciplina/*75.88*/.getNome())),format.raw/*75.98*/("""</a>   <span>"""),_display_(Seq[Any](/*75.112*/disciplina/*75.122*/.getCreditos())),format.raw/*75.136*/("""  /  """),_display_(Seq[Any](/*75.142*/disciplina/*75.152*/.getDificuldade())),format.raw/*75.169*/("""</span>
				<br>
			""")))})),format.raw/*77.5*/("""
		""")))})),format.raw/*78.4*/("""
		<br>
		"""),_display_(Seq[Any](/*80.4*/for(disciplina <- naoAlocadas) yield /*80.34*/ {_display_(Seq[Any](format.raw/*80.36*/("""
			"""),_display_(Seq[Any](/*81.5*/if(disciplina.getPeriodoSugerido() == 7)/*81.45*/{_display_(Seq[Any](format.raw/*81.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*82.46*/disciplina/*82.56*/.getPreRequisitos())),format.raw/*82.75*/("""">"""),_display_(Seq[Any](/*82.78*/disciplina/*82.88*/.getNome())),format.raw/*82.98*/("""</a>   <span>"""),_display_(Seq[Any](/*82.112*/disciplina/*82.122*/.getCreditos())),format.raw/*82.136*/("""  /  """),_display_(Seq[Any](/*82.142*/disciplina/*82.152*/.getDificuldade())),format.raw/*82.169*/("""</span>
				<br>
			""")))})),format.raw/*84.5*/("""
		""")))})),format.raw/*85.4*/("""
		<br>
		"""),_display_(Seq[Any](/*87.4*/for(disciplina <- naoAlocadas) yield /*87.34*/ {_display_(Seq[Any](format.raw/*87.36*/("""
			"""),_display_(Seq[Any](/*88.5*/if(disciplina.getPeriodoSugerido() == 8)/*88.45*/{_display_(Seq[Any](format.raw/*88.46*/("""
				<a class="cada2" title="Pré-requisitos: """),_display_(Seq[Any](/*89.46*/disciplina/*89.56*/.getPreRequisitos())),format.raw/*89.75*/("""">"""),_display_(Seq[Any](/*89.78*/disciplina/*89.88*/.getNome())),format.raw/*89.98*/("""</a>   <span>"""),_display_(Seq[Any](/*89.112*/disciplina/*89.122*/.getCreditos())),format.raw/*89.136*/("""  /  """),_display_(Seq[Any](/*89.142*/disciplina/*89.152*/.getDificuldade())),format.raw/*89.169*/("""</span>
				<br>
			""")))})),format.raw/*91.5*/("""
		""")))})),format.raw/*92.4*/("""
	</div>

	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*99.4*/for(disciplina <- naoAlocadas) yield /*99.34*/ {_display_(Seq[Any](format.raw/*99.36*/("""
				"""),_display_(Seq[Any](/*100.6*/if(disciplina.getPeriodoSugerido() == -1)/*100.47*/{_display_(Seq[Any](format.raw/*100.48*/("""
					<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*101.47*/disciplina/*101.57*/.getPreRequisitos())),format.raw/*101.76*/("""">"""),_display_(Seq[Any](/*101.79*/disciplina/*101.89*/.getNome())),format.raw/*101.99*/("""</a>   <span>"""),_display_(Seq[Any](/*101.113*/disciplina/*101.123*/.getCreditos())),format.raw/*101.137*/("""  /  """),_display_(Seq[Any](/*101.143*/disciplina/*101.153*/.getDificuldade())),format.raw/*101.170*/("""</span>
					<br>
				""")))})),format.raw/*103.6*/("""
		""")))})),format.raw/*104.4*/("""
	</div>
			
	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*111.4*/for(disciplina <- naoAlocadas) yield /*111.34*/ {_display_(Seq[Any](format.raw/*111.36*/("""
			"""),_display_(Seq[Any](/*112.5*/if(disciplina.getPeriodoSugerido() == -2)/*112.46*/{_display_(Seq[Any](format.raw/*112.47*/("""
				<a class="cada3" title="Pré-requisitos: """),_display_(Seq[Any](/*113.46*/disciplina/*113.56*/.getPreRequisitos())),format.raw/*113.75*/("""">"""),_display_(Seq[Any](/*113.78*/disciplina/*113.88*/.getNome())),format.raw/*113.98*/("""</a>   <span>"""),_display_(Seq[Any](/*113.112*/disciplina/*113.122*/.getCreditos())),format.raw/*113.136*/("""  /  """),_display_(Seq[Any](/*113.142*/disciplina/*113.152*/.getDificuldade())),format.raw/*113.169*/("""</span>
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
                    DATE: Thu Feb 27 15:57:52 BRT 2014
                    SOURCE: /home/karen/workspace/projeto-si1/app/views/index.scala.html
                    HASH: 186517339e894731a4afdb0feede8914a558faf3
                    MATRIX: 805->1|991->77|1019->96|1055->98|1092->127|1131->129|1258->222|1297->246|1335->247|1423->299|1439->306|1473->318|1748->557|1814->607|1854->609|1941->660|1967->677|2006->694|2045->697|2072->714|2105->724|2156->738|2183->755|2220->769|2261->773|2288->790|2328->807|2391->838|2505->917|2551->954|2590->955|2705->1039|2762->1060|2778->1067|2821->1088|2864->1095|2880->1102|2926->1126|2978->1143|3039->1195|3079->1197|3182->1269|3251->1307|3316->1337|3363->1375|3403->1377|3518->1460|3871->1778|3917->1808|3957->1810|3997->1815|4046->1855|4085->1856|4167->1902|4186->1912|4227->1931|4266->1934|4285->1944|4317->1954|4368->1968|4388->1978|4425->1992|4468->1998|4488->2008|4528->2025|4580->2046|4615->2050|4661->2061|4707->2091|4747->2093|4787->2098|4836->2138|4875->2139|4957->2185|4976->2195|5017->2214|5056->2217|5075->2227|5107->2237|5158->2251|5178->2261|5215->2275|5258->2281|5278->2291|5318->2308|5370->2329|5405->2333|5451->2344|5497->2374|5537->2376|5577->2381|5626->2421|5665->2422|5747->2468|5766->2478|5807->2497|5846->2500|5865->2510|5897->2520|5948->2534|5968->2544|6005->2558|6048->2564|6068->2574|6108->2591|6160->2612|6195->2616|6241->2627|6287->2657|6327->2659|6367->2664|6416->2704|6455->2705|6537->2751|6556->2761|6597->2780|6636->2783|6655->2793|6687->2803|6738->2817|6758->2827|6795->2841|6838->2847|6858->2857|6898->2874|6950->2895|6985->2899|7031->2910|7077->2940|7117->2942|7157->2947|7206->2987|7245->2988|7327->3034|7346->3044|7387->3063|7426->3066|7445->3076|7477->3086|7528->3100|7548->3110|7585->3124|7628->3130|7648->3140|7688->3157|7740->3178|7775->3182|7821->3193|7867->3223|7907->3225|7947->3230|7996->3270|8035->3271|8117->3317|8136->3327|8177->3346|8216->3349|8235->3359|8267->3369|8318->3383|8338->3393|8375->3407|8418->3413|8438->3423|8478->3440|8530->3461|8565->3465|8611->3476|8657->3506|8697->3508|8737->3513|8786->3553|8825->3554|8907->3600|8926->3610|8967->3629|9006->3632|9025->3642|9057->3652|9108->3666|9128->3676|9165->3690|9208->3696|9228->3706|9268->3723|9320->3744|9355->3748|9608->3966|9654->3996|9694->3998|9736->4004|9787->4045|9827->4046|9911->4093|9931->4103|9973->4122|10013->4125|10033->4135|10066->4145|10118->4159|10139->4169|10177->4183|10221->4189|10242->4199|10283->4216|10338->4239|10374->4243|10621->4454|10668->4484|10709->4486|10750->4491|10801->4532|10841->4533|10924->4579|10944->4589|10986->4608|11026->4611|11046->4621|11079->4631|11131->4645|11152->4655|11190->4669|11234->4675|11255->4685|11296->4702|11349->4723|11385->4727|11434->4744
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|39->11|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|43->15|45->17|48->20|48->20|48->20|50->22|51->23|51->23|51->23|51->23|51->23|51->23|53->25|53->25|53->25|55->27|57->29|60->32|60->32|60->32|62->34|73->45|73->45|73->45|74->46|74->46|74->46|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|75->47|77->49|78->50|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|82->54|84->56|85->57|87->59|87->59|87->59|88->60|88->60|88->60|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|89->61|91->63|92->64|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|99->71|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|105->77|106->78|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|112->84|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|119->91|120->92|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|129->101|131->103|132->104|139->111|139->111|139->111|140->112|140->112|140->112|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|141->113|143->115|144->116|147->119
                    -- GENERATED --
                */
            