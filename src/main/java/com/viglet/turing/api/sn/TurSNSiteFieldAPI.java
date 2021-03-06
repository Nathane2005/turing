package com.viglet.turing.api.sn;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viglet.turing.persistence.model.sn.TurSNSite;
import com.viglet.turing.persistence.model.sn.TurSNSiteField;
import com.viglet.turing.persistence.repository.sn.TurSNSiteFieldRepository;
import com.viglet.turing.persistence.repository.sn.TurSNSiteRepository;

@Component
@Path("sn/{snSiteId}/field")
public class TurSNSiteFieldAPI {

	@Autowired
	TurSNSiteRepository turSNSiteRepository;
	@Autowired
	TurSNSiteFieldRepository turSNSiteFieldRepository;

	@GET
	@Produces("application/json")
	public List<TurSNSiteField> list(@PathParam("snSiteId") int snSiteId) throws JSONException {
		TurSNSite turSNSite = turSNSiteRepository.findById(snSiteId);
		return this.turSNSiteFieldRepository.findByTurSNSite(turSNSite);
	}

	@Path("{snSiteFieldId}")
	@GET
	@Produces("application/json")
	public TurSNSiteField mlSolution(@PathParam("snSiteId") int snSiteId,
			@PathParam("snSiteFieldId") int id) throws JSONException {
		return this.turSNSiteFieldRepository.findById(id);
	}

	@Path("/{snSiteFieldId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public TurSNSiteField update(@PathParam("snSiteId") int snSiteId,
			@PathParam("snSiteFieldId") int id, TurSNSiteField turSNSiteField) throws Exception {
		TurSNSiteField turSNSiteFieldEdit = this.turSNSiteFieldRepository.findById(id);
		turSNSiteFieldEdit.setDescription(turSNSiteField.getDescription());
		turSNSiteFieldEdit.setMultiValued(turSNSiteField.getMultiValued());
		turSNSiteFieldEdit.setName(turSNSiteField.getName());
		turSNSiteFieldEdit.setType(turSNSiteField.getType());
		this.turSNSiteFieldRepository.save(turSNSiteFieldEdit);
		return turSNSiteFieldEdit;
	}

	@Path("{snSiteFieldId}")
	@DELETE
	@Produces("application/json")
	public boolean deleteEntity(@PathParam("snSiteId") int snSiteId, @PathParam("snSiteFieldId") int id) {
		this.turSNSiteFieldRepository.delete(id);
		return true;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public TurSNSiteField add(@PathParam("snSiteId") int snSiteId,
			TurSNSiteField turSNSiteField) throws Exception {
		TurSNSite turSNSite = turSNSiteRepository.findById(snSiteId);
		turSNSiteField.setTurSNSite(turSNSite);	
		this.turSNSiteFieldRepository.save(turSNSiteField);
		return turSNSiteField;

	}
	
	
}