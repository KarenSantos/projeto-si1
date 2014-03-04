
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
	"""),_display_(Seq[Any](/*10.3*/if(planejador.isInvertido())/*10.31*/{_display_(Seq[Any](format.raw/*10.32*/("""
		<a onclick="inverter('0')" title="Ordenação crescente"><div id="inverter"> v </div></a>
	""")))}/*12.4*/else/*12.9*/{_display_(Seq[Any](format.raw/*12.10*/("""
		<a onclick="inverter('0')" title="Ordenação decrescente"><div id="inverter"> ^ </div></a>
	""")))})),format.raw/*14.3*/("""
	<h2>Períodos </h2>
</div>
<div id="col1">
	"""),_display_(Seq[Any](/*18.3*/for(periodo <- periodos) yield /*18.27*/{_display_(Seq[Any](format.raw/*18.28*/("""
		<div id="periodoBox">
			<a onclick="editarPeriodo('"""),_display_(Seq[Any](/*20.32*/periodo/*20.39*/.getNumero())),format.raw/*20.51*/("""')" title="Clique aqui para editar"><div id="numPeriodo"><b>"""),_display_(Seq[Any](/*20.112*/periodo/*20.119*/.getNumero())),format.raw/*20.131*/("""º</b> Período</div></a><!-- Numero do periodo -->
			<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			<div class="disc"><!-- Disciplinas do periodo -->
			    """),_display_(Seq[Any](/*23.9*/for(disciplinaPeriodo <- periodo.getDisciplinas()) yield /*23.59*/ {_display_(Seq[Any](format.raw/*23.61*/("""
			    	"""),_display_(Seq[Any](/*24.10*/if(planejador.ehDisciplinaOptativaGenerica(disciplinaPeriodo))/*24.72*/{_display_(Seq[Any](format.raw/*24.73*/("""
			    		<a>"""),_display_(Seq[Any](/*25.14*/disciplinaPeriodo/*25.31*/.getNome())),format.raw/*25.41*/(""" </a>
				    	<span>"""),_display_(Seq[Any](/*26.17*/disciplinaPeriodo/*26.34*/.getCreditos())),format.raw/*26.48*/(""" / _</span>
				    	<br>
			    	""")))}/*28.11*/else/*28.16*/{_display_(Seq[Any](format.raw/*28.17*/("""
				    	"""),_display_(Seq[Any](/*29.11*/if(disciplinaPeriodo.isAlocadaCorretamente())/*29.56*/ {_display_(Seq[Any](format.raw/*29.58*/("""
				    	   	<a title="Pré-requisitos: """),_display_(Seq[Any](/*30.41*/disciplinaPeriodo/*30.58*/.getPreRequisitos)),format.raw/*30.75*/("""">"""),_display_(Seq[Any](/*30.78*/disciplinaPeriodo/*30.95*/.getNome())),format.raw/*30.105*/(""" </a>
				    	   	<span>"""),_display_(Seq[Any](/*31.21*/disciplinaPeriodo/*31.38*/.getCreditos())),format.raw/*31.52*/(""" / """),_display_(Seq[Any](/*31.56*/disciplinaPeriodo/*31.73*/.getDificuldade())),format.raw/*31.90*/("""</span>
				    		<br>
				    	""")))}/*33.12*/else/*33.17*/{_display_(Seq[Any](format.raw/*33.18*/("""
				    		<a class="discRed" title="Pré-requisitos: """),_display_(Seq[Any](/*34.54*/disciplinaPeriodo/*34.71*/.getPreRequisitos)),format.raw/*34.88*/("""">"""),_display_(Seq[Any](/*34.91*/disciplinaPeriodo/*34.108*/.getNome())),format.raw/*34.118*/(""" </a>
							<span>"""),_display_(Seq[Any](/*35.15*/disciplinaPeriodo/*35.32*/.getCreditos())),format.raw/*35.46*/(""" / """),_display_(Seq[Any](/*35.50*/disciplinaPeriodo/*35.67*/.getDificuldade())),format.raw/*35.84*/("""</span>
				    		<br>
				    	""")))})),format.raw/*37.11*/("""
			    	""")))})),format.raw/*38.10*/("""
			    """)))})),format.raw/*39.9*/("""
			</div>
			<div class="totalC"><!-- Total de créditos do periodo -->
			"""),_display_(Seq[Any](/*42.5*/if(periodo.getTotalDeCreditos() < 14)/*42.42*/{_display_(Seq[Any](format.raw/*42.43*/("""
				<div class="totalCNota">Número mínimo de 14 créditos não alcançado</div>
			""")))})),format.raw/*44.5*/("""
				<b>Total: </b>"""),_display_(Seq[Any](/*45.20*/periodo/*45.27*/.getTotalDeCreditos())),format.raw/*45.48*/("""  /   """),_display_(Seq[Any](/*45.55*/periodo/*45.62*/.getTotalDeDificuldade())),format.raw/*45.86*/("""
			</div>
		</div><!-- Fim de um periodo -->
	""")))})),format.raw/*48.3*/("""
	
</div>

<div id="top2"><h2>Disciplinas</h2></div><!-- coluna de disciplinas -->
<div id="col2">
	<div id="header">Obrigatórias</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*58.4*/for(disciplina <- naoAlocadas) yield /*58.34*/ {_display_(Seq[Any](format.raw/*58.36*/("""
			"""),_display_(Seq[Any](/*59.5*/if(disciplina.getPeriodoSugerido() == 1)/*59.45*/{_display_(Seq[Any](format.raw/*59.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*60.32*/disciplina/*60.42*/.getPreRequisitos())),format.raw/*60.61*/("""">"""),_display_(Seq[Any](/*60.64*/disciplina/*60.74*/.getNome())),format.raw/*60.84*/("""</a>   <span>"""),_display_(Seq[Any](/*60.98*/disciplina/*60.108*/.getCreditos())),format.raw/*60.122*/("""  /  """),_display_(Seq[Any](/*60.128*/disciplina/*60.138*/.getDificuldade())),format.raw/*60.155*/("""</span>
				<br>
			""")))})),format.raw/*62.5*/("""
		""")))})),format.raw/*63.4*/("""
		<br>
		
		"""),_display_(Seq[Any](/*66.4*/for(disciplina <- naoAlocadas) yield /*66.34*/ {_display_(Seq[Any](format.raw/*66.36*/("""
			"""),_display_(Seq[Any](/*67.5*/if(disciplina.getPeriodoSugerido() == 2)/*67.45*/{_display_(Seq[Any](format.raw/*67.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*68.32*/disciplina/*68.42*/.getPreRequisitos())),format.raw/*68.61*/("""">"""),_display_(Seq[Any](/*68.64*/disciplina/*68.74*/.getNome())),format.raw/*68.84*/("""</a>   <span>"""),_display_(Seq[Any](/*68.98*/disciplina/*68.108*/.getCreditos())),format.raw/*68.122*/("""  /  """),_display_(Seq[Any](/*68.128*/disciplina/*68.138*/.getDificuldade())),format.raw/*68.155*/("""</span>
				<br>
			""")))})),format.raw/*70.5*/("""
		""")))})),format.raw/*71.4*/("""
		<br>
		"""),_display_(Seq[Any](/*73.4*/for(disciplina <- naoAlocadas) yield /*73.34*/ {_display_(Seq[Any](format.raw/*73.36*/("""
			"""),_display_(Seq[Any](/*74.5*/if(disciplina.getPeriodoSugerido() == 3)/*74.45*/{_display_(Seq[Any](format.raw/*74.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*75.32*/disciplina/*75.42*/.getPreRequisitos())),format.raw/*75.61*/("""">"""),_display_(Seq[Any](/*75.64*/disciplina/*75.74*/.getNome())),format.raw/*75.84*/("""</a>   <span>"""),_display_(Seq[Any](/*75.98*/disciplina/*75.108*/.getCreditos())),format.raw/*75.122*/("""  /  """),_display_(Seq[Any](/*75.128*/disciplina/*75.138*/.getDificuldade())),format.raw/*75.155*/("""</span>
				<br>
			""")))})),format.raw/*77.5*/("""
		""")))})),format.raw/*78.4*/("""
		<br>
		"""),_display_(Seq[Any](/*80.4*/for(disciplina <- naoAlocadas) yield /*80.34*/ {_display_(Seq[Any](format.raw/*80.36*/("""
			"""),_display_(Seq[Any](/*81.5*/if(disciplina.getPeriodoSugerido() == 4)/*81.45*/{_display_(Seq[Any](format.raw/*81.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*82.32*/disciplina/*82.42*/.getPreRequisitos())),format.raw/*82.61*/("""">"""),_display_(Seq[Any](/*82.64*/disciplina/*82.74*/.getNome())),format.raw/*82.84*/("""</a>   <span>"""),_display_(Seq[Any](/*82.98*/disciplina/*82.108*/.getCreditos())),format.raw/*82.122*/("""  /  """),_display_(Seq[Any](/*82.128*/disciplina/*82.138*/.getDificuldade())),format.raw/*82.155*/("""</span>
				<br>
			""")))})),format.raw/*84.5*/("""
		""")))})),format.raw/*85.4*/("""
		<br>
		"""),_display_(Seq[Any](/*87.4*/for(disciplina <- naoAlocadas) yield /*87.34*/ {_display_(Seq[Any](format.raw/*87.36*/("""
			"""),_display_(Seq[Any](/*88.5*/if(disciplina.getPeriodoSugerido() == 5)/*88.45*/{_display_(Seq[Any](format.raw/*88.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*89.32*/disciplina/*89.42*/.getPreRequisitos())),format.raw/*89.61*/("""">"""),_display_(Seq[Any](/*89.64*/disciplina/*89.74*/.getNome())),format.raw/*89.84*/("""</a>   <span>"""),_display_(Seq[Any](/*89.98*/disciplina/*89.108*/.getCreditos())),format.raw/*89.122*/("""  /  """),_display_(Seq[Any](/*89.128*/disciplina/*89.138*/.getDificuldade())),format.raw/*89.155*/("""</span>
				<br>
			""")))})),format.raw/*91.5*/("""
		""")))})),format.raw/*92.4*/("""
		<br>
		"""),_display_(Seq[Any](/*94.4*/for(disciplina <- naoAlocadas) yield /*94.34*/ {_display_(Seq[Any](format.raw/*94.36*/("""
			"""),_display_(Seq[Any](/*95.5*/if(disciplina.getPeriodoSugerido() == 6)/*95.45*/{_display_(Seq[Any](format.raw/*95.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*96.32*/disciplina/*96.42*/.getPreRequisitos())),format.raw/*96.61*/("""">"""),_display_(Seq[Any](/*96.64*/disciplina/*96.74*/.getNome())),format.raw/*96.84*/("""</a>   <span>"""),_display_(Seq[Any](/*96.98*/disciplina/*96.108*/.getCreditos())),format.raw/*96.122*/("""  /  """),_display_(Seq[Any](/*96.128*/disciplina/*96.138*/.getDificuldade())),format.raw/*96.155*/("""</span>
				<br>
			""")))})),format.raw/*98.5*/("""
		""")))})),format.raw/*99.4*/("""
		<br>
		"""),_display_(Seq[Any](/*101.4*/for(disciplina <- naoAlocadas) yield /*101.34*/ {_display_(Seq[Any](format.raw/*101.36*/("""
			"""),_display_(Seq[Any](/*102.5*/if(disciplina.getPeriodoSugerido() == 7)/*102.45*/{_display_(Seq[Any](format.raw/*102.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*103.32*/disciplina/*103.42*/.getPreRequisitos())),format.raw/*103.61*/("""">"""),_display_(Seq[Any](/*103.64*/disciplina/*103.74*/.getNome())),format.raw/*103.84*/("""</a>   <span>"""),_display_(Seq[Any](/*103.98*/disciplina/*103.108*/.getCreditos())),format.raw/*103.122*/("""  /  """),_display_(Seq[Any](/*103.128*/disciplina/*103.138*/.getDificuldade())),format.raw/*103.155*/("""</span>
				<br>
			""")))})),format.raw/*105.5*/("""
		""")))})),format.raw/*106.4*/("""
		<br>
		"""),_display_(Seq[Any](/*108.4*/for(disciplina <- naoAlocadas) yield /*108.34*/ {_display_(Seq[Any](format.raw/*108.36*/("""
			"""),_display_(Seq[Any](/*109.5*/if(disciplina.getPeriodoSugerido() == 8)/*109.45*/{_display_(Seq[Any](format.raw/*109.46*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*110.32*/disciplina/*110.42*/.getPreRequisitos())),format.raw/*110.61*/("""">"""),_display_(Seq[Any](/*110.64*/disciplina/*110.74*/.getNome())),format.raw/*110.84*/("""</a>   <span>"""),_display_(Seq[Any](/*110.98*/disciplina/*110.108*/.getCreditos())),format.raw/*110.122*/("""  /  """),_display_(Seq[Any](/*110.128*/disciplina/*110.138*/.getDificuldade())),format.raw/*110.155*/("""</span>
				<br>
			""")))})),format.raw/*112.5*/("""
		""")))})),format.raw/*113.4*/("""
	</div>

	<div id="header">Optativas TECC</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
			
	<div class="disc2">
		"""),_display_(Seq[Any](/*120.4*/for(disciplina <- naoAlocadas) yield /*120.34*/ {_display_(Seq[Any](format.raw/*120.36*/("""
			"""),_display_(Seq[Any](/*121.5*/if(disciplina.getPeriodoSugerido() == -2)/*121.46*/{_display_(Seq[Any](format.raw/*121.47*/("""
				<a title="Pré-requisitos: """),_display_(Seq[Any](/*122.32*/disciplina/*122.42*/.getPreRequisitos())),format.raw/*122.61*/("""">"""),_display_(Seq[Any](/*122.64*/disciplina/*122.74*/.getNome())),format.raw/*122.84*/("""</a>   <span>"""),_display_(Seq[Any](/*122.98*/disciplina/*122.108*/.getCreditos())),format.raw/*122.122*/("""  /  """),_display_(Seq[Any](/*122.128*/disciplina/*122.138*/.getDificuldade())),format.raw/*122.155*/("""</span>
				<br>
			""")))})),format.raw/*124.5*/("""
		""")))})),format.raw/*125.4*/("""
	</div>
	
	<div id="header">Optativas de Outros Cursos</div>
	<div id="headerDescription">Disciplina <span>créditos / <a title="variando de 1-fácil até 5-difícil">dificuldade</a></span></div>
	
	<div class="disc2">
		"""),_display_(Seq[Any](/*132.4*/for(disciplina <- naoAlocadas) yield /*132.34*/ {_display_(Seq[Any](format.raw/*132.36*/("""
				"""),_display_(Seq[Any](/*133.6*/if(disciplina.getPeriodoSugerido() == -1)/*133.47*/{_display_(Seq[Any](format.raw/*133.48*/("""
					<a title="Pré-requisitos: """),_display_(Seq[Any](/*134.33*/disciplina/*134.43*/.getPreRequisitos())),format.raw/*134.62*/("""">"""),_display_(Seq[Any](/*134.65*/disciplina/*134.75*/.getNome())),format.raw/*134.85*/("""</a>   <span>"""),_display_(Seq[Any](/*134.99*/disciplina/*134.109*/.getCreditos())),format.raw/*134.123*/("""  /  """),_display_(Seq[Any](/*134.129*/disciplina/*134.139*/.getDificuldade())),format.raw/*134.156*/("""</span>
					<br>
				""")))})),format.raw/*136.6*/("""
		""")))})),format.raw/*137.4*/("""
	</div>
</div>
""")))})),format.raw/*140.2*/("""
"""))}
    }
    
    def render(periodos:List[Periodo],naoAlocadas:List[Disciplina],planejador:Planejador): play.api.templates.HtmlFormat.Appendable = apply(periodos,naoAlocadas,planejador)
    
    def f:((List[Periodo],List[Disciplina],Planejador) => play.api.templates.HtmlFormat.Appendable) = (periodos,naoAlocadas,planejador) => apply(periodos,naoAlocadas,planejador)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Mar 04 20:23:41 GMT-03:00 2014
                    SOURCE: D:/Karen/workspace/projeto-si1/app/views/index.scala.html
                    HASH: 9e02f5ccd3f9252d09149b5e94b8815a154160e4
                    MATRIX: 809->1|1000->81|1030->103|1067->106|1104->135|1143->137|1208->167|1226->177|1268->198|1402->297|1439->325|1478->326|1591->422|1603->427|1642->428|1770->525|1855->575|1895->599|1934->600|2028->658|2044->665|2078->677|2176->738|2193->745|2228->757|2510->1004|2576->1054|2616->1056|2663->1067|2734->1129|2773->1130|2824->1145|2850->1162|2882->1172|2941->1195|2967->1212|3003->1226|3059->1264|3072->1269|3111->1270|3159->1282|3213->1327|3253->1329|3331->1371|3357->1388|3396->1405|3435->1408|3461->1425|3494->1435|3557->1462|3583->1479|3619->1493|3659->1497|3685->1514|3724->1531|3778->1567|3791->1572|3830->1573|3921->1628|3947->1645|3986->1662|4025->1665|4052->1682|4085->1692|4142->1713|4168->1730|4204->1744|4244->1748|4270->1765|4309->1782|4376->1817|4419->1828|4460->1838|4574->1917|4620->1954|4659->1955|4774->2039|4831->2060|4847->2067|4890->2088|4933->2095|4949->2102|4995->2126|5077->2177|5415->2480|5461->2510|5501->2512|5542->2518|5591->2558|5630->2559|5699->2592|5718->2602|5759->2621|5798->2624|5817->2634|5849->2644|5899->2658|5919->2668|5956->2682|5999->2688|6019->2698|6059->2715|6113->2738|6149->2743|6201->2760|6247->2790|6287->2792|6328->2798|6377->2838|6416->2839|6485->2872|6504->2882|6545->2901|6584->2904|6603->2914|6635->2924|6685->2938|6705->2948|6742->2962|6785->2968|6805->2978|6845->2995|6899->3018|6935->3023|6983->3036|7029->3066|7069->3068|7110->3074|7159->3114|7198->3115|7267->3148|7286->3158|7327->3177|7366->3180|7385->3190|7417->3200|7467->3214|7487->3224|7524->3238|7567->3244|7587->3254|7627->3271|7681->3294|7717->3299|7765->3312|7811->3342|7851->3344|7892->3350|7941->3390|7980->3391|8049->3424|8068->3434|8109->3453|8148->3456|8167->3466|8199->3476|8249->3490|8269->3500|8306->3514|8349->3520|8369->3530|8409->3547|8463->3570|8499->3575|8547->3588|8593->3618|8633->3620|8674->3626|8723->3666|8762->3667|8831->3700|8850->3710|8891->3729|8930->3732|8949->3742|8981->3752|9031->3766|9051->3776|9088->3790|9131->3796|9151->3806|9191->3823|9245->3846|9281->3851|9329->3864|9375->3894|9415->3896|9456->3902|9505->3942|9544->3943|9613->3976|9632->3986|9673->4005|9712->4008|9731->4018|9763->4028|9813->4042|9833->4052|9870->4066|9913->4072|9933->4082|9973->4099|10027->4122|10063->4127|10112->4140|10159->4170|10200->4172|10242->4178|10292->4218|10332->4219|10402->4252|10422->4262|10464->4281|10504->4284|10524->4294|10557->4304|10608->4318|10629->4328|10667->4342|10711->4348|10732->4358|10773->4375|10828->4398|10865->4403|10914->4416|10961->4446|11002->4448|11044->4454|11094->4494|11134->4495|11204->4528|11224->4538|11266->4557|11306->4560|11326->4570|11359->4580|11410->4594|11431->4604|11469->4618|11513->4624|11534->4634|11575->4651|11630->4674|11667->4679|11918->4894|11965->4924|12006->4926|12048->4932|12099->4973|12139->4974|12209->5007|12229->5017|12271->5036|12311->5039|12331->5049|12364->5059|12415->5073|12436->5083|12474->5097|12518->5103|12539->5113|12580->5130|12635->5153|12672->5158|12934->5384|12981->5414|13022->5416|13065->5423|13116->5464|13156->5465|13227->5499|13247->5509|13289->5528|13329->5531|13349->5541|13382->5551|13433->5565|13454->5575|13492->5589|13536->5595|13557->5605|13598->5622|13655->5647|13692->5652|13744->5672
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|40->12|40->12|40->12|42->14|46->18|46->18|46->18|48->20|48->20|48->20|48->20|48->20|48->20|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|54->26|54->26|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|59->31|59->31|61->33|61->33|61->33|62->34|62->34|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|65->37|66->38|67->39|70->42|70->42|70->42|72->44|73->45|73->45|73->45|73->45|73->45|73->45|76->48|86->58|86->58|86->58|87->59|87->59|87->59|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|88->60|90->62|91->63|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|96->68|98->70|99->71|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|103->75|105->77|106->78|108->80|108->80|108->80|109->81|109->81|109->81|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|110->82|112->84|113->85|115->87|115->87|115->87|116->88|116->88|116->88|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|117->89|119->91|120->92|122->94|122->94|122->94|123->95|123->95|123->95|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|124->96|126->98|127->99|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|131->103|133->105|134->106|136->108|136->108|136->108|137->109|137->109|137->109|138->110|138->110|138->110|138->110|138->110|138->110|138->110|138->110|138->110|138->110|138->110|138->110|140->112|141->113|148->120|148->120|148->120|149->121|149->121|149->121|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|150->122|152->124|153->125|160->132|160->132|160->132|161->133|161->133|161->133|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|162->134|164->136|165->137|168->140
                    -- GENERATED --
                */
            