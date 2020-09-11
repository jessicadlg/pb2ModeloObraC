package ar.edu.unlam.pb2.obras;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
private Set<ObraDeArte>listaObras;
	

	public Catalogo() {
		listaObras = new HashSet<>();
	}
	
	public Set<ObraDeArte> getListaObras() {
		return listaObras;
	}

	public void setListaObras(Set<ObraDeArte> listaObras) {
		this.listaObras = listaObras;
	}


	public void agregarObra(ObraDeArte obraDeArte) throws Exception {
		if(!this.listaObras.contains(obraDeArte)){		
			this.listaObras.add(obraDeArte);
	}else{
			throw new Exception();
		}
	}
	
	public boolean existeObra(ObraDeArte obraDeArte) {
		
		for (ObraDeArte o : listaObras) {
			if(o.getNombre().equals(obraDeArte.getNombre())) {
				return true;
			}
		}return false;
	}

	public Integer ontenerCantidadObras() {
		return listaObras.size();
	}

	

	public Integer ontenerCantidadObrasPorAnio(Integer Anio) {
		Integer anio= 0;
		for (ObraDeArte obraDeArte : listaObras) {
			if(obraDeArte.getAnio().equals(Anio)) {
				anio=listaObras.size();
			}
		}
		return  anio;
	}
}
