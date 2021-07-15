package org.opalj.fpcf.fixtures.cifi_benchmark.arrays.transitively_immutable;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.fixtures.cifi_benchmark.common.CustomObject;
import org.opalj.fpcf.properties.immutability.classes.TransitivelyImmutableClass;
import org.opalj.fpcf.properties.immutability.field_assignability.NonAssignableField;
import org.opalj.fpcf.properties.immutability.fields.TransitivelyImmutableField;
import org.opalj.fpcf.properties.immutability.field_assignability.EffectivelyNonAssignableField;
import org.opalj.fpcf.properties.immutability.types.TransitivelyImmutableType;

/**
 * This class encompasses different array-typed transitively immutable fields.
 */
@Immutable
@TransitivelyImmutableType("Class is final")
@TransitivelyImmutableClass("Class has only transitively immutable fields")
public final class ArrayTransitiveImmutability {

    @Immutable
    @TransitivelyImmutableField("The elements of the array can not escape")
    @NonAssignableField("Field is final")
    private final Integer @Immutable[] eagerAssignedIntegerArray = new Integer @Immutable[]{1, 2, 3};

    @Immutable
    @TransitivelyImmutableField("The elements of the array are never set")
    @NonAssignableField("The field is only assigned once")
    private static final Integer @Immutable[] staticTransitivelyImmutableArray = new Integer @Immutable[5];

    @TransitivelyImmutableField("The elements of the array can not escape")
    @NonAssignableField("Field is initialized in the constructor")
    private final Integer @Immutable[] transitivelyImmutableArrayAssignedInTheConstructor;

    public ArrayTransitiveImmutability() {
        transitivelyImmutableArrayAssignedInTheConstructor = new Integer @Immutable[]{5, 6, 7, 8};
    }

    @Immutable
    @TransitivelyImmutableField("The elements of the array can not escape")
    @EffectivelyNonAssignableField("The array is not initialized.")
    private CustomObject @Immutable[] notInitializedArray;

    @Immutable
    @TransitivelyImmutableField("")
    @EffectivelyNonAssignableField("")
    private CustomObject @Immutable[] clonedArray = new CustomObject @Immutable[]{new CustomObject(), new CustomObject()};

    public CustomObject[] getClonedArray(){ return  clonedArray.clone(); }
}
