package vlsu.ProducerCentr.serverside.utils.validation;

public interface Validator<T> {
    void validate(T target);
}
