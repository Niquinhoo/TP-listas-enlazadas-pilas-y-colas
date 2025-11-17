public class SolicitudInscripcion {
    private String alumno;
    private String materia;

    public SolicitudInscripcion(String alumno, String materia){
        this.alumno = alumno;
        this.materia = materia;
    }

    @Override
    public String toString(){
        return "Solicitudo de " + alumno + " para inscribirse a " + materia;
    }
}
