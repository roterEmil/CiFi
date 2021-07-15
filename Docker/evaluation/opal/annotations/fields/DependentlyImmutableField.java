/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.properties.immutability.fields;

public @interface DependentlyImmutableField {

    /**
     * A short reasoning of this property.
     */
    String value();
    
    String[] parameter() default {""};
}
