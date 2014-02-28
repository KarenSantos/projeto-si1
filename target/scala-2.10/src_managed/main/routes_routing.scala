// @SOURCE:/home/karen/workspace/projeto-si1/conf/routes
// @HASH:4f5deab169f37c98c51fdb7bf1dac64714086afc
// @DATE:Fri Feb 28 11:29:33 BRT 2014


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
        

// @LINE:9
private[this] lazy val controllers_Application_periodos1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("periodos"))))
        

// @LINE:10
private[this] lazy val controllers_Application_novoPeriodo2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editar"))))
        

// @LINE:12
private[this] lazy val controllers_Application_editar3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editar/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:13
private[this] lazy val controllers_Application_adicionar4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("adicionar/"),DynamicPart("periodo", """[^/]+""",true),StaticPart("/"),DynamicPart("disciplinaId", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Application_remover5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("remover/"),DynamicPart("periodo", """[^/]+""",true),StaticPart("/"),DynamicPart("disciplinaId", """[^/]+""",true))))
        

// @LINE:15
private[this] lazy val controllers_Application_deletarPeriodo6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletar/"),DynamicPart("periodo", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Assets_at7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """periodos""","""controllers.Application.periodos()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editar""","""controllers.Application.novoPeriodo()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editar/$periodo<[^/]+>""","""controllers.Application.editar(periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """adicionar/$periodo<[^/]+>/$disciplinaId<[^/]+>""","""controllers.Application.adicionar(disciplinaId:String, periodo:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """remover/$periodo<[^/]+>/$disciplinaId<[^/]+>""","""controllers.Application.remover(disciplinaId:String, periodo:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletar/$periodo<[^/]+>""","""controllers.Application.deletarPeriodo(periodo:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:9
case controllers_Application_periodos1(params) => {
   call { 
        invokeHandler(controllers.Application.periodos(), HandlerDef(this, "controllers.Application", "periodos", Nil,"GET", """ Periodos""", Routes.prefix + """periodos"""))
   }
}
        

// @LINE:10
case controllers_Application_novoPeriodo2(params) => {
   call { 
        invokeHandler(controllers.Application.novoPeriodo(), HandlerDef(this, "controllers.Application", "novoPeriodo", Nil,"POST", """""", Routes.prefix + """editar"""))
   }
}
        

// @LINE:12
case controllers_Application_editar3(params) => {
   call(params.fromPath[Int]("periodo", None)) { (periodo) =>
        invokeHandler(controllers.Application.editar(periodo), HandlerDef(this, "controllers.Application", "editar", Seq(classOf[Int]),"GET", """""", Routes.prefix + """editar/$periodo<[^/]+>"""))
   }
}
        

// @LINE:13
case controllers_Application_adicionar4(params) => {
   call(params.fromPath[String]("disciplinaId", None), params.fromPath[Int]("periodo", None)) { (disciplinaId, periodo) =>
        invokeHandler(controllers.Application.adicionar(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "adicionar", Seq(classOf[String], classOf[Int]),"GET", """""", Routes.prefix + """adicionar/$periodo<[^/]+>/$disciplinaId<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Application_remover5(params) => {
   call(params.fromPath[String]("disciplinaId", None), params.fromPath[Int]("periodo", None)) { (disciplinaId, periodo) =>
        invokeHandler(controllers.Application.remover(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "remover", Seq(classOf[String], classOf[Int]),"POST", """""", Routes.prefix + """remover/$periodo<[^/]+>/$disciplinaId<[^/]+>"""))
   }
}
        

// @LINE:15
case controllers_Application_deletarPeriodo6(params) => {
   call(params.fromPath[Int]("periodo", None)) { (periodo) =>
        invokeHandler(controllers.Application.deletarPeriodo(periodo), HandlerDef(this, "controllers.Application", "deletarPeriodo", Seq(classOf[Int]),"POST", """""", Routes.prefix + """deletar/$periodo<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Assets_at7(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     