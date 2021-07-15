/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.cifi_benchmark.arrays.not_transitively_immutable;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.fixtures.cifi_benchmark.common.CustomObject;
import org.opalj.fpcf.properties.immutability.classes.NonTransitivelyImmutableClass;
import org.opalj.fpcf.properties.immutability.field_assignability.NonAssignableField;
import org.opalj.fpcf.properties.immutability.fields.NonTransitivelyImmutableField;
import org.opalj.fpcf.properties.immutability.types.NonTransitivelyImmutableType;

/**
 * This classes encompasses array-typed fields that are all assigned in the constructor.
 */
@Immutable
@NonTransitivelyImmutableType("Class is non-transitively immutable and final")
@NonTransitivelyImmutableClass("Class has only transitively immutable fields")
public final class PrivateFinalArraysEscapeViaConstructor {

    @Immutable
    @NonTransitivelyImmutableField("Array has a primitive type but is assigned in the constructor and, thus, escapes")
    @NonAssignableField("Array is final")
    private final char @Immutable[] charArray;

    @Immutable
    @NonTransitivelyImmutableField("Array has a primitive type but is assigned in the constructor and, thus, escapes")
    @NonAssignableField("Array is final")
    private final byte @Immutable[] byteArray;

    @Immutable
    @NonTransitivelyImmutableField("Array has a primitive type but is assigned in the constructor and, thus, escapes")
    @NonAssignableField("Array is final")
    private final int @Immutable[] intArray;

    @Immutable
    @NonTransitivelyImmutableField("Array has a primitive type but is assigned in the constructor and, thus, escapes")
    @NonAssignableField("Array is final")
    private final long @Immutable[] longArray;

    @Immutable
    @NonTransitivelyImmutableField("Array has a primitive type but is assigned in the constructor and, thus, escapes")
    @NonAssignableField("Array is final")
    private final CustomObject @Immutable[] objectArray;

    public PrivateFinalArraysEscapeViaConstructor(@Immutable char @Immutable[] charArray, @Immutable byte @Immutable[] byteArray, @Immutable int @Immutable[] intArray,
                                                  @Immutable long @Immutable[] longArray, @Immutable CustomObject @Immutable[] objectArray) {
        this.charArray = charArray;
        this.byteArray = byteArray;
        this.intArray = intArray;
        this.longArray = longArray;
        this.objectArray = objectArray;
    }
}
