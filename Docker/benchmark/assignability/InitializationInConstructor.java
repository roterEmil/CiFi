package org.opalj.fpcf.fixtures.cifi_benchmark.assignability;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.properties.immutability.field_assignability.AssignableField;
import org.opalj.fpcf.properties.immutability.field_assignability.EffectivelyNonAssignableField;

@Immutable
class InitializationInConstructorAssignable {

    @Immutable
    @AssignableField("The field is written everytime it is passed to the constructor of another instance.")
    private InitializationInConstructorAssignable child;
    public InitializationInConstructorAssignable(InitializationInConstructorAssignable parent) {
        parent.child = this;
        }
    }

@Immutable
class InitializationInConstructorNonAssignable {

    @Immutable
    @EffectivelyNonAssignableField("The class is only assigned once in its own constructor.")
    private InitializationInConstructorNonAssignable parent;
    public InitializationInConstructorNonAssignable(InitializationInConstructorNonAssignable parent) {
        this.parent = parent.parent;
    }
}