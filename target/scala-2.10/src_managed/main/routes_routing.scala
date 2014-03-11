// @SOURCE:C:/Users/Rodr/Documents/repositorios/projeto-si1/conf/routes
// @HASH:f82e19dc0793668d5cfe47ecf872a64089f768cb
// @DATE:Tue Mar 11 14:42:46 GMT-03:00 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_Autenticador_login1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:11
private[this] lazy val controllers_Autenticador_cadastro2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:12
private[this] lazy val controllers_Autenticador_authenticate3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:13
private[this] lazy val controllers_Autenticador_efetuaCadastro4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cadastro"))))
        

// @LINE:16
private[this] lazy val controllers_Application_periodos5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodos"))))
        

// @LINE:17
private[this] lazy val controllers_Application_novoPeriodo6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("novoPeriodo"))))
        

// @LINE:20
private[this] lazy val controllers_Application_editar7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editar/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:21
private[this] lazy val controllers_Application_adicionar8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adicionar/"),DynamicPart("disciplinaId", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Application_remover9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remover/"),DynamicPart("disciplinaId", """[^/]+""",true),StaticPart("/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:23
private[this] lazy val controllers_Application_mover10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mover/"),DynamicPart("disciplinaId", """[^/]+""",true),StaticPart("/"),DynamicPart("futuro", """[^/]+""",true),StaticPart("/"),DynamicPart("atual", """[^/]+""",true))))
        

// @LINE:24
private[this] lazy val controllers_Application_inverter11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("inverter"))))
        

// @LINE:27
private[this] lazy val controllers_Assets_at12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Autenticador.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Autenticador.cadastro()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Autenticador.authenticate()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cadastro""","""controllers.Autenticador.efetuaCadastro()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodos""","""controllers.Application.periodos()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """novoPeriodo""","""controllers.Application.novoPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editar/$periodo<[^/]+>""","""controllers.Application.editar(periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adicionar/$disciplinaId<[^/]+>/$periodo<[^/]+>""","""controllers.Application.adicionar(disciplinaId:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remover/$disciplinaId<[^/]+>/$periodo<[^/]+>""","""controllers.Application.remover(disciplinaId:String, periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mover/$disciplinaId<[^/]+>/$futuro<[^/]+>/$atual<[^/]+>""","""controllers.Application.mover(disciplinaId:String, futuro:Int, atual:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """inverter""","""controllers.Application.inverter()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_Autenticador_login1(params) => {
   call { 
        invokeHandler(controllers.Autenticador.login(), HandlerDef(this, "controllers.Autenticador", "login", Nil,"GET", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:11
case controllers_Autenticador_cadastro2(params) => {
   call { 
        invokeHandler(controllers.Autenticador.cadastro(), HandlerDef(this, "controllers.Autenticador", "cadastro", Nil,"GET", """""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:12
case controllers_Autenticador_authenticate3(params) => {
   call { 
        invokeHandler(controllers.Autenticador.authenticate(), HandlerDef(this, "controllers.Autenticador", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:13
case controllers_Autenticador_efetuaCadastro4(params) => {
   call { 
        invokeHandler(controllers.Autenticador.efetuaCadastro(), HandlerDef(this, "controllers.Autenticador", "efetuaCadastro", Nil,"POST", """""", Routes.prefix + """cadastro"""))
   }
}
        

// @LINE:16
case controllers_Application_periodos5(params) => {
   call { 
        invokeHandler(controllers.Application.periodos(), HandlerDef(this, "controllers.Application", "periodos", Nil,"GET", """ Periodos	""", Routes.prefix + """periodos"""))
   }
}
        

// @LINE:17
case controllers_Application_novoPeriodo6(params) => {
   call { 
        invokeHandler(controllers.Application.novoPeriodo(), HandlerDef(this, "controllers.Application", "novoPeriodo", Nil,"GET", """""", Routes.prefix + """novoPeriodo"""))
   }
}
        

// @LINE:20
case controllers_Application_editar7(params) => {
   call(params.fromPath[Int]("periodo", None)) { (periodo) =>
        invokeHandler(controllers.Application.editar(periodo), HandlerDef(this, "controllers.Application", "editar", Seq(classOf[Int]),"GET", """ Edicoes""", Routes.prefix + """editar/$periodo<[^/]+>"""))
   }
}
        

// @LINE:21
case controllers_Application_adicionar8(params) => {
   call(params.fromPath[String]("disciplinaId", None), params.fromPath[Int]("periodo", None)) { (disciplinaId, periodo) =>
        invokeHandler(controllers.Application.adicionar(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "adicionar", Seq(classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """adicionar/$disciplinaId<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Application_remover9(params) => {
   call(params.fromPath[String]("disciplinaId", None), params.fromPath[Int]("periodo", None)) { (disciplinaId, periodo) =>
        invokeHandler(controllers.Application.remover(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "remover", Seq(classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """remover/$disciplinaId<[^/]+>/$periodo<[^/]+>"""))
   }
}
        

// @LINE:23
case controllers_Application_mover10(params) => {
   call(params.fromPath[String]("disciplinaId", None), params.fromPath[Int]("futuro", None), params.fromPath[Int]("atual", None)) { (disciplinaId, futuro, atual) =>
        invokeHandler(controllers.Application.mover(disciplinaId, futuro, atual), HandlerDef(this, "controllers.Application", "mover", Seq(classOf[String], classOf[Int], classOf[Int]),"GET", """""", Routes.prefix + """mover/$disciplinaId<[^/]+>/$futuro<[^/]+>/$atual<[^/]+>"""))
   }
}
        

// @LINE:24
case controllers_Application_inverter11(params) => {
   call { 
        invokeHandler(controllers.Application.inverter(), HandlerDef(this, "controllers.Application", "inverter", Nil,"GET", """""", Routes.prefix + """inverter"""))
   }
}
        

// @LINE:27
case controllers_Assets_at12(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     