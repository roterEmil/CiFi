/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.general;

import org.opalj.br.fpcf.analyses.L0ClassImmutabilityAnalysis;
import org.opalj.br.fpcf.analyses.L0FieldImmutabilityAnalysis;
import org.opalj.br.fpcf.analyses.L0TypeImmutabilityAnalysis;
import org.opalj.fpcf.properties.immutability.classes.MutableClass;
import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.fields.MutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;
import org.opalj.fpcf.properties.immutability.references.MutableFieldReference;
import org.opalj.fpcf.properties.immutability.types.MutableType;
import org.opalj.tac.fpcf.analyses.L1FieldImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.L2FieldImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.L1ClassImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.L1TypeImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.L3FieldImmutabilityAnalysis;
import org.opalj.tac.fpcf.analyses.immutability.fieldreference.L0FieldReferenceImmutabilityAnalysis;

/**
 * This testclass tests that different modifiers like transient, volatile or static
 * does not have an impact of mutability.
 *
 * @author Tobias Roth
 *
 */
public class DifferentModifier {

    @MutableField(value = "field has a mutable field reference")
    @MutableFieldReference(value = "field is public")
    public int mutableInt = 5;

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    private int immutableInt = 3;

    @MutableField(value = "field has a mutable field reference")
    @MutableFieldReference(value = "field is public")
    public transient int mutableTransientInt = 5;

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    private transient int immutableTransientInt = 5;

    @MutableField(value = "field has a mutable field reference")
    @MutableFieldReference(value = "field is public")
    public volatile int mutableVolatileInt = 5;

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    private volatile int immutableVolatileInt = 5;

    @MutableField(value = "field has a mutable field reference")
    @MutableFieldReference(value = "field is public")
    public volatile long mutableVolatileLong;

    @DeepImmutableField("")
    @ImmutableFieldReference("")
    private volatile long immutableVolatileLong = 0L;

    DifferentModifier(long l){
        this.mutableVolatileLong = l;
    }

      static final class InnerClass {

          @MutableField(value = "field has a mutable field reference")
          @MutableFieldReference(value = "field is public")
          public static int mutableInnerStaticInt = 1;

          @DeepImmutableField("")
          @ImmutableFieldReference("")
          private static int immutableInnerStaticInt = 1;

          @MutableField(value = "field has a mutable field reference")
          @MutableFieldReference(value = "field is public")
          public int mutableInnerInt = 5;

          @DeepImmutableField("")
          @ImmutableFieldReference("")
          private int immutableInnerInt = 5;

          @MutableField(value = "field has a mutable field reference")
          @MutableFieldReference(value = "field is public")
        public transient int mutableInnerTransientInt = 5;

          @DeepImmutableField("")
          @ImmutableFieldReference("")
          private transient int immutableInnerTransientInt = 5;

          @MutableField(value = "field has a mutable field reference")
          @MutableFieldReference(value = "field is public")
        public volatile int mutableInnerVolatileInt = 5;

          @DeepImmutableField("")
          @ImmutableFieldReference("")
          private volatile int immutableInnerVolatileInt = 5;

          @MutableField(value = "field has a mutable field reference")
          @MutableFieldReference(value = "field is public")
        public volatile transient int mutableInnerVolatileTransientInt = 5;

          @DeepImmutableField("")
          @ImmutableFieldReference("")
          private volatile transient int immutableInnerVolatileTransientInt = 5;
    }
}
