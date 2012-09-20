/**
 * 
 */
package juanma;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;

/**
 * @author jmalmeida
 * Clase persistente en base de datos con annotations Entity.
 */
@Entity
@Table(name= "VUELO")
public class Flight {
	
	private long id;
	private String nombre;
	private Date fecha;
	
	//Indicamos que es la clave primaria y que debe ser generada 
	//automáticamente por la base de datos
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}
	@Basic  // atributo de un tipo básico
	@Column(name="NOMBRE")//nombre que deseamos para la columna en la base de datos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/** Una fecha. Debemos indicar si es 
	 * DATE solo fecha, TIME hora o TIMESTAMP fecha y hora */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
