/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.escaping;

import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;

public class ClassWithDeepImmutableFieldWhereTheObjectCanEscape {

    @DeepImmutableField("immutable reference and immutable field type FinalEmptyClass")
    @ImmutableFieldReference("field is effective immutable")
    private FinalEmptyClass fec = new FinalEmptyClass();

    public FinalEmptyClass getFec() {
        return fec;
    }
}

class FinalEmptyClass{ }