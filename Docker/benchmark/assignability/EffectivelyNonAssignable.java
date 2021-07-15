package org.opalj.fpcf.fixtures.cifi_benchmark.assignability;

import edu.cmu.cs.glacier.qual.Immutable;
import org.opalj.fpcf.fixtures.cifi_benchmark.common.CustomObject;
import org.opalj.fpcf.fixtures.cifi_benchmark.common.ClassWithMutableField;
import org.opalj.fpcf.properties.immutability.field_assignability.EffectivelyNonAssignableField;
import org.opalj.fpcf.properties.immutability.fields.NonTransitivelyImmutableField;
import org.opalj.fpcf.properties.immutability.fields.TransitivelyImmutableField;

import java.util.*;

/**
 * This class encompasses different cases of effectively non assignable fields.
 */
@Immutable
public class EffectivelyNonAssignable {

    @Immutable
    @EffectivelyNonAssignableField("The field is only assigned once")
    private ClassWithMutableField classWithMutableField = new ClassWithMutableField();

    public void setClassWithMutableField(){
        classWithMutableField.nop();
    }

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an effectively non assignable field")
    @EffectivelyNonAssignableField("field is not written after initialization")
    private int simpleInitializedFieldWithPrimitiveType = 5;

    @Immutable
    @TransitivelyImmutableField("immutable reference and deep immutable type")
    @EffectivelyNonAssignableField("effective immutable field")
    private Integer effectiveImmutableIntegerField = 5;

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is effective immutable")
    private double effectiveImmutableDoubleField = 5d;

    @Immutable
    @TransitivelyImmutableField("immutable reference and deep immutable type")
    @EffectivelyNonAssignableField("field is effective immutable")
    private Double effectiveImmutableObjectDoubleField = 5d;

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is not written after initialization")
    private float effectiveImmutableFloatField = 5;

    @Immutable
    @TransitivelyImmutableField("field has an immutable field reference and a deep immutable type")
    @EffectivelyNonAssignableField("the field reference is effective immutable")
    private Float effectiveImmutableFloatObjectField = 5f;

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is effective immutable")
    private Byte effectiveImmutableByteObjectField = 5;

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is effective immutable")
    private byte effectiveImmutableByteField = 5;

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is effective immutable")
    private char simpleChar = 'a';

    @Immutable
    @TransitivelyImmutableField("field value has a primitive type and an immutable field reference")
    @EffectivelyNonAssignableField("field is not written after initialization")
    private long effectiveImmutableLongField = 5;

    @Immutable
    @TransitivelyImmutableField("")
    @EffectivelyNonAssignableField("")
    private Long simpleLong = 5l;

    @Immutable
    @TransitivelyImmutableField("The concrete assigned object is known to be deep immutable")
    @EffectivelyNonAssignableField("The field is effective immutable")
    private String effectiveImmutableString = "abc";

    @Immutable
    @NonTransitivelyImmutableField("The field has a mutable type.")
    @EffectivelyNonAssignableField("effective immutable reference")
    private List<CustomObject> effectiveImmutableLinkedList = new LinkedList<CustomObject>();

    @Immutable
    @TransitivelyImmutableField("The concrete assigned object is known to be deep immutable")
    @EffectivelyNonAssignableField("The field is effective immutable")
    private CustomObject effectiveImmutableObjectReference = new CustomObject();

    @Immutable
    @NonTransitivelyImmutableField("The field has a mutable type.")
    @EffectivelyNonAssignableField("effective immutable reference")
    private Set<CustomObject> effectiveImmutableSet = new HashSet<CustomObject>();

    @Immutable
    @NonTransitivelyImmutableField("")
    @EffectivelyNonAssignableField("effective immutable reference")
    private HashMap<Object, Object> effectiveImmutableHashMap = new HashMap<Object, Object>();

}
