import java.lang.Comparable;
/**
 * @author Brandon Hernández 19376
 * @since 26/03/2020
 * @version 26/03/2020
 *
 * Se encarga de modelar a un paciente de un hospital
 * @param <E> tipo de dato que extiede a comparable
 */
public class Patient<E extends Comparable<E>> implements Comparable<Patient<E>> {

    // Atributos de un paciente del hospital
    private E patientName, symptom, category;

    /**
     * Constructor del objeto paciente
     * @pos se crea un nuevo paciente
     * @param name el nombre del paciente
     * @param symptom lo que siente el paciente
     * @param category la categoria en la que cae el paciente
     */
    public Patient(E name, E symptom, E category){
        this.patientName = name;
        this.symptom = symptom;
        this.category = category;
    }

    /**
     * Compara la categoria de los paciente
     * @pre otro paicente !null
     * @pos quien posee una categoria mayor
     * @param that otro paciente
     * @return 1 si es mas grande este pasiente -1 si es mas pequeño y 0 si son iguales
     */
    public int compareTo(Patient<E> that) {
        return this.category.compareTo(that.category);
    }

    /**
     * Se encarga de conseguir la información
     * @pre la informacion del paciente esta desordenada
     * @os la informacion esta en un string y ordenada
     * @return un string con la informacion del paciente
     */
    public String getPatientInfo(){
        return "Nombre : " + this.patientName + "\nSintomas: " + this.symptom + "\nCategoría: " + this.category;
    }

}
