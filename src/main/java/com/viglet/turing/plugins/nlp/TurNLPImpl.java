package com.viglet.turing.plugins.nlp;

import javax.xml.transform.TransformerException;

import com.viglet.turing.nlp.TurNLPResults;

public interface TurNLPImpl {
	public TurNLPResults retrieve(String text) throws TransformerException, Exception;
}