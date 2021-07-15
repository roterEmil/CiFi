package org.opalj.fpcf.fixtures.cifi_benchmark.general;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.properties.immutability.classes.NonTransitivelyImmutableClass;
import org.opalj.fpcf.properties.immutability.fields.NonTransitivelyImmutableField;
import org.opalj.fpcf.properties.immutability.field_assignability.NonAssignableField;
import org.opalj.fpcf.properties.immutability.types.NonTransitivelyImmutableType;
import org.opalj.fpcf.fixtures.cifi_benchmark.common.ClassWithMutableField;

@Immutable
@NonTransitivelyImmutableType("Class is final and non transitively immutable")
@NonTransitivelyImmutableClass("Class has only non transitively immutable fields")
public final class ClassWithNonTransitivelyImmutableFields {

    @Immutable
    @NonTransitivelyImmutableField("Final field with mutable type assigned in the constructor")
    @NonAssignableField("Declared final Field")
    private final ClassWithMutableField nonTransitivelyImmutableFieldConstructorAssigned;

    @Immutable
    @NonTransitivelyImmutableField("Final field with mutable type eager assigned")
    @NonAssignableField("Declared final Field")
    private final ClassWithMutableField nonTransitivelyImmutableFieldEagerAssigned = new ClassWithMutableField();


    @Immutable
    @NonTransitivelyImmutableField("Field is assignable and has a non transitively immutable type")
    @NonAssignableField("Declared final Field")
    private final ClassWithNonTransitivelyImmutableFields instance =
            new ClassWithNonTransitivelyImmutableFields(new ClassWithMutableField());

    public ClassWithNonTransitivelyImmutableFields(ClassWithMutableField classWithMutableFields){
        this.nonTransitivelyImmutableFieldConstructorAssigned = classWithMutableFields;
    }
}
