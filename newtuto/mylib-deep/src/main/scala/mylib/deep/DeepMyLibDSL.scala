/* Generated by Purgatory 2014-2015 */

package mylib.deep

import ch.epfl.data.sc.pardis
import pardis.ir._
import pardis.types.PardisTypeImplicits._
import pardis.effects._
import pardis.deep._
import pardis.deep.scalalib._
import pardis.deep.scalalib.collection._
import pardis.deep.scalalib.io._

import ch.epfl.data.sc.pardis.quasi.anf.{ BaseExt, BaseExtIR }
import ch.epfl.data.sc.pardis.quasi.TypeParameters.MaybeParamTag

trait MyLibDSLOps extends Base with ListOps with MemOps with ScalaCoreOps with ch.epfl.data.sc.pardis.quasi.anf.BaseQuasiExp {  
  // Type representation
  val MyLibDSLType = MyLibDSLIRs.MyLibDSLType
  implicit val typeMyLibDSL: TypeRep[MyLibDSL] = MyLibDSLType
  implicit class MyLibDSLRep(self : Rep[MyLibDSL]) {

  }
  object MyLibDSL {

  }
  // constructors

  // IR defs
  
  // method definitions
  
  type MyLibDSL = mylib.shallow.MyLibDSL
}
object MyLibDSLIRs extends Base {
  import ListIRs._
  import MemIRs._
  import ScalaCoreIRs._
  // Type representation
  case object MyLibDSLType extends TypeRep[MyLibDSL] {
    def rebuild(newArguments: TypeRep[_]*): TypeRep[_] = MyLibDSLType
    val name = "MyLibDSL"
    val typeArguments = Nil
  }
      implicit val typeMyLibDSL: TypeRep[MyLibDSL] = MyLibDSLType
  // case classes
  
  type MyLibDSL = mylib.shallow.MyLibDSL
}
trait MyLibDSLImplicits extends MyLibDSLOps { 
  // Add implicit conversions here!
}
trait MyLibDSLComponent extends MyLibDSLOps with MyLibDSLImplicits {  }

trait MyLibDSLPartialEvaluation extends MyLibDSLComponent with BasePartialEvaluation {  
  // Immutable field inlining 

  // Mutable field inlining 
  // Pure function partial evaluation
}


// QUASI GENERATED CODE:

object MyLibDSLQuasiNodes extends BaseExtIR {
  import MyLibDSLIRs._
  import ListQuasiNodes._
  import MemQuasiNodes._
  import ScalaCoreQuasiNodes._
  // case classes
  type MyLibDSL = mylib.shallow.MyLibDSL
}

trait MyLibDSLExtOps extends BaseExt with ListExtOps with MemExtOps with ScalaCoreExtOps with ch.epfl.data.sc.pardis.quasi.anf.BaseQuasiExt {
  
  import MyLibDSLQuasiNodes._
  import ch.epfl.data.sc.pardis.quasi.OverloadHackObj._
  import ListQuasiNodes._
  import MemQuasiNodes._
  import ScalaCoreQuasiNodes._
  implicit class MyLibDSLRep(self : Rep[MyLibDSL]) {
  }
  object MyLibDSL {
  }
  // constructors
  
  // method definitions
  type MyLibDSL = mylib.shallow.MyLibDSL
}

