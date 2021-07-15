/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.properties.immutability.types;

/**
 * Annotation to state that the annotated type shallow immutable.
 *
 * @author Tobias Peter Roth
 */
public @interface DependentlyImmutableType {

    /**
     * A short reasoning of this property.
     */
    String value();

}
