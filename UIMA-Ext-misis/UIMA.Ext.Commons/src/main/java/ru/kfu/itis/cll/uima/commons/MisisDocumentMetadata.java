

/* First created by JCasGen Sun Feb 03 22:01:11 MSK 2013 */
package ru.kfu.itis.cll.uima.commons;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Sun Feb 03 22:36:42 MSK 2013
 * XML source: C:/Documents and Settings/Тест/temp/UIMA-Ext-misis/UIMA.Ext.Commons/desc/cpe/PreprocessingCasConsumerDescriptor.xml
 * @generated */
public class MisisDocumentMetadata extends DocumentMetadata {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MisisDocumentMetadata.class);
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
  protected MisisDocumentMetadata() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MisisDocumentMetadata(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MisisDocumentMetadata(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public MisisDocumentMetadata(JCas jcas, int begin, int end) {
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
     
 
    
  //*--------------*
  //* Feature: language

  /** getter for language - gets 
   * @generated */
  public String getLanguage() {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_language);}
    
  /** setter for language - sets  
   * @generated */
  public void setLanguage(String v) {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_language == null)
      jcasType.jcas.throwFeatMissing("language", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_language, v);}    
   
    
  //*--------------*
  //* Feature: format

  /** getter for format - gets MIME-type of document: Plaintext, DOC, XLS, PDF.
   * @generated */
  public String getFormat() {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_format == null)
      jcasType.jcas.throwFeatMissing("format", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_format);}
    
  /** setter for format - sets MIME-type of document: Plaintext, DOC, XLS, PDF. 
   * @generated */
  public void setFormat(String v) {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_format == null)
      jcasType.jcas.throwFeatMissing("format", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_format, v);}    
   
    
  //*--------------*
  //* Feature: documentRawText

  /** getter for documentRawText - gets 
   * @generated */
  public String getDocumentRawText() {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_documentRawText == null)
      jcasType.jcas.throwFeatMissing("documentRawText", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_documentRawText);}
    
  /** setter for documentRawText - sets  
   * @generated */
  public void setDocumentRawText(String v) {
    if (MisisDocumentMetadata_Type.featOkTst && ((MisisDocumentMetadata_Type)jcasType).casFeat_documentRawText == null)
      jcasType.jcas.throwFeatMissing("documentRawText", "ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((MisisDocumentMetadata_Type)jcasType).casFeatCode_documentRawText, v);}    
  }

    