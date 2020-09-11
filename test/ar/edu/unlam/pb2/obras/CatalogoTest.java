package ar.edu.unlam.pb2.obras;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.obras.Autor;
import ar.edu.unlam.pb2.obras.Catalogo;
import ar.edu.unlam.pb2.obras.ObraDeArte;

public class CatalogoTest {
    private Catalogo catalogo;
    
    @Before
    public void init(){
        catalogo = new Catalogo();
    }
    
    @Test
    public void testCrearCatalogoVacio(){
        Assert.assertTrue(0 == catalogo.ontenerCantidadObras());
    }

    @Test
    public void testAgregarObra() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
        Assert.assertTrue(1 == catalogo.ontenerCantidadObras());
    }

    @Test
    public void testExisteObra() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
        Assert.assertTrue(catalogo.existeObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887)));
    }
    
    @Test(expected= Exception.class)
    public void testAgregarObraDuplicada() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
    }
    
    @Test
    public void testObrasOrdenadasPorNombre() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
        catalogo.agregarObra(new ObraDeArte("Autorretrato con sombrero de paja", new Autor("Vincent Van Gogh"),1887));
        catalogo.agregarObra(new ObraDeArte("El dormitorio en Arlés", new Autor("Vincent Van Gogh"),1888));
        
        int i = 0;
        for(Iterator<ObraDeArte> it = catalogo.getListaObras().iterator();
        		it.hasNext();){
            ObraDeArte each = it.next();
            switch (i){
            case 0:
                Assert.assertTrue("Autorretrato con sombrero de paja".equals(each.getNombre()));
                break;
            case 1:
                Assert.assertTrue("El dormitorio en Arlés".equals(each.getNombre()));
                break;
            case 2:
                Assert.assertTrue("Jarrón con acianos y amapolas".equals(each.getNombre()));
                break;
            }
            i++;
        }
    }
    @Test
    public void testCantidadDeObrasPorAnio() throws Exception{
        catalogo.agregarObra(new ObraDeArte("Jarrón con acianos y amapolas", new Autor("Vincent Van Gogh"),1887));
        catalogo.agregarObra(new ObraDeArte("Autorretrato con sombrero de paja", new Autor("Vincent Van Gogh"),1887));
        catalogo.agregarObra(new ObraDeArte("El dormitorio en Arlés", new Autor("Vincent Van Gogh"),1888));
        Assert.assertTrue(2 == catalogo.ontenerCantidadObrasPorAnio(1887));
    }
}
