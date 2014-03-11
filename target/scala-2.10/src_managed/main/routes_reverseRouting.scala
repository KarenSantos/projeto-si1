// @SOURCE:C:/Users/Rodr/Documents/repositorios/projeto-si1/conf/routes
// @HASH:f82e19dc0793668d5cfe47ecf872a64089f768cb
// @DATE:Tue Mar 11 14:42:46 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseAutenticador {
    

// @LINE:11
def cadastro(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cadastro")
}
                                                

// @LINE:12
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:13
def efetuaCadastro(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cadastro")
}
                                                

// @LINE:10
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:6
class ReverseApplication {
    

// @LINE:17
def novoPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "novoPeriodo")
}
                                                

// @LINE:16
def periodos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "periodos")
}
                                                

// @LINE:22
def remover(disciplinaId:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "remover/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:23
def mover(disciplinaId:String, futuro:Int, atual:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mover/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("futuro", futuro) + "/" + implicitly[PathBindable[Int]].unbind("atual", atual))
}
                                                

// @LINE:20
def editar(periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "editar/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:24
def inverter(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "inverter")
}
                                                

// @LINE:21
def adicionar(disciplinaId:String, periodo:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "adicionar/" + implicitly[PathBindable[String]].unbind("disciplinaId", dynamicString(disciplinaId)) + "/" + implicitly[PathBindable[Int]].unbind("periodo", periodo))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseAutenticador {
    

// @LINE:11
def cadastro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Autenticador.cadastro",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastro"})
      }
   """
)
                        

// @LINE:12
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Autenticador.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:13
def efetuaCadastro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Autenticador.efetuaCadastro",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cadastro"})
      }
   """
)
                        

// @LINE:10
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Autenticador.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:6
class ReverseApplication {
    

// @LINE:17
def novoPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.novoPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "novoPeriodo"})
      }
   """
)
                        

// @LINE:16
def periodos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.periodos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "periodos"})
      }
   """
)
                        

// @LINE:22
def remover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.remover",
   """
      function(disciplinaId,periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "remover/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:23
def mover : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.mover",
   """
      function(disciplinaId,futuro,atual) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mover/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("disciplinaId", encodeURIComponent(disciplinaId)) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("futuro", futuro) + "/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("atual", atual)})
      }
   """
)
                        

// @LINE:20
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.editar",
   """
      function(periodo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "editar/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("periodo", periodo)})
      }
   """
)
                        

// @LINE:24
def inverter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.inverter",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "inverter"})
      }
   """
)
                        

// @LINE:21
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
        


// @LINE:27
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
package controllers.ref {


// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseAutenticador {
    

// @LINE:11
def cadastro(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Autenticador.cadastro(), HandlerDef(this, "controllers.Autenticador", "cadastro", Seq(), "GET", """""", _prefix + """cadastro""")
)
                      

// @LINE:12
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Autenticador.authenticate(), HandlerDef(this, "controllers.Autenticador", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:13
def efetuaCadastro(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Autenticador.efetuaCadastro(), HandlerDef(this, "controllers.Autenticador", "efetuaCadastro", Seq(), "POST", """""", _prefix + """cadastro""")
)
                      

// @LINE:10
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Autenticador.login(), HandlerDef(this, "controllers.Autenticador", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:6
class ReverseApplication {
    

// @LINE:17
def novoPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.novoPeriodo(), HandlerDef(this, "controllers.Application", "novoPeriodo", Seq(), "GET", """""", _prefix + """novoPeriodo""")
)
                      

// @LINE:16
def periodos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.periodos(), HandlerDef(this, "controllers.Application", "periodos", Seq(), "GET", """ Periodos	""", _prefix + """periodos""")
)
                      

// @LINE:22
def remover(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.remover(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "remover", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """remover/$disciplinaId<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:23
def mover(disciplinaId:String, futuro:Int, atual:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.mover(disciplinaId, futuro, atual), HandlerDef(this, "controllers.Application", "mover", Seq(classOf[String], classOf[Int], classOf[Int]), "GET", """""", _prefix + """mover/$disciplinaId<[^/]+>/$futuro<[^/]+>/$atual<[^/]+>""")
)
                      

// @LINE:20
def editar(periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.editar(periodo), HandlerDef(this, "controllers.Application", "editar", Seq(classOf[Int]), "GET", """ Edicoes""", _prefix + """editar/$periodo<[^/]+>""")
)
                      

// @LINE:24
def inverter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.inverter(), HandlerDef(this, "controllers.Application", "inverter", Seq(), "GET", """""", _prefix + """inverter""")
)
                      

// @LINE:21
def adicionar(disciplinaId:String, periodo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.adicionar(disciplinaId, periodo), HandlerDef(this, "controllers.Application", "adicionar", Seq(classOf[String], classOf[Int]), "GET", """""", _prefix + """adicionar/$disciplinaId<[^/]+>/$periodo<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    