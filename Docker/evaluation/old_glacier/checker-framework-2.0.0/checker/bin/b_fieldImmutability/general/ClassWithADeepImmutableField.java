/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.general;

import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.fields.MutableField;
import org.opalj.fpcf.properties.immutability.fields.ShallowImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;
import org.opalj.fpcf.properties.immutability.references.MutableFieldReference;

public class ClassWithADeepImmutableField {

    @DeepImmutableField("Immutable Reference and Immutable Field Type")
    @ImmutableFieldReference("declared final field")
    private final FinalEmptyClass fec = new FinalEmptyClass();

    public FinalEmptyClass getFec() {
        return fec;
    }

    @DeepImmutableField("Immutable Reference and Immutable Field Type")
    @ImmutableFieldReference("effective immutable field")
    private FinalEmptyClass name = new FinalEmptyClass();

    @DeepImmutableField("immutable reference and deep immutable field type")
    @ImmutableFieldReference(value = "declared final field reference")
    private final FinalEmptyClass fec1;

    @ShallowImmutableField("immutable field reference and mutable type ClassWithPublicFields")
    @ImmutableFieldReference("declared final field")
    private final ClassWithPublicFields tmc;

    public ClassWithADeepImmutableField( ClassWithPublicFields tmc, FinalEmptyClass fec) {
        this.tmc = tmc;
        this.fec1 = fec;
    }

    @ShallowImmutableField("field has an immutable field reference and mutable type")
    @ImmutableFieldReference("declared final reference")
    private final ClassWithPublicFields cwpf = new ClassWithPublicFields();

    public ClassWithPublicFields getTmc() {
        return cwpf;
    }
}

class ClassWithProtectedFields {

    @MutableField("the field has a mutable field reference")
    @MutableFieldReference("the field is protected")
    protected FinalEmptyClass fec1 = new FinalEmptyClass();

    @MutableField("Because of Mutable Reference")
    @MutableFieldReference("Because it is declared as protected")
    protected ClassWithPublicFields cwpf1 = new ClassWithPublicFields();

    @ShallowImmutableField("field has an immutable reference and mutable type")
    @ImmutableFieldReference("Declared final Field")
    private final ClassWithPublicFields cwpf2 = new ClassWithPublicFields();

    @DeepImmutableField("immutable reference and deep immutable field type")
    @ImmutableFieldReference("Declared final Field")
    private final FinalEmptyClass fec2 = new FinalEmptyClass();
}

class ClassWithPublicFields {

    @MutableField(value = "field is public")
    @MutableFieldReference(value = "field is public")
    public int n = 0;

    @MutableField(value = "field is public")
    @MutableFieldReference(value = "field is public")
    public String name = "name";
}

class FinalEmptyClass{}