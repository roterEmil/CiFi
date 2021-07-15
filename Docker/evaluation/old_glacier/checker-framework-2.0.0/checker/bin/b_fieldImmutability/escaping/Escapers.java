/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.escaping;

import org.opalj.fpcf.properties.immutability.classes.DependentImmutableClass;
import org.opalj.fpcf.properties.immutability.classes.ShallowImmutableClass;
import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.fields.DependentImmutableField;
import org.opalj.fpcf.properties.immutability.fields.MutableField;
import org.opalj.fpcf.properties.immutability.fields.ShallowImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;
import org.opalj.fpcf.properties.immutability.references.LazyInitializedNotThreadSafeFieldReference;
import org.opalj.tac.fpcf.analyses.immutability.L3FieldImmutabilityAnalysis;

public class Escapers{

}

class TransitiveEscape1 {

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private ClassWithPublicFields tmc = new ClassWithPublicFields();

    public ClassWithPublicFields get(){
        ClassWithPublicFields tmc1 = this.tmc;
        return tmc1;
    }
}

class TransitiveEscape2 {

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private ClassWithPublicFields tmc = new ClassWithPublicFields();

    public ClassWithPublicFields get(){
        ClassWithPublicFields tmc1 = this.tmc;
        ClassWithPublicFields tmc2 = tmc1;
        return tmc2;
    }
}

class OneThatNotEscapesAndOneWithDCL {
    @ShallowImmutableField(value = "immutable field reference and mutable type")
    @ImmutableFieldReference(value = "field is only written once")
    private ClassWithPublicFields tmc1 = new ClassWithPublicFields();

    @MutableField(value = "mutable reference")
    @LazyInitializedNotThreadSafeFieldReference("")
    private ClassWithPublicFields tmc2;

    public ClassWithPublicFields set() {
        ClassWithPublicFields tmc22 = tmc2;
        if (tmc22 == null) {
            synchronized (this) {
                if (tmc22 == null) {
                    tmc2 = new ClassWithPublicFields();
                }
            }
        }
        return tmc2;
    }
}

class GenericEscapes {

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private SimpleGenericClass sgc;

    public GenericEscapes(ClassWithPublicFields tmc){
        sgc = new SimpleGenericClass(tmc);
    }
}


@ShallowImmutableClass("")
class GenericEscapesTransitive {
    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private SimpleGenericClass gc1;

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private ClassWithPublicFields tmc;

    public GenericEscapesTransitive(ClassWithPublicFields tmc){
        this.tmc = tmc;
        gc1 = new SimpleGenericClass(this.tmc);
    }
}

class GenericNotEscapesMutualEscapeDependencyNotAbleToResolve{

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private ClassWithPublicFields tmc = new ClassWithPublicFields();

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private SimpleGenericClass sgc;

    public GenericNotEscapesMutualEscapeDependencyNotAbleToResolve() {

        this.sgc = new SimpleGenericClass(this.tmc);
    }
}

class GenericNotEscapesMutualEscapeDependencyAbleToResolve<T>{

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    private FinalEmptyClass fec = new FinalEmptyClass();

    @DependentImmutableField(value = "", analyses = L3FieldImmutabilityAnalysis.class)
    @ImmutableFieldReference("")
    private SimpleGenericClass<T> sgc;

    public GenericNotEscapesMutualEscapeDependencyAbleToResolve() {
        this.sgc = new SimpleGenericClass(this.fec);
    }
}

@DependentImmutableClass("")
final class SimpleGenericClass<T> {

    @DependentImmutableField(value = "")
    private T t;

    SimpleGenericClass(T t){
        this.t = t;
    }
}

class ClassWithPublicFields {
    public int n = 5;
}
