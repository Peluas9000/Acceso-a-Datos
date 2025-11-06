package ficheros.explicacionHerencia;

public interface ClasePadre1 {
	
	 int m1=0;
	
	public void m1();
	
	public void m2();
	
	public default void m3() {
		System.out.println("Hola m3 por Padre1");
	};
	
}
