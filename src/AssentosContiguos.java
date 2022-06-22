import java.util.Random;

public class AssentosContiguos {

	public static void main(String[] args) {
//		int A = Integer.parseInt(args[0]);
//		int N = Integer.parseInt(args[1]);
//		int M = Integer.parseInt(args[2]);
//		int[][] teatroAssentos = {
//				   {0,1,1,0,0},
//				   {0,1,0,1,0},
//				   {1,1,1,1,1}};
		Random r = new Random();
		//int A = r.nextInt(2,101);
		int A = 5;
		int N = r.nextInt(1,20);
		int M = r.nextInt(1,40);
		System.out.println("Amigos: "+A + " - Fileiras: "+ N +" - Assentos:"+ M);
		int[][] teatroAssentos = new int[N][M];
		
		int filaOrdem = teatroAssentos.length;
		for (int fila = 0; fila < teatroAssentos.length; fila++) {
			if( fila == 0 ) {
				System.out.print("               ");
				for (int col = 1; col <= teatroAssentos[fila].length; col++) {
					System.out.printf("%2d ", col);
				}System.out.println("");
			}
			System.out.print("fileira: ");
			System.out.printf("%2d >>> ", filaOrdem--); 
			for (int assento = 0; assento < teatroAssentos[fila].length; assento++) {
				teatroAssentos[fila][assento] = r.nextInt(2);
				System.out.print(teatroAssentos[fila][assento] + "  ");
			}
			System.out.println("");
		}
		int fileiraContiguos = assentosContiguos(teatroAssentos, A);
		System.out.println("Fileira " + fileiraContiguos + " com "+A+" assentos contiguos.");
		//questoes();
	}


	private static int assentosContiguos(int[][] teatroAssentos, int qtdAssentosContiguos) {
		int contiguos = -1;
		int fileiraOrdem = -1;
		for (int fila = teatroAssentos.length -1; fila >= 0; fila--) {
			fileiraOrdem++;
			int vagas = 0;
			for (int ass = 0; ass < teatroAssentos[fila].length; ass++) {
				if(teatroAssentos[fila][ass]==0) {
					vagas = vagas + 1;
					if(vagas == qtdAssentosContiguos) {
						contiguos = ++fileiraOrdem;
						System.out.println("A partir do assento número " + (ass - qtdAssentosContiguos + 2));
						break;
					}
				}else {
					vagas = 0;
				}
			}
			if(vagas == qtdAssentosContiguos) {
				break;
			}
		}
		return contiguos;
	}


	private static void questoes() {
		int x;
		try {
			x = 9 /2 ;
			if (x== 4)
				throw new RuntimeException("Deveria se 4.5");
		}catch(RuntimeException e) {
			System.out.println(inverteMaius(e.getMessage()));
		}finally {
			System.out.println("Divisao inteira");
		}
		System.out.println("Sera que chega aqui?");
	}

	static String inverteMaius(String txt) {
		String txtInv = new StringBuffer(txt).reverse().toString();
		String txtMaius = txtInv.toUpperCase();
		return txtMaius;
	}

}
