package controler;

public class Item {
	private String id;
	private String descripcion;
	public Item(String string, String descripcion) {
		super();
		this.id = string;
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return  descripcion ;
	}
	
}
