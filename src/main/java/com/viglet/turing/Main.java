/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.viglet.turing;

import java.io.File;

import javax.jms.Queue;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.store.PersistenceAdapter;
import org.apache.activemq.store.kahadb.KahaDBPersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@Controller
@SpringBootApplication
@EnableJms
public class Main {
	@Autowired
	DataSource dataSource;

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setForceEncoding(true);
	    characterEncodingFilter.setEncoding("UTF-8");
	    registrationBean.setFilter(characterEncodingFilter);
	    return registrationBean;
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public BrokerService broker() throws Exception {
	    final BrokerService broker = new BrokerService();
	    //broker.addConnector("tcp://localhost:61616");
	    broker.addConnector("vm://localhost");
	    PersistenceAdapter persistenceAdapter = new KahaDBPersistenceAdapter();
	    File dir = new File(System.getProperty("user.home") + File.separator + "kaha");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    persistenceAdapter.setDirectory(dir);
	    broker.setPersistenceAdapter(persistenceAdapter);
	    broker.setPersistent(true);
	    return broker;
	}
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/sn/{siteName}")
	String sn(@PathVariable("siteName") String siteName) {
		return "sn/templates/index";
	}
}
