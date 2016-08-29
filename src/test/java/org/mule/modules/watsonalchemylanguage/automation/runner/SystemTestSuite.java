/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.watsonalchemylanguage.automation.system.ConnectorConfigTestCases;

@RunWith(Suite.class)
@SuiteClasses({ ConnectorConfigTestCases.class })
public class SystemTestSuite {

}
