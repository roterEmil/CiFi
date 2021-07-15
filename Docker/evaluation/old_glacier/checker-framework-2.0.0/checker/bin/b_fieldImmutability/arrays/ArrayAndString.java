/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.arrays;

import org.opalj.fpcf.properties.immutability.fields.DeepImmutableField;
import org.opalj.fpcf.properties.immutability.fields.ShallowImmutableField;

public class ArrayAndString<T> {

    @ShallowImmutableField("")
    private String[] stringArray;

    @ShallowImmutableField("")
    private int[] intArray;

    @DeepImmutableField("")
    private String string;

    @DeepImmutableField("")
    private int i;

    @ShallowImmutableField("")
    private ClassWithPublicFields[] tmc;

    @ShallowImmutableField("")
    private T[] tArray;

    ArrayAndString(String[] stringArray, int[] intArray, String string, ClassWithPublicFields[] tmc, T[] tArray) {
        this.stringArray = stringArray;
        this.intArray = intArray;
        this.string = string;
        this.tmc = tmc;
        this.tArray = tArray;
    }
}

class ClassWithPublicFields {
    public int n = 5;
}