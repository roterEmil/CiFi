/* BSD 2-Clause License - see OPAL/LICENSE for details. */
package org.opalj.fpcf.properties.immutability.field_assignability;

public @interface AssignableField {

    /**
     * A short reasoning of this property.
     */
    String value()  default "N/A";
}
