package com.viglet.turing.listener.onstartup.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viglet.turing.persistence.model.se.TurSEInstance;
import com.viglet.turing.persistence.model.se.TurSEVendor;
import com.viglet.turing.persistence.model.system.TurConfigVar;
import com.viglet.turing.persistence.repository.se.TurSEInstanceRepository;
import com.viglet.turing.persistence.repository.se.TurSEVendorRepository;
import com.viglet.turing.persistence.repository.system.TurConfigVarRepository;

@Component
@Transactional
public class TurSEInstanceOnStartup {
	
	@Autowired
	private TurSEInstanceRepository turSEInstanceRepository;
	@Autowired
	private TurSEVendorRepository turSEVendorRepository;
	@Autowired
	private TurConfigVarRepository turConfigVarRepository;
	
	public void createDefaultRows() {


		TurConfigVar turConfigVar = new TurConfigVar();
		
		if (turSEInstanceRepository.findAll().isEmpty()) {

			TurSEVendor turSEVendor = turSEVendorRepository.getOne("SOLR");
			if (turSEVendor != null) {
				TurSEInstance turSEInstance = new TurSEInstance();
				turSEInstance.setTitle("Apache Solr");
				turSEInstance.setDescription("Solr Production");
				turSEInstance.setTurSEVendor(turSEVendor);
				turSEInstance.setHost("localhost");
				turSEInstance.setPort(8983);
				turSEInstance.setLanguage("pt-br");
				turSEInstance.setEnabled(1);
				turSEInstanceRepository.save(turSEInstance);
				
				turConfigVar.setId("DEFAULT_SE");
				turConfigVar.setPath("/se");
				turConfigVar.setValue(Integer.toString(turSEInstance.getId()));
				turConfigVarRepository.save(turConfigVar);
			}
		}

	}
	
	
}
