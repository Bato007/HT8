/**
 * @author Brandon Hernández 19376
 * @since 26/03/2020
 * @version 26/03/2020
 * @name Heap.java
 *
 * @param <E> parametro que extiende a comparable
 * Contrato de una priorityQueue
 */
public interface Heap<E extends Comparable<E>> {

    /**
     * Agruega un valor al heap
     * @pre heap tiene n elementos
     * @pos heap tiene (n + 1) elementos
     * @param value elemento que quiere ser agregado al heap
     */
    public void add(E value);

    /**
     * Se consigue el valor que esta hasta arriba del heap
     * @pre heap !isEmpty y posee n valore s
     * @pos heap n - 1
     * @return el valor que se quito del heap
     */
    public E remove();

    /**
     * Revisa si el heap esta vacio
     * @pos muestra si esta vacio el heap
     * @return true si esta vacia y false si no lo esta
     */
    public boolean isEmpty();
}
