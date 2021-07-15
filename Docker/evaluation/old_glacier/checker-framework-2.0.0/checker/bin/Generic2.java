package org.opalj.fpcf.fixtures.benchmark.b_fieldImmutability.dependent;

import edu.cmu.cs.glacier.qual.*;

class FinalEmptyClass {}

class Mutable {
public int n = 8;
}

public final class Generic<T> {
    //@DependentImmutableField("")
    private T t;
    public Generic(T t){
    this.t = t;
	}
    }

@Immutable
class Foo<T> {

    //@DeepImmutableField("")
    //@Immutable
    private Generic<FinalEmptyClass> deepImmutable = new Generic<>(new FinalEmptyClass());

    //@DependentImmutableField("")
    //private Generic<T> g;



    //@ShallowImmutableField("")
    //private Generic<Mutable> mutable = new Generic<>(new Mutable());


    //@DependentImmutableField("")
    //private Generic<Generic<T>> nestedDependent;

    //@ShallowImmutableField("")
    //private Generic<Generic<Mutable>> nestedShallow = new Generic<>(new Generic<>(new Mutable()));

    //@DeepImmutableField("")
    //@Immutable
    private Generic<Generic<FinalEmptyClass>> nestedDeep = new Generic<>(new Generic<>(new FinalEmptyClass()));

    public Foo(T t){
       // this.g = new Generic<>(t);
       // this.nestedDependent = new Generic<>(new Generic<>(t));
    }

}

class LowerUpperBounds<T extends Mutable> {

    //@ShallowImmutableField("")
    private T t;

    public LowerUpperBounds(T t){
        this.t = t;
    }
}

