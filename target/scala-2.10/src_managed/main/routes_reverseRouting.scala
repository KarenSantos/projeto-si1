// @SOURCE:E:/Workspace/projeto-si1/conf/routes
// @HASH:4cde73103c4c13dbca00ba5452b0ceb0f1f3bfb5
// @DATE:Wed Mar 05 22:13:48 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def novoPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "novoPeriodo")
}
                                                

// @LINE:9
def periodos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodos")
}
                                                

// @LINE:15
def remover(disciplinaId:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remover/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:16
def mover(disciplinaId:String, futuro:Int, atual:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mover/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("futuro", futuro) + "/" + implicitly[PathBindable[Int]].unbind("atual", atual))
}
                                                

// @LINE:13
def editar(periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "editar/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:17
def inverter(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inverter")
}
                                                

// @LINE:14
def adicionar(disciplinaId:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adicionar/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def novoPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.novoPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "novoPeriodo"})
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
                        

// @LINE:15
def remover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.remover",
   """
      function(disciplinaId,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remover/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:16
def mover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.mover",
   """
      function(disciplinaId,futuro,atual) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mover/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("futuro", futuro) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("atual", atual)})
      }
   """
)
                        

// @LINE:13
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editar",
   """
      function(periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "editar/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:17
def inverter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.inverter",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inverter"})
      }
   """
)
                        

// @LINE:14
def adicionar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.adicionar",
   """
      function(disciplinaId,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adicionar/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
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
        


// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:20
class ReverseAssets {
    

// @LINE:20
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def novoPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.novoPeriodo(), HandlerDef(this, "controllers.Application", "novoPeriodo", Seq(), "GET", """""", _prefix + """novoPeriodo""")
)
                      

// @LINE:9
def periodos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.periodos(), HandlerDef(this, "controllers.Application", "periodos", Seq(), "GET", """ Periodos	""", _prefix + """periodos""")
)
                      

// @LINE:15
def remover(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.remover(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "remover", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """remover/$disciplinaId<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:16
def mover(disciplinaId:String, futuro:Int, atual:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.mover(disciplinaId, futuro, atual), HandlerDef(this, "controllers.Application", "mover", Seq(classOf[String], classOf[Int], classOf[Int]), "GET", """""", _prefix + """mover/$disciplinaId<[^/]+>/$futuro<[^/]+>/$atual<[^/]+>""")
)
                      

// @LINE:13
def editar(periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editar(periodo), HandlerDef(this, "controllers.Application", "editar", Seq(classOf[Int]), "GET", """ Edicoes""", _prefix + """editar/$periodo<[^/]+>""")
)
                      

// @LINE:17
def inverter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.inverter(), HandlerDef(this, "controllers.Application", "inverter", Seq(), "GET", """""", _prefix + """inverter""")
)
                      

// @LINE:14
def adicionar(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.adicionar(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "adicionar", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """adicionar/$disciplinaId<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    