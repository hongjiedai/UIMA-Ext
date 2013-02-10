
/* First created by JCasGen Sun Feb 10 23:27:25 MSK 2013 */
package ru.kfu.itis.issst.uima.chunker.cas;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Represents typed 'chunk', i.e. a head word with its dependents.
				Chunk annotation should have the same borders with its head word.
 * Updated by JCasGen Sun Feb 10 23:27:25 MSK 2013
 * @generated */
public class Chunk_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Chunk_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Chunk_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Chunk(addr, Chunk_Type.this);
  			   Chunk_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Chunk(addr, Chunk_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Chunk.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("ru.kfu.itis.issst.uima.chunker.cas.Chunk");
 
  /** @generated */
  final Feature casFeat_chunkType;
  /** @generated */
  final int     casFeatCode_chunkType;
  /** @generated */ 
  public String getChunkType(int addr) {
        if (featOkTst && casFeat_chunkType == null)
      jcas.throwFeatMissing("chunkType", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    return ll_cas.ll_getStringValue(addr, casFeatCode_chunkType);
  }
  /** @generated */    
  public void setChunkType(int addr, String v) {
        if (featOkTst && casFeat_chunkType == null)
      jcas.throwFeatMissing("chunkType", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    ll_cas.ll_setStringValue(addr, casFeatCode_chunkType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_head;
  /** @generated */
  final int     casFeatCode_head;
  /** @generated */ 
  public int getHead(int addr) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    return ll_cas.ll_getRefValue(addr, casFeatCode_head);
  }
  /** @generated */    
  public void setHead(int addr, int v) {
        if (featOkTst && casFeat_head == null)
      jcas.throwFeatMissing("head", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    ll_cas.ll_setRefValue(addr, casFeatCode_head, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dependents;
  /** @generated */
  final int     casFeatCode_dependents;
  /** @generated */ 
  public int getDependents(int addr) {
        if (featOkTst && casFeat_dependents == null)
      jcas.throwFeatMissing("dependents", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dependents);
  }
  /** @generated */    
  public void setDependents(int addr, int v) {
        if (featOkTst && casFeat_dependents == null)
      jcas.throwFeatMissing("dependents", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    ll_cas.ll_setRefValue(addr, casFeatCode_dependents, v);}
    
   /** @generated */
  public int getDependents(int addr, int i) {
        if (featOkTst && casFeat_dependents == null)
      jcas.throwFeatMissing("dependents", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i);
  }
   
  /** @generated */ 
  public void setDependents(int addr, int i, int v) {
        if (featOkTst && casFeat_dependents == null)
      jcas.throwFeatMissing("dependents", "ru.kfu.itis.issst.uima.chunker.cas.Chunk");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_dependents), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Chunk_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_chunkType = jcas.getRequiredFeatureDE(casType, "chunkType", "ru.kfu.itis.issst.uima.chunker.cas.ChunkType", featOkTst);
    casFeatCode_chunkType  = (null == casFeat_chunkType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_chunkType).getCode();

 
    casFeat_head = jcas.getRequiredFeatureDE(casType, "head", "org.opencorpora.cas.Word", featOkTst);
    casFeatCode_head  = (null == casFeat_head) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_head).getCode();

 
    casFeat_dependents = jcas.getRequiredFeatureDE(casType, "dependents", "uima.cas.FSArray", featOkTst);
    casFeatCode_dependents  = (null == casFeat_dependents) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dependents).getCode();

  }
}



    