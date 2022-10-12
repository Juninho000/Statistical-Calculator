package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("=====Calculadora Estat�stica=====");
			System.out.println("");
			
			System.out.println("(1) - Para calcular a M�dia");
			System.out.println("(2) - Para calcular a Vari�ncia");
			System.out.println("(3) - Para calcular o Desvio Padr�o");
			System.out.println("(4) - Para calcular o Coefici�nte de Varia��o");
			System.out.println("(5) - Para Sair");
			
			System.out.println("");
			System.out.print("Digite a op��o de calculo que deseja fazer: ");
			opcao = sc.nextInt();
			
			switch(opcao) {
			
				case 1:
					System.out.println("");
					System.out.println("Qual o tamanho do seu conjunto de dados?");
			        int x = sc.nextInt();
			        
			        System.out.println("Digite seus valores:");
			        double[] vect = new double[x];
			        for (int i = 0; i < x; i++) {
			            vect[i] = sc.nextDouble();
			        }
			        int n = vect.length;
			        
			        System.out.print("Media = ");
			        System.out.println(media(vect, n));
			        System.out.println("");
			        break;
			        
				case 2:
					System.out.println("");
					System.out.println("Qual o tamanho do seu conjunto de dados?");
			        x = sc.nextInt();
			        
			        System.out.println("Digite seus valores:");
			        vect = new double[x];
			        for (int i = 0; i < x; i++) {
			            vect[i] = sc.nextDouble();
			        }
			        n = vect.length;
			        
			        System.out.printf("Vari�ncia Amostral = ");
			        System.out.println(String.format("%.2f", varianciaA(vect, n)));
			        System.out.print("Vari�ncia Populacional = ");
			        System.out.println(String.format("%.2f", varianciaP(vect, n)));
			        System.out.println("");
			        break;
			        
				case 3:
					System.out.println("");
					System.out.println("Qual o tamanho do seu conjunto de dados?");
			        x = sc.nextInt();
			        
			        System.out.println("Digite seus valores:");
			        vect = new double[x];
			        for (int i = 0; i < x; i++) {
			            vect[i] = sc.nextDouble();
			        }
			        n = vect.length;
			        
			        System.out.printf("Desvio Padr�o Amostral = ");
			        System.out.println(String.format("%.2f", desvioPadraoA(vect, n)));
			        System.out.print("Desvio Padr�o Populacional = ");
			        System.out.println(String.format("%.2f", desvioPadraoP(vect, n)));
			        System.out.println("");
			        break;
			        
				case 4:
					System.out.println("");
					System.out.print("Digite o Desvio Padr�o: ");
					double DP = sc.nextDouble();
					System.out.print("Digite a M�dia: ");
					double M = sc.nextDouble();
					
					double coeficienteDeVariacao = (DP / M) * 100;
					
					System.out.print("Coeficiente de Varia��o = ");
					System.out.println(String.format("%.2f", coeficienteDeVariacao));
					System.out.println("");
					break;
					
				case 5:
					System.out.println("Voc� escolheu Sair");
					System.out.println("");
					break;
			        
				default:
					System.out.println("Escolha uma op��o valida!");
					System.out.println("");
					break;
			}
			
		}while(opcao != 5);
		
		System.out.println("Fim do Programa!");
	    
	    sc.close();
	}
	
	// Calculo da M�dia.
    static double media(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += vect[i];
        return sum / n;
    }
    
    // Calculo da Vari�ncia Amostral.
    static double varianciaA(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += Math.pow((vect[i] - media(vect, n)), 2);
    
        return sum / (n - 1);
    }
    
    // Calculo da Vari�ncia Populacional.
    static double varianciaP(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += Math.pow((vect[i] - media(vect, n)), 2);
    
        return sum / n;
    }
    
    // Calculo do Desvio Padr�o Amostral.
    static double desvioPadraoA(double vect[], int n){
    
        return Math.sqrt(varianciaA(vect, n));
    }
    
    // Calculo do Desvio Padr�o Populacional.
    static double desvioPadraoP(double vect[], int n){
    	
    	return Math.sqrt(varianciaP(vect, n));
    }

}
