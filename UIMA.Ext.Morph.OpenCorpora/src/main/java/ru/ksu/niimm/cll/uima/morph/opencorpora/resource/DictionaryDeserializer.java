/**
 * 
 */
package ru.ksu.niimm.cll.uima.morph.opencorpora.resource;

import static java.lang.System.currentTimeMillis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rinat Gareev (Kazan Federal University)
 * 
 */
public class DictionaryDeserializer {

	private static Logger log = LoggerFactory.getLogger(DictionaryDeserializer.class);
	private static final int DICTIONARY_READING_BUFFER_SIZE = 32768;

	public static MorphDictionary from(File file) throws Exception {
		if (!file.isFile()) {
			throw new IllegalArgumentException(String.format(
					"%s is not existing file", file));
		}
		return from(new FileInputStream(file), file.toString());
	}

	public static MorphDictionary from(InputStream in, String srcLabel) throws Exception {
		log.info("About to deserialize MorphDictionary from InputStream of {}...", srcLabel);
		long timeBefore = currentTimeMillis();
		InputStream is = new BufferedInputStream(in, DICTIONARY_READING_BUFFER_SIZE);
		ObjectInputStream ois = new ObjectInputStream(is);
		MorphDictionary dict;
		try {
			dict = (MorphDictionary) ois.readObject();
		} finally {
			IOUtils.closeQuietly(ois);
		}
		log.info("Deserialization of MorphDictionary finished in {} ms",
				currentTimeMillis() - timeBefore);
		dict.setWfPredictor(new DummyWordformPredictor(dict));
		log.info("DummyWordformPredictor was set in Deserialized MorphDictionary");
		return dict;
	}

	private DictionaryDeserializer() {
	}
}