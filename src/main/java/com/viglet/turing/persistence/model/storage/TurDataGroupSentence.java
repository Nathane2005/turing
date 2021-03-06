package com.viglet.turing.persistence.model.storage;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.viglet.turing.persistence.model.ml.TurMLCategory;

/**
 * The persistent class for the turDataSentence database table.
 * 
 */
@Entity
@Table(name = "turDataGroupSentence")
@NamedQuery(name = "TurDataGroupSentence.findAll", query = "SELECT ds FROM TurDataGroupSentence ds")
public class TurDataGroupSentence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Lob
	@Column(nullable = false, length = 100000 )
	private String sentence;

	// bi-directional many-to-one association to TurCategory
	@ManyToOne
	private TurMLCategory turMLCategory;

	// bi-directional many-to-one association to TurData
	@ManyToOne
	@JoinColumn(name = "datagroup_id", nullable = false)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private TurDataGroup turDataGroup;

	// bi-directional many-to-one association to TurData
	@ManyToOne
	@JoinColumn(name = "data_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	private TurData turData;

	public TurDataGroupSentence() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSentence() {
		return this.sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	public TurMLCategory getTurMLCategory() {
		return this.turMLCategory;
	}

	public void setTurMLCategory(TurMLCategory turMLCategory) {
		this.turMLCategory = turMLCategory;
	}

	public TurData getTurData() {
		return this.turData;
	}

	public void setTurData(TurData turData) {
		this.turData = turData;
	}

	public TurDataGroup getTurDataGroup() {
		return turDataGroup;
	}

	public void setTurDataGroup(TurDataGroup turDataGroup) {
		this.turDataGroup = turDataGroup;
	}

}