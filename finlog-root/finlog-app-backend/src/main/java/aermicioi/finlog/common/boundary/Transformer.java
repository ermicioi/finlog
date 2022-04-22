package aermicioi.finlog.common.boundary;

import com.google.common.collect.ImmutableList;

import java.util.List;

public interface Transformer<I, O> {

    O transform(final I input);

    default List<O> transform(final List<I> inputs) {
        return inputs.stream()
                .map(this::transform)
                .collect(ImmutableList.toImmutableList());
    }

}
