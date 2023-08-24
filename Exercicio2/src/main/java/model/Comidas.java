package model;

public class Comidas {
private int codigo;
private String tipo;
private String definiao;


public Comidas() {
	this.codigo=-1;
	this.tipo="";
	this.definiao="";
	
	
}
public Comidas(int codigo,String tipo,String definiao) {
	this.codigo=codigo;
	this.tipo=tipo;
	this.definiao=definiao;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo=codigo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo=tipo;
}
public String getDefiniao() {
	return definiao;
}
public void setDefiniao(String definiao) {
	this.definiao=definiao;
}

public String toString() {
	return "Comida [codigo= "+codigo+" ,tipo= " +tipo+ ", definição= "+definiao+"]";

}}

