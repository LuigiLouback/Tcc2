package app;
import dao.ComidasDAO;
import model.Comidas;
import dao.DAO;
import java.util.Scanner;


public class Main {
	 public static Scanner sc = new Scanner(System.in);
	 public static void main(String[] args) {
		 ComidasDAO db = new ComidasDAO();
		 Comidas comidas = new Comidas();
		 
		 
		 if (db.conectar()) {
			 boolean status=true;
			 while(status) {
				 int opcao= menu();
				 if(opcao==1) {
					 System.out.println(db.listar());
				 }
				 else if(opcao==2) {
					 System.out.println("Digite as informações dessa comida:");
             
                 	System.out.print("Código: ");
                 	comidas.setCodigo(sc.nextInt());
                 	sc.nextLine();
                 	System.out.print("Tipo de comida: ");
                	comidas.setTipo(sc.nextLine());
                	System.out.print("Definição(doce ou salgado): ");
                 	comidas.setDefiniao(sc.nextLine());
                	
                 	
                 	if(db.insert(comidas) == true) {
                 		System.out.println("\nInsercao feita com sucesso -> " + comidas.toString() + "\n\n");
                 	}
				 }
				 else if(opcao==3) {
					 System.out.print("Digite o código da comida: ");
                     comidas.setCodigo(sc.nextInt());
                     
                     System.out.println("\n\n==== Excluir comida (código " + comidas.getCodigo() + ") ===\n\n");
             		
                     if(db.delete(comidas.getCodigo()) == true) 
             			System.out.println("comida excluida! \n\n");
             		
				 }
				 else if(opcao==4) {
					 System.out.println("Digite as novas informacoes dessa comida:");
                 	
                 	System.out.print("Código: ");
                     comidas.setCodigo(sc.nextInt());
                     sc.nextLine();
                  	System.out.print("Tipo de comida: ");
                 	comidas.setTipo(sc.nextLine());
                 	System.out.print("Definicao(doce ou salgado): ");
                 	comidas.setDefiniao(sc.nextLine());
                     
                     if(db.update(comidas) == true)
                     	System.out.println("comida atualizada! \n\n");
                     
				 }
				 else if (opcao==5){
					 status=db.desconectar();
				 }
				 
				 
				 
			 }
			 
		 }
	 
	 }
	 public static int menu() {
	    	System.out.println("Selecione uma opcao:");
	        System.out.println("1. ver comidas");
	        System.out.println("2. Inserir");
	        System.out.println("3. Excluir");
	        System.out.println("4. Atualizar");
	        System.out.println("5. Sair");
	        System.out.print("Opção: ");
	        int opcao = sc.nextInt();
	        return opcao;
	    }
}
