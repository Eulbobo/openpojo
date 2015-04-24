/*
 * Copyright (c) 2010-2015 Osman Shoukry
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License or any
 *    later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.openpojo;

import java.util.List;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.TestsMustBeNamedTestOrTestSuiteRule;
import org.junit.Before;
import org.junit.Test;

/**
 * @author oshoukry
 */
public class StructuralTest {
    private PojoValidator pojoValidator;

    @Before
    public void setup() {
        pojoValidator = new PojoValidator();
        pojoValidator.addRule(new TestsMustBeNamedTestOrTestSuiteRule());
    }

    @Test
    public void allTestsMustEndWithTest() {
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClassesRecursively("com.openpojo", null);
        for (PojoClass pojoClass : pojoClasses) {
            pojoValidator.runValidation(pojoClass);
        }
    }
}
