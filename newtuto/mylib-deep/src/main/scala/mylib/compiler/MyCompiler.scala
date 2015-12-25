package mylib
package compiler

import ch.epfl.data.sc.pardis
import pardis.optimization._
import pardis.compiler._

import deep._

class MyCompiler(val DSL: MyLibDSLOps, name: String, offlineOptim: Boolean = false, lowering: Int = 0) extends Compiler[MyLibDSLOps] {
  
  // Pipeline Definition:
  
  pipeline += DCE
  
  if (offlineOptim) {
    
    pipeline += PartiallyEvaluate  // used to crash... for some reason... <- needs DCE to run before!
    
    //pipeline += new Optim.Offline.HighLevel(DSL)
    pipeline += new Optim.HighLevel(DSL)
    pipeline += new Optim.Generic(DSL)
    
    pipeline += DCE
    
  }
  
  if (lowering > 0) {
    
    pipeline += new ListLowering(DSL)
    
    pipeline += DCE
    
    if (lowering > 1) {
      
      pipeline += new ArrBufLowering(DSL)
      
      pipeline += DCE
      
      if (lowering > 2) {

        pipeline += new ArrayBufferToArray(DSL)
        
        pipeline += new CGenLowering(DSL)
        
        pipeline += DCE
        
      }
    }
    
    if (offlineOptim) {
      
      pipeline += PartiallyEvaluate
      
      //pipeline += new Optim.Offline.Generic(DSL)
      pipeline += new Optim.Generic(DSL)
      
      pipeline += DCE
      
    }
    
  }
  
  
  // Outputting Scala code inside an executable wrapper:
  
  import pardis.prettyprinter._
  
  val codeGenerator = new ScalaCodeGenerator with ASTCodeGenerator[MyLibDSLOps] {
    val IR = DSL
    import pardis.utils.document.Document
    override def getHeader(): Document = s"""
      |package mylib
      |import mylib.shallow._
      |import scala.collection.mutable.ArrayBuffer""".stripMargin
    override def getTraitSignature(): Document = s"""
      |object $name {
      |  def main(args: Array[String]): Unit = println(""".stripMargin
    override def getFooter(): Document = s"""
      |  )
      |}
      |""".stripMargin
  }
  
}
















