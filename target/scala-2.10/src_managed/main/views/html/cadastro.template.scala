
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
object cadastro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[Autenticador.Cadastro],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: play.data.Form[Autenticador.Cadastro]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.47*/("""
"""),_display_(Seq[Any](/*3.2*/main("Cadastro")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
<meta charset="utf-8">



    <head>
    	<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.56*/routes/*9.62*/.Assets.at("images/favicon.png"))),format.raw/*9.94*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*10.70*/routes/*10.76*/.Assets.at("stylesheets/signin.css"))),format.raw/*10.112*/("""">
    </head>
    
    

    
    <body>    
	  <form class="form-signin" role="form" action=""""),_display_(Seq[Any](/*17.51*/routes/*17.57*/.Autenticador.efetuaCadastro())),format.raw/*17.87*/("""" method="post">
   			   <br>
   			   <br>
   			   <h3>Preencha os campos abaixo para completar o cadastro</h3>
			   <br>	
   			   <input type="email" class= "control-label" name="email" placeholder="e-mail" rows = 40>
			   <br>
			   <input type="password" class="control-label" name="password" placeholder="senha" rows = 40>
			   <br>
			   <input type="password" class="control-label" name="repassword" placeholder="Confirme a senha" rows = 40>
			   <br>
			   <button type="submit" class="btn  btn-primary">   Entrar   </button>
			   
			   
       </form>
	</div>	
		
    </body>
		
		

  <body>

   
""")))})),format.raw/*41.2*/("""


"""))}
    }
    
    def render(form:play.data.Form[Autenticador.Cadastro]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((play.data.Form[Autenticador.Cadastro]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Mar 11 14:25:05 GMT-03:00 2014
                    SOURCE: C:/Users/Rodr/Documents/repositorios/projeto-si1/app/views/cadastro.scala.html
                    HASH: 7e239480675ea70483378fc02ca4653496c23510
                    MATRIX: 808->1|964->46|1001->67|1025->83|1064->85|1198->184|1212->190|1265->222|1374->295|1389->301|1448->337|1587->440|1602->446|1654->476|2325->1116
                    LINES: 26->1|30->1|31->3|31->3|31->3|37->9|37->9|37->9|38->10|38->10|38->10|45->17|45->17|45->17|69->41
                    -- GENERATED --
                */
            