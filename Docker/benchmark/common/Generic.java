/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.cifi_benchmark.common;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.properties.immutability.field_assignability.NonAssignableField;

/**
 * Generic class with a generic field.
 */
@Immutable
//@DependentImmutableType(value = "class is dependently immutable and final", parameter = {"T"})
//@DependentlyImmutableClass(value = "class has a dependently immutable field", parameter = {"T"})
public final class Generic<T> {

    @Immutable
    //@DependentlyImmutableField(value = "field has a generic type parameter", parameter= {"T"} )
    @NonAssignableField("field is final")
    private final T t;

    public Generic(@Immutable T t){this.t = t;}
}
