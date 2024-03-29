package com.prodyna.pac.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * Helper class to easily setup arquillian container.
 * 
 * @author moritz löser (moritz.loeser@prodyna.com)
 *
 */
public abstract class ArquillianContainer {
    /**
     * Default container for all tests.
     */
    private static WebArchive container = ShrinkWrap.create(WebArchive.class, "test.war")
                                                    .addAsResource("META-INF/test-persistence.xml",
                                                                   "META-INF/persistence.xml")
                                                    .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                                                    // Deploy our test
                                                    // datasource
                                                    .addAsWebInfResource("test-ds.xml")
                                                    .addClass(ArquillianContainer.class);

    /**
     * Adds classes to default container.
     * 
     * @param classes
     *            classes to add
     * @return container with classes added.
     */
    public static WebArchive addClasses(final Class<?>... classes) {
        return container.addClasses(classes);
    }
}
