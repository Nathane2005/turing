package com.viglet.turing.persistence.model.ml;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the vigNLPSolutions database table.
 * 
 */
@Entity
@Table(name = "turMLVendor")
@NamedQuery(name = "TurMLVendor.findAll", query = "SELECT v FROM TurMLVendor v")
public class TurMLVendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 25)
	private String id;

	@Column(nullable = true, length = 255)
	private String description;

	@Column(nullable = true, length = 255)
	private String plugin;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = true, length = 255)
	private String website;

	public TurMLVendor() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlugin() {
		return this.plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}