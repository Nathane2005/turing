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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServerResponseConceptExtractorResultConceptOccurencesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServerResponseConceptExtractorResultConceptOccurencesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subterm" type="{}ServerResponseConceptExtractorResultConceptOccurenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServerResponseConceptExtractorResultConceptOccurencesType", propOrder = {
    "subterm"
})
public class ServerResponseConceptExtractorResultConceptOccurencesType {

    @XmlElement(name = "Subterm")
    protected List<ServerResponseConceptExtractorResultConceptOccurenceType> subterm;

    /**
     * Gets the value of the subterm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subterm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubterm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServerResponseConceptExtractorResultConceptOccurenceType }
     * 
     * 
     */
    public List<ServerResponseConceptExtractorResultConceptOccurenceType> getSubterm() {
        if (subterm == null) {
            subterm = new ArrayList<ServerResponseConceptExtractorResultConceptOccurenceType>();
        }
        return this.subterm;
    }

}
