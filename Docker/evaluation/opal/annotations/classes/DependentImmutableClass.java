/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.properties.immutability.classes;

public @interface DependentImmutableClass {

    /**
     * A short reasoning of this property.
     */
    String value();
    
    String[] parameter() default {""};
}
