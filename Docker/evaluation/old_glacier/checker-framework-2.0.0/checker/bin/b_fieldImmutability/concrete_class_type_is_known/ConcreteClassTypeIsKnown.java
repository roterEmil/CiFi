package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.concrete_class_type_is_known;

import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;

public class ConcreteClassTypeIsKnown {

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    public final Object knownObject = new Object();

    private Object unknownObject;

    public ConcreteClassTypeIsKnown(Object object) {
        this.unknownObject = object;
    }
}
