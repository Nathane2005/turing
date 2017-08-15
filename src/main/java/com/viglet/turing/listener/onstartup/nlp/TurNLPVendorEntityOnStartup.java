package com.viglet.turing.listener.onstartup.nlp;

import com.viglet.turing.persistence.model.nlp.TurNLPEntity;
import com.viglet.turing.persistence.model.nlp.TurNLPVendor;
import com.viglet.turing.persistence.model.nlp.TurNLPVendorEntity;
import com.viglet.turing.persistence.service.nlp.TurNLPEntityService;
import com.viglet.turing.persistence.service.nlp.TurNLPVendorEntityService;
import com.viglet.turing.persistence.service.nlp.TurNLPVendorService;


public class TurNLPVendorEntityOnStartup {
	private static final String CORENLP = "CORENLP";
	private static final String OPENNLP = "OPENNLP";
	private static final String OTCA = "OTCA";
	
	TurNLPEntityService turNLPEntityService = new TurNLPEntityService();
	TurNLPVendorEntityService turNLPVendorEntityService = new TurNLPVendorEntityService();

	public static void createDefaultRows() {
		TurNLPVendorService turNLPVendorService = new TurNLPVendorService();
		TurNLPVendorEntityService turNLPVendorEntityService = new TurNLPVendorEntityService();
		TurNLPVendorEntityOnStartup turNLPVendorEntityOnStartup = new TurNLPVendorEntityOnStartup();

		if (turNLPVendorEntityService.listAll().isEmpty()) {
			TurNLPVendor turNLPVendor = turNLPVendorService.get(CORENLP);

			if (turNLPVendor != null) {
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "PN", "PERSON");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "GL", "LOCATION");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "ON", "ORGANIZATION");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "DURATION", "DURATION");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "DATE", "DATE");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "MISC", "MISC");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "ORDINAL", "ORDINAL");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "TIME", "TIME");
			}

			turNLPVendor = turNLPVendorService.get(OPENNLP);

			if (turNLPVendor != null) {
				TurOpenNLPModelsOnStartup.downloadModels();
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "PN", "/models/opennlp/en/en-ner-person.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "GL", "/models/opennlp/en/en-ner-location.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "ON",
						"/models/opennlp/en/en-ner-organization.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "MONEY", "/models/opennlp/en/en-ner-money.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "DATE", "/models/opennlp/en/en-ner-date.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "PERCENTAGE",
						"/models/opennlp/en/en-ner-percentage.bin");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "TIME", "/models/opennlp/en/en-ner-time.bin");
			}

			turNLPVendor = turNLPVendorService.get(OTCA);

			if (turNLPVendor != null) {
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "PN", "PN");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "GL", "GL");
				turNLPVendorEntityOnStartup.addNLPVendor(turNLPVendor, "ON", "ON");
			}

		}
	}

	public void addNLPVendor(TurNLPVendor turNLPVendor, String internalName, String name) {

		TurNLPEntity turNLPEntity = turNLPEntityService.findByInternalName(internalName);
		if (turNLPEntity != null) {
			TurNLPVendorEntity turNLPVendorEntity = new TurNLPVendorEntity();
			turNLPVendorEntity.setName(name);
			turNLPVendorEntity.setTurNLPEntity(turNLPEntity);
			turNLPVendorEntity.setTurNLPVendor(turNLPVendor);
			turNLPVendorEntityService.save(turNLPVendorEntity);
		}
	}
}