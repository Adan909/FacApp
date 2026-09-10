package ni.edu.uam.facapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private Integer id;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private Cargo cargo;
    private boolean activo;
}