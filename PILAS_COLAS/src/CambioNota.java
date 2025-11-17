public class CambioNota {
    private String alumno;
    private String materia;
    private double notaAnterior;
    private double notaNueva;

    public CambioNota(String alumno, String materia, double notaAnterior, double notaNueva){
        this.alumno = alumno;
        this.materia = materia;
        this.notaAnterior = notaAnterior;
        this.notaNueva = notaNueva;
    }

    @Override
    public String toString(){
        return "Cambio: " + alumno + " En " + materia + " (" + notaAnterior + " -> " + notaNueva + ") ";
    }
}
