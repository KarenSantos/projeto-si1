
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[Autenticador.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: play.data.Form[Autenticador.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.44*/("""
"""),_display_(Seq[Any](/*2.2*/main("Caronas Inteligentes")/*2.30*/{_display_(Seq[Any](format.raw/*2.31*/("""

<meta charset="utf-8">
    
  	<br>
  	<br>
    <div class="hero-unit">
    		<h1>Caronas Inteligentes</h1>
			</div>
			<div class="form-actions">
			"""),_display_(Seq[Any](/*12.5*/if(flash.containsKey("erro"))/*12.34*/{_display_(Seq[Any](format.raw/*12.35*/("""
				<div class="alert alert-erro container">
  					"""),_display_(Seq[Any](/*14.9*/flash/*14.14*/.get("erro"))),format.raw/*14.26*/("""
				</div>
			""")))})),format.raw/*16.5*/("""
			"""),_display_(Seq[Any](/*17.5*/if(flash.containsKey("success"))/*17.37*/{_display_(Seq[Any](format.raw/*17.38*/("""
				<div class="alert alert-success container">
					"""),_display_(Seq[Any](/*19.7*/flash/*19.12*/.get("success"))),format.raw/*19.27*/("""
				</div>
			""")))})),format.raw/*21.5*/("""

    
	<form class="form-signin" role="form" action=""""),_display_(Seq[Any](/*24.49*/routes/*24.55*/.Autenticador.authenticate())),format.raw/*24.83*/("""" method="post">
   			   <br>
   			   <br>
   			   <h3>Faça login ou cadastre-se</h3>
			   
   			   <br>	
			   <div class="control-group">
			    <div class="controls">
			   <input type="email" class= "form-control" name="email" placeholder="e-mail" value=""""),_display_(Seq[Any](/*32.91*/form("email")/*32.104*/.value)),format.raw/*32.110*/("""" required>
			   </div>
			   </div>
			   <div class="control-group">
			    <div class="controls">
			   <input type="password" class="form-control" name="password" placeholder="senha">
			   </div>
			   </div>
			   <div class="control-group">
			    <div class="controls">
				  <button type="submit" class="btn btn-primary">Entrar</button>
				  <button type="button" class="btn" onclick="location.href = '"""),_display_(Seq[Any](/*43.68*/routes/*43.74*/.Autenticador.cadastro())),format.raw/*43.98*/("""';	">Cadastrar</button>
				</div>
			    </div>
			  </div>
			</form>
		

   
""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(form:play.data.Form[Autenticador.Login]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((play.data.Form[Autenticador.Login]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Mar 11 14:43:15 GMT-03:00 2014
                    SOURCE: C:/Users/Rodr/Documents/repositorios/projeto-si1/app/views/login.scala.html
                    HASH: f92a9548de58643822cc48e13b7005512522b082
                    MATRIX: 802->1|938->43|975->46|1011->74|1049->75|1248->239|1286->268|1325->269|1416->325|1430->330|1464->342|1513->360|1554->366|1595->398|1634->399|1726->456|1740->461|1777->476|1826->494|1920->552|1935->558|1985->586|2294->859|2317->872|2346->878|2807->1303|2822->1309|2868->1333|2988->1422
                    LINES: 26->1|29->1|30->2|30->2|30->2|40->12|40->12|40->12|42->14|42->14|42->14|44->16|45->17|45->17|45->17|47->19|47->19|47->19|49->21|52->24|52->24|52->24|60->32|60->32|60->32|71->43|71->43|71->43|79->51
                    -- GENERATED --
                */
            