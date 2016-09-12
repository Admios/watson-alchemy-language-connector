/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import org.mule.modules.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public abstract class AbstractTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	protected AbstractTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

}
