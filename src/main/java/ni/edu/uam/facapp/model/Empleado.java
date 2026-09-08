package ni.edu.uam.facapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    private Integer id;

    private String nombre;

    private String apellido;

    private Cargo cargo;

    private LocalDate fechaContratacion;

    private boolean activo;


}
