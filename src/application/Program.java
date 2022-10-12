package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("=====Calculadora Estatística=====");
			System.out.println("");
			
			System.out.println("(1) - Para calcular a Média");
			System.out.println("(2) - Para calcular a Variância");
			System.out.println("(3) - Para calcular o Desvio Padrão");
			System.out.println("(4) - Para calcular o Coeficiênte de Variação");
			System.out.println("(5) - Para Sair");
			
			System.out.println("");
			System.out.print("Digite a opção de calculo que deseja fazer: ");
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
			        
			        System.out.printf("Variância Amostral = ");
			        System.out.println(String.format("%.2f", varianciaA(vect, n)));
			        System.out.print("Variância Populacional = ");
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
			        
			        System.out.printf("Desvio Padrão Amostral = ");
			        System.out.println(String.format("%.2f", desvioPadraoA(vect, n)));
			        System.out.print("Desvio Padrão Populacional = ");
			        System.out.println(String.format("%.2f", desvioPadraoP(vect, n)));
			        System.out.println("");
			        break;
			        
				case 4:
					System.out.println("");
					System.out.print("Digite o Desvio Padrão: ");
					double DP = sc.nextDouble();
					System.out.print("Digite a Média: ");
					double M = sc.nextDouble();
					
					double coeficienteDeVariacao = (DP / M) * 100;
					
					System.out.print("Coeficiente de Variação = ");
					System.out.println(String.format("%.2f", coeficienteDeVariacao));
					System.out.println("");
					break;
					
				case 5:
					System.out.println("Você escolheu Sair");
					System.out.println("");
					break;
			        
				default:
					System.out.println("Escolha uma opção valida!");
					System.out.println("");
					break;
			}
			
		}while(opcao != 5);
		
		System.out.println("Fim do Programa!");
	    
	    sc.close();
	}
	
	// Calculo da Média.
    static double media(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += vect[i];
        return sum / n;
    }
    
    // Calculo da Variância Amostral.
    static double varianciaA(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += Math.pow((vect[i] - media(vect, n)), 2);
    
        return sum / (n - 1);
    }
    
    // Calculo da Variância Populacional.
    static double varianciaP(double vect[], int n){
    	
        double sum = 0;
        
        for (int i = 0; i < n; i++)
            sum += Math.pow((vect[i] - media(vect, n)), 2);
    
        return sum / n;
    }
    
    // Calculo do Desvio Padrão Amostral.
    static double desvioPadraoA(double vect[], int n){
    
        return Math.sqrt(varianciaA(vect, n));
    }
    
    // Calculo do Desvio Padrão Populacional.
    static double desvioPadraoP(double vect[], int n){
    	
    	return Math.sqrt(varianciaP(vect, n));
    }

}
