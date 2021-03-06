//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.24 at 09:29:47 AM BRT 
//


package com.viglet.turing.plugins.otca.response.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServerResponseResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServerResponseResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="Ping" type="{}ServerResponsePingResultType"/>
 *           &lt;element name="GetSupportedEncodings" type="{}ServerResponseGetSupportedEncodingsResultType"/>
 *           &lt;element name="languagedetector" type="{}ServerResponseLanguageDetectorResultType"/>
 *           &lt;element name="nconceptextractor" type="{}ServerResponseConceptExtractorResultType"/>
 *           &lt;element name="ncategorizer" type="{}ServerResponseCategorizerResultType"/>
 *           &lt;element name="nfinder" type="{}ServerResponseEntityExtractorResultType"/>
 *           &lt;element name="nsentiment" type="{}ServerResponseSentimentResultType"/>
 *           &lt;element name="nlikethis" type="{}ServerResponseSimilarityResultType"/>
 *           &lt;element name="nsummarizer" type="{}ServerResponseSummarizerResultType"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="LanguageDetector" type="{}ServerResponseLanguageDetectorResultType"/>
 *           &lt;element name="NConceptExtractor" type="{}ServerResponseConceptExtractorResultType"/>
 *           &lt;element name="NCategorizer" type="{}ServerResponseCategorizerResultType"/>
 *           &lt;element name="NFinder" type="{}ServerResponseEntityExtractorResultType"/>
 *           &lt;element name="NSentiment" type="{}ServerResponseSentimentResultType"/>
 *           &lt;element name="NLikeThis" type="{}ServerResponseSimilarityResultType"/>
 *           &lt;element name="NSummarizer" type="{}ServerResponseSummarizerResultType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServerResponseResultsType", propOrder = {
    "pingOrGetSupportedEncodingsOrLanguagedetector",
    "languageDetectorOrNConceptExtractorOrNCategorizer"
})
public class ServerResponseResultsType {

    @XmlElements({
        @XmlElement(name = "Ping", type = ServerResponsePingResultType.class),
        @XmlElement(name = "nlikethis", type = ServerResponseSimilarityResultType.class),
        @XmlElement(name = "ncategorizer", type = ServerResponseCategorizerResultType.class),
        @XmlElement(name = "nconceptextractor", type = ServerResponseConceptExtractorResultType.class),
        @XmlElement(name = "nsentiment", type = ServerResponseSentimentResultType.class),
        @XmlElement(name = "nfinder", type = ServerResponseEntityExtractorResultType.class),
        @XmlElement(name = "languagedetector", type = ServerResponseLanguageDetectorResultType.class),
        @XmlElement(name = "GetSupportedEncodings", type = ServerResponseGetSupportedEncodingsResultType.class),
        @XmlElement(name = "nsummarizer", type = ServerResponseSummarizerResultType.class)
    })
    protected List<Object> pingOrGetSupportedEncodingsOrLanguagedetector;
    @XmlElements({
        @XmlElement(name = "NLikeThis", type = ServerResponseSimilarityResultType.class),
        @XmlElement(name = "NSentiment", type = ServerResponseSentimentResultType.class),
        @XmlElement(name = "NCategorizer", type = ServerResponseCategorizerResultType.class),
        @XmlElement(name = "LanguageDetector", type = ServerResponseLanguageDetectorResultType.class),
        @XmlElement(name = "NConceptExtractor", type = ServerResponseConceptExtractorResultType.class),
        @XmlElement(name = "NSummarizer", type = ServerResponseSummarizerResultType.class),
        @XmlElement(name = "NFinder", type = ServerResponseEntityExtractorResultType.class)
    })
    protected List<Object> languageDetectorOrNConceptExtractorOrNCategorizer;

    /**
     * Gets the value of the pingOrGetSupportedEncodingsOrLanguagedetector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pingOrGetSupportedEncodingsOrLanguagedetector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPingOrGetSupportedEncodingsOrLanguagedetector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServerResponsePingResultType }
     * {@link ServerResponseSimilarityResultType }
     * {@link ServerResponseCategorizerResultType }
     * {@link ServerResponseConceptExtractorResultType }
     * {@link ServerResponseSentimentResultType }
     * {@link ServerResponseEntityExtractorResultType }
     * {@link ServerResponseLanguageDetectorResultType }
     * {@link ServerResponseGetSupportedEncodingsResultType }
     * {@link ServerResponseSummarizerResultType }
     * 
     * 
     */
    public List<Object> getPingOrGetSupportedEncodingsOrLanguagedetector() {
        if (pingOrGetSupportedEncodingsOrLanguagedetector == null) {
            pingOrGetSupportedEncodingsOrLanguagedetector = new ArrayList<Object>();
        }
        return this.pingOrGetSupportedEncodingsOrLanguagedetector;
    }

    /**
     * Gets the value of the languageDetectorOrNConceptExtractorOrNCategorizer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageDetectorOrNConceptExtractorOrNCategorizer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageDetectorOrNConceptExtractorOrNCategorizer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServerResponseSimilarityResultType }
     * {@link ServerResponseSentimentResultType }
     * {@link ServerResponseCategorizerResultType }
     * {@link ServerResponseLanguageDetectorResultType }
     * {@link ServerResponseConceptExtractorResultType }
     * {@link ServerResponseSummarizerResultType }
     * {@link ServerResponseEntityExtractorResultType }
     * 
     * 
     */
    public List<Object> getLanguageDetectorOrNConceptExtractorOrNCategorizer() {
        if (languageDetectorOrNConceptExtractorOrNCategorizer == null) {
            languageDetectorOrNConceptExtractorOrNCategorizer = new ArrayList<Object>();
        }
        return this.languageDetectorOrNConceptExtractorOrNCategorizer;
    }

}
