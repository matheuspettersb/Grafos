//Marcos Mattedi e Matheus Petters Bevilaqua
public class ExercicioParcial01 {
	public static void main(String[] args) {

		// matriz de adjacencia
		// teste 1
		int matrizA[][] = {
				{ 0, 1, 1, 0, 0 },
				{ 1, 0, 1, 0, 1 },
				{ 1, 1, 0, 1, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 0 },
				};
		System.out.println("--------- MATRIZ A ---------");
		System.out.println(tipoDoGrafo(matrizA));
		System.out.println("\n"+arestasDoGrafo(matrizA));
		System.out.println("\n"+grausDoVertice(matrizA));
		System.out.println("-----------------------------\n\n\n");
		
		int matrizB[][] = {
				{ 0, 0, 0, 1},
				{ 1, 0, 0, 0},
				{ 0, 1, 0, 0},
				{ 0, 1, 1, 0},
				};
		System.out.println("--------- MATRIZ B ---------");
		System.out.println(tipoDoGrafo(matrizB));
		System.out.println("\n"+arestasDoGrafo(matrizB));
		System.out.println("\n"+grausDoVertice(matrizB));
		System.out.println("-----------------------------\n\n\n");
		
		int matrizC[][] = {
				{ 0, 0, 0,},
				{ 0, 2, 0,},
				{ 0, 0, 0,},
				};
		System.out.println("--------- MATRIZ C ---------");
		System.out.println(tipoDoGrafo(matrizC));
		System.out.println("\n"+arestasDoGrafo(matrizC));
		System.out.println("\n"+grausDoVertice(matrizC));
		System.out.println("-----------------------------\n\n\n");
		
		int matrizD[][] = {
				{ 0, 1, 1, 1},
				{ 1, 0, 1, 1},
				{ 1, 1, 0, 1},
				{ 1, 1, 1, 0},
				};
		System.out.println("--------- MATRIZ D ---------");
		System.out.println(tipoDoGrafo(matrizD));
		System.out.println("\n"+arestasDoGrafo(matrizD));
		System.out.println("\n"+grausDoVertice(matrizD));
		System.out.println("-----------------------------\n\n\n");
		
		int matrizE[][] = {
				{ 0, 1, 0, 0, 0, 0},
				{ 1, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 1, 0, 0},
				{ 0, 0, 1, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 1},
				{ 0, 0, 0, 0, 1, 0},
				};
		System.out.println("--------- MATRIZ E ---------");
		System.out.println(tipoDoGrafo(matrizE));
		System.out.println("\n"+arestasDoGrafo(matrizE));
		System.out.println("\n"+grausDoVertice(matrizE));
		System.out.println("-----------------------------\n\n\n");
		
		
	}

	// a.Qual é o tipo do grafo (dirigido ou não, simples ou multigrafo, regular, completo ou nulo) 
	//nome do método: tipoDoGrafo
	//parâmetro de entrada: matriz deadjacência
	//retorno: String contendo o tipo do grafo
	
	
	// METODOS AUXILIARES:
	private static boolean ehDirigido(int matriz[][]) {
		// testa se é dirigido ou não dirigido
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != matriz[j][i]) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean ehSimples(int matriz[][]) {
		// simples ou multigrafo
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i == j && matriz[i][j] == 1) {
					return false;
				}
				if (matriz[i][j] > 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean ehNulo(int matriz[][]) {
		// testa se é nulo ou não;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean ehCompleto(int matriz[][]) {
		// testa completo
		if (ehSimples(matriz)) {
				int grauA = (matriz.length-1);

				for (int i = 1; i < matriz.length; i++) {
					int grauB = 0;
					for (int j = 0; j < matriz.length; j++) {
						if (matriz[i][j] == 1) {
							grauB++;
						}
					}
					if (grauA != grauB) {
						return false;
					}
				}
				return true;
		}
		return false;
	}
		
	private static boolean ehRegular(int matriz[][]) {
		// testa se é regular
		int grauA = 0;
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				grauA += matriz[i][j];
			}
		}

		for (int i = 1; i < matriz.length; i++) {
			int grauB = 0;
			for (int j = 0; j < matriz.length; j++) {
				grauB += matriz[i][j];
			}
			if (grauA != grauB) {
				return false;
			}
		}
		return true;
	}

	//FIM DOS MÉTODOS AUXILIARES.
	
	private static String tipoDoGrafo(int matriz[][]) {
		String retorno = "O Grafo é:";

		if (ehSimples(matriz)) {
			retorno += "\nSimples, ";
		} else {
			retorno += "\nMultigrafo, ";
		}

		if (ehDirigido(matriz) == true) {
			retorno += "\nDirigido, ";
		} else {
			retorno += "\nNão dirigido, ";
		}

		if (ehNulo(matriz) == true) {
			retorno += "\nNulo, ";
		} else {
			retorno += "\nNão nulo, ";
		}

		if (ehCompleto(matriz) == true) {
			retorno += "\nCompleto e ";
		} else {
			retorno += "\nNão Completo e ";
		}

		if (ehRegular(matriz) == true) {
			retorno += "\nRegular";
		} else {
			retorno += "\nNão Regular";
		}

		return retorno;
	}

	// b.Quantas arestas esse grafo possui? Liste o conjunto de arestas.
	// nome do método: arestasDoGrafo
	// parâmetro de entrada: matriz de adjacência
	// retorno: String com a quantidade e o conjunto de arestas

	private static String arestasDoGrafo(int matriz[][]) {
		String retorno = "O grafico tem ";
		int numArestas = 0;
		String arestas = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] >=1) {
					numArestas+=matriz[i][j];
					arestas += "(v" + (i + 1) + ", v" + (j + 1) + ")";
				}
			}
			arestas = arestas + "\n";
		}
		if (ehDirigido(matriz) || numArestas < 2) {
			retorno += (numArestas) + " arestas.\n E = {" + arestas + "}";
		} else {
			retorno += (numArestas / 2) + " arestas.\n E = {" + arestas + "}";
		}
		return retorno;
	}

	// c.Qual é o grau de cada vértice. Liste a sequência de graus
	// nome do método: grausDoVertice
	// parâmetro de entrada: matriz de adjacência
	// retorno: String identificando o grau de cada vértice e por fim, a sequência de graus

	private static String grausDoVertice(int matriz[][]) {
		String retorno = "Graus dos vertices:";
		int vetor[] = new int[matriz.length];
		int aux;

		for (int i = 0; i < matriz.length; i++) {
			int grau = 0;
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == 1) {
					grau++;
				}
			}
			retorno = retorno + "\n v" + (i + 1) + " = " + grau;
			vetor[i] = grau;
		}
		
		if (!ehDirigido(matriz)) {
			retorno = retorno + "\nSequência de graus: ";

			for (int i = 0; i < vetor.length; i++) {
				for (int j = 0; j < vetor.length; j++) {
					if (vetor[i] < vetor[j]) {
						aux = vetor[i];
						vetor[i] = vetor[j];
						vetor[j] = aux;
					}
				}
			}
			for (int i = 0; i < vetor.length; i++) {
				retorno = retorno + vetor[i] + " ";
			}
		}
		return retorno;
	}

}
