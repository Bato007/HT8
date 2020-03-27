/**
 * @author Brandon Hernández 19376
 * @since 26/03/2020
 * @version 26/03/2020
 * @name Person.java
 *
 * @param <E> parametro que extiende a comparable
 * Contrato de una persona
 */
public interface Person<E extends Comparable<E>>{

    /**
     * Se encarga de conseguir la información
     * @pre la informacion del paciente esta desordenada
     * @os la informacion esta en un string y ordenada
     * @return un string con la informacion del paciente
     */
    public String getPatientInfo();

}
