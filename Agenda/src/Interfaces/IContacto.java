
package Interfaces;

import Model.ContactoVo;
import java.util.List;

/**
 *
 * @author PC54
 */
public interface IContacto {
    
    public List<ContactoVo> Consultar();
    public void Guardar(ContactoVo modelo);
    public void Modificar(ContactoVo modelo);
    public void Eliminar(ContactoVo modelo);
    
    
}
