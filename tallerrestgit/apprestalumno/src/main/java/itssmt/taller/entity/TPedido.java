package itssmt.taller.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
@NamedQuery(name="TPedido.findAll", query="SELECT t FROM TPedido t")
public class TPedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int No_pedido;
	
	private int Cliente_Id;
	
    private String Fecha;
	
	private String Estado;

	private float Importe;
	
	
	public int getNo_pedido() {
		return No_pedido;
	}

	public void setNo_pedido(int no_pedido) {
		No_pedido = no_pedido;
	}

	
	public int getCliente_Id() {
		return Cliente_Id;
	}

	public void setCliente_Id(int cliente_Id) {
		Cliente_Id = cliente_Id;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public float getImporte() {
		return Importe;
	}

	public void setImporte(float importe) {
		Importe = importe;
	}


}
