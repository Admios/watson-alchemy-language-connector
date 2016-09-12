/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

public abstract class CommonHandler<T> {

	protected final AlchemyLanguage service;
	protected Map<String, Object> params = new HashMap<>();

	public CommonHandler(AlchemyLanguage service, String param, Object value) {
		this.service = service;
		params.put(param, value);
	}

	protected <K extends CommonHandler<T>> K addParam(String param, Object value) {
		if (StringUtils.isEmpty(param)){
			throw new IllegalArgumentException("The param name can be null or empty");
		} else if (value != null) {
			params.put(param, value);
		}
		return this.cast();
	}

	@SuppressWarnings("unchecked")
	private <K extends CommonHandler<?>> K cast() {
		return (K) this;
	}

	protected CommonHandler<T> removeParam(String param) {
		params.remove(param);
		return this;
	}
	
	public Integer parametersSize() {
		return params.size();
	}

	abstract public T execute();
}
