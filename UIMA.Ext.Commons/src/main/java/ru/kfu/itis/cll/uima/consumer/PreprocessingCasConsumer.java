package ru.kfu.itis.cll.uima.consumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
//import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import ru.kfu.itis.cll.uima.commons.MisisDocumentMetadata;

public class PreprocessingCasConsumer extends CasConsumer_ImplBase {

	public static final String PARAM_OUTPUTDIR = "OutputDirectory";
	
	private File mOutputDir;

	private int mDocNum;

	public void initialize() throws ResourceInitializationException {
		mDocNum = 0;
		mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
	    if (!mOutputDir.exists()) {
	      mOutputDir.mkdirs();
	    }
	}
	
	@Override
	public void processCas(CAS aCAS) throws ResourceProcessException {
		String modelFileName = null;
		JCas jcas;
	    try {
	      jcas = aCAS.getJCas();
	    } catch (CASException e) {
	      throw new ResourceProcessException(e);
	    }
	    FSIterator it = jcas.getAnnotationIndex(MisisDocumentMetadata.type).iterator();
	    File outFile = null;
	    if (it.hasNext()) {
	    	MisisDocumentMetadata fileLoc = (MisisDocumentMetadata) it.next();
	    	File inFile;
	    	try {
	            inFile = new File(new URL(fileLoc.getSourceUri()).getPath());
	            String outFileName = inFile.getName();
	            if (fileLoc.getOffsetInSource() > 0) {
	              outFileName += ("_" + fileLoc.getOffsetInSource());
	            }
	            outFileName += ".xmi";
	            outFile = new File(mOutputDir, outFileName);
	            modelFileName = mOutputDir.getAbsolutePath() + "/" + inFile.getName() + ".ecore";
	    	} catch (MalformedURLException e1) {
	            // invalid URL, use default processing below
	    	}
	    }
	    if (outFile == null) {
	    	outFile = new File(mOutputDir, "doc" + mDocNum++ + ".xmi");     
	    }
	    try {
			FileOutputStream out = new FileOutputStream(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
