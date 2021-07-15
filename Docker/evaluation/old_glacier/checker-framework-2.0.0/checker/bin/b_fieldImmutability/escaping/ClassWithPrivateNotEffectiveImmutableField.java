/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.escaping;

import org.opalj.fpcf.properties.immutability.classes.MutableClass;
import org.opalj.fpcf.properties.immutability.fields.MutableField;
import org.opalj.fpcf.properties.immutability.references.MutableFieldReference;
import org.opalj.fpcf.properties.immutability.types.MutableType;
import org.opalj.tac.fpcf.analyses.immutability.fieldreference.L0FieldReferenceImmutabilityAnalysis;

@MutableType(value = "class is extensible")
@MutableClass(value = "class has the mutable field tmc")
public class ClassWithPrivateNotEffectiveImmutableField {

    @MutableField(value = "field has mutable reference")
    @MutableFieldReference(value = "referenced object can be changed via setter",
            analyses = L0FieldReferenceImmutabilityAnalysis.class)
    private ClassWithPublicFields tmc = new ClassWithPublicFields();

    public void setTmc(ClassWithPublicFields tmc) {
        this.tmc = tmc;
    }
}
