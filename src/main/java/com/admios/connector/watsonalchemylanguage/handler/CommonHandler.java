package com.admios.connector.watsonalchemylanguage.handler;

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

	protected CommonHandler<T> addParam(String param, Object value) {
		if (StringUtils.isEmpty(param)){
			throw new IllegalArgumentException("The param name can be null or empty");
		} else if (value != null) {
			params.put(param, value);
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public <K extends CommonHandler<?>> K cast() {
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
