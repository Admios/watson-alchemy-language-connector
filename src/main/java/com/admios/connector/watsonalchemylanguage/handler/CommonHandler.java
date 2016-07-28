package com.admios.connector.watsonalchemylanguage.handler;

import java.util.HashMap;
import java.util.Map;

public abstract class CommonHandler<T> {

	private Map<String, Object> params = new HashMap<>();

	public CommonHandler(String param, Object value) {
		params.put(param, value);
	}

	protected CommonHandler<T> addParam(String param, Object value) {
		if (!isEmpty(value))
			params.put(param, value);
		return this;
	}

	protected CommonHandler<T> removeParam(String param) {
		params.remove(param);
		return this;
	}

	abstract public T execute();

	private boolean isEmpty(Object value) {
		if (value == null)
			return true;
		if (value instanceof String && ((String) value).isEmpty())
			return true;
		return false;
	}
}
