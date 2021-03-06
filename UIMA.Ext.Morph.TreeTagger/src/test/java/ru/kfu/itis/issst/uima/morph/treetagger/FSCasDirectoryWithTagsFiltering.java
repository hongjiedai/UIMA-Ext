/**
 * 
 */
package ru.kfu.itis.issst.uima.morph.treetagger;

import java.util.List;
import java.util.Set;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.opencorpora.cas.Word;
import org.opencorpora.cas.Wordform;
import org.uimafit.util.FSCollectionFactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import ru.kfu.itis.cll.uima.cas.FSUtils;
import ru.kfu.itis.cll.uima.eval.cas.FSCasDirectory;

import static ru.ksu.niimm.cll.uima.morph.opencorpora.model.MorphConstants.*;

/**
 * @author Rinat Gareev (Kazan Federal University)
 * 
 */
public class FSCasDirectoryWithTagsFiltering extends FSCasDirectory {

	private static final Set<String> FILTERED_GRAM_TAGS = ImmutableSet.of(
			Prnt,
			Fixd,
			Qual, Poss,
			tran, intr,
			Name, Patr, Surn,
			Dist);

	private static final Set<String> CASE_TAGS = ImmutableSet.of(
			nomn, gent, gen1, gen2, datv, accs, ablt, loct, loc1, loc2, voct);
	private static final Set<String> ANIMACY_TAGS = ImmutableSet.of(anim, inan);
	private static final Set<String> GENDER_TAGS = ImmutableSet.of(femn, masc, neut);
	private static final Set<String> ADJ_POSES = ImmutableSet.of(ADJF, ADJS, PRTF, PRTS);
	private static final Set<String> SHORT_ADJ_POSES = ImmutableSet.of(ADJS, PRTS);

	private DirType dirType;

	@Override
	protected void postProcessCAS(CAS cas) {
		try {
			postProcessJCas(cas.getJCas());
		} catch (CASException e) {
			throw new IllegalStateException(e);
		}
	}

	private void postProcessJCas(JCas cas) {
		AnnotationIndex<Annotation> wordIdx = cas.getAnnotationIndex(Word.typeIndexID);
		List<Annotation> wordList = Lists.newArrayList(wordIdx);
		for (Annotation _wAnno : wordList) {
			Word word = (Word) _wAnno;
			if (word.getWordforms() != null) {
				for (Wordform wf : FSCollectionFactory.create(word.getWordforms(), Wordform.class)) {
					postProcess(cas, wf);
				}
			}
		}
	}

	private void postProcess(JCas jCas, Wordform wf) {
		// alignment rule 4
		if (isGoldDirectory() && PRED.equals(wf.getPos())) {
			wf.setPos(ADVB);
		}
		//
		if (wf.getGrammems() != null) {
			List<String> tagList = Lists.newLinkedList(FSUtils.toList(wf.getGrammems()));
			// arguable alignment rule 6
			if (isGoldDirectory() && wf.getPos() == null && tagList.contains(Prnt)) {
				wf.setPos(ADVB);
			}
			if (filterGramTags(wf.getPos(), tagList)) {
				if (tagList.isEmpty()) {
					wf.setGrammems(null);
				} else {
					wf.setGrammems(FSUtils.toStringArray(jCas, tagList));
				}
			}
		}
	}

	private boolean filterGramTags(String pos, List<String> tagList) {
		// alignment rule 1
		boolean changed = tagList.removeAll(FILTERED_GRAM_TAGS);
		// alignment rule 2
		if (!NOUN.equals(pos)) {
			changed |= tagList.removeAll(ANIMACY_TAGS);
		}
		// alignment rule 3
		if (ADJ_POSES.contains(pos) && tagList.contains(plur)) {
			changed |= tagList.removeAll(GENDER_TAGS);
		}
		// alignment rule 5
		if (isSystemDirectory() && SHORT_ADJ_POSES.contains(pos)) {
			changed |= tagList.removeAll(CASE_TAGS);
		}
		return changed;
	}

	private static enum DirType {
		SYSTEM, GOLD;
	}

	private boolean isSystemDirectory() {
		if (dirType == null) {
			initDirType();
		}
		return dirType.equals(DirType.SYSTEM);
	}

	private boolean isGoldDirectory() {
		if (dirType == null) {
			initDirType();
		}
		return dirType.equals(DirType.GOLD);
	}

	private void initDirType() {
		if (beanName.startsWith("gold")) {
			dirType = DirType.GOLD;
		} else if (beanName.startsWith("system")) {
			dirType = DirType.SYSTEM;
		} else {
			throw new IllegalStateException("Can't assign DirType for bean named " + beanName);
		}
	}
}