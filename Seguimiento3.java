import java.util.Scanner;

public class Seguimiento3{
	//Otras constantes para no jugarmela poniendo los valores sin mas.
	private static final double DESCUENTO = 0.15;
	private static final double INCREMENTO = 0.25;
	private static final int AVIANCA = 1;
	private static final int AMERICA_AIRLINES = 2;
	//Constantes para vuelos nacionales
	private static final int NACIONAL = 1;
	private static final double TAN = 15400;
	private static final double DRN = 4.75798;
	private static final double TUPAN = 126800;
	//Constantes para vuelos internacionales
	private static final int INTERNACIONAL = 2;
	private static final double TAI = 35;
	private static final double DRI = 1.00548;
	private static final double TUPAI = 117;
	private static final int DESPEGAR = 1;
	private static final int ATERRIZAR = 2;
	private static final String BOGOTA = "bogota";
	
	public static void main(String[] args){
		
		double cambio_moneda = 0;//Guardara el valor del dolar en dinero colombiano
		boolean fin_Dia = false;
		//Contadores para avianca
		int CVN_salidaAvianca= 0;//Cantidad vuelos nacionales que salieron
		int CVN_llegaronAvianca = 0;//Cantidad vuelos nacionales que llegaron
		int CVI_salidaAvianca = 0;//Cantidad vuelos internacionales que salieron
		int CVI_llegaronAvianca = 0;//Cantidad vuelos internacionales que llegaron
		
		//Contadores para America Airlines
		int CVN_salidaAmerica = 0;//Cantidad vuelos nacionales que salieron
		int CVN_llegaronAmerica = 0;//Cantidad vuelos nacionales que llegaron
		int CVI_salidaAmerica = 0;//Cantidad vuelos internacionales que salieron
		int CVI_llegaronAmerica = 0;//Cantidad vuelos internacionales que llegaron
		
		//Variables para opciones
		int aerolinea = 0;//Guardara la opcion elegida por el operario sobre que aerolinea realiza la accion
		double total_pagarAv = 0.0;//Guardara el total a pagar al final del dia para avianca
		int total_vuelosAv = 0;
		int total_vuelosAm = 0;
		int total_vuelos = 0;
		double porcentaje_vuelosAv = 0.0;
		double porcentaje_vuelosAm = 0.0;
		double total_pagarAm = 0.0; //Guardara el total a pagar al final del dia para america Airlines
		int tipo_vuelo = 0;//Guardara la opcion elegida por el operario (Nacional o Internacional)
		int accion = 0;//Guardara la opcion elegida por el operario (Despegar aterrizar)
		double auxiliar = 0; //para ayudarme a hacer unas operaciones.
		String ciudad = new String();//Guardara la ciudad destino u origen.
		Scanner sc = new Scanner(System.in);
		
		//Pide el precio del dolar para realizar las conversiones requeridas al final del programa.
		System.out.println("Ingrese el precio del dolar en moneda colombiana: ");
		cambio_moneda = sc.nextDouble();
		sc.nextLine();
		
		//Ejecuta el programa siempre y cuando el dia no haya finalizado
		while(!fin_Dia){
			//Le permite al operario elegir entre las dos aerolineas o terminar el dia
			System.out.println("\n\nA que aerolinea pertenece el vuelo?");
			System.out.println("1-Avianca\n2-American Airlines\nCualquier otro numero para terminar dia.");
			aerolinea = sc.nextInt();
			sc.nextLine();
			
			//Si el operador no ha terminado el dia. Entonces ejecuta el programa.
			if( (aerolinea == AVIANCA) || (aerolinea == AMERICA_AIRLINES) ){			
				
				System.out.println("El vuelo es: \n1)Nacional\n2)Internacional.");
				tipo_vuelo = sc.nextInt();
				
				//Evita que el operador se equivoque con el tipo de vuelo
				while( (tipo_vuelo < NACIONAL) || (tipo_vuelo > INTERNACIONAL) ){
					System.out.println("Opcion incorrecta, ingresela nuevamente: ");
					tipo_vuelo = sc.nextInt();
					}//Fin while
					
				sc.nextLine();
				System.out.println("Accion\n1-Despegue.\n2-Aterrizaje.");
				accion = sc.nextInt();
				
				//Evita que el operador ingrese una opcion incorrecta.
				while( (accion < DESPEGAR) || (accion > ATERRIZAR) ){
					System.out.println("Opcion incorrecta, ingresela nuevamente: ");
					accion = sc.nextInt();
					}
				sc.nextLine();
				
				switch(aerolinea){
					
					case AVIANCA:	
						if(tipo_vuelo == NACIONAL){
							if(accion == DESPEGAR){
								System.out.println("Ingrese la ciudad de destino");
								CVN_salidaAvianca++;
							}//Fin if
							else{
								System.out.println("Ingrese la ciudad de origen");
								CVN_llegaronAvianca++;
							}//Fin else
								
							ciudad = sc.nextLine();//Toma la ciudad ingresada en cualquiera de los dos casos.
							ciudad = ciudad.toLowerCase();
							auxiliar = ( TAN + TUPAN ) * DRN;
							
							if( (ciudad.equals(BOGOTA)) && ( accion == ATERRIZAR ) ){
								auxiliar = auxiliar + (auxiliar * INCREMENTO );
								auxiliar = auxiliar - (auxiliar * DESCUENTO);
							}
							else if(ciudad.equals(BOGOTA)){
								auxiliar -= auxiliar * DESCUENTO;
							}	
							total_pagarAv += auxiliar;
							
						}//Fin if Vuelo NACIONAL
						else{//vuelo INTERNACIONAL
						
							if(accion == DESPEGAR){
								CVI_llegaronAvianca++;
								}//Fin if
							else{
								CVI_salidaAvianca++;
								}//Fin else
							total_pagarAv += (TAI  + TUPAI ) * (DRI * cambio_moneda);
						}//Fin else vuelo INTERNACIONAL
						break;
					//Fin de metodo para avianca.
					case AMERICA_AIRLINES:
					
						if(tipo_vuelo == NACIONAL){
							if(accion == DESPEGAR){
								System.out.println("Ingrese la ciudad de destino");
								CVN_salidaAmerica++;
							}//Fin if
							else{
								System.out.println("Ingrese la ciudad de origen");
								CVN_llegaronAmerica++;
							}//Fin else
								
							ciudad = sc.nextLine();//Toma la ciudad ingresada en cualquiera de los dos casos.
							ciudad = ciudad.toLowerCase();
							auxiliar = ( TAN + TUPAN ) * DRN;
							
							if( (ciudad.equals(BOGOTA)) && ( accion == ATERRIZAR ) ){
								auxiliar = auxiliar + (auxiliar * INCREMENTO );
								auxiliar = auxiliar - (auxiliar * DESCUENTO);
							}
							else if(ciudad.equals(BOGOTA)){
								auxiliar -= auxiliar * DESCUENTO;
							}	
							total_pagarAm += auxiliar;
							
						}//Fin if Vuelo NACIONAL
						else{//vuelo INTERNACIONAL
						
							if(accion == DESPEGAR){
								CVI_llegaronAmerica++;
								}//Fin if
							else{
								CVI_salidaAmerica++;
								}//Fin else
							
							total_pagarAm += (TAI  + TUPAI ) * (DRI * cambio_moneda);
						}//Fin else vuelo INTERNACIONAL
					break;
					//Fin para America Airlines
				}
			}//Fin if cuerpo del programa
			else{//Si el operario ha terminado el dia entonces termina el programa.
				fin_Dia = true;
			}//Fin else de terminar dia
		}//Fin while
		
		total_vuelosAv = CVN_llegaronAvianca + CVN_salidaAvianca + CVI_llegaronAvianca + CVI_salidaAvianca;
		total_vuelosAm = CVN_llegaronAmerica + CVN_salidaAmerica + CVI_llegaronAmerica + CVI_salidaAmerica;
		total_vuelos = total_vuelosAm + total_vuelosAv;
		
		if(total_vuelos != 0){//Evitar divisiones entre 0
		porcentaje_vuelosAv = (total_vuelosAv * 100)/total_vuelos;
		porcentaje_vuelosAm = (total_vuelosAm * 100)/total_vuelos;
		}
		
		//Informacion para Avianca
		System.out.println("\n\nInformacion aerolinea Avianca:");
		System.out.printf("El porcentaje de vuelos realizados es de %.2f porciento\n", porcentaje_vuelosAv);
		System.out.printf("Cantidad de vuelos nacionales que salieron %d\n",CVN_salidaAvianca);
		System.out.printf("Cantidad de vuelos nacionales que llegaron %d\n",CVN_llegaronAvianca);
		System.out.printf("Cantidad de vuelos internacionales que salieron %d\n",CVI_salidaAvianca);
		System.out.printf("Cantidad de vuelos internacionales que llegaron %d\n",CVI_llegaronAvianca);
		System.out.printf("Valor total a pagar a la Aerocivil %.3f pesos\n",total_pagarAv);
		//Informacion para America Airlines
		System.out.println("\n\nInformacion aerolinea America Airlines:");
		System.out.printf("El porventaje de vuelos realizados es de %.2f porciento\n",porcentaje_vuelosAm);
		System.out.printf("Cantidad de vuelos nacionales que salieron %d\n",CVN_salidaAmerica );
		System.out.printf("Cantidad de vuelos nacionales que llegaron %d\n",CVN_llegaronAmerica );
		System.out.printf("Cantidad de vuelos internacionales que salieron %d\n",CVI_salidaAmerica );
		System.out.printf("Cantidad de vuelos internacionales que llegaron %d\n",CVI_llegaronAmerica );
		System.out.printf("Valor total a pagar a la Aerocivil %.3f pesos\n",total_pagarAm);
	}//Fin main
}//Fin Seguimiento3