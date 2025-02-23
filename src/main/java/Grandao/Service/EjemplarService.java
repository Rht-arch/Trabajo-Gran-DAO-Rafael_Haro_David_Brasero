package Grandao.Service;

import Grandao.DTO.EjemplarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjemplarService {

    @Autowired
    private EjemplarDAO ejemplarDAO;

    public EjemplarDTO getEjemplar(Long id) {
        // Lógica de validación antes de obtener el ejemplar
        EjemplarDTO ejemplar = ejemplarDAO.findById(id);
        return new EjemplarDTO(ejemplar);
    }

    public EjemplarDTO createEjemplar(EjemplarDTO ejemplarDTO) {
        // Lógica de validación
        EjemplarDTO ejemplar = new EjemplarDTO(ejemplarDTO);
        ejemplar = ejemplarDAO.save(ejemplar);
        return new EjemplarDTO(ejemplar);
    }

    public EjemplarDTO updateEjemplar(Long id, EjemplarDTO ejemplarDTO) {
        // Lógica de validación
        EjemplarDTO ejemplar = ejemplarDAO.update(id, ejemplarDTO);
        return new EjemplarDTO(ejemplar);
    }

    public void deleteEjemplar(Long id) {
        ejemplarDAO.delete(id);
    }
}

