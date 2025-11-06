package ficheros.explicacionHerencia;

public abstract class ClasePadre {
	 protected int a1,a2;
	 public ClasePadre(int a1, int a2 ) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		
	 }
	 
	 public ClasePadre() {
		 
	 }
	 @Override
	 public String toString() {
		return "ClasePadre [a1=" + a1 + ", a2=" + a2 + "]";
	 }
	 public int getA1() {
		 return a1;
	 }
	 public void setA1(int a1) {
		 this.a1 = a1;
	 }
	 public int getA2() {
		 return a2;
	 }
	 public void setA2(int a2) {
		 this.a2 = a2;
	 }
	
	 public  abstract void m1() ;
		 

	 public abstract void m2() ;
		 
	 
	 

}
