// @SOURCE:E:/Workspace/projeto-si1/conf/routes
// @HASH:b73db92a2ecf8ec181fd384ae4f83916380471cf
// @DATE:Sat Mar 01 11:09:06 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:15
def deletarPeriodo(periodo:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deletar/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:9
def periodos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodos")
}
                                                

// @LINE:10
def novoPeriodo(periodo:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "novoPeriodo/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:14
def remover(disciplinaId:String, periodo:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "remover/" + implicitly[PathBindable[Int]].unbind("periodo", periodo) + "/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)))
}
                                                

// @LINE:12
def editar(periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "editar/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:13
def adicionar(disciplinaId:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adicionar/" + implicitly[PathBindable[Int]].unbind("periodo", periodo) + "/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:15
def deletarPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deletarPeriodo",
   """
      function(periodo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deletar/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:9
def periodos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.periodos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodos"})
      }
   """
)
                        

// @LINE:10
def novoPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.novoPeriodo",
   """
      function(periodo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "novoPeriodo/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:14
def remover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.remover",
   """
      function(disciplinaId,periodo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "remover/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId))})
      }
   """
)
                        

// @LINE:12
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editar",
   """
      function(periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "editar/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:13
def adicionar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.adicionar",
   """
      function(disciplinaId,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adicionar/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId))})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:18
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:18
class ReverseAssets {
    

// @LINE:18
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:15
def deletarPeriodo(periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deletarPeriodo(periodo), HandlerDef(this, "controllers.Application", "deletarPeriodo", Seq(classOf[Int]), "POST", """""", _prefix + """deletar/$periodo<[^/]+>""")
)
                      

// @LINE:9
def periodos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.periodos(), HandlerDef(this, "controllers.Application", "periodos", Seq(), "GET", """ Periodos""", _prefix + """periodos""")
)
                      

// @LINE:10
def novoPeriodo(periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.novoPeriodo(periodo), HandlerDef(this, "controllers.Application", "novoPeriodo", Seq(classOf[Int]), "POST", """""", _prefix + """novoPeriodo/$periodo<[^/]+>""")
)
                      

// @LINE:14
def remover(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.remover(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "remover", Seq(classOf[String], classOf[Int]), "POST", """""", _prefix + """remover/$periodo<[^/]+>/$disciplinaId<[^/]+>""")
)
                      

// @LINE:12
def editar(periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editar(periodo), HandlerDef(this, "controllers.Application", "editar", Seq(classOf[Int]), "GET", """""", _prefix + """editar/$periodo<[^/]+>""")
)
                      

// @LINE:13
def adicionar(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.adicionar(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "adicionar", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """adicionar/$periodo<[^/]+>/$disciplinaId<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    