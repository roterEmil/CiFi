package org.opalj.fpcf.fixtures.cifi_benchmark.common;

import org.opalj.fpcf.properties.immutability.classes.TransitivelyImmutableClass;
import org.opalj.fpcf.properties.immutability.types.MutableType;
import edu.cmu.cs.glacier.qual.Immutable;

/**
 * This class is used instead of the class java.lang.Object
 * to bypass some analyses' special handling of java.lang.Object
 */
@MutableType("The class is extensible")
@TransitivelyImmutableClass("The class has no field and thus no state")
@Immutable
public class CustomObject {}
