package Repositories.Interfaces;

public interface Repository<T> {
    boolean add(T item);
    boolean remove(T item);
    String toString();
}
