package ar.edu.unlam.pb2.obras;

public class ObraDeArte implements Comparable<ObraDeArte>{
	private String nombre;
	private Autor autor;
	private Integer anio;
		
		public ObraDeArte(String nombre,Autor autor,Integer anio) {
			this.nombre = nombre;
			this.autor=autor;
			this.anio=anio;
		}

		public Integer getAnio() {
			return anio;
		}

		public void setAnio(Integer anio) {
			this.anio = anio;
		}

		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ObraDeArte other = (ObraDeArte) obj;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			return true;
		}

		@Override
		public int compareTo(ObraDeArte o1) {
			this.nombre.compareTo(o1.getNombre());
			return this.nombre.compareTo(o1.getNombre());
		}
		
}
