/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.properties.immutability.classes;

/**
 * Annotation to state that the annotated class is dependent immutable
 *
 * @author Tobias Roth
 */
public @interface DependentlyImmutableClass {

    /**
     * A short reasoning of this property.
     */
    String value();
    
}
