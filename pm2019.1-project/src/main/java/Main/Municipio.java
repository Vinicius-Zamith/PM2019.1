package Main;

public class Municipio {
	private String nome;
	private String codigo;
	private Object boundingBox;

	public Municipio(String nome, String codigo, Object boundingBox) {
		this.nome = nome;
		this.codigo = codigo;
		this.boundingBox = boundingBox;
	}
	
	
	public Object getBoudingBox() {
		return boundingBox;
	}

	public void setBoudingBox(Object boudingBox) {
		this.boundingBox = boudingBox;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String toString(){
		String municipioString = String.format("Nome: %s \n Código: %s \n", this.nome, this.codigo);
		String boundingBox = this.boundingBox.toString(); 
		return municipioString+boundingBox;
	}
	
}
