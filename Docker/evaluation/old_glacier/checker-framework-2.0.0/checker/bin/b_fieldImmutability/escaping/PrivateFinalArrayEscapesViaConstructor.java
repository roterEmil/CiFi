/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.escaping;

import org.opalj.fpcf.properties.immutability.fields.ShallowImmutableField;
import org.opalj.fpcf.properties.immutability.references.ImmutableFieldReference;

public class PrivateFinalArrayEscapesViaConstructor {

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private final char[] charArray;

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private final byte[] byteArray;

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private final int[] intArray;

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private final long[] longArray;

    @ShallowImmutableField("")
    @ImmutableFieldReference("")
    private final Object[] objectArray;

    public PrivateFinalArrayEscapesViaConstructor(char[] charArray, byte[] byteArray, int[] intArray,
                                                  long[] longArray, Object[] objectArray) {
        this.charArray = charArray;
        this.byteArray = byteArray;
        this.intArray = intArray;
        this.longArray = longArray;
        this.objectArray = objectArray;
    }
}
