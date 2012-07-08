/**
 * 
 */
package ru.kfu.itis.cll.uima.eval;

import java.util.SortedSet;

import org.apache.commons.lang3.event.EventListenerSupport;
import org.apache.uima.cas.Type;
import org.apache.uima.jcas.tcas.Annotation;

/**
 * @author Rinat Gareev (Kazan Federal University)
 * 
 */
public class EvaluationContext {

	private EventListenerSupport<EvaluationListener> listenerSupport =
			new EventListenerSupport<EvaluationListener>(EvaluationListener.class);

	public void addListener(EvaluationListener newListener) {
		listenerSupport.addListener(newListener);
	}

	public void reportMissing(Type type, Annotation goldAnno) {
		listenerSupport.fire().onMissing(type, goldAnno);
	}

	public void reportMatching(Type type, SortedSet<Annotation> goldAnnos,
			SortedSet<Annotation> sysAnnos) {
		listenerSupport.fire().onMatching(type, goldAnnos, sysAnnos);
	}

	public void reportSpurious(Type type, Annotation sysAnno) {
		listenerSupport.fire().onSpurious(type, sysAnno);
	}
}