

/* First created by JCasGen Tue Sep 04 18:38:22 MSK 2012 */
package ru.kfu.cll.uima.tokenizer.fstype;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Tue Sep 04 18:38:22 MSK 2012
 * XML source: D:/projects/uima-ext/UIMA.Ext.Tokenizer/src/main/resources/ru/kfu/cll/uima/tokenizer/tokenizer-TypeSystem.xml
 * @generated */
public class CAP extends CW {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CAP.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CAP() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public CAP(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public CAP(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public CAP(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
}

    