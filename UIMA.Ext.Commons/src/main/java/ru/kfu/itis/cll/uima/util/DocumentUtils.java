/**
 * 
 */
package ru.kfu.itis.cll.uima.util;

import static ru.kfu.itis.cll.uima.util.AnnotatorUtils.featureExist;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.TypeSystem;
import org.apache.uima.cas.text.AnnotationFS;

import ru.kfu.itis.cll.uima.commons.DocumentMetadata;

/**
 * @author Rinat Gareev
 * 
 */
public class DocumentUtils {

	/**
	 * search for a {@link DocumentMetadata} annotation in given CAS and return
	 * its 'sourceUri' feature value
	 * 
	 * @param cas
	 * @return sourceUri value or null if there is no a DocumentMetadata
	 *         annotation
	 */
	public static String getDocumentUri(CAS cas) {
		TypeSystem ts = cas.getTypeSystem();
		Type docMetaType = ts.getType(DocumentMetadata.class.getName());
		if (docMetaType == null) {
			return null;
		}
		Feature sourceUriFeat;
		try {
			sourceUriFeat = featureExist(docMetaType, "sourceUri");
		} catch (AnalysisEngineProcessException e) {
			throw new IllegalStateException(e);
		}
		FSIterator<AnnotationFS> dmIter = cas.getAnnotationIndex(docMetaType).iterator();
		if (dmIter.hasNext()) {
			AnnotationFS docMeta = dmIter.next();
			return docMeta.getStringValue(sourceUriFeat);
		} else {
			return null;
		}
	}

	private DocumentUtils() {
	}
}