/*
 * Copyright 2015 JBoss Inc
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
package io.fabric8.apiman;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class KubernetesServiceCatalogTest {

	@Test @Ignore
	public void singleServiceAnnotations() {
		String serviceUrl = "http://localhost:8080/";
		Kubernetes2ApimanMapper catalog = new Kubernetes2ApimanMapper(null);
		Map<String,String> annotations = new HashMap<String,String>();
		annotations.put(Kubernetes2ApimanMapper.SERVICE_PATH, "cxfcdi");
		annotations.put(Kubernetes2ApimanMapper.SERVICE_PROTOCOL, "rest");
		annotations.put(Kubernetes2ApimanMapper.DESCRIPTION_PATH, "_?wsdl");
		annotations.put(Kubernetes2ApimanMapper.DESCRIPTION_LANGUAGE, "wsdl");
		Kubernetes2ApimanMapper.ServiceContract sc = catalog.createServiceContract(annotations, serviceUrl, null);
	
		assertEquals("http://localhost:8080/cxfcdi", sc.serviceUrl);
		assertEquals("rest", sc.serviceProtocol);
		assertEquals("http://localhost:8080/_?wsdl", sc.descriptionUrl);
		assertEquals("wsdl", sc.descriptionLanguage);
	}
	
	@Test @Ignore
	public void testK8s() {
	    KubernetesServiceCatalog catalog = new KubernetesServiceCatalog();
	    String authToken = "4q1_NL3LFhndlLFevYiU5KQvvimzkEoLaJmkWQwuIxY";
	    catalog.searchKube("*", "default", authToken);
	}

}
